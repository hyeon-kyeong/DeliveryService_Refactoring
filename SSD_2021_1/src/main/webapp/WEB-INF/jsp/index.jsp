<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Main -->
<div id="main">
	<div class="inner">
		<header>
			<h1>
				<b style="color: #f2849e">용달의 민족</b> <br /> a delivery service
				auction <br /> and co-purchasing site.<br />
			</h1>
			<p>현재 진행중인 용달 서비스 경매 및 공동구매 입니다.</p>
		</header>
		<br />
		<h3>⏳ 경매</h3>
		<section class="tiles">
			<c:forEach var="ac" items="${ACList}">
				<article class="style3">
					<span class="image"> <img src="images/pic01.jpg" alt="" />
					</span> <a
						href="<c:url value='/delivery/auctionDetailView.do'>
						   <c:param name='acId' value='${ac.auctionId}'/>
				 		 </c:url>">
						<h2>출발지: ${ac.address1 }</h2>
						<div class="content">
							<p>
								${ac.address1} > ${ac.address2 } <br /> 시작가: ${ac.startPrice}
							</p>
						</div>
					</a> <br />
					<c:choose>
						<c:when test="${ac.successfulBidder eq null}">
							<div class="col-6 col-12-medium">
						<ul class="actions">
							<li><span class="button">경매 입장가능</span></li>
						</ul>
					</div>
						</c:when>
						<c:otherwise>
							<div class="col-6 col-12-medium">
						<ul class="actions">
							<li><span class="button primary" disabled>종료된 경매</span></li>
						</ul>
					</div>
						</c:otherwise>
					</c:choose>
				</article>
			</c:forEach>
		</section>

		<br /> <br /> <br />
		<br />
		<h3>👥 공동구매</h3>
		<section class="tiles">
			<c:forEach var="cp" items="${CPList}">
				<article class="style5">
					<span class="image"> <img src="images/pic08.jpg" alt="" />
					</span> <a
						href="<c:url value='/delivery/coPurchasingDetailView.do'>
						   <c:param name='coPurchasingId' value='${cp.coPurchasingId}'/>
				 		 </c:url>">
						<h2>${cp.username}님의공동구매</h2>
						<div class="content">
							<p>1인당 가격: ${cp.unitCost }</p>
						</div>
					</a>
				</article>
			</c:forEach>
		</section>

		<br /> <br /> <br />
		<br />
		<h3>🚛 회원간 용달 거래</h3>
		<section class="tiles">
			<c:forEach var="del" items="${DelList}">
				<article class="style1">
					<span class="image"> <img src="images/pic06.jpg" alt="" />
					</span> <a
						href="<c:url value='/delivery/detailView.do'>
						   <c:param name='deliveryId' value='${del.deliveryId}'/>
				 		 </c:url>">
						<h2>출발지: ${del.address1 }</h2>
						<div class="content">
							<p>
								출발: ${del.address1 } > 도착: ${del.address2 } <br /> 가격:
								${del.price}
							</p>
						</div>
					</a> <br /> 서비스 제공일: ${del.serviceDate }
				</article>
			</c:forEach>
		</section>
		<br /> <br /> <br />
		<br />
	</div>
</div>

<%@ include file="IncludeBottom.jsp"%>
