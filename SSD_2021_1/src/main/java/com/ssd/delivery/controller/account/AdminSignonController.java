package com.ssd.delivery.controller.account;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.Message;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/adminSignon.do")
public class AdminSignonController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public String showForm() {
		return "adminLogin";
	}

	@PostMapping
	public String handleRequest(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value = "forwardAction", required = false) String forwardAction, Model model)
			throws Exception {

		AccountDTO account = delivery.findUser(username);

		if (account == null || !account.getPassword().equals(password) || account.getStatus() != 0) { // 로그인 정보 불일치
			model.addAttribute("data", new Message("관리자가 아니거나, 잘못된 비밀번호 입니다.", "/"));
			return "adminLogin";
		}
		model.addAttribute("userSession", account);

		if (forwardAction != null) {
			return "redirect:/delivery/adminMain.do" + forwardAction;
		}
		else {
			return "redirect:/delivery/adminMain.do";
		}
	}
}
