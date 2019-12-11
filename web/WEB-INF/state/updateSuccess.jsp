<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/main_area.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

</head>
<body style="background: url('${pageContext.request.contextPath}/image/background.png')">
<div id="main_area">
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/menu.jsp"/>
    <div style="padding-top: 30px;padding-bottom: 30px;">
        <p align="center" style="font-size: 30px;">密码修改成功！</p>
    </div>
</div>

</body>
