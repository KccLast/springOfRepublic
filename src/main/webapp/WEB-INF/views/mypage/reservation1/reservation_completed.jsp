<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/reservation/reservation_completed.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // 모든 tab-button에서 active 클래스 제거
            var buttons = document.querySelectorAll('.tab-button');
            buttons.forEach(function(button) {
                button.classList.remove('active');
            });

            // 두 번째 자식 (index는 1)에게 active 클래스 추가
            if (buttons[1]) {
                buttons[1].classList.add('active');
            }
        });
    </script>
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">

        <div class="content">
            <%@include file="/resources/common/mypageHeader.jsp" %>

            <nav>
                <ul>
                    <li><a href="/reservation/list/${member_id}" class="btn-reservation">예약</a></li>
                    <li><a href="/reservation/completed/${member_id}" class="btn-complete">방문 완료</a></li>
                    <li><a href="/reservation/cancel/${member_id}"  class="btn-cancel">예약 취소</a></li>
                </ul>
            </nav>
        </div>

        <div id="d-reservation-box">
            <c:forEach var="reservation" items="${completedReservations}">
                <div class="j-reservation-id">${reservation.reservation_Id}</div>
                <div class="d-res-content-box">
                    <div class="d-res-button">
                        <input type="radio" id="option1" name="options" value="option1">
                    </div>
                    <div class="d-res-content-ch-box">
                        <div class ="d-res-img-box">
                            <img src="/resources/image/${reservation.restaurant_img}" alt="Insert Image"/>
                        </div>
                        <div class="d-res-name-box">
                            <div class="d-r-name">
                                <span>${reservation.restaurant_name}</span>
                            </div>
                            <div class="d-r-district">
                                <span>${reservation.restaurant_address}</span>
                            </div>
                        </div>
                        <div class="d-res-date-box">
                            <div class="d-res-date-1">
                                방문 날짜 : <span><fmt:formatDate value="${reservation.reservation_reg_date}" pattern="yyyy.MM.dd" /></span>
                            </div>
                            <div class="d-res-date-2">
                                방문 시간 : <span><fmt:formatDate value="${reservation.reservation_reg_date}" pattern="a h:mm" /></span>
                            </div>
                            <div class="d-res-per-1">
                                방문 인원 : <span>${reservation.reservation_per}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="submit-button-size">
            <button class="submit-button" id="openReviewModal">리뷰 작성</button>
        </div>

        <!-- 리뷰 작성 모달 -->
        <div class="j-modal" style="display:none;">
            <form action="/review/insert" method="post" enctype="multipart/form-data">
                <input type="hidden" name="reservation_id" class="j-reservation_id" />
                <input type="hidden" name="member_id" class="j-member-id" value="101">
            <div class="j-modal_body">
                <!-- 닫기 버튼 추가 -->
                <div class="close-button" id="closeModal">x</div>

                <div class="d-res-details-box">

                    <div class="d-res-details-content">
                        <div id="j-reviewid" style="display:none;"></div>
                        <h2 id="restaurantName"></h2>
                        <p id="restaurantDistrict"></p>

                        <div class="d-image-section">
                            <input type="file" name="review_img" id="review_img_box">
                            <img id="j-preview" />
                        </div>

                        <p>방문 날짜: <span id="reservationDate"></span></p>
                        <p>방문 시간: <span id="reservationTime"></span></p>
                        <p><span id="reservationPer"></span>명</p>

                        <div class="d-review-content">
                            <label for="review_score">리뷰 점수:</label>
                            <input type="number" id="review_score" min="1" max="5" name="review_score">

                            <label for="review_content">리뷰 내용:</label>
                            <textarea id="review_content" name="review_content"></textarea>
                        </div>
                    </div>

                </div>

                <div class="d-button-group">
                    <input type="submit" class="d-save-button" id="saveReview" value="저장"/>
                </div>
            </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>

            $(function (){
                let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
                $('.j-member-id').val(member_id);

                $('#openReviewModal').click(function (e) {
                    console.log($('.j-member-id').val());
                    if($('input[name="options"]:checked').length===0)return false;

                    let $parent = $('input[name="options"]:checked').parent().parent();

                    // 모달에 데이터 채워넣기
                    $('#restaurantName').text($parent.find('.d-r-name').text());
                    $('#restaurantDistrict').text($parent.find('.d-r-district').text());
                    $('#restaurantImage').attr('src', $parent.find('.d-res-img-box > img').attr('src'));
                    $('#reservationDate').text($parent.find('.d-res-date-1 > span').text());
                    $('#reservationTime').text($parent.find('.d-res-date-2 > span').text());
                    $('#reservationPer').text($parent.find('.d-res-per-1').text());

                    $('.j-reservation_id').val($parent.parent().find('.j-reservation-id').text());

                    // 모달 열기
                    $('.j-modal').show();
                });
                $('#closeModal').click(function () {
                    document.getElementById('j-preview').src = "";
                    $('#review_img_box').val('');
                            $('.j-modal').hide();
                        });

                $('#review_img_box').change(function (){
                    readURL(this);
                })

            })

            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        document.getElementById('j-preview').src = e.target.result;
                    };
                    reader.readAsDataURL(input.files[0]);
                } else {
                    document.getElementById('j-preview').src = "";
                }
            }






                // 리뷰 작성 버튼 클릭 시 모달 열기


                // 모달 닫기 버튼 클릭 시
            //     $('#closeModal').click(function () {
            //         $('.j-modal').hide();
            //     });
            //
            //     // 모달 외부 클릭 시 모달 닫기
            //     // $(window).click(function (event) {
            //     //     if ($(event.target).hasClass('j-modal')) {
            //     //         $('.j-modal').hide();
            //     //     }
            //     // });
            //
            //     // 리뷰 저장 버튼 클릭 시
            //     $('#saveReview').click(function (event) {
            //         event.stopPropagation();
            //         var reviewScore = $('#review_score').val();
            //         var reviewContent = $('#review_content').val();
            //
            //         // 유효성 검사
            //         if (!reviewScore || reviewScore < 1 || reviewScore > 5) {
            //             alert('리뷰 점수는 1에서 5 사이여야 합니다.');
            //             return;
            //         }
            //         if (reviewContent.trim() === '') {
            //             alert('리뷰 내용을 작성해주세요.');
            //             return;
            //         }
            //
            //         // '방문 인원 : 2' 형태에서 숫자만 추출
            //         var reservationPer = $('#reservationPer').text(); // "방문 인원 : 2" 라는 텍스트를 가져옴
            //         reservationPer = reservationPer.replace("방문 인원 : ", "").trim(); // "방문 인원 : " 부분을 제거하고 숫자만 추출
            //
            //         // 준비된 데이터를 객체로 변환
            //         var reviewData = {
            //             review_score: reviewScore,
            //             review_content: reviewContent,
            //             restaurant_name: $('#restaurantName').text(),
            //             restaurant_address: $('#restaurantDistrict').text(),
            //             reservation_date: $('#reservationDate').text(),
            //             reservation_time: $('#reservationTime').text(),
            //             reservation_per: parseInt(reservationPer, 10) // 숫자 값으로 변환하여 전송
            //         };
            //
            //         $.ajax({
            //             url: '/review/insert',
            //             method: 'POST',
            //             contentType: 'application/json',
            //             data: JSON.stringify(reviewData),
            //             success: function (response) {
            //                 if (response.success) {
            //                     alert('리뷰가 저장되었습니다.');
            //                     window.location.href = '/mypage/review1/review_list';
            //                 } else {
            //                     alert('리뷰 저장에 실패했습니다: ' + response.message);
            //                 }
            //             },
            //             error: function () {
            //                 alert('리뷰 저장에 실패했습니다.');
            //             }
            //         });
            //
            //         // 모달 닫기
            //         $('.j-modal').hide();
            //     },false);
            //
            // });

            // $('#openReviewModal').click(function () {
            //     let $selectedOption = $('input[name="options"]:checked');
            //
            //     if ($selectedOption.length === 0) {  // 아무 옵션도 선택되지 않았을 때
            //         alert('먼저 예약을 선택해주세요.');
            //         return;
            //     }
            //
            //     let $parent = $selectedOption.parent().parent();
            //     console.log($parent);
            //
            //     // 데이터 채워넣기
            //     $('#restaurantName').text($parent.find('.d-r-name').text());
            //     $('#restaurantDistrict').text($parent.find('.d-r-district').text());
            //     $('#restaurantImage').attr('src', $parent.find('.d-res-img-box > img').attr('src'));
            //     $('#reservationDate').text($parent.find('.d-res-date-1 > span').text());
            //     $('#reservationTime').text($parent.find('.d-res-date-2 > span').text());
            //     $('#reservationPer').text($parent.find('.d-res-per-1').text());
            //
            //     // Hidden input에 reservation_id 값 넣기
            //     $('input[type=hidden]').val($parent.find('.j-reservation-id').text());
            //
            //     // 모달 열기
            //     $('.j-modal').show();
            // });

        </script>


    </div>
</div>


</body>
</html>
