/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import static com.cms.constants.PatternConstants.*;
import com.cms.dao.ProfileUpdateDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.to.ProfileUpdateTO;
import com.cms.util.PropertyUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rishabh Gupta
 */
public class ProfileUpdateService {

    /**
     * @param profileUpdateTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean updateProfileDetails(ProfileUpdateTO profileUpdateTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        status = isValidDetails(profileUpdateTO);
        if (status) {
            status = updateProfileDetailsInDatabase(profileUpdateTO);
        }
        return status;
        //return new ProfileUpdateDAO().updateProfile(profileUpdateTO);
    }

    private boolean isValidDetails(ProfileUpdateTO profileUpdateTO) throws CMSBusinessException {
        boolean status = false;
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(profileUpdateTO.getFirstname());
        if (matcher.matches()) {
            matcher = pattern.matcher(profileUpdateTO.getLastname());
            if (matcher.matches()) {
                pattern = Pattern.compile(EMAIL);
                matcher = pattern.matcher(profileUpdateTO.getEmailaddress());
                if (matcher.matches()) {
                    pattern = Pattern.compile(CONTACT);
                    matcher = pattern.matcher(profileUpdateTO.getContactnumber());
                    if (matcher.matches()) {
                        pattern = Pattern.compile(CITY);
                        matcher = pattern.matcher(profileUpdateTO.getCity());
                        if (matcher.matches()) {
                            pattern = Pattern.compile(STATE);
                            matcher = pattern.matcher(profileUpdateTO.getState());
                            if (matcher.matches()) {
                                pattern = Pattern.compile(ZIPCODE);
                                matcher = pattern.matcher(profileUpdateTO.getZipcode());
                                if (matcher.matches()) {
                                    status = true;
                                } else {
                                    throw new CMSBusinessException(PropertyUtil.getCMSMessages("137"));
                                }
                            } else {
                                throw new CMSBusinessException(PropertyUtil.getCMSMessages("136"));
                            }
                        } else {
                            throw new CMSBusinessException(PropertyUtil.getCMSMessages("135"));
                        }
                    } else {
                        throw new CMSBusinessException(PropertyUtil.getCMSMessages("203"));
                    }
                } else {
                    throw new CMSBusinessException(PropertyUtil.getCMSMessages("202"));
                }
            } else {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("208"));
            }
        } else {
            throw new CMSBusinessException(PropertyUtil.getCMSMessages("201"));
        }
        return status;
    }

    private boolean updateProfileDetailsInDatabase(ProfileUpdateTO profileUpdateTO) throws DatabaseException {
        boolean status = false;
        if (new ProfileUpdateDAO().isUpdatingFirstTimeProfile(profileUpdateTO) == 0) {
            status = new ProfileUpdateDAO().updateFirstTimeProfile(profileUpdateTO);
        } else {
            status = new ProfileUpdateDAO().updateProfile(profileUpdateTO);
        }

        return status;
    }
}
