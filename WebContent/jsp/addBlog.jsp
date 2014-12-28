<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/editBlog.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap-markdown.min.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap-markdown.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div class="blog-masthead">
    <div class="container">
      <nav class="blog-nav">
        <a class="blog-nav-item active" href="/class_project">首页</a>
        <a class="blog-nav-item" href="#">New features</a>
        <a class="blog-nav-item" href="#">Press</a>
        <a class="blog-nav-item" href="#">New hires</a>
        <a class="blog-nav-item" href="#">About</a>
        <a class="blog-nav-item right-click" href="/class_project/jsp/login.jsp">登陆</a>
        <a class="blog-nav-item right-click" href="/class_project/jsp/signup.jsp">注册</a>
      </nav>
    </div>
  </div>
  <div class="container">
	<div class="row clearfix">
		<div style="width:100px; height: 100px"><p id="blog"></p> </div>
		<div class="col-md-12 column" style="margin-left: 150px">
			<form method="post" action="/class_project/addBlog">
				<div class="row"  style="margin-top:20px">
					<div class="col-sm-10"><span>文章标题</span></div>
				    <div class="col-sm-3">
				    	<input name="title" class="form-control" type="text" placeholder="Title?" />
				    </div>
				</div>
				<div class="row"  style="margin-top:25px">
					<div class="col-sm-10"><span>文章的内容</span></div>
					<div class="col-sm-8">
					    <textarea name="content" data-provide="markdown" rows="25"></textarea>
					    <label class="checkbox" style="margin-left: 20px">
					      <input name="publish" type="checkbox"> Publish
					    </label>
					    <hr/>
					    <button type="submit" class="btn" id="button">Submit</button>
				    </div>
				</div>
			</form>
		</div>
	</div>
  </div>
</body>
<style>
textarea {
	background-color: #ffffff;
}
</style>
</html>