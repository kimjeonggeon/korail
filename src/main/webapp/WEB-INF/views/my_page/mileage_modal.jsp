<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>고속버스
        통합예매 - 나의 마일리지</title>
    <link rel="stylesheet" href="http://localhost:9000/css/mileage.css">
    <link rel="stylesheet" href="http://localhost:9000/css/am-pagination.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="http://localhost:9000/js/am-pagination.js"></script>
</head>
<body>
<div class="content">
    <section class="board">
        <h1 class="title">마일리지 내역
            <p class="p_text">마일리지는 적립일로부터 5년 후 만료됩니다.</p>
        </h1>
    </section>
</div>
<script>
    window.addEventListener('message', function(event) {
        memberId = event.data;

        initAjax(1, memberId);
        function initAjax(page, memberId) {
            $.ajax({
                url: "mileage_list_json_data/" + page + "/" + memberId + "/", success: function (result) {
                    let output = "<table class='board_list'>";
                    output += "<tr class='tr'><th>날짜</th><th>차감액</th><th>내역</th><th>적용 시작일</th></tr>";

                    let changeAmount = 0;

                    for (let i = result.list.length - 1; i >= 0; i--) {
                        const obj = result.list[i];
                        output += "<tr class='tr'>";
                        output += "<td>" + obj.accumulationDate + "</td>";

                        let fontColor = ""
                        if(obj.type == 2) {
                            fontColor = "style='color:#5dbd5d;'";
                            changeAmount -= obj.changeAmount;
                        } else if (obj.type == 1) {
                            fontColor = "style='color:red'";
                            changeAmount += obj.changeAmount;
                        }

                        output += "<td class='changeAmount'" + fontColor + ">" +
                            (obj.type ===2 ? "(" + obj.changeAmount + ")" : obj.changeAmount) + "</td>";

                        output += "<td>" + obj.specifics + "</td>";
                        if (obj.depplandTime == null) {
                            obj.depplandTime = "";
                        }
                        output += "<td>" + obj.depplandTime + "</td>";
                        output += "</tr>";
                    }


                    output += "<tr>";
                    output += "<td colspan='5'><div id='ampaginationsm'></td>";
                    output += "</tr>";
                    output += "</table>";

                    $("table.board_list").remove();
                    $("h1").after(output);

                    //페이징 처리 함수 호출
                    pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage, memberId);
                    //페이지 번호 클릭 이벤트 처리
                    jQuery('#ampaginationsm').on('am.pagination.change', function (e) {
                        jQuery('.showlabelsm').text('The selected page no: ' + e.page);
                        initAjax(e.page, memberId);
                    });
                }
            });
        }

        function pager(totals, maxSize, pageSize, page, memberId) {

            var pager = jQuery('#ampaginationsm').pagination({

                maxSize: maxSize,	    		// max page size
                totals: totals,	// total pages
                page: page,		// initial page
                pageSize: pageSize,			// max number items per page

                // custom labels
                lastText: '&raquo;&raquo;', firstText: '&laquo;&laquo;', prevText: '&laquo;', nextText: '&raquo;',

                btnSize: 'sm'	// 'sm'  or 'lg'
            });
        }
    })
</script>
</body>
</html>