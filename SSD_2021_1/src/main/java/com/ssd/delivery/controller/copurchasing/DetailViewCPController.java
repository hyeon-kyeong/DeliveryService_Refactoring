package com.ssd.delivery.controller.copurchasing;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.CoPurchasingLineItemDTO;

import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.service.DeliveryFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */

@Controller
@SessionAttributes("userSession")
@RequestMapping("/delivery/coPurchasingDetailView.do")
public class DetailViewCPController { 
	@Autowired
	private DeliveryFacade delivery;

	@Autowired
	public void setDelivery(DeliveryFacade delivery) {
		this.delivery = delivery;
	}

	@GetMapping
	public String handleRequest(
			@RequestParam("coPurchasingId") int cpId,
			HttpSession session,
			ModelMap model) throws Exception {

		System.out.println(cpId);
		CoPurchasingDTO cp = this.delivery.getCPById(cpId);
		DeliveryDTO del = delivery.getDeliveryById(cp.getDelivery());
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");

		System.out.println(cpId);

		List<CoPurchasingLineItemDTO> cplineitem = delivery.getCPLineItemsByCPId(cpId);

		String status = "open";

		if(delivery.getCPById(cpId).getMaxNumberOfPurchaser() <= delivery.CPLineItemCount(cpId)) 
		{
			status= "closed";
		}
		System.out.println("status " + status);


		String status2 = "notparticipant";

		if (account == null) {
			status2 = "signoff";
		}
		else if (account.getUsername().equals(cp.getUsername())) {

			status2 = "poster";

		}
		else {
			for (CoPurchasingLineItemDTO list : cplineitem) {

				System.out.println("lineitem [" + list.getUsername() +"]");
				System.out.println("account.getUsername [" + account.getUsername() +"]");

				if (list.getUsername().equals(account.getUsername()) )

					status2 = "participant";
			}
		}

		System.out.println("status " + status);
		System.out.println("status2 " + status2);

		if (cplineitem != null) model.put("cplineitem", cplineitem);

		model.put("cp", cp);
		model.put("del", del);
		model.put("cplineitem", cplineitem);
		model.put("status", status);
		model.put("status2", status2);
		return "coPurchasingDetail";

	}

}
