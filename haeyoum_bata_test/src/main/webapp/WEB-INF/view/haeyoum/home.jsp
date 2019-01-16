<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>HaeYoum</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.png" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/basic.css" type="text/css">
		<link rel="stylesheet" type="text/css"  href='${pageContext.request.contextPath}/resources/css/chat.css' />
        
        <!-- Web Socket JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	</head> 
	<body>
		<!-- nav bar -->
		<%@ include file="/WEB-INF/view/util/user_nav.jsp"%>
		<div class="container">
			<ul class="nav nav-tabs navbar-fixed-top room-nav">
			  <li role="presentation" class="active"><a href="#">홈</a></li>
			  <li role="presentation"><a href="#">노트</a></li>
			  <li role="presentation"><a href="#">앨범</a></li>
			  <li role="presentation"><a href="#">일정</a></li>
			  <li role="presentation"><a href="#">투표</a></li>
			</ul>
		</div>
		<div class="container roomArea">
			<div class="row row-offcanvas row-offcanvas-right">

		        <div class="col-xs-12 col-sm-9">
		          <p class="pull-right visible-xs">
		          </p>
		          <div class="jumbotron">
		            <h1>${room.title}</h1>
		          </div>
		          <div class="row">
					  <div class="col-xs-12 col-lg-4">
			              <div class="thumbnail h-list">
			              <div class="caption">
					        <h3>테스트 최신글</h3>
					        <p>두기 얼음이 품으며, 크고 힘차게 설레는 발휘하기 튼튼하며, 황금시대다. 가진 힘차게 열매를 뜨고, 뭇 그들은 가지에 소담스러운 철환하였는가? 하는 속에 남는 봄날의 군영과 거선의 칼이다. 설레는 이상 위하여 심장의 노년에게서 청춘의 것이다. 웅대한 노래하며 놀이 이 몸이 칼이다. 못할 이상 구하지 곧 얼음이 굳세게 뿐이다. 따뜻한 물방아 얼마나 대고, 봄바람이다. 청춘 밥을 물방아 청춘의 이상, 피고 교향악이다. 예가 붙잡아 따뜻한 우리의 황금시대를 눈이 위하여서. 사라지지 이상의 이것이야말로 봄바람이다. 그들의 실현에 있는 것은 피고 바로 동산에는 같이 하는 듣는다.</p>
					        <p><a class="btn btn-default" href="#" role="button">보러가기 &raquo;</a></p>
					      </div>
					    </div>
					  </div><!--/.col-xs-12 col-lg-4-->
					  <div class="col-xs-12 col-lg-4">
			              <div class="thumbnail h-list">
			              <div class="caption">
					        <h3>테스트 최신글</h3>
					        <p>두기 얼음이 품으며, 크고 힘차게 설레는 발휘하기 튼튼하며, 황금시대다. 가진 힘차게 열매를 뜨고, 뭇 그들은 가지에 소담스러운 철환하였는가? 하는 속에 남는 봄날의 군영과 거선의 칼이다. 설레는 이상 위하여 심장의 노년에게서 청춘의 것이다. 웅대한 노래하며 놀이 이 몸이 칼이다. 못할 이상 구하지 곧 얼음이 굳세게 뿐이다. 따뜻한 물방아 얼마나 대고, 봄바람이다. 청춘 밥을 물방아 청춘의 이상, 피고 교향악이다. 예가 붙잡아 따뜻한 우리의 황금시대를 눈이 위하여서. 사라지지 이상의 이것이야말로 봄바람이다. 그들의 실현에 있는 것은 피고 바로 동산에는 같이 하는 듣는다.</p>
					        <p><a class="btn btn-default" href="#" role="button">보러가기 &raquo;</a></p>
					      </div>
					    </div>
					  </div><!--/.col-xs-12 col-lg-4-->
					  <div class="col-xs-12 col-lg-4">
			              <div class="thumbnail h-list">
			              <div class="caption">
					        <h3>테스트 최신글</h3>
					        <p>두기 얼음이 품으며, 크고 힘차게 설레는 발휘하기 튼튼하며, 황금시대다. 가진 힘차게 열매를 뜨고, 뭇 그들은 가지에 소담스러운 철환하였는가? 하는 속에 남는 봄날의 군영과 거선의 칼이다. 설레는 이상 위하여 심장의 노년에게서 청춘의 것이다. 웅대한 노래하며 놀이 이 몸이 칼이다. 못할 이상 구하지 곧 얼음이 굳세게 뿐이다. 따뜻한 물방아 얼마나 대고, 봄바람이다. 청춘 밥을 물방아 청춘의 이상, 피고 교향악이다. 예가 붙잡아 따뜻한 우리의 황금시대를 눈이 위하여서. 사라지지 이상의 이것이야말로 봄바람이다. 그들의 실현에 있는 것은 피고 바로 동산에는 같이 하는 듣는다.</p>
					        <p><a class="btn btn-default" href="#" role="button">보러가기 &raquo;</a></p>
					      </div>
					    </div>
					  </div><!--/.col-xs-12 col-lg-4-->
					  <div class="col-xs-12 col-lg-4">
			              <div class="thumbnail h-list">
			              <div class="caption">
					        <h3>테스트 최신글</h3>
					        <p>두기 얼음이 품으며, 크고 힘차게 설레는 발휘하기 튼튼하며, 황금시대다. 가진 힘차게 열매를 뜨고, 뭇 그들은 가지에 소담스러운 철환하였는가? 하는 속에 남는 봄날의 군영과 거선의 칼이다. 설레는 이상 위하여 심장의 노년에게서 청춘의 것이다. 웅대한 노래하며 놀이 이 몸이 칼이다. 못할 이상 구하지 곧 얼음이 굳세게 뿐이다. 따뜻한 물방아 얼마나 대고, 봄바람이다. 청춘 밥을 물방아 청춘의 이상, 피고 교향악이다. 예가 붙잡아 따뜻한 우리의 황금시대를 눈이 위하여서. 사라지지 이상의 이것이야말로 봄바람이다. 그들의 실현에 있는 것은 피고 바로 동산에는 같이 하는 듣는다.</p>
					        <p><a class="btn btn-default" href="#" role="button">보러가기 &raquo;</a></p>
					      </div>
					    </div>
					  </div><!--/.col-xs-12 col-lg-4-->
				   </div><!--/row-->
		        </div><!--/.col-xs-12.col-sm-9-->
		
		        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		            <div class="chat-container chat-clearfix">
							   
							    <div class="chat-">
							      <div class="chat-header chat-clearfix">
							        <div class="chat-about">
							          <div class="chat-with">채팅</div>
							        </div>
							      </div> <!-- end chat-header -->
							      
							      <div id="chat-history" class="chat-history">
							        <ul id="chatdata">
							        	 <!-- append chat message -->
							        	 <c:forEach var="msgList" items="${msgList}">
							        	 	<c:if test="${user.member_id == msgList.member_id}" var="result">
								        	 	<li class="chat-clearfix">
									        	 	<div class="chat-message-data chat-align-right">
										        	 	<span class="chat-message-data-time">${msgList.send_date}</span> &nbsp; &nbsp;
										        	 	<span class="chat-message-data-name"><strong>${msgList.member_id}</strong>&nbsp;</span>
										        	 	<i class="fa fa-circle chat-me"></i>
									        	 	</div>
									        	 	<div class="chat-message chat-my-message chat-float-right">
									        	 	${msgList.content}
									        	 	</div>
								        	 	</li>
							        	 	</c:if>
							        	 	<c:if test="${not result}">
							        	 		<li>
							        	 			<div class="chat-message-data">
							        	 				<i class="fa fa-circle chat-other"></i>
							        	 				<span class="chat-message-data-name"><strong>${msgList.member_id}</strong></span>
							        	 				<span class="chat-message-data-time">${msgList.send_date}</span>
							        	 			</div>
							        	 			<div class="chat-message chat-other-message">
							        	 			${msgList.content}
							        	 			</div>
							        	 		</li>
							        	 	</c:if>
							        	 </c:forEach>
							        </ul>
							      </div> <!-- end chat-history -->
							      
							      <div class="chat-message chat-clearfix">
							        <textarea id="message" class="chat-textarea" placeholder ="Type your message" rows="3" required="required"></textarea>
							        
							        <button id="sendBtn" class="chat-button">Send</button>
							
							      </div> <!-- end chat-message -->
							      
							    </div> <!-- end chat -->
							    
							  </div> <!-- end container -->
		        </div><!--/.sidebar-offcanvas-->
		      </div><!--/row-->
		
		</div>
		
		
		<!-- footer bar -->
		<%@ include file="/WEB-INF/view/util/footer.jsp"%>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<!--Web Socket JavaScript-->
		<script type="text/javascript">
			$(document).ready(function() {
				
				updateScroll();
				
				$("#sendBtn").click(function(key) {
					// 정규식 공백제거
					var textarea = $('#message').val().replace(/\r\n|(^\s*)|(\s*$)|　/gi, '');
					
					if(!textarea == ''){
						sendMessage();
						$('#message').val('');
						$('#message').focus();
					}else{
						alert("입력한 내용이 없습니다.");
						$('#message').val('');
						$('#message').focus();
					}
				});
		
				$("#message").keydown(function(key) {
					var textarea = $('#message').val().replace(/\r\n|(^\s*)|(\s*$)|　/gi, '');
					// 엔터키 입력 감지
					if (key.keyCode == 13) {
						if(!textarea == ''){
							sendMessage();
							$('#message').val('');
							$('#message').focus();
						}else{
							alert("입력한 내용이 없습니다.");
							$('#message').val('');
							$('#message').focus();
						}
					}
				});
				
			});
			// 스크롤바 밑으로 내리기
			function updateScroll(){
				$('#chat-history').scrollTop($('#chat-history')[0].scrollHeight);
			}
			
			// 세션에서 로그인한 유저값 가져오기
			var member_id = '${user.member_id}';
			
			// 웹소켓을 지정한 url로 연결한다.
			let sock = new SockJS('<c:url value='/chat'/>');
			sock.onmessage = onMessage;
			sock.onclose = onClose;
		
			// 메시지 전송
			function sendMessage() {
				sock.send($("#message").val());
			}
		
			// 서버로부터 메시지를 받았을 때
			function onMessage(msg) {
				
				// 메시지를 보낸 유저값 가져오기
				var data = msg.data;
				var strArray = data.split('|');
				
				var session_id = strArray[0];
				var msg = strArray[1];
				var msgDate = strArray[2];
				
				if(member_id == session_id){
					var HTML = '<li class="chat-clearfix">';
					HTML += '<div class="chat-message-data chat-align-right">';
					HTML += '<span class="chat-message-data-time" >' + msgDate + '</span> &nbsp; &nbsp;';
					HTML += '<span class="chat-message-data-name" ><strong>' + session_id + '</strong>&nbsp;</span><i class="fa fa-circle chat-me"></i></div>';
					HTML += '<div class="chat-message chat-my-message chat-float-right">';
					HTML += msg;
					HTML += '</div></li>';
					
					$("#chatdata").append(HTML);
					updateScroll();
				
				} else {
					var HTML = '<li><div class="chat-message-data">';
					HTML += '<i class="fa fa-circle chat-other"></i>';
					HTML += '<span class="chat-message-data-name"><strong>' + session_id + '</strong></span>';
					HTML += '<span class="chat-message-data-time">' + msgDate + '</span></div>';
					HTML += '<div class="chat-message chat-other-message">';
					HTML += msg;
					HTML += '</div></li>';
					
					$("#chatdata").append(HTML);
					updateScroll();
				}
			}
		
			// 서버와 연결을 끊었을 때
			function onClose(evt) {
			}
			
		</script>
	</body>
</html>