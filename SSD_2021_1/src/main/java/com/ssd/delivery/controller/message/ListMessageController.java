package com.ssd.delivery.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.service.DeliveryImpl;

@Controller
@SessionAttributes("sessionMessage")
public class ListMessageController {
	@Autowired
	private DeliveryImpl deliveryImpl;
	
	@RequestMapping("/message/list")
	public ModelAndView handleRequest(
		) throws Exception {
		return new ModelAndView("MessageList", "messageList", 
				deliveryImpl.getMessageList());
	}
}
