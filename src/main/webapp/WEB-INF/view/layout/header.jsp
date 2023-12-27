<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <a class="navbar-brand" href="#">Home</a>
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
                <a class="nav-link" href="#">게시판</a>
              </li>
            </ul>
            <ul class="navbar-nav me-5">
              <li class="nav-item">
                <a class="nav-link" href="#">로그인</a>
              </li>
            </ul>
          </div>
        </div>

      </div>
    </nav>