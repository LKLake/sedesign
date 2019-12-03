<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>制作试卷</title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div style="height: 100vmin" class=" col-lg-5 panel panel-default ">
                <h3 class="panel-title text-center">出题</h3>
            <form action="question!saveQuestion" method="post" onsubmit="return checkForm()">
                <table  class="table-condensed text-center" >
                    <tr>
                        <td ><label>作业题目：</label></td>
                        <td><textarea  id="content" name="content" ></textarea></td>
                    </tr>
                    <tr>
                        <td><label>题目类型：</label></td>
                        <td >
                            <label class="radio-inline">
                                <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="single" checked> 单选
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="multi"> 多选
                            </label>
                        </td>
                    </tr>

                    <tr >
                        <td><label>A：</label></td>
                        <td><input type="text" id="optionA" name="optionA" /></td>
                    </tr>
                    <tr>
                        <td><label>B：</label></td>
                        <td><input type="text" id="optionB" name="optionB" /></td>
                    </tr>
                    <tr>
                        <td><label>C：</label></td>
                        <td><input type="text" id="optionC" name="optionC" /></td>
                    </tr>
                    <tr>
                        <td><label>D：</label></td>
                        <td><input type="text" id="optionD" name="optionD" /></td>
                    </tr>
                    <tr>
                        <td><label>题目答案：</label></td>
                        <td><input type="text" id="answer" name="answer" placeholder='(多选题答案用逗号隔开，如"A,D")' />&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" class="btn btn-primary" value="添加"/>
                        </td>
                        <td>
                            &nbsp;&nbsp;<font id="error" color="red">${error }</font>
                        </td>
                    </tr>
                </table>
            </form>
        </div>




        <div class="col-lg-6 col-lg-push-1 panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">试卷预览</h3>
            </div>
            <form>
                <table class="table table-bordered table-hover" id="main_table">
                    <tr>
                        <th>序号</th>
                        <th id="userId">学号</th>
                        <th id="name">姓名</th>
                        <th id="sex">性别</th>
                        <th id="classNo">班号</th>
                        <th id="password">密码</th>
                        <th id="major">专业</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="student" items="${studentList}" varStatus="status" >
                        <tr>
                            <td class="absrow">${status.index+1 }</td>
                            <td class="row">${student.userId }</td>
                            <td class="row">${student.name }</td>
                            <td class="row">${student.sex }</td>
                            <td class="row">${student.classNo}</td>
                            <td class="row">${student.password }</td>
                            <td class="row">${student.major }</td>
                            <td><button class="btn-mini btn-info" type="button" onclick="try_to_change(this)">修改</button>&nbsp;&nbsp;
                                <button class="btn-mini btn-danger" type="button" onclick="try_to_delete(this)">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>
</div>





</body>
</html>

