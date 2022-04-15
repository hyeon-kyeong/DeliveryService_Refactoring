<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>
		<!-- Main -->
		<div id="main">
			<div style="float:right; padding-right:100px">
				<a href="/delivery/adminSignon.do" class="button primary">&nbsp;&nbsp;&nbsp;&nbsp;Admin&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</div>
			<div class="inner">
			<c:if test="${msg ne null}">
			<p style="color:#f2849e">🚩&nbsp;&nbsp;&nbsp; ${msg.message }</p>
			</c:if>
				<h1>🔐 Login</h1>
				<form action="/delivery/signon.do" method="POST">
				<c:if test="${data ne null}"> 
					<p style="color: red">${data.message}</p>
				 </c:if>
				<label for="username" class="visually-hidden" style="font-size:24px">Username</label>
				<input type="text" style="width:420px" id="username" name="username" placeholder="Username" required autofocus>
				<p/><p/>
				<label for="password" class="visually-hidden" style="font-size:24px">Password</label>
				<input type="password" style="width:420px" id="password" name="password" placeholder="Password" required>
				
				<ul class="actions">
					<li><button type="submit" >&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;</button></li>
					<li><a href="/delivery/insertAccount.do" class="button">&nbsp;&nbsp;Register&nbsp;&nbsp;</a></li>
				</ul></form>
			</div>
		
		</div>
<%@ include file="IncludeBottom.jsp"%>