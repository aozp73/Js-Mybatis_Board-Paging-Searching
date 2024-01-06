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
            appendComments(response.data, boardId);
            $('#commentContent').val('');
        },
        error: function(error) {
            console.log(error);
            alert(error.responseJSON.data);
            location.href = '/board/' + boardId;
        }
    });
}

function appendComments(commentList, boardId) {
    let commentSection = $('#commentSection');
    commentSection.empty();

    commentList.forEach(function(comment) {
        let commentItem = $('<li class="list-group-item"></li>');
        let commentDiv = $('<div class="mb-2 d-flex justify-content-between"></div>');

        // 사용자 이름, 생성 날짜
        let userInfo = $('<div></div>')
            .append($('<span class="me-4"></span>').text(comment.username))
            .append($('<span class="custom-comment-font"></span>').text(comment.createdAtFormat));

        // 수정, 삭제 버튼 (작성자만 랜더링)
        let editDeleteDiv = $('<div>', {
            id: 'commentUpdateButtonBox-'+ comment.id
        });

        if (comment.editable) {
            let editButton = $('<span class="custom-comment-font me-1">수정</span>')
                .click(function() {
                    updateFormat(comment.id, boardId);
                });
            let deleteButton = $('<span class="custom-comment-font">삭제</span>')
                .click(function() {
                    deleteComment(comment.id, boardId);
                });

            editDeleteDiv.empty().append(editButton).append(deleteButton);
        }

        // 댓글 내용
        let commentContent = $('<div>', {
            id: 'commentContentBox-' + comment.id
        }).append(
            $('<div>', {
                id: 'commentContent-' + comment.id,
                style: 'font-size: 14px',
                text: comment.content
            })
        );

        commentDiv.append(userInfo).append(editDeleteDiv);
        commentItem.append(commentDiv).append(commentContent);
        commentSection.append(commentItem);
    });

    $('#countComment').text('댓글 ' + commentList.length + '개');
}

function deleteComment(commentId, boardId) {
    let confirmation = confirm("댓글을 삭제하시겠습니까?");

    if (confirmation) {
        $.ajax({
            url: '/auth/comment/' + boardId + '/' + commentId,
            type: 'DELETE',

            success: function(response) {
                console.log(response)
                appendComments(response.data, boardId);
            },
            error: function(error) {
                console.log(error);
                alert(error.responseJSON.data);
            }
        });
    } else {
    }
}

function updateFormat(commentId, boardId) {
    let commentUpdateButtonBox = $('#commentUpdateButtonBox-' + commentId);
    let commentContentBox = $('#commentContentBox-' + commentId);
    let commentContent = $('#commentContent-' + commentId);

    let editButton = $('<span class="custom-comment-font me-2">수정하기</span>');
    let cancelButton = $('<span class="custom-comment-font">취소</span>')
        .click(function() {
            cancelEdit(commentId, boardId);
        });

    commentUpdateButtonBox.empty().append(editButton).append(cancelButton);

    let currentContent = commentContent.text();
    let inputElement = $('<input>', {
        id: 'commentContent-' + commentId,
        type: 'text',
        class: 'form-control form-control-sm',
        value: currentContent
    });

    commentContentBox.empty().append(inputElement);
}

function cancelEdit(commentId, boardId) {
    let commentUpdateButtonBox = $('#commentUpdateButtonBox-' + commentId);
    let commentContentBox = $('#commentContentBox-' + commentId);
    let commentContent = $('#commentContent-' + commentId);

    let editButton = $('<span class="custom-comment-font me-1">수정</span>')
        .click(function() {
            updateFormat(commentId, boardId);
        });
    let deleteButton = $('<span class="custom-comment-font">삭제</span>')
        .click(function() {
            deleteComment(commentId, boardId);
        });
    commentUpdateButtonBox.empty().append(editButton).append(deleteButton);

    let currentContent = commentContent.val();
    console.log(currentContent);
    let inputElement = $('<div>', {
        id: 'commentContent-' + commentId,
        type: 'text',
        style: 'font-size: 14px',
        text: currentContent
    });
    commentContentBox.empty().append(inputElement);
}
