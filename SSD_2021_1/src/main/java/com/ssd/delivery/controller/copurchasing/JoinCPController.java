package com.ssd.delivery.controller.copurchasing;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/coPurchasingJoin.do")
public class JoinCPController {
	@Autowired
	private DeliveryFacade delivery;

	@GetMapping
	public String handleRequest(
			@RequestParam("coPurchasingId") int cpId,
			HttpSession session,
			ModelMap model) throws Exception {
		
		CoPurchasingDTO cp = this.delivery.getCPById(cpId);
		
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		
		model.put("cp", cp);
		model.put("user", account);
		return "copurchasingJoinForm";

	}

	@PostMapping
	public String submit(CoPurchasingLineItemDTO cplineitemDTO, ModelMap model) {
		delivery.insertCPLineItem(cplineitemDTO);
		
		int cpId = cplineitemDTO.getCoPurchasingId();
		CoPurchasingDTO cp = delivery.getCPById(cpId);
		
		DeliveryDTO del = delivery.getDeliveryById(cp.getDelivery());
		
		model.put("cp", cp);
		model.put("cplineitemDTO", cplineitemDTO);
		model.put("del", del);
		
		return "coPurchasingJoinSuccess";
	}
	
}
