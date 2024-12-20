<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
  	ex05_04.jsp
  	
  	pageContext 객체
  		ㄴ JSP 기본 내장 객체를 얻어올 수 도 있다.
  			커스텀 태그 사용
  			request = pageContext.getRequest();
  			response = pageContext.getResponse();
  			out = pageContext.getOut();
  			application = pageContext.getServletContext();
  		ㄴ 에러 데이터 구하기
  		ㄴ 페이지 흐름 제어
  		ㄴ 속성 처리
  		   page 영역
  		   pageContext.setAttribute();
  		   pageContext.getAttribute();
  		   
  </xmp>
</div> 
</body>
</html>