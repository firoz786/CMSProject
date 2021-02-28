/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.action;

import com.cms.facade.MemberRegistrationFacade;
import com.cms.facade.UserLoginFacade;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.util.PropertyUtil;
import com.cms.to.MemberRegistrationTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 *
 * @author Rishabh Gupta
 */
@WebServlet(name = "RegisterNewMember", urlPatterns = {"/registernewmember"})
public class MemberRegistrationAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(MemberRegistrationAction.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void registerNewMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = null;
        MemberRegistrationTO memberRegistrationTO = new MemberRegistrationTO();
        HttpSession errorMessage = request.getSession(true);
        try {
            if (request.getParameter("firstname").equals("") || request.getParameter("lastname").equals("")
                    || request.getParameter("gender").equals("") || request.getParameter("dateofbirth").equals("")
                    || request.getParameter("emailaddress").equals("") || request.getParameter("contact").equals("")
                    || request.getParameter("password").equals("")) {
                throw new NullPointerException(PropertyUtil.getCMSMessages("227"));
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            memberRegistrationTO.setFirstname(request.getParameter("firstname"));
            memberRegistrationTO.setLastname(request.getParameter("lastname"));
            memberRegistrationTO.setGender(request.getParameter("gender"));
            String date = request.getParameter("dateofbirth");
            dateFormat.format(new Date(date));
            memberRegistrationTO.setDateofbirth(date);
            memberRegistrationTO.setEmailaddress(request.getParameter("emailaddress"));
            memberRegistrationTO.setContactnumber(request.getParameter("contact"));
            memberRegistrationTO.setPassword(request.getParameter("password"));
            if (new MemberRegistrationFacade().registerMember(memberRegistrationTO)) {
                HttpSession memberRegistrationTOSession = request.getSession(true);
                memberRegistrationTOSession.setAttribute("memberRegistrationTO", memberRegistrationTO);

                dispatcher = request.getRequestDispatcher("successful.jsp");
            }
        } catch (IllegalArgumentException e) {
            errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("205"));
            dispatcher = request.getRequestDispatcher("MemberRegistration.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } catch (CMSBusinessException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("MemberRegistration.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());

        } catch (DatabaseException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("MemberRegistration.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } catch (NullPointerException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("MemberRegistration.jsp");
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
        registerNewMember(request, response);
    }

}
