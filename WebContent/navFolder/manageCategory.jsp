<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="../images/favicon.jpg">
<link rel="stylesheet" type="text/css" href="../css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/lib/footable.core.css"/>
<link rel="stylesheet" type="text/css" href="../css/lib/footable-demos.css"/>
<link rel="stylesheet" type="text/css" href="../css/navcss.css">
<script type="text/javascript" src="../js/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/lib/bootstrap-tab.js" ></script>
<script type="text/javascript" src="../js/lib/layer/layer.min.js"></script>
<script type="text/javascript" src="../js/lib/footable.js"></script>
<script type="text/javascript" src="../js/lib/footable.paginate.js"></script>
<script type="text/javascript" src="../js/manageCategory.js"></script>
<title>类别管理</title>
</head>
<body class="body-background">
<div class="container">
			<div id="error"></div>
	<div class="row clearfix table-location">
		<div class="col-md-4 column">
			<table class="footable">
			  <thead>
			    <tr>
			      <th>类别</th>
			      <th>操作</th>
			    </tr>
			  </thead>
			  <tbody id="tbody">
			  </tbody>
			  <tfoot>
				  <tr>
					<td colspan="5">
						<div class="pagination pagination-centered contentNav"></div>
					</td>
				  </tr>
			  </tfoot>
			</table>
			<div class="row"  style="margin-top:10px">
			    <div class="col-sm-5 col-sm-offset-2">
			    	<input name="category" class="form-control" type="text" id="category"/>
			    </div>
			    <div class="col-sm-2"><button type="button" class="btn btn-primary" id="button">添加类别</button></div>
			</div>
		</div>
	</div>
</div>
</body>
<style>
.contentNav {
	height:73px;
    float:left;
    width:330px;
}
.contentNav ul{
	float:left;
    list-style-type:none;
    margin-left: 80px;
	margin-top: 20px;
}
.contentNav ul li{
	height:35px;
    line-height:35px;  /*  让内容垂直居中  */
    display:inline;  /*  将li设置成内联元素就可以了  */
}
li a {
	margin-left: 24px;
	text-align: center;
	font-size: 16px;
}
a.delete-category {
	color: #f90;
	text-decoration: none;
}
.table-location {
	margin-top: 30px;
	margin-right: -15px;
	margin-left: 100px;
	width: 500px;
	height: 368px;
	border: 1px solid #ddd;
	background-color: #fefefe
}
thead tr th, tbody tr td {
	text-align: center;
}
.body-background {
	background-color: #f8f8f8;
}
</style>
</html>