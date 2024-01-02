function post() {
    let title = document.getElementById("title").value;
    let content = document.getElementById("content").value;
    let data = {
        "title": title,
        "content": content
    };
    console.log(data);
    $.ajax({
        url: '/auth/board',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),

        success: function(response) {
            console.log(response);
        },
        error: function(error) {
            console.log(error);
        }
    })
}
