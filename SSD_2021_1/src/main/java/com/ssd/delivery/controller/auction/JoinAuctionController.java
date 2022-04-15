package com.ssd.delivery.controller.auction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.AuctionJoinFormValidator;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/auctionJoin.do")
public class JoinAuctionController {
	@Autowired
	private DeliveryFacade delivery; 
	@Autowired
	private AuctionJoinFormValidator validator;
	@GetMapping
	public String handleRequest(
			@RequestParam("auctionId") int acId, HttpSession session, ModelMap model) throws Exception {
		
		AuctionDTO ac = this.delivery.getAuctionById(acId);
		DeliveryDTO del = delivery.getDeliveryById(ac.getDelivery());
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		
		if(ac.getCurrentPrice() == 0) {
			ac.setCurrentPrice(ac.getStartPrice());
		}
		System.out.println("AUCTIONID: " + acId + " CURR PRICE: " + ac.getCurrentPrice());
		
		model.put("ac", ac);
		model.put("delivery", del);
		model.put("user", account);
		return "auctionJoinForm"; 

	}

	
	@PostMapping
	public ModelAndView submit(HttpSession session,@ModelAttribute("auctionJoinForm") AuctionLineItemDTO aclineitemDTO,
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		AuctionDTO auction = delivery.getAuctionById(aclineitemDTO.getAuctionId());
		
		validator.validate(aclineitemDTO, result);
		if (result.hasErrors()) {
			AccountDTO account = (AccountDTO)session.getAttribute("userSession");
			mav.addObject("user", account);
			mav.addObject("ac", auction);
			mav.setViewName("auctionJoinForm");
			return mav;
		}
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String currentDate = dFormat.format(date);
		
		DeliveryDTO del = delivery.getDeliveryById(auction.getDelivery());
		aclineitemDTO.setJoinDate(currentDate);
		delivery.updateCurrentPriceAuction(aclineitemDTO.getJoinPrice(), aclineitemDTO.getAuctionId());
	
		delivery.insertACLineItem(aclineitemDTO);
		
		List<AuctionLineItemDTO> aclineitem = delivery.getACLineItemsByACId(aclineitemDTO.getAuctionId());
		mav.addObject("aclineitem", aclineitem);
		mav.addObject("ac", auction);
		mav.addObject("delivery",del);
		mav.setViewName("auctionDetail");
		
		return mav;
	}
	
}
