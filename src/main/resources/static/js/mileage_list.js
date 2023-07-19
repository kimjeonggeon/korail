$(document).ready(function () {
    initAjax(1)

    function initAjax(page) {
        $.ajax({
            url: "mileage_list_json_data/" + page + "/", success: function (result) {


            }
        });
    }
})