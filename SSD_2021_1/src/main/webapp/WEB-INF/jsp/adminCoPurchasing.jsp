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
					<p>관리자 공동구매 관리 페이지 입니다.</p>
				</header>
				<br />
				<div class="inner">
					<h3>* 공동구매 관리</h3>
					<br />
				</div>
				<div class="table-wrapper">
					<table class="alt">
						<thead>
							<tr>
								<th>CoPurchasing ID</th>
								<th>Delivery Id</th>
								<th>CoPurchasing Promoter</th>
								<th>Show Detail</th>
								<th>Remove</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="cp" items="${CPList}">
								<tr>
									<td>
									${cp.coPurchasingId}</td>
									<td>
									<c:if test="${cp.flag ne 1}">
									<b style="color:red">존재하지 않는 용달 서비스 이용, <br/> 삭제 요망</b><br/>
									</c:if>
									${cp.delivery }
								
									</td>
									<td>${cp.username}</td>
									<td><a
										href="<c:url value='/delivery/coPurchasingDetailView.do?coPurchasingId='>
						   <c:param name='coPurchasingId' value='${cp.coPurchasingId}'/>
				 		 </c:url>"
										class="button">&nbsp;&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
									<td><a
										href="<c:url value='/admin/coPurchasing/delete.do'>
						   <c:param name='cpId' value='${cp.coPurchasingId}'/>
				 		 </c:url>"
										class="button" onClick="deleteFuc()">&nbsp;&nbsp;&nbsp;&nbsp;Remove&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
								</tr>
								</c:forEach>
							
						</tbody>
					</table>
				</div>
				<br /> <br /> <br />
			</div>
		</div>
<%@ include file="IncludeBottom.jsp"%>