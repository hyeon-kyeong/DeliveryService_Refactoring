<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="IncludeTop.jsp"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/rsa/rsa.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/rsa/jsbn.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/rsa/prng4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/rsa/rng.js"></script>

<script type="text/javascript">
	function frmCheck() {
		var un = $("#username").val();
		var pwd = $("#password").val();

		//RSA 암호화
		var rsa = new RSAKey();
		rsa.setPublic($('#RSAModulus').val(), $('#RSAExponent').val());

		$("#USERNAME").val(rsa.encrypt(un));
		$("#PASSWORD").val(rsa.encrypt(pwd));

		username.val("");
		password.val("");

	}
</script>

<!-- Main -->
<div id="main">
	<div style="float: right; padding-right: 100px">
		<a href="/delivery/adminSignon.do" class="button primary">&nbsp;&nbsp;&nbsp;&nbsp;Admin&nbsp;&nbsp;&nbsp;&nbsp;</a>
	</div>
	<div class="inner">
		<h1>🔐 Login</h1>
		<form name="loginform" action="/delivery/signon.do" method="POST" onsubmit="return frmCheck();">
			<c:if test="${data ne null}">
				<p style="color: red">${data.message}</p>
			</c:if>

				  <input type="hidden" id="RSAModulus" value="${RSAModulus}">
                  <input type="hidden" id="RSAExponent" value="${RSAExponent}">
                  <input type="hidden" id="USERNAME" name="USERNAME">
                  <input type="hidden" id="PASSWORD" name="PASSWORD">
			<label for="username" class="visually-hidden" style="font-size: 24px">UserName</label>
			<input type="text" style="width: 420px" id="username" name="username"
				placeholder="Username" required autofocus>
			<p />
			<p />
			<label for="password" class="visually-hidden" style="font-size: 24px">Password</label>
			<input type="password" style="width: 420px" id="password"
				name="password" placeholder="Password" required autofocus>
			<ul class="actions">
				<li><button type="submit">&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;</button></li>
				<li><a href="/delivery/insertAccount.do" class="button">&nbsp;&nbsp;Register&nbsp;&nbsp;</a></li>
			</ul>
		</form>
	</div>

</div>
<%@ include file="IncludeBottom.jsp"%>