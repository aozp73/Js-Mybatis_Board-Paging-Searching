<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="height: 430px">
  <div class="container join-custom-container mb-5 mt-5">
    <div class="mb-4 text-center">
        <h2>회원가입</h2>
    </div>
    <form>
      <div class="mb-3">
        <input
          class="form-control"
          placeholder="이메일"
          id="email"
        />
      </div>
      <div class="mb-3">
        <input
          class="form-control"
          placeholder="비밀번호"
          id="password"
        />
      </div>
      <div class="mb-5">
        <input
          class="form-control"
          placeholder="아이디"
          id="username"
        />
      </div>

      <div>
        <div>
          <div class="mb-2">
            <button type="submit" class="btn btn-primary join-btn">
              회원가입
            </button>
          </div>
        </div>
      </div>

    </form>

  </div>
</div>


<%@ include file="../layout/footer.jsp" %>