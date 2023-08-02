<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import=" com.example.korail.dto.StationDto" %>
			<%@ page import=" java.util.*" %>
					
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<title>기차역 상세 정보</title>
						<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
						<script src="http://localhost:9000/js/min.js"></script>
						<script type="text/javascript"
							src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6c229bd14220c7cc4fa6edf4d24c1d9e"></script>
						<link rel="stylesheet" href="http://localhost:9000/css/min.css">
					</head>

					<body>
						<div class="body">
							<jsp:include page="../gnb.jsp"></jsp:include>
						</div>
						<div id="contentWrap">
							<div class="title-wrap">
								<div class="title-background">
									<jsp:include page="../header.jsp"></jsp:include>
									
									<h2 class="title_station">KTX역 정보</h2>
								</div>
							</div>
							
							<div class="train-route">
								<nav class="route">
									<input type="hidden" id="route_name" class="route_name" value="kyeongbu">
									<input type="hidden" id="station_count1" value="1">
									<input type="hidden" id="station_count2" value="2">
									<ul>
										<li><span class="underline" id="kyeongbu">경부선</span></li>
										<li><span class="underline" id="honam">호남선</span></li>
										<li><span class="underline" id="kyeongjeon">경전선</span></li>
										<li><span class="underline" id="jeonla">전라선</span></li>
										<li><span class="underline" id="kangleung">강릉선</span></li>
										<li><span class="underline" id="joongang">중앙선</span></li>
										<li><span class="underline" id="joongbu">중부내륙선</span></li>
									</ul>
									<div class="line" id="line"></div>
								</nav>
								
								<%-- <div id="station">
										<div class="station-section two-column">
											<div class="col-left">
												<% for(StationVo stationVo : list){ %>
													<img src="http://localhost:9000/images/<%=stationVo.getClink1() %>"
														class="train_category">
													<img src="http://localhost:9000/images/<%=stationVo.getClink2() %>"
														class="category_map">
											</div>
											<div class="col-right">
												<div class="container-top">
													<h2 class="title">
														<%=stationVo.getStation() %>
													</h2>
													<div class=
													"container-mover">
														<a class="btn" id="before"><</a>
														<a class="btn" id="next">></a>
													</div>
													<img src="http://localhost:9000/project/images/<%=stationVo.getPlink() %>"
														class="station_map">
												</div>
												<div class="container-bottom">
													<table>
														<tr>
															<td>위치</td>
															<td>
																<%=stationVo.getLocation() %>
															</td>
														</tr>
														<tr>
															<td>연락처</td>
															<td>
																<%=stationVo.getSphone() %>
															</td>
														</tr>

													</table>
													<div class="button">
														<a href="#info" class="btn">기차역 상세</a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="station-basic-info">
										<div class="info-top">
											<h3 id="info">기본 정보</h3>
											<div class="station-info">
												<%=stationVo.getInfo() %>
											</div>
										</div>
										<div class="info-bottom">
											<h3>서울역 연혁</h3>
											<ol>
												<% StringTokenizer st=new StringTokenizer(stationVo.getHistory(),"]");
													while(st.hasMoreTokens()){ %>
													<li>&nbsp;<%=st.nextToken() %>
													</li>
													<% } %>
											</ol>
										</div>
										<% } %>

									<div class="station-map-info">
										<h3>위치/교통</h3>

										<div id="map" style="width:1100px;height:700px;"></div>
										<script>
				<% for (StationVo stationVo : list) { %>
					var container = document.getElementById('map');
												var options = {
													center: new kakao.maps.LatLng(<%=stationVo.getMlink() %>),
													level: 3
												};

												var map = new kakao.maps.Map(container, options);
												// 마커가 표시될 위치입니다
												var markerPosition = new kakao.maps.LatLng(<%=stationVo.getMlink() %>);

												// 마커를 생성합니다
												var marker = new kakao.maps.Marker({
													position: markerPosition
												});

												// 마커가 지도 위에 표시되도록 설정합니다
												marker.setMap(map);
					<%} %>

										</script>
									</div>
								</div>--%>
								<jsp:include page="../footer.jsp"></jsp:include>
							</div>
						</div>
					</body>
				</html>