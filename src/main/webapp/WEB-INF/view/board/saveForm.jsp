<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp" %>

<div style="margin-top: 50px; margin-bottom: 50px">
    <div class="container custom-board-save-container mb-5 mt-5">
        <div class="text-center" style="margin-bottom: 37px">
            <h2>게시글 등록</h2>
        </div>
        <form>
            <div class="form-group mb-2">
                <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요">
            </div>
            <div class="form-group mb-3">
                <textarea class="form-control" id="content" rows="13" placeholder="내용을 입력하세요"></textarea>
            </div>
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-secondary me-2">등록</button>
                <button type="submit" class="btn btn-secondary">취소</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>