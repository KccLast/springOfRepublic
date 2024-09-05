$(document).ready()
{
    let link = document.location.href;
    let login_check = link.includes("login?error");

    if (login_check) {
        alert("등록되지 않은 이메일이거나 이메일 또는 비밀번호가 일치하지 않습니다.");
    }
}