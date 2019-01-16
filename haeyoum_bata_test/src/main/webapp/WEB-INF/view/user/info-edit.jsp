<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>MyPage</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css" type="text/css">
	</head> 
	<body class="sti-body">
		<!-- nav bar -->
		<%@ include file="/WEB-INF/view/util/user_nav.jsp"%>
		
		<div class="container">
		<div class="col-xs-12 col-sm-12 col-lg-6 margin-auto">
		<form action="${pageContext.request.contextPath}/user/edit"	method="post" enctype="multipart/form-data">
			 <h2 class="title" align="center"></h2>
			 		 
			 	<div class="form-group">
				    <label for="inputimage3" class="col-sm-2 control-label">Image</label>
				    <div class="col-sm-10">
				      <img id="img" src="${pageContext.request.contextPath}/resources/upload/${memberInfo.image}" alt="${memberInfo.image}" width= "50%" height="auto" > 
				      <input type="file" accept="image/*" name="file" onchange="loadFile(event)"  value="${memberInfo.image}"><br>	
				    </div>
				  </div>    	        
				 <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label">Email(ID)</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control input-lg" id="inputEmail3" value="${user.member_id}" readonly="readonly" name="email">	    
				    </div>
				  </div>

				  <div class="form-group">
				    <label for="inputPhone3" class="col-sm-2 control-label">Phone</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control input-lg" id="inputPhone3" value="${memberInfo.phone}" name="phone">
				    </div>
				  </div>				  		  
				  
				  <div class="form-inline">

				    <div class="col-sm-offset-2 col-sm-10" style="display:inline-table;">
				      <button class="btn btn-sign-up btn-lg btn-block m-t-10" type="submit" onclick="location.href='${pageContext.request.contextPath}/user/edit">정보수정</button>
				      <button class="btn btn-sign-up btn-lg btn-block m-t-10" onclick="location.href='${pageContext.request.contextPath}/'">홈으로</button>
				    </div>
				  </div>
				  
			</form>
		      </div><!--/row-->
		      
		      </div>
		

		
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/listajax.js"></script>
		
		<script type="text/javascript">
	   
		function readURL(input) {
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function (e) {
		            $('#img').attr('src', e.target.result);
		        }
		        reader.readAsDataURL(input.files[0]);
		    }
		};
		 	var loadFile = function(event) {
	      		var output = document.getElementById('img');
	      		output.src = URL.createObjectURL(event.target.files[0]);
	   		 };
	    </script>
	</body>
</html>