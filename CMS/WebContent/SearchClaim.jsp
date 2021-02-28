<%@page import="com.cms.util.PropertyUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.cms.to.SearchClaimTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <%
            HttpSession memberIdSession = request.getSession(false);
            if (memberIdSession.getAttribute("memberid") == null) {
                memberIdSession.setAttribute("errorMessage", PropertyUtil.getCMSMessages("229"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
                dispatcher.forward(request, response);
            }

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/CommonCSS.css">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/SearchClaim.css">
        <title>Search Claim</title>

        <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/SearchClaim.js"></script>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" flush="true"></jsp:include>
                <div class="card">
                    <div class="searchlabel">
                        <label> Search Here!! </label>
                    </div>
                    <div class="inputs">
                        <div class="searchbox">
                            <form name="SearchClaim" class="form" action="SearchClaimAction" method="post">
                                <input type="text" class="name" required name="memberid" placeholder="Member-ID" value="<%=memberIdSession.getAttribute("memberid")%>"/> 
                            <input type="text" class="dateofbirth" required name="requestdate" placeholder="Request Date"/> 
                            <input type="submit" class="submit" action="" value="Submit"/> 
                            <input type="reset" class="reset" action="reset" value="Reset"/>
                        </form>
                        <div id="errorlabel">
                            <%  HttpSession errorMessage = request.getSession(false);
                                String errorMessageString = (String) errorMessage.getAttribute("errorMessage");
                                if (errorMessageString != null) {

                            %>

                            <%=errorMessageString%>

                            <%
                                }
                                errorMessage.setAttribute("errorMessage", null);

                            %>

                        </div>
                    </div>
                </div>
            </div>
            <%                HttpSession seachClaimSession = request.getSession(false);
                if (seachClaimSession.getAttribute("seachClaimDTO") != null) {
                    SearchClaimTO searchclaimDTO = (SearchClaimTO) seachClaimSession.getAttribute("seachClaimDTO");
            %>
        </div>
        <div class="card1">
            <div class="tabledata">
                <table border>
                    <tr>
                        <th>Claim-ID</th>
                        <th>Member-ID</th>
                        <th>Insurance Type ID</th>
                        <th>Claim Reason</th>
                        <th>Request Date</th>
                        <th>Date Of Approval</th>
                        <th>Final Claim Amount</th>
                        <th>Status</th>
                    </tr>
                    <tr>

                        <%                                if (searchclaimDTO.getClaimId() != null) {
                        %>

                        <td><%=searchclaimDTO.getClaimId()%></td>
                        <%
                            }
                        %>


                        <%
                            if (searchclaimDTO.getMemberID() != null) {
                        %>

                        <td><%=searchclaimDTO.getMemberID()%></td>
                        <%
                            }
                        %>

                        <%
                            if (searchclaimDTO.getInsurancetypeId() != null) {
                        %>

                        <td><%=searchclaimDTO.getInsurancetypeId()%></td>
                        <%
                            }
                        %>
                        <%
                            if (searchclaimDTO.getClaimreason() != null) {
                        %>

                        <td><%=searchclaimDTO.getClaimreason()%></td>
                        <%
                            }
                        %>
                        <%
                            if (searchclaimDTO.getDateofapproval() != null) {
                        %>

                        <td><%=searchclaimDTO.getDateofapproval()%></td>
                        <%
                            }
                        %>
                        <%
                            if (searchclaimDTO.getRequestDate() != null) {
                        %>

                        <td><%=searchclaimDTO.getRequestDate()%></td>
                        <%                              }
                        %>
                        <%
                            if (searchclaimDTO.getFinalclaimamount() != 0) {
                        %>

                        <td><%=searchclaimDTO.getFinalclaimamount()%></td>
                        <%
                            }
                        %>
                        <%
                            if (searchclaimDTO.getStatus() != null) {
                        %>

                        <td><%=searchclaimDTO.getStatus()%></td>
                        <%
                            }
                        %>

                        <%
                            }
                            seachClaimSession.setAttribute("seachClaimDTO", null);
                        %>
                    </tr>
                </table>

            </div>

            <%-- <jsp:include page="Footer.jsp" flush="true"></jsp:include> --%>
    </body>
</html>