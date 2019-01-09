<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="${pageContext.request.contextPath}/">해 윰</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="${pageContext.request.contextPath}/sign-up">회원가입</a></li>
	            <li><a href="${pageContext.request.contextPath}/sign-in">로그인</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </header>
	    
	    <div class="container">
	    	<!-- main Area -->
	    	<div class="mainArea">
	    		<div class="imgSection col-xs-7 col-sm-7 col-lg-7"></div>
	    		<div class="loginSection col-xs-5 col-sm-5 col-lg-5">
	    			<div class="sign-up">
		    			<h2 class="title">
		    				특별한 모임의 시작!
		    				<br>
		    				우리끼리 해윰
		    			</h2>
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
	    		</div>
	    	</div>
	    </div>
	    <!-- img Area -->
    	<div class="imgArea col-xs-12 col-sm-12 col-lg-12">
    		<div class="script">
	    		<h1>우리만의 특별한 모임, 해윰</h1>
	    		<p class="sub">
	    			해윰은 그룹 멤버와 함께 하는 공간입니다.<br/> 
					친구, 스터디, 주제별 모임을 해윰으로 시작하세요.
				</p>
			</div>
    	</div>
    	<!-- sub Area -->
	    <div class="container">
	    	<div class="sub-con">
		    	<div class="row">
				  <div class="col-sm-6 col-md-4">
				    <div class="img-rounded">
				      <img class="img-rounded" src="${pageContext.request.contextPath}/resources/images/sub_img_01.jpg" alt="No Image...">
				      <div class="caption">
				        <h3 class="str-cen">어떤 모임이라도!</h3>
				        <p class="str-cen">
				        	친구, 가족, 동료 등 함께 하고 싶은 사람과 <br/>
							우리만의 공간을 만들어보세요.
						</p>
				      </div>
				    </div>
				  </div>
				  <div class="col-sm-6 col-md-4">
				    <div class="img-rounded">
				      <img class="img-rounded" src="${pageContext.request.contextPath}/resources/images/sub_img_02.jpg" alt="No Image...">
				      <div class="caption">
				        <h3 class="str-cen">모임에 어울리는 기능들</h3>
				        <p class="str-cen">
				        	투표로 의견을 모으고, 함께 일정을 공유하며 <br/>
							게시판과 앨범에는 추억을 쌓아보세요.
						</p>
				      </div>
				    </div>
				  </div>
				  <div class="col-sm-6 col-md-4">
				    <div class="img-rounded">
				      <img class="img-rounded" src="${pageContext.request.contextPath}/resources/images/sub_img_03.jpg" alt="No Image...">
				      <div class="caption">
				        <h3 class="str-cen">어떤 모임이라도</h3>
				        <p class="str-cen">
				        	취미, 스포츠, 또래 모임 등 <br/>
							나와 같은 관심사 밴드를 찾을 수 있어요.
						</p>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
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
	    
		<script type="text/javascript">
		var msg = '${msg}';
		if( msg.length != 0 ) {
			alert(msg);
		}
		</script>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</body>
</html>
