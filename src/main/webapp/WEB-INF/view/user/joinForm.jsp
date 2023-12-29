<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 70px; margin-bottom: 70px">
  <div class="container custom-join-container mb-5 mt-5">
    <div class="text-center" style="margin-bottom: 35px">
        <h2>회원가입</h2>
    </div>
  <form:form modelAttribute="joinInDTO" action="/join" method="post" onsubmit="return validateForm()">
      <div class="d-flex justify-content-between">
        <form:input
                id="email"
                path="email"
                type="email"
                class="form-control"
                placeholder="이메일"
                onkeyup="checkEmail()"
                required="true"
        />
        <form:errors path="email" cssClass="error" />
      </div>
      <div id="emailCheckMessage" class="mb-3 ms-2"></div>
      <div class="mb-3">
        <form:input id="password"
                    path="password"
                    type="password"
                    class="form-control"
                    placeholder="비밀번호"
                    onkeyup="validatePassword()"
                    required="true"
        />
        <form:errors id="passwordError" path="password" cssClass="error" />
      </div>
      <div>
        <form:input id="passwordConfirmation"
                    path="passwordConfirmation"
                    type="password"
                    class="form-control"
                    placeholder="비밀번호 확인"
                    onkeyup="validatePassword()"
                    required="true"
        />
        <form:errors id="passwordConfirmationError" path="passwordConfirmation" cssClass="mt-2 mb-3 ms-2" cssStyle="color: orangered" />
      </div>
      <div class="mb-3 ms-2" id="passwordCheck" style="color: orangered"></div>
      <div class="mb-5">
        <form:input id="username"
                    path="username"
                    class="form-control"
                    placeholder="아이디"
                    required="true"
        />
        <form:errors path="username" cssClass="mt-2 mb-3 ms-2" cssStyle="color: orangered"  />
      </div>

      <div>
        <div class="mb-2">
          <button type="submit" class="btn btn-primary custom-join-btn">
            등록하기
          </button>
        </div>
      </div>

    </form:form>

  </div>
</div>

<script src="/js/joinForm.js"></script>
<%@ include file="../layout/footer.jsp" %>