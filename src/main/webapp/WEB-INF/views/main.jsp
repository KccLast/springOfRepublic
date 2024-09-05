<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/main/main.css">
    <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="/resources/js/main/main.js"></script>
    <script >
        $(function(){
            let page = parseInt(${pageDTO.cri.page});
            drawBorderBottomToSelectPage(page%5);
            $('#j-page-right').on('click','img',function (){
                 // let page = Math.ceil(parseInt(location.pathname.substring(1))/5)*5+1;
                let page2 = Math.ceil(parseInt(page)/5)*5+1;
                 let search = location.search;
                 location.href="/"+page2+search;
            })
            $('#j-page-left').on('click','img',function (){
                let page2 = (Math.ceil(parseInt(page)/5)-2)*5+1;
                let search = location.search;
                location.href="/"+page2+search;
            })
            $('#j-type-select').change(function (){
               let restaurant_district = $(this).val();
               if(restaurant_district === '전체'){
                   location.href="/";
               }else {
                   location.href = "/" + "?restaurant_district=" + restaurant_district;
               }
            })

            const urlParams = new URLSearchParams(window.location.search);
            const district = urlParams.get('restaurant_district');
            const name = urlParams.get('restaurant_name');
            const selectElement = document.getElementById('j-type-select');

            if (district) {
                selectElement.value = district;
            }else{
                selectElement.value = '전체';
            }
            if(name){
                $('#j-search-input > input').val(name);
            }



            $('#j-search-button').click(function (){
                let loc='';
                let restaurant_name = $('#j-search-input > input').val().trim();
                let restaurant_district =$('#j-type-select').select().val().trim();

                if(restaurant_name !== ''){
                    loc="/?restaurant_name="+restaurant_name;
                    if(restaurant_district !== '전체' || restaurant_district === ' '){
                        loc+='&restaurant_district='+restaurant_district;
                    }
                    location.href=loc;
                }
            })

            $('#j-content-body').on('click','.j-content-card',function (){
              let resNumber = $(this).find('input[type=hidden]').val();
              location.href="/restaurant/home/"+resNumber;
            })
        })
    </script>
</head>
<body>
<%@ include file="/resources/common/header.jsp" %>
<div id="c-container" class="c-flex-col">
    <div id="c-contentBox">
        <div id="j-contentTop">
        <div id="j-slogan">Be Gonna Love Every Bite!</div>
        <div id="j-search-box" class="j-flex-row-center">
            <div id="j-search-type">
                <select id="j-type-select" name="restaurant_district">
                    <option value="전체">전체</option>
                    <option value="강남구">강남구</option>
                    <option value="강동구">강동구</option>
                    <option value="강서구">강서구</option>
                    <option value="강북구">강북구</option>
                    <option value="관악구">관악구</option>
                    <option value="구로구">구로구</option>
                    <option value="금천구">금천구</option>
                    <option value="노원구">노원구</option>
                    <option value="동대문구">동대문구</option>
                    <option value="도봉구">도봉구</option>
                    <option value="동작구">동작구</option>
                    <option value="마포구">마포구</option>
                    <option value="서대문구">서대문구</option>
                    <option value="성동구">성동구</option>
                    <option value="성북구">성북구</option>
                    <option value="서초구">서초구</option>
                    <option value="송파구">송파구</option>
                    <option value="영등포구">영등포구</option>
                    <option value="용산구">용산구</option>
                    <option value="양천구">양천구</option>
                    <option value="은평구">은평구</option>
                    <option value="종로구">종로구</option>
                    <option value="중랑구">중랑구</option>
                </select>
            </div>
            <div id="j-search-input">
                <input type="text" name="search">
            </div>
            <div id="j-search-button" class="j-flex-row-center">
                <img src="/resources/img/main/search.png">
            </div>
        </div>
        </div>

        <div id="j-content-body" class="c-flex-col">

            <c:forEach items="${resList}" var="res" varStatus="st">
                <c:if test="${st.index % 4 ==0 }">
                <div class="j-content-box">
                </c:if>
                <div class="j-content-card c-flex-col">
                    <input type="hidden" value="${res.restaurant_id}">
                    <div class="j-card-head">
                        <div class="j-card-name-rank j-flex-row-center">
                            <div class="j-card-res-name">${res.restaurant_name}</div>
                            <div class="j-card-star">
                                <img src="/resources/img/main/star-fill.png" />
                            </div>
                            <div class="j-card-rank">
                                <span>${res.res_avg}</span>
                                <span>/5.0</span>
                            </div>
                        </div>
                    </div>
                    <div class="j-card-img j-flex-row-center">
                        <c:choose>
                            <c:when test="${not empty res.restaurant_img}">
                                <img src="/images/${res.restaurant_img}">
                            </c:when>
                            <c:otherwise>
                                <img src="/resources/img/bibibi.png"> <!-- 기본 이미지 경로 -->
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="j-card-footer">
                        <span class="j-card-footer-res-type">${res.restaurant_type}</span>
                        <span>-</span>
                        <span class="j-card-footer-res-district">${res.restaurant_district}</span>
                    </div>
                </div>
                <c:if test="${(st.index+1) % 4 ==0}">
                    </div>
                </c:if>
            </c:forEach>

        </div>
        <div id="content-footer" class="j-flex-row-center">
            <div id="j-paging" >
                <div id="j-page-left">
                    <c:if test="${pageDTO.prev}">
                   <img src="/resources/img/main/leftButton.png">
                    </c:if>
                </div>
                <c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
                    <div class="j-page-num">
                     ${num}
                    </div>
                </c:forEach>
                <div id="j-page-right">
                    <c:if test="${pageDTO.next}">
                    <img src="/resources/img/main/buttonright.png">
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>