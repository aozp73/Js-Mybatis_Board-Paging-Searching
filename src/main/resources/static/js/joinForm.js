
document.addEventListener("DOMContentLoaded", function() {
    initializePage();
});

// POST 메서드 유효성 실패 후, 안내 문구 재출력
function initializePage() {
    checkEmail();
    validatePassword();
}

// 비밀번호, 비밀번호 확인 체크
function validatePassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("passwordConfirmation").value;
    let passwordCheck = document.getElementById("passwordCheck");

    if (password === "" || confirmPassword === "") {
        passwordCheck.innerHTML = "";
        return;
    }

    if (password === confirmPassword) {
        passwordCheck.style.color = "green";
        passwordCheck.innerHTML = "비밀번호 일치";
    } else {
        passwordCheck.style.color = "red";
        passwordCheck.innerHTML = "비밀번호가 일치하지 않습니다.";
    }
}

// 등록버튼 클릭 - Server 전송 전, 유효성 체크 
function validateForm() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("passwordConfirmation").value;
    let emailCheckMessage = document.getElementById("emailCheckMessage").innerHTML;

    if (password !== confirmPassword || emailCheckMessage !== "사용 가능한 이메일입니다.") {
        alert("입력 정보를 확인해주세요.");
        return false;
    } else {
        return true;
    }
}

// 이메일 중복여부 체크
function checkEmail() {
    let email = document.getElementById("email").value;
    let emailCheckMessage = document.getElementById("emailCheckMessage");

    if(email === ""){
        emailCheckMessage.innerHTML = "";
        return;
    }

    $.ajax({
        url: '/emailCheck?email=' + email,

    success: function(response) {
        if (response) {
            emailCheckMessage.style.color = "green";
            emailCheckMessage.innerHTML = "사용 가능한 이메일입니다.";
        } else {
            emailCheckMessage.style.color = "red";
            emailCheckMessage.innerHTML = "이미 사용 중인 이메일입니다.";
        }
    },
    error: function(error) {
        alert(error.responseJSON.data);
    }
    })
}

