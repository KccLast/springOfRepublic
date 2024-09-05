<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.tab-menu {
		display: flex;
		justify-content: center;
		border-bottom: 2px solid #ccc;
		padding: 10px 0;
	}

	.tab-button {
		font-size: 20px;
		font-weight: bold;
		color: #b3b3a9;
		background: none;
		border: none;
		cursor: pointer;
		padding: 0 38px;
		transition: all 0.3s ease;
	}

	.tab-button.active {
		color: #006400;
		border-bottom: 2px solid #006400;
	}

	.tab-button:focus {
		outline: none;
	}

</style>
<div class="tab-menu">
	<button class="tab-button" onclick="openTab('member')" id="j-mypage-myinfo">내 정보</button>
	<button class="tab-button" onclick="openTab('/reservation/list')">내 예약</button>
	<button class="tab-button" onclick="openTab('/review/list')">내 리뷰</button>
</div>

<script>
	let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
		function openTab(url){
			if(url.lastIndexOf('member')!==-1){
				location.href='/members/confirm-myInfo';
			}else {
				location.href = url;
			}
		}
</script>