package com.ssd.delivery.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.AccountFormValidator;
import com.ssd.delivery.service.DeliveryFacade;

//등록, 수정 둘 다 이곳에서
@Controller
@SessionAttributes("userSession")
@RequestMapping({"/delivery/insertAccount.do","/delivery/newUserSubmitted.do", "/delivery/updateAccount.do"})
public class AccountFormController {
	@Autowired
	private DeliveryFacade delivery;
	@Autowired
	private AccountFormValidator validator;
	
	@GetMapping
	public String showForm() { 
		return "register";
	}

	@PostMapping
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm") AccountDTO account,
			BindingResult result) throws Exception {
		

		validator.validate(account, result);
		if (result.hasErrors()) return "register";

		
		try {
			AccountDTO existingUser = delivery.findUser(account.getUsername());
			
			if(existingUser == null) {
				String address = account.getAddress2() + account.getPostcode() + account.getDetailAddress() + account.getExtraAddress();
				account.setAddress(address);
				account.setStatus(1);
				delivery.insertAccount(account);
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return "redirect:/"; 
		}
		
		session.setAttribute("userSession", account);
		
		return "redirect:/";
	}
}