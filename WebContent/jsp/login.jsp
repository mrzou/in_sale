<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/login.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/login_validate.js"></script>
<script type="text/javascript" src="../js/lib/layer/layer.min.js"></script>
<title>用户登陆</title>
</head>
<body class="signup-otherplace">
	<div id="error"></div>
	<div class="container signup-location">
	<div class="row clearfix">
		<div class="col-md-12 column col-sm-offset-1">
	        <div class="signup-place">
			<h4><span class="icon"></span>用户登陆<a href="/class_project/jsp/home.jsp"><span class="blogLogo"></span>zz_blog</a></h4>
			<form class="form-horizontal" role="form" id="loginForm" action="/class_project/winLoginUser.action?location=" method="post">
				<div class="form-group">
					<label for="user.email" class="col-sm-3 control-label">邮箱</label>
					<div class="col-sm-5">
						<input type="email" class="form-control signup-form" name="user.email" />
					</div>
					<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
					<div class="name-tool-tip-info col-sm-4">
						<span class="icon-border"></span>
						<span class="state"></span>
						<span class="alert-name">邮箱不能为空</span>
					</div>
				</div>
				<div class="form-group">
					<label for="user.password" class="col-sm-3 control-label">密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control signup-form" name="user.password" />
					</div>
					<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
					<div class="name-tool-tip-info col-sm-4">
						<span class="icon-border"></span>
						<span class="state"></span>
						<span class="alert-name">密码不能为空</span>
					</div>
				</div>
				<div class="form-group">
					<label for="password-confirm" class="col-sm-3 control-label">验证码</label>
					<div class="col-sm-3">
						<input type="text" class="form-control signup-form" name="validateCode"/>
					</div>
					<div class="col-sm-2"><a href=""><img border=0 src="signupValidate" name="checkCodeImage" id="checkCode" /></a></div>
					<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
					<div class="col-sm-1" style="display: none" id="validateCode"></div>
					<div class="name-tool-tip-info col-sm-4">
						<span class="icon-border"></span>
						<span class="state"></span>
						<span class="alert-name">验证不能为空</span>
					</div>
				</div>
				<div class="form-group">
                    <div class="col-sm-offset-3 col-sm-11">
                       <div class="checkbox">
                          <label>
                             <input type="checkbox" name="autoLogin"> 请记住我一天
                          </label>
                       </div>
                    </div>
                </div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-5">
						 <button type="submit" class="btn btn-primary btn-lg next-step">登陆</button>
					</div>
					<div class="col-sm-4 signup-link">还没注册?&nbsp;&nbsp;<a href="/class_project/jsp/signup.jsp">现在去注册</a></div>
				</div>
			</form>
			<div style="display:none" id="requesturl"><%= request.getParameter("location") %></div>
			<%-- <div style="display:none" id="redirect"><%= request.getParameter("redirect") %></div>
			<div style="display:none" id="emailConfirm"><%= request.getParameter("emailConfirm") %></div> --%>
			</div>
		</div>
	</div>
</div>
</body>
<script>
$(document).ready(function(){
	if($("#requesturl").html()!="null"){
		var action = $("form")[0].action;
		$("form")[0].action = action + $("#requesturl").html();
	}
})
</script>
</html>
