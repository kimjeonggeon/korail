<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세 내용</title>
	<script src="http://localhost:9000/js/min.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/css/min.css">
</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2 class="title_station">공지사항</h2>
	</div>
	<div class="notice_content">
	
		<p id="content_define">KTX 홈페이지의 새로운 소식을 확인하세요.</p>
		
		<div class="line2"></div>
		<div class="table_content"><p id="notice_table1">${noticeVo.ntitle}</p><p id="notice_table2">${noticeVo.ndate}</p></div>
		<div class="line2"></div>
		
		<p id="content_title">${noticeVo.ntitle}</p>
		
		<p id="content_content">${noticeVo.ncontent}</p>
		
		<div>
		<div class="line2"></div>
			
			<div class="button">
				<a href="http://localhost:9000/notice_list.do?category=all&cvalue=all&page=1" class="btn">리스트</a>
				<a href="http://localhost:9000/notice_content.do?nid=${nprev}" class="btn" id="click_before"><</a>
				<a href="http://localhost:9000/notice_content.do?nid=${nnext}" class="btn" id="click_after">></a>
				<input type="hidden" id="before_hidden" value="${nprev}">
				<input type="hidden" id="next_hidden" value="${nnext}">
			</div>
	</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>