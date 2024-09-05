<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/review/review_list.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // 모든 tab-button에서 active 클래스 제거
            var buttons = document.querySelectorAll('.tab-button');
            buttons.forEach(function(button) {
                button.classList.remove('active');
            });

            // 두 번째 자식 (index는 1)에게 active 클래스 추가
            if (buttons[2]) {
                buttons[2].classList.add('active');
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

        </div>

        <div id="d-cancel-box">
            <!-- 취소하려는 예약 정보를 표시 -->
            <c:forEach var="review" items="${reviews}">
                <div class="d-res-content-box">

                    <div class="d-res-content-ch-box">
                        <input type="hidden" value="${review.reservation_id}">
                         <%--이미지파일첨부--%>
                        <div class="d-res-img-box">
                            <img id="${review.reservation_id}" src="/resources/image/${review.restaurant_img}" alt="Insert Image"/>
                        </div>

                        <div class="d-res-name-box">
                            <div class="d-r-name">${review.restaurant_name}</div>
                            <div class="d-r-district">
                                <span>${review.restaurant_type} - ${review.restaurant_address}</span></div>
                            <div class="d-score">
                                <p>리뷰 점수: ⭐${review.review_score} / 5.0</p>
                            </div>
                        </div>
                        <div class="d-res-date-box">
                            <div class="d-res-date-1">
                               방문 날짜 : <span><fmt:formatDate value="${review.reservation_reg_date}" pattern="yyyy.MM.dd" /></span>
                            </div>
                            <div class="d-res-date-2">
                                방문 시간 : <span><fmt:formatDate value="${review.reservation_reg_date}" pattern="a h:mm" /></span>
                            </div>
                            <div class="d-res-date-3">
                                예약 인원 : <span>${review.reservation_per}</span>명
                            </div>
                        </div>
                        <div class="j-review-content">${review.review_content}</div>

<%--                        <!-- 이미지 파일 업로드 추가 -->--%>
<%--                        <div class="file-upload-box">--%>
<%--                            <label for="file-input-${review.reservation_id}">이미지 업로드:</label>--%>
<%--                            <input type="file" id="file-input-${review.reservation_id}" accept="image/*">--%>
<%--                        </div>--%>

                        <!-- 상세보기 버튼 추가 -->
                        <div class="details-button-box">
                            <button class="details-button">상세보기</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
<%--            .details-button--%>


        </div>
    </div>
</div>

<div class="j-modal" style="display:none;">
<%--    실제 모달창 내가 다룰 거--%>
    <div class="j-modal_body">

        <!-- 닫기 버튼 추가 -->
        <button class="close-button" id="closeModal">&times</button>

        <div class="d-res-details-box">
            <div class="d-res-details-content">
                <div id="j-reviewid"></div>
                <h2 id="restaurantName"></h2>
                <p id="restaurantDistrict"></p>


                <div class="d-image-section">
                    <img src="/resources/image/veganbread.png" alt="Vegan Bread Image">
                </div>

                <p>방문 날짜: <span id="visitDate"></span></p>
                <p>방문 시간: <span id="visitTime"></span></p>
                <p>예약 인원: <span id="reservationPer"></span></p>
                <p>리뷰 점수: <span id="reviewScore"></span></p>

                <div class="d-review-content">
                    <p>리뷰 내용:</p>
                    <textarea id="reviewContent" disabled>Insert Content</textarea>
                </div>
            </div>
        </div>

        <div class="d-button-group">
            <button class="d-edit-button" id="editReview">수정하기</button>
            <button class="d-delete-button" id="deleteReview">삭제하기</button>
        </div>
    </div>
</div>


    <script src="/resources/review/review_details.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    document.getElementById('closeModal').addEventListener('click', function () {
        // 모달 창을 닫기
        document.querySelector('.j-modal').style.display = 'none';


    });
    $(function () {
        // 모달을 여는 부분
        $("#d-cancel-box").on('click', '.details-button', function () {
            // 버튼의 부모 요소에서 데이터를 가져옴
            var $parentBox = $(this).closest('.d-res-content-box');

            // 데이터 추출
            var restaurantName = $parentBox.find('.d-r-name').text();
            var restaurantDistrict = $parentBox.find('.d-r-district span').text();
            var visitDate = $parentBox.find('.d-res-date-1 span').text();
            var visitTime = $parentBox.find('.d-res-date-2 span').text();
            var reservationPer = $parentBox.find('.d-res-date-3 span').text();
            var reviewScore = $parentBox.find('.d-score p').text().replace('리뷰 점수: ⭐', '').trim();
            var restaurantImage = $parentBox.find('.d-res-img-box img').attr('src');
            var rev = $parentBox.find('.j-review-content').text();
            var reviewId = $parentBox.find('input[type=hidden]').val();

            console.log(rev);

            // 모달에 데이터 삽입
            $('.j-modal_body #restaurantName').text(restaurantName);
            $('.j-modal_body #restaurantDistrict').text(restaurantDistrict);
            $('.j-modal_body #visitDate').text(visitDate);
            $('.j-modal_body #visitTime').text(visitTime);
            $('.j-modal_body #reservationPer').text(reservationPer + '명');
            $('.j-modal_body #reviewScore').text('⭐' + reviewScore);
            $('.j-modal_body #reviewContent').text(rev);
            $('.j-modal_body .d-image-section img').attr('src', restaurantImage);
            $('.j-modal_body  #j-reviewid').text(reviewId);

            // textarea를 disabled 상태로 설정
            $('#reviewContent').prop('disabled', true);

            // 모달 표시
            $('.j-modal').show();
        });

        // 수정하기 버튼 클릭 이벤트 (이벤트 위임 사용)
        $(document).on('click', '#editReview', function () {
            var isDisabled = $('#reviewContent').prop('disabled');
            $('#reviewContent').prop('disabled', !isDisabled);

            // 활성화에서 비활성화로 전환될 때 (수정 완료 시)
            if (!isDisabled) {

                var updatedReviewContent = $('#reviewContent').val();
                var reviewId = $('#j-reviewid').text();


                $.ajax({
                    url: '/review/updateReview', // 서버의 리뷰 업데이트 URL
                    method: 'POST',
                    contentType: 'application/json', // 요청의 Content-Type을 JSON으로 설정
                    cache: false,
                    data: JSON.stringify({
                        reservation_id: reviewId,
                        review_content: updatedReviewContent
                    }),
                    // success: function(response) {
                    //     if (response.success) {
                    //         alert('수정이 완료되었습니다!');
                    //     }
                    // },
                    // error: function() {
                    //     alert('수정에 실패했습니다.');
                    // }
                    success: function (response) {
                        if (response.success) {
                            alert('수정이 완료되었습니다!');
                            location.reload();
                        } else {
                            alert('수정에 실패했습니다: ' + response.message);
                        }
                    }

                });
            }
        });

        // 삭제하기 버튼 클릭 이벤트
        $('#deleteReview').on('click', function () {
            var reviewId = $('#j-reviewid').text();


            if (confirm('정말로 이 리뷰를 삭제하시겠습니까?')) {
                $.ajax({
                    url: '/review/deleteReview/' + reviewId,  // 서버의 리뷰 삭제 URL
                    method: 'GET',
                    //contentType: 'application/json', // 요청의 Content-Type을 JSON으로 설정

                    success: function (response) {

                        alert('리뷰가 삭제되었습니다.');
                        location.reload();

                    },
                    error: function () {
                        alert('삭제에 실패하였습니다.');
                    }
                });
            }
        });

        // 모달 닫기 기능 추가 (필요 시)
        // $('.j-modal').on('click', function() {
        //     $(this).hide();
        // });
    });



</script>

</body>

</html>
