// $(document).ready(function() {
//     // 모달을 여는 부분
//     $(".submit-button").on('click', function() {
//         var $parentBox = $(this).closest('.d-res-content-box');
//
//         // 데이터 추출
//         var restaurantName = $parentBox.find('.d-r-name').text();
//         var restaurantDistrict = $parentBox.find('.d-r-district span').text();
//         var visitDate = $parentBox.find('.d-res-date-1 span').text();
//         var visitTime = $parentBox.find('.d-res-date-2 span').text();
//         var reservationPer = $parentBox.find('.d-res-date-3 span').text();
//         var restaurantImage = $parentBox.find('.d-res-img-box img').attr('src');
//         var reviewId = $parentBox.find('input[type=hidden]').val();
//
//         // 모달에 데이터 삽입
//         $('#restaurantName').text(restaurantName);
//         $('#restaurantDistrict').text(restaurantDistrict);
//         $('p#visitDate span').text(visitDate);
//         $('p#visitTime span').text(visitTime);
//         $('p#reservationPer span').text(reservationPer + '명');
//         $('.d-image-section img').attr('src', restaurantImage);
//         $('#j-reviewid').text(reviewId);
//
//         // 모달 표시
//         $('.j-modal').show();
//     });
//
//     $(document).ready(function() {
//         $('.submit-button').on('click', function() {
//             alert('리뷰가 제출되었습니다!');
//
//             var reviewText = $('#review_content').val();
//             var reviewScore = $('#review_score').val();
//
//             $.ajax({
//                 url: 'submitReview',
//                 method: 'POST',
//                 data: {
//                     reviewText: reviewText,
//                     reviewScore: reviewScore
//                 },
//                 success: function(response) {
//                     alert('리뷰가 성공적으로 제출되었습니다!');
//                     location.reload();
//                 },
//                 error: function(xhr, status, error) {
//                     alert('리뷰 제출에 실패했습니다. 다시 시도해 주세요.');
//                 }
//             });
//         });
//     });
//
//
//     // 모달 닫기 기능
//     $('#closeModal').on('click', function() {
//         // 모달 닫기 전 데이터 초기화
//         $('#restaurantName').text('');
//         $('#restaurantDistrict').text('');
//         $('p#visitDate span').text('');
//         $('p#visitTime span').text('');
//         $('p#reservationPer span').text('');
//         $('#review_score').val('');
//         $('#review_content').val('');
//         $('.j-modal').hide();
//     });
// });
