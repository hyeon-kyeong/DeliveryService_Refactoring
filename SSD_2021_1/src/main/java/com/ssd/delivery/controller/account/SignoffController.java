package com.ssd.delivery.controller.account;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignoffController { 
	@RequestMapping("/delivery/signoff.do")
	public String handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("userSession");
		session.invalidate();
		return "redirect:/";
	}
}