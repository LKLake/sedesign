<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/request.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/color.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/no_empty.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script type="text/javascript">
    var changed_tr=[];
	function studentDelete(studentId){
		if(confirm("确定要删除这条记录吗?")){
			$.post("student!deleteStudent",{id:studentId},
				function(result){
					var result = eval('('+result+')');
					if(result.error){
						alert(result.error);
					}else{
						alert("删除成功！");
						window.location.href="${pageContext.request.contextPath}/student!list";
					}
				}
			);
		}
	}
	function try_to_change(target){
        var tr=target.parentElement.parentElement;
        var table=tr.parentElement;
        var form={};
        for (var i=0;i<tr.cells.length;i++){
            if(tr.cells[i].className==="row"){
                form[table.rows[0].cells[i].id]=tr.cells[i].innerText;
            }
        }
        function func(content){
            if(content==="modefied_success"){
                alert("修改成功");
            }
            else{
                alert("修改失败");
                location.reload();
            }
        }
        request(form,"${pageContext.request.contextPath}/classInfo?action=changeStudentInfo",func);
    }
    function search(){
	    var nameElem=document.getElementById("student_name");
	    var userIdEelem=document.getElementById("student_id");
	    var ret=no_empty([nameElem,userIdEelem]);
	    if(ret!="success"){
	        alert(ret);
	        return;
        }
        var table=document.getElementById("main_table");
	    color(table,["userId","name"],[userIdEelem.value,nameElem.value]);
    }
    function try_to_delete(target){
        var tr=target.parentElement.parentElement;
        var table=tr.parentElement;
        var form={};
        for (var i=0;i<tr.cells.length;i++){
            if(tr.cells[i].className==="row"){
                form[table.rows[0].cells[i].id]=tr.cells[i].innerText;
            }
        }
        function func(content){
            if(content==="delete_success"){
                alert("删除成功");
                location.reload();
            }
            else{
                alert("删除失败");
                location.reload();
            }
        }
        request(form,"${pageContext.request.contextPath}/classInfo?action=deleteStudentInfo",func);
    }
</script>
<div class="data_list">
	<div class="data_info">
		<p>学生信息管理</p>
	</div>
	<div class="search_content">
        <table align="center">
            <tr>
                <td><label>学号：</label></td>
                <td><input type="text" id="student_id" /></td>
                <td>&nbsp;</td>
                <td><label>姓名：</label></td>
                <td><input type="text" id="student_name" /></td>
                <td>&nbsp;</td>
                <td><button class="btn btn-primary" style="margin-bottom: 8px;" onclick="search()" >查询</button></td>
            </tr>
        </table>
		<button class="btn-mini btn-primary" style="float: right;margin-bottom: 5px;" type="button" onclick="javascript:window.location='student!preSave'">添加考生信息</button>
	</div>
	<div class="data_content">
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
	</div>
	<div class="pagination pagination-centered">
	 	 <ul>
	    	${pageCode }
	 	 </ul>
	</div>
    <script>

        var rows=document.getElementsByClassName("row");
            for (i=0;i<rows.length;i++){
                rows[i].addEventListener("dblclick",function (){
                    var txt=document.createElement("input");
                    txt.type="text";
                    txt.value=this.innerText;
                    this.innerText="";
                    this.appendChild(txt);
                    txt.select();
                    txt.focus();
                    txt.onblur=function (ev) {
                        var target=ev.target;
                        var parent=target.parentElement
                        parent.innerText=target.value;
                        changed_tr.push(parent.parentElement);
                    }
                });
    }
    </script>
</div>