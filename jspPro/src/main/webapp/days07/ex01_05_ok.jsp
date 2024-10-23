<%@page import="java.util.Enumeration"%>
<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	Enumeration<String> en = request.getParameterNames();

	while(en.hasMoreElements()){
		String cookieName = en.nextElement();
		String cookieValue = request.getParameter(cookieName);
		
		Cookie c = new Cookie( cookieName , URLEncoder.encode(cookieValue, "utf-8") );
		c.setMaxAge(-1); // 음수		브라우저 닫으면 자동으로 쿠키 제거
		c.setPath("/");
		
		response.addCookie(c);
	}
	String location = "ex01_03.jsp";
	response.sendRedirect(location);
%>
