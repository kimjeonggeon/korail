<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-07-24
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://localhost:9000/css/board.css">
    <script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
    <title>Title</title>
</head>
<body>
<jsp:include page="../gnb.jsp"></jsp:include>
<div id ="contentWrap">
    <div class="title_wrap in_process route_chk ticketingT">

        <jsp:include page="../header.jsp"></jsp:include>

        <h2>게시판</h2>

    </div>
    <div class="page page_payment depth3">
        <div class="content">
            <section class="board">

                <table class="board_content">
                    <tr>
                        <th>제목</th>
                        <td>${boardDto.btitle}</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>${boardDto.bcontent }<br><br><br>
                            <c:if test="${boardDto.bsfile != null}">
                                <img src="http://localhost:9000/upload/${boardDto.bsfile}">
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>조회수</th>
                        <td>${boardDto.bhits}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>${boardDto.id }</td>
                    </tr>
                    <tr>
                        <th>작성일자</th>
                        <td>${boardDto.bdate }</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/board_update/${bvo.bid}">
                                <button type="button" class="btn_style">수정하기</button></a>
                            <a href="/board_delete/${bvo.bid}">
                                <button type="button" class="btn_style">삭제하기</button></a>
                            <a href="/board_list/${page}">
                                <button type="button" class="btn_style">리스트</button></a>
                            <a href="http://localhost:9000/">
                                <button type="button" class="btn_style">홈으로</button></a>
                        </td>
                    </tr>
                </table>
            </section>
        </div>

        <jsp:include page="../footer.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
