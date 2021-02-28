/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.NomineeNameRemovalFacade;

import com.cms.to.NomineeNameRemovalTO;
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
public class RemoveNomineeNameAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(RemoveNomineeNameAction.class);

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
	private void removeNomineeName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession errorMessage = request.getSession(true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		try {
			if (request.getParameter("rnomineename").equals("") || request.getParameter("rinsurancetype").equals("")) {
				throw new CMSBusinessException(PropertyUtil.getCMSMessages("139"));
			}
			NomineeNameRemovalTO nameRemovalTO = new NomineeNameRemovalTO();
			HttpSession memberIDSession = request.getSession(false);

			nameRemovalTO.setMemberid(memberIDSession.getAttribute("memberid").toString());
			nameRemovalTO.setNomineeName(request.getParameter("rnomineename"));
			nameRemovalTO.setInsuranceType(request.getParameter("rinsurancetype"));
			if (new NomineeNameRemovalFacade().removeNomiee(nameRemovalTO)) {
				errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("161"));
				dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
			}

		} catch (CMSBusinessException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());

		} catch (DatabaseException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());

		} finally {
			dispatcher.forward(request, response);
		}
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
		removeNomineeName(request, response);
	}

}
