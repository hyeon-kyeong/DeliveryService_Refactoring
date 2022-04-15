package com.ssd.delivery.controller.copurchasing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;

@Controller
public class ListCPController {

	@RequestMapping("/coPurchasing/list")
	public ModelAndView handleRequest(
			@ModelAttribute("Account") AccountDTO account) throws Exception {
		
		return new ModelAndView("viewCPList");
	}

}
