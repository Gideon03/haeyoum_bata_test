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

			<h1 class="text-center">초대받기</h1>
			<form class="form-horizontal m-t-5" action="${pageContext.request.contextPath}/haeyoum/invite" method="post">
		 		<p id="keyName" class="text-center">&nbsp;
						<c:if test="${errors.emptyKey}">코드를 입력하세요</c:if>
						<c:if test="${errors.errorKey}">코드를 확인하세요</c:if>
						<c:if test="${errors.emptyRoom}">코드를 확인하세요</c:if>
						<c:if test="${errors.joined}">이미 가입된 그룹이예요</c:if>
						<c:if test="${errors.fullMember}">그룹에 최대인원이 들어가있어요</c:if>
					</p>
		 		<div class="form-group">
				      <input name="roomkey" id="roomkey" type="text" class="form-control input-lg" id="title" maxlength="18" placeholder="초대코드를 입력하세요" required>
				  </div><!-- end form-group -->
				  
				<div class="form-group">
			      <button class="btn btn-sign-up btn-lg btn-block m-t-10">입력하기</button>
			      <button class="btn btn-sign-up btn-lg btn-block m-t-10" type="button" onclick="history.back()">돌아가기</button>
			    </div>
			</form>
			
        </div>
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$("#roomkey").keyup(function() {
				var key = $("#roomkey").val();
				
				if(key){
					$.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/haeyoum/roomkey/" + key,
						dataType : "json",
						success : function(key) {
							if(key.value == 1){
								$("#keyName").text("방을 찾았어요 :D");
							}else{
								$("#keyName").text("방을 찾을 수 없어요 :(");
							}
						},
						error : function() {
							$("#keyName").text("코드 에러");
							$("#roomkey").val("errorKey");
						}
					});
				}
			});
		</script>
	</body>
</html>