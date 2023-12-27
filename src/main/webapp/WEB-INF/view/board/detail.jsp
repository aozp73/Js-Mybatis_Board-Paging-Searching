<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/WEB-INF/view/layout/header.jsp" %>

<div style="margin-top: 50px; margin-bottom: 50px">
    <div class="container custom-board-detail-container mb-5 mt-5">
        <div class="mb-2 d-flex justify-content-between align-items-center custom-board-detail-title">
            <div class="ms-1" style="font-size:18px">안녕하세요. 처음 가입했습니다!</div>
            <div style="color: gray;">2023.12.27 11:13:41</div>
        </div>
        <div class="d-flex justify-content-between align-items-center ms-1">
            <div>
                <span class="ms-3 me-3" style="color: gray;">aozp73</span>

            </div>
            <div class="me-2">
                <span class="me-3" style="color: gray;">조회수: 1</span>
                <span style="color: gray;">댓글: 2</span>
            </div>
        </div>
    
        <hr/>
        <div class="ms-2 py-3">
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>
        내용 <br>

        </div>
        <hr/>
        <div class="ms-1 mt-4 mb-5">
            <div class="ms-2 mb-2" style="font-size:13px">댓글 2개</div>
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div>
                        <span class="me-5">사용자1</span>
                        <span>안녕하세요~</span>
                    </div>
                    <div>
                        <span>2023.12.27 13:45:22</span>
                    </div>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <div>
                        <span class="me-5">사용자2</span>
                        <span>반가워요 !!</span>
                    </div>
                    <div>
                        <span>2023.12.27 14:30:10</span>
                    </div>
                </li>
            </ul>
        </div>
        <form action="" method="post" class="ms-1">
            <div class="mb-2">
                <textarea class="form-control" id="commentContent" name="commentContent" rows="3"></textarea>
            </div>
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">댓글 작성</button>
            </div>
        </form>

    </div>
</div>

<%@ include file="../layout/footer.jsp" %>