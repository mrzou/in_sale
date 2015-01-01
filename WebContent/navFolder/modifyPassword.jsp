<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<link rel="stylesheet" type="text/css" href="../css/modifyPassword.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/modifyPassword.js"></script>

<title>个人博客主页</title>
</head>
<body class="signup-otherplace">
<jsp:include page="/jsp/navjsp.jsp"></jsp:include>
<div class="container signup-location">
	<div class="row clearfix">
		<div class="col-md-12 column col-sm-offset-1">
			<div class="sign-process register-progress clearfix hidden-xs hidden-sm">      
				<div class="signup-place">
				<h4 style="border-bottom: 1px solid #C0C0C0"><span class="icon"></span>修改密码</h4>
				<form class="form-horizontal" role="form" id="loginForm" action="/class_project/modifyPassword" method="post">
					<div class="form-group" style="margin-top:50px;">
						<label for="user.password" class="col-sm-5 control-label">旧密码</label>
						<div class="col-sm-3">
							<input type="password" class="form-control signup-form" name="user.password"/>
						</div>
						<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
						<div class="name-tool-tip-info col-sm-4">
							<span class="icon-border"></span>
							<span class="state"></span>
							<span class="alert-name">旧密码不正确</span>
						</div>
					</div>
					<div class="form-group">
						<label for="newUser.password" class="col-sm-5 control-label">新密码</label>
						<div class="col-sm-3">
							<input type="password" class="form-control signup-form" name="new_password" />
						</div>
						<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
						<div class="name-tool-tip-info col-sm-4">
							<span class="icon-border"></span>
							<span class="state"></span>
							<span class="alert-name">密码不能少于6个字符</span>
						</div>
					</div>
					<div class="form-group">
						<label for="password_confirm" class="col-sm-5 control-label">确认新密码</label>
						<div class="col-sm-3">
							<input type="password" class="form-control signup-form" name="password_confirm" />
						</div>
						<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
						<div class="name-tool-tip-info col-sm-4">
							<span class="icon-border"></span>
							<span class="state"></span>
							<span class="alert-name">确认密码不正确</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-5">
							 <button type="submit" class="btn btn-primary btn-lg next-step">修改密码</button>
						</div>
					</div>
				</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>