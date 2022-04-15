<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<!-- Main -->
<div id="main">
	<div class="inner">

			<h2>경매 글 작성</h2>
 
			<div class="col-12">
				<label for="demo-name">경매 진행할 상품 선택</label>
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>Name</th>
								<th>Date</th>
								<th>Start</th>
								<th>Destination</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="del" items="${delList}">
								<tr>
									<td><a
										href="<c:url value='/delivery/auctionInsert2.do'>
						   <c:param name='deliveryId' value='${del.deliveryId}'/>
				 		 </c:url>">${del.deliveryId}</a></td>
									<td>${del.serviceDate}</td>
									<td>${del.address1}</td>
									<td>${del.address2}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<br /> <br /> <br />
			</div>
	</div>
</div>

	<%@ include file="IncludeBottom.jsp"%>