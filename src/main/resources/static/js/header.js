
/**
 * 토큰 확인 후, UI 렌더링
 * (토큰 만들어서 장난칠 경우, Filter에서 검증 => 비정상적인 접근 알림)
 */
document.addEventListener('DOMContentLoaded', function() {
    checkAndRemoveExpiredToken();

    const jwtToken = localStorage.getItem('jwtToken');
    if (jwtToken) {
        $.ajax({
            url: '/userInfo',
            type: 'GET',
            headers: {
                'Authorization': jwtToken
            },
            success: function(data) {
                document.getElementById("statusLogin").style.display = "block";
                $("#statusUsername").text(data.username);
            },
            error: function(error) {
                alert("비정상적인 접근")
                document.getElementById("statusLogout").style.display = "block";
                document.getElementById("statusLogin").style.display = "none";
                console.log(error);
            }
        });

    } else {
        document.getElementById("statusLogout").style.display = "block";
    }
});

/**
 * 로그아웃 - 토큰 만료시간 체크 및 제거
 */
function checkAndRemoveExpiredToken() {
    const token = localStorage.getItem('jwtToken');
    if (token && isTokenExpired(token)) {
        localStorage.removeItem('jwtToken');
        alert("자동 로그아웃")
    }
}

function isTokenExpired(token) {
    try {
        const [, payload,] = token.split('.');

        // Base64에서 JSON 문자열로 디코딩
        const decodedPayload = atob(payload);

        // JSON 문자열을 JavaScript 객체로 변환
        const { exp } = JSON.parse(decodedPayload);

        // 현재 시간을 가져와 JWT의 exp와 비교
        const currentUnixTime = Math.floor(Date.now() / 1000);
        return currentUnixTime > exp;
    } catch (e) {
        alert("비정상적인 접근")
        console.error("Error decoding JWT:", e);
        return false;
    }
}

/**
 * 로그아웃 - 버튼 클릭
 */
function logout() {
    localStorage.removeItem('jwtToken');
    alert("로그아웃")
    location.reload();
}