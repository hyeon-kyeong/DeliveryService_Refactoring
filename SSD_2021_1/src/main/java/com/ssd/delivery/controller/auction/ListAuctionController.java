package com.ssd.delivery.controller.auction;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.controller.UserSession;
import com.ssd.delivery.dao.mybatis.mapper.EventMapper;
import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.service.DeliveryFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class ListAuctionController {
	@Autowired
	private DeliveryFacade delivery;

	@Autowired
	EventMapper event;
	
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@RequestMapping("/auction/list")
	public ModelAndView handleRequest(
		@ModelAttribute("userSession") UserSession userSession) throws Exception { 
		
		List<AuctionDTO> auctionList =  delivery.getAuctionList();
		
		for (int i = 0; i < auctionList.size(); i++) {
			Date curTime = new Date();
			// 실행 시점의 시각을 전달하여 그 시각 이전의 closing time 값을 갖는 event의 상태를 변경
			event.closeEvent(curTime); // EVENTS 테이블의 레코드 갱신
			System.out.println("updateTableRunner is executed at " + curTime);
		}
		
		return new ModelAndView("auctionList", "auctionList", auctionList);
	}

}
