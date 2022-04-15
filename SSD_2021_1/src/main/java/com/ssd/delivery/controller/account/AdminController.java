package com.ssd.delivery.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ssd.delivery.service.DeliveryFacade;

import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userSession")
public class AdminController {

	@SuppressWarnings("unused")
	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@RequestMapping("/delivery/adminMain.do")
	public String showForm() {
		return "adminMain";
	}
	
}
