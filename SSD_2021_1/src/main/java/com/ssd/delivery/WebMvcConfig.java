package com.ssd.delivery;

import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {  

//	@Autowired
//	@Qualifier(value = "signonInterceptor") 
//	private HandlerInterceptor interceptor;
 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		//main
		registry.addViewController("/delivery/mainpage.jsp").setViewName("index");
		
		//admin
		registry.addViewController("/delivery/adminSignon.do").setViewName("adminLogin");
		registry.addViewController("/delivery/adminMain.do").setViewName("adminMain");
		registry.addViewController("/delivery/adminAuction.do").setViewName("adminAuction");
		registry.addViewController("/delivery/adminDelivery.do").setViewName("adminDelivery");
		registry.addViewController("/delivery/adminCoPurchasing.do").setViewName("adminCoPurchasing"); 
		
		//account 
		registry.addViewController("/delivery/insertAccount.do").setViewName("register");
		registry.addViewController("/delivery/updateAccount.do").setViewName("accountUpdate");
		registry.addViewController("/delivery/newUserSubmitted.do").setViewName("index");
		registry.addViewController("/delivery/mypage.do").setViewName("mypage");
		registry.addViewController("/delivery/favoriteUser.do").setViewName("favoriteUser");
		registry.addViewController("/delivery/userView.do").setViewName("viewUser");
		
		//login
		registry.addViewController("/delivery/signon.do").setViewName("login");
		registry.addViewController("/delivery/signoff.do").setViewName("index");
		
		//auction
		registry.addViewController("/delivery/auctionDetailView.do").setViewName("auctionDetail");
		registry.addViewController("/delivery/auctionInsert.do").setViewName("auctionForm");
		registry.addViewController("/delivery/auctionInsert2.do").setViewName("auctionForm2");
		registry.addViewController("/delivery/auctionNewAuctionSubmitted.do").setViewName("auctionpage");
		registry.addViewController("/delivery/auctionDetail.do").setViewName("auctionDetail");
		registry.addViewController("/delivery/auctionJoin.do").setViewName("auctionJoinForm");
		registry.addViewController("/delivery/auctionAuctionedOff.do").setViewName("auctionedPage");

		//copurchasing
		registry.addViewController("/delivery/copurchasingView.do").setViewName("copurchasingpage");
		registry.addViewController("/delivery/coPurchasingDetailView.do").setViewName("coPurchasingDetail");
		registry.addViewController("/delivery/coPurchasingInsertForm.do").setViewName("copurchasingForm");
		registry.addViewController("/delivery/coPurchasingJoin.do").setViewName("copurhasingjoinForm");
		
		//delivery
		registry.addViewController("/delivery/detailView.do").setViewName("deliveryDetail");
		registry.addViewController("/delivery/listView.do").setViewName("deliveryPage");
		
		//message
		registry.addViewController("/delivery/message.do").setViewName("message");
		registry.addViewController("/delivery/messageCreate.do").setViewName("messageForm");
		registry.addViewController("/delivery/messageCreate2.do").setViewName("messageForm2");
		registry.addViewController("/delivery/messageSend.do").setViewName("message");
		registry.addViewController("/delivery/messageSend2.do").setViewName("messageForm");
		registry.addViewController("/delivery/messageSend3.do").setViewName("message");

	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor)
//				.addPathPatterns("/shop/editAccount.do", "/shop/listOrders.do",
//					"/shop/viewOrder.do", "/shop/newOrder.do");
//	}

}
