$(document).ready(function(){
	

	
	//카드사 선택 이벤트
	$(".selectricOpen").click(function() {
		
		$(".selectricOpen").css("z-index","9999");
		$(".selectricItems").css("display","block");
	});
	  
	$(document).on("click", ".selectricScroll li", function(){
		
		//
		$(".selectricScroll li").removeClass("selected");
		//클래스 추가
		$(this).addClass("selected");
		
		 let selectedValue = $(this).text();
		$("#selectric .label").text(selectedValue);
		$(".selectricInput").val(selectedValue);
		
		//alert(selectedValue);
		$(".selectricItems").css("display","none");
		
	});
	
	
	
	
	//카드 정보 입력 이벤트
	$(".box_inputForm span").click(function(){
		
		if($(this).text() == ''){
			$(this).find('label').css('display', 'block');
	  		$(this).find('input').css('display', 'none');
		}else{
			$(this).find('label').css('display', 'none');
	  		$(this).find('input').css('display', 'block');
		}
	});
	
	//
	$(".chk_purple").click(function() {
	  var isCheckedAll = $("input[name='agreeAll']").prop("checked");
	
	  if (isCheckedAll) {
	    $("input[name='agree']").prop("checked", true);
	  } else {
	    $("input[name='agree']").prop("checked", false);
	  }
	});
	
	//결제하기 클릭시 서브밋
	$("#stplCfmBtn").click(function(){
		var cardNum1 = $("#cardNum1").val();
		var cardNum2 = $("#cardNum2").val();
		var cardNum3 = $("#cardNum3").val();
		var cardNum4 = $("#cardNum4").val();
	
		if($("input[name='agree']:checked").length != 3){
			//alert("서비스 이용약관 동의를 체크해주세요");
			Swal.fire({
				text: "서비스 이용약관 동의를 체크해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($("#mail-check-warn").text() != "인증번호가 일치합니다." && $(".pass_user").css("display") != "none"){
			//alert("이메일 인증을 진행해주세요");
			Swal.fire({
				text: "이메일 인증을 진행해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($(".label").text() == "카드를 선택하세요"){
			//alert("카드를 선택해주세요");
			Swal.fire({
				text: "카드를 선택해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if(cardNum1 === "" || cardNum2 === "" || cardNum3 === "" || cardNum4 === ""){
			//alert("카드 번호를 입력해주세요");
			Swal.fire({
				text: "카드 번호를 입력해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($("#cardMonth").val() == ""){
			//alert("유효기간 월을 입력해주세요");
			Swal.fire({
				text: "유효기간 월을 입력해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($("#cardYear").val() == ""){
			//alert("유효기간 년을 입력해주세요");
			Swal.fire({
				text: "유효기간 년을 입력해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($("#cardPw").val() == ""){
			//alert("비밀번호을 입력해주세요");
			Swal.fire({
				text: "비밀번호을 입력해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else if($("#birthday").val() == ""){
			//alert("생년월일을 입력해주세요");
			Swal.fire({
				text: "생년월일을 입력해주세요.",
				width: 600,
				padding: '1.5em',
				confirmButtonColor: '#74b3c7',
				confirmButtonText: '확인'
			});
			return false;
		}else{
			purchaseForm.submit();
		}
	});
	
	
		//결제하기 클릭시 서브밋 - 예매변경
	$("#updatepay").click(function(){
		var cardNum1 = $("#cardNum1").val();
		var cardNum2 = $("#cardNum2").val();
		var cardNum3 = $("#cardNum3").val();
		var cardNum4 = $("#cardNum4").val();

	
		if($("input[name='agree']:checked").length != 3){
			alert("서비스 이용약관 동의를 체크해주세요");
			return false;
		}else if($(".label").text() == "카드를 선택하세요"){
			alert("카드를 선택해주세요");
			return false;
		}else if(cardNum1 === "" || cardNum2 === "" || cardNum3 === "" || cardNum4 === ""){
			alert("카드 번호를 입력해주세요");
			return false;
		}else if($("#cardMonth").val() == ""){
			alert("유효기간 월을 입력해주세요");
			return false;
		}else if($("#cardYear").val() == ""){
			alert("유효기간 년을 입력해주세요");
			return false;
		}else if($("#cardPw").val() == ""){
			alert("비밀번호을 입력해주세요");
			return false;
		}else if($("#birthday").val() == ""){
			alert("생년월일을 입력해주세요");
			return false;
		}else{
			purchaseForm.submit();
		}
	});
	
});