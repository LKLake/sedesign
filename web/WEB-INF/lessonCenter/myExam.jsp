<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
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