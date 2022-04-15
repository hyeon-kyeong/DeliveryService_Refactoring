package com.ssd.delivery.controller.delivery;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@RequestMapping("/admin/delivery/delete.do")
public class DeleteDeliveryController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}
	
	@GetMapping
	public String adminDeliveryDelete(Model model, HttpSession session, @RequestParam("delId") int delId) throws Exception {
		
		delivery.deleteAuction(delId);
		delivery.deleteCP(delId);
		delivery.deleteDelivery(delId);
		
		return "redirect:/admin/delivery.do";
	}
}
