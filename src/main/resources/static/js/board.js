$(document).ready(function (){
    initAjax(1);

    function initAjax(page){
        $.ajax({
                url: "/board_list_json/"+page+"/",
                success : function (result){

                    let output = "<table class='board_list'>";
                    output += "<tr><td colspan='5'>";
                    output += "<a href='/board_write'>";
                    output += "<button type='button' class='btn_style2'>글쓰기</button>";
                    output += "</a></td></tr>";
                    output += "<tr><th>번호</th><th>제목</th><th>조회수</th><th>작성자</th><th>작성일자</th></tr>";

                    for(obj of result.list){
                        output += "<tr>";
                        output += "<td>"+ obj.rno   +"</td>";
                        output += "<td class='btitle', id='"+obj.bid+"'><a>"+ obj.btitle  +"</a></td>";
                        output += "<td>"+ obj.bhits  +"</td>";
                        output += "<td>"+ obj.id  +"</td>";
                        output += "<td>"+ obj.bdate  +"</td>";
                        output += "</tr>";
                    }

                    output += "<tr>";
                    output += "<td colspan='5'><div id='ampaginationsm'></td>";
                    output += "</tr>";
                    output += "</table>";

                    //output을 출력
                    $("table.board_list").remove();
                    $("h3").after(output);

                $(".btitle").click(function (){
                    //contentAjax($(this).attr("id"),page);
                });

                $(".btn_style2").click(function (){
                    styleAjax();
                });

                pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqpage);

                //페이지 번호 클릭 이벤트 처리
                jQuery('#ampaginationsm').on('am.pagination.change',function(e){
                    jQuery('.showlabelsm').text('The selected page no: '+e.page);


                    initAjax(e.page);
                });

                }//success
        });//ajax
    }//initAjax

    function styleAjax(){
        $.ajax({
            url:"/board_write",
            success:function(result){
                let output = "<form name='writeForm' action='board_write_proc' method='post' enctype='multipart/form-data'>";
                output += "<table>";
                output += "<tr>";
                output += "<th class='test'>제목</th>";
                output += "<td><input type='text' name='btitle' id='btitle' placeholder='*제목은 반드시 입력해주세요.'></td>";
                output += "</tr>";
                output += "<tr>";
                output += "<th>내용</th>";
                output += "<td><textarea rows='5' cols='30' name='bcontent'></textarea></td>";
                output += "</tr>";
                output += "<tr>";
                output += "<th>작성자</th>";
                output += "<td><input type='text' name='id' value='admin' disabled></td>";
                output += "</tr>";
                output += "<tr>";
                output += "<th>파일업로드</th>";
                output += "<td><input type='file' name='file1'></td>";
                output += "</tr>";
                output += "<tr>";
                output += "<td colspan='2'>";
                output += "<button type='button' class='btn_style' id='btnBoardWrite'>등록완료</button>";
                output += "<button type='reset' class=''btn_style>다시쓰기</button>";
                output += "<a href='/board_list/'+page>";
                output += "<tr>";
                output += "</tr>";
                output += "</table>";
            }
        });
    }//styleAjax


    /* 페이징 처리 함수 */
    function pager(totals, maxSize, pageSize, page){
        //alert(totals+","+maxSize+","+pageSize+","+page);

        var pager = jQuery('#ampaginationsm').pagination({

            maxSize: maxSize,	    		// max page size
            totals: totals,	// total pages
            page: page,		// initial page
            pageSize: pageSize,			// max number items per page

            // custom labels
            lastText: '&raquo;&raquo;',
            firstText: '&laquo;&laquo;',
            prevText: '&laquo;',
            nextText: '&raquo;',

            btnSize:'sm'	// 'sm'  or 'lg'
        });
    }

});