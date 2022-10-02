<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">USERNAME : </label> <input type="text" class="form-control" placeholder="Enter Username" id="username">
		</div>
			<div class="form-group">
			<label for="password">PASSWORD : </label> <input type="password" class="form-control" placeholder="Enter Password" id="password">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
<br />
<%@ include file="../layout/footer.jsp"%>
