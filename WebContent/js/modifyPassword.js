$(document).ready(function(){
	$("a").removeClass("active");
	$("a").eq(2).addClass("active");
	$("input[name='user.password'], input[name='new_password']").blur(function(){
		var userName = this.value;
		if(userName.length<=5){
			layer.tips('密码要多于6个字符', this , {guide: 1, time: 10});
			$("button[type='submit']").attr("disabled","disable");
		}else{
			$("button[type='submit']").removeAttr("disabled","disable");
		}
	});
	/*验证密码是否相同的标签*/
	$("input[name='password_confirm']").blur(function(){
		var password = $("input[name='new_password']").val();
		if(password != this.value ){
			layer.alert("确认密码不一致!")
			$("button[type='submit']").attr("disabled","disable");
		}else{
			$("button[type='submit']").removeAttr("disabled","disable");
		}
	});
	/*修改密码，发送异步请求到后台*/
	$("#loginForm").submit(function(event) {
		event.preventDefault();
		var oldPassword = $(this).find('input[name="user.password"]').val();
		var newPassword = $(this).find('input[name="new_password"]').val();
		var deferred = $.post(
				this.action, 
				{ 
					"user.password": oldPassword, 
					"new_password": newPassword,
				}
		);
		deferred.success(function () {
			if(deferred.responseText=="success"){
				layer.alert("修改成功!","");
				$("#loginForm")[0].reset();
			}else if(deferred.responseText=="same"){
				layer.alert("新密码和旧密码一致!")
				$("#loginForm")[0].reset();
			}else{
				layer.alert("旧密码输入错误!");
				$("#loginForm")[0].reset();
			}
	    });
	});
});
