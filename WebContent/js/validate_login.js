$(document).ready(function(){
	$("img#checkCode").click(function(event){
		$(this).attr("src","/class_project/signupValidate?t=" + +Math.random());
		/*event.stopPropagation();*/
		window.event.returnValue = false;
	});
	$("img#checkCode").mouseup(function() {
		setTimeout(function() {
			clickValidateCode();
		}, 100);
	});
	/*提交时的验证form标签的内容*/
	$("input[type='submit']").click(function(event){
		$("input.validate").each(function(index, element){
			var data = $(this).val();
			if(this.name == "user.email"){
				dealEmailInput(data, event);
			}else{
				dealOtherInput(data, index+1, event);
			}
		});
	});
	/*密码验证是否相同的标签*/
	$("input[name='password_confirm']").blur(function(){
		var password = $("input[name='user.password']")[0].value;
		if(password>0 && password != this.value ){
			$("#pass_confirm").html("密码不一样").show();
		}else{
			$("#pass_confirm").hide();
		}
	});
	/*验证密码长度*/
	$("input[name='user.password']").blur(function(){
		if(this.value.length<6){
			$("#password").html("密码长度要大于6").show();
		}else{
			$("#password").hide();
		}
	});
	/*重置全部隐藏提示*/
	$("input[type='reset']").click(function(){
		$("span.validate").hide();
	});
	/*获取后台的验证码到前台*/
	$("input[name='check_code']").blur(function(){
		var validateCode = clickValidateCode();
		if(this.value != validateCode.responseText){
			$("#Validatespan").show();
			$("input[type='submit']").attr("disabled","disable");
			/*监听再次的输入*/
			$(this).bind('input propertychange', function() {
				validateCode = $("#validateCode").html();
				if(this.value==validateCode.responseText){
					$("#Validatespan").hide();
				}else{
					$("#Validatespan").show();
				}
			});
		}else{
			$("#Validatespan").hide();
			$("input[type='submit']").removeAttr("disabled");
		}
	});
});
/*点击图片更新验证码*/
function clickValidateCode(){
	var validateCode = $.ajax({url:"/class_project/getValidateCode",async:false});
	$("#validateCode").html(validateCode.responseText);
	return validateCode;
}
function dealEmailInput(data, event){
	if(valid_email(data)){
		$("span#email").hide();
	} else{
		$("span#email").show();
		event.preventDefault();
	}
};

function valid_email(email){
	var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return pattern.test(email);
};

function dealOtherInput(data, index, event){
	if(data.length>0){
		$("span")[index].style.display="none";
	}else{
		console.log(data)
		$("span")[index].style.display="inline";
		event.preventDefault();
	}
}
