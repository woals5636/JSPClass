package days07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import days06.MemberInfo;

@WebServlet("/days07/session.htm")
public class ServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> ServletSession.doGet()....");
		/*
		   1) HttpSession session request.getSession();
		      == HttpSession session request.getSession(true);
		      세션이 존재하면 존재하는 세션 객체를 반환하고
		      존재하지 않으면 세션 객체를 새로 생성해서 반환
		   2) HttpSession session request.getSession(boolean);
		   	  세션이 존재하면 존재하는 세션 객체를 반환하고
		      존재하지 않으면 null 반환
		      
		   주의)
		   	HttpSession session =  request.getSession();
		   	if(session == null){
		   		//
		   		//................
		   	}
		*/
		
		// 인증받은 사용자 정보를 세션에 저장
		MemberInfo mi = new MemberInfo();
		mi.setId("admin");
		mi.setName("홍길동");
		mi.setEmail("admin@naver.com");
		mi.setPasswd("1234");
		
		HttpSession session = request.getSession();
		session.setAttribute("auth", mi);
		
		MemberInfo auth_mi = (MemberInfo) session.getAttribute("auth");
		if (auth_mi != null) {
			//
			//
		}
		
		session.removeAttribute("auth");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
