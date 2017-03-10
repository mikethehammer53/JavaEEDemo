/**
 * 
 */
var flag=false;
var flag1=false;
var flag2=false;
var flag3=false;
var flag4=false;
var flag5=false;
$(function(){
	 $("input").focus(function(){
		    $(".inputbox").css("background-color","#FFFFCC");
		  });
	 $("input").blur(function(){
		    $(".inputbox").css("background-color","#D6D6FF");
		  });
	//name
	$("#uid").focus(function(){
		$('#nameerr').empty();
		$('#nameexisted').empty();
	});
	$("#uid").blur(function(){
		if($("#uid").val()==""){
			$("#nameerr").append("请输入用户名");
			flag1=false;
		}
		else flag1=true;
	});
	//password
	$("#pid").focus(function(){
		$("#pwderr").empty();
	});
	$("#pid").blur(function(){
		if($("#pid").val()==""){
			$("#pwderr").append("请输入密码");
			flag2=false;
		}
		else flag2=true;
	});
	//password confirm
	$("#confirmpwd").focus(function(){
		$("#pwdcfmerr").empty();
	});
	$("#comfirmpwd").blur(function(){
		if(($("#pid").val())==($("#comfirmpwd").val())){
			flag3=true;
		}
		else {
			$("#pwdcfmerr").empty();
			$("#pwdcfmerr").append("密码不一致");
			flag3=false;
		}
	});
	//email
	$("#umail").focus(function(){
		$("#mailerr").empty();
	});
	$("#umail").blur(function(){
		if($("#umail").val()==""){
			$("#mailerr").append("请输入邮箱");
			flag4=false;
		}
		else flag4=true;
	});
	//verify code
	$("#verifycodeid").focus(function(){
		$("#verifycodeerr").empty();
	});
	$("#verifycodeid").blur(function(){
		if($("#verifycodeid").val()==""){
			$("#verifycodeerr").append("请输入验证码");
			flag5=false;
		}
		else flag5=true;
	});
	function formvalidate(){
		flag=flag1&&flag2&&flag3&&flag4&&flag5;
		if(flag) $("#subbtn").removeAttr("disabled");
		else $("#subbtn").attr("disabled","disabled");
	}
	setInterval(formvalidate, 0);
});