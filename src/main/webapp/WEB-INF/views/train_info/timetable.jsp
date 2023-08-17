<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>기차 시간표</title>
<link rel="stylesheet" href="http://localhost:9000/css/timetable.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/timetable.js"></script>

<style>
.title{
	font-size: 34px;
	color: #fff;
	text-align: center;
	margin: 0px;
	font-weight: bold;
}
</style>
<script>

</script>
</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
		<div class="train_timetable">
			<div class="title-wrap">
				<jsp:include page="../header.jsp"></jsp:include>
				<h2 class="title">기차 시간표</h2>
			</div>
		</div>
	<div id="trainList">
		<div class="start_div">
			<span class="start_span">출발지</span>
			<select id="start_city"></select>
			<select id="start_train"></select>
		</div>
		<div class="end_div">
			<span class="end_span">도착지</span>
			<select id="end_city"></select>
			<select id="end_train"></select>
		</div>
		<div class="tab_cont clear" style="width: 44.5%; margin: 10px 0 0 46px; display: inline-block;">
		<ul class="date">
			<li>
				<div class="date_picker_wrap" style="height: 108px;">
					<span class="name">가는날</span>
					<p class="text">
						<span class="text_date text_date1" id="starttime"></span>
						<input type="hidden" id="datepicker11" readonly="" class="hasDatepicker">
						<img class="ui-datepicker-trigger" src="http://localhost:9000/images/ico_calender.png" alt="달력" title="달력">
					</p>

				</div>
			</li>

			<li class="return">
				<div class="date_picker_wrap">
					<span class="name">오는날</span>
					<p class="text">
						<span class="text_date text_date2"></span>
						<input type="text" id="datepicker22" readonly="" class="hasDatepicker">
						<img class="ui-datepicker-trigger" src="http://localhost:9000/images/ico_calender.png" alt="달력" title="달력">
					</p>
				</div>
			</li>
		</ul>
		<jsp:include page="../reservcalender.jsp"></jsp:include>
		</div>
		<button type="button" id="btnsearch" style='cursor: pointer;'>조회</button>
		<input type="hidden" id="start">
		<input type="hidden" id="end">
		<input type="hidden" id="traintime">

	</div>

	<jsp:include page="../footer.jsp"></jsp:include>
</div>
</body>
</html>