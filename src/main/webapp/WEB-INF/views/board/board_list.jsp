<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-07-24
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="http://localhost:9000/css/board.css">
  <link rel="stylesheet" href="http://localhost:9000/css/am-pagination.css">
  <script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
  <script src="http://localhost:9000/js/board.js"></script>
  <script src="http://localhost:9000/js/am-pagination.js"></script>
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
        </section>
      </div>
    </div>

    <jsp:include page="../footer.jsp"></jsp:include>
</div>
</body>
</html>
