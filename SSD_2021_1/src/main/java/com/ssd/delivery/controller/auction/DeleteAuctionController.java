package com.ssd.delivery.controller.auction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.service.DeliveryFacade;


@RestController
//@RequestMapping("/admin/auction/delete.do")
public class DeleteAuctionController { 

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}
	
	@GetMapping("/admin/auction/delete.do/{auctionId}")
	public ModelAndView adminAuctionDelete(@PathVariable("auctionId") int auctionId, Model model, HttpSession session) throws Exception {
		System.out.println("안녕");
		
		ModelAndView mav = new ModelAndView();
		delivery.deleteACLineItem(auctionId);
		delivery.deleteAuction(auctionId);
		
		mav.setViewName("redirect:/admin/auction.do");
		return mav;
	}
	
}
