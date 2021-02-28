/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.facade.UserLoginFacade;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.util.PropertyUtil;
import com.cms.to.UserTO;
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
public class LoginAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(LoginAction.class);

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
	private void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		UserTO userTO = new UserTO();
		HttpSession errorMessage = request.getSession(true);

		try {
			if (request.getParameter("memberid").equals("") || request.getParameter("password").equals("")) {
				throw new NullPointerException(PropertyUtil.getCMSMessages("227"));
			}

			userTO.setUserMemberID(request.getParameter("memberid"));
			userTO.setUserPassword(request.getParameter("password"));
			HttpSession userSession = request.getSession(true);
			if (new UserLoginFacade().checkUserValidity(userTO)) {
				userSession.setAttribute("memberid", userTO.getUserMemberID());
				dispatcher = request.getRequestDispatcher("userhome.jsp");
			} else {
				errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("228"));
				userSession.setAttribute("memberid", userTO.getUserMemberID());
				dispatcher = request.getRequestDispatcher("getMemberProfileDetails");
			}
		} catch (CMSBusinessException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());

		} catch (DatabaseException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
			if (e.getMessage().equals(PropertyUtil.getCMSMessages("228"))) {
				dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("Welcome.jsp");
			}
		} catch (NullPointerException e) {
			errorMessage.setAttribute("errorMessage", e.getMessage());
			dispatcher = request.getRequestDispatcher("Welcome.jsp");
			LOGGER.info("Happened at class" + this.getClass().getName() + " at " + Calendar.getInstance().getTime()
					+ " -" + e.getMessage());
		} finally {
			dispatcher.forward(request, response);
		}

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
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
		validateUser(request, response);
	}

}
