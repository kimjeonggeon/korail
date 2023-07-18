<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>고속버스통합예매 - 우대예약 등록</title>

    <link rel="styleSheet" type="text/css"
          href="http://localhost:9000/css/s_reservation.css">
    <script src="http://localhost:9000/js/am-pagination.js"></script>
</head>
<body class="sub KO">
<div id="wrap">
    <jsp:include page="../gnb2.jsp"></jsp:include>
    <div id="content" style="padding-top: 0px;">
        <div id="contentWrap">
            <div class="dimmed"></div>
            <div id="contents" style="padding-top: 0px;">
                <jsp:include page="/header_sreser"></jsp:include>
                <div class="page">
                    <div class="list_div">
                        <strong>이용안내</strong>
                        <ul class="desc_list">
                            <li>대상 : 코레일 멤버십 회원 중 상이등급이 있는 국가유공자<br>
                                <p class="marL10">
                                    * 장애인은 회원 가입 후 레츠코레일 홈페이지-장애인인증등록 시 자동으로 맞춤형 우대예약서비스 등록<br>
                                <p class="marL10">* 65세 이상 생일이 도래한 철도회원은 별도 절차 없이 맞춤형
                                    우대예약서비스 등록</li>
                            <li>증빙자료 : 유공자증</li>
                            <li>승인 여부는 ‘홈 > 마이페이지 > 회원정보관리’에서 확인할 수 있으며, 영업일 기준 약 2~3일
                                정도 소요됩니다.
                            </li>
                            <li>홈페이지에서 증빙자료를 등록하신 경우는 역 창구를 방문하시지 않고, 인증 절차를 거친 후 상품을
                                이용하실 수 있습니다.
                            </li>
                        </ul>
                        <strong style="padding-top: 15px">개인정보 수집 및 이용에 대한 동의</strong>
                        <ul class="desc_list">
                            <li class="desc_list_dt">1. 개인정보의 수집/이용 목적
                                <p class="marL10" style="color: #0002ffa8; font-weight: bold;">레츠코레일에서는
                                    회원의 이름, 유공자 유형을 수집 및 이용합니다.</p>
                            </li>
                            <li class="desc_list_dt">2. 수집하려는 개인정보의 항목
                                <p class="marL10" style="color: #0002ffa8; font-weight: bold;">회원의
                                    이름, 유공자 유형</p>
                            </li>
                            <li class="desc_list_dt">3. 개인정보의 보유 및 이용기간
                                <p class="marL10" style="color: #0002ffa8; font-weight: bold;">회원탈퇴시
                                    까지</p>
                            </li>
                            <li class="desc_list_dt">4. 동의를 거부할 권리가 있다는 사실과 동의거부에 따른
                                불이익 내용
                                <p class="marL10" style="color: #0002ffa8; font-weight: bold;">귀하는
                                    개인정보의 수집 및 이용 동의를 거부할 수 있으며, 동의 거부 시에는 예매 서비스가 제한됩니다.</p>
                            </li>
                            <input type="checkbox" id="chkAgree" name="chkAgree"
                                   title="개인정보 수집 및 이용 안내 동의" style="margin-top: 15px;">
                            개인정보 수집 및 이용에 대한 안내에 동의합니다.
                        </ul>
                        <strong style="padding-top: 15px">우대서비스 종류를 선택하시고 첨부파일을
                            등록하시기 바랍니다.</strong>
                        <div style="width: 100%;">
                            <form name="preferential" action="preferential_proc" method="post"
                                  enctype="multipart/form-data">
                                <table>
                                    <tbody>
                                    <tr>
                                        <th scope="row"><%--@declare id="reguserid"--%><label for="regUserId">우대서비스
                                            대상</label></th>
                                        <td>
                                            <select name="preferential" id="svcType" title="우대서비스대상"
                                                    class="ipt_st04" style="margin-top: 3px;">
                                                <option value="01" selected>경로자</option>
                                                <option value="02">장애인</option>
                                                <option value="03">유공자</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr id="apply_input">
                                        <th scope="row" style="height: inherit;"><%--@declare id="filename"--%><label
                                                for="filename">첨부파일</label></th>
                                        <td><input type="file" name="file1" id="file"
                                                   style="width: 450px; background-color: #ffffff;"><br>
                                            <p>주민등록번호 뒷자리를 마스킹(음영처리) 하지 않을 시 제출하신 서류가 반송됩니다.</p></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                        <button type="button" name="preferential_btn"
                                id="preferential_btn">신청하기
                        </button>
                    </div>
                </div>
                <jsp:include page="../footer.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
</body>
</html>