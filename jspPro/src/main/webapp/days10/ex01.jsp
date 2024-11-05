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
	  [파일업로드]
	      1. [업로드]    :   클 -> 서
	         다운로드  :   서 -> 클
	      2. 쇼핑사이트 : 상품 정보 등록
	         자료실 : 첨부파일 등록
	         회원가입 : 회원이미지 등록
	         등등  
	                 
	      3. (꼭 기억) 실제 파일 업로드 할 때 
	        1) 스트림 기반의 전송 방식인 form method="post" 설정.
	        2) 인코딩 설정
	           기본 :   enctype="application/x-www-form-urlencoded"  
	                    enctype="multipart/form-data"   철자
  </xmp>
  <a href="ex01_02.jsp?lat=37.499294&lng=127.0331883">(주)쌍용교육센터</a>
  <br>
  <div id="googleMap" style="width: 100%;height:400px"></div>
  
</div>

<script>
  function myMap() {
     var mapOptions = {
           center:new google.maps.LatLng(51.508742, -0.120850)
             , zoom: 5
     };
     var map = new google.maps.Map( 
           document.getElementById("googleMap") 
           , mapOptions);
  }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC5qGXAOFrxUVGO0-7Xhe9nfHm45ZcgoYw&callback=myMap"></script>

<!-- Maps JavaScript API 검색
구글 지도 API 키 발급 받는 방법 (Maps JavaScript API)
https://blog.cosmosfarm.com/archives/389/%EA%B5%AC%EA%B8%80-%EC%A7%80%EB%8F%84-api-%ED%82%A4-%EB%B0%9C%EA%B8%89-%EB%B0%9B%EB%8A%94-%EB%B0%A9%EB%B2%95-maps-javascript-api/
 -->
</div> 
</body>
</html>