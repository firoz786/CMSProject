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

/*import org.omg.PortableServer.ServantActivatorHelper;*/
import com.cms.dao.SearchClaimDAO;
import com.cms.to.SearchClaimTO;
import com.cms.exception.CMSBusinessException;
import com.cms.exception.DatabaseException;
import com.cms.facade.SearchClaimFacade;
import com.cms.util.PropertyUtil;



/**
 * @author Aeishwary Gupta
 *
 */
public class SearchClaimAction extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public static final Logger LOGGER = Logger.getLogger(SearchClaimAction.class);

    /**
     * 
     */
    public SearchClaimAction() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SearchClaimTO searchclaimDTO = new SearchClaimTO();
        HttpSession seachClaimSession = request.getSession(true);
        HttpSession errorMessage = request.getSession();
        searchclaimDTO.setMemberID(request.getParameter("memberid"));
        searchclaimDTO.setRequestDate(request.getParameter("requestdate"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        try {
            if (new SearchClaimFacade().searchClaim(searchclaimDTO)) {
                seachClaimSession.setAttribute("seachClaimDTO", searchclaimDTO);
                dispatcher = request.getRequestDispatcher("SearchClaim.jsp");
            } else {
                errorMessage.setAttribute("errorMessage", PropertyUtil.getCMSMessages("164"));
                dispatcher = request.getRequestDispatcher("SearchClaim.jsp");
            }
        } catch (CMSBusinessException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("SearchClaim.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } catch (DatabaseException e) {
            errorMessage.setAttribute("errorMessage", e.getMessage());
            dispatcher = request.getRequestDispatcher("SearchClaim.jsp");
            LOGGER.info("Happened at class" + this.getClass().getName()+" at "+Calendar.getInstance().getTime()+" -" + e.getMessage());
        } finally {
            dispatcher.forward(request, response);
        }
    }
    
}
