
/**
 * Server 유효성 검사 -> jwtToken 저장 및 페이지 이동
 */
function login(e) {
    e.preventDefault();

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    $.ajax({
        type: 'POST',
        url: '/login',
        data: {
            email,
            password
        },
        success: function (data, textStatus, request) {
            var jwtToken = request.getResponseHeader('Authorization');
            localStorage.setItem('jwtToken', jwtToken);
            window.location.href = '/';
        },
        error: function (error) {
            alert(error.responseJSON.data);
        }
    });
}