package com.ssd.delivery.controller.auction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@RequestMapping("/delivery/auctionView.do")
public class ViewAuctionController { 

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}
	
	@GetMapping
	public ModelAndView showAC(Model model, HttpSession session) throws Exception {
		List<AuctionDTO> ACList = delivery.getAuctionList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ACList", ACList);
		mav.setViewName("auctionpage");
				
		return mav;
	} 

}
