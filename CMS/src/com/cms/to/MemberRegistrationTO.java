/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.to;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rishabh Gupta
 */
public class MemberRegistrationTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String memberID;
    private String firstname;
    private String lastname;
    private String gender;
    private String dateofbirth;
    private String emailaddress;
    private String contactnumber;
    private String password;

    /**
     * @return String
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * @param memberID
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    /**
     * @return String
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String
     */
    public String getDateofbirth() {
        return dateofbirth;
    }

    /**
     * @param dateofbirth
     */
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    /**
     * @return String
     */
    public String getEmailaddress() {
        return emailaddress;
    }

    /**
     * @param emailaddress
     */
    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    /**
     * @return String
     */
    public String getContactnumber() {
        return contactnumber;
    }

    /**
     * @param contactnumber
     */
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
