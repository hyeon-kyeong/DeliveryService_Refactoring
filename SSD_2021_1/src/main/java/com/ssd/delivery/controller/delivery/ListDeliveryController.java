package com.ssd.delivery.controller.delivery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@RequestMapping("/delivery/listView.do")
public class ListDeliveryController { 
	@Autowired
	private DeliveryFacade delivery;
	
	@GetMapping
	public ModelAndView showDelivery(Model model, HttpSession session) throws Exception {
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		
		List<DeliveryDTO> deliveryList = delivery.getDeliveryList();
		
		for (int i = 0; i < deliveryList.size(); i++) {
			String sdate = deliveryList.get(i).getServiceDate();
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			Date to = dFormat.parse(sdate);
			String date = dFormat.format(to);
			
			deliveryList.get(i).setServiceDate(date);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("delivery", deliveryList);
		mav.addObject("userSession", account);
		mav.setViewName("deliveryPage");
				
		return mav;
	}
	
}