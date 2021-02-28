/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rishabh Gupta
 */
public class JSPProfileUpdateTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String memberID;
    private String firstname;
    private String lastname;
    private String gender;
    private String dateofbirth;
    private String emailaddress;
    private String contactnumber;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String nomineename1;
    private String nomineename2;
    private String nomineename3;
    private String insuranceType;
    private HashMap<String, Double> insuranceTypeMap = new HashMap<String, Double>();
    private String subInsuranceType;
    private Double maximumClaimableAmount;
    private Double finalClaimableAmount;
    private String claimiID;
    private String dateofapproval;

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
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return String
     */
    public String getNomineename1() {
        return nomineename1;
    }

    /**
     * @param nomineename1
     */
    public void setNomineename1(String nomineename1) {
        this.nomineename1 = nomineename1;
    }

    /**
     * @return String
     */
    public String getNomineename2() {
        return nomineename2;
    }

    /**
     * @param nomineename2
     */
    public void setNomineename2(String nomineename2) {
        this.nomineename2 = nomineename2;
    }

    /**
     * @return String
     */
    public String getNomineename3() {
        return nomineename3;
    }

    /**
     * @param nomineename3
     */
    public void setNomineename3(String nomineename3) {
        this.nomineename3 = nomineename3;
    }

    /**
     * @param insuranceType
     * @param insuranceAmount
     */
    public void putInsuranceTypeValue(String insuranceType, Double insuranceAmount) {
        insuranceTypeMap.put(insuranceType, insuranceAmount);

    }

    /**
     * @return HashMap
     */
    public HashMap getInsuranceTypeMap() {
        return insuranceTypeMap;
    }

    /**
     * @return Double
     */
    public Double getMaximumClaimableAmount() {
        return maximumClaimableAmount;
    }

    /**
     * @param maximumClaimableAmount
     */
    public void setMaximumClaimableAmount(Double maximumClaimableAmount) {
        this.maximumClaimableAmount = maximumClaimableAmount;
    }

    /**
     * @return String
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * @param insuranceType
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * @return String
     */
    public String getSubInsuranceType() {
        return subInsuranceType;
    }

    /**
     * @param subInsuranceType
     */
    public void setSubInsuranceType(String subInsuranceType) {
        this.subInsuranceType = subInsuranceType;
    }

    /**
     * @return String
     */
    public Double getFinalClaimableAmount() {
        return finalClaimableAmount;
    }

    /**
     * @param finalClaimableAmount
     */
    public void setFinalClaimableAmount(Double finalClaimableAmount) {
        this.finalClaimableAmount = finalClaimableAmount;
    }

    /**
     * @return String
     */
    public String getClaimiID() {
        return claimiID;
    }

    /**
     * @param claimiID
     */
    public void setClaimiID(String claimiID) {
        this.claimiID = claimiID;
    }
    /**
     * @return String
     */
    public String getDateofapproval() {
        return dateofapproval;
    }

    /**
     * @param dateofapproval
     */
    public void setDateofapproval(String dateofapproval) {
        this.dateofapproval = dateofapproval;
    }
    

    
}
