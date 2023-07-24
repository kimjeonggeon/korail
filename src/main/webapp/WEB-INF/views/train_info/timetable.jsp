<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>기차 시간표</title>
<link rel="stylesheet" href="http://localhost:9000/css/min.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/ktx_getJson.js"></script>

<style>
	#d2{
		margin-bottom: 70px;
	}
</style>
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
		<div>
			<span class="start_span">출발지</span>
			<select id="start_city"></select>
			<select id="start_train"></select>
		</div>
		<div>
			<span class="end_span">도착지</span>
			<select id="end_city"></select>
			<select id="end_train"></select>
		</div>
	
		<input type="text" name="traintime" placeholder="날짜입력 예)20200701" id="traintime">
		<button type="button" id="btnsearch">조회</button>
		<input type="hidden" id="start">
		<input type="hidden" id="end">
	</div>
		
	<jsp:include page="../footer.jsp"></jsp:include>
</div>
</body>
</html>