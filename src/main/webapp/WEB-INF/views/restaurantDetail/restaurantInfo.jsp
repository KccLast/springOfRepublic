<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantInfo.css"
    />
    <link rel="shortcut icon" href="#" />
  </head>
  <body>
    <%@ include file="/resources/common/header.jsp" %>
    <!-- class c-flex-center 추가 8.30 3:01-->
    <div id="c-container" class="c-flex-col">
      <div id="c-contentBox">
        <%@ include file="/resources/common/restaurantNav.jsp" %>
        <!-- 매장 소개 -->
        <div class="m-5">
          <div>
            <h2 class="m-3 fw-bold">매장 소개</h2>
            <h3 class="m-5 text-black-50 text-center lh-base">
              스페인어를 가르치며, 스페인 문화도 즐길 수 있게 만든 요리수업,
              음식물 나누며 즐거워하는 그 모습이 좋아 스페인 레스토랑을 오픈하게
              되었습니다.
            </h3>
          </div>
          <hr />
        </div>
        <!-- 위치 -->
        <div class="mx-5">
          <h2 class="m-3 fw-bold">위치</h2>
          <div id="map" class="mx-5 my-4"></div>
          <div class="ms-5 mb-4">
            <i class="bi bi-geo-alt d-inline"></i>
            <h4 class="d-inline">서울특별시 서대문구 연희동</h4>
          </div>
          <hr />
        </div>
        <!-- 상세 정보 -->
        <div class="m-5">
          <h2 class="m-3 fw-bold">상세 정보</h2>
          <div class="ms-5 mt-5 mb-5">
            <h3 class="fw-bold">전화번호</h3>
            <div class="mt-3 mb-4">
              <i class="bi bi-telephone-fill d-inline"></i>
              <h4 class="ms-2 d-inline">02-322-8870</h4>
            </div>
          </div>
          <div class="ms-5 my-4">
            <h3 class="fw-bold">영업시간</h3>
            <div class="m-3">
              <h4 class="d-inline me-3">평일</h4>
              <h4 class="d-inline">12:00</h4>
              <h4 class="d-inline">21:00</h4>
            </div>
            <div class="m-3">
              <h4 class="d-inline me-3">주말 및 공휴일</h4>
              <h4 class="d-inline">11:00</h4>
              <h4 class="d-inline">22:00</h4>
            </div>
            <div class="m-3">
              <h4 class="d-inline me-3">휴무일</h4>
              <h4 class="d-inline">MON</h4>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=401e33ef992c7cba61db76f8876a919f"
    ></script>
    <script
      type="text/javascript"
      src="/resources/js/restaurant/restaurantMap.js"
    ></script>
  </body>
</html>
