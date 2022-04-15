<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<!DOCTYPE HTML>
<html>
<head>
<title>용달의 민족 - 관리자</title>
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
<body class="p-3 mb-2 bg-dark text-white">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<div class="inner">

				<!-- Logo -->
				<a href="/delivery/adminMain.do" class="logo"> <span class="symbol"><img
						src="/images/logoicon.svg" alt="" /></span><span class="title">용달의
						민족 관리자 페이지</span>
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
			<li><a href="/delivery/adminMain.do"><b>관리자 메인</b></a></li>
			<li><a href="/">사용자 페이지로</a></li>
				<c:if test="${userSession.username ne null}">
						<li><a href="/delivery/signoff.do">🔓 ${userSession.username} 로그아웃
						</a></li>
				</c:if>
				<li><a href="/delivery/adminUser.do">📋 회원 관리</a></li>
				<li><a href="/delivery/adminAuction.do">⏱ 경매 관리</a></li>
				<li><a href="/delivery/adminCoPurchasing.do">👥 공동구매 관리</a></li>
				<li><a href="/delivery/adminDelivery.do">🚘 1:1 용달 거래 관리</a></li>
			</ul>
		</nav>