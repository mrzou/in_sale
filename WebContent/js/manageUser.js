$(document).ready(function(){
	$("a").removeClass("active");
	$("a").eq(3).addClass("active");
	$('.footable').data('page-size', 10);
	$('.footable').trigger('footable_initialized');
	/*初始化整张表*/
	$(function () {
	    $('.footable').footable();
	});
	/* 显示列表 */
	var allCategory = $.ajax({
		url: "/class_project/userIndex",
		async: false,
		success: function(data){
			if(JSON.parse(data).records.length!=0){
				JSON.parse(data).records.forEach(function(obj){
					$("#tbody").prepend("<tr>"+
						      "<td>"+obj.name+"</td>"+
						      "<td>"+obj.email+"</td>"+
						      "<td>"+
						      	"<a href='/class_project/userModify?id="+obj.id+"'"+
						      	">修改</a>"+
						      	"<a href='/class_project/userDelete?id="+obj.id+"'"+
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
	/*添加删除修改用户的事件*/
	$("tbody td a").click(function(event){
		event.preventDefault();
		if(this.innerHTML=="删除"){
			var state = $.ajax({
				url: this.href,
				async: false,
			});
			if(state.responseText=="success"){
				$(this).parent().parent().remove();
				layer.alert("删除成功!");
			}else{
				layer.alert("删除失败!");
			}
		}else{
			layer.alert("要修改请先删除再添加!");
		}
	})
});