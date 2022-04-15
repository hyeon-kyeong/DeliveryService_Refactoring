package com.ssd.delivery.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.AuctionLineItemDTO;

public interface AuctionLineItemDao {

	void insertACLineItem(AuctionLineItemDTO ac) throws DataAccessException;
	void deleteACLineItem(int auctionId) throws DataAccessException;
	List<AuctionLineItemDTO> getACLineItemsByACId(int auctionId) throws DataAccessException;
	void deleteACLineItemByUsername(String username) throws DataAccessException;

	

}
