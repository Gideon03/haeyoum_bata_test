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
	<%@ include file="/WEB-INF/view/util/user_nav.jsp"%>

	<div class="container">
		<div class="col-xs-12 col-sm-12 col-lg-6 margin-auto">
   			<h2 class="title">로그아웃</h2>
   			<!-- sign-up form -->
   			<form class="inputForm" action="${pageContext.request.contextPath}/sign-out" method="post">
				<button class="btn btn-sign-up btn-lg btn-block m-t-10">로그아웃</button>
   			</form>
		</div>
    </div> <!-- /container -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>