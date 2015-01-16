<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/home.css">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/home.js"></script>
<title>zz_blog首页</title>
</head>
<body>
    <jsp:include page="navjsp.jsp"></jsp:include>
    <div class="container">
      <div class="blog-header">
        <p class="lead blog-description" style="margin-left: 200px;">用户所有博客</p>
      </div>

      <div class="row">

        <div class="col-md-8 blog-main">

          <div class="blog-post">
            
          </div><!-- /.blog-post -->

          <nav>
            <ul class="pager">
              <li><a href="#" id="previous">Previous</a></li>
              <li><a href="#" id="next">Next</a></li>
              <li style="display:none" id="ifConfirm"><%= request.getParameter("confirm_email") %></li>
            </ul>
          </nav>

        </div><!-- /.blog-main -->

        <div class="col-md-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="http://www.github.com">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->
</body>
<script type="text/javascript">
$(document).ready(function(){
	if($("#ifConfirm").html()=="yes"){
		layer.alert("邮箱验证成功!","",function(){
			var stateObject = {};
			var title = "Wow Title";
			var newUrl = "/class_project/jsp/home.jsp";
			history.pushState(stateObject,title,newUrl);
			layer.closeAll();
		});
	}
})
</script>
</html>