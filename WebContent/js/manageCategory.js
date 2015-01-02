$(document).ready(function(){
	$('.footable').data('page-size', 10);
	$('.footable').trigger('footable_initialized');
	/*初始化整张表*/
	$(function () {
	    $('.footable').footable();
	});
	/* 显示列表 */
	var allCategory = $.ajax({
		url: "/class_project/categoryIndex",
		async: false,
		success: function(data){
			if(JSON.parse(data).records.length!=0){
				JSON.parse(data).records.forEach(function(obj){
					$("#tbody").prepend("<tr>"+
						      "<td>"+obj.content+"</td>"+
						      "<td>"+
						      	"<a href='/class_project/modifyCategory?id="+obj.id+"'"+
						      	">修改</a>"+
						      	"<a href='/class_project/deleteCategory?id="+obj.id+"'"+
						      	"class='delete-category'>删除</a>"+
						      "</td>"+
						      "</tr>");
				})
			}
		},
		error: function(msg){
			$("#error").html(msg.responseText);
		}
	});
	/*添加删除修改类别的事件*/
	$("tbody td a").click(function(event){
		event.preventDefault();
		if(this.innerHTML=="删除"){
			var state = $.ajax({
				url: this.href,
				async: false,
			});
			if(state.responseText=="success"){
				$(this).remove();
				layer.alert("删除成功!");
			}
		}else{
			layer.alert("要修改请先删除再添加!");
		}
	})
	/* 添加类别 */
	$("button[type='button']").click(function(){
		var category = $(this).parent().siblings().first().children().first().val();
		var deferred = $.post(
			"/class_project/addCategory", 
			{ 
				"category.content": category, 
			}
		);
		deferred.success(function(){
			layer.alert("success","", function(){
				$("#tbody").prepend("<tr>"+
					      "<td>"+category+"</td>"+
					      "<td>"+
					      	"<a href='#'>修改</a>"+
					      	"<a href='#' class='delete-category'>删除</a>"+
					      "</td>"+
					      "</tr>");
				$('.footable').trigger('footable_initialized');
				layer.closeAll();
			});
		});
		deferred.error(function(){
			layer.alert("类别不能重复取名");
		});
	});
})