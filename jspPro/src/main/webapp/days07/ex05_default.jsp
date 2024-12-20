<%@page import="com.util.Cookies"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/inc/session_auth.jspf" %>
<%-- <%
	// 인증 + 권한(X)
	// [세션을 사용한 인증 처리] 세션이름 auth로 로그인ID 저장 (약속)
	
	String sname = "auth";
	String logonId = null;
	logonId = (String) session.getAttribute(sname);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon"
	href="http://localhost/jspPro/images/SiSt.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet"
	href="http://localhost/jspPro/resources/cdn-main/example.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
span.material-symbols-outlined {
	vertical-align: text-bottom;
}
</style>
</head>
<body>
	<header>
		<h1 class="main">
			<a href="#" style="position: absolute; top: 30px;">Jam HOme</a>
		</h1>
		<ul>
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</header>
	<div>
		<xmp class="code"> ex05_default.jsp </xmp>

<%
     if( logonId == null ){
  %>
  <div id="logon">
    <form action="ex05_logon.jsp">
       아이디 : <input type="text" name="id" value="admin" /><br>
       비밀번호 : <input type="password" name="passwd" value="1234" /><br>
       <input type="submit" value="로그인" />
       <input type="button" value="회원가입" />
       <span style="color:red; display:none">로그인 실패했습니다.</span> 
   </form>
  </div>
  <%
     }else{
  %>
  <div id="logout">
    [ <%= logonId %> ]님 환영합니다<br>
    <a href="ex05_logout.jsp">로그아웃</a>
  </div> 
  <%      
     }
  %>
     
  <!-- 로그인 X -->
  <a href="/jspPro/cstvsboard/list.htm">게시판</a><br>
  
  <%
     if( logonId != null ){
  %>
  <!-- 로그인 O -->
  <a href="#">자료실</a><br>
  <a href="#">일정관리</a><br>   
  <%
        if( logonId.equals("admin")){
  %>
  <!-- 로그인 O + admin 관리자로 로그인 -->
  <a href="#">급여관리</a><br>
  <a href="#">인사관리</a><br> 
  <%         
        } // if
     } // if
  %>

	</div>
	
	<script>
		if( ${ param.logon eq "fail"} ){
   		  $("#logon span")
   		 	    .fadeIn()
     		   .fadeOut(3000);
 		 }           
	</script>
	
</body>
</html>