<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	String location = "ex10_finish.jsp?name=" + name + "&age=" + age;
	response.sendRedirect(location);
%>