$(document).ready(function() {
    $('.submit-button').on('click', function() {
        alert('리뷰가 제출되었습니다!');


        var reviewText = $('textarea[name="reviewText"]').val();

        $.ajax({
            url: 'submitReview',
            method: 'POST',
            data: {
                reviewText: reviewText
                // Add other form data here
            },
            success: function(response) {
                // Handle the response from the server
                alert('리뷰가 성공적으로 제출되었습니다!');
            },
            error: function(xhr, status, error) {
                // Handle any errors
                alert('리뷰 제출에 실패했습니다. 다시 시도해 주세요.');
            }
        });
    });
});
