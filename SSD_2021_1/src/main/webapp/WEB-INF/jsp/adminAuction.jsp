<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTopAdmin.jsp"%>
<script>
   function deleteFuc() {
      alert("정말 삭제하시겠습니까?");
      form.submit();
   }
</script>
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<header>
					<h1>
						용달의 민족 <br /> Administrator Page <br />
					</h1>
					<p>관리자 경매 관리 페이지 입니다.</p>
				</header>
				<br />
				<div class="inner">
					<h3>* 경매 관리</h3>
				</div>
				<br />
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>Auction ID</th>
								<th>Delivery ID</th>
								<th>Service Provider</th>
								<th>Service Date</th>
								<th>Show Detail</th>
								<th>Remove</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="ac" items="${ACList}">
								<tr>
									<td>
									<c:if test="${ac.successfulBidder ne null}">
									<b style="color:red">종료된 경매, <br/> 삭제 요망</b><br/>
									</c:if>
									${ac.auctionId}</td>
									<td>
									<c:if test="${ac.flag ne 1}">
									<b style="color:red">존재하지 않는 용달 서비스 이용, <br/> 삭제 요망</b><br/>
									</c:if>
									${ac.delivery }</td>
									<td>${ac.username }</td>
									<td>${ac.serviceDate}</td>
									<td><a
										href="<c:url value='/delivery/auctionDetailView.do'>
						   <c:param name='acId' value='${ac.auctionId}'/>
				 		 </c:url>"
										class="button">&nbsp;&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
									<td><a
										href="<c:url value='/admin/auction/delete.do/${ac.auctionId}'>
<%-- 						   <c:param name='auctionId' value='${ac.auctionId}'/> --%>
				 		 </c:url>"
										class="button" onClick="deleteFuc()">&nbsp;&nbsp;&nbsp;&nbsp;Remove&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>
<%@ include file="IncludeBottom.jsp"%>