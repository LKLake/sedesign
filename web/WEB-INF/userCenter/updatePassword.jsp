<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function checkForm(){
            var oldPassword=$("#oldPassword").val();
            var newPassword1=$("#newPassword1").val();
            var newPassword2=$("#newPassword2").val();
            if(oldPassword==null||oldPassword===""){
                alert("请输入原密码！");
                return false;
            }
            /*alert(oldPassword);
            alert("${sessionScope.currentUser.password}");
		if(oldPassword!=="${sessionScope.currentUser.password}"){
			alert("原密码错误，请重新输入");
			return false;
		}*/
            if(newPassword1==null||newPassword1===""){
                alert("请输入新密码！");
                return false;
            }
            if(newPassword2==null||newPassword2===""){
                alert("请输入确认新密码！");
                return false;
            }
            if(newPassword1!==newPassword2){
                alert("确认新密码填写错误，请重新输入！");
                return false;
            }
            return true;
        }
        function update_success() {
            alert("修改密码成功");
            window.history.back();
        }
        function update_failed() {
            alert("修改失败");
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
        <div class="data_info">
            <p>修改个人密码</p>
        </div>
        <div class="data_content">
            <form action="?action=changePassword" method="post" onsubmit="return checkForm()">
                <table width="40%" align="center">
                    <tr>
                        <td><label>用户名：</label></td>
                        <td>
                            <input type="text" value="${sessionScope.currentUser.userId}" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>原密码：</label></td>
                        <td>
                            <input type="password" name="rawPassword" id="oldPassword" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>新密码：</label></td>
                        <td>
                            <input type="password" id="newPassword1"  name="newPassword"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>确认新密码：</label></td>
                        <td>
                            <input type="password" id="newPassword2"  />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn  btn-primary" value="修改密码"/>
                        </td>

                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
