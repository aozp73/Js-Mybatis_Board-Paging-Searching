function deleteBoard(boardId) {
    let confirmation = confirm("게시글을 삭제하시겠습니까?");

    if (confirmation) {
        $.ajax({
            url: '/auth/board/' + boardId,
            type: 'DELETE',

            success: function(response) {
                console.log(response)
                alert("게시글을 삭제하였습니다.")
                location.href = '/board';
            },
            error: function(error) {
                console.log(error);
                alert(error.responseJSON.data);
                location.href = '/board';
            }
        });
    } else {
    }
}

function postComment(boardId) {
    let content = document.getElementById("commentContent").value;
    let data = {
        content: content,
        boardId: boardId
    }

    $.ajax({
        url: '/auth/comment',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),

        success: function(response) {
            console.log(response)
        },
        error: function(error) {
            console.log(error);
            alert(error.responseJSON.data);
        }
    });
}