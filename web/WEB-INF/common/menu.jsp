<%@ page import="model.StudentModel" %>
<%@ page import="model.TeacherModel" %>
<%@ page import="model.UserModel" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <script type="text/javascript">

        function logout(){
            if(confirm('您确定要退出系统吗？')){
                window.location.href="userCenter?action=logout";
            }
        }
        <%=request.getParameter("currentUser")%>
    </script>
</head>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="${pageContext.request.contextPath}/home">首页</a>
        <ul class="nav">
            <c:choose>
                <c:when test="${ sessionScope.currentUserIdentity==\"teacher\"}">
                    <li><a href="${pageContext.request.contextPath}/classInfo?action=listStudentInfo">学生信息管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/classInfo?action=getStudentScore">学生成绩查询</a></li>
                    <li><a href="${pageContext.request.contextPath}/makeNewPaper">制作试卷</a></li>
                    <li><a href="${pageContext.request.contextPath}/changePassword">修改密码</a></li>
                    <%--    			<li><a href="${pageContext.request.contextPath}/question!list">题库管理</a></li>--%>
                    <%-- <li><a href="${pageContext.request.contextPath}/appointment!appointmentList">预约查询</a></li> --%>
                    <li><a href="javascript:logout()">退出系统</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/doExam?action=getAvailablePaper">在线作业</a></li>
                    <li><a href="${pageContext.request.contextPath}/lessonInfo?action=queryScore">成绩查询</a></li>
                    <%-- <li><a href="${pageContext.request.contextPath}/appointment!preAppointment">我要预约</a></li> --%>
                    <li><a href="${pageContext.request.contextPath}/changePassword">修改密码</a></li>
                    <li><a href="javascript:logout()">退出系统</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
</body>
