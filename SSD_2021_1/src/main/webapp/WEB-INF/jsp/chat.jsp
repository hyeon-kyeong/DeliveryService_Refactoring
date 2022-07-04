<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>
<style>
.chatbox {
	padding: 10px 10px 0px 10px;
	height: 450px;
	width: 100%;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script>
	$(document).ready(function() {
		var socket = new SockJS('/websocket');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/greetings', function(greeting) {
				showGreeting(JSON.parse(greeting.body).content);
			});
			stompClient.subscribe('/topic/chat', function(chat) {
				showChat(JSON.parse(chat.body));
			});
		});
		
// 		document.getElementById("content").focus();

	});
	
	var stompClient = null;

	function setConnected(connected) {
		$("#connect").prop("disabled", connected);
		$("#disconnect").prop("disabled", !connected);
		if (connected) {
			$("#conversation").show();
		} else {
			$("#conversation").hide();
		}
		$("#greetings").html("");
	}

	function connect() {
		if (stompClient == null) {
			var socket = new SockJS('/websocket');
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('Connected: ' + frame);
				stompClient.subscribe('/topic/greetings', function(greeting) {
					showGreeting(JSON.parse(greeting.body).content);
				});
				stompClient.subscribe('/topic/chat', function(chat) {
					showChat(JSON.parse(chat.body));
				});
			});
		}
	}

	// 	function disconnect() {
	// 		if (stompClient !== null) {
	// 			stompClient.disconnect();
	// 		}
	// 		setConnected(false);
	// 		console.log("Disconnected");
	// 	}

	// 	function sendName() {
	// 		stompClient.send("/app/hello", {}, JSON.stringify({
	// 			'senderUsername' : $("#senderUsername").val()
	// 		}));
	// 	}

	function sendChat() {
		if ($("#content").val() != "") {
			stompClient.send("/app/chat", {}, JSON.stringify({
				'senderUsername' : $("#senderUsername").val(),
				'receiverUsername' : $("#receiverUsername").val(),
				'content' : $("#content").val()
			}));
		}

		$("#content").val("");
	}

// 	function showGreeting(message) {
// 		$("#greetings").append("<tr><td>" + message + "</td></tr>");
// 	}

	function showChat(chat) {
		var today = new Date();
		var hour = ('0' + today.getHours()).slice(-2);
		var minute = ('0' + today.getMinutes()).slice(-2);
		var blank = "<br>";
		for (var i = 0; i < Math.floor(chat.content.length / 17); i++) {
			blank += "<br>";
		}
		console.log(blank);
		if (chat.senderUsername == $("#senderUsername").val()) {		
			$("#chatbox").append(
				"<table>"
				+ "<label for=\"myMessage\" class=\"float-right\">나</label>"
				+ "<br><div class=\"d-inline-flex p-2 bg-light text-dark float-right\" id=\"myMessage\" style=\"max-width:60%\; border-radius:10px\;\">"
				+ chat.content + "</div>"
				+ blank + "<div class=\"float-right\">"
				+ hour + " : " + minute
				+ "</div></table>");
		} 
		else {
			$("#chatbox").append(
				"<table>"
				+ "<label for=\"yourMessage\" class=\"float-left\">"
				+ chat.senderUsername
				+ "</label>"
				+ "<br><div class=\"d-inline-flex p-2 bg-secondary text-white float-left\" style=\"max-width:60%\; border-radius:10px\;\">"
				+ chat.content + "</div>"
				+ blank + today.getHours() + " : " + today.getMinutes()
				+ "</table>");
		}

		var chat = document.getElementById("chatbox");
		chat.scrollTop = chat.scrollHeight;
	}

	$(function() {
		$("form").on('submit', function(e) {
			e.preventDefault();
		});
		$("#disconnect").click(function() {
			disconnect();
		});
		$("#send").click(function() {
			sendName();
		});
		$("#chatSend").click(function() {
			sendChat();
			chatSend();
		});
	});

	function chatSend() {
		$.ajax({
			url : "${pageContext.request.contextPath}/delivery/insertChat.do",
			type : "POST",
			data : {
				senderUsername : $("#senderUsername").val(),
				receiverUsername : $("#receiverUsername").val(),
				content : $("#content").val()
			},
			dataType : "json",
			success : function(result) {
				console.log("success");
			},
			error : function(xhr, status, err) {
				console.log("fail");

				console.log(xhr);
				console.log(status);
				console.log(err);
			}
		});
	}
</script>
<%-- <div id="main-content" class="container">
	<div class="row">
		<div class="col-md-6">
			<form class="form-inline">
				<div class="form-group">
					<label for="connect">WebSocket connection:</label>
					<button id="connect" class="btn btn-default" type="submit">Connect</button>
					<button id="disconnect" class="btn btn-default" type="submit"
						disabled="disabled">Disconnect</button>
				</div>
			</form>
		</div>
		<div class="col-md-6">
			<form class="form-inline">
								<div class="form-group">
									<label for="senderUsername">What is your name?</label> <input
										type="text" id="senderUsername" class="form-control"
										placeholder="Your name here..." value=${username } />
								</div>
								<div class="form-group">
									<label for="senderUsername">Receiver's name</label> <input
										type="text" id="receiverUsername" class="form-control"
										placeholder="Receiver name here..." value="k" />
								</div>
				                <div class="form-group">
				                	<label for="content">Input Message</label>
				                	<input type="text" id="content" class="form-control" placeholder="message.." />
				                </div>
				                <button id="chatSend" class="btn btn-default" type="button">Chat Send</button>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table id="conversation" class="table table-striped">
				<thead>
					<tr>
						<th>Messages</th>
					</tr>
				</thead>
				<tbody id="greetings">
				</tbody>
			</table>
		</div>
	</div>
</div> --%>

<!-- Wrapper -->
<form action="/delivery/chat.do" method="POST">
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<h1>💬 Your Message</h1>
				<div style="width: 500px;">
					<div class="bg-dark text-white "
						style="width: 500px; height: 60px; display: table;">
						<span class="align-middle"
							style="display: table-cell; text-align: center;">${receiverUsername} 님 과의 대화</span>

						<!-- 						 <span class="align-middle" -->
						<%-- 							style="display: table-cell; padding: 0 0 0 20px;">${receiver}님 --%>
						<!-- 							과의 대화</span>  -->
						<!-- <a href="message_list.jsp">DM리스트</a> -->
						<a href="/delivery/message.do" class="button text-white"
							style="display: table-cell; padding: 15px; font-size:20px">DM리스트</a>
					</div>
					<div class="chatbox" id="chatbox"
						style="overflow-y: auto; overflow-x: hidden;"></div>
					<%-- 					<c:forEach var="list" items="${contentList}"> --%>
					<%-- 						<c:choose> --%>
					<%-- 							<c:when test="${username eq list.senderUsername}"> --%>
					<!-- 								<div class="chatbox "> -->
					<!-- 									<div class="chatbox float-right"> -->
					<!-- 										<label for="myMessage" class="float-right">나</label><br> -->
					<%-- 										${list.messageDate } --%>
					<!-- 										<div class="d-inline-flex p-2 bg-light text-dark float-right" -->
					<%-- 											id="myMessage">${list.content}</div> --%>
					<!-- 									</div> -->
					<!-- 								</div> -->
					<%-- 							</c:when> --%>
					<%-- 							<c:otherwise> --%>
					<!-- 								<div class="chatbox"> -->
					<!-- 									<div class="chatbox "> -->
					<%-- 										<label for="buyerMessage">${list.senderUsername}</label><br> --%>

					<%-- 										${list.messageDate } --%>
					<!-- 										<div -->
					<!-- 											class="d-inline-flex p-2 bg-secondary text-white float-left" -->
					<%-- 											id="buyerMessage">${list.content}</div> --%>
					<!-- 									</div> -->
					<!-- 								</div> -->
					<%-- 							</c:otherwise> --%>

					<%-- 						</c:choose> --%>
					<%-- 					</c:forEach> --%>
				</div>
				<br>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">메시지 보내기</label>
					<textarea class="form-control" id="content" rows="2" cols="2"
						style="width:500px; overflow-y:scroll;" placeholder="이곳에 메세지를 작성하세요." name="content"></textarea>
					<c:if test="${data ne null}">
						<p style="color: #E16A93">${data.message}</p>
					</c:if>
				</div>
				<button id="chatSend" class="primary" type="button">Chat
					Send</button>
				<!-- 				<input type="submit" value="Send Message" class="primary" /> -->
			</div>
		</div>
	</div>
</form>
<%@ include file="IncludeBottom.jsp"%>