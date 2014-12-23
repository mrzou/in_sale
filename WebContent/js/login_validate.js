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
	/*验证邮箱不能为空*/
	$("input[name='user.email']").blur(function(event){
		if(this.value.length<=0){
			inputIfRight(this, "wrong");
		}else{
			dealEmailInput(this, event);
		}
	});
	/*检查密码*/
	$("input[name='user.password']").blur(function(){
		if(this.value.length<=0){
			inputIfRight(this, "wrong");
		}else{
			inputIfRight(this, event);
		}
	});
	/*获取后台的验证码到前台*/
	$("input[name='check_code']").blur(function(){
		getValidateCodeTo(this);
	});
	/*重置全部隐藏提示*/
	$("input[type='reset']").click(function(){
		$("span.validate, div.inputWrong, div.inputRight").hide();
	});
	/*提交时的验证form标签的内容*/
	$("input[type='submit']").click(function(event){
		$("input.validate").each(function(index, element){
			var data = $(this).val();
			/*如果没填提示为空*/
			if(data.length<=0){
				inputIfRight(this, "wrong");
				event.preventDefault();
			}else{                              /*检验有填的部分*/
				if(this.name == "user.email"){
					checkValidateEmail(this, event);
				}else if(this.name == "check_code"){
					getValidateCodeTo(this);
				}/*else{
					//dealOtherInput(data, this, event);
				}*/
			}
		});
	});
});
/*作用: 检查邮件的格式;
inputSelf: this;
data: email;*/
function dealEmailInput(inputSelf, event){
	var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var isEmail = pattern.test(inputSelf.value);
	if(isEmail){
		validateNameAndEmail(inputSelf, "email", "邮箱");
	}else{
		inputIfRight(inputSelf, "wrong", "邮箱格式不正确");
		event.preventDefault();
	}
};
/*检查是否存在邮箱*/
function checkValidateEmail(inputSelf, event){
	var validateEmail = $.ajax({
		url:"/class_project/checkValidateEmail?email="+inputSelf.value,
		async:false,
		error: function(msg){
			$("#error").html(msg.responseText);
		}
	});
	if(validateEmail.responseText=="unExist"){
		inputIfRight(inputSelf, "wrong", "邮箱用户不存在");
		event.preventDefault();
	}else{
		inputIfRight(inputSelf, "right");
	}
}
/*验证码的检查*/
function getValidateCodeTo(inputSelf){
	var validateCode = $("#validateCode").html();
	if(inputSelf.value != validateCode){
		$(inputSelf).parent().siblings().eq(2).children().show();
		$("#Validatespan").show().html("验证码不正确");
		$("input[type='submit']").attr("disabled","disable");
		/*监听再次的输入*/
		inputValidateEvent(inputSelf)
	}else{
		$("#Validatespan").hide();
		$("input[type='submit']").removeAttr("disabled");
		$(inputSelf).parent().siblings().eq(2).children().removeClass("inputWrong").addClass("inputRight").show();
	}
}

/*输入验证码时添加事件*/
function inputValidateEvent(inputSelf){
	$(inputSelf).bind('input propertychange', function() {
		validateCode = $("#validateCode").html();
		if(inputSelf.value==validateCode){
			$("#Validatespan").hide();
			$(inputSelf).parent().siblings().eq(2).children().removeClass("inputWrong").addClass("inputRight");
		}else{
			$(inputSelf).parent().siblings().eq(2).children().show().removeClass("inputRight").addClass("inputWrong");
			$("#Validatespan").show().html("验证码不正确");
		}
	});
}

/*点击图片更新验证码*/
function clickValidateCode(){
	var validateCode = $.ajax({url:"/class_project/getValidateCode",async:false});
	$("#validateCode").html(validateCode.responseText);
	return validateCode;
}

/*作用: 检查邮件的格式;
inputSelf: this;
data: email;*/
function dealEmailInput(inputSelf, event){
	var pattern = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var isEmail = pattern.test(inputSelf.value);
	if(isEmail){
		inputIfRight(inputSelf, "right");
	}else{
		inputIfRight(inputSelf, "wrong", "邮箱格式不正确");
		event.preventDefault();
	}
};

function dealOtherInput(data, selfEle, event){
	if(data.length>0){
		inputIfRight(selfEle, "right");
	}else{
		inputIfRight(selfEle, "wrong");
	}
}

/*作用: 显示或者隐藏提示
message: 要显示的提示信息
inputSelf: this
type: 类型是显示错误还是正确*/
function inputIfRight(inputSelf, type, message){
	var alertPic = $(inputSelf).parent().next().children();
	var alertSpan = $(inputSelf).parent().siblings().last().children();
	var newMessage = message == null? alertSpan.html():message;
	if(type=="wrong"){
		alertPic.removeClass("inputRight").addClass("inputWrong").show();
		alertSpan.show().html(newMessage);
	}else{
		alertPic.show();
		alertPic.removeClass("inputWrong").addClass("inputRight");
		alertSpan.hide();
	}
}
