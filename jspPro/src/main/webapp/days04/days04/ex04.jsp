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
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">lsh</a></h1>
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
     	
     [ 기본 게시판 ] 을 만든다.
     
     Controller				Model							View
     url 요청 -> 로직 처리 - 서블릿을 거치고 -> 뷰(view) jsp 페이지로 이동한다.
     				자바 코딩
     				포워딩/리다이렉트
     				
     create sequence seq_tblcstVSBoard
			nocache;
			-- Sequence SEQ_TBLCSTVSBOARD이(가) 생성되었습니다.
			-- oracle 수정 - 테이블 생성
			create table tbl_cstVSBoard (
			  seq number not null primary key,
			  writer varchar2(20) not null,
			  pwd varchar2(20) not null,
			  email varchar2(100),
			  title varchar2(200) not null,
			  writedate date default sysdate,
			  readed number default 0,
			  tag number(1) not null, -- mode 예약어 x
			  content clob
			);
			-- Table TBL_CSTVSBOARD이(가) 생성되었습니다.
     
     [패키지]
     days04.board : List.java 서블릿
     days04.board.domain : BoardDTO.java, PagingDTO.java
     days04.board.persistence : BoardDAO.java, BoardDAOImpl.java
     
     controller, service 는 안만든다.
     				
     요청 URL : /jspPro/cstvsboard/list.htm
     			-> days04.board.List.java 서블릿 호출(GET 방식)
     			-> days04/board/list.jsp 응답하도록 한다.
  </xmp>
  
  <%
  	String contextPath = request.getContextPath();
  %>
  
  <a href="<%= contextPath %>/cstvsboard/list.htm">게시판 목록보기</a>
  
</div>
</body>
</html>