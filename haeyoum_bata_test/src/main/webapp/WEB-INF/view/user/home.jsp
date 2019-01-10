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
	<body class="sti-body">
		<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">해 윰</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <form class="navbar-form navbar-left" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Search">
		        </div>
		        <button type="submit" class="btn btn-default btn-search"><span class="glyphicon glyphicon-search"></span></button>
		      </form>
		      <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-bell"></span> <span class="badge">0</span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="#">새글알림 영역입니다.....</a></li>
		            <li class="divider"></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="#">내 정보</a></li>
		            <li class="divider"></li>
		            <li><a href="#">초대코드 입력</a></li>
		            <li class="divider"></li>
		            <li><a href="#">로그아웃</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		
		<div class="container userArea">
			<div class="row row-offcanvas row-offcanvas-right">

		        <div class="col-xs-12 col-sm-12">
		          <p class="pull-right visible-xs">
		            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
		          </p>
		          <div class="jumbotron">
		            <h1>해윰, 모임의 시작!</h1>
		            <p>여기에서 여러분들의 이야기가 시작됩니다. 해윰을 만들고 친구들을 초대해서 독창적인 모임 또는 스토리를 만들어가세요.</p>
		          </div>
		          <div class="row">
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>해윰 만들기</h2>
		              <p></p>
		            </div><!--/.col-xs-12.col-lg-4-->
		            <div class="col-xs-12 col-lg-4 h-list">
		              <h2>테스트 해윰</h2>
		              <p>테스트 해윰 소개글 없으면 그냥 빈공간이려나?</p>
		              <p class="btn-bottom"><a class="btn btn-default" href="#" role="button">방 들어가기 &raquo;</a></p>
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
		
		<footer class="footer sti-foot">
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
		<script src="${pageContext.request.contextPath}/resources/js/grouplistajax.js"></script>
	</body>
</html>