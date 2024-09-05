$(document).ready(function () {
    // 폼 제출 이벤트 처리
    $('#find-pwd-form').on('submit', function (event) {
        event.preventDefault();  // 기본 폼 제출 동작을 막음

        let member_name = $('#member_name').val();
        let username = $('#username').val();

        // 유효성 검사
        if (member_name === '') {
            alert('이름을 입력해주세요.');
            return false;  // 유효성 검사 실패 시 제출 중단
        }

        if (username === '') {
            alert('이메일을 입력해주세요.');
            return false;  // 유효성 검사 실패 시 제출 중단
        }

        // AJAX 요청 전송
        $.ajax({
            url: '/members/find-pwd',  // 서버에서 비밀번호 찾기 처리하는 URL
            type: 'POST',

            success: function (data) {
                if(data) {
                    console.log("성공")
                } else {
                    console.log("실패");
                }
            },
            error: function (xhr, status, error) {
                console.error("에러 발생: " + error);
                alert("비밀번호 찾기 요청 중 문제가 발생했습니다.");
            }
        });
    });
});
