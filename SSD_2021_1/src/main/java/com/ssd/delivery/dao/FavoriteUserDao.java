package com.ssd.delivery.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

public interface FavoriteUserDao {

	void insertFU(FavoriteUserDTO favoriteUser) throws DataAccessException;
	
	void updateFU(FavoriteUserDTO favoriteUser) throws DataAccessException;
	
	void updateTradeCount(String tradeCount, String username, String favUsername) throws DataAccessException;
	
	void deleteFU(String favId) throws DataAccessException;
	
	List<FavoriteUserDTO> getFUByUsername(String username) throws DataAccessException;
	
	List<FavoriteUserDTO> getFUList() throws DataAccessException;
	
	List<AuctionDTO> getACTradeCount(String favUsername, String username) throws DataAccessException;
	
	List<CoPurchasingDTO> getCPTradeCount(String favUsername, String username) throws DataAccessException;
}
