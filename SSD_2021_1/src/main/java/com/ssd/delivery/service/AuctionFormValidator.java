package com.ssd.delivery.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ssd.delivery.domain.AuctionDTO;

@Component
public class AuctionFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return AuctionDTO.class.isAssignableFrom(clazz);
	}
 
	public void validate(Object obj, Errors errors) {

		AuctionDTO auction = (AuctionDTO)obj;
		
		Calendar cal = Calendar.getInstance();
		Date day1 = cal.getTime();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currentDate = dFormat.format(day1);
		
		Date day2 = null;
		
		try {
			day1 = dFormat.parse(currentDate); 
			day2 = dFormat.parse(auction.getEndDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int compare = day1.compareTo(day2);
		
		if (compare > 0)
			errors.rejectValue("endDate", "END_DATE_PASSED", "End Date is already passed.");
		if (compare == 0)
			errors.rejectValue("endDate", "TOO_SHOR_AUCTION_PERIOD", "Auction Period is too short");

	}
}
