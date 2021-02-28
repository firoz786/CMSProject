<%-- 
    Document   : MemberRegistration
    Created on : 3 Sep, 2016, 9:35:50 AM
    Author     : Rishabh Gupta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CommonCSS.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/MemberRegistration.css">
        <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/MemberRegistration.js"></script>

        <title>Member Registration</title>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>

            <div class="paragraphcontainer">
                
            </div>

            <form name="registration" action="registernewmember" method='post' onsubmit="return checkForm()">
                <div class="registrationcontainer">
                    <div class="registrationlabel">
                        <label>
                            Create a Free Account
                        </label>
                    </div>
                    <div class="inputs">
                        <input class="name" type="text" name="firstname" value="" placeholder="FirstName" onclick="hideContent()" onblur="return checkFirstName()"/><img id="i1" title=""/>
                        <input class="name" type="text" name="lastname" value="" placeholder="LastName" onclick="hideContent()" onblur="return checkLastName()" /> <img id ="i2"  title=""/>

                        <div class="gender" > 
                            <input onclick="hideContent()"  class="radio" required type="radio" name="gender" value="Male"/><label class="radiolabel">Male</label>
                            <input  onclick="hideContent()"  class="radio" required  type="radio" name="gender" value="Female"/><label class="radiolabel">Female</label>
                            <input  onclick="hideContent()"  class="radio"  required type="radio" name="gender" value="Other"/><label class="radiolabel">Other</label>
                        </div>
                        <input class="dateofbirth" onclick="hideContent()"  type="text" name="dateofbirth" value="" placeholder="Date Of Birth" id="dateofbirth"  onblur="return checkDOB()" /> <img id ="i3"  title=""/>
                        <input class="emailaddress" type="text" onclick="hideContent()"  name="emailaddress" value="" placeholder="Email Address" onblur="return checkEmailAddress()" /> <img id ="i4"  title=""/>
                        <input class="contact" type="text" name="contact" value="" onclick="hideContent()"  placeholder="Contact Number" onblur="return checkContactNumber()" /> <img id ="i5"  title=""/>

                        <input class="password" type="password" name="password" value="" onclick="hideContent()"  placeholder="Password" onblur="return checkPassword()" /> <img id ="i6" title=""/>
                        <input class="password" onclick="hideContent()"  type="password" name="confirmpassword" value="" placeholder="Confirm Password" onblur="return checkConfirmPassword()" /> <img id ="i7" title=""/>
                    </div>
                    <div class="buttoncontainer">
                        <input type="submit" class="submit" name="registrationbutton" value="Register"/>
                        <input type="reset" class="reset"  value="Reset"/>
                    </div>



                </div>
            </form>
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
        <jsp:include page="Footer.jsp" flush="true"></jsp:include>
    </body>
</html>
