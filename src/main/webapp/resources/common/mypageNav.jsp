<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
	<ul>
		<li onclick="openNavTab('list')" class="j-btn-button"> 예약</li>
		<li onclick="openNavTab('completed')">방문 완료</li>
		<li onclick="openNavTab('cancel')">예약 취소</li>
	</ul>
</nav>

<script>

		let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
		function openNavTab(url){
			location.href="/reservation/"+url+"/"+member_id;
		}

	// let member_id = location.pathname.substring(location.pathname.lastIndexOf('/')+1);
	// 	function openNavTab(url){
	// 		location.href="/reservation/"+url+"/"+member_id;
	// 	}
</script>

