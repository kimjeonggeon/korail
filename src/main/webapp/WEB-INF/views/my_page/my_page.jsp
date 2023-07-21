<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매 - 마이페이지</title>
<link rel="styleSheet" href="http://localhost:9000/css/layout.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script>

	let c_pass = "${c_pass}";
	let c_pnum = "${c_pnum}";

	$(".adtnPrdPT").click(function() {
		var url = "http://localhost:9000/mypage_receipt";
		window.location.href = url;
	});

	if (c_pass == "ok") {
		alert("비밀번호 변경 완료");
		var url = "http://localhost:9000/mypage";
		$(location).attr('href', url);
	}
	if (c_pnum == "ok") {
		alert("휴대폰번호 변경 완료");
		var url = "http://localhost:9000/mypage";
		$(location).attr('href', url);
	} else if (c_pnum == "fail") {
		alert("변경 실패");
	}

	$(document).ready(function() {

		$("#usrPw4").on("input", function() {
			  let pass = "${sessionScope.memberPass}";
			  let currentPassword = $(this).val().trim();

			  if (currentPassword == pass) {
			    $("#cmsg2").text("비밀번호 확인 완료")
			      .css("color", "green").css("font-size", "11px").css("display", "block");
			  } else {
			    $("#cmsg2").text("잘못된 비밀번호")
			      .css("color", "red").css("font-size", "11px").css("display", "block");
			  }
			});


		$("#usrPw5").on("input", function() {
		    if (this.value.length !== 11) {
		        $("#cmsg8").text("잘못된 휴대폰 번호")
		            .css("color", "red").css("font-size", "11px").css("display", "block");
		    } else {
		        $("#cmsg8").text("변경된 번호 확인 완료")
		            .css("color", "green").css("font-size", "11px").css("display", "block");
		    }
		});

		$("#with-confirm").click(function() {
			let pass = "${sessionScope.memberPass}";
			if($("#usrPw").val().trim() == pass) {
				withForm.submit();
			} else {
		    	$("#cmsg7").text("잘못된 비밀번호")
                .css("color", "red").css("font-size", "11px").css("display", "block");
		        $("#usrPw1").focus();
			}
		});

		/**
		 * 마이페이지 비밀번호 변경완료
		 */
		 $("#usrPw1").on("input", function() {
			  // 이벤트 처리 로직 작성
			  let pass = "${sessionScope.memberPass}";
			  let currentPassword = $(this).val().trim();

			  // 변경된 값에 따라 원하는 동작 수행
			  if (currentPassword !== "") {
				  if(currentPassword == pass) {
	 			    	$("#cmsg4").text("동일한 비밀번호")
	 	                .css("color", "green").css("font-size", "11px").css("display", "block");
	 			        $("#usrPw2").focus();
	 		    	} else {
	 			    	$("#cmsg4").text("잘못된 비밀번호")
	 	                .css("color", "red").css("font-size", "11px").css("display", "block");
	 			        $("#usrPw1").focus();
 		    	}
				  }
		});

		 $("#usrPw2").on("input", function() {
			 let pass = "${sessionScope.memberPass}";
			 let currentPassword = $(this).val().trim();
			 let passwordPattern = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$/;

			 if (!passwordPattern.test(currentPassword)) {
			    $("#cmsg5").text("영문, 숫자 8자리 이상의 새 비밀번호를 입력하세요.")
			        .css("color", "red").css("font-size", "11px").css("display", "block");
			    $("#usrPw2").focus();
			} else if (currentPassword == pass) {
			    $("#cmsg5").text("전과 동일한 비밀번호")
			        .css("color", "red").css("font-size", "11px").css("display", "block");
			    $("#usrPw2").focus();
			} else {
			    $("#cmsg5").text("새 비밀번호 입력 완료.")
			        .css("color", "green").css("font-size", "11px").css("display", "block");
			}

		 });

		 $("#usrPw3").on("input", function() {
			 let pass = "${sessionScope.memberPass}";
			 let currentPassword = $(this).val().trim();

			 if (currentPassword != $("#usrPw2").val()){
	    		$("#cmsg6").text("새 비밀번호가 일치하지 않습니다.")
                .css("color", "red").css("font-size", "11px").css("display", "block");
			 } else if (currentPassword == $("#usrPw2").val()) {

				 if(currentPassword == pass) {
		    		$("#cmsg6").text("전과 동일한 비밀번호")
	                .css("color", "red").css("font-size", "11px").css("display", "block");
				 } else {
		    	$("#cmsg6").text("동일한 비밀번호")
                .css("color", "green").css("font-size", "11px").css("display", "block")
				 }
			 }
		});

		 $("#pass-confimr").click(function() {
			 if ($("#cmsg4").css("color") === "rgb(0, 128, 0)" && $("#cmsg5").css("color") === "rgb(0, 128, 0)" && $("#cmsg6").css("color") === "rgb(0, 128, 0)") {
				  passForm.submit();
				}
		 });
		 $("#phone-confirm").click(function() {
		 	if($("#cmsg2").css("color") === "rgb(0, 128, 0)" && $("#usrPw5").val().length == 11) {
		 		phonenumForm.submit();
		 	}
		 });
	});

</script>
</head>
<body class="sub KO">
	<div id="wrap">
		<jsp:include page="../gnb2.jsp"></jsp:include>
		<div id="contentWrap">
			<div class="dimmed" style="display: none;"></div>
			<div id="contents" style="padding-top: 0px;">
				<jsp:include page="../header/header_mypage.jsp"></jsp:include>
				<div class="page">
					<div class="myAccount">
						<ul>
							<li><strong>계정정보</strong> <span class="detail"
								id="mbrsEmail">${sessionScope.memberId}</span>
								<div class="btnBox">
									<a class="btn btn_sm_link_blue" id="pass">비밀번호 변경</a> <a
										class="btn btn_sm_link_blue" id="with">회원탈퇴</a>
								</div></li>
							<li><strong>휴대폰번호</strong> <span class="detail" id="phone">${sessionScope.memberPnumber}</span>
								<div class="btnBox">
									<a class="btn btn_sm_link_blue" id="phonech">휴대폰번호 변경</a>
								</div></li>
						</ul>
						<jsp:include page="../my_page/mypage_modal.jsp"></jsp:include>
					</div>
				</div>
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
    <script>
		$(".mileage").click(function () {
			var dataToSend = "${memberId}";
			alert("header : " + dataToSend);

			// 사용자 동작에 의한 창 생성
			var newWindow = window.open('mileage', '마일리지 모달', 'width=900, height=500');

			// 새 창이 성공적으로 열렸을 때에만 postMessage 호출
			newWindow.onload = function () {
				newWindow.postMessage(dataToSend, "http://localhost:9000/mileage");
			};
		});
    </script>
</body>
</html>