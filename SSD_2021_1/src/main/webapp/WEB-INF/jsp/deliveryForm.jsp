<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="IncludeTop.jsp"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>용달 서비스 등록하기 ✏️</h1>
		<form:form modelAttribute="deliveryForm" method="post"
			action="/delivery/insert.do">
			<div class="col-sm-6 col-md-offset-3">
				<div class="col-12">
					<label for="address1">아이디</label> <input type="hidden"
						name="username" id="username" value="${userSession.username}"
						placeholder="${userSession.username}" />
						<p class="form-control-static">${userSession.username}</p> 
				</div>

				<div class="col-12">
					<label for="address1">출발지</label> <input type="text"
						name="address1" id="address1" value="${delivery.address1}"
						placeholder="출발가능 지역을 작성해주세요." />
					<form:errors path="address1" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="col-12">
					<label for="address2">도착지</label> <input type="text"
						name="address2" id="address2" value="${delivery.address2}"
						placeholder="도착 가능 지역을 작성해주세요." />
					<form:errors path="address2" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="col-12">
					<label for="serviceDate">서비스 제공일</label> <input type="text"
						name="serviceDate" id="serviceDate" value="${delivery.serviceDate}"
						placeholder="2022/01/01" />
					<form:errors path="serviceDate" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="col-12">
					<label for="price">가격 (KRW) </label> <input type="text"
						name="price" id="price" value="50000" />
				</div>
				<br>
				<div class="col-6">
					<label for="size">차량 재적 정보</label>
				</div>
				<div class="col-6">
					<label for="size">가로 (cm)</label> <input type="text" name="width"
						id="width" value="100" />
				</div>
				<div class="col-6">
					<label for="size">세로 (cm)</label> <input type="text" name="depth"
						id="depth" value="100" />
				</div> 
				<div class="col-6">
					<label for="size">높이 (cm)</label> <input type="text" name="height"
						id="height" value="100" />
				</div>
				<div class="col-6">
					<label for="size">개당 최대 무게 (g)</label> <input type="text" name="weight"
						id="weight" value="1000" />
				</div>
				<div class="col-6">
					<label for="size">총 적재량 (g)</label> <input type="text"
						name="loadage" id="loadage" value="1000" />
				</div>
				<br> <br>
				<div class="col-12">
					<ul class="actions">
						<li>
							<button type="submit" id="submit" class="button primary">
								서비스 등록<i class="fa fa-check spaceLeft"></i>
							</button>
						</li>
						<li><a class="button" href="/delivery/listView.do">&nbsp;등록
								취소&nbsp;<i class="fa fa-times spaceLeft"></i>
						</a></li>
					</ul>
				</div>
			</div>
		</form:form>
	</div>
</div>

<%@ include file="IncludeBottom.jsp"%>