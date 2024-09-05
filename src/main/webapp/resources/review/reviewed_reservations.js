//     $(document).ready(function() {
//     // 리뷰 작성 버튼 클릭 이벤트
//     $('.review-button').on('click', function() {
//         var reservationId = $(this).data('reservation-id');
//         // 모달창에 예약 정보를 표시하는 로직
//         var reservationData = $(this).closest('.d-res-content-box');
//         $('#modal-restaurant-name').text(reservationData.find('.d-r-name').text());
//         $('#modal-restaurant-info').text(reservationData.find('.d-r-district').text());
//         $('#modal-visit-date').text(reservationData.find('.d-res-date-1 span').text());
//         $('#modal-person-count').text(reservationData.find('.d-res-date-3 span').text());
//
//         // 모달창 열기
//         $('#reviewModal').fadeIn();
//     });
//
//     // 모달창 닫기 버튼 이벤트
//     $('#closeModal').on('click', function() {
//     $('#reviewModal').fadeOut();
// });
// });
