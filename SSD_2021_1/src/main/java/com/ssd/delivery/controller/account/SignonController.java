package com.ssd.delivery.controller.account;

import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.Message;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@RestController
//@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/signon.do")
public class SignonController {

	private DeliveryFacade delivery;
	
	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public ModelAndView showForm(HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		EncryptionAndHashing.initRsa(request);

		return mav;
	}

	@PostMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpSession session,
			@RequestParam("USERNAME") String username,
			@RequestParam("PASSWORD") String password, 
			@RequestParam(value = "forwardAction", required = false) String forwardAction,
			Model model) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		PrivateKey privateKey = (PrivateKey) session
				.getAttribute(EncryptionAndHashing.getRSA_WEB_KEY());

		// 복호화
		username = EncryptionAndHashing.decryptRsa(privateKey, username);
		password = EncryptionAndHashing.decryptRsa(privateKey, password);

		// 개인키 삭제
		session.removeAttribute(EncryptionAndHashing.getRSA_WEB_KEY());
		
		AccountDTO account = delivery.findUser(username);
		
		if (account != null) {
			String salt = delivery.getSaltByUsername(username);
			password = EncryptionAndHashing.getEncrypt(password, salt.getBytes());
		}
		
		if (account == null || !account.getPassword().equals(password)) { // 로그인 정보 불일치
			model.addAttribute("data",
					new Message("가입되지 않은 아이디거나 잘못된 비밀번호 입니다.", "/"));
			EncryptionAndHashing.initRsa(request);
			
			mav.setViewName("login");
			
			return mav;
		}

		model.addAttribute("userSession", account);

		if (forwardAction != null) {
			mav.setViewName("redirect:/" + forwardAction);
		} else {
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}

}
