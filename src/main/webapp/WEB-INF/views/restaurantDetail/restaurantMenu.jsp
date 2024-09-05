<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.kcc.rich.dto.RestaurantMenuResponse"%>
<%
  request.setCharacterEncoding("UTF-8");

  RestaurantMenuResponse res = (RestaurantMenuResponse)request.getAttribute("RestaurantMenuResponse");
%>
<c:set var = 'list' value = '<%=res.getMenuList()%>'/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css" />
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantDetail.css"
    />
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantMenu.css"
    />
    <script type="text/javascript">
    var restaurant_id = ${restaurantMenuResponse.restaurant_id};
  </script>
  </head>
  <body>
    <%@ include file="/resources/common/header.jsp" %>
    <!-- class c-flex-center 추가 8.30 3:01-->
    <div id="c-container" class="c-flex-col">
      <div id="c-contentBox">
        <%@ include file="/resources/common/restaurantNav.jsp" %>
        <!-- 메뉴판 -->
        <div class="menu-board">
          <h3 class="m-4 fw-bold">메뉴판</h3>
          <div class="wrap-vertical p-2 m-auto">
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image1.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
            <img class="m-2" src="/resources/img/main/image85.png" />
          </div>
        </div>
        <hr />
        <!-- 메뉴 상세 -->
        <div class="menu-list-wrap">
          <h3 class="m-4 fw-bold">메뉴 목록</h3>
          <ul id="menu-list" class="mt-5 mb-3">
            <c:forEach var="menu" items="${list}">
              <li class="row justify-content-center m-3">
                <div class="col-8">
                  <h3 class="fw-bold">${menu.menu_name}</h3>
                  <h5 class="text-black-50">
                    ${menu.menu_detail}
                  </h5>
                  <h3 class="mt-3 text-orange"><fmt:formatNumber value="${menu.menu_price}" pattern="#,###"/></h3>
                </div>
                <img class="m-2 col-2" src="/resources/img/main/image85.png" />
                <hr class="m-3" />
              </li>
            </c:forEach>
          </ul>
        </div>
        <hr />
      </div>
    </div>
  </body>
</html>
