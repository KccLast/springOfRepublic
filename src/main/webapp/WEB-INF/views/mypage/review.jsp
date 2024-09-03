<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/review/styles.css">
    <link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <nav>
            <ul>
                <li><a href="#">내 정보</a></li>
                <li><a href="#">내 예약</a></li>
                <li><a href="#">내 리뷰</a></li>
            </ul>
        </nav>

        <div class="review-content">
            <button class="back-button">&larr; 돌아가기</button>
            <div class="review-header">
                <h2>이태원 비건 베이커리</h2>
                <span class="rating">⭐ 4.0 / 5.0</span>
            </div>
            <p class="restaurant-info">양식 · 서울특별시 마포구 대흥로24길</p>
            <div class="reservation-info">
                <p>방문 날짜: 2024.08.28</p>
                <p>방문 시간: 오후 6:00</p>
                <p>예약 인원: 2명</p>
            </div>
            <div class="review-photo">
                <h3>사진</h3>
                <!-- 사진이 여기에  -->
            </div>
            <textarea class="review-text" placeholder="리뷰를 입력하세요...">Design System for Bootstrap - the world's most popular framework for building responsive, mobile-first sites.</textarea>
            <div class="button-group">
                <button class="edit-button">수정하기</button>
                <button class="delete-button">삭제하기</button>
            </div>
        </div>
    </div>

    <script src="/resources/review/script.js"></script>
</body>
</html>