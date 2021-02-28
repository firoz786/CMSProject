/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import static com.cms.constants.PatternConstants.NAME;
import com.cms.dao.NomineeAdditionDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.to.NomineeAdditionTO;
import com.cms.util.PropertyUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rishabh Gupta
 */
public class NomineeAdditionService {

    /**
     * @param nomineeAdditionTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean addNominee(NomineeAdditionTO nomineeAdditionTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        if (isValidNomineeName(nomineeAdditionTO)) {
            status = addNomineeToDAO(nomineeAdditionTO);
        }
        return status;
    }

    private boolean isValidNomineeName(NomineeAdditionTO nomineeAdditionTO) throws CMSBusinessException {
        boolean status = false;
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(nomineeAdditionTO.getNomineeName());
        if (matcher.matches()) {
            status = true;
        } else {
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("138"));
        }
        return status;
    }

    private boolean addNomineeToDAO(NomineeAdditionTO nomineeAdditionTO) throws DatabaseException {
        return new NomineeAdditionDAO().addNominee(nomineeAdditionTO);
    }
}
