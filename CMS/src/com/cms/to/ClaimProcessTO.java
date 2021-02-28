package com.cms.to;

/**
 * @author Aeishwary Gupta
 *
 */
public class ClaimProcessTO {

	private String memberID;
	private String RequestDate;
	private String claimId;
	private String insurancetypeId;
	private String claimreason;
	private String dateofapproval;
	private int finalclaimamount;
	private String status;

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
	public String getRequestDate() {
		return RequestDate;
	}

	/**
	 * @param requestDate
	 */
	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}

	/**
	 * @return String
	 */
	public String getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return String
	 */
	public String getInsurancetypeId() {
		return insurancetypeId;
	}

	/**
	 * @param insurancetypeId
	 */
	public void setInsurancetypeId(String insurancetypeId) {
		this.insurancetypeId = insurancetypeId;
	}

	/**
	 * @return String
	 */
	public String getClaimreason() {
		return claimreason;
	}

	/**
	 * @param claimreason
	 */
	public void setClaimreason(String claimreason) {
		this.claimreason = claimreason;
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

	/**
	 * @return String
	 */
	public int getFinalclaimamount() {
		return finalclaimamount;
	}

	/**
	 * @param finalclaimamount
	 */
	public void setFinalclaimamount(int finalclaimamount) {
		this.finalclaimamount = finalclaimamount;
	}

	/**
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
