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
	days04
		ㄴ ex04.jsp
		ㄴ board
	[ 기본 게시판 ]
	JDBC - 게시판
	
	url 요청 -> 로직처리   서블릿 -> 뷰(View) jsp 페이지
			   자바 코딩
			   포워딩/리다이렉트
	
	[패키지]
	days04.board : List.java 서블릿
	days04.board.domain : BoardDTO.java , PagingDTO.java
	days04.board.persistence : BoardDAO.java , BoardDAOImpl.java
	
	// controller, service x
			   
	요청 URL : /jspPro/cstvsboard/list.htm
	       -> days04.board.List.java 서블릿 호출(GET)
	       -> days04/board/list.jsp
  </xmp>
  
  <a href="/jspPro/cstvsboard/list.htm">게시판 목록 보기</a>
</div> 
</body>
</html>