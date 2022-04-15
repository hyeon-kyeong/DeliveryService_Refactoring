<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>
			<b style="color: #f2849e">${user.username}</b>님의 마이페이지
		</h1>
		<div>
			<h3>📰 회원정보</h3>
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
							<td>${user.username}</td>
						</tr>
						<tr>
							<td>email</td>
							<td>${user.email}</td>
						</tr>
						<tr>
							<td>firstName</td>
							<td>${user.firstName}</td>
						</tr>
						<tr>
							<td>lastName</td>
							<td>${user.lastName}</td>
						</tr>
						<tr>
							<td>address</td>
							<td>${user.address}</td>
						</tr>
						<tr>
							<td>phone</td>
							<td>${user.phone}</td>

						</tr>
						<tr>
							<td>carInfo</td>
							<td>${user.carInfo}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<a class="button" href="/delivery/updateAccount.do">정보수정</a><br>
			<br>
		</div>
		<br />
		<div>
			<h3>
				<b style="color: #f2849e">*</b> 즐겨찾기
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>즐겨찾기한 회원</th>
							<th>거래 횟수</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="fav" items="${favList}">
							<tr>
								<td>${fav.favoriteUsername}</td>
								<td>${fav.tradeCount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h3>
				<b style="color: #f2849e">*</b> 참여한 공동구매 내역
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>공동구매 ID</th>
							<th>공동구매 부가정보</th>
							<th>1인당 가격</th>
							<th>총금액</th>
							<th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cp" items="${CPList}">
							<tr>
								<td><a
					href="<c:url value='/delivery/coPurchasingDetailView.do'>
						   <c:param name='coPurchasingId' value='${cp.coPurchasingId}'/>
				 		 </c:url>">
				 		 ${cp.coPurchasingId}</a></td>
								<td>${cp.note}</td>
								<td>${cp.unitCost}원</td>
								<td>${cp.price}원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<br />
			<h3>
				<b style="color: #f2849e">*</b> 회원간 거래 글
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>용달 서비스 ID</th>
							<th>서비스 일자</th>
							<th>서비스 요금</th>

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
								<td>${del.price}원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<br />
		<div>
			<h3>
				<b style="color: #f2849e">*</b> 참여한 경매 내역
			</h3>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>경매 ID</th>
							<th>경매 시작가</th>
							<th>경매 종료시각</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ac" items="${ACList}">
							<tr>
								<td><a
									href="<c:url value='/delivery/auctionDetailView.do'>
						   <c:param name='acId' value='${ac.auctionId}'/>
				 		 </c:url>">${ac.auctionId}</a></td>
								<td>${ac.startPrice}원</td>
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
