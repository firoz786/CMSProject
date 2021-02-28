/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.RequestClaimFacade;
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
public class RequestClaimAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(RequestClaimAction.class);

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
	private void getDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		HttpSession errorMessage = request.getSession(false);
		try {

			if (request.getParameter("memberid").equals("") || request.getParameter("firstname").equals("")
					|| request.getParameter("lastname").equals("") || request.getParameter("insurancetype2").equals("")
					|| request.getParameter("subinsurancetype2").equals("")
					|| request.getParameter("maximumclaimableamount").equals("")
					|| request.getParameter("finalclaimableamount").equals("")
					|| request.getParameter("dateofbirth").equals("")) {

				throw new CMSBusinessException(PropertyUtil.getCMSMessages("200"));
			}

			JSPProfileUpdateTO jSPProfileUpdateTO = new JSPProfileUpdateTO();
			jSPProfileUpdateTO.setMemberID(request.getParameter("memberid"));
			jSPProfileUpdateTO.setFirstname(request.getParameter("firstname"));
			jSPProfileUpdateTO.setLastname(request.getParameter("lastname"));
			jSPProfileUpdateTO.setInsuranceType(request.getParameter("insurancetype2"));
			jSPProfileUpdateTO.setSubInsuranceType(request.getParameter("subinsurancetype2"));
			jSPProfileUpdateTO
					.setMaximumClaimableAmount(Double.valueOf(request.getParameter("maximumclaimableamount")));
			jSPProfileUpdateTO.setDateofbirth(request.getParameter("dateofbirth"));
			jSPProfileUpdateTO.setFinalClaimableAmount(Double.valueOf(request.getParameter("finalclaimableamount")));

			if (new RequestClaimFacade().getDetails(jSPProfileUpdateTO)) {

				HttpSession session = request.getSession(true);
				session.setAttribute("claimid", jSPProfileUpdateTO.getClaimiID());
				dispatcher = request.getRequestDispatcher("SuccessRequest.jsp");
			}
		} catch (CMSBusinessException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("RequestClaim.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} catch (DatabaseException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("RequestClaim.jsp");
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
		getDetails(request, response);
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
		getDetails(request, response);
	}

}
