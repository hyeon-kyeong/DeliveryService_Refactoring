package com.ssd.delivery.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.DeliveryDTO;

public interface DeliveryDao {

	void insertDelivery(DeliveryDTO delivery) throws DataAccessException;
	
	void updateDelivery(DeliveryDTO delivery) throws DataAccessException;
	
	void deleteDelivery(int deliveryId) throws DataAccessException;
	
	DeliveryDTO getDeliveryIdByUsername(String username) throws DataAccessException;
	
	DeliveryDTO getDeliveryById(int deliveryId) throws DataAccessException;
	
	List<DeliveryDTO> getDeliveryByUsername(String username) throws DataAccessException;
	
	List<DeliveryDTO> getDeliveryList() throws DataAccessException;
	
	List<DeliveryDTO> isExistingCP() throws DataAccessException;
	
	List<DeliveryDTO> isExistingAC() throws DataAccessException;
	

}
