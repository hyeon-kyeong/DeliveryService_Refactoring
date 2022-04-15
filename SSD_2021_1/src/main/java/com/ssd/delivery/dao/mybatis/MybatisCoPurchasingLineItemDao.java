package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.CoPurchasingLineItemDao;
import com.ssd.delivery.dao.mybatis.mapper.CoPurchasingLineItemMapper;
import com.ssd.delivery.domain.CoPurchasingLineItemDTO;

/**
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
@Repository
public class MybatisCoPurchasingLineItemDao implements  CoPurchasingLineItemDao {

	@Autowired
	private CoPurchasingLineItemMapper cplineitemmapper;

	@Override
	public List<CoPurchasingLineItemDTO> getCPLineItemsByCPId(int CPId) throws DataAccessException {
		return cplineitemmapper.getCPLineItemsByCPId(CPId);
	}


	@Override
	public void insertCPLineItem(CoPurchasingLineItemDTO cp) throws DataAccessException {
		cplineitemmapper.insertCPLineItem(cp);
	}
	
	@Override
	public void insertCPLineItem2(CoPurchasingLineItemDTO cp) throws DataAccessException {
		cplineitemmapper.insertCPLineItem2(cp);
	}

	@Override
	public void deleteCPLineItem(int coPurchasingId) throws DataAccessException {
		cplineitemmapper.deleteCPLineItem(coPurchasingId);
	}
	
	@Override
	public int CPLineItemCount(int coPurchasingId) throws DataAccessException {
		return cplineitemmapper.getCPLineItemsByCPId(coPurchasingId).size();
	}

	@Override
	public void deleteCPLineItemByUsername(String username) throws DataAccessException {
		cplineitemmapper.deleteCPLineItemByUsername(username);
		
	}
	
}