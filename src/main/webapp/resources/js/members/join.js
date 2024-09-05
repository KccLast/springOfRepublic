$(document).ready(function () {
    // 유효성 검사
    function validateForm() {
        let isValid = true;

        // 이메일 유효성 검사
        const email = $('#username').val();
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            $('#email-error').text('유효한 이메일 주소를 입력해주세요.').show();
            isValid = false;
        } else {
            $('#email-error').hide();
        }

        // 비밀번호 유효성 검사
        const password = $('#password').val();
        const passwordRegex = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\W)(?=\S+$).{8,16}$/;
        if (!passwordRegex.test(password)) {
            $('#pwd-error').text('문자, 숫자, 특수문자 포함 8자 이상 16자 이하이어야 합니다.').show();
            isValid = false;
        } else {
            $('#pwd-error').hide();
        }

        // 비밀번호 확인
        const passwordConfirm = $('#password_confirm').val();
        if (password !== passwordConfirm) {
            $('#pwd-confirm-error').text('비밀번호가 일치하지 않습니다.').show();
            isValid = false;
        } else {
            $('#pwd-confirm-error').hide();
        }

        // 이름 유효성 검사
        const name = $('#member_name').val();
        if (name.trim() === '') {
            $('#name-error').text('이름을 입력해주세요.').show();
            isValid = false;
        } else {
            $('#name-error').hide();
        }

        // 닉네임 유효성 검사
        const nick = $('#member_nick').val();
        if (nick.trim() === '') {
            $('#nick-error').text('닉네임을 입력해주세요.').show();
            isValid = false;
        } else {
            $('#nick-error').hide();
        }

        // 주소 유효성 검사
        const address = $('#member_address').val();
        if (address.trim() === '') {
            $('#address-error').text('주소를 입력해주세요.').show();
            isValid = false;
        } else {
            $('#address-error').hide();
        }

        // 전화번호 유효성 검사
        const phone = $('#member_phone').val();
        const phoneRegex = /^\d{3}-\d{4}-\d{4}$/;
        if (!phoneRegex.test(phone)) {
            $('#phone-error').text('전화번호는 000-0000-0000 형식이어야 합니다.').show();
            isValid = false;
        } else {
            $('#phone-error').hide();
        }

        return isValid;


    }
});

let dup_check = false;

function duplicate_check() {
    let username = $("#username").val();

    if (username == '') {
        alert("이메일을 입력해주세요.");
        return false;
    }

    $.ajax({
        url: '/members/' + username,
        type: 'GET',
        success: function (data) {
            if (data == 0) {
                alert("사용 가능한 이메일입니다.");
                dup_check = true;
            } else {
                alert("이미 사용 중인 이메일입니다.");
                return false;
            }
        },
        error: function (xhr, status, error) {
            console.error("에러 발생: " + error);
        }
    });

}

// 프로필 이미지 업로드 - 사용자가 파일을 선택할 때 이벤트 발생
// function profile_img(event) {
//     const file = event.target.files[0];
//     if (file) {
//         const reader = new FileReader();
//         reader.onload = function(e) {
//             $('#profile-image').attr('src', e.target.result); // jQuery로 이미지 src 설정
//             $('#member_img').val(e.target.result.split(',')[1]); // jQuery로 input value 설정
//         };
//         reader.readAsDataURL(file);
//     }
// }

function profile_img(event) {
    var reader = new FileReader();
    reader.onload = function(e) {
        // jQuery를 사용하여 프로필 이미지 미리보기 업데이트
        $('#profile-image').attr('src', e.target.result); // 선택된 이미지로 미리보기 업데이트
    };
    // 선택한 파일을 읽음
    reader.readAsDataURL(event.target.files[0]);
}


