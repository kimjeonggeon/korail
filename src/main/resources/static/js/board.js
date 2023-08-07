$(document).ready(function (){
    initAjax(1);
    //board list
    function initAjax(page){
        $.ajax({
                url: "/board_list_json/"+page ,
                success : function (result){

                    let output = "<table class='board_list'>";
                    output += "<tr><td colspan='5'>";
                    output += "<button type='button' class='btn_style2'>글쓰기</button>";
                    output += "</td></tr>";
                    output += "<tr><th>번호</th><th>제목</th><th>조회수</th><th>작성자</th><th>작성일자</th></tr>";

                    for(obj of result.list){
                        output += "<tr>";
                        output += "<td>"+ obj.rno  +"</td>";
                        output += "<td class='btitle', id='"+obj.bid+"'><a>"+ obj.btitle +"</a></td>";
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
                    contentAjax($(this).attr("id"),page);
                });

                $(".btn_style2").click(function (){
                    styleAjax();
                });

                pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);

                //페이지 번호 클릭 이벤트 처리
                jQuery('#ampaginationsm').on('am.pagination.change',function(e){
                    jQuery('.showlabelsm').text('The selected page no: '+e.page);


                    initAjax(e.page);
                });

                }//success
        });//ajax
    }//initAjax

    //글쓰기
    function styleAjax(){

            let output = "<form name='writeForm' id='writeForm' action='board_write_proc' method='post' enctype='multipart/form-data'>";
            output += "<table class='writetable'>";
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
            output += "<td><input type='file' name='bfiles'></td>";
            output += "</tr>";
            output += "<tr>";
            output += "<td colspan='2'>";
            output += "<button type='button' class='btn_style' id='btnBoardWrite'>등록완료</button>";
            output += "<button type='reset' class='btn_style'>다시쓰기</button>";
            output += "<a href='/board_list/1'>";
            output += "<button type='button' class='btn_style' id='board_list'>리스트</button></a>";
            output += "<a href='http://localhost:9000'>";
            output += "<button type='button' class='btn_style' id='index'>홈으로</button></a>";
            output += "</tr>";
            output += "</table>";
            output += "</form>";

            $("table.board_list").remove();
            $("h3").after(output);

            $("#btnBoardWrite").click(function (){
                boardwrite();
            });

            $("#board_list").click(function (){
                $("table.board_content").remove();
                initAjax(page);
            });

            $("#index").click(function (){
                $(location).attr('href', 'http://localhost:9000/');
            });

    }


    //등록하기
    function boardwrite(){

        var formData  = $("#writeForm").serializeArray();

        $.ajax({
            url:"/board_write_proc",
            type: 'POST',
            dataType: "json",
            data: formData,
            success : function (result){
                $("table.writetable").remove();
                initAjax(1);
            }
        });//ajax
    }

    //content
    function contentAjax(bid,page){
        $.ajax({
            url:"/board_content_json/"+bid+"/",
            success: function (board){
                let output = "<table class='board_content'>";
                output += "<tr>";
                output += "<th>제목</th>";
                output += "<td>"+board.btitle+"</td>";
                output += "</tr>";

                output += "<tr>";
                output += "<th>내용</th>";
                output += "<td>"+board.bcontent+"</td>";
                output += "</tr>";

                output += "<tr>";
                output += "<th>조회수</th>";
                output += "<td>"+board.bhits+"</td>";
                output += "</tr>";

                output += "<tr>";
                output += "<th>작성자</th>";
                output += "<td>"+board.id+"</td>";
                output += "</tr>";

                output += "<tr>";
                output += "<th>작성일자</th>";
                output += "<td>"+board.bdate+"</td>";
                output += "</tr>";

                output += "<tr>";
                output += "<td colspan='2'>";
                output += "<a><button type='button' class='btn_style updateboard' id='"+board.bid+"'>수정하기</button></a>";
                output += "<a><button type='button' class='btn_style deleteboard' id='"+board.bid+"'>삭제하기</button></a>";
                output += "<a><button type='button' class='btn_style' id='board_list'>리스트</button></a>";
                output += "<a><button type='button' class='btn_style' id='index'>홈으로</button></a>";
                output += "</td>";
                output += "</tr>";

                output += "</table>";

                $("table.board_list").remove();
                $("h3").after(output);

                $(".deleteboard").click(function (){
                    $("table.board_content").remove();
                    deleteboard($(this).attr("id"),page);
                });

                $(".updateboard").click(function (){
                    $("table.board_content").remove();
                    updateboard($(this).attr("id"));
                });

                $("#board_list").click(function (){
                    $("table.board_content").remove();
                    initAjax(page);
                });

                $("#index").click(function (){
                    $(location).attr('href', 'http://localhost:9000/');
                });
            }
        })
    }

    //수정하기
    function updateboard(bid){
        //alert(bid);
        $.ajax({
           url:"/board_update_json/"+bid+"/",
           success: function (board){
               let output = "<form name='updateForm' id='updateForm' action='board_update_proc_json' method='post' enctype='multipart/form-data'>";
               output += "<table class='writetable updatetable'>";
               output += "<tr>";
               output += "<th class='test'>제목</th>";
               output += "<td><input type='text' name='btitle' id='btitle' placeholder='"+board.btitle+"'></td>";
               output += "</tr>";
               output += "<tr>";
               output += "<th>내용</th>";
               output += "<td><textarea rows='5' cols='30' name='bcontent'>"+board.bcontent+"</textarea></td>";
               output += "</tr>";
               output += "<tr>";
               output += "<th>작성자</th>";
               output += "<td><input type='text' name='id' value='admin' disabled></td>";
               output += "</tr>";
               output += "<tr>";
               output += "<th>파일업로드</th>";
               output += "<td><input type='file' name='bfiles'></td>";
               output += "</tr>";
               output += "<tr>";
               output += "<td colspan='2'>";
               output += "<button type='button' class='btn_style btnBoardUpdate' id='"+board.bid+"'>수정완료</button>";
               output += "<button type='reset' class='btn_style'>다시쓰기</button>";
               output += "<a href='/board_list/1'>";
               output += "<button type='button' class='btn_style' id='board_list'>리스트</button></a>";
               output += "<a href='http://localhost:9000'>";
               output += "<button type='button' class='btn_style' id='index'>홈으로</button></a>";
               output += "</tr>";
               output += "</table>";
               output += "</form>";

               $("table.board_list").remove();
               $("h3").after(output);

               $("#board_list").click(function (){
                   $("table.board_content").remove();
                   initAjax(page);
               });

               $("#index").click(function (){
                   $(location).attr('href', 'http://localhost:9000/');
               });

               $(".btnBoardUpdate").click(function (){
                   board_update_proc_json($(this).attr("id"));
               });

           }
        });
    }


    //수정완료 버튼 클릭 시 호출
    function board_update_proc_json(bid){
        var formData  = $("#updateForm").serializeArray();
        $.ajax({
            url: "/board_update_proc_json/"+bid+"/",
            type: 'POST',
            dataType: "json",
            data: formData,
            success:function (result){
                if(result == 1){
                    $("table.updatetable").remove();
                    initAjax(1);
                }
            }
        })
    }

    //삭제하기
    function deleteboard(bid,page){
        var output = "<form name='deleteForm' id='deleteForm'>";
        output += "<table class='writetable deletetable'><tr><td>";
        output += "<img src='http://localhost:9000/images/trash.jpg'>";
        output += "</td></tr>";
        output += "<tr><td>정말로 삭제 하시겠습니까?</td></tr>";
        output += "<tr><td colspan=\"2\">";
        output += "<button type='button' class='btn_style board_delete_proc' id='"+bid+"'>삭제완료</button>";
        output += "<button type='button' class='btn_style' id='board_back'>이전페이지</button>";
        output += "<button type='button' class='btn_style' id='board_list'>리스트</button>";
        output += "<button type='button' class='btn_style' id='index'>홈으로</button>";
        output += "</td></tr></table>";
        output += "</form>";

        $("table.board_list").remove();
        $("h3").after(output);
        
        $(".board_delete_proc").click(function (){
            board_delete_proc($(this).attr("id"));
        });

        $("#board_back").click(function (){
            $("table.deletetable").remove();
            contentAjax(bid,page);
        });

        $("#board_list").click(function (){
            $("table.board_content").remove();
            initAjax(page);
        });

        $("#index").click(function (){
            $(location).attr('href', 'http://localhost:9000/');
        });
    }

    //삭제 완료 버튼 클릭 시 호출
    function board_delete_proc(bid){
        var formData  = $("#deleteForm").serializeArray();
        $.ajax({
            url:"/board_delete_proc_json/"+bid+"/",
            dataType: "json",
            data: formData,
            success : function (result){
                //alert(result);
                if(result == 1){
                    $("table.deletetable").remove();
                    initAjax(1);
                }
            }
        });

    }
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