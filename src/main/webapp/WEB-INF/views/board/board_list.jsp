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
        <h3 class="title">게시판</h3>
        <table class="board_list">
          <tr>
            <td colspan="5">
              <a href="board_write">
                <button type="button" class="btn_style2">글쓰기</button>
              </a>
            </td>
          </tr>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>작성자</th>
            <th>작성일자</th>
          </tr>
          <%--<c:forEach var="boardDto" items="${list}">--%>
            <tr>
              <td>${boardDto.rno}</td>
              <td><a href="/board_content/${boardDto.bid}/${page.reqPage}">${boardDto.btitle}</a></td>
              <td>${boardDto.bhits }</td>
              <td>${boardDto.id }</td>
              <td>${boardDto.bdate }</td>
            </tr>
          <%--</c:forEach>--%>
          <tr>
            <!-- <td colspan="5"><< 1  2  3  4  5 >></td> -->
            <td colspan="5"><div id="ampaginationsm"></div></td>
          </tr>
        </table>
      </section>
      </div>

    <jsp:include page="../footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>
