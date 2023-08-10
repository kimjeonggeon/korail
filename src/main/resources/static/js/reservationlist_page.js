$(document).ready(function(){

    initAjax(1);//1페이지 호출 - 디폴트

    function initAjax(page){//ajax를 함수로 만들어서 호출해서 사용가능하도록 한다. / page=페이지 번호
        $.ajax({
            url : "/admin_reservationlist_json_data/"+page ,
            success : function(result){
                //alert(result);	//String으로 받았기때문에 문자인 상태
                //let jdata = JSON.parse(result);	//넘어온 데이터를 JSON으로 파싱하는 작업
                //alert(jdata.jlist[0].rno);	// Object object = JSON 객체

                //dhtml을 활용하여 테이블로 출력
                let output = "<table class='reservlist'>";
                output += "<tr class='admin_table_title'>";
                output += "<th>예매번호</th><th>예매자</th><th>출발역</th><th>도착역</th><th>출발일</th><th>출발시간</th><th>도착시간</th><th>예매일자</th></tr>";

                for (obj of result.list) {
                    if (obj.cancel == 0) {
                        output += "<tr>";
                        output += "<td>"+ obj.reservnum +"</td>";
                        output += "<td>"+ obj.id +"</td>";
                        output += "<td>"+ obj.sstation +"</td>";
                        output += "<td>"+ obj.dstation +"</td>";
                        output += "<td>"+ obj.depPlandTime +"</td>";
                        output += "<td>"+ obj.stime +"</td>";
                        output += "<td>"+ obj.dtime +"</td>";
                        output += "<td>"+ obj.rdate +"</td>";
                        output += "</tr>";
                    }
                }

                output += "<tr>"
                output += "<td colspan='8' class='paging'><div id='ampaginationsm' class='paging'></div></td>"
                output += "</tr>"
                output += "</table>"

                //output을 화면에 출력 - h1다음에 output출력
                $("table.reservlist").remove();
                $(".reservatonTable").after(output);

                //content 상세보기 이벤트처리 - 이벤트 처리는 출력된 다음에 줘야함!!
                /*$(".btitle").click(function (){
                    //alert($(this).attr("id"));
                    contentAjax($(this).attr("id"), page);
                });*/

                //페이징 처리 함수 호출 - success안에서 해야함!
                pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);

                //페이지 번호 클릭 이벤트 처리
                jQuery('#ampaginationsm').on('am.pagination.change',function(e){
                    jQuery('.showlabelsm').text('The selected page no: '+e.page);
                    //$(location).attr('href', "http://localhost:9000/reservlist_json.do?page="+e.page); //자기자신이니까 페이지 호출 필요없음 - 함수만 호출하면됨. -> 깜빡이는 현상 없어짐
                    initAjax(e.page);
                });

            }//success

        });//ajax
    }//initAjax

    /*페이징 처리 함수 만들기*/
    function pager(totals, maxSize, pageSize, page){
        //alert(totals+","+maxSize+","+pageSize+","+page);


        var pager = jQuery('#ampaginationsm').pagination({

            maxSize: maxSize,	// max page size
            totals: totals,		// total pages
            page: page,			// initial page
            pageSize: pageSize,	// max number items per page

            // custom labels
            lastText: '&raquo;&raquo;',
            firstText: '&laquo;&laquo;',
            prevText: '&laquo;',
            nextText: '&raquo;',

            btnSize:'sm'	// 'sm'  or 'lg'

        });
    }

    /* 검색 */
/*    function search(page, category) {
        $("#reserv_search").click(function () {
            if ($("#category").val() == "reservnumber") {
                if ($("#cvalue").val() == "") {
                    alert("예매번호를 입력해주세요");
                    $("#cvalue").focus();
                    return false;
                }
            } else if ($("#category").val() == "id") {
                if ($("#cvalue").val() == "") {
                    alert("아이디를 입력해주세요");
                    $("#cvalue").focus();
                    return false;
                }
            }
            searchform.submit();
        });
    }*/



});	//ready