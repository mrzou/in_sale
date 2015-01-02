<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/signup.css">
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<title>注册信息</title>
</head>
<body class="signup-otherplace">
    <jsp:include page="navjsp.jsp"></jsp:include>
	<div id="error"></div>
	<div class="container signup-location">
	<div class="row clearfix">
		<div class="col-md-12 column col-sm-offset-1">
			<div class="sign-process register-progress clearfix hidden-xs hidden-sm" id="head-step">
				<div class="sign-up-pross sign-up-ok"><span class="index">1</span>填写注册信息
		            <div class="signup-pross-dir">
			            <span class="outside"></span>
			            <span class="inside"></span>
			        </div>
			    </div>
	          	<div class="sign-up-pross sign-up-ok"><span class="index">2</span>邮箱激活
		          	<div class="signup-pross-dir">
		          		<span class="outside"></span>
		          		<span class="inside"></span>
		          	</div>
	          	</div>
	          	<div class="sign-up-pross" id="success"><span class="index">3</span>注册成功</div>
	        </div>
	        <div class="signup-place">
				<h4 style="border-bottom: 1px solid #C0C0C0"><span class="icon"></span>邮箱验证</h4>
				<div class="col-sm-4"><span class="validateEmailIcon"></span></div>
				<div class="col-sm-8 col-sm-offset-6"><span class="alert-message">请在24小时内点击邮件中的链接继续完成注册</span></div>
				<div class="col-sm-8 col-sm-offset-6">
					<span class="another-message">邮件已经发到邮箱</span><a href="#" id="email">${email}</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
var interval = null;
$(document).ready(function(){
	interval = setInterval(checkIfConfirm,4000)
	if(!$("div#success").hasClass("sign-up-ok")){
		layer.alert("注册成功，请到邮箱验证!","")
	}
})
function checkIfConfirm(){
	var ifConfirm = $.ajax({
		url: "/class_project/ifConfirm",
		async: false,
	})
	console.log(ifConfirm.responseText)
	if(ifConfirm.responseText=="yes"){
		$("#success").addClass("sign-up-ok");
		$("div.signup-place").remove();
		$("#head-step").append("<h1 style='margin:200px 100px; font-size: 100px'>邮箱验证成功</h1>")
		window.clearInterval(interval);
	}
}
</script>
<style>
.another-message {
	display: inline-block;
	width: 384px;
	height: 30px;
	margin-top: -32px;
	margin-left: -63px;
	font-size: 15px;
}
.alert-message {
	display: inline-block;
	width: 384px;
	height: 30px;
	margin-top: -89px;
	margin-left: -76px;
	font-size: 19px;
}
.validateEmailIcon {
	background: url("../images/anydo.png") no-repeat;
	width: 130px;
	height: 130px;
	display: inline-block;
	margin-left: 200px;
	margin-top: 100px;
}
a#email {
	margin-left: -254px;
}
</style>
</html>
