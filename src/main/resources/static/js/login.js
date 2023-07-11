$(document).ready(function(){
	

/*************************
로그인
*************************/
$("#btn_login").click(function(){
	if($("#id").val() == ""){
		alert("아이디를 입력해주세요");
		$("#id").focus();
		return false;
	}else if($("#pass").val()==""){
		alert("패스워드를 입력해주세요");
		$("#pass").focus();
		return false;
	}else{
		loginForm.submit();
	}
	
});

/*******************************
로그인 폼 - 다시쓰기 
*******************************/
$("#btn_reset").click(function(){
$("#id").val("").focus();
$("#pass").val("");
}); //btnLoginReset click



/*************************
		로그인2 -예매내역용 
*************************/
$("#btnLogin").click(function(){
	if($("#id").val() == ""){
		alert("아이디를 입력해주세요");
		$("#id").focus();
		return false;
	}else if($("#pass").val()==""){
		alert("패스워드를 입력해주세요");
		$("#pass").focus();
		return false;
	}else{
		loginForm.submit();
	}
	
});

/*************************
		로그인2 -예매내역용 
*************************/



}); //ready
