<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="IncludeTop.jsp"%>

<!-- Main -->
<div id="main">
	<div class="inner">

		<h1>경매 입찰 ✏️</h1>

		<div class="row gtr-uniform">
			<div class="col-12">
				<label for="demo-name">경매 제시자 이름</label><input type="hidden"
					name="username" id="username" value='${ac.username}' />
				<div class="col-lg-10">
					<p class="form-control-static">${ac.username}</p>
				</div>
			</div>



			<div class="col-12">
				<label for="demo-name">경매 상품</label> <input type="hidden"
					name="deliveryId" id="deliveryId" value='${delivery.deliveryId}'
					placeholder="${delivery.deliveryId}" />
				<div class="col-lg-10">
					<p class="form-control-static">${delivery.deliveryId}</p>
				</div>
			</div>

			<div class="col-12">
				<label for="demo-name">시작가</label> <input type="hidden"
					name="startPrice" id="startPrice" value='${ac.startPrice}'
					placeholder="${ac.startPrice}" />
				<div class="col-lg-10">
					<p class="form-control-static">${ac.startPrice}</p>
				</div>
			</div>

			<div class="col-12">
				<label for="demo-name">경매 종료일</label> <input type="hidden"
					name="endDate" id="endDate" value='${ac.endDate}'
					placeholder='${ac.endDate}' />
				<div class="col-lg-10">
					<p class="form-control-static">${ac.endDate}</p>
				</div>
			</div>


			<form:form modelAttribute="auctionJoinForm" method="post"
				action="/delivery/auctionJoin.do">
				<input type="hidden" name="auctionId" id="auctionId"
					value='${ac.auctionId} ' />
				<div class="col-12">
					<label for="demo-name">참여자</label><input type="hidden"
						name="username" id="username" value='${user.username}'
						placeholder="username" />
					<div class="col-lg-10">
						<p class="form-control-static">${user.username}</p>
					</div>
				</div>
				<div class="col-12">
					<label for="demo-name">입찰가</label> <input type="text"
						style="width: 800px" name="joinPrice" id="joinPrice"
						value="${ac.currentPrice}" />
					<form:errors path="joinPrice"
						style="color:#E16A93; font-size:28px;"/>
				</div>
				<br />
				<div class="col-12">
					<ul class="actions">
						<li>
							<button type="submit" id="join-submit" class="button primary">
								경매참여<i class="fa fa-check spaceLeft"></i>
							</button>
						</li>
						<li><a class="button"
							href="/delivery/auctionDetailView.do?acId=${ac.auctionId}">참여취소<i
								class="fa fa-times spaceLeft"></i></a></li>
					</ul>
				</div>

			</form:form>
		</div>

	</div>

</div>

<%@ include file="IncludeBottom.jsp"%>