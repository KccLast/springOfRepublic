document.querySelector('.edit-button').addEventListener('click', function() {
    alert('리뷰 수정 페이지로 이동합니다.');
    // 수정 페이지로 이동하거나 편집 모드를 활성화하는 코드를 추가
});

document.querySelector('.delete-button').addEventListener('click', function() {
    if (confirm('정말로 리뷰를 삭제하시겠습니까?')) {
        alert('리뷰가 삭제되었습니다.');
        // 리뷰 삭제 동작을 구현하는 코드를 추가
    }
});

document.querySelector('.back-button').addEventListener('click', function() {
    window.history.back();
});
