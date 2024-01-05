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
            appendComments(response.data);
            $('#commentContent').val('');
        },
        error: function(error) {
            console.log(error);
            alert(error.responseJSON.data);
            location.href = '/board/' + boardId;
        }
    });
}

function appendComments(commentList) {
    let commentSection = $('#commentSection');
    commentSection.empty();

    commentList.forEach(function(comment) {

        let newComment = $('<li class="list-group-item">' +
            '<div class="mb-2 d-flex justify-content-between">' +
            '<div>' +
            '<span class="me-4">' + comment.username + '</span>' +
            '<span class="custom-comment-font">' + comment.createdAtFormat + '</span>' +
            '</div>' +
            '<div>' +
            (comment.editable ? '<span class="custom-comment-font me-1">수정</span>' : '') +
            (comment.editable ? '<span class="custom-comment-font">삭제</span>' : '') +
            '</div>' +
            '</div>' +
            '<div>' +
            '<div style="font-size: 14px">' + comment.content + '</div>' +
            '</div>' +
            '</li>');

        commentSection.append(newComment);
    });
    let countComment = $('#countComment');
    countComment.text('댓글 ' + commentList.length + '개');
}

function deleteComment(commentId, boardId) {
    let confirmation = confirm("댓글을 삭제하시겠습니까?");

    if (confirmation) {
        $.ajax({
            url: '/auth/comment/' + boardId + '/' + commentId,
            type: 'DELETE',

            success: function(response) {
                console.log(response)
                appendComments(response.data);
            },
            error: function(error) {
                console.log(error);
                alert(error.responseJSON.data);
            }
        });
    } else {
    }
}