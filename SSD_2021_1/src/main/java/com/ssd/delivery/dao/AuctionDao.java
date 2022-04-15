package com.ssd.delivery.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.AuctionDTO;

public interface AuctionDao {
		  
	  void insertAuction(AuctionDTO auction) throws DataAccessException;
	  
	  void updateAuction(AuctionDTO auction) throws DataAccessException;
	  
	  void deleteAuction(int auctionId) throws DataAccessException;
	  
	  void updateCurrentPriceAuction(int currentPrice, int auctionId) throws DataAccessException;
	  
	  AuctionDTO getAuctionIdByUsername(String username) throws DataAccessException;
	  
	  AuctionDTO getAuctionById(int auctionId) throws DataAccessException;
	  
	  AuctionDTO getAuctionByDeliveryId(int deliveryId) throws DataAccessException;
	  
	  List<AuctionDTO> getAuctionByUsername(String username) throws DataAccessException;
	  
	  List<AuctionDTO> getAuctionList() throws DataAccessException;

}
