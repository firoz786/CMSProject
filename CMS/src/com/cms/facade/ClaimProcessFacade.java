package com.cms.facade;

import java.sql.SQLException;

import com.cms.exception.DatabaseException;
import com.cms.service.ClaimProcessService;
import com.cms.to.ClaimProcessTO;

/**
 * @author Aeishwary Gupta
 *
 */
public class ClaimProcessFacade {

	/**
	 * @param claimprocessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public  boolean processclaim(ClaimProcessTO claimprocessDTO) throws DatabaseException  {
		return new ClaimProcessService().processclaim(claimprocessDTO);
		
	}

	/**
	 * @param claimProcessDTO
	 * @return boolean
	 * @throws DatabaseException
	 */
	public  boolean updatestatus(ClaimProcessTO claimProcessDTO) throws DatabaseException{
		
		return  new ClaimProcessService().updatestatus(claimProcessDTO);
	}


}
