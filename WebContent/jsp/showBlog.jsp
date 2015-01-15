<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="class_project.zou.javabean.Blog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/indexBlog.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<title>博客</title>
</head>
<body>
<jsp:include page="/jsp/navjsp.jsp"></jsp:include>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-11 column col-sm-offset-1">
			<div class="sign-process register-progress clearfix hidden-xs hidden-sm">      
				<div class="signup-place">
				<h4 style="border-bottom: 1px solid #C0C0C0"><span class="icon"></span>用户博客</h4>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var articleId = window.location.href.split("?")[1].split("=")[1]
	var allCategory = $.ajax({
		url: "/class_project/showBlog?id="+articleId,
		async: false,
		success: function(data){
			$("#blogForm").remove();
			JSON.parse(data).content.split("\\n").forEach(function(pdata){
				$("div.signup-place").append("<div><p class='article'>" + pdata + "</p></div>");
				/* $(".signup-place").css("height",$(document).height()); */
			})
			$("div.signup-place").append("<button type='button' class='btn btn-primary btn-xs addBlog'>添加评论</button>");
		},
		error: function(msg){
			$("#error").html(msg.responseText);
		}
	});
});
</script>
</html>