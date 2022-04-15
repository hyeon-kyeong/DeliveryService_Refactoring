package com.ssd.delivery.controller.auction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.dao.mybatis.mapper.EventMapper;
import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.AuctionFormValidator;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/auctionInsert2.do")
public class InsertAuctionController {
	@Autowired
	private DeliveryFacade delivery;
	@Autowired
	EventMapper eventMapper;
	@Autowired
	private AuctionFormValidator validator;
	
	@GetMapping
	public ModelAndView insert2(@RequestParam("deliveryId") int deliveryId, HttpSession session) throws Exception {
		
		DeliveryDTO delItem = delivery.getDeliveryById(deliveryId);
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currentDate = dFormat.format(date);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("currentDate", currentDate);
		mav.addObject("delivery", delItem);
		mav.setViewName("auctionForm2");
		
		return mav;
	}
	
	@PostMapping 
	public ModelAndView insertAuction(Model model, HttpSession session, @ModelAttribute("AuctionForm")  AuctionDTO auction, 
			BindingResult result, @RequestParam("deliveryId") int deliveryId , @RequestParam("endDate")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date closeTime
			) throws Exception {
		
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		
		ModelAndView mav = new ModelAndView();
		
		DeliveryDTO del = delivery.getDeliveryById(deliveryId);
		String status = eventMapper.getStatusByDeliveryId(deliveryId);

		mav.addObject("status", status);
		mav.addObject("ac", auction);
		mav.addObject("delivery", del);
		mav.addObject("userSession", account);

		validator.validate(auction, result);
		if (result.hasErrors()) {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String currentDate = dFormat.format(date);

			mav.addObject("currentDate", currentDate);
			mav.setViewName("auctionForm2");
			 
			return mav;
		}
		
		
		auction.setDelivery(deliveryId);
		delivery.insertAuction(auction);

		System.out.println(deliveryId + "	" + closeTime);
		delivery.testScheduler(deliveryId, closeTime);
			
		mav.setViewName("auctionDetail");
		
		return mav;
	
	}
	
}
