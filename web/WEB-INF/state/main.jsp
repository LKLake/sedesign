<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>互动式教学系统主界面</title>
<link href="${pageContext.request.contextPath}/style/exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        #main_area{
            width: 1000px;
            height: 100vmin;
            margin: 0 auto;
            background: rgb(250,250,250);
            box-shadow: 5px 5px 5px rgba(0,0,0,.5), -5px 5px 5px rgba(255,255,255,.5);
        }
    </style>
</head>

<body style="background: url('${pageContext.request.contextPath}/image/background.png')">
<div id="main_area">
    <table align="center" style="height:100vmin;">
        <tr style="height: 5vmin">
            <td>
                <jsp:include page="../common/head.jsp"/>
            </td>
        </tr>
        <tr style="height: 5vmin">
            <td>
                <jsp:include page="../common/menu.jsp"/>
            </td>
        </tr>
        <tr>
            <td>
                <jsp:include page="../common/foot.jsp"/>
            </td>
        </tr>
    </table>
</div>

</body>
</html>