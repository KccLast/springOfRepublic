<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main/main.css" />
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantDetail.css"
    />
      <script src="/resources/js/restaurant/restaurantNav.js"></script>
  </head>
  <body>
    <!-- nav bar, 뒤로가기 버튼, 공유하기 버튼 -->
    <ul class="nav nav-underline row m-3 fs-4 fw-bold text-center col">
      <i class="bi bi-chevron-left col-1 text-start"></i>
      <li class="nav-item mx-5 col-2">
        <a
          class="nav-link"
          id="nav-home-tab"
<%--          aria-current="page"--%>
          href="http://localhost:8085/restaurant/home"
          >홈</a
        >
      </li>
      <li class="nav-item col-2">
        <a
          class="nav-link"
          id="nav-menu-tab"
          href="http://localhost:8085/restaurant/menu"
          >메뉴</a
        >
      </li>
      <li class="nav-item col-2">
        <a
          class="nav-link"
          id="nav-review-tab"
          href="http://localhost:8085/restaurant/review"
          >리뷰</a
        >
      </li>
      <li class="nav-item col-2">
        <a
          class="nav-link"
          id="nav-info-tab"
          href="http://localhost:8085/restaurant/info"
          >매장정보</a
        >
      </li>
      <i class="bi bi-share col-1 text-end"></i>
    </ul>
  </body>
</html>
