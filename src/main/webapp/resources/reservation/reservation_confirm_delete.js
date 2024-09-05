
$(document).ready(function() {

    $('#d-cancel-box').on('click', function() {
        const memberId = $(this).data('member_id');
        alert("취소된 예약 ID: " + memberId);
    });

});





