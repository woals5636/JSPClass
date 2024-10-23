<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/inc/session_auth.jspf" %>
<%-- <%
	// 인증 + 권한(X)
	// [세션을 사용한 인증 처리] 세션이름 auth로 로그인ID 저장 (약속)
	
	String sname = "auth";
	String logonId = null;
	logonId = (String) session.getAttribute(sname);
%> --%>
<%
	// 1. 세션을 자동으로 종료
	// 2. 세션을 강제로 종료하는 메서드 invalidate
	session.invalidate();
%>

<script>
	alert("<%= logonId %>님이 로그아웃하셨습니다.");
	location.href = "ex05_default.jsp";
</script>