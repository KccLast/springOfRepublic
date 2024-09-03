<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.11.3/font/bootstrap-icons.min.css"
	integrity="sha512-dPXYcDub/aeb08c63jRq/k6GaKccl256JQy/AnOq7CAnEZ9FzSL9wSbcZkMp4R26vBsMLFYH4kQ67/bbV8XaCQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<%--<script src="https://code.jquery.com/jquery-3.7.1.js"--%>
<%--	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="--%>
<%--	crossorigin="anonymous"></script>--%>

</head>
<header>
	<div class="text-center shadow-sm p-2 bg-body-tertiary">
		<div class="row">
			<div class="row col-auto">
				<img class="mt-1 ms-3" src="/resources/img/logo.png" style="width: 225px; height: 45px">
			</div>
			<div class="row ms-auto col-auto pt-3 pb-3 pe-5">
				<h5 class="ps-3 pe-3 col-auto fw-bold">My Page</h5>
				<h5 class="ps-3 pe-3 col-auto fw-bold">Sign In</h5>
				<i class="ps-3 pe-3 pt-1 col-auto bi bi-bell h5"></i>
			</div>
		</div>

	</div>
</header>
</html>