<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>Co-Purchasing 👥</h1>
		<section>
			<h1 style="font-size: 40px">공동구매 상세내역</h1>
			<div style="float: right; padding-right: 30px">
			<a href="/delivery/copurchasingView.do" class="button">공동구매 페이지로 돌아가기 </a>
			</div>
			<h1 style="font-size: 30px">
				📢 &nbsp;게시자 says &nbsp;&nbsp;<b style="color: #f2849e">" 
					&nbsp;${cp.note } &nbsp;"</b>
			</h1>
			<h3>* 공동구매 ID : ${cp.coPurchasingId}</h3>
			<div class="table-wrapper">
				<table>
					<thead>
						<tr>
							<th>Item</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>서비스 일시</td>
							<td>${del.serviceDate }</td>

						</tr>
						<tr>
							<td>공동구매 게시자</td>
							<td><a href="/delivery/userView.do?username=${cp.username}">${cp.username}</a></td>
						</tr>
						<tr>
							<td>도착지</td>
							<td>${del.address2 }</td>

						</tr>
						<tr>
							<td>가격</td>
							<td>${del.price } (KRW) (인당${cp.unitCost } (KRW))</td>
						</tr>
						<tr>
							<td>모집인원</td>
							<td>${cp.maxNumberOfPurchaser } 명</td>

						</tr>
						<tr>
							<td>가로 규격</td>
							<td>${del.width} cm</td>

						</tr>
						<tr>
							<td>세로 규격</td>
							<td>${del.height } cm</td>

						</tr>
						<tr>
							<td>총 무게</td>
							<td>${del.weight } g</td>

						</tr>
					</tbody>
				</table>
			</div>
			<br>

			<c:if test="${userSession.username ne null}">
				<div style="float: right; padding-right: 5px">

					<c:if test="${status eq 'open' and status2 eq 'notparticipant'}">
						<a
							href="/delivery/coPurchasingJoin.do?coPurchasingId=${cp.coPurchasingId}"
							class="button primary">&nbsp;&nbsp;&nbsp;&nbsp;공동구매
							참여🤚🏻&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</c:if>

					<c:if test="${status eq 'closed' }">
						<button disabled>&nbsp;&nbsp;&nbsp;&nbsp;공동구매
							종료&nbsp;&nbsp;&nbsp;&nbsp;</button>

					</c:if>
					<c:if test="${ status eq 'open' and status2 eq 'poster'}">
						공동구매 주최자입니다! 이미 참여되었습니다. <br>


					</c:if>

					<c:if test="${ status eq 'open' and status2 eq 'participant'}">
							이미 참여하셨습니다!
						</c:if>


				</div>
			</c:if>
			<h1 style="font-size: 35px">
				<b style="color: #f2849e">*&nbsp;</b> Progress of Co-Purchasing
			</h1>
			<p>공동구매 진행상황을 보여줍니다.</p>
			<div class="progress">
				<div
					class="progress-bar progress-bar-warning progress-bar-striped active"
					role="progressbar" aria-valuenow='${fn:length(cplineitem) }'
					aria-valuemin="0" aria-valuemax='${ cp.maxNumberOfPurchaser }'
					style="width: ${fn:length(cplineitem)/cp.maxNumberOfPurchaser*100}%; ">
					<c:if test="${status eq 'closed'}">
					공동구매 달성 완료!

					</c:if>
					<c:if test="${status eq 'open'}">
					${fn:length(cplineitem) }명
					참여중!
					</c:if>

				</div>
			</div>


			<br> <br>
			<!-- 참여자 정보 -->
			<h1 style="font-size: 35px">
				<b style="color: #f2849e">*&nbsp;</b> 참여자 정보
			</h1>
			<div class="table-wrapper">
				<table class="alt">
					<thead>
						<tr>
							<th>No</th>
							<th>UserName</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="cplineitem" items="${cplineitem}" varStatus="st">
							<tr>
								<td>${st.index+1}</td>
								<td>${cplineitem.username}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</section>
	</div>
</div>
<%@ include file="IncludeBottom.jsp"%>