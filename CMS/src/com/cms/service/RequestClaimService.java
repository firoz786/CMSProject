/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cms.dao.RequestClaimDAO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.to.JSPProfileUpdateTO;
import com.cms.util.PropertyUtil;

/**
 *
 * @author Rishabh Gupta
 */
public class RequestClaimService {

	/**
	 * @param jSPProfileUpdateTO
	 * @return boolean
	 * @throws DatabaseException
	 * @throws CMSBusinessException
	 */
	public boolean getDetails(JSPProfileUpdateTO jSPProfileUpdateTO) throws DatabaseException, CMSBusinessException {

		String dateofapproval = jSPProfileUpdateTO.getDateofbirth();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		date.setLenient(false);
		Date d;
		try {
			d = date.parse(dateofapproval);
		} catch (ParseException e) {
			throw new CMSBusinessException(PropertyUtil.getCMSMessages("167"));
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 45);
		jSPProfileUpdateTO.setDateofapproval(
				cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
		return new RequestClaimDAO().getDetails(jSPProfileUpdateTO);
	}
}
