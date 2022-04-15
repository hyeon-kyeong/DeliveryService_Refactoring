package com.ssd.delivery.controller.delivery;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Controller
@SessionAttributes("userSession")
@RequestMapping({"/admin/delivery.do", "/adminDelivery.do", "/delivery/adminDelivery.do"})
public class AdminDeliveryController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public ModelAndView adminDeliveryView(Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		List<DeliveryDTO> DelList = delivery.getDeliveryList();
		System.out.println("%%%%%%%%" + DelList.isEmpty());

		mav.addObject("DelList", DelList);
		mav.setViewName("adminDelivery");
	
		return mav;
	}
	
}
