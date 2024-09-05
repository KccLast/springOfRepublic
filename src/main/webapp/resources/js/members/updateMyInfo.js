function profile_img(event) {
    let reader = new FileReader();
    reader.onload = function(e) {
        // jQuery를 사용하여 프로필 이미지 미리보기 업데이트
        $('#profile-image').attr('src', e.target.result); // 선택된 이미지로 미리보기 업데이트
    };
    // 선택한 파일을 읽음
    reader.readAsDataURL(event.target.files[0]);
}