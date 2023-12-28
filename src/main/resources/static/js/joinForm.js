
function validatePassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("passwordConfirmation").value;
    let passwordCheck = document.getElementById("passwordCheck");

    if (password === "" || confirmPassword === "") {
        passwordCheck.innerHTML = "";
        return;
    }

    if (password !== confirmPassword) {
        passwordCheck.innerHTML = "비밀번호가 일치하지 않습니다.";
    } else {
        passwordCheck.innerHTML = "";
    }
}

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

