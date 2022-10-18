<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">USERNAME : </label> 
			<input type="text" class="form-control" placeholder="Enter Username" name="username" id="username">
		</div>
		<div class="form-group">
			<label for="password">PASSWORD : </label> 
			<input type="password" class="form-control" placeholder="Enter Password" name="password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=74cd7b92b8278684161b3e0556e8b6a9&redirect_uri=http://localhost:8000//auth/kakao/callback&response_type=code"><img height="38" src="/image/kakao_login_button.png"/></a>
	</form>
</div>
<br />
<script src='/js/user.js'></script>
<%@ include file="../layout/footer.jsp"%>
