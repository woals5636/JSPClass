<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// int num = request.getParameter("num")==null?0:Integer.parseInt(request.getParameter("num"));
	String pNum = request.getParameter("num");
	int num = 0;
	if( pNum != null && !pNum.equals("") ){
		num = Integer.parseInt(request.getParameter("num"));
	}
%>
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
                            
  </xmp>
  
  <%-- 정수 : <input type="text" id="num" value="<%if(num==0){}%><%else {%><%= num%><%}%>"><br> --%>
  정수 : <input type="text" id="num"><br>
  
  <p id="demo">
  		<%
	  	if( pNum != null && !pNum.equals("") ){
			int sum = 0;
			for(int i = 1; i <= num ; i++){
				sum+=i;
   		%>
		<%= i %>
		+
		<% }  %>
		=
		<%= sum %>
		<% } %>
  </p>
  
</div> 
<script>
$("#num").select();
$("#num")
.css("text-align","center")
<%-- .val('<%= pNum %>') --%>
.val('${param.num}')
.on({
	"keydown":function(e){
		 if ( !(
				 (event.keyCode >= 48 && event.keyCode <= 57) || // 숫자키 (상단)
				 (event.keyCode >= 96 && event.keyCode <= 105) || // 숫자키패드
				 event.keyCode === 8 ||  // Backspace
				 event.keyCode === 9 ||  // Tab
				 event.keyCode === 13 || // Enter
				 event.keyCode === 37 || // 왼쪽 화살표
				 event.keyCode === 39 || // 오른쪽 화살표
				 event.keyCode === 46    // Delete
				 
				/*  // event.key로 사용하는 방법
			    (event.key >= '0' && event.key <= '9') ||  // 숫자 키 (상단과 숫자 패드 동일)
			    event.key === "Backspace" || 
			    event.key === "Tab" ||
			    event.key === "Enter" ||
			    event.key === "ArrowLeft" ||
			    event.key === "ArrowRight" ||
			    event.key === "Delete" */
	          )){
			    
			 alert("숫자만 입력하세요.");
			 e.preventDefault();
		 }
	},
     "keyup":function (e){
         if( $(this).val().length != 0 && event.which == 13){
        	 // js BOM
        	 let numValue = $("#num").val();
        	 location.href=`ex03_05.jsp?num=\${numValue}`;
         } // if
       }
    });
</script>
</body>
</html>