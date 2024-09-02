<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/members/join.css">
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>

<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <h2>회원가입</h2>
        <div class="join-container">
            <div class="profile-container">
                <img class="profile-image" src="/resources/img/members/profile.png" alt="프로필">
                <img class="camera-icon" src="/resources/img/members/camera.png" alt="카메라">
            </div>

            <!-- 회원가입 폼 -->
            <form:form id="join-form" modelAttribute="memberDto" action="/members/join" method="post">
                <!-- 이메일 입력 필드 -->
                <div class="email-container">
                    <form:input type="email" id="username" class="form-control" path="username"
                                placeholder="이메일 주소"/>

                    <div class="duplicate-btn">
                        <button type="button" onclick="duplicate_check();" class="btn-info">중복 확인</button>
                    </div>
                </div>
                <form:errors path="username" cssClass="error-message"/>
                <!-- 비밀번호 입력 필드 -->
                <div class="password-container">
                    <form:input type="password" id="password" class="form-control" path="password"
                                placeholder="비밀번호(문자, 숫자, 특수문자 포함 8~16자)"/>
                </div>
                <form:errors path="password" cssClass="error-message"/>
                <!-- 비밀번호 확인 입력 필드 -->
                <div class="password-confirm-container">
                    <form:input type="password" id="password_confirm" class="form-control" path="password_confirm"
                                placeholder="비밀번호 확인"/>

                </div>
                <form:errors path="password_confirm" cssClass="error-message"/>
                <!-- 이름 입력 필드 -->
                <div class="name-container">
                    <form:input type="text" id="member_name" class="form-control" path="member_name" placeholder="이름"/>
                </div>
                <form:errors path="member_name" cssClass="error-message"/>
                <!-- 닉네임 입력 필드 -->
                <div class="nickname-container">
                    <form:input type="text" id="member_nick" class="form-control" path="member_nick" placeholder="닉네임"/>
                </div>
                <form:errors path="member_nick" cssClass="error-message"/>
                <!-- 주소 입력 필드 -->
                <div class="address-container">
                    <form:input type="text" id="member_address" class="form-control" path="member_address"
                                placeholder="주소"/>
                </div>
                <form:errors path="member_address" cssClass="error-message"/>
                <!-- 전화번호 입력 필드 -->
                <div class="phone-container">
                    <form:input type="tel" id="member_phone" class="form-control" path="member_phone"
                                placeholder="전화번호(ex.010-1111-2222)"/>
                </div>
                <form:errors path="member_phone" cssClass="error-message"/>
                <!-- 회원가입 버튼 -->
                <div class="submit-container">
                    <input type="submit" class="btn btn-success mt-3" id="submit-btn" value="회원가입"/>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="/resources/js/members/join.js"></script>

</body>
</html>
