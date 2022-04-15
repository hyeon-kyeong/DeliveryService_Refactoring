package com.ssd.delivery.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.CoPurchasingDTO;

public interface LineItemDao {
	
	void insertCP(CoPurchasingDTO CP) throws DataAccessException;
	
	void updateCP(CoPurchasingDTO CP) throws DataAccessException;
	
	void deleteCP(int CPId) throws DataAccessException;
	
	List<CoPurchasingDTO> getCPList() throws DataAccessException;
	
	CoPurchasingDTO getCPById(int CPId) throws DataAccessException;
	
	List<CoPurchasingDTO> getCPListByUsername(String username) throws DataAccessException;
	
	

}
