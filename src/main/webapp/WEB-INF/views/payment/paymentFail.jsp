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
        <h2>결제가 실패했습니다.</h2>
        <p>오류 코드: ${code}</p>
        <p>메시지: ${message}</p>
    </div>

</div>
</body>
</html>