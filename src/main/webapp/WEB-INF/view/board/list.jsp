<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 50px; margin-bottom: 50px">
    <div class="container custom-board-list-container mb-5 mt-5">
        <div class="mb-5">

            <div class="custom-top-layout">
                <div class="custom-flex-item number">
                    <span>번호</span>
                </div>
                <div class="custom-flex-item title">
                    <span>제목</span>
                </div>
                <div class="custom-flex-item author">
                    <span>글쓴이</span>
                </div>
                <div class="custom-flex-item date">
                    <span>작성일</span>
                </div>
                <div class="custom-flex-item view">
                    <span>조회</span>
                </div>
            </div>

            <c:forEach var="board" items="${boardList}">
            <div class="custom-board-layout">
                <div class="custom-flex-item number custom-board-font">
                    <span>${board.id}</span>
                </div>
                <div class="custom-flex-item title custom-board-font" style="text-align: left">
                    <span class="me-1">${board.title}</span>
                    <span>(2)</span>
                </div>
                <div class="custom-flex-item author custom-board-font">
                    <span>${board.username}</span>
                </div>
                <div class="custom-flex-item date custom-board-font">
                    <span>${board.createdAtFormat}</span>
                </div>
                <div class="custom-flex-item view custom-board-font">
                    <span>${board.views}</span>
                </div>
            </div>
            </c:forEach>

        </div>

        <div>
            <div class="d-flex justify-content-center">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="d-flex justify-content-center">
                <div>
                    <div class="input-group">
                        <div class="me-2">
                            <input type="text" class="form-control" style="width: 270px" placeholder="검색어를 입력하세요">
                        </div>
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="button">검색</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>