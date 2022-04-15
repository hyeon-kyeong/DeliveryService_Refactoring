<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>

<!-- Main -->
<div id="main">
	<div class="inner">

		<h1>공동구매 글 작성 ✏️</h1>
		<div class="col-12">
			<label for="demo-name">공동구매할 상품 선택</label>
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
									href="<c:url value='/delivery/coPurchasingInsert.do'>
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