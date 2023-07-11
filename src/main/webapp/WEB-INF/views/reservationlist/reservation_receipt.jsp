<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/css/reservationlist.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/reservation_jquery.js"></script>
</head>
<body>
	<div class="print_wrap">
		<input type="hidden" name="recNcnt" id="recNcnt" value="1">
		<div class="print_head">
			<ul class="desc_list">
				<li>현재 페이지에서 출력하신 영수증으로 승차권 대신하여 탑승하실 수 없습니다.</li>
			</ul>
			<p class="btnBox">
			<button type="button" onclick="window.print();" class="print">
				<img src="http://localhost:9000/images/btn_print_blue.gif" alt="프린트버튼">
			</button>
			</p>
			<span class="bg_line01"><img src="http://localhost:9000/images/img_line_print.png" alt="라인"></span>
		</div>
		<div class="receiptWrap">
			<div class="head_top">
				<p class="tit_receipt">KTX 영수증<span>(카드)</span></p>
			</div>
			<div class="box_dot">
				<ul>
					<li>상호 : (주)중앙고속</li>
					<li>사업자 번호 : 219-81-01636</li>
				</ul>
				<span class="bg_dashed"><img src="http://localhost:9000/images/bg_dashed.png"></span>
			</div>
			<div class="box_dot">
				<ul>
					<li>카드사<span class="taR fr">BC</span></li>
					<li>카드번호<span class="taR fr">${ovo.cardnum}</span></li>
					<li>승인번호<span class="taR fr">${ovo.reservnum}</span></li>
					<li>승인일시<span class="taR fr">${ovo.rdate}</span></li>
					<li>승인금액<span class="taR fr">${ovo.price}원</span></li>
					<li>환불금액<span class="taR fr">0원</span></li>
					<li>취소수수료<span class="taR fr">0원</span></li>
					<li class="txt_strong">결제금액<span class="taR fr">${ovo.price}원</span></li>
				</ul>
				<span class="bg_dashed"><img src="http://localhost:9000/images/bg_dashed.png"></span>
			</div>
			<div class="box_row">
				<ul>
					<li>출발일 : ${ovo.depPlandTime}</li>
					<li>출발지 : ${ovo.sstation}</li>
					<li>도착지 : ${ovo.dstation}</li>
					<li>출발시간 : ${ovo.stime}</li>
					<li>일반매수 : ${ovo.ticketqty}</li>
				</ul>
			</div>
	</div>
	<p style="padding: 0 20px">※ 영수증은 승차권이 아닙니다. 이 영수증으로 승차권을 대신하여 탑승하실 수 없습니다.</p>
</div>
</body>
</html>