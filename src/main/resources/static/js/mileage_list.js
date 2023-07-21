$(document).ready(function () {
        alert(memberId);
    window.addEventListener('message', function(event) {
        memberId = event.data;
        initAjax(memberId);

        function initAjax(memberId) {
            $.ajax({
                url: "mileage_list_json_data/" + memberId + "/", success: function (result) {
                    //dhtml을 활용하여 테이블로 출력
                    let output = "<table class='board_list'>";
                    output += "<tr class='tr'><th>적립일</th><th>적립금</th><th>내역</th><th>만료일</th><th>누적 마일리지</th></tr>";

                    for (obj of result.list) {
                        output += "<tr class='tr'>";
                        output += "<td>" + obj.accumulationdate + "</td>";

                        if (obj.changeamout > 0) {
                            output += "<td calss='add'>" + obj.changeamout + "</td>";
                        } else {
                            output += "<td calss='reduce'>" + obj.changeamout + "</td>";
                        }

                        output += "<td>" + obj.specifics + "</td>";

                        if (obj.expirationdate == null) obj.expirationdate = "";
                        output += "<td>" + obj.expirationdate + "</td>";

                        output += "<td>" + obj.totalmileage + "</td>";
                        output += "</tr>";
                    }

                    output += "<tr>";
                    output += "<td colspan='5'><div id='ampaginationsm'></td>";
                    output += "</tr>";
                    output += "</table>";

                    $("table.board_list").remove();
                    $("h1").after(output);

                }
            });
        }
    })
});