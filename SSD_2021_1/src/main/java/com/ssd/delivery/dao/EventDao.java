package com.ssd.delivery.dao;

import java.util.Date;
import java.util.HashMap;

public interface EventDao {
	void insertNewEvent(HashMap<String, Object> hashMap);
	void closeEvent(Date curTime);
	String getStatusByDeliveryId(int deliveryId);
}
 