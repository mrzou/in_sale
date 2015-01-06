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
<title>添加博客</title>
</head>
<body>
  <jsp:include page="/jsp/navjsp.jsp"></jsp:include>
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-11 column" style="margin-left: 150px">
			<form method="post" action="/class_project/addBlog" id="blogForm">
				<div class="row"  style="margin-top:20px">
					<div class="col-sm-1"><span>文章标题</span></div>
				    <div class="col-sm-3">
				    	<input name="blog.title" class="form-control" type="text" placeholder="title?" />
				    </div>
					<div class="col-sm-1"> <span>选择类别</span></div>
					<div class="col-sm-2">
					      <select class="form-control" id="allCategory" name="category">
					      </select>
					</div>
				</div>
				<div class="row"  style="margin-top:25px">
					<div class="col-sm-10"><span>文章的内容</span></div>
					<div class="col-sm-8">
					    <textarea name="blog.content" data-provide="markdown" rows="25"></textarea>
					    <label class="checkbox" style="margin-left: 20px">
					      <input name="publish" type="checkbox"> Publish
					    </label>
					    <hr/>
					    <button type="submit" class="btn btn-primary" id="button" style="margin-bottom: 10px">添加博客</button>
				    </div>
				</div>
			</form>
		</div>
	</div>
  </div>
</body>
<script>
	$(document).ready(function(){
		$("a").removeClass("active");
		$("a").eq(1).addClass("active");
		var allCategory = $.ajax({
			url: "class_project/categoryIndex",
			async: false,
			success: function(data){
				if(JSON.parse(data).records.length!=0){
					JSON.parse(data).records.forEach(function(obj){
						$("#allCategory").prepend("<option value="+obj.id+">"+ obj.content +"</option>");
					})
				}
			}
		});
		$("#blogForm").submit(function(event){
			event.preventDefault();
			var category =  $("#allCategory").val();
			var title = $("input[name='blog.title']").val();
			var content = $("textarea").val().replace(/\n/gi, "\\n");
			if(category==null){
				layer.alert("请先添加类别!");
			}else{
				var deferred = $.post(
						this.action, 
						{ 
							"blog.title": title, 
							"blog.content": content,
							"category": category,
						}
				);
				deferred.success(function () {
					if(deferred.responseText=="success"){
						window.location.href = "/class_project/navFolder/personalBlog.jsp"
					}else{
						window.location.href = "/class_project/jsp/error.jsp"
						
					}
			    });
			}
		});
	})
</script>
</html>