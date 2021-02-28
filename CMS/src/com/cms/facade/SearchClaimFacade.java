/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.facade;

import com.cms.to.SearchClaimTO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.SearchClaimService;

/**
 *
 * @author Aeishwary Gupta
 */
public class SearchClaimFacade {

    /**
     * @param searchclaimDTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean searchClaim(SearchClaimTO searchclaimDTO) throws CMSBusinessException, DatabaseException {
        return new SearchClaimService().searchClaim(searchclaimDTO);
    }
}
