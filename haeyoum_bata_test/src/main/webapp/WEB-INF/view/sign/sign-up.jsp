<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>HaeYoum</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css" type="text/css">
</head>
<body>
	<header class="navbar navbar-default navbar-static-top">
      <div class="container">
      	<div class="margin-auto brand">
          <a class="navbar-brand " href="${pageContext.request.contextPath}/">해 윰</a>
          </div>
      </div>
    </header>

	<div class="container">
		<div class="col-xs-12 col-sm-12 col-lg-6 margin-auto">
   			<h2 class="title">회원가입</h2>
   			<!-- sign-up form -->
   			<form class="inputForm" action="${pageContext.request.contextPath}/sign-up" method="post">
				<input type="email" class="form-control input-lg" name="m_email" placeholder="인증메일이 발송되니 확인해주세요" required>
				<input type="password" class="form-control input-lg" name="m_password" placeholder="비밀번호를 입력해주세요" required>
				<input type="text" class="form-control input-lg" name="m_name" placeholder="이름을 입력해주세요" required>
			
				<button class="btn btn-sign-up btn-lg btn-block m-t-10">회원가입</button>
   			</form>
   			<div class="btnGroup m-t-10">
				<button type="button" class="btn btn-default btn-lg btn-block">
				  <span class="glyphicon" aria-hidden="true">
				  	<img class="sign-up-icon" src="${pageContext.request.contextPath}/resources/images/naver_icon.PNG" alt="No Image...">
				  </span>
				  <small>네이버로 가입</small>
				</button>
			</div>
			<div class="btnGroup">
				<button type="button" class="btn btn-default btn-lg btn-block">
				  <span class="glyphicon" aria-hidden="true">
				  	<img class="sign-up-icon" src="${pageContext.request.contextPath}/resources/images/facebook_icon.png" alt="No Image...">
				  </span>
				  <small>페이스북으로 가입</small>
				</button>
			</div>
		</div>
    </div> <!-- /container -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>