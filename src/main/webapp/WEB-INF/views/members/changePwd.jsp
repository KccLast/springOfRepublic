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
            <h2>비밀번호 변경</h2>
            <form class="login-form" action="/members/login" method="post">
                <input type="text" id="password" name="password" placeholder="새 비밀번호 입력">
                <input type="text" id="member_new_pwd" name="member_new_pwd" placeholder="새 비밀번호 확인">
                <input type="submit" class="btn-next" value="비밀번호 변경">
            </form>
        </div>
    </div>
</div>
</body>
</html>