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

		        <div class="col-xs-12 col-sm-9">
					<form class="login100-form validate-form flex-sb flex-w" action="${pageContext.request.contextPath}/group/regist" method="post">
				 		<span class="login100-form-title p-b-32" style="font-family: 'Jua', sans-serif;">
							그룹생성
						</span>
				 		<span class="txt1 p-b-11" >
							그룹이름
						</span>
						<div class="wrap-input100 validate-input m-b-36" data-validate = "Group name is required">
							<input class="input100" type="text" name="group_name" autofocus>
						  	<span class="focus-input100"></span>
						</div>
						
						<span class="txt1 p-b-11" >
							최대인원
						</span>
						<div class="wrap-input100 validate-input m-b-36">
							<select class="form-control" name="group_max">
								<option value="2" selected="selected">2 명</option>
								<option value="3">3 명</option>
								<option value="4">4 명</option>
								<option value="5">5 명</option>
								<option value="6">6 명</option>
								<option value="7">7 명</option>
								<option value="8">8 명</option>
								<option value="9">9 명</option>
								<option value="10">10 명</option>
							</select>
						</div>
				 		
				 		<span class="txt1 p-b-11" >
							그룹코드
						</span>
						<div class="wrap-input100 m-b-36" style="border: 0;">
							<c:if test="${errors.emptyCode}">
								<label class="input100" id="code">
									초대코드를 생성하세요.
								</label>
							</c:if>
							<c:if test="${errors.errorCode}">
								<label class="input100" id="code">
								초대코드 발급중 오류가 발생하였습니다 관리자에게 문의하세요.
								</label>
							</c:if>
							
							<input id="input_code" type="hidden" name="group_code">
						  	<button class="login100-form-btn" type="button" id="btn">초대코드 생성</button>
						</div>
							
						<div class="container-login300-form-btn">
							<button class="login300-form-btn" >만들기</button>
							<button class="login100-form-btn" type="button" onclick="history.back()">
								돌아가기
							</button>
						</div>
					</form>
            	</div>
        	</div>
        </div>
		        <!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	</body>
</html>