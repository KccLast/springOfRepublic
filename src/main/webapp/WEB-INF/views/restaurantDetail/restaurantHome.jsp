<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.kcc.rich.dto.RestaurantHomeResponse"%>
<%
  request.setCharacterEncoding("UTF-8");

  RestaurantHomeResponse res = (RestaurantHomeResponse)request.getAttribute("restaurantHomeResponse");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
    <link
      rel="stylesheet"
      href="/resources/css/restaurant/restaurantHome.css"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.11.3/font/bootstrap-icons.min.css"
      integrity="sha512-dPXYcDub/aeb08c63jRq/k6GaKccl256JQy/AnOq7CAnEZ9FzSL9wSbcZkMp4R26vBsMLFYH4kQ67/bbV8XaCQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

    <script src="/resources/js/restaurant/restaurantHome.js"></script>
  </head>
  <body>
    <%@ include file="/resources/common/header.jsp" %>
    <!-- class c-flex-center 추가 8.30 3:01-->
    <div id="c-container" class="c-flex-col">
      <div id="c-contentBox">
        <%@ include file="/resources/common/restaurantNav.jsp" %>
        <div id="c-img-box">
          <!-- 매장 사진 -->
          <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <div class="carousel-image">
                  <img src="/resources/img/main/image85.png" />
                </div>
                <!-- <img src="/resources/img/main/image85.png" /> -->
              </div>
              <div class="carousel-item">
                <img src="/resources/img/main/image85.png" />
              </div>
              <div class="carousel-item">
                <img src="/resources/img/main/image85.png" />
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExample"
              data-bs-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExample"
              data-bs-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
        <hr />
        <!-- 식당 정보 텍스트 -->
        <div class="hi">
          <h4 class="text-secondary mb-3"><%=res.getRestaurant_type()%></h4>
          <h2 class="mb-2"><%=res.getRestaurant_name()%></h2>
          <i class="bi bi-star-fill d-inline text-warning"></i>
          <h3 class="ms-3 d-inline"><%=res.getReview_avg()%></h3>
          <h4 class="ms-5 d-inline">
            리뷰 <%=res.getReview_total()%>개 <i class="bi bi-chevron-right m-2"></i>
          </h4>
          <h4 class="text-secondary mt-3">
            <%=res.getRest_oneline()%>
          </h4>
          <hr />
          <div class="m-2">
            <i class="bi bi-geo-alt d-inline"></i>
            <h4 class="ms-2 d-inline"><%=res.getRestaurant_address()%></h4>
          </div>
          <div class="m-2">
            <i class="bi bi-coin d-inline"></i>
            <h4 class="ms-2 d-inline">2-5만원</h4>
          </div>
          <div class="m-2">
            <i class="bi bi-clock d-inline"></i>
            <h4 class="ms-2 d-inline">오늘 (<%=res.getCur_day()%>)</h4>
            <h4 class="d-inline"><%=res.getStart_time()%></h4>
            <h4 class="d-inline">~</h4>
            <h4 class="d-inline"><%=res.getEnd_time()%></h4>
          </div>
        </div>

        <!-- 예약하기 -->
        <div class="reservation-btn">
          <button
            type="button"
            class="btn res-btn btn-success m-3"
            data-bs-toggle="modal"
            data-bs-target="#reservationModal"
          >
            예약하기
          </button>

          <!-- Modal -->
          <div
            class="modal fade"
            id="reservationModal"
            tabindex="-1"
            aria-labelledby="reservationModalLabel"
            aria-hidden="true"
          >
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="reservationModalLabel">
                    식당명
                  </h1>
                  <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div class="modal-body">
                  <h3 class="fw-bold">예약자 정보</h3>
                  <div class="row g-3 align-items-center">
                    <div class="col-auto">
                      <label for="inputName" class="col-form-label">이름</label>
                    </div>
                    <div class="col-auto">
                      <input
                        type="text"
                        id="inputName"
                        class="form-control"
                        aria-describedby="nameHelp"
                      />
                    </div>
                  </div>
                  <div class="row g-3 align-items-center">
                    <div class="col-auto">
                      <label for="inputPhone" class="col-form-label"
                        >전화번호</label
                      >
                    </div>
                    <div class="col-auto">
                      <input
                        type="text"
                        id="inputPhone"
                        class="form-control"
                        aria-describedby="phoneHelp"
                      />
                    </div>
                  </div>
                  <div class="row g-3 align-items-center">
                    <div class="col-auto">
                      <label for="inputPerson" class="col-form-label"
                        >예약인원</label
                      >
                    </div>
                    <div class="col-auto">
                      <input
                        type="text"
                        id="inputPerson"
                        class="form-control"
                        aria-describedby="personHelp"
                      />
                    </div>
                  </div>
                  <div class="row g-3 align-items-center">
                    <div class="col-auto">
                      <label for="inputDeposit" class="col-form-label"
                        >1인당 예약금</label
                      >
                    </div>
                    <div class="col-auto">
                      <input
                        type="text"
                        id="inputDeposit"
                        class="form-control"
                        aria-describedby="depositHelp"
                      />
                    </div>
                  </div>
                  <!-- 예약 일시 -->
                </div>
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                  <button type="button" class="btn btn-primary">
                    Save changes
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>