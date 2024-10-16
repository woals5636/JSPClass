<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="http://localhost/jspPro/resources/cdn-main/example.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">Jam HOme</a></h1>
  <ul>
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <xmp class="code">
  	// 상대경로			X
  	// http://절대경로 	X               
  	
  	/jspPro/days02/ex01_emp_02.jsp?deptno=10&deptno=20&deptno=30&deptno=40
  	
  	/jspPro	-> context path : Tomcat에서 웹상의 어플리케이션들을 구분하기 위한 Path
  </xmp>
  
  <%
  	String contextPath = request.getContextPath();
  %>
  
  contextPath = <%= contextPath %>;
  <br>
  <img alt="" src="<%= contextPath %>/images/샘플01.png" width="500px">
</div> 
</body>
</html>