<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 리스트</title>
    <script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/js/min.js"></script>
	<script src="http://localhost:9000/js/am-pagination.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/css/min.css">
	<link rel="stylesheet" href="http://localhost:9000/css/am-pagination.css">

</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
		<div class="title-wrap notice">
			<jsp:include page="../header.jsp"></jsp:include>
			<h2 class="title">공지사항</h2>
		</div>
	<h3 class="title-notice">KTX 홈페이지의 새로운 소식을 확인하세요.</h3>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>