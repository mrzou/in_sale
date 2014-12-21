<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/logup.css">
<script type="text/javascript" src="js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/validate_login.js"></script>
<title>注册信息</title>
</head>
<body>
	<div>
	<form action="signupUser" method="post" name="logupForm" >
		<fieldset>
			<legend align="center"><span>注册</span></legend>
			<table>
			<tr>
				<td>*用户名:</td>
				<td><input type="text" name="user.name" class="validate" /></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="nameSpan">名字已经存在</span></td>
			</tr>
			<tr>
				<td>*邮箱:</td>
				<td><input type="text" name="user.email" class="validate" /></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="email">邮箱格式不正确</span></td>
			</tr>
			<tr>
				<td>*密码:</td>
				<td><input type="password" name="user.password" class="validate" placeholder="大于6位字符"/></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="password">密码不能为空</span></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="password_confirm" class="validate"/></td>
				<td><div class="inputWrong"></div></td>
				<td class="alert"><span class="validate" id="pass_confirm"></span></td>
			</tr>
			<tr>
				<td>*验证码:</td>
				<td><input type="text" name="check_code" class="validate" placeholder="输入验证码"/></td>
				<td class="alert"><a href=""><img border=0 src="signupValidate" name="checkCodeImage" id="checkCode" /></a>
				<td><div class="inputWrong"></div></td>
				<td><span class="validate" id="Validatespan">验证码不正确</span></td>
				<td id="validateCode" style="display:none"></td>
			</tr>
			<tr><td colspan="2">
				<input type="submit" value="注册"/>&nbsp;&nbsp; 
				<input type="reset" value="重置"></td>
			</tr>
			</table>
        </fieldset>
	</form>
    </div>
    
</body>
</html>
