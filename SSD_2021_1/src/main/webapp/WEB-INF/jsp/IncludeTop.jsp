<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
						<li><a href="/delivery/signoff.do">🔓 ${userSession.username} 로그아웃
						</a></li>
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

					<li class="nav-item"><li><a href="/delivery/mypage.do?username=${userSession.username}">📰 마이페이지</a></li>
					<li><a href="/delivery/message.do">📬 DM</a></li>
					<li><a href="/delivery/chatList.do">chatListTest</a></li>
					<li><a href="/delivery/chat.do">chatting test</a></li>
					
				</c:if>
				<c:if test="${userSession.status eq 0}">
				<li class="nav-item"><li><a href="/delivery/adminMain.do">**관리자 페이지**</a></li>
				</c:if>
			</ul>
		</nav>