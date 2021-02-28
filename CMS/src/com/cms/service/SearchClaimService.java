/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.to.SearchClaimTO;
import com.cms.dao.SearchClaimDAO;
import com.cms.exception.DatabaseException;
import java.sql.SQLException;

/**
 *
 * @author Aeishwary Gupta
 */
public class SearchClaimService {

    /**
     * @param searchclaimDTO
     * @return boolean
     * @throws DatabaseException
     */
    public boolean searchClaim(SearchClaimTO searchclaimDTO) throws DatabaseException {
        return new SearchClaimDAO().searchClaim(searchclaimDTO);
    }
}
