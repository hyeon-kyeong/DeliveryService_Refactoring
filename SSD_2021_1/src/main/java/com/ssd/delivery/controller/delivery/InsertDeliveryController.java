package com.ssd.delivery.controller.delivery;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.DeliveryFormValidator;
import com.ssd.delivery.service.Message;

@Controller
@RequestMapping("/delivery/insert.do")
@SessionAttributes("userSession")
public class InsertDeliveryController {
	@Autowired
	private DeliveryFacade delivery;
	@Autowired
	private DeliveryFormValidator validator;
	
	@GetMapping
	public ModelAndView showForm(HttpSession session) { 
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		ModelAndView mav = new ModelAndView();
		
		if(account == null) {
			Message msg = new Message("로그인 후 이용 가능합니다. 로그인을 해주세요.", "/");
			mav.addObject("msg", msg);
			mav.setViewName("login");
			
		}else {
			mav.setViewName("deliveryForm");
		}
		 
		return mav;
	}
	
	@PostMapping
	public ModelAndView insertDelivery(Model model, HttpSession session, @ModelAttribute("deliveryForm")  DeliveryDTO del,
			BindingResult result) throws Exception {
		
		ModelAndView mav = new ModelAndView();	
		
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		mav.addObject("userSession", account);	

		validator.validate(del, result);

		if (result.hasErrors()) {
			mav.setViewName("deliveryForm");
			return mav;
		}
		
		String sdate = del.getServiceDate();
		
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date to = dFormat.parse(sdate);
		String date = dFormat.format(to);

		del.setServiceDate(date);
		delivery.insertDelivery(del);

		mav.addObject("delivery", del);
		mav.setViewName("deliveryDetail");
		
		return mav;
	
	}
	
}
