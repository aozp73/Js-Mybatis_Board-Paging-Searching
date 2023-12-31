<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%-- boostrap --%>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <%-- jQuery --%>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <title>Document</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>

  <body>
    <nav class="custom-navbar-layout navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid ms-3">
        <a class="navbar-brand" href="/">Home</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
          <!-- <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li> -->
          <div class="d-flex justify-content-between w-100">
            <ul class="navbar-nav ms-3">
              <li class="nav-item">
                <a class="nav-link" href="/board/list">게시판</a>
              </li>
            </ul>
            <ul class="navbar-nav me-5">
              <sec:authorize access="isAuthenticated()">
                <li id="statusLogin" class="nav-item">
                  <div class="d-flex">
                    <span class="nav-link me-2">
                        <sec:authentication property="name" />
                    </span>
                    <a class="nav-link" href="/logout">로그아웃</a>
                  </div>
                </li>
              </sec:authorize>
              <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                  <div>
                    <a class="nav-link" href="/loginForm">로그인</a>
                  </div>
                </li>
              </sec:authorize>
            </ul>
          </div>
        </div>

      </div>
    </nav>

    <script src="/js/header.js"></script>