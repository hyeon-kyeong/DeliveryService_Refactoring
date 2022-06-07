<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<!DOCTYPE HTML>
<html>
<head>
<title>용달의 민족</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="/assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="inner">

				<!-- Logo -->
				<a href="/" class="logo"> <span class="symbol"><img
						src="/images/logoicon.svg" alt="" /></span><span class="title">용달의
						민족</span>
				</a>
				<!-- Nav -->
				<nav>
					<ul>
						<li><a href="#menu">Menu</a></li>
					</ul>
				</nav>

			</div>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<h2>Menu</h2>
			<ul>
				<li><a href="/"><b>메인</b></a></li>
				<c:choose>
					<c:when test="${userSession.username ne null}">
						<li><a href="/delivery/signoff.do">🔓
								${userSession.username} 로그아웃 </a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/delivery/signon.do">🔐 로그인</a></li>
						<li><a href="/delivery/insertAccount.do">📋 회원가입</a></li>
					</c:otherwise>
				</c:choose>

				<li><a href="/delivery/auctionView.do">⏱ 경매</a></li>
				<li><a href="/delivery/copurchasingView.do">👥 공동구매</a></li>
				<li><a href="/delivery/listView.do">🚘 1:1 용달 거래</a></li>
				<c:if test="${userSession.username ne null}">

					<li class="nav-item"><li><a
						href="/delivery/mypage.do?username=${userSession.username}">📰 마이페이지</a></li>
					<li><a href="/delivery/message.do">📬 DM</a></li>
					
				</c:if>
				<c:if test="${userSession.status eq 0}">
				<li class="nav-item">
					<li><a href="/delivery/adminMain.do">**관리자 페이지**</a></li>
				</c:if>
			</ul>
		</nav>
	<%@ page language="java"
							contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

		
					</div>
		<!-- Scripts -->
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/browser.min.js"></script>
		<script src="assets/js/breakpoints.min.js"></script>
		<script src="assets/js/util.js"></script>
		<script src="assets/js/main.js"></script>

		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
		<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>