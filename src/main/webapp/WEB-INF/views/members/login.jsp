<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>로그인</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/members/login.css">
</head>
<body>
<%@include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <div class="login-content">
            <img src="/resources/img/logo.png" alt="로고">
            <h2>로그인</h2>
            <form class="login-form" action="" method="post">
                <input type="text" id="member_email" name="member_email" placeholder="이메일을 입력하세요">
                <input type="text" id="member_password" name="member_password" placeholder="비밀번호를 입력하세요">
                <input type="submit" value="이메일로 로그인">
            </form>
            <button class="btn-join">회원가입</button>

            <p><a href="/members/find-pwd">비밀번호를 잊으셨나요?</a></p>
        </div>
    </div>
</div>
</body>
</html>