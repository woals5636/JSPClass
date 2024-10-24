package days07.mvc.command;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConnectionProvider;
import com.util.DBConn;

import days04.board.domain.BoardDTO;
import days04.board.persistence.BoardDAOImpl;

public class ViewHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String referer = request.getHeader("referer");
		// System.out.println("> referer : " + referer); // http://localhost/jspPro/cstvsboard/list.htm
		
		long pseq = Long.parseLong(request.getParameter("seq"));
		
		Connection conn = ConnectionProvider.getConnection();
		BoardDAOImpl dao = new BoardDAOImpl(conn);
		BoardDTO dto = null;
		int rowCount = 0;
		
		// 트랜잭션 처리 필요 부분
		try {
			rowCount = dao.increaseReaded(pseq);

			dto = dao.view(pseq);

			System.out.println("> 게시글 쓰기 : 로그 기록 작업...");

		} catch (SQLException e) {
			System.out.println("> ViewHandler.doGet() Exception...");
			e.printStackTrace();
		}
		conn.close();
		
		// view.jsp 포워딩
		request.setAttribute("dto", dto);
		
		return "/days07/board/view.jsp";
	}

}
