package com.ssd.delivery.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssd.delivery.domain.DeliveryDTO;

@Component
public class DeliveryFormValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return DeliveryDTO.class.isAssignableFrom(clazz);
	}
 
	public void validate(Object obj, Errors errors) {

		DeliveryDTO delivery = (DeliveryDTO)obj; 

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "ADDRESS1_REQUIRED", "Departure point is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2", "ADDRESS2_REQUIRED", "Destination is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serviceDate", "SERVICE_DATE_REQUIRED", "Service Date is required.");
		
		if (!delivery.getServiceDate().equals("")) {
			if (!Pattern.matches("^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$", delivery.getServiceDate()))
				errors.rejectValue("serviceDate", "SERVICE_DATE_PATTERN_WRONG", "Service Date pattern is wrong.");
			
			else {
				Calendar cal = Calendar.getInstance();
				Date day1 = cal.getTime();
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
				String currentDate = dFormat.format(day1);
				
				Date day2 = null;
				
				try {
					day1 = dFormat.parse(currentDate); 
					day2 = dFormat.parse(delivery.getServiceDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				int compare = day1.compareTo(day2);
				
				if (compare > 0)
					errors.rejectValue("serviceDate", "SERVICE_DATE_PASSED", "Service Date is already passed.");
				if (compare == 0)
					errors.rejectValue("serviceDate", "TOO_SHOR_AUCTION_PERIOD", "Service Period is too short");
			}
		}
	}
}
 