<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.kcc.rich.dto.RestaurantReviewResponse" %>
<%
  request.setCharacterEncoding("UTF-8");

  RestaurantReviewResponse res = (RestaurantReviewResponse)request.getAttribute("RestaurantReviewResponse");
%>
<c:set var = 'reviewCountList' value = '<%=res.getReview_count_list()%>'/>
<c:set var = 'reviewList' value='<%=res.getReview_list()%>'/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css" />
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantReview.css"
    />
  </head>
  <body>
    <%@ include file="/resources/common/header.jsp" %>
    <!-- class c-flex-center 추가 8.30 3:01-->
    <div id="c-container" class="c-flex-col">
      <div id="c-contentBox">
        <%@ include file="/resources/common/restaurantNav.jsp" %>
        <!-- 리뷰 통계 -->
        <div class="row justify-content-center w-100">
          <div class="col-5 m-auto">
            <div class="round-text">
              <h3><%=res.getReview_total()%>개 리뷰 별점 평균</h3>
            </div>

            <div class="d-flex flex-column align-items-center m-4">
              <i class="bi bi-star-fill text-warning m-3"></i>
              <h3 class="mb-5"><%=res.getReview_avg()%></h3>
            </div>
          </div>

          <div class="col-5 m-auto">
            <c:forEach var="countList" items="${reviewCountList}">
              <div class="row align-items-center mt-3">
                <h5 class="col-auto">${countList.review_score}점</h5>
                <div
                        class="progress col p-0"
                        role="progressbar"
                        aria-label="Basic example"
                        aria-valuenow="<${countList.review_percent}"
                        aria-valuemin="0"
                        aria-valuemax="100"
                >
                  <div
                          class="progress-bar"
                          style="width: ${countList.review_percent}%; background-color: #000"
                  ></div>
                </div>
                <h5 class="col-auto text-muted">${countList.review_cnt}</h5>
              </div>
            </c:forEach>
          </div>
          <hr />
        </div>
        <!-- 리뷰 리스트 -->
        <div id="j-menu-list-box">
          <div class="j-menu-button1">
            <button type="button" class="btn btn-outline-secondary" disabled>
              전체
            </button>
          </div>
          <div class="j-menu-button1">
            <button type="button" class="btn btn-outline-secondary" disabled>
              점심
            </button>
          </div>
          <div class="j-menu-button1">
            <button type="button" class="btn btn-outline-secondary" disabled>
              저녁
            </button>
          </div>
          <div class="j-menu-button2">
            <div class="dropdown">
              <a
                class="btn btn-secondary dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown link
              </a>

              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li>
                  <a class="dropdown-item" href="#">Something else here</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div>
          <div class="menu-list-wrap">
            <ul id="menu-list" class="mt-5 mb-3">
              <c:forEach var="review" items="${reviewList}">
              <li class="row justify-content-center m-3">
                <div class="row">
                  <div
                    class="profile-box col-auto m-2"
                    style="background: #bdbdbd"
                  >
                    <img
                      class="profile"
                      src="/resources/img/main/image85.png"
                    />
                  </div>
                  <h4 class="col mt-3">${review.member_nick}</h4>
                </div>
                <div class="row m-3">
                  <div class="col">
                    <i class="bi bi-star-fill small d-inline text-warning"></i>
                    <h4 class="ms-3 d-inline">${review.review_score}</h4>
                  </div>
                  <h4 class="text-black-50 col text-end">
                    <fmt:formatDate value="${review.review_create}" pattern="yyyy.MM.dd" /></h4>
                </div>
                <div class="row">
                  <img
                    class="m-2 col-3"
                    src="/resources/img/main/image85.png"
                  />
                  <h4 class="reveiw-detail col m-3 p-4">
                    ${review.review_content}
                  </h4>
                </div>
                <hr class="m-3" />
              </li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
