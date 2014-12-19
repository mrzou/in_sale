$(document).ready(function(){
	$("img#checkCode").click(function(event){
		$(this).attr("src","/class_project/signupValidate?t=" + +Math.random());
		/*$.ajax({
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            url: '/class_project/getValidateCode',
            dataType: 'json',
            success: function (msg, status) {
                console.log(msg);
                console.log("hello");
            },
            error: function (xhr, desc, err) {
                console.log(xhr);
                console.log("Details: " + desc + "\nError:" + err);
            }
        });*/
		/*event.stopPropagation();*/
		window.event.returnValue = false;
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
		console.log(this.value.length);
		if(this.value.length<2){
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
	$("#validateCode")
});

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
