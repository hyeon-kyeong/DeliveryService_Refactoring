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
			stompClient.subscribe('/topic/chat/${roomId}', function(chat) {
				console.log(chat);
				showChat(JSON.parse(chat.body));
			});
		});

		var chat = document.getElementById("chatbox");
		chat.scrollTop = chat.scrollHeight;
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
				stompClient.subscribe('/topic/chat/${roomId}', function(chat) {
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
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		var hour = ('0' + today.getHours()).slice(-2);
		var minute = ('0' + today.getMinutes()).slice(-2);
		
		if ($("#content").val() != "") {
			stompClient.send("/app/chat/${roomId}", {}, JSON.stringify({
				'username' : $("#senderUsername").val(),
				'content' : $("#content").val(),
				'chatDate' : year + "/" + month + "/" + day + " " + hour + ":" + minute,
				'roomId' : $("#roomId").val()
			}));
		}

		chatSend();

		$("#content").val("");
	}

	// 	function showGreeting(message) {
	// 		$("#greetings").append("<tr><td>" + message + "</td></tr>");
	// 	}
	var isNull = true;
	function showChat(chat) {
		isNull = false;
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		var hour = ('0' + today.getHours()).slice(-2);
		var minute = ('0' + today.getMinutes()).slice(-2);
		
		var blank = "<br>";
		for (var i = 0; i < Math.floor(chat.content.length / 17); i++) {
			blank += "<br>";
		}

		if (chat.username == $("#senderUsername").val()) {
			$("#chatbox")
					.append(
							"<table>"
									+ "<label for=\"myMessage\" class=\"float-right\">나</label>"
									+ "<br><div class=\"d-inline-flex p-2 bg-light text-dark float-right\" id=\"myMessage\" style=\"max-width:60%\; border-radius:10px\;\">"
									+ chat.content + "</div>" + blank
									+ "<div class=\"float-right\">" + year + "/" + month + "/" + day + " " + hour
									+ ":" + minute + "</div></table>");
		} else {
			$("#chatbox")
					.append(
							"<table>"
									+ "<label for=\"yourMessage\" class=\"float-left\">"
									+ $("#receiverUsername").val()
									+ "</label>"
									+ "<br><div class=\"d-inline-flex p-2 bg-secondary text-white float-left\" style=\"max-width:60%\; border-radius:10px\;\">"
									+ chat.content + "</div>" + blank
									+ year + "/" + month + "/" + day + " " + hour
									+ ":" + minute + "</table>");
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
		});
	});

	function chatSend() {
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0' + (today.getMonth() + 1)).slice(-2);
		var day = ('0' + today.getDate()).slice(-2);
		var hour = ('0' + today.getHours()).slice(-2);
		var minute = ('0' + today.getMinutes()).slice(-2);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/delivery/insertChat.do",
			type : "POST",
			data : {
				'username' : $("#senderUsername").val(),
				'content' : $("#content").val(),
				'chatDate' : year + "/" + month + "/" + day + " " + hour + ":" + minute,
				'roomId' : $("#roomId").val()
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
							style="display: table-cell; text-align: center;">${receiverUsername}
							님 과의 대화</span>
						<input type="hidden" id="senderUsername" value="${senderUsername}">
						<input type="hidden" id="receiverUsername" value="${receiverUsername}">
						<input type="hidden" id="roomId" value="${roomId}">
						<input type="hidden" id="chatDate">
						<a href="/delivery/chatList.do" class="button text-white"
							style="display: table-cell; padding: 15px; font-size: 20px">DM리스트</a>
					</div>
					<div class="chatbox" id="chatbox"
						style="overflow-y: auto; overflow-x: hidden;">
						<c:set var="chatVal" value="chatVal" />
<%-- 						<c:if test="${empty chatList && isNull eq true}"> --%>
<!-- 							<br> -->
<!-- 							<div style="text-align: center;"> -->
<!-- 								<div -->
<!-- 									style="display: inline-block; text-align: center; font-size: 25px; border: 2px solid #585858; border-radius: 50px; padding: 10px 30px 10px 30px;"> -->
<%-- 									${receiverUsername} 님과 대화를 시작해보세요!</div> --%>
<!-- 							</div> -->
<%-- 						</c:if> --%>
						
						<c:forEach var="list" items="${chatList}">
							<script>
								function showSavedChat() {
									var blank = "<br>";
									for (var i = 0; i < Math.floor("${list.content}".length / 17); i++) {
										blank += "<br><br>";
									}

									if ("${list.username}" == $("#senderUsername").val()) {
										$("#chatbox")
												.append(
														"<table>"
																+ "<label for=\"myMessage\" class=\"float-right\">나</label>"
																+ "<br><div class=\"d-inline-flex p-2 bg-light text-dark float-right\" id=\"myMessage\" style=\"max-width:60%\; border-radius:10px\;\">"
																+ "${list.content}" + "</div>" + blank
																+ "<div class=\"float-right\">"
																+ "${list.chatDate}"
																+ "</div></table>");
									} else {
										$("#chatbox")
												.append(
														"<table>"
																+ "<label for=\"yourMessage\" class=\"float-left\">" + "${list.username}" + "</label>"
																+ "<br><div class=\"d-inline-flex p-2 bg-secondary text-white float-left\" style=\"max-width:60%\; border-radius:10px\;\">"
																+ "${list.content}" + "</div>" + blank
																+ "<div class=\"float-left\">"
																+ "${list.chatDate}"
																+ "</div></table>");
									}
	
									var chat = document.getElementById("chatbox");
									chat.scrollTop = chat.scrollHeight;
								}
							</script>
							
							<script>
								showSavedChat()
							</script>
						</c:forEach>

					</div>
				</div>
				<br>
				<div class="form-group">
					<label for="exampleFormControlTextarea1">메시지 보내기</label>
					<textarea class="form-control" id="content" rows="2" cols="2"
						style="width: 500px; overflow-y: scroll;"
						placeholder="이곳에 메세지를 작성하세요." name="content"></textarea>
					<c:if test="${data ne null}">
						<p style="color: #E16A93">${data.message}</p>
					</c:if>
				</div>
				<button id="chatSend" class="primary" type="button">Send Chat</button>
			</div>
		</div>
	</div>
</form>
<%@ include file="IncludeBottom.jsp"%>