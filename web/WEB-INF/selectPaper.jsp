<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm(){
		var paperId=$("#paperId").val();
		if(paperId==null||paperId==""){
			alert("请选择作业测试卷！");
			return false;
		}
		return true;
	}
</script>
<div class="data_list">
	<div class="data_content">
		<form action="doExam?action=getPaperContent" method="post" onsubmit="return checkForm()">
			<table width="40%" align="center">
				<tr>
					<td><label><strong>请选择作业测试卷：</strong></label></td>
					<td>
						<select id="paperId" name="paperId">
							<option value="">请选择...</option>
							<c:forEach var="availablePaper" items="${availablePaperList}">
								<option value="${availablePaper.key}" >${availablePaper.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="btn  btn-primary" value="确定"/>
					</td> 
					<td>
						<input type="button" class="btn  btn-primary" value="返回" onclick="javascript:history.back() "/>
					</td>
				</tr>
			</table>
		</form> 
	</div>
</div>