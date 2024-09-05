<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.11.3/font/bootstrap-icons.min.css"
          integrity="sha512-dPXYcDub/aeb08c63jRq/k6GaKccl256JQy/AnOq7CAnEZ9FzSL9wSbcZkMp4R26vBsMLFYH4kQ67/bbV8XaCQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
<%--    <script src="https://code.jquery.com/jquery-3.7.1.js"--%>
<%--            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="--%>
<%--            crossorigin="anonymous"></script>--%>
</head>
<body>
<header>
    <div class="text-center shadow-sm p-2 bg-body-tertiary">
        <div class="d-flex justify-content-between align-items-center">
            <!-- 로고 클릭 시 메인 화면으로 이동 -->
            <a href="/" class="ms-3">
                <img class="mt-1" src="/resources/img/logo.png" style="width: 225px; height: 45px" alt="Logo">
            </a>

            <!-- 메뉴 -->
            <div class="menu">
                <!-- 비로그인 상태일 때 로그인과 회원가입 메뉴 표시 -->
                <sec:authorize access="isAnonymous()">
                    <a href="/members/login">Login</a>
                    <a href="/members/join">Join</a>
                </sec:authorize>

                <!-- 로그인 상태일 때 로그아웃 버튼과 마이페이지 표시 -->
                <sec:authorize access="isAuthenticated()">
                    <form method="POST" action="/logout" style="display:inline;">
                        <button type="submit">Logout</button>
                    </form>
                </sec:authorize>

                <a href="/members/mypage">My Page</a>
                <i class="ps-3 pe-3 pt-1 bi bi-bell h5"></i>
            </div>
        </div>
    </div>
</header>
</body>
</html>
