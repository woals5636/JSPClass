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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="http://localhost/jspPro/resources/cdn-main/example.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
span.material-symbols-outlined {
    vertical-align: text-bottom;
}
</style>
</head>
<body>
<header>
    <h1 class="main">
        <a href="#" style="position: absolute; top: 30px;">Jam Home</a>
    </h1>
    <ul>
        <li><a href="#">로그인</a></li>
        <li><a href="#">회원가입</a></li>
    </ul>
</header>
<div>
    <h2>내용 보기</h2>
    <table>
        <tbody>
            <tr>
                <td>이름</td>
                <td>${ dto.writer }</td>
                <td>등록일</td>
                <td>${ dto.writedate }</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${ dto.email }</td>
                <td>조회수</td>
                <td>${ dto.readed }</td>
            </tr>
            <tr>
                <td>제목</td>
                <td colspan="3">${ dto.title }</td>
            </tr>
            <tr>
                <td colspan="4" class="full" style="height: 200px; vertical-align: top">${ dto.content }</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4" align="center"></td>
                <a href="<%=contextPath%>/cstvsboard/edit.htm?seq=${dto.seq}"> 수정하기 </a>
                <a href="<%=contextPath%>/cstvsboard/delete.htm?seq=${dto.seq}"> 삭제하기 </a>
                <a href="<%=contextPath%>/cstvsboard/list.htm?seq=${dto.seq}"> Home </a>
                <input type="button" id="btnModalDelete" value="모달창 삭제">
            </tr>
        </tfoot>
    </table>

    <div id="dialog-form" title="삭제관련모달창">
        <h2>삭제하기</h2>
        <form action="<%=contextPath%>/cstvsboard/delete.htm?seq=${dto.seq}" method="post">
            <table>
                <tr>
                    <td colspan="2" align="center"><b>글을 삭제합니다.</b></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pwd" size="15" autofocus="autofocus"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="삭제"> &nbsp;&nbsp;
                        <input type="button" value="취소" id="cancel">
                    </td>
                </tr>
            </table>
            <span style="color: red; display: none" id="spn">비밀번호가 잘못되었습니다.</span>
        </form>
    </div>

    <script>
        let dialog, form;
        dialog = $("#dialog-form").dialog({
            autoOpen: false,
            height: 400,
            width: 350,
            modal: true,
            buttons: {},
            close: function() {
                form[0].reset();
            }
        });

        form = dialog.find("form");

        $("#btnModalDelete").button().on("click", function() {
            dialog.dialog("open");
        });

        $("#cancel").button().on("click", function() {
            dialog.dialog("close");
        });
    </script>
    <script>
     if( ${param.delete eq 'fail' } ){
    	 dialog.dialog("open");
    	 $("#spn").show().slideToggle(3000);
     }
    </script>
</div>
</body>
</html>
