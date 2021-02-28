<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="com.cms.to.ClaimProcessTO"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/CommonCSS.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/ClaimProcess.css">
<title>Claim Process</title>
</head>
<body>
	<div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>
	<div class="card">
		<div class="searchlabel">
			<label> Search Here!! </label>
		</div>
		<div class="searchbox">
			<form name="ClaimProcess" class="form" action="processclaim"
				method="post">
				<input type="text" class="name" required="required"
					name="memberid" placeholder="MemberID"> <input
					type="submit" class="submit" value="Submit"> <input
					type="reset" class="reset" value="Reset">
			</form>
		</div>
	</div>
	<%
		HttpSession ClaimProcessSession = request.getSession(false);
		if (ClaimProcessSession.getAttribute("claimProcessTO") != null) {
			ClaimProcessTO claimprocessDTO = (ClaimProcessTO) ClaimProcessSession.getAttribute("claimProcessTO");
			
	%>
	<form name="ClaimAction" action="statusupdate" method="get">
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
						<th>Approve</th>
						<th>Reject</th>
					</tr>
					<tr>

						<%
							if (claimprocessDTO.getClaimId() != null) {
						%>

						<td><%=claimprocessDTO.getClaimId()%></td>
						<%
							}
						%>


						<%
							if (claimprocessDTO.getMemberID() != null) {
						%>

						<td><%=claimprocessDTO.getMemberID()%></td>
						<%
							}
						%>

						<%
							if (claimprocessDTO.getInsurancetypeId() != null) {
						%>

						<td><%=claimprocessDTO.getInsurancetypeId()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getClaimreason() != null) {
						%>

						<td><%=claimprocessDTO.getClaimreason()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getDateofapproval() != null) {
						%>

						<td><%=claimprocessDTO.getDateofapproval()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getRequestDate() != null) {
						%>

						<td><%=claimprocessDTO.getRequestDate()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getFinalclaimamount() != 0) {
						%>

						<td><%=claimprocessDTO.getFinalclaimamount()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getStatus() != null) {
						%>

						<td><%=claimprocessDTO.getStatus()%></td>
						<%
							}
						%>
						<%
							if (claimprocessDTO.getClaimId() != null) {
						%>
						<td><input type="submit" name="Approve" value="Approve"></td>

						<td><input type="submit" name="Reject" value="Reject"></td>

						<%
							}
						%>
						<%
							}
						%>
					</tr>
				</table>
			</div>
		</div>
	</form>

	<jsp:include page="Footer.jsp" flush="true"></jsp:include>
</body>
</html>