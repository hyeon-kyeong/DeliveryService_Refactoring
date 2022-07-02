<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>

<!-- Main -->
<div id="main">
	<div class="inner">
		<c:if
			test="${userSession.username ne null and userSession.username ne delivery.username}">
			<div style="float: right; padding-right: 10px">
				<a class=button href="/delivery/listView.do">용달 페이지로 돌아가기</a>
			</div>
			<div style="float: right; padding-right: 10px">
				<a class=button
					href="/delivery/createChatRoom.do?receiverUsername=${delivery.username}">💬
					용달 기사님께 디엠 보내기</a>
			</div>
		</c:if>
		<c:if test="${userSession.username eq delivery.username}">
			<div style="float: right; padding-right: 10px">내가 작성한 거래글입니다.</div>
		</c:if>
		<h1>Delivery Service</h1>
		<h2>🚚 용달 서비스 정보</h2>
		<c:if test="${msg ne null}">
			<p style="color: #f2849e">
				** ${msg.message} ** <br /> <a href="/delivery/copurchasingView.do"><b>공동구매
						게시판</b></a> 또는, &nbsp;<a href="/delivery/auctionView.do"><b>경매 게시판</b></a>을
				참조해주시기 바랍니다.
			</p>
		</c:if>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>Item</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>서비스 제공자</td>
						<td><a
							href="/delivery/userView.do?username=${delivery.username}">${delivery.username}</a></td>

					</tr>
					<tr>
						<td>출발지</td>
						<td>${delivery.address1 }</td>

					</tr>
					<tr>
						<td>도착지</td>
						<td>${delivery.address2 }</td>

					</tr>
					<tr>
						<td>서비스 날짜</td>
						<td>${delivery.serviceDate }</td>

					</tr>
					<tr>
						<td>가격</td>
						<td>${delivery.price }(KRW)</td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="IncludeBottom.jsp"%>

