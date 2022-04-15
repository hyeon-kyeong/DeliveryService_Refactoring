<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>

<!-- Main -->
<div id="main">
	<div class="inner">

		<h1>공동구매 참여 성공!️</h1>
		
		<a href="/delivery/coPurchasingDetailView.do?coPurchasingId=${cp.coPurchasingId }">공동구매 페이지로 돌아가기 </a>

		<h2>차량 정보</h2>
		<table>
			<thead>
				<tr>
					<th>Item</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>ServiceDate</td>
					<td>${del.serviceDate }</td>

				</tr>
				<tr>
					<td>Poster</td>
					<td><a href="/delivery/userView.do?username=${cp.username}">${cp.username}</a></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td>${del.address2 }</td>

				</tr>
				<tr>
					<td>Price</td>
					<td>${del.price } (KRW)&nbsp;(인당 ${cp.unitCost }(KRW))</td>
				</tr>
				<tr>
					<td>MaxNumberOfPurchaser</td>
					<td>${cp.maxNumberOfPurchaser }</td>

				</tr>
				<tr>
					<td>Width</td>
					<td>${del.width}m</td>

				</tr>
				<tr>
					<td>Height</td>
					<td>${del.height }m</td>

				</tr>
				<tr>
					<td>Weight</td>
					<td>${del.weight }kg</td>
 
				</tr>
			</tbody>
		</table>
	
		※ ${cp.unitCost}원을 미리 준비해주세요! <br>
		※ 인원 수 미달시 취소되거나 인당 지불할 금액이 인상될 수 있습니다.<br>
		<br>
		<a href="/delivery/messageCreate2.do?receiverUsername=${cp.username}">💬 공동구매 개최자에게 디엠 보내기</a><br>
		<a href="/delivery/messageCreate2.do?receiverUsername=${del.username}">💬 용달 기사님께 디엠 보내기</a>

	</div>

</div>

<%@ include file="IncludeBottom.jsp"%>