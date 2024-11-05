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
	ex07_04.jsp
	지도 위에 마우스를 클릭하면 마커 표시
	( 마커를 클릭하면 정보창을 표시 )
  </xmp>
  
  <div id="googleMap" style="width: 100%; height: 400px"></div>
  
  <script>
  	function getRndNumber(min, max) {
  		return (Math.random() * (max - min) ) + min;
  	}
  	
  	function myMap() {
  		var lat = 37.499338;
  		var lng = 127.033187;
  		
  		var mapCanvas = document.getElementById("googleMap");
  		var mapCenter = new google.maps.LatLng(lat, lng);
  		
  		var mapOptions = {
  			center: mapCenter, // 지도 중앙 배치
  			zoom: 5	// 지도의 확대/축소 수준
  		};
  		var map = new google.maps.Map(mapCanvas, mapOptions);
  		
		markerPosition = new google.maps.LatLng(lat, lng);
		let marker = new google.maps.Marker({
			position: markerPosition
		});
		marker.setMap(map);
 		
  		let message = "<a href='http://www.sist.co.kr'><img alt='lezhin.com 로고' src='//img-s-msn-com.akamaized.net/tenant/amp/entityid/BBFwET1.img'></a>";
		let infoWindow = new google.maps.InfoWindow({
			content: message
		});
		
		// 지도를 클릭할 때 정보창 표시(open)
		google.maps.event.addListener(
			marker
			, "click"
			, function(){
				map.setZoom(15);
				map.setCenter( marker.getPosition() );
				infoWindow.open( map, marker );
				// 3초 후에 정보창을 자동을 ㅗ닫기
				window.setTimeout(function (){
					infoWindow.close();
				}, 3000);
			}
		);
  	}

  </script>
  
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC5qGXAOFrxUVGO0-7Xhe9nfHm45ZcgoYw&callback=myMap"></script>
  
  
</div> 
</body>
</html>