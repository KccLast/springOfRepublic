$(function () {
  $("#nav-home-tab").on("click", function (e) {
    e.preventDefault();
    // console.log();

    $.ajax({
      type: "GET",
      url: `http://localhost:8085/restaurant/home/${restaurant_id}`,
      success: function (response) {
        //
      },
    });
  });

  $("#nav-menu-tab").on("click", function (e) {
    e.preventDefault();
    // console.log();

    $.ajax({
      type: "GET",
      url: `http://localhost:8085/restaurant/menu/${restaurant_id}`,
      success: function (response) {
        //
      },
    });
  });

  $("#nav-review-tab").on("click", function (e) {
    e.preventDefault();
    // console.log();

    $.ajax({
      type: "GET",
      url: `http://localhost:8085/restaurant/review/${restaurant_id}`,
      success: function (response) {
        //
      },
    });
  });

  $("#nav-info-tab").on("click", function (e) {
    e.preventDefault();
    // console.log();

    $.ajax({
      type: "GET",
      url: `http://localhost:8085/restaurant/info/${restaurant_id}`,
      success: function (response) {
        //
      },
    });
  });
});