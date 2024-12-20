package days04.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;

import days04.board.domain.BoardDTO;
import days04.board.persistence.BoardDAOImpl;

/*@WebServlet("/cstvsboard/view.htm")*/
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public View() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> View.doGet()...");
		//      참조자
		 // 이전 페이지의 URL
		String referer = request.getHeader("referer");
		// System.out.println("> referer : " + referer); // http://localhost/jspPro/cstvsboard/list.htm
		
		long pseq = Long.parseLong(request.getParameter("seq"));
		
		Connection conn = DBConn.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		BoardDTO dto = null;
		int rowCount = 0;
		
		// 트랜잭션 처리 필요 부분
		try {
			rowCount = dao.increaseReaded(pseq);

			dto = dao.view(pseq);

			System.out.println("> 게시글 쓰기 : 로그 기록 작업...");

		} catch (SQLException e) {
			System.out.println("> View.doGet() Exception...");
			e.printStackTrace();
		}
		DBConn.close();
		
		// view.jsp 포워딩
		request.setAttribute("dto", dto);
		
		String path = "/days04/board/view.jsp";
		RequestDispatcher dispatcher =  request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> View.doPost()...");
	}

}
