<%@page import="com.cms.util.PropertyUtil"%>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.cms.to.JSPProfileUpdateTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	HttpSession timeStampSession = request.getSession(false);
	RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	if (timeStampSession.getAttribute("memberid") != null) {
		if (timeStampSession.getAttribute("timeStamp2") == null
				|| timeStampSession.getAttribute("timeStamp2").toString().equals("first")) {
			timeStampSession.setAttribute("timeStamp2", "second");
			dispatcher = request.getRequestDispatcher("getmemberdetails");
			dispatcher.forward(request, response);
		} else {
			timeStampSession.setAttribute("timeStamp2", "first");
		}
	} else {
		timeStampSession.setAttribute("errorMessage", PropertyUtil.getCMSMessages("229"));
		dispatcher = request.getRequestDispatcher("Welcome.jsp");
		dispatcher.forward(request, response);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/CommonCSS.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/RequestClaim.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/RequestClaim.js"></script>
<title>Request Claim</title>
<%
	HttpSession insuranceTypeSession = request.getSession(false);
	HttpSession jspProfileTOSession = request.getSession(false);
	JSPProfileUpdateTO jSPProfileUpdateTO = (JSPProfileUpdateTO) jspProfileTOSession
			.getAttribute("jspProfileUpdateTO");
%>
</head>
<body>
	<div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>

	<div class="requestclaimcontainer">
		<div class="requestclaimlabel">
			<label>Request Claim</label>
		</div>
		<div id="errorlabel">
			<%
				HttpSession errorMessage = request.getSession(false);
				String errorMessageString = (String) errorMessage.getAttribute("errorMessage");
				if (errorMessageString != null) {
			%>

			<%=errorMessageString%>

			<%
				}
				errorMessage.setAttribute("errorMessage", null);
			%>
		</div>

		<form name="requestclaimform" class="requestclaimform"
			action="requestclaim" method="post">
			<input class="name" id="memberid" type="text" name="memberid"
				value="<%=timeStampSession.getAttribute("memberid")%>"
				placeholder="MemberID" onclick="hideContent()"
				onblur="return checkMemberID()" /> <img id="i1" title="" /> <input
				class="name" id="firstname" type="text" name="firstname"
				value="<%=jSPProfileUpdateTO.getFirstname()%>"
				placeholder="FirstName" onclick="hideContent()"
				onblur="return checkFirstName()" /><img id="i2" title="" /> <input
				class="name" id="lastname" type="text" name="lastname"
				value="<%=jSPProfileUpdateTO.getLastname()%>" placeholder="LastName"
				onclick="hideContent()" onblur="return checkLastName()" /> <img
				id="i3" title="" />
			<div class="insurancetypediv2">
				<%
					if (insuranceTypeSession.getAttribute("insurancetype2") != null) {
				%>
				<select id="insurancetype2" onchange="getSubDetails(value)"
					onclick="hideContent()" required name="insurancetype2"
					class="insurancetype2">
					<option
						value="<%=insuranceTypeSession.getAttribute("insurancetype2")%>"><%=insuranceTypeSession.getAttribute("insurancetype2")%></option>
					<%
						Set insuraceTypeSet = jSPProfileUpdateTO.getInsuranceTypeMap().entrySet();
							Iterator iterator = insuraceTypeSet.iterator();
							while (iterator.hasNext()) {
								Map.Entry entry = (Map.Entry) iterator.next();
					%>
					<option value="<%=entry.getKey()%>"><%=entry.getKey()%></option>

					<%
						}
					%>
				</select>
				<%
					insuranceTypeSession.setAttribute("insurancetype2", null);
					} else {
				%>
				<select id="insurancetype2" onclick="hideContent()" required
					name="insurancetype2" class="insurancetype2">
					<option value="">--Type--</option>
					<%
						Set insuraceTypeSet = jSPProfileUpdateTO.getInsuranceTypeMap().entrySet();
							Iterator iterator = insuraceTypeSet.iterator();
							while (iterator.hasNext()) {
								Map.Entry entry = (Map.Entry) iterator.next();
					%>
					<option value="<%=entry.getKey()%>"><%=entry.getKey()%></option>

					<%
						}
						}
					%>
				</select>
				<%
					if (timeStampSession.getAttribute("subinsurancetypevalue") != null) {
				%>
				<select onchange="getAmountDetails(value)" required
					class="subinsurancetype2" id="subinsurancetype2"
					name="subinsurancetype2">
					<option
						value="<%=timeStampSession.getAttribute("subinsurancetypevalue")%>"><%=timeStampSession.getAttribute("subinsurancetypevalue")%>
					</option>
				</select>
				<%
					timeStampSession.setAttribute("subinsurancetypevalue", null);
					} else {
				%>
				<select onchange="getAmountDetails(value)" required
					class="subinsurancetype2" id="subinsurancetype2">
					<option value="">-- Reason --</option>
				</select>
				<%
					}
				%>
			</div>

			<%
				
			%>
			<%
				HttpSession maximumClaimableAmountSession = request.getSession(false);
				if (maximumClaimableAmountSession.getAttribute("maximumclaimableamount") != null) {
			%>
			<input class="maxclaimableamount" type="text"
				name="maximumclaimableamount"
				value="<%=maximumClaimableAmountSession.getAttribute("maximumclaimableamount")%>"
				placeholder="Maximum Claimable Amount" /> <img id="i4" title="" />
			<%
				maximumClaimableAmountSession.setAttribute("maximumclaimableamount", null);
				} else {
			%>
			<input class="maxclaimableamount" type="text"
				name="maximumclaimableamount" placeholder="Maximum Claimable Amount" />
			<img id="i4" title="" />
			<%
				}
			%>
			<%
				Calendar cal = Calendar.getInstance();
				String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
						+ cal.get(Calendar.YEAR);
			%>
			<input class="dateofbirth" onclick="hideContent()"
				onblur="return checkDOB()" type="text" name="dateofbirth" value="<%=formatedDate %>"
				placeholder="Request Date" /> <img id="i5" title="" />


			<%
				HttpSession finalClaimAmountSession = request.getSession(false);
				if (finalClaimAmountSession.getAttribute("finalclaimableamount") != null) {
			%>
			<input class="finalclaimableamount" type="text"
				name="finalclaimableamount"
				value="<%=finalClaimAmountSession.getAttribute("finalclaimableamount")%>"
				placeholder="Final Claimable Amount" /> <img id="i6" title="" />
			<%
				finalClaimAmountSession.setAttribute("finalclaimableamount", null);
				} else {
			%>
			<input class="finalclaimableamount" type="text"
				name="finalclaimableamount" placeholder="final Claimable Amount" />
			<img id="i6" title="" />
			<%
				}
			%>
			<div class="buttoncontainer">
				<input type="submit" class="submit" name="registrationbutton"
					value="Register" /> <input type="reset" class="reset" value="Reset" />
			</div>


		</form>



	</div>
	<form id="finalclaimformsubmit" action="getamount" method="post">
		<input type="hidden" id="insurancetype2hidden"
			name="insurancetype2hidden" /> <input type="hidden"
			name="subinsurancetypehidden" id="subinsurancetypehidden" />
	</form>
	<jsp:include page="Footer.jsp" flush="true"></jsp:include>
</body>
</html>