<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="IncludeTop.jsp"%>
<!-- Main -->
<div id="main">
	<div class="inner">
		<h1>📋 Register Page</h1>
		<div class="col-sm-6 col-md-offset-3">
			<form:form modelAttribute="accountForm"
				action="/delivery/newUserSubmitted.do" method="post">
				<div class="form-group"> 
					<label for="account.username" style="font-size: 24px">Username</label>
					<input type="text" style="width: 800px" class="form-control"
						name="username" value="${userSession.username}"
						placeholder="로그인 시 사용할 이름을 입력해 주세요.">
					<form:errors path="username" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="form-group">
					<label for="password1" style="font-size: 24px">Password</label> <input
						type="password" style="width: 800px" class="form-control"
						name="password" value="${userSession.password}"
						placeholder="비밀번호를 입력해 주세요.">
					<form:errors path="password" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="form-group">
					<label for="password2" style="font-size: 24px">Password
						Check</label> <input type="password" style="width: 800px"
						class="form-control" name="password2" placeholder="비밀번호를 입력해 주세요.">
					<form:errors path="password2" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="form-group row">
					<label for="firstName" class="col-lg-2 col-form-label"
						style="font-size: 24px">FirstName</label>
					<div class="col-lg-10">
						&nbsp;<input type="text" name="firstName"
							value="${userSession.firstName}" class="form-control"
							placeholder="길동">
						<form:errors path="firstName"
							style="color:#E16A93; font-size:28px;" />
					</div>
					<label for="lastName" class="col-lg-2 col-form-label"
						style="font-size: 24px">LastName</label>
					<div class="col-lg-10">
						&nbsp;<input type="text" name="lastName"
							value="${userSession.lastName}" class="form-control"
							placeholder="홍">
						<form:errors path="lastName"
							style="color:#E16A93; font-size:28px;" />
					</div>
				</div>
				<div class="form-group">
					<label for="email" style="font-size: 24px">Email</label> <input
						type="text" style="width: 800px" class="form-control" name="email"
						value="${userSession.email}" placeholder="kildongHong@naver.com">
					<form:errors path="email" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="form-group">
					<label for="address" style="font-size: 24px">Address</label> <input
						type="hidden" style="width: 800px" class="form-control"
						name="address" value="${userSession.address}">
					
					<!-- 도로명주소 api 활용 -->
					<input type="text" id="sample2_postcode" name="postcode"
						placeholder="우편번호"> <input type="button"
						class="button small" onclick="sample2_execDaumPostcode()"
						value="우편번호 찾기" name="postcode"> <br> <input
						type="text" id="sample2_address" placeholder="주소" name="address2">
						<form:errors path="address2" style="color:#E16A93; font-size:28px;" />
					<br> <input type="text" id="sample2_detailAddress"
						placeholder="상세주소" name="detailAddress"> <input
						type="text" id="sample2_extraAddress" placeholder="(동)"
						name="extraAddress">
					
					<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
					<div id="layer"
						style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
						<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
							id="btnCloseLayer"
							style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
							onclick="closeDaumPostcode()" alt="닫기 버튼">
					</div>
				</div>
				<script
					src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
					
				</script>
				<script>
					// 우편번호 찾기 화면을 넣을 element
					var element_layer = document.getElementById('layer');

					function closeDaumPostcode() {
						// iframe을 넣은 element를 안보이게 한다.
						element_layer.style.display = 'none';
					}

					function sample2_execDaumPostcode() {
						new daum.Postcode(
								{
									oncomplete : function(data) {
										// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

										// 각 주소의 노출 규칙에 따라 주소를 조합한다.
										// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
										var addr = ''; // 주소 변수
										var extraAddr = ''; // 참고항목 변수

										//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
										if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
											addr = data.roadAddress;
										} else { // 사용자가 지번 주소를 선택했을 경우(J)
											addr = data.jibunAddress;
										}

										// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
										if (data.userSelectedType === 'R') {
											// 법정동명이 있을 경우 추가한다. (법정리는 제외)
											// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
											if (data.bname !== ''
													&& /[동|로|가]$/g
															.test(data.bname)) {
												extraAddr += data.bname;
											}
											// 건물명이 있고, 공동주택일 경우 추가한다.
											if (data.buildingName !== ''
													&& data.apartment === 'Y') {
												extraAddr += (extraAddr !== '' ? ', '
														+ data.buildingName
														: data.buildingName);
											}
											// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
											if (extraAddr !== '') {
												extraAddr = ' (' + extraAddr
														+ ')';
											}
											// 조합된 참고항목을 해당 필드에 넣는다.
											document
													.getElementById("sample2_extraAddress").value = extraAddr;

										} else {
											document
													.getElementById("sample2_extraAddress").value = '';
										}

										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										document
												.getElementById('sample2_postcode').value = data.zonecode;
										document
												.getElementById("sample2_address").value = addr;
										// 커서를 상세주소 필드로 이동한다.
										document.getElementById(
												"sample2_detailAddress")
												.focus();

										// iframe을 넣은 element를 안보이게 한다.
										// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
										element_layer.style.display = 'none';
									},
									width : '100%',
									height : '100%',
									maxSuggestItems : 5
								}).embed(element_layer);

						// iframe을 넣은 element를 보이게 한다.
						element_layer.style.display = 'block';

						// iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
						initLayerPosition();
					}

					// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
					// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
					// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
					function initLayerPosition() {
						var width = 300; //우편번호서비스가 들어갈 element의 width
						var height = 400; //우편번호서비스가 들어갈 element의 height
						var borderWidth = 5; //샘플에서 사용하는 border의 두께

						// 위에서 선언한 값들을 실제 element에 넣는다.
						element_layer.style.width = width + 'px';
						element_layer.style.height = height + 'px';
						element_layer.style.border = borderWidth + 'px solid';
						// 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
						element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
								+ 'px';
						element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
								+ 'px';
					}
				</script>
				<div class="form-group">
					<label for="phone" style="font-size: 24px">Phone Number</label> <input
						type="text" style="width: 800px" class="form-control" name="phone"
						value="${userSession.phone}" placeholder="010-0000-0000">
					<form:errors path="phone" style="color:#E16A93; font-size:28px;" />
				</div>
				<div class="form-group">
					<input type="hidden" style="width: 800px" class="form-control"
						name="favoriteUser" value="null" placeholder="선호하는 매장을 입력하세요.">
				</div>
				<div class="form-group">
					<input type="hidden" style="width: 800px" class="form-control"
						name="languagePreference" value="null" placeholder="Korean">
				</div>
				<div class="form-group">
					<label for="carInfo" style="font-size: 24px">Car
						Information</label> <input type="text" style="width: 800px"
						class="form-control" name="carInfo" value="${userSession.carInfo}"
						placeholder="소유한 차량의 정보를 입력하세요.">
					<form:errors path="carInfo" style="color:#E16A93; font-size:28px;" />
					<br> <br>

				</div>
				<div class="form-group" style="text-align: center">
					<button type="submit" id="join-submit" class="button primary">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="button" id="join-cancle" onclick="location.href='/'">
						가입취소<i class="fa fa-times spaceLeft"></i>		
					</button>
					<!-- <a class="button" href="/">가입취소<i class="fa fa-times spaceLeft"></i></a> -->
				</div>
			</form:form>
		</div> 
	</div>
</div>
<%@ include file="IncludeBottom.jsp"%>