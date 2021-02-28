/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import com.cms.constants.PatternConstants;
import com.cms.dao.UserLoginDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.util.PropertyUtil;
import com.cms.to.UserTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rishabh Gupta
 */
public class UserLoginService {

    /**
     * @param userTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean isValidUser(UserTO userTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        int memberIDValue = 0;
        if (isValidCredentials(userTO)) {
            memberIDValue = new UserLoginDAO().isValidUser(userTO);
            if (memberIDValue == 1) {
                int passwordValue = new UserLoginDAO().checkUserCredentials(userTO);
                if (passwordValue == 1) {
                    status = true;
                } else {
                    throw new CMSBusinessException(PropertyUtil.getCMSMessages("222"));
                }
            } else {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("221"));
            }
        }
        return status;
    }

    private boolean isValidCredentials(UserTO userVO) throws CMSBusinessException {
        boolean status = false;
        Pattern memberIDPattern = Pattern.compile(PatternConstants.MEMBERID);
        Matcher memberIDMatcher = memberIDPattern.matcher(userVO.getUserMemberID());
        if (memberIDMatcher.matches()) {
            if (userVO.getUserPassword().length() > 3) {
                status = true;
            } else {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("226"));
            }
        } else {
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("223"));
        }
        return status;
    }

}
