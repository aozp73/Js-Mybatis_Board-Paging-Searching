<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 70px; margin-bottom: 100px">
  <div class="container custom-login-custom-container mb-5 mt-5">

    <form>
  
      <div class="mb-3">
        <input
          id="email"
          name="email"
          type="email"
          class="form-control"
          placeholder="이메일"
        />
      </div>
      <div class="mb-4">
        <input
          id="password"
          name="password"
          type="password"
          class="form-control"
          placeholder="비밀번호"
        />
      </div>

      <div>
        <div>
          <div class="mb-2">
            <button type="button" onclick="login()" class="btn btn-primary custom-login-btn">
              로그인
            </button>
          </div>
          <div class="d-flex justify-content-end">
            <div class="me-2">
              <a href="/joinForm" class="custom-login-link">회원가입</a>
            </div>
            <div>
              <a href="#" class="custom-login-link">비밀번호 찾기</a>
            </div>
          </div>
        </div>
      </div>

    </form>

  </div>
</div>

<Script>
  function login() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    // AJAX 또는 폼 전송으로 로그인 요청 후 토큰을 받아옴
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
</Script>

<%@ include file="../layout/footer.jsp" %>