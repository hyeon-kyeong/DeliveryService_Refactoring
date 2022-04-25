<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>
			<b style="color: #f2849e"> ${favUser.username}</b>님 Profile
		</h1>
		<form method="post" action="/delivery/favoriteUser.do">
			<div class="form-group">
				<input type="hidden" class="form-control" name="username"
					value='${user.username}' id="username">
			</div>
			<div class="form-group">
				<input type="hidden" style="width: 800px" class="form-control"
					name="favoriteUsername" value='${favUser.username}'>
			</div>
			<div class="form-group">
				<input type="hidden" style="width: 800px" class="form-control"
					name="tradeCount" value="0" id="tradeCount">
			</div>
			<c:if test="${m ne null}"> 
				<p>
					<b>※ ${m.message }</b>
				</p>
			</c:if>
			<c:if test="${favUser.username ne userSession.username && m eq null}">
				<div class="form-group text-center">
					<button type="submit" class="button primary">
						즐겨찾기 등록<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>

			</c:if>
		</form>
		<div>
			<h3>📝 회원정보</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>username</td>
							<td>${favUser.username}</td>
						</tr>
						<tr>
							<td>email</td>
							<td>${favUser.email}</td>
						</tr>
						<tr>
							<td>firstName</td>
							<td>${favUser.firstName}</td>
						</tr>
						<tr>
							<td>lastName</td>
							<td>${favUser.lastName}</td>
						</tr>
						<tr>
							<td>carInfo</td>
							<td>${favUser.carInfo}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h3>
				* ${favUser.username}님이 참여한 <b style="color: #f2849e"> 공동구매 내역</b>
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="cp" items="${CPList}">
							<tr>
								<td><a
									href="<c:url value='/coPurchasing/detailView.do'>
						   <c:param name='cpId' value='${cp.coPurchasingId}'/>
				 		 </c:url>">${cp.coPurchasingId}</a></td>
								<td>${cp.username}</td>
								<td>${cp.note}</td>
								<td>${cp.unitCost}</td>
								<td>${cp.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h3>
				* ${favUser.username}님의 <b style="color: #f2849e"> 회원간 거래 글</b>
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="del" items="${DelList}">
							<tr>
								<td><a
									href="<c:url value='/delivery/detailView.do'>
						   <c:param name='deliveryId' value='${del.deliveryId}'/>
				 		 </c:url>">${del.deliveryId}</a></td>
								<td>${del.serviceDate}</td>
								<td>${del.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h3>
				* ${favUser.username}님이 참여한 <b style="color: #f2849e">경매 내역</b>
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="ac" items="${ACList}">
							<tr>
								<td><a
									href="<c:url value='/delivery/auctionDetailView.do'>
						   <c:param name='acId' value='${ac.auctionId}'/>
				 		 </c:url>">${ac.auctionId}</a></td>
								<td>${ac.username}</td>
								<td>${ac.startPrice}</td>
								<td>${ac.endDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<%@ include file="IncludeBottom.jsp"%>
