<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Spring form 태그 라이브러리 추가 -->
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
                <label for="profile-image-input">

<%--                    <img id="profile-image" class="profile-image" src="/images/${fileName}" alt="프로필">--%>
                    <c:choose>
                        <c:when test="${loginMember.member_img.startsWith('/resources/img')}">
                            <img id="profile-image" class="profile-image" src="${filename}" alt="프로필">
                        </c:when>
                        <c:otherwise>
                            <img id="profile-image"  class="profile-image" src="/images/${fileName}" />
                        </c:otherwise>
                    </c:choose>


                    <img class="camera-icon" src="/resources/img/members/camera.png" alt="카메라">
                </label>
            </div>

            <!-- Spring form 태그로 변경 -->
            <form:form id="update-form" modelAttribute="loginMember" action="/members/update-info" method="post" enctype="multipart/form-data">
                <input type="file" id="profile-image-input" name="member_img" style="display: none;"
                       onchange="profile_img(event)">

                <p>닉네임</p>
                <form:input path="member_nick" id="member_nick" placeholder="닉네임을 입력하세요"
                            value="${loginMember.member_nick}"/>

                <p>자기소개</p>
                <textarea id="member_explain" name="member_explain" rows="5" cols="50"
                          placeholder="자신을 알릴 수 있는 소개글을 작성해 주세요.">${loginMember.member_explain}</textarea>

                <p>주소</p>
                <form:input path="member_address" id="member_address" placeholder="주소를 입력하세요"
                            value="${loginMember.member_address}"/>

                <p>전화번호</p>
                <form:input path="member_phone" id="member_phone" placeholder="전화번호를 입력하세요"
                            value="${loginMember.member_phone}"/>

                <button class="btn-update-info" type="submit">회원 정보 수정</button>
            </form:form>
        </div>
    </div>
</div>

<!-- JavaScript 파일 링크 -->
<script src="/resources/js/members/updateMyInfo.js"></script>
</body>
</html>
