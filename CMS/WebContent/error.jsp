<%-- 
    Document   : Error
    Created on : Sep 21, 2016, 11:44:25 AM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/CommonCSS.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/error.css">
<title>Error!!!</title>
</head>
<body>
	<div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>
	<div class="successlabel">
		<label>Bad Server Response!!!</label>
	</div>
	<div class="registerid">
		<label> <%
 	HttpSession errorSession = request.getSession(false);
 	if (errorSession.getAttribute("errorMessage") != null) {
 %> <span><b><%=errorSession.getAttribute("errorMessage")%></b></span>
			<%
				}
			%>




		</label>
	</div>
	<jsp:include page="Footer.jsp" flush="true"></jsp:include>
</body>
</html>

