<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>HaeYoum</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css" type="text/css">
	</head> 
	<body class="sti-body">
		<!-- nav bar -->
		<%@ include file="/WEB-INF/view/util/user_nav.jsp"%>
		
		<div class="container userArea">
			<div class="row row-offcanvas row-offcanvas-right">

		        <div class="col-xs-12 col-sm-12">
		          <div class="jumbotron">
		            <h1>해윰, 모임의 시작!</h1>
		            <p>여기에서 여러분들의 이야기가 시작됩니다. 해윰을 만들고 친구들을 초대해서 독창적인 모임 또는 스토리를 만들어가세요.</p>
		          </div>
		          <div class="row" id="listSection">
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>해윰 만들기</h2>
		              <p>여기에서 모임을 만들어 보세요!</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="${pageContext.request.contextPath}/haeyoum/create" role="button">모임 만들기 &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>테스트 해윰</h2>
		              <p>테스트 해윰 소개글 없으면 그냥 빈공간이려나?</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">모임 들어가기 &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>테스트 해윰</h2>
		              <p>테스트 해윰 소개글 없으면 그냥 빈공간이려나?</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">모임 들어가기 &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>테스트 해윰</h2>
		              <p>테스트 해윰 소개글 없으면 그냥 빈공간이려나?</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">모임 들어가기 &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>테스트 해윰</h2>
		              <p>테스트 해윰 소개글 없으면 그냥 빈공간이려나?</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">모임 들어가기 &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		          </div><!--/row-->
		        </div><!--/.col-xs-12.col-sm-9-->
		
		      </div><!--/row-->
		</div>
		
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/listajax.js"></script>
	</body>
</html>