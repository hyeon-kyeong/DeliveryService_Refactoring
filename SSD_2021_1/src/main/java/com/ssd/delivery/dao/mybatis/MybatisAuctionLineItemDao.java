package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.AuctionLineItemDao;
import com.ssd.delivery.dao.mybatis.mapper.AuctionLineItemMapper;
import com.ssd.delivery.domain.AuctionLineItemDTO;

@Repository
public class MybatisAuctionLineItemDao implements  AuctionLineItemDao {

	@Autowired
	private AuctionLineItemMapper aclineitemmapper;

	@Override
	public List<AuctionLineItemDTO> getACLineItemsByACId(int ACId) throws DataAccessException {
		
		return aclineitemmapper.getACLineItemsByACId(ACId);
	}


	@Override
	public void insertACLineItem(AuctionLineItemDTO ac) throws DataAccessException {
		
		aclineitemmapper.insertACLineItem(ac);
	}


	@Override
	public void deleteACLineItem(int auctionId) throws DataAccessException {
		
		aclineitemmapper.deleteACLineItem(auctionId);
		
	}

	@Override
	public void deleteACLineItemByUsername(String username) throws DataAccessException {
		
		aclineitemmapper.deleteACLineItemByUsername(username);
	}
	
}