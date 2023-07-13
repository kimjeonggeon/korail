<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/css/reservationlist.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/reservation_jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
	.hidden-span {
            display: none;
        }
</style>
</head>
<body>
<div>
	<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
	<div class="title_wrap_checkTicketingT">
		<div class="title_wrap">
			<jsp:include page="../header.jsp"></jsp:include>
			<h2>예매확인/취소/변경</h2>
		</div>
	</div>
	
	<!------------------------ 메뉴바 ---------------------------->
	<!-- <div class="breadcrumb">
		<ul class="breadcrumb_list">
			<li><a href="/main.do">HOME</a></li>
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/rotinf.do">고속버스예매</option>
								<option value="/mrs/mrscfm.do" selected="selected">예매확인</option>
								<option value="/oprninf/alcninqr/oprnAlcnPage.do">운행정보</option>
								<option value="/ugd/mrsgd/Mrsgd.do">이용안내</option>
								<option value="/cscn/ntcmttr/readNtcList.do">공지사항</option>
							</select>
						</div>
						 <div class="selectric">
							<p class="label">예매확인</p>
							<b class="button">▾</b>
						</div> -->
						<!-- <div class="selectricItems" tabindex="-1">
							<div class="selectricScroll">
								<ul>
									<li class="">고속버스예매</li>
									<li class="selected">예매확인</li>
									<li class="">운행정보</li>
									<li class="">고속버스 프리패스/정기권</li>
									<li class="">이용안내</li>
									<li class="">공지사항</li>
									<li class="">고객센터</li>
									<li class="">전국고속버스운송사업조합</li>
									<li class="last">터미널사업자협회</li>
								</ul>
							</div>
						</div>
						<input class="selectricInput" tabindex="0"> 
					</div>
				</div>
			</li>
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/mrscfm.do" selected="selected">예매 확인/취소/변경</option>
								<option value="/mrs/mrsrecplist.do">영수증 발행</option>
							</select>
						</div>
						<div class="selectric">
							<p class="label">예매 확인/취소/변경</p>
							<b class="button">▾</b>
						</div>
							<div class="selectricItems" tabindex="-1">
							<div class="selectricScroll">
								<ul>
									<li class="selected">예매 확인/취소/변경</li>
									<li class="last">영수증 발행</li>
								</ul>
							</div>
						</div>
						<input class="selectricInput" tabindex="0">
					</div>
				</div>
			</li>
		</ul>
	</div> -->
	<!------------------------ 예매확인하기 ---------------------------->
	<div class="page">
	<div class="tab_type1">
		<!------------------------ 예매내역/취소내역 버튼 ---------------------------->
		<ul class="tabs">
			<li class="active"><a href="#" class="reserv_btn">예매내역</a></li>
			<li><a href="#" class="cancel_btn">취소내역</a></li>
		</ul>
			
		<!------------------------ 예매내역 ---------------------------->
			<div id="reserv">
			
			<section class="detail_info_wrap homeTicket marT30 ">
				<!-- cancel 수량 계산 -->
				<c:set var="reservCount" value="0" />
				
				<c:forEach var="ovo" items="${orderList}">
				    <c:if test="${ovo.cancel == 0}">
				        <c:set var="reservCount" value="${reservCount + 1}" />
				    </c:if>
				</c:forEach>
				
				<%-- <!-- reservCount 변수의 값 출력 test -->
				${reservCount} --%>
				
				<!-- 최근 예매 내역이 없는 경우 -->
				<c:if test="${empty orderList or reservCount == 0}"> 
					<span class="spanText">최근 예매 내역이 없습니다.</span>
				</c:if>
				
				
				
				<!-- 최근 예매 내역이 있는 경우 -->
				<c:forEach var="ovo" items="${orderList}">	
				
				<c:if test="${not empty ovo and ovo.cancel == 0 }">	
					     
				<div class="box_detail_info" id="${ovo.reservnum}">
					<div class="routeHead">
						<p class="date" id="depPlandTime">${ovo.depPlandTime}</p>
						<p class="stime" id="stime">${ovo.stime}  출발</p>
						<p class="ticketPrice">총 결제금액
							<span class="price" id="price">${ovo.price}원</span>
							<span class="txt_div">(카드)</span>
						</p>
					</div>
					<div class="routeBody">
						<div class="routeArea route_wrap">
							<div class="inner">
								<span class="roundBox_start">출발</span>
								<span class="roundBox departure" id="sstation">${ovo.sstation}</span>
								<span class="roundBox_end">도착</span>
								<span class="roundBox arrive" id="dstation">${ovo.dstation}</span>
							</div>
							<div class="detail_info">
								<!-- <span id="runtime">소요</span> --> <!-- 예상소요시간 -->
							</div>
						</div>
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type2">
								<table class="tbl_info">
									<!-- <caption>
										<strong>버스 정보</strong>
										<p>고속사, 등급, 출발</p>
									</caption> -->
									<colgroup>
										<col style="width:68px;">

									</colgroup>
									<tbody class="reservMainTable">
										<tr>
											<th scope="row">예매번호</th>
											<td id="reservnum">${ovo.reservnum}</td>
										</tr>
										<tr>
											<th scope="row">차량</th>
											<td>
												ktx<span class="jabus ico_bus"></span>
											</td>
										</tr>
										<tr>
											<th scope="row">열차번호</th>
											<td id="trainnum">${ovo.trainnum}</td>
										</tr>
										<tr>
											<th scope="row">매수</th>
											<td id="ticketqty">${ovo.ticketqty}명 </td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				
					<!-- 좌석상세내역 -->
					<!-- 전체검표완료 시 class="check_com" 추가-->
					<div class="seat_detail">
						<ul>
							<li class="seatL" style="border-top: none;">
								<span class="seatNum" id="chairnum">${ovo.chairnum}</span>
							</li>
						</ul>
						<span class="hidden-span" id="depPlaceId">${ovo.depPlaceId}</span>
						<span class="hidden-span" id="arrPlaceId">${ovo.arrPlaceId}</span>
					</div>
				</div>
				</c:if>
				</c:forEach>
			
					<div id="inputContainer">
						<input type="hidden" id="clickVal_depPlandTime" name="clickVal_depPlandTime" />
						<input type="hidden" id="clickVal_stime" name="clickVal_stime" />
						<input type="hidden" id="clickVal_price" name="clickVal_price" />
						<input type="hidden" id="clickVal_sstation" name="clickVal_sstation" />
						<input type="hidden" id="clickVal_dstation" name="clickVal_dstation" />
						<!-- <input type="hidden" id="clickVal_runtime" name="clickVal_runtime" /> -->
						<input type="hidden" id="clickVal_reservnum" name="clickVal_reservnum" />
						<input type="hidden" id="clickVal_trainnum" name="clickVal_trainnum" />
						<input type="hidden" id="clickVal_chairnum" name="clickVal_chairnum" />
						<input type="hidden" id="clickVal_depPlaceId" name="clickVal_depPlaceId" />
						<input type="hidden" id="clickVal_arrPlaceId" name="clickVal_arrPlaceId" />
						<input type="hidden" id="clickVal_ticketqty" name="clickVal_ticketqty" />
					</div>
				
					<p class="btns multi mainclfix col4">
				
						<a href="http://localhost:9000/reservation_update"  class="btnL btn_cancel" id="change_btn">예매변경</a>
						<a href="http://localhost:9000/reservation_receipt" target="_blank"  class="btnL btn_cancel" id="receipt_btn">영수증 발행</a>
						<a href="#" onclick="fnRecpCanInfo(0,'');" class="btnL btn_cancel" id="cancelReserv">예매취소</a>
						<a href="http://localhost:9000/reservation_hometicket" target="_blank"  class="btnL btn_confirm" id="hometicket_btn">홈티켓 발행</a>
					</p>
					
				
					<ul class="desc_list marT30">
						<li>과거 예매 내역은 <strong class="txt_puple">출발일 날짜 기준 당일</strong>까지, 예매 <strong class="txt_puple">취소 내역은 과거 3개월</strong>까지 조회 가능합니다.</li>
						<li><strong class="txt_puple">홈티켓으로 발권된 내역은 변경이 불가</strong>하니 변경을 원하시면 취소 후 다시 예매를 진행하시기 바랍니다.</li>
						<li>신용카드 예매 취소 또는 변경 시 일주일 내로 예매했던 카드로 청구 취소 처리가 되면서 반환됩니다.</li>
						<li><strong class="txt_puple">시간 변경은 취소 위약금을 부과하지 않습니다.</strong></li>
					</ul>
			</section>
			</div>
	</div>
			
	<!------------------------ 취소내역 ---------------------------->
		<div class="tab_conts" id="cancelList">
					
			<section class="detail_info_wrap homeTicket marT30">
				
				<c:set var="cancelCount" value="0" />
				<c:forEach var="ovo" items="${orderList}">
					<!-- cancel 수량 -->
					
				    <c:if test="${ovo.cancel == 1}">
				        <c:set var="cancelCount" value="${cancelCount + 1}" />
				    </c:if>
				
				</c:forEach>
				
				
				<!-- 예매 취소내역 없는경우 -->
				<c:if test="${empty orderList or cancelCount == 0}"> 
					<span class="spanText">최근 취소 내역이 없습니다.</span>
				</c:if>
								
				<c:forEach var="ovo" items="${orderList}">
				
				<!-- 예매 취소내역 있는경우 -->
				<c:if test="${not empty ovo and ovo.cancel == 1}">
				<div class="box_detail_info">
					<div class="routeHead">
						<p class="date txt_black">${ovo.depPlandTime}&nbsp;${ovo.stime}  출발</p>
						<p class="ticketPrice cancel">취소일시 
							<span class="txt_cancelDate">${ovo.cdate}</span>
						</p>
					</div>
					<div class="routeBody">
						<div class="routeArea route_wrap cancel_com">
							<div class="inner">
								<span class="roundBox_start">출발</span>
								<span class="roundBox departure">${ovo.sstation}</span>
								<span class="roundBox_end">도착</span>
								<span class="roundBox arrive">${ovo.dstation}</span>
							</div>
							<div class="detail_info">
								<!-- <span>소요</span> -->
							</div>
						</div>
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type2">
								<table class="taR">
									<!-- <caption>
										<strong>취소결제 정보</strong>
										<p>결제금, 취소 위약금, 총 반환 금액</p>
									</caption> -->
									<colgroup>
										<col style="width:100px;">

									</colgroup>
									<tbody>
										<tr>
											<th scope="row">결제금</th>
											<td>${ovo.price}원</td>
										</tr>
										<tr>
											<th scope="row">취소 위약금</th>
											<td>${ovo.price}원</td>
										</tr>
										<tr>
											<th scope="row">총 반환 금액</th>
											<td><strong>${ovo.price}원</strong></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				</c:if>
			</c:forEach>
			</section>
				<ul class="desc_list marT30">
					<li>과거 예매 내역은 <strong class="txt_puple">출발일 날짜 기준 당일</strong>까지, 예매 <strong class="txt_puple">취소 내역은 과거 3개월</strong>까지 조회 가능합니다.</li>
					<li><strong class="txt_puple">홈티켓으로 발권된 내역은 변경이 불가</strong>하니 변경을 원하시면 취소 후 다시 예매를 진행하시기 바랍니다.</li>
					<li>신용카드 예매 취소 또는 변경 시 일주일 내로 예매했던 카드로 청구 취소 처리가 되면서 반환됩니다.</li>
					<li><strong class="txt_puple">시간 변경은 취소 위약금을 부과하지 않습니다.</strong></li>
				</ul>
			</div>							
		</div>	
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</div>						
	<!------------------------ 취소버튼 클릭시 나오는 팝업창 ---------------------------->
	<div class="modal">
	<div class="remodal w680 popTicket_cancel remodal-is-initialized remodal-is-opened" id="popTicketCancel" role="dialog" tabindex="-1">
		<form id="modalForm" name="modalForm" action="reservation_main_proc.do" method="post">
													
			<!-- 팝업header -->
			<div class="pop">
			<div class="title type_blue">예매취소
				<span class="remodal-close" >
					<img src="http://localhost:9000/images/close_mobile.png">
				</span>
			</div>
			<!-- 팝업content -->
			<div class="cont">
				<div class="box_detail_info">
					<div class="routeHead">
						<p class="date" id="modal_date"></p>
					</div>
					<div class="routeBody">
						<div class="routeArea route_wrap">
							<div class="inner">
								<span class="roundBox_start">출발</span>
								<span class="roundBox departure" id="modal_sstation"></span>
								<span class="roundBox_end">도착</span>
								<span class="roundBox arrive" id="modal_dstation"></span>
							</div>
							<div class="detail_info">
								<span id="modal_runtime"></span>
							</div>
						</div>
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type2">
								<table><colgroup><col style="width:68px;"></colgroup>
									<tbody>
										<tr>
											<th scope="row">예매번호</th>
											<td id="modal_reservnum"></td>
										</tr>
										<tr>
											<th scope="row">차량번호</th>
											<td id="modal_trainnum"></td>
										</tr>
										<tr>
											<th scope="row">매수</th>
											<td id="modal_ticketqty"></td>
										</tr>
										<tr>
											<th scope="row">좌석</th>
											<td id="modal_chairnum"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="box_detail_info bgGray">
					<div class="routeArea route_wrap mob_route">
						<div class="tbl_type3">
							<table><colgroup><col style="width:80px;"></colgroup>
								<tbody>
									<tr>
										<th scope="row">결제일시</th>
										<td>2023.05.08</td>
									</tr>
									<tr>
										<th scope="row">결제수단</th>
										<td>카드</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="routeArea route_wrap mob_route">
						<div class="tbl_type3">
							<table class="taR"><colgroup><col style="width:135px;"></colgroup>
								<tbody>
									<tr>
										<th scope="row">결제금액</th>
										<td id="modal_price"></td>
									</tr>
										<tr><th scope="row">취소 수수료(예상)</th>
										<td>0원</td>
									</tr>
									<tr>
										<th scope="row">반환금액</th>
										<td id="modal_price2"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="mob_pad marT30">
					<h3 class="pop_h3 mob_h3">취소수수료</h3>
						<div class="tbl_type1">
							<table><colgroup><col style="width: 60%;"><col style="width: auto"></colgroup>
								<thead class="cancel_thead">
									<tr>
										<th scope="col">취소시기</th>
										<th scope="col" class="cancel_thead2">수수료</th>
									</tr>
								</thead>
								<tbody class="cancel_tbody">
									<tr>
										<td>예매 당일 또는 승차일 2일전 취소<br>(단, 당일출발차량 예매 후 1시간 이후 취소는 수수료 발생)</td>
										<td>없음</td>
									</tr>
									<tr>
										<td>예매 후 출발일 1일 전일부터 지정차 출발 1시간 전 취소<br>(단, 당일출발차량 예매 후 1시간 이내 취소는 수수료 없음)</td>
										<td>승차권 요금의 5%</td></tr>
									<tr>
										<td>예매 후 지정차 출발 1시간 이내 취소<br>(단, 당일출발차량 예매 후 1시간 이내 취소는 수수료 없음)</td>
										<td>승차권 요금의 10%</td></tr><tr><td>예매하신 지정차 출발 후 목적지 도착예정시간 전 취소</td>
										<td>승차권 요금의 30%</td></tr>
								</tbody>
							</table>
						</div>
					<ul class="desc_list">
						<li>취소수수료 산정은 날짜를 기준(시간 기준이 아님)으로 합니다.</li>
						<li>사용하지 않은 모든 승차권은 지정차 출발 후 도착 예정시간이 지나면 환불하실 수 없습니다.</li>
						<li>취소 수수료는 취소가 완료되는 시점을 기준으로 발행하니 유의하시기 바랍니다.</li>
						<li>왕복할인 적용 예매건의 편도 취소시 할인조건 적용제외로 인한 할인반환금이 추가 청구되니 유의하시기 바랍니다.</li>
						<li>할인승차권 취소 시 원요금(할인 전)기준으로 취소수수료가 부과됩니다.</li>
						<li>신용(체크)카드 환불은 카드사 정책에 따라 평일(은행영업일)기준 3~5일 소요될 수 있습니다.</li>
					</ul>
				</div>
			</div>
			<input type="hidden" id="modal_reservnum_input" name="modal_reservnum_input">
			<!-- 팝업 footer -->
			<div class="btns col1"><button type="button" class="btnL btn_orange" id="reservCancel">예매취소</button></div>
		</div>
		</form>
	</div>
	
	</div>
</body>
</html>