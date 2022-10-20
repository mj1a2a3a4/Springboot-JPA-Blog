<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="form-group">
		<h3>${board.title }</h3>
	</div>
	<div>
		글 번호 : <span id="id"><i>${board.id } </i></span> 작성자 : <span><i>${board.user.username } </i></span> 등록일 : <span><i>${board.createDate }</i></span>
	</div>
	<hr />
	<div class="form-group">
		<div>${board.content }</div>
		<hr />
	</div>
	<button class="btn btn-secondary" onclick="history.back()">되돌아가기</button>
	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id }/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br> <br>
	<div class="card">
		<div class="card-body">
			<textarea class="form-control" rows="1"></textarea>
		</div>
		<div class="card-footer">
			<button class="btn btn-primary">등록</button>
		</div>
	</div>
	<br />
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply--box" class="list-group">
			<c:forEach var="reply" items="${board.replys }">
				<li id="reply--1" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex ">
						<div class="font-italic">작성자 : ${reply.user.username } &nbsp;</div>
						<button class="badge">삭제</button>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<script src='/js/board.js'></script>
<%@ include file="../layout/footer.jsp"%>


