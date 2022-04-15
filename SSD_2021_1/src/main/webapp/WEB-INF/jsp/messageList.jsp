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
						style="width: 500px; height: 80px; display: table;">
						<span class="align-middle"
							style="display: table-cell; padding: 0 0 0 20px;">메시지 리스트</span>
						<a href=#menu></a>
					</div>

				</div>
				<div class="list-group" style="width: 500px;">
					<a class="list-group-item list-group-item-action active" style="bgcolor:#f2849e">현재
						채팅중인 상대</a>
					<c:if test="${DMList ne null}">
						<c:forEach var="dm" items="${DMList}">
						<c:if test="${dm ne null}">
							<a
								href="<c:url value='/delivery/messageViewContent.do'>
						   <c:param name='receiver' value='${dm}'/>
				 		 </c:url>"
								class="list-group-item list-group-item-action">${dm}</a>
								</c:if>
								
						</c:forEach>
					</c:if> 
					<a href="/delivery/messageCreate.do"
						class="button primary">새로운 메시지
						시작하기</a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="IncludeBottom.jsp"%>