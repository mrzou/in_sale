<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<link rel="stylesheet" type="text/css" href="../css/indexBlog.css">
<link rel="stylesheet" type="text/css" href="../css/lib/footable.core.css"/>
<link rel="stylesheet" type="text/css" href="../css/lib/footable-demos.css"/>
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/lib/footable.js"></script>
<script type="text/javascript" src="../js/lib/footable.paginate.js"></script>
<script type="text/javascript" src="../js/blogIndex.js"></script>

<title>个人博客主页</title>
</head>
<body class="body-background">
<jsp:include page="/jsp/navjsp.jsp"></jsp:include>
<div class="container signup-location">
	<div class="row clearfix">
		<div class="col-md-12 column col-sm-offset-1">
			<div class="sign-process register-progress clearfix hidden-xs hidden-sm">      
				<div class="signup-place">
				<h4 style="border-bottom: 1px solid #C0C0C0"><span class="icon"></span>用户博客</h4>
				<div class="col-md-10 column" id="blogForm">
					<table class="footable">
					  <thead>
					    <tr>
					      <th>博客</th>
					      <th>时间</th>
					      <th>操作</th>
					      <th width=60px><a href="/class_project/navFolder/addBlog.jsp"class="btn btn-link">添加博客</a></th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					  </tbody>
					  <tfoot align="center">
						  <tr>
							<td colspan="5">
								<div class="pagination pagination-centered contentNav"></div>
							</td>
						  </tr>
					  </tfoot>
					</table>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>