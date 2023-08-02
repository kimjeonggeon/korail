$(document).ready(function() {
	//initAjax("kyeongbu" , '1', '서울역', 'c');

	$(".underline").on("click", function() {
		let route = $(this).attr("id");
		let route_name = $("#route_name").val();
		let rno = '1';
		let station = '';

		if(route != route_name) {
			$(".underline").css("border", "none");
			$("#" + route).css("border-bottom", "3px solid rgb(83, 49, 156)");
			$("#route_name").val(route);

			if(route == 'kangleung') {
				rno = '2';
			}

			if(route == 'kyeongbu') {
				station = "서울역";
			} else if(route == 'honam') {
				station = "용산역";
			} else if(route == 'kyeongjeon') {
				station = "서울역";
			} else if(route == 'jeonla') {
				station = "용산역";
			} else if(route == 'kangleung') {
				station = "청량리역";
			} else if(route == 'joongang') {
				station = "청량리역";
			} else if(route == 'joongbu') {
				station = "부발역";
			}

		}
		//initAjax(route, rno, station, 'c');

	});	//onClick

	function display_station(category) {
		$(".map_station").css("display", "none");
		if(category == "kyeongbu") {
			$("#station01").css("display", "block");
			$("#station02").css("display", "block");
			$("#station03").css("display", "block");
		} else if(category == "honam") {
			$("#station04").css("display", "block");
			$("#station05").css("display", "block");
			$("#station06").css("display", "block");
		} else if(category == "kyeongjeon") {
			$("#station07").css("display", "block");
			$("#station08").css("display", "block");
			$("#station09").css("display", "block");
		} else if(category == "jeonla") {
			$("#station10").css("display", "block");
			$("#station11").css("display", "block");
			$("#station12").css("display", "block");
		} else if(category == "kangleung") {
			$("#station13").css("display", "block");
			$("#station14").css("display", "block");
			$("#station15").css("display", "block");
		} else if(category == "joongang") {
			$("#station16").css("display", "block");
			$("#station17").css("display", "block");
			$("#station18").css("display", "block");
		} else {
			$("#station19").css("display", "block");
			$("#station20").css("display", "block");
			$("#station21").css("display", "block");
		}
	}

	// function initAjax(category, rno, station, type) {
	// 	$.ajax({
	// 		url : "train_route_info_json?category="+category+"&rno="+rno+"&station="+station+"&type="+type,
	// 		success:function(result) {
	// 			//alert(result);
	// 			let jdata = JSON.parse(result);
	// 			let obj = jdata.jlist;
	//
	// 			const arr = [jdata.station_list[0].station, jdata.station_list[1].station, jdata.station_list[2].station];
	//
	// 			let output = "<div class='station'><div class='station-section two-column'><div class='col-left'>";
	// 			output += "<img src='http://localhost:9000/images/" + obj.clink1 + "' class= 'train_category'>";
	// 			output += "<img src='http://localhost:9000/images/" + obj.clink2 + "' class= 'category_map'>";
	// 			output += "<ul><li class='map_station' id='station01'><a href='#'>서울</a></li>";
	// 			output += "<li class='map_station' id='station02'><a href='#'>수원</a></li>";
	// 			output += "<li class='map_station' id='station03'><a href='#'>부산</a></li>";
	// 			output += "<li class='map_station' id='station04'><a href='#'>용산</a></li>";
	// 			output += "<li class='map_station' id='station05'><a href='#'>천안아산(온양온천)</a></li>";
	// 			output += "<li class='map_station' id='station06'><a href='#'>광주송정</a></li>";
	// 			output += "<li class='map_station' id='station07'><a href='#'>서울</a></li>";
	// 			output += "<li class='map_station' id='station08'><a href='#'>대전</a></li>";
	// 			output += "<li class='map_station' id='station09'><a href='#'>동대구</a></li>";
	// 			output += "<li class='map_station' id='station10'><a href='#'>용산</a></li>";
	// 			output += "<li class='map_station' id='station11'><a href='#'>서대전</a></li>";
	// 			output += "<li class='map_station' id='station12'><a href='#'>여수엑스포</a></li>";
	// 			output += "<li class='map_station' id='station13'><a href='#'>청량리</a></li>";
	// 			output += "<li class='map_station' id='station14'><a href='#'>횡성</a></li>";
	// 			output += "<li class='map_station' id='station15'><a href='#'>강릉</a></li>";
	// 			output += "<li class='map_station' id='station16'><a href='#'>청량리</a></li>";
	// 			output += "<li class='map_station' id='station17'><a href='#'>단양</a></li>";
	// 			output += "<li class='map_station' id='station18'><a href='#'>안동</a></li>";
	// 			output += "<li class='map_station' id='station19'><a href='#'>부발</a></li>";
	// 			output += "<li class='map_station' id='station20'><a href='#'>가남</a></li>";
	// 			output += "<li class='map_station' id='station21'><a href='#'>충주</a></li></ul>";
	// 			output += "</div><div class='col-right'><div class='container-top'>";
	// 			output += "<h2 class='title'>" + obj.station + "</h2>";
	// 			output += "<div class='container-mover'><a class='btn' id='before'><</a><a class='btn' id='next'>></a></div>";
	// 			output += "<img src='http://localhost:9000/images/" + obj.plink + "' class= 'station_map'></div>";
	// 			output += "<div class='container-bottom'><table><tr><td>위치</td>";
	// 			output += "<td>" + obj.location + "</td></tr><tr><td>연락처</td>";
	// 			output += "<td>" + obj.sphone + "</td></tr></table>";
	// 			output += "<div class='button'><a href='#info' class='btn'>기차역 상세</a></div></div></div></div></div>";
	// 			output += "<div class='station-basic-info'><div class='info-top'><h3 id='info'>기본 정보</h3>";
	// 			output += "<div class='station-info'>" + obj.info + "</div></div>";
	// 			output += "<div class='info-bottom'><h3>연혁</h3>";
	// 			output += "<ol>";
	// 			for(hobj of obj.jhistory) {
	// 				output += "<li class='info-bottom'>" + hobj.history + "</li>";
	// 			}
	// 			output += "</ol>";
	//
	// 			output += "</div>";
	//
	// 			output += "</div><div class='station-map-info'><h3>위치/교통</h3><div id='map' style='width:1100px;height:700px;'></div><script>";
	//
	// 			output += "var container = document.getElementById('map');";
	// 			output += "var options = { center: new kakao.maps.LatLng(" + obj.mlink + " ),level: 3 };";
	// 			output += "var map = new kakao.maps.Map(container, options);";
	// 			output += "var markerPosition  = new kakao.maps.LatLng(" + obj.mlink + ");";
	// 			output += "var marker = new kakao.maps.Marker({ position: markerPosition });";
	// 			output += "marker.setMap(map);";
	//
	// 			output += "</script></div></div></div>";
	//
	// 			$(".station-map-info").remove();
	// 			$(".station").remove();
	// 			$(".station-basic-info").remove();
	// 			$(".route").after(output);
	//
	// 			display_station(category);
	//
	// 			$("#station01").click(function() {
	// 				initAjax("kyeongbu", '1', '서울역', 'c');
	// 			});
	//
	// 			$("#station02").click(function() {
	// 				initAjax("kyeongbu", '2', '수원역', 'c');
	// 			});
	//
	// 			$("#station03").click(function() {
	// 				initAjax("kyeongbu", '3', '부산역', 'c');
	// 			});
	//
	// 			$("#station04").click(function() {
	// 				initAjax("honam", '1', '용산역', 'c');
	// 			});
	//
	// 			$("#station05").click(function() {
	// 				initAjax("honam", '2', '천안아산역', 'c');
	// 			});
	//
	// 			$("#station06").click(function() {
	// 				initAjax("honam", '3', '광주송정역', 'c');
	// 			});
	//
	// 			$("#station07").click(function() {
	// 				initAjax("kyeongjeon", '1', '서울역', 'c');
	// 			});
	//
	// 			$("#station08").click(function() {
	// 				initAjax("kyeongjeon", '2', '대전역', 'c');
	// 			});
	//
	// 			$("#station09").click(function() {
	// 				initAjax("kyeongjeon", '3', '동대구역', 'c');
	// 			});
	//
	// 			$("#station10").click(function() {
	// 				initAjax("jeonla", '1', '용산역', 'c');
	// 			});
	//
	// 			$("#station11").click(function() {
	// 				initAjax("jeonla", '2', '서대전역', 'c');
	// 			});
	//
	// 			$("#station12").click(function() {
	// 				initAjax("jeonla", '3', '여수엑스포역', 'c');
	// 			});
	//
	// 			$("#station13").click(function() {
	// 				initAjax("kangleung", '2', '청량리역', 'c');
	// 			});
	//
	// 			$("#station14").click(function() {
	// 				initAjax("kangleung", '3', '횡성역', 'c');
	// 			});
	//
	// 			$("#station15").click(function() {
	// 				initAjax("kangleung", '1', '강릉역', 'c');
	// 			});
	//
	// 			$("#station16").click(function() {
	// 				initAjax("joongang", '1', '청량리역', 'c');
	// 			});
	//
	// 			$("#station17").click(function() {
	// 				initAjax("joongang", '2', '단양역', 'c');
	// 			});
	//
	// 			$("#station18").click(function() {
	// 				initAjax("joongang", '3', '안동역', 'c');
	// 			});
	//
	// 			$("#station19").click(function() {
	// 				initAjax("joongbu", '1', '부발역', 'c');
	// 			});
	//
	// 			$("#station20").click(function() {
	// 				initAjax("joongbu", '2', '가남역', 'c');
	// 			});
	//
	// 			$("#station21").click(function() {
	// 				initAjax("joongbu", '3', '충주역', 'c');
	// 			});
	//
	// 			$("#before").on("click", function() {
	// 				var count = $("#station_count2").val();
	// 				var num = parseInt(count);
	// 				station = arr[num];
	// 				route = $("#route_name").val();
	//
	// 				num--;
	// 				if(num == -1) {
	// 					$("#station_count2").val(2);
	// 				} else {
	// 					$("#station_count2").val(num);
	// 				}
	// 				$(".title").text(arr[count]);
	//
	// 				initAjax(route, rno, station, 's');
	// 			});
	//
	// 			$("#next").on("click", function() {
	// 				var count = $("#station_count1").val();
	// 				var num = parseInt(count);
	// 				station = arr[num];
	// 				route = $("#route_name").val();
	//
	// 				num++;
	// 				if(num == 3) {
	// 					$("#station_count1").val(0);
	// 				} else {
	// 					$("#station_count1").val(num);
	// 				}
	// 				$(".title").text(arr[count]);
	//
	// 				initAjax(route, rno, station, 's');
	// 			});
	//
	// 		}	//success
	//
	// 	});	//ajax
	//
	// }//initAjax

});	//ready

$(document).ready(function(){
	init();

	function init(){
		let url = "https://apis.data.go.kr/1613000/TrainInfoService/getCtyCodeList?serviceKey=fia82dW58XZekM3fyfsYQjw24d3TDN%2FOCdtbCQWjlYjltamNE5UGs23S0OiE%2BdghuBeQ%2Bt%2FLjncovmHroyfk1Q%3D%3D&_type=json";
		$.getJSON(url, function(city){
			/*alert(city.response.body.items.item);*/

			let code = "<option value='default'>선택</option>";
			for(citynum of city.response.body.items.item){
				/*alert(citynum.citycode);*/
				code +="<option name='start_city' value ='"+citynum.citycode+"'>" + citynum.cityname + "</option>";
			}

			$("#start_city").append(code);

		});
	}//init

	$("#start_city").change(function(){
		let url2 ="https://apis.data.go.kr/1613000/TrainInfoService/getCtyAcctoTrainSttnList?serviceKey=fia82dW58XZekM3fyfsYQjw24d3TDN%2FOCdtbCQWjlYjltamNE5UGs23S0OiE%2BdghuBeQ%2Bt%2FLjncovmHroyfk1Q%3D%3D&pageNo=1&numOfRows=10&_type=json&cityCode="+$(this).val();
		$.getJSON(url2, function(train){

			let code = "<option class='c1' value='default'>출발역</option>";
			for(trainnum of train.response.body.items.item){
				code +="<option class='c1' name='start_train' id='start_trainnone' value ='"+trainnum.nodeid+"'>" + trainnum.nodename + "</option>";
			}
			$(".c1").remove();
			$("#start_train").append(code);
		})
	});

	$("#start_train").change(function(){
		$("#start").val($(this).val());
	});

	// 도착역

	let url = "https://apis.data.go.kr/1613000/TrainInfoService/getCtyCodeList?serviceKey=fia82dW58XZekM3fyfsYQjw24d3TDN%2FOCdtbCQWjlYjltamNE5UGs23S0OiE%2BdghuBeQ%2Bt%2FLjncovmHroyfk1Q%3D%3D&_type=json";
	$.getJSON(url, function(city){
		/*alert(city.response.body.items.item);*/

		let code = "<option value='default'>선택</option>";
		for(citynum of city.response.body.items.item){
			/*alert(citynum.citycode);*/
			code +="<option  name='end_city' value ='"+citynum.citycode+"'>" + citynum.cityname + "</option>";
		}

		$("#end_city").append(code);
	});

	$("#end_city").change(function(){
		let url2 ="https://apis.data.go.kr/1613000/TrainInfoService/getCtyAcctoTrainSttnList?serviceKey=fia82dW58XZekM3fyfsYQjw24d3TDN%2FOCdtbCQWjlYjltamNE5UGs23S0OiE%2BdghuBeQ%2Bt%2FLjncovmHroyfk1Q%3D%3D&pageNo=1&numOfRows=10&_type=json&cityCode="+$(this).val();
		$.getJSON(url2, function(train){

			let code = "<option class='c2' value='default'>도착역</option>";
			for(trainnum of train.response.body.items.item){
				code +="<option class='c2' name='end_train' value ='"+trainnum.nodeid+"'>" + trainnum.nodename + "</option>";
			}
			$(".c2").remove();
			$("#end_train").append(code);
		})
	});
	$("#end_train").change(function(){
		$("#end").val($(this).val());
	});
	/*	$("#traintime").text(function(){
			$("#start_time").val($(this).val());
	});*/

	$("#btnsearch").click(function(){

		let url ="https://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo?serviceKey=fia82dW58XZekM3fyfsYQjw24d3TDN%2FOCdtbCQWjlYjltamNE5UGs23S0OiE%2BdghuBeQ%2Bt%2FLjncovmHroyfk1Q%3D%3D&pageNo=1&numOfRows=10&_type=json&depPlaceId="+$("#start").val() +"&arrPlaceId="+$("#end").val()+"&depPlandTime="+$("#traintime").val()+"&trainGradeCode=00";
		$.getJSON(url, function(citys){
			let code = "<form name='testForm' action='testProc.jsp' method='post'><div id='d2'>";
			code += "<table id='testTable'><tr><th>출발역</th><th>도착역</th><th>출발일시</th><th>도착시간</th><th>열차명</th><th>열차번호</th><th>운임</th></tr>";
			for(kobi of citys.response.body.items.item){

				code +="<td>"+kobi.depplacename+"</td>";
				code +="<td>"+kobi.arrplacename+"</td>";
				code +="<td>"+kobi.depplandtime+"</td>";
				code +="<td>"+kobi.arrplandtime+"</td>";
				code +="<td>"+kobi.traingradename+"</td>";
				code +="<td>"+kobi.trainno+"</td>";
				code +="<td>"+kobi.adultcharge+"</td>";

				code += "</tr>";
			}

			code +="</table>"
			code +="</div> </form>"

			$("div#d2").remove();

			$("div#trainList").after(code);

		});
	})

});

//공지사항 등록
$(document).ready(function() {
	$("#btnSubmit").click(function() {
		if($("#notice_title").val() == "") {
			alert("제목을 입력해주세요.");
			$("#notice_title").focus();
			return false;
		} else {
			writeForm.submit();
		}
	});

	$("#btnAgain").click(function() {
		$('#form_write').trigger("reset");

	});

//공지사항 수정
	$("#btnSubmit_update").click(function() {
		if($("#notice_title").val() == "") {
			alert("제목을 입력해주세요.");
			$("#notice_title").focus();
			return false;
		} else {
			updateForm.submit();
		}
	});

	$("#btnAgain_update").click(function() {
		$('#form_update').trigger("reset");

	});

	$("#btnSubmit_delete").click(function() {
		deleteForm.submit();
	});
});

$(document).ready(function() {

	initAjax(1);

	function initAjax(page) {
		$.ajax({
			url: "notice_list_json_data/" + page + "/",
			success: function(result) {
				//alert(result.list[0].ntitle);
				let output = "<table class='notice_search'>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>제목</th>";
				output += "<th>조회수</th>";
				output += "<th>등록일자</th>";
				output += "</tr>";

				for(obj of result.list) {
					output += "<tr>";
					output += "<td>"+ obj.rno +"</td>";
					output += "<td class='ntitle' id='"+ obj.nid +"'><a>"+ obj.ntitle  +"</a></td>";
					output += "<td>"+ obj.nhits +"</td>";
					output += "<td>"+ obj.ndate +"</td>";
					output += "</tr>";
				}
				output += "<tr>";
				output += "<td colspan='5' class='paging'>";
				output += "<div id='ampaginationsm' class='paging'></div>";
				output += "</td>";
				output += "</tr>";
				output += "</table>";

				// output 출력
				$("table.notice_search").remove();
				$("#notice_list_search").after(output);

				// 페이징 처리 함수 호출
				pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);

				// content(상세보기) 이벤트
				$(".ntitle").click(function () {
					contentAjax($(this).attr("id"), page);
					$(".search-form").css("display", "none");
				});

				// 페이지 번호 클릭 이벤트
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
					jQuery('.showlabelsm').text('The selected page no: '+e.page);

					initAjax(e.page);
				});

			}
		});	// ajax
	}	// initAjax

	// 페이징 처리 함수
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

	// validation 체크
	function validation(category, cvalue) {
		if (category == "title") {
			if (cvalue == "") {
				alert("제목을 입력해주세요");
				$("#cvalue").focus();
				return false;
			} else {
				return true;
			}

		} else if (category == "content") {
			if (cvalue == "") {
				alert("내용을 입력해주세요");
				$("#cvalue").focus();
				return false;
			} else {
				return true;
			}
		} else if (category == "title_content") {
			if (cvalue == "") {
				alert("제목 또는 내용을 입력해주세요");
				$("#cvalue").focus();
				return false;
			} else {
				return true;
			}
		}
	}

	// 검색 버튼 클릭 이벤트
	$("#notice_search").click(function() {
		//alert("111");
		var category = $("#category").val();
		var cvalue = $("#cvalue").val();
		if(validation(category, cvalue)) {
			searchAjax(category, cvalue, 1);
		} else {
			$("#cvalue").focus();
		}

	});	// search click

	// 값 입력이 될때만 버튼 활성화
	$(function() {
		$("#cvalue").on('input', function() {
			if($("#cvalue").val() == '') {
				$("#notice_search").attr("disabled", true);
			} else {
				$("#notice_search").attr("disabled", false);
			}

		});
	});

	// category all일 땐 값 입력 불가능하기 처리 이벤트
	$(function() {
		$("#category").on('change', function() {
			if($("#category").val() == "all") {
				$("#cvalue").attr("disabled", true);
			} else {
				$("#cvalue").attr("disabled", false);
			}
		});
	});

	// 공지사항 등록 글자수 세기
	$("#notice_content").keyup(function (e) {
		let content = $(this).val();

		if(content.length == 0 || content =="") {
			$(".textCount").text('0자');
		} else {
			$(".textCount").text(content.length + '자');
		}

		// 글자수 제한
		if(content.length > 200) {
			$(this).val($(this).val().substring(0, 200));
		}
	});

	// enter 버튼 이벤트 처리
	$(function () {
		$("#cvalue").keypress(function (e) {
			if(e.keyCode && e.keyCode == 13) {
				$("#notice_search").trigger("click");
				return false;
			}
		});
	});

	function searchAjax(category, cvalue, page) {
		$.ajax({
			url: "notice_search_json_data/" + category + "/" + cvalue + "/" + page + "/",
			success: function (result) {

				let output = "<table class='notice_search'>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>제목</th>";
				output += "<th>조회수</th>";
				output += "<th>등록일자</th>";
				output += "</tr>";

				for(obj of result.slist) {
					output += "<tr>";
					output += "<td>"+ obj.rno +"</td>";
					output += "<td class='ntitle' nid='"+ obj.nid +"'><a>"+ obj.ntitle  +"</a></td>";
					output += "<td>"+ obj.nhits +"</td>";
					output += "<td>"+ obj.ndate +"</td>";
					output += "</tr>";
				}
				output += "<tr>";
				output += "<td colspan='5' class='paging'>";
				output += "<div id='ampaginationsm' class='paging'></div>";
				output += "</td>";
				output += "</tr>";
				output += "</table>";

				$("table.notice_search").remove();
				$("#notice_list_search").after(output);

				pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);

				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
					jQuery('.showlabelsm').text('The selected page no: '+e.page);

					searchAjax(category, cvalue, e.page);
				});

			}	// success
		});	// ajax
	}	// searchAjax

	// 상세보기
	function contentAjax(nid, page) {
		$.ajax({
			url: "notice_content_json_data/" + nid + "/",
			success: function (notice) {
				let output = "<div class='notice_content'>";
				output += "<div class='line2'></div>";
				output += "<div class='table_content'><p id='notice_table1'>" + notice.ntitle + "</p><p id='notice_table2'>" + notice.ndate + "</p></div>";
				output += "<div class='line2'></div>";
				output += "<p id='content_title'>" + notice.ntitle + "</p>";
				output += "<p id='content_content'>" + notice.ncontent + "<br>";
				if(notice.nsfile != null) {
					output += "<img src='http://localhost:9000/upload/" + notice.nsfile + "'>";
				}
				output += "</p><div>";
				output += "<div class='line2'></div>";
				output += "<div class='button'>";
				output += "<a class='btn' id='list'>리스트</a>";
				output += "<a class='btn' id='click_before'><</a>";
				output += "<a class='btn' id='click_after'>></a>";
				output += "<input type='hidden' id='before_hidden' value='" + notice.nprev + "'>";
				output += "<input type='hidden' id='next_hidden' value='" + notice.nnext + "'>";
				output += "</div>";
				output += "</div>";
				output += "</div>";

				$("table.notice_search").remove();
				$("h3").after(output);

				$("#list").click(function() {
					$(".notice_content").remove();
					$(".search-form").css("display", "flex");
					initAjax(page);
				});

				$("#click_before").click(function() {
					$(".notice_content").remove();
					contentAjax(notice.nnext, page);
				});

				$("#click_after").click(function() {
					$(".notice_content").remove();
					contentAjax(notice.nprev, page);
				});

			}	// success
		});	// ajax
	}	// contentAjax

	stationAjax("kyeongbu", "서울역");

	function stationAjax(category, station) {

		$.ajax({
			url: "route_info_json_data/" + category + "/" + station + "/",
			success: function (result) {
				let output = "<div class='station-section two-column'>";
				output += "<div class='col-left'>";
				for(obj of result.slist) {
					output += "<img src='http://localhost:9000/images/" + obj.clink1 + "'class='train_category'>";
					output += "<img src='http://localhost:9000/images/" + obj.clink2 + "'class='category_map'>";
					output += "</div>";
					output += "<div class='col-right'>";
					output += "<div class='container-top'>";
					output += "<h2 class='title'>" + obj.station + "</h2>";
					output += "<div class='container-mover'>";
					output += "<a class='btn' id='before'><</a>";
					output += "<a class='btn' id='next'>></a></div>";
					output += "<img src='http://localhost:9000/images/" + obj.plink + "'class='station_map'></div>";
					output += "<div class='container-bottom'>";
					output += "<table><tr><td>위치</td>";
					output += "<td>" + obj.location + "</td></tr>";
					output += "<tr><td>연락처</td>";
					output += "<td>" + obj.sphone + "</td></tr>";

					output += "</table><div class='button'><a href='#info' class='btn'>기차역 상세</a></div>";
					output += "</div></div></div></div>";
					output += "<div class='station-basic-info'>";
					output += "<div class='info-top'>";
					output += "<h3 id='info'>기본 정보</h3>";
					output += "<div class='station-info'>" + obj.info + "</div></div>";
					output += "<div class='info-bottom'>";
					output += "<h3>" + obj.station + " 연혁</h3>";
					output += "<ol>";
					for(hobj of obj.list) {
						output += "<li class='info-bottom'>" + hobj.history + "</li>";
					}
					output += "</ol>";

				}
				output += "<div className='station-map-info'>";
				output += "<h3>위치/교통</h3>";
				output += "<div id='map' style='width:1100px;height:700px;'></div></div>";
				output += "<script>";

				for(obj of result.slist) {
					output += "var container = document.getElementById('map')";
					output += "var options = {";
					output += "center: new kakao.maps.LatLng(" + obj.mlink + "),";
					output += "level: 3}";

					output += "var map = new kakao.maps.Map(container, options);";
					output += "var markerPosition = new kakao.maps.LatLng(" + obj.mlink + ");";

					output += "var marker = new kakao.maps.Marker({";
					output += "position: markerPosition});";
					output += "marker.setMap(map)";
				}
				output += "</script></div>";

				$("#line").after(output);

			}

		});	// Ajax
	}	// stationAjax

});