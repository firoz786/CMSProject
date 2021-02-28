<%-- 
    Document   : Header
    Created on : 3 Sep, 2016, 11:08:13 PM
    Author     : Rishabh Gupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="icon" href="../Resources/icons/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="../Resources/icons/favicon.ico" type="image/x-icon"/>
</head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CommonCSS.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Header.css"/>
    <body>
        <div class="headercontainer">
            <div class="logo">
                <img src="Resources/images/logo.png" alt="Claim Management System"/>
            </div>
            <div id="cssmenu">
                <ul>
                    <li class='welcome'><a href='Welcome.jsp'>Home</a></li>
                    <li class='registration'><a href='MemberRegistration.jsp'>Registration</a></li>
                    <li class='profileupdate'><a href='ProfileUpdate.jsp'>Profile Update</a></li>
                    <li class='claimrequest'><a href='RequestClaim.jsp'>Request Claim</a></li>
                    <li class='claimprocess'><a href='ClaimProcess.jsp'>Process Claim</a></li>
                    <li class='searchclaim'><a href='SearchClaim.jsp'>Search Claim</a></li>
                    <li class='signout' ><a href="signout">Sign Out</a></li>
                    
                </ul>
            </div>
        </div>
    </body>
</html>
