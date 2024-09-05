<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/reservation/reservation_list.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // 모든 tab-button에서 active 클래스 제거
            var buttons = document.querySelectorAll('.tab-button');
            buttons.forEach(function(button) {
                button.classList.remove('active');
            });

            // 두 번째 자식 (index는 1)에게 active 클래스 추가
            if (buttons[1]) {
                buttons[1].classList.add('active');
            }
        });
    </script>
</head>

<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">

        <div class="content">
            <%@include file="/resources/common/mypageHeader.jsp" %>

            <nav>
                <ul>
                    <li><a href="/reservation/list/${member_id}" class="btn-reservation">예약</a></li>
                    <li><a href="/reservation/completed/${member_id}" class="btn-complete">방문 완료</a></li>
                    <li><a href="/reservation/cancel/${member_id}"  class="btn-cancel">예약 취소</a></li>
                </ul>
            </nav>
        </div>

        <div id="d-reservation-box">
            <c:forEach var="reservation" items="${reservations}">
                <div class="d-res-content-box">
                    <div class="d-res-button">
                        <input type="radio" id="option1" name="options" value="option1">
                    </div>
                    <div class="d-res-content-ch-box">

                        <div class ="d-res-img-box">
                            <img src="/resources/image/${reservation.restaurant_img}" alt="Insert Image"/>
                        </div>
                        <div class="d-res-name-box">
                            <div class="d-r-name">
                                <span>${reservation.restaurant_name}</span>
                            </div>
                            <div class="d-r-district">
                                <span>${reservation.restaurant_address}</span>
                            </div>
                        </div>
                        <div class="d-res-date-box">
                            <div class="d-res-date-1">
                                예약 날짜 : <span><fmt:formatDate value="${reservation.reservation_reg_date}" pattern="yyyy.MM.dd" /></span>
                            </div>
                            <div class="d-res-date-3">
                                예약 인원 : <span>${reservation.reservation_per}</span>명
                            </div>
                            <div class="d-res-price">
                                예약 금액 : <span>${reservation.reservation_price}</span>원
                            </div>
                        </div>
                    </div>
                </div>


            </c:forEach>
        </div>

        <div class="cancel-button-size">
            <button class="cancel-button">예약 취소</button>
        </div>
<%--        리뷰작성--%>
<%--        <form action="${pageContext.request.contextPath}/review/submit" method="post">--%>
<%--            <label for="title">Title:</label>--%>
<%--            <input type="text" id="title" name="title" required>--%>

<%--            <label for="content">Content:</label>--%>
<%--            <textarea id="content" name="content" required></textarea>--%>

<%--            <label for="rating">Rating:</label>--%>
<%--            <input type="number" id="rating" name="rating" min="1" max="5" required>--%>

<%--            <button type="submit">리뷰작성</button>--%>
<%--        </form>--%>

    </div>
</div>
<script src="/resources/reservation/reservation_list.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</body>

</html>
