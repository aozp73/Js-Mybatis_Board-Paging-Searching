function cancel() {
    var confirmation = confirm("작성 중인 글이 모두 지워집니다.");

    if (confirmation) {
        location.href = '/board/list';
    } else {
    }
}