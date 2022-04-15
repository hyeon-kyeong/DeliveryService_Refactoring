package com.ssd.delivery.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.CoPurchasingLineItemDTO;

public interface CoPurchasingLineItemDao {

	void insertCPLineItem(CoPurchasingLineItemDTO cp) throws DataAccessException;
	
	void insertCPLineItem2(CoPurchasingLineItemDTO cp) throws DataAccessException;
	
	void deleteCPLineItem(int coPurchasingId) throws DataAccessException;
	
	List<CoPurchasingLineItemDTO> getCPLineItemsByCPId(int coPurchasingId) throws DataAccessException;
	
	int CPLineItemCount(int coPurchasingId) throws DataAccessException;
	
	void deleteCPLineItemByUsername(String username) throws DataAccessException;

}
