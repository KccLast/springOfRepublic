
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <link rel="stylesheet" href="/src/main/webapp/WEB-INF/views/join/join.css">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <%@ include file="common/header.jsp" %>
  <div class="signup-container shadow-lg p-4">
    <h2>회원가입</h2>
    <div class="profile-wrapper">
      <img class="profile-image" src="/src/main/webapp/resources/img/join/profile.png" alt="회원가입">
      <img class="camera-icon" src="/src/main/webapp/resources/img/join/camera.png" alt="카메라">
    </div>
    <form action="" method="post">
      <div class="form-group">
        <input type="text" class="form-control" name="member_email" placeholder="이메일 주소">
        <button type="button" class="btn btn-info mt-2">중복 확인</button>
      </div>
      <input type="password" class="form-control" name="member_pwd" placeholder="비밀번호(문자, 숫자, 특수문자 포함 8~20자)">
      <input type="password" class="form-control" name="member_pwd_confirm" placeholder="비밀번호 확인">
      <input type="text" class="form-control" name="member_name" placeholder="이름">
      <input type="text" class="form-control" name="member_nick" placeholder="닉네임">
      <input type="text" class="form-control" name="member_address" placeholder="주소">
      <input type="tel" class="form-control" name="member_phone" placeholder="전화번호(ex.010-1111-2222)">
      <input type="submit" class="btn btn-success mt-3" value="회원가입">
    </form>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
