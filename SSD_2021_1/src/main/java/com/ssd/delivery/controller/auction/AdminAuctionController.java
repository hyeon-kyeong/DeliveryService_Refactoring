package com.ssd.delivery.controller.auction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

@Controller
@SessionAttributes("userSession")
@RequestMapping({"/admin/auction.do","/delivery/adminAuction.do"})
public class AdminAuctionController {

	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public String adminAuctionView(Model model, HttpSession session) throws Exception {
		List<DeliveryDTO> del = delivery.isExistingAC();
		
		List<AuctionDTO> ACList = delivery.getAuctionList();

		for (int i = 0; i < del.size(); i++) {
			for (int j = 0; j < ACList.size(); j++) {
				if (del.get(i).getDeliveryId() == ACList.get(j).getDelivery()) {
					ACList.get(j).setFlag(1);
				}
			}
		}
		
		model.addAttribute("ACList", ACList);
	
		return "adminAuction";
	}
	
	
}
