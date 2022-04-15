package com.ssd.delivery.controller.account;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@RequestMapping("/delivery/mypage.do")
public class MyPageController { 
	private DeliveryFacade delivery;
	@Autowired
	public void setDeliveryFacade(DeliveryFacade delivery) {
		this.delivery= delivery;
	}
   
	@GetMapping 
	public ModelAndView viewMypage(Model model, HttpSession session, @RequestParam("username")String username) throws Exception {
		List<AccountDTO> accountList = delivery.getUserList();
		AccountDTO account = null;
		
		for(int i = 0 ; i < accountList.size(); i++) {
			if(accountList.get(i).getUsername().equals(username)) {
				account = accountList.get(i);
				break;
			}
		}
	
		ModelAndView mav = new ModelAndView();
		List<CoPurchasingDTO> CPList = delivery.getCPListByUsername(username);
		List<AuctionDTO> ACList = delivery.getAuctionByUsername(username);
		List<DeliveryDTO> DelList = delivery.getDeliveryByUsername(username);
		List<FavoriteUserDTO> favList = delivery.getFUByUsername(username);
		
		for(int i = 0; i < favList.size(); i++) {
			Integer tradeCount = 0;
			
			List<CoPurchasingDTO> CPTrade = delivery.getCPTradeCount(favList.get(i).getFavoriteUsername(), username);
			List<AuctionDTO> ACTrade = delivery.getACTradeCount(favList.get(i).getFavoriteUsername(), username);
			
			tradeCount = CPTrade.size() + ACTrade.size();
			delivery.updateTradeCount(tradeCount.toString(), username, favList.get(i).getFavoriteUsername());
		}
		
		mav.addObject("CPList", CPList);
		mav.addObject("DelList", DelList);
		mav.addObject("ACList", ACList);
		mav.addObject("favList", favList);
		mav.addObject("user", account);
		mav.setViewName("mypage");
	
		return mav;
	}
	
	@PostMapping
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm")  AccountDTO account,
			BindingResult result) throws Exception  {
		delivery.updateAccount(account);
		
		session.setAttribute("userSession", account);
		return "redirect:/delivery/mypage.do";
}
	
}