<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 공지사항 수정</title>
	<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
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
	<h2 class="title">관리자 - 공지사항</h2>
	</div>
	<form id="form_update" name="updateForm" action="admin_notice_update_proc.do" method="post">
		<input type="hidden" name="nid" value="${noticeVo.nid}">
		<table class="notice_update">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="ntitle" id="notice_title" value="${noticeVo.ntitle}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="80" name="ncontent" id="notice_content">${noticeVo.ncontent}</textarea>
				</td>
			</tr>					
			<tr>
				<td colspan="2">
				<div class="button">
					<a id="btnSubmit_update" class="btn" >수정완료</a>
					<a id="btnAgain_update" class="btn" >다시쓰기</a>
					<a href="admin_notice_content.do?nid=${noticeVo.nid}" class="btn">이전페이지</a>
					<a href="admin_notice_list.do" class="btn">리스트</a>	
				</div>						
				</td>				
			</tr>
		</table>
	</form>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>