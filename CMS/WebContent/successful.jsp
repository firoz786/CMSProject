<%-- 
    Document   : successful
    Created on : Sep 21, 2016, 11:44:25 AM
    Author     : Rishabh
--%>

<%@page import="com.cms.to.MemberRegistrationTO"%>
<%@page import="com.cms.util.PropertyUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CommonCSS.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/successful.css">
        <title>Success!!!</title>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>
            <div class="successlabel">
                <label>Successfull!!!</label>
            </div>
            <div class="registerid">
                <label>
                <%
                    HttpSession memberRegistrationTOSession = request.getSession(false);
                    MemberRegistrationTO memberRegistrationTO = (MemberRegistrationTO) memberRegistrationTOSession.getAttribute("memberRegistrationTO");
                %>
                <%=PropertyUtil.getCMSMessages("100")%>
                <%=PropertyUtil.getCMSMessages("101")%>
                <%=PropertyUtil.getCMSMessages("102")%>
                <%=PropertyUtil.getCMSMessages("110")%>
                <span><b><%= memberRegistrationTO.getMemberID()%></b></span>


            </label>
        </div>
        <jsp:include page="Footer.jsp" flush="true"></jsp:include>
    </body>
</html>
