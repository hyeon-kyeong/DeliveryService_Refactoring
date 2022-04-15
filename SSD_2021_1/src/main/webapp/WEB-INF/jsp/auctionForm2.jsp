<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="IncludeTop.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	function dateFormat(el) {
		//익스플로러 브라우저인 
		if ((navigator.appName == 'Netscape' && navigator.userAgent
				.search('Trident') != -1)
				|| (agent.indexOf("msie") != -1))
			el.value = el.value.replace(/(\d\d\d\d)(\d\d)(\d\d)/g, '$1-$2-$3');
	}
</script>
<!-- Main -->
<div id="main">
	<div class="inner">

		<h1>경매 글 작성 ✏️</h1>
		<form:form modelAttribute="AuctionForm" method="post"
			action="/delivery/auctionInsert2.do">
			<!-- 	
<input type="date" onkeyup="dateFormat(this)" maxlength="10">
 -->
			<div class="form-group">
				<label for="username" style="font-size: 24px">경매 게시자</label> <input
					type="hidden" style="width: 800px" class="form-control"
					name="username" value='${userSession.username}' id="username">
				<p class="form-control-static">${userSession.username}</p>
			</div>
			<div class="form-group">
				<label for="demo-name" style="font-size: 24px">경매 진행할 상품</label> <input
					type="hidden" name="deliveryId" id="deliveryId"
					value='${delivery.deliveryId}' placeholder="${delivery.deliveryId}" />
				<div class="col-lg-10">
					<p class="form-control-static">${delivery.deliveryId}</p>
				</div>
				<div class="form-group">
					<label for="auction.address1" style="font-size: 24px">출발지</label> <input
						type="hidden" style="width: 800px" class="form-control"
						name="address1" placeholder="${delivery.address1 }" id="address1"
						value='${delivery.address1}'>
					<p class="form-control-static">${delivery.address1}</p>
				</div>
				<div class="form-group">
					<label for="auction.address2" style="font-size: 24px">도착지</label> <input
						type="hidden" style="width: 800px" class="form-control"
						name="address2" placeholder="${delivery.address2 }" id="address2"
						value='${delivery.address2 }'>
					<p class="form-control-static">${delivery.address2}</p>
				</div>

				<div class="form-group">
					<label for="auction.startPrice" style="font-size: 24px">용달
						서비스 제공일</label> <input type="hidden" style="width: 800px"
						class="form-control" name="serviceDate"
						placeholder="${delivery.serviceDate }" id="serviceDate"
						value='${delivery.serviceDate }'>
					<p class="form-control-static">${delivery.serviceDate}</p>
				</div>
				<div class="form-group">
					<label for="auction.startPrice" style="font-size: 24px">경매
						시작가</label> <input type="text" style="width: 800px" class="form-control"
						name="startPrice" value="${delivery.price}" id="startPrice">
					<form:errors path="startPrice"
						style="color:#E16A93; font-size:28px;" />
				</div>

				<div class="form-group">
					<label for="auction.endDate" style="font-size: 24px">경매 마감일
						(ex. 2021-01-01 00:00)</label> <input type="text" style="width: 800px"
						class="form-control" name="endDate" value="${currentDate}">
					<form:errors path="endDate" style="color:#E16A93; font-size:28px;" />
				</div>


				<div class="col-12">
					<ul class="actions">
						<li>
							<button type="submit" class="button primary">
								경매 등록<i class="fa fa-check spaceLeft"></i>
							</button>
						</li>
						<li><a class="button" href="/delivery/auctionInsert.do">등록취소<i
								class="fa fa-times spaceLeft"></i>
						</a></li>
					</ul>
				</div>

			</div>

		</form:form>

	</div>

</div>

<%@ include file="IncludeBottom.jsp"%>