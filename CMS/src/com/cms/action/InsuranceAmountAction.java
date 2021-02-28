/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.facade.InsuranceMaximumClaimableAmountFacade;
import com.cms.facade.NomineeNameFacade;
import com.cms.to.JSPProfileUpdateTO;
import com.cms.util.PropertyUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 *
 * @author Rishabh Gupta
 */
public class InsuranceAmountAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(InsuranceAmountAction.class);

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	private void getInsuranceAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession errorMessage = request.getSession(true);
		RequestDispatcher dispatcher = null;
		try {
			if (request.getParameter("insurancetype") == null) {
				throw new NullPointerException(PropertyUtil.getCMSMessages("231"));
			}
			HttpSession jspProfileTOSession = request.getSession(false);
			JSPProfileUpdateTO jSPProfileUpdateTO = (JSPProfileUpdateTO) jspProfileTOSession
					.getAttribute("jspProfileUpdateTO");
			HttpSession insuranceAmountSession = request.getSession(true);
			if (jSPProfileUpdateTO == null) {
				throw new NullPointerException(PropertyUtil.getCMSMessages("229"));
			}
			insuranceAmountSession.setAttribute("insuranceamount",
					jSPProfileUpdateTO.getInsuranceTypeMap().get(request.getParameter("insurancetype")));
			jSPProfileUpdateTO.setInsuranceType(request.getParameter("insurancetype"));
			insuranceAmountSession.setAttribute("insurancetype", request.getParameter("insurancetype"));
			HttpSession maximumClaimableAmountSession = request.getSession(true);
			if (new InsuranceMaximumClaimableAmountFacade().getMaximumClaimableAmount(jSPProfileUpdateTO,
					request.getParameter("insurancetype"))) {
				maximumClaimableAmountSession.setAttribute("maximumclaimableamount",
						jSPProfileUpdateTO.getMaximumClaimableAmount());
				dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");

			}
		} catch (CMSBusinessException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} catch (NullPointerException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("error.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} finally {
			dispatcher.forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getInsuranceAmount(request, response);
	}

}
