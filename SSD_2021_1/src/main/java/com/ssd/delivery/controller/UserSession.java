package com.ssd.delivery.controller;

import java.io.Serializable;
import org.springframework.beans.support.PagedListHolder;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private AccountDTO account;

	private PagedListHolder<FavoriteUserDTO> myList;

	public UserSession(AccountDTO accountDTO) {
		this.account = accountDTO;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setMyList(PagedListHolder<FavoriteUserDTO> myList2) {
		this.myList = myList2;
	}

	public PagedListHolder<FavoriteUserDTO> getMyList() {
		return myList;
	}
}
