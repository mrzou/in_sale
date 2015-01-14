$(document).ready(function(){
	var allBlog = null;
	var pageSize = null;
	var allCategory = $.ajax({
		url: "/class_project/blogIndexAll",
		async: false,
		success: function(data){
			allBlog = JSON.parse(data).records;
			pageSize = allBlog%5;
			if(allBlog.length!=0){
				for(var i=0; i<5; i++){
					$("div.blog-post").append("<h4 class='blog-post-title'><a href='/class_project/jsp/showBlog.jsp?id="+allBlog[i].id+
					"\'>" + allBlog[i].title + "</a></h4>");
					
					allBlog[i].content.split("\\n").forEach(function(pdata){
						$("div.blog-post").append("<p>" + pdata + "</p>");
					})
				}
			}
			$("#next").data("pageCount", 1);
			$("#previous").data("pageCount", 0);
			$("#previous").removeAttr("href");
			$("#previous").removeAttr("onclick");
		},
		error: function(msg){
			alert(msg.responseText);
		}
	});
	$("#next").click(function(event){
		event.preventDefault();
		$("div.blog-post").children().remove();
		var pageCount = $(this).data("pageCount")
		for(var i=pageCount*5; i<pageCount*5+5; i++){
			$("div.blog-post").append("<h4 class='blog-post-title'><a href='/class_project/jsp/showBlog.jsp?id="+allBlog[i].id+
			"\'>" + allBlog[i].title + "</a></h4>");
			
			allBlog[i].content.split("\\n").forEach(function(pdata){
				$("div.blog-post").append("<p>" + pdata + "</p>");
			})
		}
		$(this).data("pageCount",pageCount+1);
		$("#previous").data("pageCount",pageCount-1);
	})
	$("#previous").click(function(event){
		event.preventDefault();
		$("div.blog-post").children().remove();
		var pageCount = $(this).data("pageCount")
		for(var i=pageCount*5; i<pageCount*5+5; i++){
			$("div.blog-post").append("<h4 class='blog-post-title'><a href='/class_project/jsp/showBlog.jsp?id="+allBlog[i].id+
			"\'>" + allBlog[i].title + "</a></h4>");
			
			allBlog[i].content.split("\\n").forEach(function(pdata){
				$("div.blog-post").append("<p>" + pdata + "</p>");
			})
		}
		$(this).data("pageCount",pageCount-1);
		$("#next").data("pageCount",pageCount+1);
	})
});