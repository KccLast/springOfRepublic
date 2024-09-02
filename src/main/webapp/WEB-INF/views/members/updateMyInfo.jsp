<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>마이페이지</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/members/updateMyInfo.css">
</head>
<body>
<%@include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <div class="tab-menu">
            <ul>
                <li>내 정보</li>
                <li>내 예약</li>
                <li>내 리뷰</li>
            </ul>
        </div>
        <div class="my-info">
            <div class="profile-container">
                <img class="profile-image" src="/resources/img/members/profile.png" alt="프로필">
                <img class="camera-icon" src="/resources/img/members/camera.png" alt="카메라 ">
            </div>
            <p>닉네임</p>
            <input type="text" name="member_name" placeholder="닉네임을 입력하세요">
            <p class="p-email">자기소개</p>
            <textarea name="self-intro" rows="5" cols="50"
                      placeholder="자신을 알릴 수 있는 소개글을 작성해 주세요."></textarea>
            <button class="btn-update-info">회원 정보 수정</button>
        </div>
    </div>
</div>
</body>
</html>