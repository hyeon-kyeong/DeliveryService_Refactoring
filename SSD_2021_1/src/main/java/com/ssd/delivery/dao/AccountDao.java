package com.ssd.delivery.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

@Repository
public interface AccountDao {
	void insertAccount(AccountDTO account) throws DataAccessException;
	
	void updateAccount(AccountDTO account) throws DataAccessException;
	
	void deleteAccount(String username) throws DataAccessException;
	
	List<AccountDTO> getUserListByAuctionId(String auctionId) throws DataAccessException;
	
	List<AccountDTO> getUserList() throws DataAccessException;
	
	List<AccountDTO> getUserListByCPId(String CPId) throws DataAccessException;
	
	boolean existingUser(String username) throws DataAccessException;
	
	List<FavoriteUserDTO> getFavoriteUserList(String username) throws DataAccessException;
	
	AccountDTO findUser(String username) throws DataAccessException;

}
