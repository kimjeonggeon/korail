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


	/*************************
	 비밀번호 보여주는 기능
	 *************************/

	$('.passshow').on('click', function() {
		$('#pass').toggleClass('active');
		if ($('#pass').hasClass('active')) {
			$('#passshow').attr('src', 'http://localhost:9000/images/view.png');
			$(this).prev('input').attr('type', 'text');
		} else {
			$('#passshow').attr('src', 'http://localhost:9000/images/hide.png');
			$(this).prev('input').attr('type', 'password');
		}
	});





}); //ready
