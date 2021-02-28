<%-- 
    Document   : userhome
    Created on : Sep 19, 2016, 5:21:50 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/CommonCSS.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/userhome.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>
	<%
		HttpSession getMemberID = request.getSession(false);
	%>
	<div class=header>
		<h1>
			<label>Hi, <%=getMemberID.getAttribute("memberid")%></label>
		</h1>
	</div>

	<div class="paragraph">
		<p>
			<span>Welcome to Claim Management System.</span><br> You can
			Request Claim, View profile.<br> Also, you can Update your
			profile.
		</p>
	</div>


	<div class="footerdiv">
		<jsp:include page="Footer.jsp" flush="true"></jsp:include></div>
</body>
</html>
