$(document).ready(function(){
	clickValidateCode();
	$("div.inputWrong").hide();
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
	/*验证名字的唯一性*/
	$("input[name='user.name']").blur(function(){
		var userName = this.value;
		var uniqueName = $.ajax({
			url: "/class_project/validateUniqueName?name="+userName,
			async: false,
        });
		if(uniqueName.responseText=="exist"){
			inputIfRight(this, "wrong")
		}else{
			inputIfRight(this, "right")
		}
	});
	/*提交时的验证form标签的内容*/
	$("input[type='submit']").click(function(event){
		$("input.validate").each(function(index, element){
			var data = $(this).val();
			if(this.name == "user.email"){
				dealEmailInput(this, data, event);
			}else if(this.name == "check_code"){
				getValidateCodeTo(this);
			}else{
				dealOtherInput(data, this, event);
				if($("input[name='check_code']").val()!=$("#validateCode").val()){
					$("#Validatespan").show();
					event.preventDefault();
				}else{
					$("#validateCode").hide();
				}
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
		getValidateCodeTo(this);
	});
});

function getValidateCodeTo(inputSelf){
	var validateCode = $("#validateCode").html();
	if(inputSelf.value != validateCode){
		$("#Validatespan").show();
		$(inputSelf).parent().siblings().eq(2).children().show();
		$("input[type='submit']").attr("disabled","disable");
		/*监听再次的输入*/
		$(inputSelf).bind('input propertychange', function() {
			validateCode = $("#validateCode").html();
			if(inputCode.value==validateCode){
				$("#Validatespan").hide();
			}else{
				$(inputSelf).parent().siblings().eq(3).children().show();
				$("#Validatespan").show();
			}
		});
	}else{
		$("#Validatespan").hide();
		$("input[type='submit']").removeAttr("disabled");
	}
}
/*点击图片更新验证码*/
function clickValidateCode(){
	var validateCode = $.ajax({url:"/class_project/getValidateCode",async:false});
	$("#validateCode").html(validateCode.responseText);
	return validateCode;
}
function dealEmailInput(inputSelf, data, event){
	if(valid_email(data)){
		$("span#email").hide();
	} else{
		$(inputSelf).parent().next().children().show();
		$("span#email").show();
		event.preventDefault();
	}
};

function valid_email(email){
	var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return pattern.test(email);
};

function dealOtherInput(data, selfEle, event){
	if(data.length>0){
		console.log(selfEle);
		inputIfRight(selfEle, "right");
	}else{
		inputIfRight(selfEle, "wrong");
		event.preventDefault();
	}
}

function inputIfRight(inputSelf, type){
	if(type=="wrong"){
		$(inputSelf).parent().next().children().show();
		$(inputSelf).parent().siblings().last().children().show()
	}else{
		$(inputSelf).parent().next().children().hide();
		$(inputSelf).parent().siblings().last().children().hide();
	}
}
