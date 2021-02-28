package com.cms.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cms.exception.DatabaseException;
import com.cms.facade.ClaimProcessFacade;
import com.cms.to.ClaimProcessTO;


/**
 * @author Aeishwary Gupta
 *
 */
public class ClaimApprovalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ClaimApprovalAction.class);
	/**
	 * 
	 */
	public ClaimApprovalAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession claimApprovalSession = request.getSession(false);
		ClaimProcessTO claimProcessTO = (ClaimProcessTO) claimApprovalSession.getAttribute("claimProcessTO");
		String status = null;
		
		if (request.getParameter("Approve") != null) {
			status = "Approve";

		}
		if (request.getParameter("Reject") != null) {
			status = "Reject";
		}
		claimProcessTO.setStatus(status);
		try {
			if (new ClaimProcessFacade().updatestatus(claimProcessTO)) {

				claimApprovalSession.setAttribute("claimProcessTO", claimProcessTO);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ClaimProcess.jsp");
				dispatcher.forward(request, response);
			}
		} catch (DatabaseException e) {
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
		}

	}
}
