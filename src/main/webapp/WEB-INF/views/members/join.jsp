<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/join/join.css">
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <h2>회원가입</h2>
        <div class="join-container">
            <div class="profile-container">
                <img class="profile-image" src="/resources/img/join/profile.png" alt="프로필">
                <img class="camera-icon" src="/resources/img/join/camera.png" alt="카메라">
            </div>

            <form id="join-form" action="" method="post">
                <div class="email-container">
                    <input type="text" id="email" class="form-control" name="member_email" placeholder="이메일 주소">
                    <div class="duplicate-btn">
                        <button type="button" class=" btn-info">중복 확인</button>
                    </div>
                </div>

                <input type="password" id="password" class="form-control" name="member_pwd"
                       placeholder="비밀번호(문자, 숫자, 특수문자 포함 8~20자)">
                <input type="password" id="password-confirm" class="form-control" name="member_pwd_confirm"
                       placeholder="비밀번호 확인">

                <input type="text" id="name" class="form-control" name="member_name" placeholder="이름">
                <input type="text" id="nickname" class="form-control" name="member_nick" placeholder="닉네임">
                <input type="text" id="address" class="form-control" name="member_address" placeholder="주소">

                <input type="tel" id="phone" class="form-control" name="member_phone"
                       placeholder="전화번호(ex.010-1111-2222)">
                <input type="submit" class="btn btn-success mt-3" value="회원가입">
            </form>
        </div>

    </div>
</div>
</body>
</html>