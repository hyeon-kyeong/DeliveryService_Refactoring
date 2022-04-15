package com.ssd.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.AuctionLineItemDTO;
 
@Component
public class AuctionJoinFormValidator implements Validator {
	@Autowired
	private DeliveryFacade delivery; 
	
	public boolean supports(Class<?> clazz) {
		return AuctionLineItemDTO.class.isAssignableFrom(clazz);
	}
 
	public void validate(Object obj, Errors errors) {

		AuctionLineItemDTO auction = (AuctionLineItemDTO)obj; 

		AuctionDTO ac = delivery.getAuctionById(auction.getAuctionId());
		
		System.out.println(auction.getAuctionId());
		System.out.println(ac.getCurrentPrice());
		System.out.println(auction.getJoinPrice());
		if (ac.getCurrentPrice() >= auction.getJoinPrice() && auction.getJoinPrice() != 0)
			errors.rejectValue("joinPrice", "JOIN_PRICE_NOT_HIGHER_THAN_CURRENT_PRICE", "Join Price must be higher than " + ac.getCurrentPrice() + " (KRW)");

	}
}