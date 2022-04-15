package com.ssd.delivery.controller.auction;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.*;
import com.ssd.delivery.service.DeliveryFacade;
import com.ssd.delivery.service.Message;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/auctionInsert.do")
public class InsertAuctionFormController {

	@Autowired
	private DeliveryFacade delivery;

	@SuppressWarnings("unused")
	@GetMapping
	public ModelAndView showInsertForm(HttpSession session) {

		AccountDTO account = (AccountDTO) session.getAttribute("userSession");
		
		ModelAndView mav = new ModelAndView();

		if(account == null) {
			Message msg = new Message("로그인 후 이용 가능합니다. 로그인을 해주세요.", "/");
			mav.addObject("msg", msg);
			mav.setViewName("login");
			
			return mav; 
			
		}else {
			List<DeliveryDTO> deliveryList = delivery.getDeliveryByUsername(account.getUsername());
			List<DeliveryDTO> del = delivery.isExistingCP();
			List<DeliveryDTO> del2 = delivery.isExistingAC();
		
		// 같은 딜리버리로 공동구매가 진행중인게 있는지 확인하고 있으면 삭제함
		for (int i = 0; i < del.size(); i++) {
			for (int j = 0; j < deliveryList.size(); j++) {
				if (del.get(i).getDeliveryId() == deliveryList.get(j).getDeliveryId()) {
					deliveryList.remove(j);
				}
			}
		}

		// 같은 딜리버리로 이미 생성한 경매가 있는지 조사하고 있으면 삭제함
		for (int i = 0; i < del2.size(); i++) {
			for (int j = 0; j < deliveryList.size(); j++) {
				if (del2.get(i).getDeliveryId() == deliveryList.get(j).getDeliveryId()) {
					deliveryList.remove(j);
				}
			}
		}
		
			mav.addObject("delList", deliveryList);
			mav.setViewName("auctionForm");
		}

		return mav;
	}

}
