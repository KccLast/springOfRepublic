<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 페이지</title>
    <link rel="stylesheet" href="/resources/reservation/reservation_delete.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            console.log('${fileName}');
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
                    <li><a href="/reservation/list" class="btn-reservation">예약</a></li>
                    <li><a href="/reservation/completed" class="btn-complete">방문 완료</a></li>
                    <li><a href="/reservation/cancel"  class="btn-cancel">예약 취소</a></li>
                </ul>
            </nav>
        </div>

        <div id="d-cancel-box">
            <!-- 취소하려는 예약 정보를 표시 -->
            <c:forEach var="reservation" items="${cancelledReservations}">
                <div class="d-res-content-box">

                <div class="d-res-content-ch-box">
                        <div class="d-res-img-box">
                            <img src="/images/${reservation.restaurant_img}" alt="Insert Image"/>
                        </div>
                        <div class="d-res-name-box">
                            <div class="d-r-name">${reservation.restaurant_name}</div>
                            <div class="d-r-district">
                                <span>${reservation.restaurant_type} - ${reservation.restaurant_district}</span></div>
                        </div>
                        <div class="d-res-date-box">
                            <div class="d-res-date-1">
                                예약 날짜 : <span><fmt:formatDate value="${reservation.reservation_date}" pattern="yyyy.MM.dd" /></span>
                            </div>
                            <div class="d-res-date-2">
                                예약 시간 : <span><fmt:formatDate value="${reservation.reservation_reg_date}" pattern="a h:mm" /></span>
                            </div>
                            <div class="d-res-date-3">
                                예약 인원 : <span>${reservation.reservation_per}</span>명
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


<%--            <!-- 예약 취소 확인 버튼 -->--%>
<%--            <div class="cancel-button-size">--%>
<%--                <form action="/reservation/cancel/confirm" method="post">--%>
<%--                    <input type="hidden" name="reservationId" value="${reservation.reservation_Id}">--%>
<%--                    <button type="submit" class="cancel-button" data-reservation_id="${reservation.reservation_Id}">예약 취소 확인</button>--%>
<%--                </form>--%>

<%--            </div>--%>

        </div>
    </div>
</div>

<script src="/resources/reservation/reservation_confirm_delete.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
<script>
    let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
    function openNavTab(url){
        location.href="/reservation/"+url+"/"+member_id;
    }
</script>
</html>
