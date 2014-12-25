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
	<!-- <div>
	<form action="signupUser" method="post" name="logupForm" >
		<fieldset>
			<legend align="center"><span>注册</span></legend>
			<table>
			<tr>
				<td>*用户名:</td>
				<td><input type="text" name="user.name" class="validate" /></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="nameSpan">名字要大于五个字符</span></td>
			</tr>
			<tr>
				<td>*邮箱:</td>
				<td><input type="text" name="user.email" class="validate" /></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="email">邮箱不能为空</span></td>
			</tr>
			<tr>
				<td>*登陆密码:</td>
				<td><input type="password" name="user.password" class="validate" placeholder="大于6位字符"/></td>
				<td><div class="inputWrong" id="s"></div></td>
				<td class="alert"><span class="validate" id="password">密码不能为空</span></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="password_confirm" class="validate"/></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="pass_confirm">确认密码不能为空</span></td>
			</tr>
			<tr>
				<td>*验证码:</td>
				<td><input type="text" name="check_code" class="validate" placeholder="输入验证码"/></td>
				<td class="alert"><a href=""><img border=0 src="signupValidate" name="checkCodeImage" id="checkCode" /></a>
				<td><div class="inputWrong"></div></td>
				<td><span class="validate" id="Validatespan">验证码不能为空</span></td>
				<td id="validateCode" style="display:none"></td>
			</tr>
			<tr><td colspan="2">
				<input type="submit" value="注册"/>&nbsp;&nbsp; 
				<input type="reset" value="重置"></td>
			</tr>
			</table>
        </fieldset>
	</form>
    </div> -->
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
			<h4><span class="icon"></span>注册帐号</h4>
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="user.name" class="col-sm-5 control-label">用户名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="user.name" id="user.name" />
					</div>
				</div>
				<div class="form-group">
					<label for="user.email" class="col-sm-5 control-label">邮箱</label>
					<div class="col-sm-4">
						<input type="email" class="form-control" name="user.email" id="user.email" />
					</div>
				</div>
				<div class="form-group">
					<label for="user.password" class="col-sm-5 control-label">密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="user.password" id="user.password" />
					</div>
				</div>
				<div class="form-group">
					<label for="password-confirm" class="col-sm-5 control-label">确认密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="password-confirm" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-7 form-group">
						<label for="password-confirm" class="col-sm-9 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="password-confirm" />
						</div>
					</div>
					<div class="col-md-5">
						<a href=""><img border=0 src="signupValidate" name="checkCodeImage" id="checkCode" /></a>
					</div>
				</div>
				<div class="form-group">
			      <div class="col-sm-offset-4 col-sm-11">
			         <div class="checkbox">
			            <label>
			               <input type="checkbox"> 请记住我
			            </label>
			         </div>
			      </div>
   			    </div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-10">
						 <button type="button" class="btn btn-primary btn-lg next-step">下一步</button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
