<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
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
    <div class="data_list">
        <div class="data_info">
            <p>${sessionScope.currentUser.name }&nbsp;的成绩列表</p>
        </div>
        <div class="data_content">
            <table class="table table-bordered table-hover">
                <tr>
                    <th>序号</th>
                    <th>试题名称</th>
                    <th>做题日期</th>
                    <th>单选题得分</th>
                    <th>多选题得分</th>
                    <th>总分</th>
                </tr>
                <c:forEach var="lessonInfo" items="${lessonInfoList}" varStatus="status" >
                    <tr>
                        <td>${status.index+1 }</td>
                        <td>${lessonInfo.paper.paperName }</td>
                        <td><fmt:formatDate value="${lessonInfo.addedTime }" type="date" pattern="yyyy-MM-dd"/></td>
                        <td>${lessonInfo.singleScore }</td>
                        <td>${lessonInfo.multiScore }</td>
                        <td><font color="red">${lessonInfo.singleScore+lessonInfo.multiScore }</font></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
