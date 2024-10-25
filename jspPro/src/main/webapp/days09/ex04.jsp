<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet"	href="http://localhost/jspPro/resources/cdn-main/example.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
span.material-symbols-outlined {
	vertical-align: text-bottom;
}
</style>
<style>
body {
	font-size: 12px;
	font-family: Arial;
}
</style>
</head>
<body>
	<header>
		<h1 class="main">
			<a href="#" style="pos ition: absolute; top: 30px;">Jam HOme</a>
		</h1>
		<ul>
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</header>
	<div>
		<xmp class="code">
		ex04.jsp
		예제)
		https://api.jquery.com/load/#load-url-data-complete
		https://api.jquery.com/resources/load.html
		</xmp>
	</div>
	<b>Projects:</b>
	<ol id="new-projects"></ol>

	<script>
	$( "#new-projects" ).load( "ex04_load.html #projects li" );
	</script>
</body>
</html>