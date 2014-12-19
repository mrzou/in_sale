$(document).ready(function(){
	$("img#checkCode").click(function(event){
		$(this).attr("src","/class_project/signupValidate?t=" + +Math.random());
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
	})
	/*密码验证是否相同的标签*/
	$("input[name='password_confirm']").blur(function(){
		var password = $("input[name='user.password']")[0].value;
		if(password>0 && password != this.value ){
			$("#pass_confirm").html("密码不一样").show();
		}else{
			$("#pass_confirm").hide();
		}
	})
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
