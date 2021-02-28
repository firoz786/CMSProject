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
public class ClaimProcessAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ClaimProcessAction.class);
	/**
	 * 
	 */
	public ClaimProcessAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClaimProcessTO claimprocessTO = new ClaimProcessTO();
		HttpSession claimProcessSession = request.getSession(true);
		claimprocessTO.setMemberID(request.getParameter("memberid"));
		try {
			if (new ClaimProcessFacade().processclaim(claimprocessTO)) {
				claimProcessSession.setAttribute("claimProcessTO", claimprocessTO);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("ClaimProcess.jsp");
				dispatcher.forward(request, response);
			}
		} catch (DatabaseException e) {
			LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
		}
	}

}
