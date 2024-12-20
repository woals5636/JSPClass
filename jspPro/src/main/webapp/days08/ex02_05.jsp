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
  	ex02_05.jsp
  	
  	[c:forEach 문]
  	 begin 속성
  	 end 속성
  	 step 속성
  	 var 속성
  	 items 속성
  	 varStatus 속성
  </xmp>
  <%-- 
  <c:forEach begin="5" end="13" step="2" var="i" varStatus="vstatus">
  	${ i } / ${ vstatus.index }
  		   / ${ vstatus.count }
  	       / ${ vstatus.first }
  	       / ${ vstatus.last }<br>
  </c:forEach>
   --%>
   
   <!-- 문제 : 1+2+3.....+10=55 -->
   <c:set  value="0" var="sum"></c:set>
   <c:forEach begin="1" end="10" step="1" var="i" varStatus="vstatus">
    <%-- ${i} +  --%>
    ${ i += (vstatus.last?"":"+") }
    <c:set  value="${ sum + i }" var="sum"></c:set>
   </c:forEach>
   = ${ sum }
</div> 
</body>
</html>