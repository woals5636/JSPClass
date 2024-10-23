<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	// ex01_04.jsp?ckbCookie=JSESSIONID&ckbCookie=id&ckbCookie=color
	String [] delCookieNames = request.getParameterValues("ckbCookie");
	// JSP 쿠키 삭제 : 쿠키 생성 + setMaxAge(0) =>
	for(int i = 0; i < delCookieNames.length; i++){
		String cookieName = delCookieNames[i];
		String cookieValue = "";
		Cookie c = new Cookie( cookieName , cookieValue );
		c.setMaxAge(0); // 쿠키 제거
		c.setPath("/");
		response.addCookie(c);
	} // for
	
	/* String location = "/jspPro/days07/ex01_03.jsp";
	response.sendRedirect(location); */
%>

<script>
 	alert("쿠키 삭제 완료!!!");
	location.href = "ex01_03.jsp";
</script>