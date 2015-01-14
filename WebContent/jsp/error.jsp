<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script src="../js/lib/layer/layer.min.js" type="text/javascript"></script>
<title>出错了!</title>
</head>
<body>
<div style="display: none" id="message">
	<%= request.getParameter("message") %>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var message = $("#message").html().replace(/\s/g,   '');
	if(message=="withoutPermit"){
		layer.alert("该用户没有权限!")
	}else{
		layer.alert("邮箱验证错误!")
	}
});
</script>
</html>