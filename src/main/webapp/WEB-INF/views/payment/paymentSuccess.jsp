<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/header.css">
</head>
<body>

<%--오류난다 풉킥--%>
<%@ include file="/resources/common/header.jsp" %>
<!-- class c-flex-center 추가 8.30 3:01-->
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <h2>결제가 성공적으로 완료되었습니다.</h2>
        <p>주문 번호: ${orderId}</p>
        <p>결제 금액: ${amount}원</p>
        <p>결제 키: ${paymentKey}</p>
    </div>

</div>
</body>
</html>