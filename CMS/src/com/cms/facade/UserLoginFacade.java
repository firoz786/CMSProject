package com.cms.facade;

import com.cms.service.PasswordCryptoService;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.service.ProfileUpdateCheckService;
import com.cms.to.UserTO;
import com.cms.service.UserLoginService;
import com.cms.to.ProfileUpdateTO;

/**
 * @author Rishabh Gupta
 *
 */
public class UserLoginFacade {

    /**
     * @param userTO
     * @return boolean
     * @throws CMSBusinessException
     * @throws DatabaseException
     */
    public boolean checkUserValidity(UserTO userTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        status = isValidUser(userTO);
        if (status) {
            status = isProfileUpdate(userTO);
        }
        return status;
    }

    private boolean isValidUser(UserTO userTO) throws CMSBusinessException, DatabaseException {
        boolean status = false;
        encryptpassword(userTO);
        status = new UserLoginService().isValidUser(userTO);
        return status;
    }

    private boolean isProfileUpdate(UserTO userTO) throws DatabaseException {
        ProfileUpdateTO profileUpdateTO = new ProfileUpdateTO();
        setProfileTOMemberID(userTO, profileUpdateTO);
        return new ProfileUpdateCheckService().isProfileUpdate(profileUpdateTO);
    }

    private void setProfileTOMemberID(UserTO userTO, ProfileUpdateTO profileUpdateTO) {
        profileUpdateTO.setMemberid(userTO.getUserMemberID());
    }

    private void encryptpassword(UserTO userTO) {
        userTO.setUserPassword(new PasswordCryptoService().getEncryptedPassword(userTO.getUserPassword()));
    }

}
