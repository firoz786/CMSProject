package com.cms.service;



import com.cms.dao.ClaimProcessDAO;
import com.cms.exception.DatabaseException;
import com.cms.to.ClaimProcessTO;

/**
 * @author Aeishwary Gupta
 *
 */
public class ClaimProcessService {

	/**
	 * @param claimprocessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public  boolean processclaim(ClaimProcessTO claimprocessDTO) throws DatabaseException {
		return new ClaimProcessDAO().processClaim(claimprocessDTO);
		
	}

	/**
	 * @param claimProcessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public  boolean updatestatus(ClaimProcessTO claimProcessDTO) throws DatabaseException{
		
		return new ClaimProcessDAO().updatestatus(claimProcessDTO);
	}

}
