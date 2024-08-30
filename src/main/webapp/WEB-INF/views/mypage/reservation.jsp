<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/reservation/styles.css">
    <link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox" >


        <div class="content">
            <nav>
                <ul>
                    <li><a href="#">예약</a></li>
                    <li><a href="#">방문 완료</a></li>
                    <li><a href="#">예약 취소</a></li>
                </ul>
            </nav>

            <div class="tab-menu">
                <button class="tab-button" onclick="openTab('정보')">내 정보</button>
                <button class="tab-button active" onclick="openTab('예약')">내 예약</button>
                <button class="tab-button" onclick="openTab('리뷰')">내 리뷰</button>
            </div>

            <div id="예약" class="tab-content active">
                <div class="reservation-list">
                    <label class="reservation-item">
                        <input type="radio" name="reservation">
                        <div class="reservation-photo">
                            <img src="/path/to/photo.jpg" alt="사진">
                        </div>
                        <div class="reservation-details">
                            <h3>이태원 비건 베이커리</h3>
                            <p>양식 · 마포구</p>
                            <p>예약 날짜: 2024.08.28</p>
                            <p>예약 시간: 오후 6:00</p>
                            <p>예약 인원: 2명</p>
                        </div>
                    </label>
                    <label class="reservation-item">
                        <input type="radio" name="reservation">
                        <div class="reservation-details">
                            <h3>이태원 비건 베이커리</h3>
                            <p>양식 · 마포구</p>
                            <p>예약 날짜: 2024.08.28</p>
                            <p>예약 시간: 오후 6:00</p>
                            <p>예약 인원: 2명</p>
                        </div>
                    </label>
                </div>
                <button class="cancel-button">예약 취소</button>
            </div>

            <div id="정보" class="tab-content">
                <h2>내 정보</h2>
                <p>여기에 사용자의 정보를 표시합니다.</p>
            </div>

            <div id="리뷰" class="tab-content">
                <h2>내 리뷰</h2>
                <p>여기에 사용자의 리뷰를 표시합니다.</p>
            </div>
        </div>
    </div>

    <script src="/resources/js/script.js"></script>
</body>
</html>