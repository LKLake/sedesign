<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/color.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script>
    function on_change_paper(){

        window.location.reload();

        var selected_item=document.getElementById("paperName");
        var selected_name=selected_item.options[selected_item.selectedIndex].innerText;
        var student_id=document.getElementById("studentId").value;
        var student_name=document.getElementById("studentName").value;
        var table=document.getElementById("main_table");
        color(table,["rowPaperName","rowStudentId","rowStudentName"],[selected_name,student_id,student_name],"red","origin")
    }
</script>
<div class="data_list">
	<div class="data_info">
		<p>学生成绩列表</p>
	</div>

	<div class="search_content">
			<table align="center">
				<tr>
                    <td><label><strong>请选择作业测试卷：</strong></label></td>
                    <td>
                        <select id="paperName" name="paperName">
                            <option value="">请选择...</option>
                            <c:forEach var="paper" items="${paperList}">
                                <option value="${paper.id}" >${paper.paperName}</option>
                            </c:forEach>
                        </select>
                    </td>
					<td><label>学号：</label></td>
					<td><input type="text" id="studentId" name="s_exam.student.id" /></td>
					<td>&nbsp;</td>
					<td><label>姓名：</label></td>
					<td><input type="text" id="studentName" name="s_exam.student.name"/></td>
					<td>&nbsp;</td>
					<td><button class="btn btn-primary" style="margin-bottom: 8px;" type="submit" onclick="on_change_paper()">查询</button></td>
				</tr>
			</table>
	</div>
	<div class="data_content">
		<table class="table table-bordered table-hover" id="main_table">
			 <tr>
				<th>序号</th>
				<th id="rowStudentId">学号</th>
				<th id="rowStudentName">学生姓名</th>
				<th id="rowPaperName">试题名称</th>
				<th>做题日期</th>
				<th>单选题得分</th>
				<th>多选题得分</th>
				<th>总分</th>
			</tr>
			<c:forEach var="student" items="${studentList}" varStatus="status" >
                <c:forEach var="lessonInfo" items="${student.lessonInfoList}" varStatus="status" >
                    <tr>
                        <td>${status.index+1 }</td>
                        <td>${student.userId }</td>
                        <td>${student.name }</td>
                        <td>${lessonInfo.paper.paperName }</td>
                        <td><fmt:formatDate value="${lessonInfo.addedTime }" type="date" pattern="yyyy-MM-dd"/></td>
                        <td>${lessonInfo.singleScore }</td>
                        <td>${lessonInfo.multiScore }</td>
                        <td><font color="red">${lessonInfo.score }</font></td>
                    </tr>
                </c:forEach>
			</c:forEach>
	  </table>
	</div>
	<div class="pagination pagination-centered">
	 	 <ul>
	    	${pageCode }
	 	 </ul>
	</div>
</div>