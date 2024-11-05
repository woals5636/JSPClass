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
	ex06_update.jsp
  </xmp>
  
    <h2>글수정</h2>
   <form 
      action="update_ok.ss" 
      method="post" enctype="multipart/form-data">
      <table border="1" align="center">
         <tr>
            <td>subject</td>
            <td><input type="text" name="subject" value="${ dto.subject }" /></td>
         </tr>
         <tr>
            <td>attach file</td>
            <td>
              <input type="file" name="attachFile" />
              <input type="text" name="filesystemname" value="${ dto.filesystemname }">
            </td>
         </tr>
         <tr>
            <td colspan="2">
              <input type="submit" />
              <input type="hidden" name="num" value="${dto.num}">
              <a href="list.ss" >Home</a>
            </td>
         </tr>
      </table>
   </form>
</div> 
</body>
</html>