<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="tab-menu">
	<button class="tab-button" onclick="openTab('information')" id="j-mypage-myinfo">내 정보</button>
	<button class="tab-button " onclick="openTab('/reservation/')">내 예약</button>
	<button class="tab-button active" onclick="openTab('/review/')">내 리뷰</button>
</div>

<script>
	let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
		function openTab(url){
			location.href=url+"list/"+member_id;
		}
</script>