<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/css/train_reservation_satschc.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/chairupdate.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
$(document).ready(function(){
	/* $(".btn_selectSeat").click(function() {
		let sid = "${sessionScope.svo.id}";
		let seatNum = $("#seatNum").val();
		
		$(location).attr("href", 'http://localhost:9000/reservation_updateselect.do?seatNum='+seatNum+"&id="+sid);
	}); */
	
	$(".btn_selectSeat").click(function() {
		if($("#seatNum").text() == ""){
			//alert("좌석을 선택해주세요");
			Swal.fire({
	    		text: "좌석을 선택해주세요.",
	    		width: 600,
				padding: '1.5em',
	    		confirmButtonColor: '#74b3c7',
	    		confirmButtonText: '확인'
	    	});
		}else{
			
			let sid = "${sessionScope.svo.id}";
			let seatNum = $("#seatNum1").val();
			let ticketQty = $("#ticketQty1").val();
			
			if(sid == ""){
			  $(".modal").css("display", "block");
			  }else{
				  $(location).attr("href",'http://localhost:9000/reservation_updateselect.do?seatNum='+seatNum +"&ticketQty="+ticketQty+"&id="+sid );
			  }
		}
		
	  });
	
	
});	
	
</script>
<style>
.title_wrap { 
	background: url(http://localhost:9000/images/visual_chkTicket_bg.gif) center 0 no-repeat;
	background-size: cover;
	}

.box{
	/* border:1px solid red; */
	display:inline-block;
}
</style>
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
	<div id ="contentWrap">
	<div class="title_wrap in_process ticketingT">
		<jsp:include page="../header.jsp"></jsp:include>
	 	<h2>예매 변경</h2>
	</div>

	<div class="page" id="seatChcPage">
		<h3>매수 및 좌석선택</h3>
				
		<div class="selectSeat_wrap">
					<!-- compareBox -->
			<div class="compare_wrap">
						<!-- 좌측 infoBox -->
				<div class="infoBox">
					<p class="date" id="satsDeprDtm">${ sessionScope.uvo.rtimes }</p>
					
				
					<div class="route_wrap" id="satsRotInfo">
						<div class="inner">
							<p class="roundBox_start">출발</p>
							<p class="roundBox departure " id="satsDeprTmlNm"> ${ sessionScope.uvo.depplacename }</p><!-- 출발지 -->
							<p class="roundBox_end">도착</p>
							<p class="roundBox arrive " id="satsArvlTmlNm">${ sessionScope.uvo.arrplacename }</p><!-- 도착지 -->
						</div>
						<div class="detail_info">
							<span id="satsTakeDrtm">4시간 15분 소요</span>
						</div>
						<div class="btn_r">
							<a href="#" class="btn btn_modify white" id="back2">수정</a>
						</div>
					</div>
					
					<div class="route_wrap">
							<div class="tbl_type2">
								<table>
									<caption>
										<strong>버스 정보</strong>
										<p>고속사, 등급, 출발</p>
									</caption>
									<colgroup>
										<col style="width:66px;">
										<col style="width:*;">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row">차량</th>
											<td>ktx</td>
										</tr>
										<tr>
											<th scope="row">열차번호</th>
											<td>${ sessionScope.uvo.trainno }</td>
										</tr>
										<tr>
											<th scope="row">출발</th>
											<td>${ sessionScope.uvo.start_date }</td>
										</tr>
									</tbody>
								</table>
								<div class="btn_r mob_pad ">
									<a href="#" class="btn btn_modify white" id="back1">수정</a>
								</div>
							</div>
						</div>
				</div>
						<!-- //좌측 infoBox -->
											
				<!-- 우측 detailBox -->
				<div class="detailBox">
					<span class="dimm" style="display: none;">
						<span class="txt_check">예매하실 매수를 먼저 선택하신 후<br>좌석을 선택해 주세요.</span>
						<a href="" class="btnS btn_normal">확인</a>
					</span>
					
					<div class="detailBox_head" style="height: 66px;">
						<div class="box_refresh">
							<button type="button" class="btn btn_refresh" onclick="fnReload();">
								<span class="ico_refresh">새로고침</span>
							</button>
						</div>							
						<div class="count_seat">
							<div class="inner">
								<div class="box_count">
									<span class="count_num"></span>
								</div>
							</div>
						</div>
					</div>
							
						
				<div class="detailBox_body">
					<div class="ticketBox ">
						<ul class="sel_list">
							<li>
								<div class="countBox">
									<p class="division">
										<em>일반</em>
										<span class="text_num count" id="adltCnt">1</span>
									</p>
								<div class="btn_wrap">
										<ul>
											<li>
												<button type="button" class="btn adult_add">
													<span class="ico_plus">증가</span>
												</button>
											</li>
											
											<li>
												<button type="button" class="btn adult_minus">
													<span class="ico_minus">감소</span>
												</button>
											</li>
										</ul>
									</div>
								</div>
							</li>
							<li>
								<div class="countBox">
									<p class="division">
										<span class="text_num count" id="chldCnt">1</span>
										<em>호차</em>
									</p>
									<div class="btn_wrap">
										<ul>
											<li>
												<button type="button" class="btn Kind_add" id="Kind_add">
													<span class="ico_plus">증가</span>
												</button>
											</li>
											
											<li>
												<button type="button" class="btn Kind_minus" id="Kind_minus">
													<span class="ico_minus">감소</span>
												</button>
											</li>
										</ul>
									</div>
								</div>
							</li>
						</ul>
					</div>			
									
								
					<div class="selectSeat_box">
						<div class="bg_seatBox seat28 " style="display:block;">
							<div class="seatList">
								<!-- 좌석 선택 위치 -->
								
							</div>
							
							
							
						</div>
					</div>
					<!-- //좌석선택 -->
				</div>
				</div>
			</div>
			<!-- //우측 detailBox -->
		
					<!-- //compareBox -->
					<!-- 선택좌석 상세보기 -->
					<div class="selectSeat_detail">
						<div class="box_tbl">
							<!-- 선택좌석 -->
							<section class="box_detail">
								<div class="box_title">
									<strong class="txt_tit">선택좌석</strong>
								</div>
								<div>
								<span id="seatNum" id="selectedSeatCount"></span>
								</div>
								<div>
									<form name="updateseatForm" id="updateseatForm" action="reservation_updatepay.do" method="post">
										<input type="hidden" name="seatNum" id="seatNum1">
										<input type="hidden" name="ticketQty" id ="ticketQty1">
										<input type="hidden" name="ticketQty" id ="ticketQty1" value=" ${sessionScope.svo.id }">
									</form>
								</div>
							</section>
							<!-- //선택좌석 -->
							<!-- 탑승인원 및 요금 -->
							<section class="box_detail">
								<div class="tbl_type3">
									<table class="taR">
										<caption>
											<strong>탑승인원 및 요금</strong>
											<p>결제금액, 취소 수수료(예상), 반환금액</p>
										</caption>
										<colgroup>
											<col style="width:115px;">
											<col style="width:*;">
										</colgroup>
										<tbody>
											<tr>
												<th scope="row" class="txt_black">탑승인원</th>
												<td id="passengersNum"></td>
											</tr>
										
											<tr>
												<th scope="row">성인 <span id="adltSeatCnt"></span></th>
												<td id="adltTotAmt">${ sessionScope.uvo.adultcharge }</td>
											</tr>
											
										</tbody>
									</table>
								</div>
							</section>
							<!-- //탑승인원 및 요금 -->
						</div>
						<!-- 할인선택 -->
						<div class="box_tbl">
							<section class="box_detail total_price "> <!-- 총 결재금액일 시 class="total_price" 추가 -->
								<div class="box_title">
									<strong class="txt_tit">총 결제금액</strong>
									<span class="sel_price" id="allTotAmtLocD">${ sessionScope.uvo.adultcharge }원</span>
								</div>
							</section>
							<!-- //총 결제금액 -->
						</div>
					</div>
					
					<!-- //선택좌석 상세보기 -->
					<div class=" btns btn_selectSeat">
						<a href="#" id="satsChcCfmBtn" class="btnL btn_confirm ready">선택완료</a>
					</div>
				
				</div>
					<!-- 상세설명 -->
				<ul class="desc_list">
					<li>일부 좌석의 경우 실제 배치와 다를 수 있습니다.</li>
				</ul>
					<!-- //상세설명 -->
			
			
			</div>
				<jsp:include page="../footer.jsp"></jsp:include>	
		</div>
			
			
	<!-- <div id="myModal" class="modal">
		<div class="remodal w590 popLogin full remodal-is-initialized plogin remodal-is-opened" data-remodal-id="popLogin" data-remodal-options="closeOnOutsideClick: false, modifier: plogin" role="dialog" tabindex="-1">
		<div class="loading pop" id="loading" style="height: 1236px; top: 180px;"><p class="load" style="margin-left: 57px;"></p></div>
			<div class="title type_blue">
				로그인
				<span class="modalclose"></span>
			</div>
		<form id="lgnUsrInfForm" name="lgnUsrInfForm">
			<div class="cont">
				<div class="login_wrap pop">
					<div class="box_login">
						<h3 class="pop_h3 mob_h3">회원 로그인</h3>
						<p class="h3_desc">회원으로 예매하시면 예매 후 아이디/비밀번호로 간편하게 조회가 가능합니다.</p>
						<div class="inner">
							<fieldset>
								<legend>회원로그인</legend>
								<ul class="loginList">
									<li>
										<div class="box_inputForm">
											<strong>아이디</strong>
											<span class="box_label">
												<label for="">아이디를 입력하세요</label>
												<input type="text" name="usrId" id="usrId" class="input" onkeyup="">
											</span>
										</div>
									</li>
									<li>
										<div class="box_inputForm">
											<strong>비밀번호</strong>
											<span class="box_label">
												<label for="usrPwd">비밀번호를 입력하세요</label>
												<input type="password" name="usrPwd" id="usrPwd" class="input" onkeyup="" data-tk-kbdtype="qwerty" onfocus="">
											</span>
										</div>
									</li>
								</ul>
							</fieldset>
							<input type="hidden" id="popUpDvs" name="popUpDvs" value="Y">
							<p class="btn_squareBox">
								<button type="button" class="btn_confirm ready" id="btn_confirm_update">로그인</button>
							</p>
							
							
							
							<div class="box_searchId col2">
								<a href=""><span class="ico_searchId">아이디찾기</span></a>
								<a href=""><span class="ico_searchPW">비밀번호찾기</span></a>
							</div>
						</div>
					</div>
					<div class="box_login non-member">
						<div class="inner">
							<h3 class="pop_h3 mob_h3">비회원 예매</h3>
							<p class="h3_desc">비회원 예매 시 일부 서비스 이용이 제한됩니다.</p>
							<p class="btn_squareBox">
								<button type="button" class="btn_normal btn_" id="btn_nonmember_update">비회원 예매</button>
							</p>
							
						</div>
					</div>			
				</div>
			</div>
		</form>		
		</div>
	</div> -->
	
</div>
</body>
</html>