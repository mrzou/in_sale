$(document).ready(function(){
	clickValidateCode();
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
	/*获取后台的验证码到前台*/
	$("input[name='validateCode']").blur(function(){
		if(this.value.length==""){
			$(this).parent().addClass("has-error");
			$(this).parent().siblings().last().show();
		}else{
			getValidateCodeTo(this);
		}
	});
	/*提交时的验证form标签的内容*/
	$(".next-step").click(function(event){
		$(".form-group .form-control").each(function(index, element){
			var data = $(this).val();
			if(data.length<=0){
				inputIfRight(this, "wrong");
				event.preventDefault();
			}else{
				if(this.name == "user.email"){
					dealEmailInput(this, event);
				}else if(this.name == "check_code"){
					getValidateCodeTo(this);
				}else{
					dealOtherInput(data, this, event);
					if($("input[name='validateCode']").val()!=null){
						if($("input[name='validateCode']").val().length<=0){
							$(this).parent().siblings().eq(2).children().removeClass("inputRight").addClass("inputWrong").show();
							$("#Validatespan").show();
							event.preventDefault();
						}else{
							$("#Validatespan").hide();
						}
					}else{event.preventDefault();}
				}
			}
		});
	});
	/*弹出窗口的登陆方式，发送一步请求到后台，并关闭窗口*/
	$("#loginForm").submit(function(event) {
		event.preventDefault();
		var email = $(this).find('input[name="user.email"]').val();
		var password = $(this).find('input[name="user.password"]').val();
		var ifLogin = $(this).find('input[name="autoLogin"]').val();
		var deferred = $.post("/class_project/loginUser.action", { "user.email": email, "user.password": password,"autoLogin": ifLogin });
		deferred.success(function () {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
	    });
	});
});
/*验证码的检查*/
function getValidateCodeTo(inputSelf){
	var validateCode = $("#validateCode").html();
	if(inputSelf.value != validateCode){
		validateCodeFail(inputSelf)
		/*监听再次的输入*/
		inputValidateEvent(inputSelf)
	}else{
		validateCodeSuccess(inputSelf)
	}
}
/*验证码监听事件的处理*/
function validateCodeSuccess(inputSelf){
	$(inputSelf).parent().removeClass("has-error")
	$(inputSelf).parent().siblings().eq(4).hide();
	$(inputSelf).parent().siblings().eq(2).show();
	$("button[type='submit']").removeAttr("disabled");
}
function validateCodeFail(inputSelf){
	$(inputSelf).parent().addClass("has-error");
	$(inputSelf).parent().siblings().eq(2).hide();
	$(inputSelf).parent().siblings().eq(4).show();
	$(inputSelf).parent().siblings().eq(4).children().last().html("验证码不正确");
	$("button[type='submit']").attr("disabled","disable");
}
/*输入验证码时添加事件*/
function inputValidateEvent(inputSelf){
	$(inputSelf).bind('input propertychange', function() {
		validateCode = $("#validateCode").html();
		if(inputSelf.value==validateCode){
			validateCodeSuccess(inputSelf);
		}else{
			validateCodeFail(inputSelf);
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
	if(!isEmail){
		inputIfRight(inputSelf, "wrong", "邮箱格式不正确");
		event.preventDefault();
	}else{
		inputIfRight(inputSelf, "right");
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
	var inputDiv = $(inputSelf).parent();
	var alertSpan = inputDiv.siblings().last().children().last();
	var newMessage = message == null? alertSpan.html():message;
	if(type=="wrong"){
		$(inputSelf).parent().addClass("has-error");
		inputDiv.next().hide();
		inputDiv.siblings().last().show();
		alertSpan.html(message).show();
	}else{
		$(inputSelf).parent().removeClass("has-error");
		inputDiv.siblings().last().hide();
		inputDiv.next().show();
	}
}
