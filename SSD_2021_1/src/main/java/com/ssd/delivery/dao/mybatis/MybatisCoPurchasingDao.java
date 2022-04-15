package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.CoPurchasingDao;
import com.ssd.delivery.dao.mybatis.mapper.CoPurchasingMapper;
import com.ssd.delivery.domain.CoPurchasingDTO;

/**
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
@Repository
public class MybatisCoPurchasingDao implements CoPurchasingDao {

	@Autowired
	private CoPurchasingMapper CPMapper;
	
	@Override
	public void insertCP(CoPurchasingDTO CP) throws DataAccessException {
		
		CPMapper.insertCP(CP);
		
	}

	@Override
	public void updateCP(CoPurchasingDTO CP) throws DataAccessException {
		
		CPMapper.updateCP(CP);
		
	}

	@Override
	public void deleteCP(int CPId) throws DataAccessException {
		
		CPMapper.deleteCP(CPId);
		
	}

	@Override
	public List<CoPurchasingDTO> getCPList() throws DataAccessException {
		
		return CPMapper.getCPList();
	}

	@Override
	public CoPurchasingDTO getCPById(int CPId) throws DataAccessException {
		
		return CPMapper.getCPById(CPId);
	}

	@Override
	public List<CoPurchasingDTO> getCPListByUsername(String username) throws DataAccessException {
		
		return CPMapper.getCPListByUsername(username);
	}
	
	@Override
	public List<CoPurchasingDTO> isExsitingCPAC() throws DataAccessException {
		
		return CPMapper.isExistingCPAC();
	}

	@Override
	public CoPurchasingDTO getCPByDeliveryId(int deliveryId) throws DataAccessException {
		
		return CPMapper.getCPByDeliveryId(deliveryId);
	}

	@Override
	public CoPurchasingDTO getCPIdByUsername(String username) throws DataAccessException {

		return CPMapper.getCPIdByUsername(username);
	}
	
}