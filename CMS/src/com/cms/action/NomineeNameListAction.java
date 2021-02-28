package com.cms.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.NomineeNameFacade;
import com.cms.to.JSPProfileUpdateTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

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
@WebServlet(name = "NomineeName", urlPatterns = {"/fetchnomineenames"})
public class NomineeNameListAction extends HttpServlet {
	public static final Logger LOGGER = Logger.getLogger(NomineeNameListAction.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void getNomineeNames(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession errorMessage = request.getSession(true);
        RequestDispatcher dispatcher = null;
        HttpSession jspProfileTOSession = request.getSession(false);
        JSPProfileUpdateTO jSPProfileUpdateTO = (JSPProfileUpdateTO) jspProfileTOSession.getAttribute("jspProfileUpdateTO");
        HttpSession insuranceTypeSession = request.getSession(false);
        insuranceTypeSession.setAttribute("insurancetype2", request.getParameter("nomineelist"));
        jSPProfileUpdateTO.setInsuranceType(request.getParameter("nomineelist"));
        try {
            new NomineeNameFacade().getNomineeDetails(jSPProfileUpdateTO);
            ArrayList<String> nomineeNameList = new ArrayList<String>();
            if (jSPProfileUpdateTO.getNomineename1() != null) {
                nomineeNameList.add(jSPProfileUpdateTO.getNomineename1());
            }
            if (jSPProfileUpdateTO.getNomineename2() != null) {
                nomineeNameList.add(jSPProfileUpdateTO.getNomineename2());
            }
            if (jSPProfileUpdateTO.getNomineename3() != null) {
                nomineeNameList.add(jSPProfileUpdateTO.getNomineename3());
            }
            HttpSession nomineeNameSeeion = request.getSession(true);
            nomineeNameSeeion.setAttribute("nomineeNameList", nomineeNameList);
            dispatcher = request.getRequestDispatcher("ProfileUpdate.jsp");
        } catch (DatabaseException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("Welcome.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } finally {
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getNomineeNames(request, response);
    }

}
