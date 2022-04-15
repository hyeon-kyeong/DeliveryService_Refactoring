<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
		
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<h1>Update Info</h1> 
				<div class="col-sm-6 col-md-offset-3">
					<form action="/delivery/mypage.do" method="post"> 
						<div class="form-group">
							<label for="account.username" style="font-size: 24px">Username</label>
							<input
								type="text" style="width: 800px" class="form-control" name="username" value="${userSession.username}">
						</div>
						<div class="form-group row">
							<label for="firstName" class="col-lg-2 col-form-label"
								style="font-size: 24px">FirstName</label>
							<div class="col-lg-10">
								&nbsp;<input type="text" name="firstName" value="${userSession.firstName}" class="form-control"
									placeholder="길동">
							</div>
							<label for="lastName" class="col-lg-2 col-form-label"
								style="font-size: 24px">LastName</label>
							<div class="col-lg-10">
								&nbsp;<input type="text" name="lastName" value="${userSession.lastName}" class="form-control"
									placeholder="홍">
							</div>
						</div>
						<div class="form-group">
							<label for="email" style="font-size: 24px">Email</label>
							<input
								type="text" style="width: 800px" class="form-control" name="email" value="${userSession.email}" 
								placeholder="kildongHong@naver.com">
						</div>
						<div class="form-group">
							<label for="address" style="font-size: 24px">Address</label>
							<input type="text" style="width: 800px" class="form-control" name="address" value="${userSession.address}" >
		
							<!-- 도로명주소 api 활용 -->
							<input type="text" id="sample2_postcode" placeholder="우편번호">
							<input type="button" class="button small"
								onclick="sample2_execDaumPostcode()" value="우편번호 찾기"> <br>
							<input type="text" id="sample2_address" placeholder="주소"> <br>
							<input type="text" id="sample2_detailAddress" placeholder="상세주소">
							<input type="text" id="sample2_extraAddress" placeholder="참고항목">
		
							<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
							<div id="layer"
								style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
								<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
									id="btnCloseLayer"
									style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
									onclick="closeDaumPostcode()" alt="닫기 버튼">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" style="font-size: 24px">Phone Number</label> <input
								type="text" style="width: 800px" class="form-control" name="phone" value="${userSession.phone}" 
								placeholder="010-0000-0000">
						</div>
						<div class="form-group">
							<label for="favoriteUser" style="font-size: 24px">Favorite
								User</label> <input type="text" style="width: 800px" class="form-control"
								name="favoriteUser" value="${userSession.favoriteUser}" placeholder="선호하는 매장을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="languagePrefernce" style="font-size: 24px">Language
								Setting</label> <input type="text" style="width: 800px"
								class="form-control" name="languagePreference" value="${userSession.languagePreference}" 
								placeholder="Korean">
						</div>
						<div class="form-group">
							<label for="carInfo" style="font-size: 24px">Car
								Information</label> <input type="text" style="width: 800px"
								class="form-control" name="carInfo" value="${userSession.carInfo}" 
								placeholder="소유한 차량의 정보를 입력하세요."> <br> <br>
						</div>
						<div class="form-group" style="text-align:center">
							<button type="submit" id="join-submit" class="button primary">
								정보수정<i class="fa fa-check spaceLeft"></i>
							</button>
							<a class="button" href="/delivery/mypage.do">수정취소<i class="fa fa-times spaceLeft"></i></a>
								
						</div>
					</form>
				</div>
			</div>
		</div>
<%@ include file="IncludeBottom.jsp"%>