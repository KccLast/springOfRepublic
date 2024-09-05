$(document).ready(function() {
    // restaurant_id가 설정되어 있는지 확인
    if (restaurant_id !== undefined && restaurant_id !== '') {
        // 각 네비게이션 링크에 restaurant_id 추가
        $('#nav-home-tab').attr('href', '/restaurant/home/' + restaurant_id);
        $('#nav-menu-tab').attr('href', '/restaurant/menu/' + restaurant_id);
        $('#nav-review-tab').attr('href', '/restaurant/review/' + restaurant_id);
        $('#nav-info-tab').attr('href', '/restaurant/info/' + restaurant_id);
    } else {
        console.log('restaurant_id가 설정되지 않았습니다.');
    }

    // 현재 페이지에 맞춰 active 클래스 추가
    var currentPage = window.location.pathname;
    $('.nav-link').each(function() {
        if ($(this).attr('href') === currentPage) {
            $(this).addClass('active');
        }
    });

    // 메뉴 클릭할 때 active 클래스 변경
    $('.nav-link').click(function(e) {
        // 기본 동작 유지, active 클래스만 변경
        $('.nav-link').removeClass('active');
        $(this).addClass('active');
    });
});