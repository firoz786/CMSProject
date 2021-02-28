package com.cms.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.util.PropertyUtil;

/**
 * Servlet implementation class SignOutAction
 */
public class SignOutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignOutAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession allSession = request.getSession(false);
		if (allSession.getAttribute("memberid") != null) {
			allSession.invalidate();
			response.sendRedirect("Welcome.jsp");
		}else{
			allSession.setAttribute("errorMessage", PropertyUtil.getCMSMessages("229"));
			response.sendRedirect("Welcome.jsp");
		}

	}

}
