<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link href="../css/lib/footable.core.css" rel="stylesheet" type="text/css" />
<link href="../css/lib/footable-demos.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<link rel="stylesheet" type="text/css" href="../css/manageUser.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script src="../js/lib/footable.js" type="text/javascript"></script>
<script src="../js/lib/footable.paginate.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/manageUser.js"></script>

<title>用户管理</title>
</head>
<body>
<jsp:include page="/jsp/navjsp.jsp"></jsp:include>
<div class="container">
	<div id="error"></div>
	<div class="row clearfix table-location">
		<div class="col-md-10 column">
			<table class="footable">
			  <thead>
			    <tr>
			      <th>用户名</th>
			      <th>邮箱</th>
			      <th>操作</th>
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
		<div><button type="button" class="btn btn-primary" style="width: 200px" id="addUser">添加用户</button></div>
	</div>
</div>
</body>
</html>