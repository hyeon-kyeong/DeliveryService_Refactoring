package com.ssd.delivery.controller.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.service.DeliveryFacade;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/delivery/adminUser.do")
public class AdminUserController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public ModelAndView adminCPView(Model model, HttpSession session) throws Exception {
		List<AccountDTO> user = delivery.getUserList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("UserList", user);
		mav.setViewName("adminUser");
	
		return mav;
	}
	
}
