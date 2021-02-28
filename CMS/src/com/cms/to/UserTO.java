package com.cms.to;

import java.io.Serializable;

/**
 * @author Rishabh Gupta
 *
 */
public class UserTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userMemberID;
    private String userPassword;

    /**
     * @return String
     */
    public String getUserMemberID() {
        return userMemberID;
    }

    /**
     * @param userMemberID
     */
    public void setUserMemberID(String userMemberID) {
        this.userMemberID = userMemberID;
    }

    /**
     * @return String
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
