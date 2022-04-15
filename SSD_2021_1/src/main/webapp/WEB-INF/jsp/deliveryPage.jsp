<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Main -->
<div id="main">
	<div class="inner">
		<header>
			<h1>
				🚚 용달 서비스 거래<br />
			</h1>
			<p>
				진행중인 용달 서비스 입니다. <br />
			</p>
			<a class=button href="/delivery/insert.do">용달 서비스 등록 📝</a>
			<br />
			<section class="tiles">
				<c:forEach var="del" items="${delivery}">
					<article class="style1">
						<span class="image"> <img src="/images/pic06.jpg" alt="" />
						</span> <a
							href="<c:url value='/delivery/detailView.do'>
						   <c:param name='deliveryId' value='${del.deliveryId}'/>
				 		 </c:url>">
							<h2>출발지: ${del.address1 }</h2>
							<br/>
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

		</header>
		<br /> <br /> <br />
	</div>
</div>
<%@ include file="IncludeBottom.jsp"%>