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

    <!-- jQuery and jQuery UI scripts in correct order -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://js.tosspayments.com/v2/standard"></script>
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
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
    ></script>
    <script type="text/javascript">
      var restaurant_id = ${restaurantHomeResponse.restaurant_id};
    </script>

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
                  <h3 class="fw-bold">예약 정보</h3>
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
<%--                        disabled--%>
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
                        >1 인당 예약금</label
                      >
                    </div>
                    <div class="col-auto">
                      <input
                        type="text"
                        id="inputDeposit"
                        class="form-control"
                        aria-describedby="depositHelp"
<%--                        disabled--%>
                      />
                    </div>
                  </div>
                  <!-- 예약 일시 -->
                  <div class="j-reservation-date-box">
                    <div class="j-datePicker"></div>
                    <div class="j-date-circle-box">

                    </div>
                  </div>

                  </div>
                <div class="modal-footer">
                  <button id="payment-button" type="button" class="btn btn-primary">
                    결제하기
                  </button>
                </div>
<%--                <script>--%>
<%--                  main();--%>

<%--                  async function main() {--%>
<%--                    const button = document.getElementById("payment-button");--%>
<%--                    // ------  결제위젯 초기화 --------%>
<%--                    const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";--%>
<%--                    const tossPayments = TossPayments(clientKey);--%>
<%--                    // 회원 결제--%>
<%--                    const customerKey = "R_oppQQtIN-hRzauuDBH0";--%>
<%--                    const widgets = tossPayments.widgets({--%>
<%--                      customerKey,--%>
<%--                    });--%>
<%--                    // 비회원 결제--%>
<%--                    // const widgets = tossPayments.widgets({ customerKey: TossPayments.ANONYMOUS });--%>

<%--                    // ------ 주문의 결제 금액 설정 --------%>
<%--                    await widgets.setAmount({--%>
<%--                      currency: "KRW",--%>
<%--                      value: document.getElementById("inputDeposit") * document.getElementById("inputPerson"),--%>
<%--                    });--%>

<%--                    await Promise.all([--%>
<%--                      // ------  결제 UI 렌더링 --------%>
<%--                      widgets.renderPaymentMethods({--%>
<%--                        selector: "#payment-method",--%>
<%--                        variantKey: "DEFAULT",--%>
<%--                      }),--%>
<%--                      // ------  이용약관 UI 렌더링 --------%>
<%--                      // widgets.renderAgreement({ selector: "#agreement", variantKey: "AGREEMENT" }),--%>
<%--                    ]);--%>

<%--                    // ------  주문서의 결제 금액이 변경되었을 경우 결제 금액 업데이트 --------%>
<%--                    // coupon.addEventListener("change", async function () {--%>
<%--                    //   if (coupon.checked) {--%>
<%--                    //     await widgets.setAmount({--%>
<%--                    //       currency: "KRW",--%>
<%--                    //       value: 50000 - 5000,--%>
<%--                    //     });--%>
<%--                    //--%>
<%--                    //     return;--%>
<%--                    //   }--%>
<%--                    //--%>
<%--                    //   await widgets.setAmount({--%>
<%--                    //     currency: "KRW",--%>
<%--                    //     value: 50000,--%>
<%--                    //   });--%>
<%--                    // });--%>

<%--                    // ------ '결제하기' 버튼 누르면 결제창 띄우기 --------%>
<%--                    button.addEventListener("click", async function () {--%>
<%--                      await widgets.requestPayment({--%>
<%--                        orderId: "g0OAizCZ9JZrqzQuAXqEX",--%>
<%--                        orderName: "토스 티셔츠 외 2건",--%>
<%--                        successUrl: "http://localhost:8085/payments/toss/success",--%>
<%--                        failUrl: "http://localhost:8085/payments/toss/fail",--%>
<%--                        customerEmail: "customer123@gmail.com",--%>
<%--                        customerName: "김토스",--%>
<%--                        customerMobilePhone: "01012341234",--%>
<%--                      });--%>
<%--                    });--%>
<%--                  }--%>
<%--                </script>--%>

                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
