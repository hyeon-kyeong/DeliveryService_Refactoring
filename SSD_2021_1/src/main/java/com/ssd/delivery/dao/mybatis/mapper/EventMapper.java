package com.ssd.delivery.dao.mybatis.mapper;

import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {
	void insertNewEvent(HashMap<String, Object> map);
	void closeEvent(Date curTime);
	String getStatusByDeliveryId(int deliveryId);
}
 