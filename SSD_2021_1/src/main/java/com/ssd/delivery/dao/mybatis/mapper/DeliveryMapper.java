package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssd.delivery.domain.DeliveryDTO;
@Mapper
public interface DeliveryMapper {

	void insertDelivery(DeliveryDTO delivery);
	
	void updateDelivery(DeliveryDTO delivery);
	
	void deleteDelivery(int deliveryId);
	
	DeliveryDTO getDeliveryIdByUsername(String username);
	
	DeliveryDTO getDeliveryById(int deliveryId);
	
	List<DeliveryDTO> isExistingCP();
	
	List<DeliveryDTO> isExistingAC();
	
	List<DeliveryDTO> getDeliveryByUsername(String username);
	
	List<DeliveryDTO> getDeliveryList();
}
