/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.NomineeAdditionFacade;
import com.cms.to.NomineeAdditionTO;
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
public class NomineeAdditionAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(NomineeAdditionAction.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void addNewNominee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession errorMessage = request.getSession(true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        try {
            if (request.getParameter("anomineename").equals("") || request.getParameter("nomineenameinsurancetype").equals("")) {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("139"));
            }
            HttpSession memberIDSession = request.getSession(false);
            NomineeAdditionTO nomineeAdditionTO = new NomineeAdditionTO();
            nomineeAdditionTO.setNomineeName(request.getParameter("anomineename"));
            nomineeAdditionTO.setInsuranceType(request.getParameter("nomineenameinsurancetype"));
            nomineeAdditionTO.setMemberid(memberIDSession.getAttribute("memberid").toString());
            if (new NomineeAdditionFacade().addNominee(nomineeAdditionTO)) {
                errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("140"));
                dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
            }

        } catch (CMSBusinessException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } catch (DatabaseException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } finally {
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addNewNominee(request, response);
    }

}
