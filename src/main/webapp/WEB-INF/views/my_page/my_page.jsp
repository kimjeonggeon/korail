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
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
	} else if (c_pass == "noop") {
		alert("비밀번호 변경 실패");
		var url = "http://localhost:9000/mypage";
        $(location).attr('href', url);
	}

	if (c_pnum == "ok") {
		alert("휴대폰번호 변경 완료");
		var url = "http://localhost:9000/mypage";
		$(location).attr('href', url);
	} else if (c_pnum == "noop") {
		alert("휴대폰번호 변경 실패");
        var url = "http://localhost:9000/mypage";
        $(location).attr('href', url);
	}

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
		let newWindow;
		$(".mileage").click(function () {
			var dataToSend = "${memberId}";

			if (newWindow && !newWindow.closed) {
				newWindow.close(); // 이미 열려있는 창이 있다면 닫기
			}

			// 사용자 동작에 의한 창 생성
			newWindow = window.open('mileage', '마일리지 모달', 'width=900, height=500');

			// 새 창이 성공적으로 열렸을 때에만 postMessage 호출
			newWindow.onload = function () {
				newWindow.postMessage(dataToSend, "http://localhost:9000/mileage");
			};
		});
    </script>
</body>
</html>