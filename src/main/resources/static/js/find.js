$(document).ready(function(){

/****************************
아이디 찾기 인증번호 같을 시 다음페이지
****************************/
	$("#authcheckBtn").click(function(){
			if($('#mail-check-warn').text() == '인증번호가 일치합니다.'){
				const email = $('#userEmail1').val()+ '@' + $('#userEmail2').val();
				
				$("#email").val(email);
				
				verti.submit();
			}




	});





/****************************
아이디 찾기 
****************************/
	$(function(){
		$("#find_id_btn").click(function(){
			location.href ='../find_id/find_id1';	
		})
	})




	/*******************************************
	아이디 중복체크
	********************************************/

		$("#btnIdCheck").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else{
			$.ajax({
				url : "id_check?id="+$("#id").val(),
				success : function(result){
					if(result == 1){
						$("#idcheck_msg").text("이미 사용중인 아이디 입니다. 다시 입력해주세요")
						.css("color","red").css("font-size","11px").css("display","block")
						.css("padding","8px 0px 8px 160px");
						$("#id").val("").focus();
					}else if(result == 0){
						$("#idcheck_msg").text("사용 가능한 아이디 입니다")
						.css("color","blue").css("font-size","11px").css("display","block")
						.css("padding","8px 0px 8px 160px");
						$("#pass").focus();
					}
				}
			});
		}
	});
		

		/*******************************************
		회원가입 폼 체크 - 비밀번호 & 비밀번호 확인 
	********************************************/
	$("#cpass").on("blur", function(){		
		if($("#pass").val() != "" && $("#cpass").val() != ""){
			if($("#pass").val() == $("#cpass").val()){
				$("#cmsg").text("비밀번호가 동일합니다").css("color","blue")
					.css("font-size","11px").css("display","block");
				$("#name").focus();
			}else{
				$("#cmsg").text("비밀번호가 동일하지 않습니다. 다시  입력해주세요")
				.css("color","red").css("font-size","11px").css("display","block");
				
				$("#pass").val("").focus();
				$("#cpass").val("");
			}
		}
	}); //cpass blur



	/*******************************
		회원가입 폼 체크 - 유효성체크(값의 유무만 확인)
	*******************************/
	
	$("#btnJoin").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#idcheck_msg").text() == ""){
			alert("중복체크를 진행해주세요");
			$("#btnIdCheck").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else if($("#cpass").val() == ""){
			alert("패스워드 확인을 입력해주세요");
			$("#cpass").focus();
			return false;
		}else if($("#name").val() == ""){
			alert("성명을 입력해주세요");
			$("#name").focus();
			return false;
		}else if($("input[name='tel']:checked").length == 0){
			alert("통신사를 선택해주세요");
			return false;
		}else if($("input[name='birth']:checked").length == 0){
			alert("출생년도를 입력해주세요");
			return false;
		}else if($("#pnumber").val() == ""){
			alert("폰번호를 입력해주세요");
			$("#pnumber").focus();
			return false;
			}else if($("input[name='gender']:checked").length == 0){
			alert("성별을 선택해주세요");
			return false;
		}else{
			//서버전송
			alert("회원가입에 성공하셨습니다.")
			joinForm.submit();
		}
	});	//btnJoin


/******

인증번호 발송 후 나오게 하기
******/
	$("#mail-Check-Btn").click(function(){
			$(".authnum").css('display','block');
});
//비밀번호 변경
$("#btnChange").click(function() {

	var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
	var password = $("#newpass").val();
if($("#newpass").val() == "" || passwordRegex.test(password)) {
	alert("패스워드를 대문자,소문자,숫자 포함하여 8자 이상 입력해주세요");
	$("#pass").focus();
	return false;
}else{
	changeForm.submit();

	}
});//btnchange




});
