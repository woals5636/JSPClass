package com.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		urlPatterns = { 
				"/days09/admin/*", 
				"/days09/board/write.jsp"
		})
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("> LoginCheckFilter.init()...");
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("> LoginCheckFilter.doFilter()...");
    	
    	// 인증 == 세션
    	HttpServletRequest jrequest = (HttpServletRequest)request;
    	HttpServletResponse jresponse = (HttpServletResponse)response;
    	
    	String logonId = null; // 세션 auth
    	boolean isLogOn = false;
    	
    	HttpSession session = jrequest.getSession(false);
    	if( session != null ) {
    		logonId = (String) session.getAttribute("auth");
    		if( logonId != null ) isLogOn = true;
    	}
    	
    	if( isLogOn ) {
    		// /admin/*		logonId = "admin"	O
    		// /admin/*		logonId = "hong"	X
    		
    		
    		
    		
    		
    		
    		chain.doFilter(request, response);
    	} else {
    		// 원래 요청 URL 확인
    		String referer = jrequest.getRequestURI();
    		// System.out.println("referer : " + referer);
    		session.setAttribute("referer", referer);
    		
    		// 로그인 페이지로 이동 ( 포워딩, [리다이렉트] )
    		String location = "/jspPro/days09/member/logon.jsp";
    		jresponse.sendRedirect(location);
    	}	// if
    	
    }
    
	public void destroy() {
		System.out.println("> LoginCheckFilter.destroy()...");
	}



}
