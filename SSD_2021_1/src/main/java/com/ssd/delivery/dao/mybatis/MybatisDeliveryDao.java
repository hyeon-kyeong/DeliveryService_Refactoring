package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.dao.DeliveryDao;
import com.ssd.delivery.dao.mybatis.mapper.DeliveryMapper;
import com.ssd.delivery.domain.DeliveryDTO;

@Repository
public class MybatisDeliveryDao implements DeliveryDao{

	@Autowired
	private DeliveryMapper deliveryMapper;
	
	public void insertDelivery(DeliveryDTO delivery) throws DataAccessException {
		deliveryMapper.insertDelivery(delivery);
	}
	
	public void updateDelivery(DeliveryDTO delivery) throws DataAccessException {
		deliveryMapper.updateDelivery(delivery);
	}
	
	public void deleteDelivery(int deliveryId) throws DataAccessException {
		deliveryMapper.deleteDelivery(deliveryId);
	}
	
	public DeliveryDTO getDeliveryById(int deliveryId) throws DataAccessException {
		return deliveryMapper.getDeliveryById(deliveryId);
	}
	
	public List<DeliveryDTO> getDeliveryByUsername(String username) throws DataAccessException {
		return deliveryMapper.getDeliveryByUsername(username);
	}
	
	public List<DeliveryDTO> getDeliveryList() throws DataAccessException {
		return deliveryMapper.getDeliveryList();
	}
	
	public List<DeliveryDTO> isExistingCP() throws DataAccessException{
		return deliveryMapper.isExistingCP();
	}
	
	public List<DeliveryDTO> isExistingAC() throws DataAccessException{
		return deliveryMapper.isExistingAC();
	}

	@Override
	public DeliveryDTO getDeliveryIdByUsername(String username) throws DataAccessException {
		return deliveryMapper.getDeliveryIdByUsername(username);
	}

}
