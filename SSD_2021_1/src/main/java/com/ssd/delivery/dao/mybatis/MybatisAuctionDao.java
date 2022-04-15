package com.ssd.delivery.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssd.delivery.dao.AuctionDao;
import com.ssd.delivery.dao.mybatis.mapper.AuctionMapper;
import com.ssd.delivery.domain.AuctionDTO;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisAuctionDao implements AuctionDao {
	
	@Autowired
	private AuctionMapper auctionMapper;
	
	
	@Override
	public void insertAuction(AuctionDTO auction) throws DataAccessException {  

		auctionMapper.insertAuction(auction);
	}
	
	@Override
	public void updateAuction(AuctionDTO auction) throws DataAccessException {  
    	
		auctionMapper.updateAuction(auction);
	}
	
	@Override
	public void updateCurrentPriceAuction(int currentPrice, int auctionId) throws DataAccessException {
		
		auctionMapper.updateCurrentPriceAuction(currentPrice, auctionId);
	}
	
	@Override
	public void deleteAuction(int auctionId) throws DataAccessException { 
		
    	auctionMapper.deleteAuction(auctionId);
	}
	
	@Override
	public AuctionDTO getAuctionById(int auctionId) {
		
		AuctionDTO auction = auctionMapper.getAuctionById(auctionId);
		
		return auction;
	}
	
	@Override
	public AuctionDTO getAuctionByDeliveryId(int deliveryId) {
		AuctionDTO auction = auctionMapper.getAuctionByDeliveryId(deliveryId);
		
		return auction;
	}
	
	@Override
	public List<AuctionDTO> getAuctionByUsername(String username){
		
	    return auctionMapper.getAuctionByUsername(username);
	}
	
	@Override
	public List<AuctionDTO> getAuctionList(){
		
	    return auctionMapper.getAuctionList();
	}
	
	@Override
	public AuctionDTO getAuctionIdByUsername(String username) throws DataAccessException {
		
		return auctionMapper.getAuctionIdByUsername(username);
	}
	
}