$(document).ready(function(){
	$("span.validate").hide();
	$("img#checkCode").click(function(event){
		$(this).attr("src","/class_project/signupValidate?t=" + +Math.random());
		/*event.stopPropagation();*/
		window.event.returnValue = false;
	});
	$("input[type='submit']").click(function(event){
		$("input.validate").each(function(index, element){
			console.log(index);
			var data = $(this).val();
			if(this.name == "email"){
				dealEmailInput(data, event);
			}else{
				dealOtherInput(data, index+1, event);
			}
		});
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
	if(data>0){
		$("span")[index].style.display="none";
	}else{
		$("span")[index].style.display="";
		event.preventDefault();
	}
}