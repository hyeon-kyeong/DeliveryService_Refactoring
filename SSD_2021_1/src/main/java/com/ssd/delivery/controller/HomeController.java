package com.ssd.delivery.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
public class HomeController {
	
	private DeliveryFacade delivery;
	@Autowired
	public void setDeliveryFacade(DeliveryFacade delivery) {
		this.delivery= delivery;
	}
	
	@GetMapping("/")
	public ModelAndView home(Model model, HttpSession session) throws Exception {
			
			ModelAndView mav = new ModelAndView();
			
			List<CoPurchasingDTO> CPList = delivery.getCPList();
			List<AuctionDTO> ACList = delivery.getAuctionList();
			List<DeliveryDTO> DelList = delivery.getDeliveryList();
			
			mav.addObject("CPList", CPList);
			mav.addObject("DelList", DelList);
			mav.addObject("ACList", ACList);
			mav.setViewName("index");
		
			return mav;
		}
} 