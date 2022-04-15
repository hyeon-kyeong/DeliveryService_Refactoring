<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>

<style>
.chatbox {
	padding: 10px 0;
	width: 100%;
}
</style>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<h1>💬 Send Message</h1>
				<form action="/delivery/messageSend2.do" method="POST">
					<div style="width: 500px;">
						<div class="bg-dark text-white "
							style="width:500px; height: 80px; display: table;">
							<span class="align-middle"
								style="display: table-cell; padding: 0 0 0 20px;">받는사람</span> <select
								id="receiverSelect" name="receiverUsername" class="form-control">
								<c:forEach var="receivers" items="${receiversList}"
									varStatus="status">
									<option value="${receivers.username}">${receivers.username}(
										${receivers.firstName} ${receivers.lastName } )</option>
								</c:forEach>
							</select>

							<!-- <a href="message_list.jsp">DM리스트</a> -->
							<a href="/delivery/message.do" class="button text-white"
								style="display: table-cell; padding: 20px;">DM리스트</a>
						</div>

						<br>
						<div class="form-group">
							<label for="exampleFormControlTextarea1">메시지 보내기</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" style="width: 500px;" placeholder="이곳에 메세지를 작성하세요."
								name="content"></textarea>
							<c:if test="${data ne null}">
								<p style="color: #E16A93">${data.message}</p>
							</c:if>
						</div>
						<input type="submit" value="Send Message" class="primary" />
					</div>
				</form>

			</div>
		</div>
	</div>
	<%@ include file="IncludeBottom.jsp"%>