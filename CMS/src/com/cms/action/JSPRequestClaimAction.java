/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.JSPProfileUpdateFacade;
import com.cms.to.JSPProfileUpdateTO;
import java.io.IOException;
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
public class JSPRequestClaimAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(JSPRequestClaimAction.class);

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
	private void getRequestDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession jspProfileTOSession = request.getSession(true);
		JSPProfileUpdateTO jSPProfileUpdateTO = new JSPProfileUpdateTO();
		HttpSession errorMessage = request.getSession(true);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
		try {
			jSPProfileUpdateTO.setMemberID((String) jspProfileTOSession.getAttribute("memberid"));
			if (new JSPProfileUpdateFacade().getmemberCredentials(jSPProfileUpdateTO)) {
				jspProfileTOSession.setAttribute("jspProfileUpdateTO", jSPProfileUpdateTO);
				requestDispatcher = request.getRequestDispatcher("RequestClaim.jsp");

			}
		} catch (CMSBusinessException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());

		} catch (DatabaseException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			requestDispatcher = request.getRequestDispatcher("error.jsp");
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
		getRequestDetails(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getRequestDetails(request, response);
	}

}
