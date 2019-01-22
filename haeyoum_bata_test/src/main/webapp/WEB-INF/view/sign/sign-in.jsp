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
	<!-- nav bar -->
	<%@ include file="/WEB-INF/view/util/sign_nav.jsp"%>

	<div class="container">
		<div class="col-xs-12 col-sm-12 col-lg-6 margin-auto">
   			<h2 class="title">로그인</h2>
   			<!-- sign-up form -->
   			<form class="inputForm" action="${pageContext.request.contextPath}/sign-in" method="post">
				<input type="email" class="form-control input-lg" name="email" maxlength="40" placeholder="메일주소를 입력해주세요" required>
				<input type="password" class="form-control input-lg" name="password" maxlength="20" placeholder="비밀번호를 입력해주세요" required>
				<div id="err" class="alert alert-danger" role="alert">&nbsp;</div>
				<button class="btn btn-sign-up btn-lg btn-block m-t-5">로그인</button>
   			</form>
   			<div class="btnGroup m-t-10">
				<button type="button" class="btn btn-default btn-lg btn-block">
				  <span class="glyphicon" aria-hidden="true">
				  	<img class="sign-up-icon" src="${pageContext.request.contextPath}/resources/images/naver_icon.PNG" alt="No Image...">
				  </span>
				  <small>네이버로 로그인</small>
				</button>
			</div>
			<div class="btnGroup">
				<button type="button" class="btn btn-default btn-lg btn-block">
				  <span class="glyphicon" aria-hidden="true">
				  	<img class="sign-up-icon" src="${pageContext.request.contextPath}/resources/images/facebook_icon.png" alt="No Image...">
				  </span>
				  <small>페이스북으로 로그인</small>
				</button>
			</div>
			<p class="text-center m-t-10">해윰이 처음이신가요? &nbsp;
			<a class="text-info" href="${pageContext.request.contextPath}/sign-up"><strong>회원가입</strong></a>
			</p>
			
		</div>
    </div> <!-- /container -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var idError = ${errors.idError};
		var pwError = ${errors.pwError};
		var notConfirmError = ${errors.notConfirmUser};
		if(idError){
			$('#err').text('아이디를 확인해주세요.');
			$('#err').css('visibility','visible');
		} else if (pwError){
			$('#err').text('비밀번호를 확인해주세요.');
			$('#err').css('visibility','visible');
		} else if (notConfirmError){
			$('#err').text('인증이 필요한 사용자입니다. 이메일 인증을 진행해주세요.');
			$('#err').css('visibility','visible');
		}
	</script>
</body>
</html>