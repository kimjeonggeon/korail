<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KTX 통합 예매</title>
<link rel="stylesheet" href="http://localhost:9000/css/reservationlist.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/reservation_jquery.js"></script>
	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.3.0/kakao.min.js"
			integrity="sha384-70k0rrouSYPWJt7q9rSTKpiTfX6USlMYjZUtr1Du+9o4cGvhPAWxngdtVZDdErlh" crossorigin="anonymous"></script>
	<script>
		Kakao.init('b6403c52c67005231281f3087ceac09b'); // 사용하려는 앱의 JavaScript 키 입력
	</script>
	<script>
		// NAVER
		function shareNaver() {
			const title = "영수증 출력";
			const url = "http://localhost:9000/reservation_receipt/${odt.reservnum}";
			window.open(
					"https://share.naver.com/web/shareView?url=" + url + "&title=" + title
			);
		}
	</script>

	<style>
		.share_btn{
			margin-top: 20px;
		}
		.desc_list li:before, p.bul:before{
			background-color: white;
		}
		.share_btn, .share_ul, .share_li{float: left; cursor:pointer;}
		.share_ul{
			margin: 20px 10px;
		}
		.share_btn:hover{

		}
	</style>
</head>
<body>
	<div class="print_wrap">
		<input type="hidden" name="recNcnt" id="recNcnt" value="1">
		<div class="print_head">
			<ul class="desc_list">
				<li>현재 페이지에서 출력하신 영수증으로 승차권 대신하여 탑승하실 수 없습니다.</li>
				<li class="share_btn"><img class="share_img" src="http://localhost:9000/images/share_click.png" style="width: 30px;"></li>
					<ul class="share_ul" style="display: none;" >
						<li class="share_li">
							<span>
								<script type="text/javascript" src="https://ssl.pstatic.net/share/js/naver_sharebutton.js"></script>
								<script type="text/javascript">
								new ShareNaver.makeButton({"type": "c"});
								</script>
							</span>
						</li>
						<li class="share_li">
							<a id="kakaotalk-sharing-btn" href="javascript:;" >
								<img src="https://developers.kakao.com/assets/img/about/logos/kakaotalksharing/kakaotalk_sharing_btn_medium.png" style="width: 25px;"
									 alt="카카오톡 공유 보내기 버튼" />
							</a>
							<script>
								Kakao.Share.createScrapButton({
									container: '#kakaotalk-sharing-btn',
									requestUrl: 'http://localhost:9000/reservation_receipt/${odt.reservnum}'
								});

								Kakao.Link.createDefaultButton({
									container:".kakao-link",
									objectType:"feed",
									content:{
										title:"KTX 영수증",
										description:"모바일에서는 확인이 불가합니다.",
										link:{
											webUrl:"http://localhost:9000/reservation_receipt/${odt.reservnum}"
										},
									},
								});
							</script>

						</li>
					</ul>
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
					<li>상호 : KORAIL</li>
					<li>사업자 번호 : 212-82-01635</li>
				</ul>
				<span class="bg_dashed"><img src="http://localhost:9000/images/bg_dashed.png"></span>
			</div>
			<div class="box_dot">
				<ul>
					<li>카드사<span class="taR fr">${odt.cardcomp}</span></li>
					<li>카드번호<span class="taR fr">${odt.cardnum}</span></li>
					<li>승인번호<span class="taR fr">${odt.recognizenum}</span></li>
					<li>승인일시<span class="taR fr">${odt.rdate}</span></li>
					<li>승인금액<span class="taR fr">${odt.price}원</span></li>
					<li>환불금액<span class="taR fr">0원</span></li>
					<li>취소수수료<span class="taR fr">0원</span></li>
					<li class="txt_strong">결제금액<span class="taR fr">${odt.price}원</span></li>
				</ul>
				<span class="bg_dashed"><img src="http://localhost:9000/images/bg_dashed.png"></span>
			</div>
			<div class="box_row">
				<ul>
					<li>출발일 : ${odt.depPlandTime}</li>
					<li>출발지 : ${odt.sstation}</li>
					<li>도착지 : ${odt.dstation}</li>
					<li>출발시간 : ${odt.stime}</li>
					<li>일반매수 : ${odt.ticketqty}</li>
				</ul>
			</div>
		</div>
		<p style="padding: 0 20px">※ 영수증은 승차권이 아닙니다. 이 영수증으로 승차권을 대신하여 탑승하실 수 없습니다.</p>
	</div>
</body>
</html>