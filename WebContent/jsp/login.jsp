<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/login_validate.js"></script>
<title>用户登陆</title>
</head>
<body>
	<div id="error"></div>
	<div>
	<form action="/class_project/loginUser" method="post" name="logupForm" >
		<fieldset>
			<legend align="center"><span>登陆</span></legend>
			<table>
			<tr>
				<td>*邮箱:</td>
				<td><input type="text" name="user.email" class="validate" /></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="email">请输入邮箱</span></td>
			</tr>
			<tr>
				<td>*登陆密码:</td>
				<td><input type="password" name="user.password" class="validate"/></td>
				<td><div class="inputWrong" id="s"></div></td>
				<td class="alert"><span class="validate" id="password">请输入登陆密码</span></td>
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
				<input type="submit" value="登陆"/>&nbsp;&nbsp; 
				<input type="reset" value="重置"></td>
			</tr>
			</table>
        </fieldset>
	</form>
    </div>
    
</body>
</html>
