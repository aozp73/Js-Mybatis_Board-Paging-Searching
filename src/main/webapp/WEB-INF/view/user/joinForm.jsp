<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 70px; margin-bottom: 70px">
  <div class="container custom-join-container mb-5 mt-5">
    <div class="text-center" style="margin-bottom: 35px">
        <h2>회원가입</h2>
    </div>
    <form action="/join" method="post" onsubmit="return validateForm()">
      <div class="mb-2 d-flex justify-content-between">
        <input
                class="form-control"
                placeholder="이메일"
                id="email"
                name="email"
                onkeyup="checkEmail()"
                required
        />
      </div>
      <div id="emailCheckMessage" class="mb-3 ms-2"></div>
      <div class="mb-3">
        <input type="password"
               class="form-control"
               placeholder="비밀번호"
               id="password"
               name="password"
               onkeyup="validatePassword()"
               required
        />
      </div>
      <div class="mb-2">
        <input type="password"
               class="form-control"
               placeholder="비밀번호 확인"
               id="passwordConfirmation"
               onkeyup="validatePassword()"
               required
        />
      </div>
      <div class="mb-3 ms-2" class="form-control" id="passwordCheck" style="color: orangered"></div>
      <div class="mb-5">
        <input
          class="form-control"
          placeholder="아이디"
          id="username"
          name="username"
          required
        />
      </div>

      <div>
        <div class="mb-2">
          <button type="submit" class="btn btn-primary custom-join-btn">
            등록하기
          </button>
        </div>
      </div>

    </form>

  </div>
</div>

<script src="/js/joinForm.js"></script>
<%@ include file="../layout/footer.jsp" %>