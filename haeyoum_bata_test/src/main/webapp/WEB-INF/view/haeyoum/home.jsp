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
		          </p>
		          <div class="jumbotron">
		            <h1>${room.title}</h1>
		            <p>T${room.intro}</p>
		          </div>
		          
		        </div><!--/.col-xs-12.col-sm-9-->
		
		        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		          <div class="list-group">
		            
		          </div>
		        </div><!--/.sidebar-offcanvas-->
		      </div><!--/row-->
		
		</div>
		
		
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</body>
</html>