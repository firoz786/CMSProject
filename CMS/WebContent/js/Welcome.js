function hideContent() {
    document.getElementById('errorlabel').style.visibility = "hidden";

}

function checkMemberID() {
    hideContent();
    var mid = document.forms["login"]["memberid"].value;
    if (mid == "") {
        document.getElementById('errorlabel').innerHTML = "Please enter the required fields!";
        document.getElementById('errorlabel').style.visibility = "visible";
        return false;
    }
    if (/^[M]{1,1}[B]{1,1}[C]{1,1}[-]{1,1}[0-9]{5,5}$/.test(mid)) {
        return true;
    } else {
        document.getElementById('errorlabel').innerHTML = "Invalid MemberID!";
        document.getElementById('errorlabel').style.visibility = "visible";
        return false;
    }


}
function checkPassword() {

    var password = document.forms["login"]["password"].value;
    if (password == "") {
        document.getElementById('errorlabel').innerHTML = "Please enter the required fields!";
        document.getElementById('errorlabel').style.visibility = "visible";
        return false;
    }
    if (password.length <= 3) {
        document.getElementById('errorlabel').innerHTML = "Password must be greater than 3!!";
        document.getElementById('errorlabel').style.visibility = "visible";
        return false;
    }

    return true;
}
function checkForm() {
    if (checkMemberID()) {
        if (checkPassword()) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}