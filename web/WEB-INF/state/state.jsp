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
    ${state}
</div>


</body>
</html>
