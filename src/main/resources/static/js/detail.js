function deleteBoard(boardId) {
    var confirmation = confirm("게시글을 삭제하시겠습니까?");

    if (confirmation) {
        $.ajax({
            url: '/auth/board/' + boardId,
            type: 'DELETE',

            success: function(response) {
                console.log(response)
                alert("게시글을 삭제하였습니다.")
                location.href = '/board/list';
            },
            error: function(error) {
                console.log(error);
                alert(error.responseJSON.data);
                location.href = '/board/list';
            }
        });
    } else {
    }
}
