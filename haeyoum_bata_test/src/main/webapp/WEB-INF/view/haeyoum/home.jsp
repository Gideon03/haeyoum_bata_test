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
		
		<div class="container userArea">
			<div class="row row-offcanvas row-offcanvas-right">

		        <div class="col-xs-12 col-sm-9">
		          <p class="pull-right visible-xs">
		            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		          </p>
		          <div class="jumbotron">
		            <h1>Hello, world!</h1>
		            <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
		          </div>
		          <div class="row">
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		            <div class="col-xs-6 col-lg-4">
		              <h2>Heading</h2>
		              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
		              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
		            </div><!--/.col-xs-6.col-lg-4-->
		          </div><!--/row-->
		        </div><!--/.col-xs-12.col-sm-9-->
		
		        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		          <div class="list-group">
		            <a href="#" class="list-group-item active">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		            <a href="#" class="list-group-item">Link</a>
		          </div>
		        </div><!--/.sidebar-offcanvas-->
		      </div><!--/row-->
		
		</div>
		
		
		<footer class="footer">
	      <div class="container">
	      	<ul>
	      	 <li>블로그</li>
			 <li>광고</li>
	      	 <li>이용약관</li>
	      	 <li>개인보호처리방침</li>
	      	 <li>활동정책</li>
	      	 <li>개발자</li>
	      	 <li>도움말</li>
	        </ul>
	        <ul>
	      	 <li class="brand">HAEYOUM © 2018</li>
	        </ul>
	      </div>
	    </footer>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</body>
</html>