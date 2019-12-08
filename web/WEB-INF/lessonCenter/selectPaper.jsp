<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
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
</div>

</body>
