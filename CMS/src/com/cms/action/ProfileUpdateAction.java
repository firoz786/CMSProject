/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.ProfileUpdateFacade;
import com.cms.to.ProfileUpdateTO;
import com.cms.util.PropertyUtil;
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
public class ProfileUpdateAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(ProfileUpdateAction.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void updateMemberDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession errorMessage = request.getSession(true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        try {
            if (request.getParameter("firstname").equals("") || request.getParameter("lastname").equals("")
                    || request.getParameter("dateofbirth").equals("") || request.getParameter("emailaddress").equals("")
                    || request.getParameter("gender").equals("") || request.getParameter("contact").equals("")
                    || request.getParameter("address").equals("") || request.getParameter("city").equals("")
                    || request.getParameter("state").equals("") || request.getParameter("zipcode").equals("")) {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("200"));
            }

            if (request.getParameter("maximumclaimableamount") == null) {
                throw new CMSBusinessException(PropertyUtil.getCMSMessages("200") + PropertyUtil.getCMSMessages("234") + PropertyUtil.getCMSMessages("233"));
            }
            HttpSession getMemberIDSession = request.getSession(false);
            ProfileUpdateTO profileUpdateTO = new ProfileUpdateTO();
            profileUpdateTO.setMemberid(getMemberIDSession.getAttribute("memberid").toString());
            profileUpdateTO.setFirstname(request.getParameter("firstname"));
            profileUpdateTO.setLastname(request.getParameter("lastname"));
            profileUpdateTO.setDateofbirth(request.getParameter("dateofbirth"));
            profileUpdateTO.setEmailaddress(request.getParameter("emailaddress"));
            profileUpdateTO.setGender(request.getParameter("gender"));
            profileUpdateTO.setContactnumber(request.getParameter("contact"));
            profileUpdateTO.setAddress(request.getParameter("address"));
            profileUpdateTO.setCity(request.getParameter("city"));
            profileUpdateTO.setState(request.getParameter("state"));
            profileUpdateTO.setZipcode(request.getParameter("zipcode"));
            profileUpdateTO.setInsuranceType(request.getParameter("insurancetype"));
            profileUpdateTO.setMaximumclaimableamount(Double.valueOf(request.getParameter("maximumclaimableamount")));
            

            if (new ProfileUpdateFacade().updateProfile(profileUpdateTO)) {
                errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("163"));
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
        updateMemberDetails(request, response);
    }

}
