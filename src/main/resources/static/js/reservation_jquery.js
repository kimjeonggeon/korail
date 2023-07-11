$(document).ready(function(){
	

	/*******************************
			 예매 취소 모달 창
	 *******************************/
	   // 모달 열기 버튼에 대한 클릭 이벤트 핸들러
	  $("#cancelReserv").click(function() {
	 	
	 	if($("#clickVal_depPlandTime").val() != ""){
	 		
		    $(".modal").css("display", "block");
		    
		    //main의 선택한 값이 들어있는 input태그의 값 불러와서 넣기
		    $("#modal_date").text( $("#clickVal_depPlandTime").val());
		    $("#modal_sstation").text( $("#clickVal_sstation").val());
		    $("#modal_dstation").text( $("#clickVal_dstation").val());
		   //$("#modal_runtime").text( $("#clickVal_runtime").val());
		    $("#modal_reservnum").text( $("#clickVal_reservnum").val());
		    $("#modal_trainnum").text( $("#clickVal_trainnum").val());
		    $("#modal_chairnum").text( $("#clickVal_chairnum").val());
		    
		    $("#modal_reservnum_input").val( $("#clickVal_reservnum").val());
		    
		    }else{
		    	alert("예매취소할 승차권을 선택해주세요.");
		    }
  		});
		
	
		// 모달 닫기 버튼에 대한 클릭 이벤트 핸들러
	 	$(".remodal-close").click(function() {
		    $(".modal").css("display", "none");
		});
		
		
	 /* $(window).click(function(event){
		 if(event.target == $("#myModal")[0]) {
		  	$("").fadeOut();
		  }
		  
	  });*/
	
	/*******************************
			예매 내역 ,취소 내역 버튼
	 *******************************/
	
	 //취소내역 버튼 클릭
	$(".cancel_btn").click(function(){
		
		$("#cancelList").show();
		$("#reserv").hide();
		$(".cancel_btn").css("color", "#68b3ce");
		$(".reserv_btn").css("color", "");
	});
	
	 //예매내역 버튼 클릭
	$(".reserv_btn").click(function(){
		
		$("#cancelList").hide();
		$("#reserv").show();
		$(".reserv_btn").css("color", "#68b3ce");
		$(".cancel_btn").css("color", "");
	});
	
	
	/*******************************
			     취소 완료 버튼
	 *******************************/
	
	$("#reservCancel").click(function(){
		
		$.ajax({
			url : "reservCancel_check?reservnum="+$("#modal_reservnum_input").val(),  //페이지이동이 아님. 웹에서는 안보이고 백단에서 이동하는 방식 = 비동기식 방식!
			success : function(result){//문자타입으로 보냈지만 script에서는 타입 정해진거 없음 따라서 숫자타입임
				if(result == 1){
					alert("취소가 완료되었습니다.");
					$(location).attr("href","http://localhost:9000/reservation_main");
				}else{
					alert("예매취소에 실패하였습니다.");
				}
			}
		});
		
	});
	
	
	/*******************************
			     예매내역 클릭 이벤트
	 *******************************/
	let previousElement = null;
	
	$(".box_detail_info").click(function(){
	    
	    // 이전에 클릭한 요소에 적용된 CSS 제거
 		 if (previousElement !== null) {
  		 	previousElement.find(".routeHead").css("background", "");
		 }
	    
	    // 현재 클릭한 요소에 CSS 적용
	    let id=$(this).attr("id");
	    //alert(id);
		$("#"+id+"> .routeHead").css("background", "#D7F1FA");
		
		// 현재 클릭한 요소를 이전 요소로 저장
  		previousElement = $(this);
	});
	
	
	/*******************************
		 예매내역 클릭시 input태그에 담기
	 *******************************/
	
	$(".box_detail_info").click(function() {
            // 클릭한 요소의 데이터 가져오기 " 한칸 띄어쓰기 꼭하기 #id #depPlandTime 로 > 효과 주기위함"
            var id=$(this).attr("id");
            var depPlandTime = $("#"+id+" #depPlandTime").text();
            var stime = $("#"+id+" #stime").text();
            var price = $("#"+id+" #price").text();
            var sstation = $("#"+id+" #sstation").text();
            var dstation = $("#"+id+" #dstation").text();
            //var runtime = $("#"+id+" #runtime").text();
            var reservnum = $("#"+id+" #reservnum").text();
            var trainnum = $("#"+id+" #trainnum").text();
            var chairnum = $("#"+id+" #chairnum").text();
            var depPlaceId = $("#"+id+" #depPlaceId").text();
            var arrPlaceId = $("#"+id+" #arrPlaceId").text();

            // clickedValue에 데이터 설정
            $("#clickVal_depPlandTime").val(depPlandTime);
            $("#clickVal_stime").val(stime);
            $("#clickVal_price").val(price);
            $("#clickVal_sstation").val(sstation);
            $("#clickVal_dstation").val(dstation);
            //$("#clickVal_runtime").val(runtime);
            $("#clickVal_reservnum").val(reservnum);
            $("#clickVal_trainnum").val(trainnum);
            $("#clickVal_chairnum").val(chairnum);
            $("#clickVal_depPlaceId").val(depPlaceId);
            $("#clickVal_arrPlaceId").val(arrPlaceId);
     });
	
	
	/*******************************
		 		영수증 버튼 클릭
	 *******************************/
	
	$("#receipt_btn").click(function(event) {
   		 event.preventDefault();

	   	 if ($("#clickVal_reservnum").val() != "") {
	        var reservnum = $("#clickVal_reservnum").val();
	        var url = "reservation_receipt?reservnum=" + reservnum;
	        window.location.href = url;
	   	 } else {
	        alert("영수증을 발행할 티켓을 선택해주세요.");
	  	 }
	});
	
	/*******************************
		 		홈티켓 버튼 클릭
	 *******************************/
	$("#hometicket_btn").click(function() {
	 	event.preventDefault();
	 	 
	 	if ($("#clickVal_reservnum").val() != "") {
	        var reservnum = $("#clickVal_reservnum").val();
	        var url = "reservation_hometicket?reservnum=" + reservnum;
	        window.location.href = url;
	   	 } else {
	        alert("홈티켓을 발행할 티켓을 선택해주세요.");
	  	 }
		
	});
	
	
	/*******************************
		 	    예매변경 버튼 클릭
	 *******************************/
	$("#change_btn").click(function() {
	 	event.preventDefault();
	 	 
	 	if ($("#clickVal_reservnum").val() != "") {
	        var reservnum = $("#clickVal_reservnum").val();
	        var url = "reservation_update?reservnum=" + reservnum;
	        window.location.href = url;
	        
	       /* 
	       	var depPlandTime = $("#"+id+" #depPlandTime").text(); 
            var depPlaceId = $("#"+id+" #depPlaceId").text();
            var arrPlaceId = $("#"+id+" #arrPlaceId").text();
	        $("#update_depPlandTime").val(depPlandTime);
	        $("#update_depPlaceId").val(depPlaceId);
            $("#update_arrPlaceId").val(arrPlaceId);
            */
	        
	   	 } else {
	        alert("홈티켓을 발행할 티켓을 선택해주세요.");
	  	 }
	});
	
	
	/*******************************
			  관리자 예매내역 클릭 이벤트
	 *******************************/
    	
    	var previousRow = null;
    	
	    $(".admin_reserv").click(function(event) {
				
			var id=$(this).attr("id");
			var reservnum = $("#"+id+" .admin_reservnum").text();
			$("#admin_input").val(reservnum);
				
	    	$(".admin_reserv.selected").removeClass("selected");
    			
			// 클릭한 행에 선택된 클래스 추가
			$(this).addClass("selected");

			// 클릭한 행에 CSS 스타일 적용
			$(this).css("background-color", "#D7F1FA");

    		// 이전에 클릭한 행 css초기화
			 if (previousRow !== null) {
 			 	previousRow.removeClass("selected");
			 	previousRow.css("background-color", "");
			}
			
			// 이전에 선택된 행 업데이트
			 previousRow = $(this);
    			
   				
  		});
	
	/*******************************
			 예매변경 - 조회하기버튼 클릭
	 *******************************/
	$("#reserv_search").click(function(event){
	    event.preventDefault();
	
	    var traintime = $("#traintime").text();
	    var depPlaceId = $("#update_depPlaceId").text();
	    var arrPlaceId = $("#update_arrPlaceId").text();
	
		if($("#traintime").text() != ""){
		
			var url = "reservation_updatetime?traintime=" + encodeURIComponent(traintime) + "&depPlaceId=" + encodeURIComponent(depPlaceId) + "&arrPlaceId=" + encodeURIComponent(arrPlaceId);
		    window.location.href = url;
		
		}else{
			alert("출발일을 선택해주세요.");	
		}
	    
});
	
	
	
	
	
	
	
	
	
	
	
	
	
}); //ready


































