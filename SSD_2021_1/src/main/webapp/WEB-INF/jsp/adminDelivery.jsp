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
					<p>관리자 회원간 용달 거래 관리 페이지 입니다.</p>
				</header>
				<br />
				<div class="inner">
					<h3>
						<span class="title">* 회원간 용달 거래 관리</span>
					</h3>
				</div><br />
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>Delivery ID</th>
								<th>Service Provider</th>
								<th>Service Date</th>
								<th>Show Detail</th>
								<th>Remove</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="del" items="${DelList}">
								<tr>
									<td>${del.deliveryId}</td>
									<td>${del.username }</td>
									<td>${del.serviceDate}</td>
									<td><a
										href="<c:url value='/delivery/detailView.do'>
						   <c:param name='deliveryId' value='${del.deliveryId}'/>
				 		 </c:url>"
										class="button">&nbsp;&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
									<td><a
										href="<c:url value='/admin/delivery/delete.do'>
						   <c:param name='delId' value='${del.deliveryId}'/>
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