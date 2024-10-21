<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
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
     empsearch_jstl
  </xmp>
  
  <form action="<%= contextPath %>/days04/empsearch.htm">
  	<fieldset>
  		<legend>부서 선택</legend>
  		<c:forEach items="${dlist}" var="vo">
  			<input type="checkbox" id="deptno-${vo.deptno}" name="deptno" value="${vo.deptno}">
  			<label for="deptno-${vo.deptno}">${vo.dname}</label>
  		</c:forEach>
  	</fieldset>
  	
  	<fieldset>
  		<legend>잡 선택</legend>
  		<c:forEach items="${jlist}" var="job">
  			<input type="checkbox" id="job-${job}" name="job" value="${job}">
  			<label for="job-${job}">${job}</label>
  		</c:forEach>
  	</fieldset>
  	
  	<input type="submit" value="search">
  	<input type="button" value="emp delete">
  </form>
  
  <!-- ex01_emp_jstl.jsp 복 붙 -->
  <h2>emp search list</h2>
  <table>
  	<thead>
  		<th>empno</th>
  		<th>ename</th>
  		<th>job</th>
  		<th>mgr</th>
  		<th>hiredate</th>
  		<th>sal</th>
  		<th>comm</th>
  		<th>deptno</th>
  	</thead>
  	<tbody>
  	
  	<c:if test="${ empty elist }">
  		<tr>
  			<td colspan="8">사원이 존재하지 않습니다.</td>
  		</tr>
  	</c:if>
  	
  	<!-- ! == not : EL 부정 연산자 -->
  	<c:if test="${ not empty elist }">
  	
  	<c:forEach items="${ elist }" var="vo">
  	<tr>
  		<!-- vo.empno == getEmpno() -->
  		<!-- 그래서 EmpVO 에서 @Getter 이 없으면 안된다. -->
  		<td>${ vo.empno }</td>
  		<td>${ vo.ename }</td>
  		<td>${ vo.job }</td>
  		<td>${ vo.mgr }</td>
  		<td>${ vo.hiredate }</td>
  		<td>${ vo.sal }</td>
  		<td>${ vo.comm }</td>
  		<td>${ vo.deptno }</td>
  	</tr>
  	</c:forEach>
  	
  	</c:if>
  	
  	
  	</tbody>
  	<tfoot>
  		<tr>
  			<td colspan="8">
  				<span class="badge left red">
  				<!-- java.lang.NumberFormatException: For input string: "size" -->
  				<%-- ${ list.size } x --%>
  				<!-- 삼항연산자 사용 가능하다. -->
  				${ empty elist ? 0 : elist.size() }
  				</span>명
  				<a href="javascript:history.back()">뒤로 가기</a>
  				<button>선택한 empno 확인</button>
  			</td>
  		</tr>
  	</tfoot>
  </table>
  
  <script>
  	// 부서, 잡 체크박스 유지되도록하기
  	let url = location.href;
  	// alert(url);
  	$(":checkbox[name=deptno]").each(function(index,element){
  		let v = $(element).val();
  		if( url.indexOf( `deptno=\${v}` ) != -1 ){
  			$(element).prop("checked",true);
  		}
  	});
  	
  	$(":checkbox[name=job]").each(function(index,element){
  		let v = $(element).val();
  		if( url.indexOf( `job=\${v}` ) != -1 ){
  			$(element).prop("checked",true);
  		}
  	});
  </script>
  
</div>
</body>
</html>