<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTopAdmin.jsp"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<header>
			<h1>
				용달의 민족 <br /> Administrator Page <br />
			</h1>
			<p>관리자 회원 관리 페이지 입니다.</p>
		</header>
		<br />
		<div class="inner">
			<h3>* 회원 관리</h3>
		</div>
		<br />
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>Username</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Detail</th>
						<th>Remove</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${UserList}">
						<tr>
							<td>${user.username}
							<c:if test="${user.status eq 0}">
							🥇
							</c:if>
							</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td><a
								href="<c:url value='/delivery/mypage.do'>
						   <c:param name='username' value="${user.username}"/>
				 		 </c:url>"
								class="button">&nbsp;&nbsp;&nbsp;&nbsp;Detail&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
							<td><a
								href="<c:url value='/admin/user/delete.do'>
						   <c:param name='username' value="${user.username}"/>
				 		 </c:url>"
								class="button">&nbsp;&nbsp;&nbsp;&nbsp;Remove&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</div>

<%@ include file="IncludeBottom.jsp"%>