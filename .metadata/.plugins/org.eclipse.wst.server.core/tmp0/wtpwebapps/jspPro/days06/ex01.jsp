<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	[JSP 기본 객체와 영억]
  	
  	1. 하나의 웹페이지에서 사용할 수 있는 4가지 영역(Scope)
  		: PAGE 영역			- pageContext
  		: REQUEST 영역		- request
  		: SESSION 영역		- session
  		: APPLICATION 영역	- application
  		
  	2. 메서드
  		setAttribute()
  		getAttribute()
  		removeAttribute()
  		getAttributeNames()
  		
  	  예) ex01_02.jsp
  	  예) ex01_03.jsp
  	
  </xmp>
</div> 
</body>
</html>