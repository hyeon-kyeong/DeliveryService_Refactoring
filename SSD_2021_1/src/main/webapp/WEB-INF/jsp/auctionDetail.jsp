<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="IncludeTop.jsp"%>
<script>
   function closedAuction() {
      alert("종료된 경매 입니다.");
      return false;
   }
</script>
<script>
   function auctionedOff() {
      alert("정말 낙찰하시겠습니까?");
      form.submit();
   }
</script>
<!-- Main -->
<div id="main">
   <div class="inner">
      <c:if test="${status eq 'CLOSE' or ac.successfulBidder ne null}">
         <h1>🚩 이미 <b style="color:red">진행 종료</b>된 경매입니다. <br/>더이상 입찰을 진행할 수 없습니다.</h1>
         
         <h2><b style="color: #f2849e">* 낙찰가: ${ac.finalPrice }원 *</b></h2>
      </c:if>
      <h1>Auction ⏳</h1>
      <div style="float: right; padding-right: 30px">
			<a href="/delivery/auctionView.do" class="button">경매 페이지로 돌아가기 </a>
			</div>
      <h2><b style="color: #f2849e">*</b>출발지: ${ac.address1}</h2>
      <h2>
         <a href="/delivery/userView.do?username=${ac.username}"><b style="color: #f2849e">*</b>경매 등록자 :
            ${ac.username}</a>
      </h2>

      <div class="table-wrapper">
         <table class="alt">
            <thead>
               <tr>
                  <th>Item</th>
                  <th>Description</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>서비스 제공자</td>
                  <td>${delivery.username}</td>

               </tr>
               <tr>
                  <td>출발지</td>
                  <td>${delivery.address1 }</td>

               </tr>
               <tr>
                  <td>도착지</td>
                  <td>${delivery.address2 }</td>

               </tr>
               <tr>
                  <td>서비스 날짜</td>
                  <td>${delivery.serviceDate }</td>

               </tr>
               <tr>
                  <td>가격</td>
                  <td>${delivery.price }</td>

               </tr>
            </tbody>
         </table>
      </div>
      <form action="" method="post"></form>
      <h2>
         ⏰ 경매 마감시간: ${ac.endDate }
         <c:if test="${userSession.username eq ac.username}">
            <div style="float: right; padding-right: 30px">
               <c:if test="${status eq 'CLOSE' or ac.successfulBidder ne null}">
                  <input type="button" class="button" disabled
                     value="&ensp;🛎낙찰🛎&ensp;">
               </c:if>
               <c:if test="${status eq 'OPEN' && ac.successfulBidder eq null}">
                  <form action="/delivery/auctionAuctionedOff.do" method="POST">
                     <input type="hidden" name="auctionId" id="auctionId"
                        value='${ac.auctionId}' placeholder="${ac.auctionId}" /> <input
                        type="hidden" name="endDate" id="endDate" value='${ac.endDate}'
                        placeholder="${ac.endDate}" /> <input type="hidden"
                        name="serviceDate" id="serviceDate"
                        value='${delivery.serviceDate}'
                        placeholder="${delivery.serviceDate}" /> <input type="hidden"
                        name="startPrice" id="startPrice" value='${ac.startPrice}'
                        placeholder="${ac.startPrice}" /> <input type="hidden"
                        name="finalPrice" id="finalPrice" value='${ac.currentPrice}'
                        placeholder="${ac.currentPrice}" /> <input type="hidden"
                        name="address1" id="address1" value='${delivery.address1}'
                        placeholder="${delivery.address1}" /> <input type="hidden"
                        name="address2" id="address2" value='${delivery.address2}'
                        placeholder="${delivery.address2}" /> <input type="hidden"
                        name="delivery" id="delivery" value='${delivery.deliveryId}'
                        placeholder="${delivery.deliveryId}" /> <input type="hidden"
                        name="username" id="username" value='${ac.username}'
                        placeholder="${ac.username}" />
                     <div style="float: right; padding-right: 30px">
                        <button type="submit" onClick="auctionedOff()">&nbsp;&nbsp;&nbsp;&nbsp;🛎낙찰🛎&nbsp;&nbsp;&nbsp;&nbsp;</button>
                     </div>
                  </form>
               </c:if>
            </div>
         </c:if>
      </h2>
      <h3>💵 시작가: ${ac.startPrice} (KRW)</h3>
      <h3>💰 입찰단위: 입찰자 자유</h3>
      <br />
      <c:if
         test="${userSession.username ne ac.username && userSession.username ne null}">
         <c:if test="${status ne 'CLOSE' or ac.successfulBidder eq null}">
         <div style="float: right; padding-right: 5px">
            <c:if test="${status eq 'CLOSE'}">
               <a href="#" class="button primary" onclick="closedAuction()">&ensp;&ensp;경매
                  참여🤚🏻&ensp;&ensp;</a>
            </c:if>
            <c:if test="${status eq 'OPEN' && ac.successfulBidder ne null}">
               <a href="#" class="button primary" onclick="closedAuction()">&ensp;&ensp;경매
                  참여🤚🏻&ensp;&ensp;</a>
            </c:if>
             <c:if test="${status eq 'OPEN' && ac.successfulBidder eq null}">
               <a href="/delivery/auctionJoin.do?auctionId=${ac.auctionId}"
                  class="button primary">&ensp;&ensp;경매 참여🤚🏻&ensp;&ensp;</a>
            </c:if>
         </div>
         </c:if>
      </c:if>
      <br />
      <h3>
         <b style="color: #f2849e">* 입찰 현황</b>
      </h3>
      <div class="table-wrapper">
         <table class="alt">
            <thead>
               <tr>
                  <th>번호</th>
                  <th>참여자</th>
                  <th>입찰일시</th>
                  <th>입찰금액</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="aclineitem" items="${aclineitem}" varStatus="st">
                  <tr>
                     <td>${st.index+1}</td>
                     <td>${aclineitem.username}</td>
                     <td>${aclineitem.joinDate}</td>
                     <td>${aclineitem.joinPrice}원</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>
</div>

<%@ include file="IncludeBottom.jsp"%>