$(document).ready(function() {
    // 리뷰 수정하기 버튼 클릭 이벤트
    $('#editReview').on('click', function() {
        var reviewId = $(this).data('review-id');
        // 리뷰 수정 페이지로 이동 (임시 경로 설정)
        window.location.href = '/review/edit?reviewId=' + reviewId;
    });

    // 리뷰 삭제하기 버튼 클릭 이벤트
    $('#deleteReview').on('click', function() {
    var reviewId = $(this).data('review-id');
    if (confirm("정말 이 리뷰를 삭제하시겠습니까?")) {
    $.post('/review/delete', { reviewId: reviewId })
    .done(function(response) {
    alert("리뷰가 삭제되었습니다.");
    // 리뷰 목록 페이지로 리다이렉트
    window.location.href = '/review1/review.jsp';
})
    .fail(function() {
    alert("리뷰 삭제에 실패했습니다. 다시 시도해주세요.");
});
}
});
});
