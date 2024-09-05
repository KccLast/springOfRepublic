$(function (){

  let date;
  let month;
  let day;
  let year;
  let yearMonthDay;
  // Initialize datepicker
  $(".j-datePicker").datepicker({
    dateFormat: 'yy-mm-dd',
    showOtherMonths: true,
    showMonthAfterYear: true,
    changeYear: true,
    changeMonth: true,
    showOn: "both",
    buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
    buttonImageOnly: true,
    buttonText: "선택",
    yearSuffix: "년",
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
    dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
    minDate: "0",
    maxDate: "+1Y",
    onSelect: function(dateText, inst) {
      // 날짜를 선택했을 때 처리할 작업을 여기에 작성
      console.log("선택된 날짜: " + dateText);
      date = $(this).datepicker('getDate');
      yearMonthDay = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
      alert("선택된 날짜: " + dateText);

      // 선택된 날짜의 시간 리스트 출력
      $.ajax({
        type: 'POST',
        url: 'http://localhost:8085/restaurant/reservation',
        contentType: 'application/json',
        data: JSON.stringify({
          "restaurant_id": restaurant_id,
          "cur_date": dateText
        }),
        dataType: 'json',
        success: function (response) {
          var html = '';

          response.forEach(function(time) {
            html += `<div class="j-timeAndPeopleBox">
                        <span class="j-people">2명</span>
                        <div class="j-time">
                          <span>${time}</span>
                        </div>
                      </div>`;
          });

          $('.j-date-circle-box').html(html);
        },
        error: function (xhr, status, error) {
          console.error("AJAX 요청 실패:", status, error);
        }
      })
    }
  });
})

$(document).ready(function() {
  // 결제 버튼 클릭 시
  $('#payment-button').on('click', function() {
    // 예약 정보 수집
    const reservationInfo = {
      restaurantId: restaurant_id,
      name: $('#inputName').val(),
      phone: $('#inputPhone').val(),
      person: $('#inputPerson').val(),
      deposit: $('#inputDeposit').val(),
      // date: $('.j-datePicker').datepicker('getDate'), // 선택된 예약 일자
    };

    // 결제 요청을 위한 데이터를 설정합니다.
    const paymentData = {
      amount: reservationInfo.person * reservationInfo.deposit, // 예약 인원 * 1인당 예약금
      orderId: 'ORDER_ID_' + new Date().getTime(), // 고유 주문 ID 생성
      orderName: '식당 예약 - ' + reservationInfo.name, // 주문명
      successUrl: 'https://docs.tosspayments.com/guides/payment/test-success', // 결제 성공 시 리다이렉트 URL
      failUrl: 'http://localhost:8085/payments/toss/fail', // 결제 실패 시 리다이렉트 URL
    };

    // 결제 API 요청을 백엔드로 전송합니다.
    $.ajax({
      type: 'POST',
      url: 'http://localhost:8085/payments/toss/request',
      contentType: 'application/json',
      data: JSON.stringify(paymentData),
      success: function(response) {
        // 토스 결제 페이지로 리다이렉트
        console.log(response.paymentUrl);
        location.href = response.paymentUrl;
      },
      error: function(error) {
        console.error('결제 요청 중 오류가 발생했습니다:', error);
        alert('결제 요청에 실패했습니다. 다시 시도해주세요.');
      }
    });
  });
});

$(".j-date-circle-box").on('click','.j-time',function (){
  console.log('hi');
  // 다른 아이템에서 focus 클래스 제거
  $('.j-time').removeClass('j-time-click');
  // 클릭한 아이템에 focus 클래스 추가
  $(this).addClass('j-time-click');
});

$('.modal-footer').on('click',function (){
  let text = $('.j-time-click > span').text();
  yearMonthDay

  if(text !== '' && text !== null && yearMonthDay !== '' &&yearMonthDay !==null){
    console.log(yearMonthDay);
    console.log(text);
  }

})
