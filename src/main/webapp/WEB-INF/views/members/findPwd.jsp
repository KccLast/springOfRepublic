<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/members/login.css">
    <link rel="stylesheet" href="/resources/css/members/findPwd.css">
</head>
<body>
<%@include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <div class="login-content">
            <img src="/resources/img/logo.png" alt="로고">
            <h2>비밀번호 찾기</h2>
            <form class="login-form" id="find-pwd-form" action="/members/change-pwd" method="post">
                <p>가입된 계정의 이메일을 정확히 기입해주시길 바랍니다.</p>
                <input type="text" id="member_name" name="member_name" placeholder="이름을 입력하세요">
                <input type="text" id="username" name="username" placeholder="이메일을 입력하세요">
                <input class="btn-next" type="submit"  value="다음">
            </form>
        </div>
    </div>
</div>
<script src="/resources/js/members/findPwd.js"></script>
</body>
</html>