<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/signup.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/signup_validate.js"></script>
<title>注册信息</title>
</head>
<body class="signup-otherplace">
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="/class_project">Home</a>
          <a class="blog-nav-item" href="#">New features</a>
          <a class="blog-nav-item" href="#">Press</a>
          <a class="blog-nav-item" href="#">New hires</a>
          <a class="blog-nav-item" href="#">About</a>
        </nav>
      </div>
    </div>
	<div id="error"></div>
	<div class="container signup-location">
	<div class="row clearfix">
		<div class="col-md-12 column col-sm-offset-1">
			<div class="sign-process register-progress clearfix hidden-xs hidden-sm">
				<div class="sign-up-pross sign-up-ok"><span class="index">1</span>填写注册信息
		            <div class="signup-pross-dir">
			            <span class="outside"></span>
			            <span class="inside"></span>
			        </div>
			    </div>
	          	<div class="sign-up-pross"><span class="index">2</span>邮箱激活
		          	<div class="signup-pross-dir">
		          		<span class="outside"></span>
		          		<span class="inside"></span>
		          	</div>
	          	</div>
	          	<div class="sign-up-pross"><span class="index">3</span>注册成功</div>
	        </div>
	        <div class="signup-place">
			<h4 style="border-bottom: 1px solid #C0C0C0"><span class="icon"></span>注册帐号</h4>
			<form class="form-horizontal" role="form" action="/class_project/signupUser" method="post">
				<div class="form-group">
					<label for="user.name" class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control signup-form" name="user.name"/>
					</div>
					<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
					<div class="name-tool-tip-info col-sm-4">
						<span class="icon-border"></span>
						<span class="state"></span>
						<span class="alert-name">用户名不能为空</span>
					</div>
				</div>
				<div class="form-group">
					<label for="user.email" class="col-sm-4 control-label">邮箱</label>
					<div class="col-sm-4">
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
					<label for="user.password" class="col-sm-4 control-label">密码</label>
					<div class="col-sm-4">
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
					<label for="password-confirm" class="col-sm-4 control-label">确认密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control signup-form" name="password_confirm"/>
					</div>
					<div class="col-sm-1" style="display: none"><span class="input-right"></span></div>
					<div class="name-tool-tip-info col-sm-4">
						<span class="icon-border"></span>
						<span class="state"></span>
						<span class="alert-name">确认密码不能为空</span>
					</div>
				</div>
				<div class="form-group">
					<label for="password-confirm" class="col-sm-4 control-label">验证码</label>
					<div class="col-sm-2">
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
					<div class="col-sm-offset-4 col-sm-5">
						 <button type="submit" class="btn btn-primary btn-lg next-step">下一步</button>
					</div>
					<div class="col-sm-3 signup-link">已注册?&nbsp;&nbsp;<a href="/class_project/jsp/login.jsp">现在去登陆</a></div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
