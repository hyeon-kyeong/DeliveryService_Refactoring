package com.ssd.delivery.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssd.delivery.domain.MessageDTO;
import com.ssd.delivery.service.DeliveryImpl;

@Controller
@SessionAttributes("sessionMessage")
public class InsertMessageController {
	@Autowired
	private DeliveryImpl deliveryImpl;
	
	@RequestMapping("/delivery/messageInsert.do")
	public String handleRequest(
			@RequestParam("message") MessageDTO message,
			ModelMap model) throws Exception {
		deliveryImpl.insertMessage(message);
		
		return "messageList";
	}
}