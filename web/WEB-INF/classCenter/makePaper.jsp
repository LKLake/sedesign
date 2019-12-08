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
    <script src="${pageContext.request.contextPath}/js/resources.js"></script>

    <script>
        function checkForm(){
            var title=document.getElementById("paper_title").innerText;
            if(title===""){
                return true;
            }
            else {
                return true;
            }
        }
        function enable_me(self){
            self.firstElementChild.removeAttribute("readonly");
            self.firstElementChild.focus();
        }
        function disable_me(self){
            self.setAttribute("readonly","readonly");
        }
        function delete_me(self){
            self.parentElement.parentElement.parentElement.removeChild(self.parentElement.parentElement);
        }
        function set_title(self) {
            var paper_name=self.value;
            if(paper_name!==""){
                document.getElementById("paper_title").innerText=paper_name;
                document.getElementById("paperName").value=paper_name;
            }
        }
        function add_question(){
            var question_type=0;
            if(document.getElementsByName("singleSelect")[0].checked){
                question_type=0;
            }
            else{
                question_type=1;
            }
            var content_cop=document.getElementById("q_content");
            if(content_cop.value===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="题目不能为空";
                return;
            }
            var optipn_a_cop=document.getElementById("optionA");
            if(content_cop.value===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="A选项不能为空";
                return;
            }
            var optipn_b_cop=document.getElementById("optionB");
            if(content_cop.value===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="B选项不能为空";
                return;
            }
            var optipn_c_cop=document.getElementById("optionC");
            if(content_cop.value===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="C选项不能为空";
                return;
            }
            var optipn_d_cop=document.getElementById("optionD");
            if(content_cop.value===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="D选项不能为空";
                return;
            }
            var answer_cop_list=document.getElementsByName("multiSelect");
            var answer="";
            for(var i =0;i<answer_cop_list.length;i++){
                if(answer_cop_list[i].checked){
                    answer+="ABCD"[i];
                }
            }
            if(answer===""){
                document.getElementById("error").setAttribute("class","alert alert-danger");
                document.getElementById("error").innerText="答案不能为空";
                return;
            }
            var table=document.getElementById("main_table");
            var index=0;
            var multi_index=0;
            var number=0;
            for(var i=0;i<table.rows.length;i++){
                if(table.rows[i].cells.length===1){
                    if(table.rows[i].cells[0].innerText==="多选"){
                        multi_index=i;
                    }
                }
            }
            if(question_type===0){
                index=multi_index;
                number=index-1;
            }
            else{
                index=table.rows.length;
                number=index-multi_index;
            }
            var tr=table.insertRow(index);
            tr.innerHTML=get_html();

            tr.cells[0].children[1].innerText=number+'';
            tr.cells[0].children[0].value=question_type;
            tr.cells[1].firstElementChild.value=content_cop.value;
            tr.cells[2].firstElementChild.value=optipn_a_cop.value;
            tr.cells[3].firstElementChild.value=optipn_b_cop.value;
            tr.cells[4].firstElementChild.value=optipn_c_cop.value;
            tr.cells[5].firstElementChild.value=optipn_d_cop.value;
            tr.cells[6].firstElementChild.value=answer;
        }
        function remove_alert(){
            document.getElementById("error").setAttribute("class","");
            document.getElementById("error").innerText="";
        }
        function submit_form(){
            document.getElementById("paper_form").submit();
        }
    </script>
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
    <div class="container-fluid">
        <div >
            <div  class=" col-lg-4 panel panel-default ">
                <div style="text-align: center;vertical-align: middle;margin-top: 5%">
                    <input type="text" style="font-size:3vmin;text-align: center;height: 5vmin;width: 25vmin" placeholder="试卷标题" onblur="set_title(this)">
                </div>

                <table  class="table-condensed table-bordered table-striped text-center" style="margin: 0 auto;height: 50%;margin-top: 5%;width: 100%" >

                    <tr>
                        <td ><label >作业题目：</label></td>
                        <td><textarea onclick="remove_alert()" style="width: 100%;height: 100%"id="q_content"  ></textarea></td>
                    </tr>
                    <tr>
                        <td><label>题目类型：</label></td>
                        <td >
                            <label class="radio-inline">
                                <input onclick="remove_alert()" type="radio" name="singleSelect"  value=0 checked> 单选
                            </label>
                            <label class="radio-inline">
                                <input onclick="remove_alert()" type="radio" name="singleSelect"  value=1> 多选
                            </label>
                        </td>
                    </tr>

                    <tr >
                        <td><label>A</label></td>
                        <td><input onclick="remove_alert()" style="width: 100%;height: 100%" type="text" id="optionA" name="optionA" /></td>
                    </tr>
                    <tr>
                        <td><label>B</label></td>
                        <td><input onclick="remove_alert()"style="width: 100%;height: 100%" type="text" id="optionB" name="optionB" /></td>
                    </tr>
                    <tr>
                        <td><label>C</label></td>
                        <td><input onclick="remove_alert()"style="width: 100%;height: 100%" type="text" id="optionC" name="optionC" /></td>
                    </tr>
                    <tr>
                        <td><label>D</label></td>
                        <td><input onclick="remove_alert()"style="width: 100%;height: 100%" type="text" id="optionD" name="optionD" /></td>
                    </tr>
                    <tr>
                        <td><label>题目答案：</label></td>
                        <td onclick="remove_alert()">
                            <label class="checkbox-inline col-md-pull-2">
                                <input type="checkbox" name="multiSelect"  > A
                            </label>
                            <label class="checkbox-inline col-md-pull-1">
                                <input type="checkbox" name="multiSelect" > B
                            </label>
                            <label class="checkbox-inline">
                                <input type="checkbox" name="multiSelect" > C
                            </label>
                            <label class="checkbox-inline col-md-push-1">
                                <input type="checkbox" name="multiSelect"> D
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" class="btn btn-primary" onclick="add_question()" value="添加"/>
                        </td>
                        <td>
                            <div  id="error"></div>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-8  panel panel-default">
                <div class="panel-heading">
                    <h2 id="paper_title" class="text-center">试卷标题</h2>


                </div>
                <form id="paper_form" action="makePaper?action=saveNewPaper" method="post" onsubmit="return checkForm()">
                    <input id="paperName" name="paperName" type="hidden">
                    <div><input class="btn btn-primary" style="float: right"type="submit">提交</div>
                    <table class="table table-bordered table-hover" id="main_table">
                        <tr>
                            <th>序号</th>
                            <th>题目</th>
                            <th>A</th>
                            <th>B</th>
                            <th>C</th>
                            <th>D</th>
                            <th>答案</th>
                            <th>操作</th>
                        </tr>
                        <tr><td colspan="8"><h4>单选</h4></td></tr>
                        <tr><td colspan="8"><h4>多选</h4></td></tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>

