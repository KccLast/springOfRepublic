function login_check() {
    let username = $('#username').val();
    let password = $('#password').val();

    if(username == '') {
        alert('이메일을 입력해주세요.');
        return false;
    }

    if(password == '') {
        alert('비밀번호를 입력해주세요.');
        return false;
    }

    $.ajax({
        url: '/members/login',
        type: 'POST',
        data: {
            username: username,
            password: password
        },
        success: function (response) {
            if(!response.redirect) {
                $("#password").val('');
                alert('등록되지 않은 이메일이거나 이메일 또는 비밀번호를 잘못 입력했습니다.');
            }
        },
        error: function (xhr, status, error) {
            console.error("에러 발생: " + error);
            alert("로그인 중 문제가 발생했습니다.");
        }
    });
}
// $(document).ready(function () {
//     $(".login-form").on("submit", function (event) {
//         const username = $("#username").val();
//         const password = $("#password").val();
//
//         $.ajax({
//             url: "/members/login",
//             type: "POST",
//             data: {
//                 username: username,
//                 password: password
//             },
//             success: function (response) {
//                 if (response.redirect) {
//                     window.location.href = response.redirect;
//                 } else {
//                     alert(response.message || "아이디와 비밀번호가 일치하지 않습니다.");
//                 }
//             },
//             error: function (xhr, status, error) {
//                 console.log("Error: ", error);
//                 alert("로그인 실패");
//             }
//         });
//     })
// })