
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%
            HttpSession memberid = request.getSession(false);
            if(memberid.getAttribute("memberid")!=null){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("userhome.jsp");
                requestDispatcher.forward(request, response);
            }

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CommonCSS.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Welcome.css">
        <script src="${pageContext.request.contextPath}/js/Welcome.js"></script>
        <title>Welcome</title>
    </head>
    <style type="text/css" medixa="screen">
    </style>
</head>
<body>
    <div><jsp:include page="Header.jsp" flush="true"></jsp:include></div>
        <div class="welcomeheadcontainer">
            <div class="headimage"><!--Check CSS for image --></div>

            <div class="logincontainer">
                <div class="loginlabel">
                    <label>
                        Login
                    </label>
                </div>
                <div class="subloginlabel">
                    <label>
                        <i>Enter Your Credentials</i>
                    </label>
                </div>
                <form name="login" action="${pageContext.request.contextPath}/checkuser" method="post" onsubmit="return checkForm()">
                <div class="inputs">
                    <input class="name" type="text" name="memberid" value="" placeholder="Member ID" title="memberid" onfocus="hideContent()"/>
                    <input class="password" type="password" name="password" value=""  placeholder="Password" onfocus="hideContent()" />
                    <!--forgetpassword link needs to be created-->
                    <div> <a  class="forgetpassword" href="">forget password?</a> </div>
                    <div class="buttoncontainer">
                        <input type="submit" class="submit" name="loginbutton" value="Login"/>
                        <input type="reset" class="reset"  value="Reset"/>
                    </div>

                </div>
            </form>
            <div id="errorlabel">
                <%                    HttpSession errorMessage = request.getSession(false);
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


    <div class="footerdiv"> <jsp:include page="Footer.jsp" flush="true"></jsp:include></div>


</body>
</html>