<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
              <h3>351개 리뷰 별점 평균</h3>
            </div>

            <div class="d-flex flex-column align-items-center m-4">
              <i class="bi bi-star-fill text-warning m-3"></i>
              <h3 class="mb-5">5.0</h3>
            </div>
          </div>

          <div class="col-5 m-auto">
            <div class="row align-items-center">
              <h5 class="col-auto">5점</h5>
              <div
                class="progress col p-0"
                role="progressbar"
                aria-label="Basic example"
                aria-valuenow="85"
                aria-valuemin="0"
                aria-valuemax="100"
              >
                <div
                  class="progress-bar"
                  style="width: 85%; background-color: #000"
                ></div>
              </div>
              <h5 class="col-auto text-muted">320</h5>
            </div>
            <div class="row align-items-center mt-3">
              <h5 class="col-auto">4점</h5>
              <div
                class="progress col p-0"
                role="progressbar"
                aria-label="Basic example"
                aria-valuenow="8"
                aria-valuemin="0"
                aria-valuemax="100"
              >
                <div
                  class="progress-bar"
                  style="width: 8%; background-color: #000"
                ></div>
              </div>
              <h5 class="col-auto text-muted">31</h5>
            </div>

            <div class="row align-items-center mt-3">
              <h5 class="col-auto">3점</h5>
              <div
                class="progress col p-0"
                role="progressbar"
                aria-label="Basic example"
                aria-valuenow="0"
                aria-valuemin="0"
                aria-valuemax="100"
              >
                <div
                  class="progress-bar"
                  style="width: 0%; background-color: #ccc"
                ></div>
              </div>
              <h5 class="col-auto text-muted">0</h5>
            </div>

            <div class="row align-items-center mt-3">
              <h5 class="col-auto">2점</h5>
              <div
                class="progress col p-0"
                role="progressbar"
                aria-label="Basic example"
                aria-valuenow="0"
                aria-valuemin="0"
                aria-valuemax="100"
              >
                <div
                  class="progress-bar"
                  style="width: 0%; background-color: #ccc"
                ></div>
              </div>
              <h5 class="col-auto text-muted">0</h5>
            </div>

            <div class="row align-items-center mt-3">
              <h5 class="col-auto">1점</h5>
              <div
                class="progress col p-0"
                role="progressbar"
                aria-label="Basic example"
                aria-valuenow="0"
                aria-valuemin="0"
                aria-valuemax="100"
              >
                <div
                  class="progress-bar"
                  style="width: 0%; background-color: #ccc"
                ></div>
              </div>
              <h5 class="col-auto text-muted">0</h5>
            </div>
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
                  <h4 class="col mt-3">송예림</h4>
                </div>
                <div class="row m-3">
                  <div class="col">
                    <i class="bi bi-star-fill small d-inline text-warning"></i>
                    <h4 class="ms-3 d-inline">5.0</h4>
                  </div>
                  <h4 class="text-black-50 col text-end">2024.08.06</h4>
                </div>
                <div class="row">
                  <img
                    class="m-2 col-3"
                    src="/resources/img/main/image85.png"
                  />
                  <h4 class="reveiw-detail col m-3 p-4">
                    4시 30분 조금 이른 저녁시간대에 예약 후 방문했더니 좀 더
                    프라이빗하게 이용할 수 있고 사장님이 너무 친절하게 메뉴
                    하나하나 설명해 주셔서 좋았어요!
                  </h4>
                </div>
                <hr class="m-3" />
              </li>
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
                  <h4 class="col mt-3">송예림</h4>
                </div>
                <div class="row m-3">
                  <div class="col">
                    <i class="bi bi-star-fill small d-inline text-warning"></i>
                    <h4 class="ms-3 d-inline">5.0</h4>
                  </div>
                  <h4 class="text-black-50 col text-end">2024.08.06</h4>
                </div>
                <div class="row">
                  <img
                    class="m-2 col-3"
                    src="/resources/img/main/image85.png"
                  />
                  <h4 class="reveiw-detail col m-3 p-4">
                    4시 30분 조금 이른 저녁시간대에 예약 후 방문했더니 좀 더
                    프라이빗하게 이용할 수 있고 사장님이 너무 친절하게 메뉴
                    하나하나 설명해 주셔서 좋았어요!
                  </h4>
                </div>
                <hr class="m-3" />
              </li>
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
                  <h4 class="col mt-3">송예림</h4>
                </div>
                <div class="row m-3">
                  <div class="col">
                    <i class="bi bi-star-fill small d-inline text-warning"></i>
                    <h4 class="ms-3 d-inline">5.0</h4>
                  </div>
                  <h4 class="text-black-50 col text-end">2024.08.06</h4>
                </div>
                <div class="row">
                  <img
                    class="m-2 col-3"
                    src="/resources/img/main/image85.png"
                  />
                  <h4 class="reveiw-detail col m-3 p-4">
                    4시 30분 조금 이른 저녁시간대에 예약 후 방문했더니 좀 더
                    프라이빗하게 이용할 수 있고 사장님이 너무 친절하게 메뉴
                    하나하나 설명해 주셔서 좋았어요!
                  </h4>
                </div>
                <hr class="m-3" />
              </li>
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
                  <h4 class="col mt-3">송예림</h4>
                </div>
                <div class="row m-3">
                  <div class="col">
                    <i class="bi bi-star-fill small d-inline text-warning"></i>
                    <h4 class="ms-3 d-inline">5.0</h4>
                  </div>
                  <h4 class="text-black-50 col text-end">2024.08.06</h4>
                </div>
                <div class="row">
                  <img
                    class="m-2 col-3"
                    src="/resources/img/main/image85.png"
                  />
                  <h4 class="reveiw-detail col m-3 p-4">
                    4시 30분 조금 이른 저녁시간대에 예약 후 방문했더니 좀 더
                    프라이빗하게 이용할 수 있고 사장님이 너무 친절하게 메뉴
                    하나하나 설명해 주셔서 좋았어요!
                  </h4>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
