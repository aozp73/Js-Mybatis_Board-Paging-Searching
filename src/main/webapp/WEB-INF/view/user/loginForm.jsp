<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 70px; margin-bottom: 100px">
  <div class="container custom-login-custom-container mb-5 mt-5">

    <form  action="/login" method="post">
  
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
            <button type="submit" class="btn btn-primary custom-login-btn">
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


<%@ include file="../layout/footer.jsp" %>