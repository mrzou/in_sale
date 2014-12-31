<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>

<title>个人博客主页</title>
</head>
<body>
	<jsp:include page="/jsp/navjsp.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-offset-4 col-sm-4" style="margin-top:10px;">
				<a href="/class_project/navFolder/addBlog.jsp">添加博客</a>
			</div>
		</div>
	</div>
</body>
<script>
$(document).ready(function(){
	$("a").eq(0).removeClass("active");
	$("a").eq(1).addClass("active");
});
</script>
</html>