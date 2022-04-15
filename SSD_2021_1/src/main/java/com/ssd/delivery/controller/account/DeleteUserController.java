package com.ssd.delivery.controller.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/admin/user/delete.do")
public class DeleteUserController { 

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}
	
	@GetMapping
	public String adminUserDelete(Model model, HttpSession session, @RequestParam("username") String username) throws Exception {
		
		AuctionDTO auction = delivery.getAuctionIdByUsername(username);
		CoPurchasingDTO cp = delivery.getCPIdByUsername(username);
		DeliveryDTO del = delivery.getDeliveryIdByUsername(username);
		
		if(del != null) {
			int deliveryId = del.getDeliveryId();
			delivery.deleteDelivery(deliveryId);
		}
		delivery.deleteACLineItemByUsername(username);
		if(auction != null) {
		  int auctionId = auction.getAuctionId();
		  delivery.deleteACLineItem(auctionId);
		  delivery.deleteAuction(auctionId);
		}
		delivery.deleteCPLineItemByUsername(username);
		if(cp != null) {
			int cpId = cp.getCoPurchasingId();
			delivery.deleteCP(cpId);
			delivery.deleteCPLineItem(cpId);
		}
		delivery.deleteFU(username);
		delivery.deleteAccount(username);
		
		return "redirect:/delivery/adminUser.do";
	}
}
