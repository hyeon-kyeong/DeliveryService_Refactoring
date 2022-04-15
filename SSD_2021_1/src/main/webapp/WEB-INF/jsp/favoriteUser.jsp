<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>${user.username}님의즐겨찾기</h1>
		<form method="post" action="/user/favoriteUser.do">
			<div class="form-group">
				<input type="text" class="form-control" name="username"
					value='${user.username}' id="username">
			</div>
			<div class="form-group">
				<input type="text" style="width: 800px" class="form-control"
					name="favoriteUsername" value='${favUser.username}' >
			</div>
			<div class="form-group">
				<input type="text" style="width: 800px" class="form-control"
					name="tradeCount" value="0"
					id="tradeCount">
			</div>

			<div class="form-group text-center">
				<button type="submit" class="button primary">
					즐겨찾기 등록<i class="fa fa-check spaceLeft"></i>
				</button>
			</div>
		</form>

	</div>
</div>

<%@ include file="IncludeBottom.jsp"%>
