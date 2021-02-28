$(document).ready(function () {

    $('.dateofbirth').datepicker({
        format: "dd/mm/yyyy"
    });

});
function hideContent() {
    document.getElementById('errorlabel').style.visibility = "hidden";
}

function checkFirstName() {
    hideContent();
    var fname = document.forms["registration"]["firstname"].value;
    if (fname == "") {
        document.getElementById('i1').title = "Please Enter First Name";
        document.getElementById('i1').style.visibility = "visible";
        return false;
    }
    if (/^[A-z]+$/.test(fname)) {
        document.getElementById('i1').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i1').title = "FirstName must be alphabetic";
    document.getElementById('i1').style.visibility = "visible";

    return false;

}
function checkLastName() {
    hideContent();
    var lname = document.forms["registration"]["lastname"].value;
    if (lname == "") {
        document.getElementById('i2').title = "Please Enter Last Name";
        document.getElementById('i2').style.visibility = "visible";
        return false;
    }
    if (/^[A-z]+$/.test(lname)) {
        document.getElementById('i2').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i2').title = "LastName must be alphabetic";
    document.getElementById('i2').style.visibility = "visible";

    return false;

}
function checkDOB() {
    hideContent();
    var dob = document.forms["registration"]["dateofbirth"].value;
    if (dob == "") {
        document.getElementById('i3').title = "Please Enter Date Of Birth";
        document.getElementById('i3').style.visibility = "visible";
        return false;
    }
    document.getElementById('i3').style.visibility = "hidden";
    return true;

}
function checkEmailAddress() {
    hideContent();
    var email = document.forms["registration"]["emailaddress"].value;
    if (email == "") {
        document.getElementById('i4').title = "Please Enter EmailID";
        document.getElementById('i4').style.visibility = "visible";
        return false;
    }
    if (/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i.test(email)) {
        document.getElementById('i4').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i4').title = "Enter Valid Email ID";
    document.getElementById('i4').style.visibility = "visible";

    return false;


}
function checkContactNumber() {
    hideContent();
    var contactNo = document.forms["registration"]["contact"].value;
    if (contactNo == "") {
        document.getElementById('i5').title = "Please Enter Contact Number";
        document.getElementById('i5').style.visibility = "visible";
        return false;
    }
    if (/[A-z]+/.test(contactNo)) {
        document.getElementById('i5').title = "Contact Number can only be numeric";
        document.getElementById('i5').style.visibility = "visible";
        return false;
    }
    if (/^[0-9]{10,10}$/.test(contactNo)) {
        document.getElementById('i5').style.visibility = "hidden";
        return true;
    }

    if (contactNo.length != 10) {
        document.getElementById('i5').title = "Contact Number must be 10 digits";
        document.getElementById('i5').style.visibility = "visible";
        return false;
    }

}
function checkPassword() {
    hideContent();

    var password = document.forms["registration"]["password"].value;
    if (password == "") {
        document.getElementById('i6').title = "Please Enter Password";
        document.getElementById('i6').style.visibility = "visible";
        return false;
    }
    if (password.length <= 3) {
        document.getElementById('i6').title = "Password must be greater than 3!";
        document.getElementById('i6').style.visibility = "visible";

        return false;
    }
    document.getElementById('i6').style.visibility = "hidden";
    return true;

}
function checkConfirmPassword() {
    hideContent();
    var password = document.forms["registration"]["password"].value;
    var checkPassword = document.forms["registration"]["confirmpassword"].value;
    if (password != checkPassword) {
        document.getElementById('i7').title = "Password donot match";
        document.getElementById('i7').style.visibility = "visible";
        return false;
    }
    document.getElementById('i7').style.visibility = "hidden";
    return true;
}
function checkForm() {
    var status = false;
    if (checkFirstName()) {
        if (checkLastName()) {
            if (checkDOB()) {
                if (checkEmailAddress()) {
                    if (checkContactNumber()) {
                        if (checkPassword()) {
                            if (checkConfirmPassword()) {
                                status = true;
                            }
                        }
                    }
                }
            }
        }

    }
    return status;
}