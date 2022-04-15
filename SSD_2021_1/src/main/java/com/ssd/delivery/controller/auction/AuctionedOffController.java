package com.ssd.delivery.controller.auction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/auctionAuctionedOff.do")
public class AuctionedOffController {
	@Autowired
	private DeliveryFacade delivery;

	@PostMapping 
	public ModelAndView insertAuction(Model model, HttpSession session, @ModelAttribute("AuctionForm")  AuctionDTO auction) throws Exception {
		
		List<AuctionLineItemDTO> acLineItem = delivery.getACLineItemsByACId(auction.getAuctionId());
		String successfulBidder = "";
		
		int finalPrice = auction.getFinalPrice();
	
		for(int i = 0; i < acLineItem.size(); i++) {
			if(acLineItem.get(i).getJoinPrice() == finalPrice) {
				successfulBidder = acLineItem.get(i).getUsername();
				break;
			}
		}
		
		auction.setFinalPrice(finalPrice);
		auction.setSuccessfulBidder(successfulBidder);
		delivery.updateAuction(auction);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ac", auction);
		mav.setViewName("auctionedPage");
				
		return mav;
	
	}
	
}
