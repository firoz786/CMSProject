/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.FinalClaimableAmountFacade;
import com.cms.facade.RequestMaximumAmountFacade;
import com.cms.to.JSPProfileUpdateTO;
import com.cms.util.PropertyUtil;
import java.io.IOException;
import java.io.PrintWriter;
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
public class FinalClaimableAmountAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(FinalClaimableAmountAction.class);

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
	protected void getAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession memberidSession = request.getSession(false);
		HttpSession errorMessageSession = request.getSession(false);
		RequestDispatcher requestDispatcher = null;
		memberidSession.setAttribute("subinsurancetypevalue", request.getParameter("subinsurancetypehidden"));
		try {
			if (request.getParameter("insurancetype2hidden").equals("")
					|| request.getParameter("subinsurancetypehidden").equals("")) {
				throw new CMSBusinessException(PropertyUtil.getCMSMessages("165"));
			}
			JSPProfileUpdateTO jSPProfileUpdateTO = new JSPProfileUpdateTO();
			jSPProfileUpdateTO.setMemberID(memberidSession.getAttribute("memberid").toString());
			jSPProfileUpdateTO.setInsuranceType(request.getParameter("insurancetype2hidden"));
			jSPProfileUpdateTO.setSubInsuranceType(request.getParameter("subinsurancetypehidden"));
			if (new RequestMaximumAmountFacade().getMaximumAmount(jSPProfileUpdateTO)) {
				new FinalClaimableAmountFacade().getAmount(jSPProfileUpdateTO);
				memberidSession.setAttribute("maximumclaimableamount", jSPProfileUpdateTO.getMaximumClaimableAmount());
				memberidSession.setAttribute("finalclaimableamount", jSPProfileUpdateTO.getFinalClaimableAmount());
				memberidSession.setAttribute("insurancetype2", jSPProfileUpdateTO.getInsuranceType());
				requestDispatcher = request.getRequestDispatcher("RequestClaim.jsp");
			} else {
				throw new CMSBusinessException(PropertyUtil.getCMSMessages("166"));
			}

		} catch (CMSBusinessException e) {
			errorMessageSession.setAttribute("errorMessage", e.getMessage());
			requestDispatcher = request.getRequestDispatcher("RequestClaim.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} catch (DatabaseException e) {
			errorMessageSession.setAttribute("errorMessage", e.getMessage());
			requestDispatcher = request.getRequestDispatcher("RequestClaim.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} finally {
			requestDispatcher.forward(request, response);
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
		getAmount(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getAmount(request, response);
	}

}
