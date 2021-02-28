package com.cms.constants;

/**
 * @author Rishabh Gupta
 *
 */
public class PatternConstants {

    public static final String NAME = "^[A-z]+$";
    public static final String EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String CONTACT = "^[0-9]{10,10}$";
    public static final String MEMBERID = "^[M]{1,1}[B]{1,1}[C]{1,1}[-]{1,1}[0-9]{5,5}$";
    public static final String CITY = "^[A-z]+$";
    public static final String STATE = "^[A-z ]+$";
    public static final String ZIPCODE = "^[1-9][0-9]{5}$";
    public static final String MAXIMUMCLAIMABLEAMOUNT = "^[0-9]{5,}$";
    

}
