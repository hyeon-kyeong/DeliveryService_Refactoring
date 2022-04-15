package com.ssd.delivery.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssd.delivery.domain.AccountDTO;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class AccountFormValidator implements Validator {
	@Autowired
	private DeliveryFacade delivery;
	
	public boolean supports(Class<?> clazz) {
		return AccountDTO.class.isAssignableFrom(clazz);
	}
 
	public void validate(Object obj, Errors errors) {

		AccountDTO account = (AccountDTO)obj; 

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "USER_NAME_REQUIRED", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "PASSWORD_REQUIRED", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "PASSWORD_REQUIRED", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "FIRST_NAME_REQUIRED", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "LAST_NAME_REQUIRED", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address2", "ADDRESS_REQUIRED", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carInfo", "CAR_INFO_REQUIRED", "Car Information is required.");
		
		List<AccountDTO> accountList = delivery.getUserList();
		
		for (AccountDTO aList : accountList) {
			if (aList.getUsername().equals(account.getUsername()))
				errors.rejectValue("username", "EXISTING_USER", account.getUsername() + " is already exist.");
		}
		
		if (!account.getPassword().equals(account.getPassword2()))
			errors.rejectValue("password", "PASSWORD_NOT_MATCH", "Password is not match with Checking Password.");
		
		if (!Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", account.getEmail()) && !account.getEmail().equals(""))
			errors.rejectValue("email", "EMAIL_PATTERN_WRONG", "Email pattern is wrong.");

		if (!Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", account.getPhone()) && !account.getPhone().equals(""))
			errors.rejectValue("phone", "PHONE_PATTERN_WRONG", "Phone pattern is wrong.");

	}
}