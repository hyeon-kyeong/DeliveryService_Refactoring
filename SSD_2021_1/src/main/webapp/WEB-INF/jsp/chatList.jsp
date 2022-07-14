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
		<div id="main">
			<div class="inner">
				<h1>📬 Message List</h1>
				<div style="width: 500px;">
					<div class="bg-dark text-white "
						style="width: 500px; height: 80px; display: table; border-radius: 5px;">
						<span class="align-middle"
							style="display: table-cell; padding: 0 0 0 20px;">메시지 리스트</span>
						<a href=#menu></a>
					</div>

				</div>
				<div class="list-group" style="width: 500px;">
					<c:if test="${map ne null}">
						<c:forEach var="m" items="${map}">
							<a href="<c:url value='/delivery/chat.do/${m.value}'>
						   <c:param name='receiverUsername' value='${m.key}'/>
						   <c:param name='roomId' value='${m.value}'/>
				 		 </c:url>"
								class="list-group-item list-group-item-action">${m.key}</a>
						</c:forEach>
					</c:if>
					<c:if test="${empty map}">
						<span class="align-middle"
							style="padding:40px; font-size: 22px; text-align: center; border: 1px solid #585858; border-radius: 5px;">
							현재 진행중인 채팅이 없습니다.</span>
					</c:if>
					<!-- 					<a href="/delivery/messageCreate.do" -->
					<!-- 						class="button primary">새로운 메시지 -->
					<!-- 						시작하기</a> -->
				</div>
			</div>
		</div>
	</div>
	<%@ include file="IncludeBottom.jsp"%>