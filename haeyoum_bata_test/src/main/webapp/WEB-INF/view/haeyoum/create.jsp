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

			<h1 class="text-center">해윰 만들기</h1>
			<form class="form-horizontal m-t-5" action="${pageContext.request.contextPath}/haeyoum/create" method="post">
		 		<div class="form-group">
				    <label for="title" class="col-sm-2 control-label">방 이름</label>
				    <div class="col-sm-10">
				      <input name="title" type="text" class="form-control" id="title" placeholder="Title" required>
				    </div>
				  </div><!-- end form-group -->
				  <div class="form-group">
				    <label for="max" class="col-sm-2 control-label">방 인원</label>
				    <div class="col-sm-10">
				      <select name="max" class="form-control" id="max">
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
				  </div><!-- end form-group -->
		 		<div class="form-group">
				    <label for="input_key" class="col-sm-2 control-label">초대코드</label>
				    <div class="col-sm-10">
				      <input id="input_key" type="hidden" name="roomkey">
				      <h4 id="key" hidden="true"><span id="key-val" class="label label-success"></span></h4>
				      <button class="btn btn-default" type="button" id="btn">생성하기</button>
				      <c:if test="${errors.emptyCode}">
							<span id="key-err" class="label label-warning">
								초대코드를 생성하세요.
							</span>
						</c:if>
						<c:if test="${errors.errorCode}">
							<span id="key-err" class="label label-danger">
								초대코드 발급중 오류가 발생하였습니다 관리자에게 문의하세요.
							</span>
						</c:if>
				    </div>
				  </div><!-- end form-group -->
				  <div class="form-group">
				    <label for="intro" class="col-sm-2 control-label">방 설명</label>
				    <div class="col-sm-10">
				      <textarea name="intro" id="intro" class="form-control" rows="3" placeholder="intro" required></textarea>
				    </div>
				  </div><!-- end form-group -->
				<div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">만들기</button>
				      <button class="btn btn-default" type="button" onclick="history.back()">
						돌아가기
						</button>
				    </div>
				  </div>
			</form>
			
        </div>
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script type="text/javascript">
	 		$("#btn").click(function() {
	 			$("#key-err").hide();
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/haeyoum/roomkey",
					dataType : "json",
					success : function(code) {
						$("#btn").hide();
						$("#key").show();
						$("#key-val").text(code.value);
						$("#input_key").val(code.value);
					},
					error : function() {
						$("#key").hide();
						$("#btn").show();
						$("#input_key").val("errorCode");
					}
				});
			});
	 		
	 		var msg = '${msg}';
			if( msg.length != 0 ) {
				alert(msg);
			}
		</script>
	</body>
</html>