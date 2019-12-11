<%--
  Created by IntelliJ IDEA.
  User: lklake
  Date: 2019/12/3
  Time: 上午11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/style/main_area.css" rel="stylesheet">
</head>
<body style="background: url('${pageContext.request.contextPath}/image/background.png')">
<div id="main_area">
    <jsp:include page="../common/head.jsp"/>
    <jsp:include page="../common/menu.jsp"/>
    ${state}
</div>


</body>
</html>
