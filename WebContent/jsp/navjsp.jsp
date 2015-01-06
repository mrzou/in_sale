<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
</head>
<body>
	<div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="/class_project">首页</a>
          <a class="blog-nav-item" href="/class_project/navFolder/personalBlog.jsp">个人博客</a>
          <a class="blog-nav-item" href="/class_project/navFolder/modifyPassword.jsp">密码修改</a>
          <a class="blog-nav-item" href="/class_project/navFolder/manageUser.jsp" id="manageUser">用户管理</a>
          <a class="blog-nav-item" href="/class_project/navFolder/manageCategory.jsp" id="category" name="类别管理">类别管理</a>
          <a class="blog-nav-item right-click" href="/class_project/jsp/signup.jsp" id="signup">加入zz_blog</a>
          <a class="blog-nav-item right-click" href="/class_project/jsp/win_login.jsp" id="login" name="用户登陆">登陆</a>
          <a class="blog-nav-item right-click" id="identify" href="#">当前访客身份为:&nbsp;&nbsp;
	      	  <span style="color:#BE4" id="user_name">
	        	<% String name = String.valueOf(session.getAttribute("userId")); %>
	        	<% name = name=="null"? "游客":name; %>
	        	<%= name %>
	          </span>
          </a>
        </nav>
      </div>
    </div>
</body>
<script type="text/javascript" src="../js/lib/layer/layer.min.js"></script>
<script type="text/javascript" src="../js/navjs.js"></script>
</html>