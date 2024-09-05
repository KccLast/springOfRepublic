$(document).ready(function () {
    // 예약 취소 버튼 클릭 이벤트
    $('.cancel-button').on('click', function (event) {


      let del = $('#d-reservation-box').find('input[type=radio]:checked').parent().parent().find(".d-r-name > span").text();
       let price =  $('#d-reservation-box').find('input[type=radio]:checked').parent().parent().find(".d-res-price > span").text();

        var reservationId = $(this).data('reservation_id');

        if (confirm("정말 이 예약을 취소하시겠습니까?")) {
            // 예약 취소를 위한 POST 요청
            /*$.get('/reservation/cancel/confirm?reservation_Id')
                .done(function (response) {
                    alert("예약이 취소되었습니다.");
                    // 페이지를 새로고침하여 변경된 예약 목록을 표시
                    window.location.href = '/mypage/reservation1/reservation_list?memberId=1';
                })
                .fail(function () {
                    alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
                });*/
            $.ajax({
                type: 'POST',
                url: `http://localhost:8085/reservation/cancel/confirm`,
                contentType: 'application/json', // JSON 데이터를 전송할 때 Content-Type 설정
                data: JSON.stringify({
                    reservation_Id: del,
                    reservation_price: price
                }),
                success: function(response) {
                    alert(response);
                    // 페이지를 새로고침하여 변경된 예약 목록을 표시
                    location.reload(true);
                },
                error: function() {
                    alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
                }
            });
                // .done(function (response) {
                //     alert("예약이 취소되었습니다.");
                //     // 페이지를 새로고침하여 변경된 예약 목록을 표시
                //     window.location.href = '/mypage/reservation1/reservation_list?memberId=1';
                // })
                // .fail(function () {
                //     alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
                // });
        }
    });
});







