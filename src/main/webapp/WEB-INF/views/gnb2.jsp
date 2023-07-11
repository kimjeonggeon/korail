<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gnb</title>
<link rel="styleSheet" type="text/css"
	href="http://localhost:9000/css/layout.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/t3_jsp_jquery.js"></script>
<style>
	.gnb_pc table img {
		width:60px;
		vertical-align: middle;
	}
	.gnb_pc table {
		margin-left: 15px;
		border-collapse: collapse;
		position: absolute;
   		top: 200%;
	}
	.gnb_pc table td{
		border: 1px solid #ddd;
	}
	
	
</style>
</head>
<body>
	<div id="gnb" class="gnb_pc">
		<h1 class="logo"
			style="margin-bottom: 0px; height: 133px; margin-top: 16px; padding-top: 28px;">
			<a href="http://localhost:9000">
			<img class="gnb_logo" src="http://localhost:9000/images/free-icon-train.png">KTX 통합 예매</a>
		</h1>
		<div id="menu">
			<ul class="depth1" style="padding-left: 30px;">
				<li><a
					href="http://localhost:9000/train_reservation_rotinf">예매</a></li>
				<li><a href="http://localhost:9000/reservation_main"
					class="">예매확인</a></li>

				<li><a class="depth2">운행정보</a>
					<ul class="depth2-1" style="padding-left: 2px; display: none;">
						<li><a href="http://localhost:9000/train_timetable">시간표
								조회</a></li>
						<li><a href="http://localhost:9000/train_route_info">기차역
								정보</a></li>
					</ul></li>
				<li><a class="depth3">이용안내</a>
					<ul class="depth3-1" style="padding-left: 2px; display: none;">
						<li><a href="http://localhost:9000/payment_info">결제
								안내</a></li>
						<li><a href="http://localhost:9000/refund_info">환불
								안내</a></li>
						<li><a href="http://localhost:9000/reservation_info">예매안내</a></li>
					</ul>

				<li><a class="depth4">회원정보관리</a>
					<ul class="depth4-1" style="padding-left: 2px; display: none;">
						<li><a href="mypage">나의정보수정</a></li>
						<li><a href="s_reservation">우대예약 등록</a></li>
						<li><a href="#">간편구매 정보 등록</a></li>
						<!-- 다자녀, 임신부, 기초생활수급자 -->
						<li><a href="mypage" onclick="bye(event)">회원탈퇴</a></li>
					</ul>
				
				<li><a href="http://localhost:9000/admin_main">공지사항</a></li>
			</ul>
		</div>

		
	</div>
</body>
</html>