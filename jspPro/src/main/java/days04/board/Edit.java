package days04.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

import days04.board.domain.BoardDTO;
import days04.board.persistence.BoardDAO;
import days04.board.persistence.BoardDAOImpl;

/*@WebServlet("/cstvsboard/edit.htm")*/
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Edit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> Edit doGet()...");
		String referer = request.getHeader("referer");
		
		long pseq = Long.parseLong(request.getParameter("seq"));
		
		Connection conn = DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		BoardDTO dto = null;
		int rowCount = 0;
		
		// 트랜잭션 처리 필요 부분
		try {
			dto = dao.view(pseq);

			System.out.println("> 게시글 수정 : 로그 기록 작업...");

		} catch (SQLException e) {
			System.out.println("> Edit.doGet() Exception...");
			e.printStackTrace();
		}
		DBConn.close();
		
		// view.jsp 포워딩
		request.setAttribute("dto", dto);
		
		String path = "/days04/board/edit.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

	// http://localhost/jspPro/cstvsboard/edit.htm?seq=1
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("> Edit doPost()...");
		
		long pseq = Long.parseLong(request.getParameter("seq"));

		// String writer = request.getParameter("writer"); 작성자 수정 안하므로 필요 없음
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int tag = Integer.parseInt( request.getParameter("tag") );

		Connection conn = DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		int rowCount = 0;
		BoardDTO dto = BoardDTO.builder()
							   .seq(pseq)
							   .pwd(pwd)
							   .email(email)
							   .title(title)
							   .content(content)
							   .tag(tag)
							   .build();
		try {
			rowCount = dao.update(dto);
		} catch (SQLException e) { 
			System.out.println("> Edit.doPost() Exception...");
			e.printStackTrace();
		}

		DBConn.close();

		// 포워딩, [ 리다이렉트 ]
		String location = "/jspPro/cstvsboard/view.htm?seq="+pseq;
		location += rowCount == 1 ? "&edit=success":"&edit=fail";
		response.sendRedirect(location);
		
	}

}
