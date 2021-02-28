

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.cms.util.PropertyUtil"%>
<%@page import="com.cms.to.JSPProfileUpdateTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   
    <head>
        <%
            HttpSession timeStampSession = request.getSession(false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            if (timeStampSession.getAttribute("memberid") != null) {
                if (timeStampSession.getAttribute("timeStamp") == null || timeStampSession.getAttribute("timeStamp").toString().equals("first")) {
                    timeStampSession.setAttribute("timeStamp", "second");
                    dispatcher = request.getRequestDispatcher("getMemberProfileDetails");
                    dispatcher.forward(request, response);
                } else {
                    timeStampSession.setAttribute("timeStamp", "first");
                }
            } else {
                timeStampSession.setAttribute("errorMessage", PropertyUtil.getCMSMessages("229"));
                dispatcher = request.getRequestDispatcher("Welcome.jsp");
                dispatcher.forward(request, response);
            }

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Profile Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CommonCSS.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ProfileUpdate.css">
        <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/ProfileUpdate.js"></script>
   </head>
<body>
    <%            HttpSession jspProfileTOSession = request.getSession(false);
        JSPProfileUpdateTO jSPProfileUpdateTO = (JSPProfileUpdateTO) jspProfileTOSession.getAttribute("jspProfileUpdateTO");
        

    %>


    <div><jsp:include page="Header.jsp" flush="true"></jsp:include>
            <form name="profileupdate" action='updateprofile' method='post' onsubmit="return checkForm()">
                <div class="profilecontainer">
                    <div class="profilelabel">
                        <label> Update Your Details </label>
                    </div>
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
                <!-- All the data need to be fetched from database -->
                <div class="inputs">
                    <input id="firstname" class="name" type="text" name="firstname"  onclick="hideContent()" onblur="return checkFirstName()" value="<%=jSPProfileUpdateTO.getFirstname()%>" placeholder="FirstName" /> <img id="i1" title=""/>
                    <input id="lastname" class="name" type="text" name="lastname" onclick="hideContent()" onblur="return checkLastName()" value="<%=jSPProfileUpdateTO.getLastname()%>" placeholder="LastName" /><img id="i2" title=""/>
                    <input class="dateofbirth"  onclick="hideContent()"  onblur="return checkDOB()" type="text" name="dateofbirth" value="<%=jSPProfileUpdateTO.getDateofbirth()%>"  placeholder="Date Of Birth"/> <img id="i3" title=""/>
                    <input class="emailaddress" onclick="hideContent()" onblur="return checkEmailAddress()" type="text" name="emailaddress" value="<%=jSPProfileUpdateTO.getEmailaddress()%>" placeholder="Email Address" /> <img id="i4" title=""/>
                    <div class="gender">
                        <%
                            if (jSPProfileUpdateTO.getGender().equalsIgnoreCase("Male")) {
                        %>
                        <input onclick="hideContent()" class="radio" type="radio" name="gender"  checked="checked" value="Male" />
                        <label class="radiolabel">Male</label> 
                        <input onclick="hideContent()" class="radio" type="radio" name="gender" value="Female" /> 
                        <label class="radiolabel">Female</label> 
                        <input  onclick="hideContent()" class="radio" type="radio" name="gender" value="Other" />
                        <label  onclick="hideContent()" class="radiolabel">Other</label>
                        <%
                        } else if (jSPProfileUpdateTO.getFirstname().equalsIgnoreCase("Female")) {
                        %>
                        <input  onclick="hideContent()" class="radio" type="radio" name="gender"  value="Male" />
                        <label  class="radiolabel">Male</label> 
                        <input  onclick="hideContent()" class="radio" type="radio" name="gender" checked="checked"  value="Female" /> 
                        <label  class="radiolabel">Female</label> 
                        <input  onclick="hideContent()" class="radio" type="radio" name="gender" value="Other" />
                        <label  class="radiolabel">Other</label>
                        <%
                        } else {
                        %>
                        <input onclick="hideContent()"  class="radio" type="radio" name="gender"  value="Male" />
                        <label  class="radiolabel">Male</label> 
                        <input onclick="hideContent()"  class="radio" type="radio" name="gender" value="Female" /> 
                        <label  class="radiolabel">Female</label> 
                        <input onclick="hideContent()"  class="radio" type="radio" name="gender"  checked="checked" value="Other" />
                        <label  class="radiolabel">Other</label>
                        <%
                            }
                        %>
                    </div>
                    <%
                        if (jSPProfileUpdateTO.getContactnumber() != null) {

                    %>
                    <input class="contact" type="text" onclick="hideContent()" onblur="return checkContactNumber()"  name="contact" value="<%=jSPProfileUpdateTO.getContactnumber()%>" placeholder="Contact Number" /> <img id="i5" title=""/>
                    <%
                    } else {

                    %>
                    <input class="contact" type="text" onclick="hideContent()" onblur="return checkContactNumber()"  name="contact" value="" placeholder="Contact Number" /> <img id="i5" title=""/>
                    <%                        }

                    %>
                    <%                          if (jSPProfileUpdateTO.getAddress() != null) {

                    %>
                    <textarea class="address" onclick="hideContent()" onblur="return checkAddress()"  name="address" placeholder="Address" value="<%=jSPProfileUpdateTO.getAddress()%>"><%=jSPProfileUpdateTO.getAddress()%></textarea><img id="i6" title=""/>
                    <%                        } else {
                    %>
                    <textarea class="address" onclick="hideContent()" onblur="return checkAddress()"  name="address" placeholder="Address" value=""></textarea><img id="i6" title=""/>
                    <%
                        }

                    %>
                    <%                          if (jSPProfileUpdateTO.getCity() != null) {

                    %>
                    <input class="city" type="text" onclick="hideContent()"  onblur="return checkCity()"  name="city" value="<%=jSPProfileUpdateTO.getCity()%>" placeholder="City" /> <img id="i7" title=""/>
                    <%                        } else {
                    %>
                    <input class="city" type="text" onclick="hideContent()"  onblur="return checkCity()"  name="city" value="" placeholder="City" /> <img id="i7" title=""/>
                    <%
                        }

                    %>
                    <%                          if (jSPProfileUpdateTO.getState() != null) {

                    %>
                    <input class="state" type="text" onclick="hideContent()" onblur="return checkState()"   name="state" value="<%=jSPProfileUpdateTO.getState()%>" placeholder="State" /> <img id="i8" title=""/>
                    <%                        } else {
                    %>
                    <input class="state" type="text" onclick="hideContent()" onblur="return checkState()"   name="state" value="" placeholder="State" /> <img id="i8" title=""/>
                    <%
                        }

                    %>
                    <%                          if (jSPProfileUpdateTO.getZipcode() != null) {

                    %>
                    <input class="zipcode" type="text" onclick="hideContent()" onblur="return checkState()"   name="zipcode" value="<%=jSPProfileUpdateTO.getZipcode()%>" placeholder="Zipcode" /> <img id="i8" title=""/>
                    <%                        } else {
                    %>
                    <input class="zipcode" type="text" onclick="hideContent()" onblur="return checkState()"   name="zipcode" value="" placeholder="Zipcode" /> <img id="i8" title=""/>
                    <%
                        }

                    %>




                    <!--Fetched from database-->
                    <div class="insurancetypediv">
                        <%                            HttpSession insuranceAmountSession = request.getSession(false);
                            if (insuranceAmountSession.getAttribute("insurancetype") == null) {
                        %>
                        <select onchange="getInsuredAmount(value)" onclick="hideContent()" id="insurancetype" required name="insurancetype" class="insurancetype">
                            <option selected disabled hidden value="">--Type--</option>
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
                        } else {
                        %>
                        <select onchange="getInsuredAmount(value)" id="insurancetype" onclick="hideContent()" required name="insurancetype" class="insurancetype">
                            <option selected hidden value="<%=insuranceAmountSession.getAttribute("insurancetype")%>"><%=insuranceAmountSession.getAttribute("insurancetype")%></option>
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
                                insuranceAmountSession.setAttribute("insurancetype", null);
                            }
                        %>
                        <!-- Fetched from database-->
                        <%
                            if (insuranceAmountSession.getAttribute("insuranceamount") != null) {
                        %>
                        <input  class="insuranceamount" disabled="true" type="text" name="insuranceamount" value="<%=insuranceAmountSession.getAttribute("insuranceamount")%>"/> 
                        <%
                                insuranceAmountSession.setAttribute("insuranceamount", null);
                            }
                        %>
                    </div>
                    <%
                        HttpSession maximumClaimableAmountSession = request.getSession(false);
                        if (maximumClaimableAmountSession.getAttribute("maximumclaimableamount") != null) {
                    %>
                    <input    class="maxclaimableamount" type="text" name="maximumclaimableamount" value="<%=insuranceAmountSession.getAttribute("maximumclaimableamount")%>" placeholder="Maximum Claimable Amount" /> <img id="i11" title=""/>
                    <%
                        maximumClaimableAmountSession.setAttribute("maximumclaimableamount", null);
                    } else {
                    %>
                    <input    class="maxclaimableamount" type="text" name="maximumclaimableamount"  placeholder="Maximum Claimable Amount" /> <img id="i11" title=""/>
                    <%
                        }
                    %>



                </div>
                <div class="buttoncontainer">
                    <input  id="submit"  type="submit" class="submit" name="registrationbutton" value="Update"/>
                    <input type="reset" class="reset"  value="Reset"/>
                </div>

                <div class="errorlabel"></div>
            </div>
        </form>

        <div class="nomineecontainer">
            <div class="nomineelabel">
                <label>Update Your Nominee Details</label>
            </div>
            <div class="nomineenamesdiv">
                <img  class="nomineenamesbutton"/>
                <div><input onclick="hideContent()" id="nomineenameinput" onblur="return checkNomineeName1()"  class="nomineenames" value="" placeholder="Nominee Name" type="text" name="nomineenameinput1"></div><img id="i10" title=""/>
            </div>

            <div>
                <select class="nomineenamelist"  name="nomineenamelist" onchange="removeNomineeName(value)">
                    <option value="">--Remove Nominee--</option>
                    <%
                        HttpSession insuranceTypeSession = request.getSession(false);
                        HttpSession nomineeNameSession = request.getSession(false);
                        if (nomineeNameSession.getAttribute("nomineeNameList") != null) {
                            ArrayList<String> nomineeNameList = (ArrayList) nomineeNameSession.getAttribute("nomineeNameList");
                            if (nomineeNameList.size() == 0) {
                    %>
                    <option disabled>No Nominee</option>
                    <%
                    } else {
                        for (int i = 0; i < nomineeNameList.size(); i++) {
                    %>
                    <option value="<%=nomineeNameList.get(i)%>"><%=nomineeNameList.get(i)%></option>
                    <%
                                }
                            }
                            nomineeNameList.clear();
                        }

                        nomineeNameSession.setAttribute("nomineeNameList", null);
                    %>
                </select>
            </div>
            <div class="insurancetypediv2">
                <%if (insuranceTypeSession.getAttribute("insurancetype2") != null) {%>
                <select onchange="getNomineeName(value)" id="insurancetype2" onclick="hideContent()" required name="insurancetype2" class="insurancetype2">
                    <option  value="<%=insuranceTypeSession.getAttribute("insurancetype2")%>"><%=insuranceTypeSession.getAttribute("insurancetype2")%></option>
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
                    insuranceTypeSession.setAttribute("insurancetype2",null);
                } else {
                %>
                <select onchange="getNomineeName(value)" id="insurancetype2" onclick="hideContent()" required name="insurancetype2" class="insurancetype2">
                    <option selected disabled hidden >--Type--</option>
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
                    }
                %>


            </div>
        </div>
        <form id="submitonchange" action="fetchinsuranceamount" method="get">
            <input type="hidden" id="insuredamount" name="insurancetype" value=""/>
        </form>
        <form id="getnomineenames" action="fetchnomineenames" method="get">
            <input type="hidden" id="nomineelist" name="nomineelist" value=""/>
        </form>
        <form id="addnomineename" action="addnewnominee" method="post">
            <input type="hidden" id="anomineename" name="anomineename"/>
            <input type="hidden" id="nomineenameinsurancetype" name="nomineenameinsurancetype"/>
        </form>
        <form id="removenomineename" action="removenominee" method="post">
            <input type="hidden" id="rnomineename" name="rnomineename"/>
            <input type="hidden" id="rinsurancetypeinput" name="rinsurancetype"/>
        </form>
        <jsp:include page="Footer.jsp" flush="true"></jsp:include>
</body>
</html>