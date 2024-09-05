$(document).ready(function() {
    // 상세보기 버튼 클릭 이벤트
    $('.details-button').on('click', function() {
        // var reservationId = $(this).data('reservation-id');
        // // 상세보기 페이지로 이동 (임시 경로 설정)
        // window.location.href = 'mypage/review1/details?reservationId=' + reservation_Id;
    });
});

// //이미지 미리보기 기능
// $(document).ready(function() {
//     $('input[type="file"]').on('change', function(event) {
//         const file = event.target.files[0];
//         const reservationId = $(this).attr('id').split('-').pop(); // id에서 reservation_id 추출
//         const $previewImg = $(`#preview-img-${reservationId}`);
//
//         if (file) {
//             const reader = new FileReader();
//             reader.onload = function(e) {
//                 $previewImg.attr('src', e.target.result);
//                 $previewImg.show(); // 이미지가 보이도록 설정
//             }
//             reader.readAsDataURL(file);
//         }
//     });
// });

// // 서버에 파일 업로드
// $('#submit-review-form').on('submit', function(event) {
//     event.preventDefault(); // 폼의 기본 제출 동작 방지
//
//     const formData = new FormData(this); // 폼 데이터를 가져오기
//
//     $.ajax({
//         url: '/uploadReview', // 서버의 파일 업로드 엔드포인트
//         type: 'POST',
//         data: formData,
//         contentType: false,
//         processData: false,
//         success: function(response) {
//             alert('파일업로드 성공!');
//         },
//         error: function(jqXHR, textStatus, errorThrown) {
//             console.error('Error:', textStatus, errorThrown);
//             alert('제출 에러임');
//         }
//     });
// });
