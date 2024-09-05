<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.kcc.rich.dto.RestaurantInfoResponse" %>
<%
  request.setCharacterEncoding("UTF-8");

  RestaurantInfoResponse res = (RestaurantInfoResponse)request.getAttribute("RestaurantInfoResponse");
%>
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
              <%=res.getRest_detailexpl()%>
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
            <h4 class="d-inline"><%=res.getRestaurant_address()%></h4>
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
              <h4 class="ms-2 d-inline"><%=res.getRestaurant_phone()%></h4>
            </div>
          </div>
          <div class="ms-5 my-4">
            <h3 class="fw-bold">영업시간</h3>
            <div class="m-3">
              <h4 class="d-inline me-3">평일</h4>
              <h4 class="d-inline"><%=res.getWeek_start()%></h4>
              <h4 class="d-inline"> ~ </h4>
              <h4 class="d-inline"><%=res.getWeek_end()%></h4>
            </div>
            <div class="m-3">
              <h4 class="d-inline me-3">주말 및 공휴일</h4>
              <h4 class="d-inline"><%=res.getWeekend_start()%></h4>
              <h4 class="d-inline"> ~ </h4>
              <h4 class="d-inline"><%=res.getWeekend_end()%></h4>
            </div>
            <div class="m-3">
              <h4 class="d-inline me-3">휴무일</h4>
              <h4 class="d-inline"><%=res.getDayoff()%></h4>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=401e33ef992c7cba61db76f8876a919f"
    ></script>
  <script>
    let x = parseFloat(${RestaurantInfoResponse.restaurant_x});
    let y = parseFloat(${RestaurantInfoResponse.getRestaurant_y});
    console.log(x);
    console.log(y);
    var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스

    var options = {
      //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(37.5535518, 126.9171055), //지도의 중심좌표.
      level: 3, //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    // 마커가 표시될 위치입니다
    var markerPosition = new kakao.maps.LatLng(37.5535518, 126.9171055);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      position: markerPosition,
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
    // marker.setMap(null);
  </script>
  </body>
</html>
