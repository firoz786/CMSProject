
$(document).ready(function () {

//date picker
    $('.dateofbirth').datepicker({
        format: "dd/mm/yyyy"
    });
//Nominee Names Input Fields

    $(".nomineenamesbutton").click(function (e) { //on add input button click
        addNomineeName(document.getElementById("nomineenameinput").value);
    });


    //for reseting profile update fields
    $(".reset").click(
            function () {
                $(".insurancetype")[0].childNodes[1].text = '--Type--';
                $(".insurancetype")[0].childNodes[1].value = "";
                $(".maxclaimableamount").attr("value", "");
                $(".insuranceamount").css("display", "none");
                $(".removefield").parent('div').remove();
                x = 1;
            });

});

function removeNomineeName(value) {


    document.getElementById('rnomineename').value = value;
    document.getElementById('rinsurancetypeinput').value = document.getElementById('insurancetype2').value;
    document.getElementById("removenomineename").submit();
}
function addNomineeName(value) {


    if (document.getElementById('insurancetype2').value == "") {
        alert("Please Select Insurance Type");
        return false;
    }
    document.getElementById('anomineename').value = value;
    document.getElementById('nomineenameinsurancetype').value = document.getElementById('insurancetype2').value;
    document.getElementById("addnomineename").submit();
}

function getInsuredAmount(value) {
    document.getElementById('insuredamount').value = value;
    document.getElementById("submitonchange").submit();

}
function getNomineeName(value) {
    document.getElementById('nomineelist').value = value;
    document.getElementById("getnomineenames").submit();

}

function hideContent() {
    document.getElementById('errorlabel').style.visibility = "hidden";
}

function checkFirstName() {
    hideContent();
    var fname = document.forms["profileupdate"]["firstname"].value;
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
    var lname = document.forms["profileupdate"]["lastname"].value;
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
    var dob = document.forms["profileupdate"]["dateofbirth"].value;
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
    var email = document.forms["profileupdate"]["emailaddress"].value;
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
    var contactNo = document.forms["profileupdate"]["contact"].value;
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
function checkAddress() {
    hideContent();
    var address = document.forms["profileupdate"]["address"].value;
    if (address == "") {
        document.getElementById('i6').title = "Please Enter Address";
        document.getElementById('i6').style.visibility = "visible";
        return false;
    }
    document.getElementById('i6').style.visibility = "hidden";
    return true;
}

function checkCity() {
    hideContent();
    var city = document.forms["profileupdate"]["city"].value;
    if (city == "") {
        document.getElementById('i7').title = "Please Enter City";
        document.getElementById('i7').style.visibility = "visible";
        return false;
    }
    if (/^[A-z]+$/.test(city)) {
        document.getElementById('i7').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i7').title = "City Name must be alphabetic";
    document.getElementById('i7').style.visibility = "visible";
    return false;
}
function checkState() {
    hideContent();
    var state = document.forms["profileupdate"]["state"].value;
    if (state == "") {
        document.getElementById('i8').title = "Please Enter State";
        document.getElementById('i8').style.visibility = "visible";
        return false;
    }
    if (/^[A-z ]+$/.test(state)) {
        document.getElementById('i8').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i8').title = "State Name must be alphabetic";
    document.getElementById('i8').style.visibility = "visible";
    return false;
}
function checkZipcode() {
    hideContent();
    var zipcode = document.forms["profileupdate"]["zipcode"].value;
    if (zipcode == "") {
        document.getElementById('i9').title = "Please Enter Zipcode";
        document.getElementById('i9').style.visibility = "visible";
        return false;
    }
    if (/[A-z]+/.test(zipcode)) {
        document.getElementById('i9').title = "Zipcode can only be numeric";
        document.getElementById('i9').style.visibility = "visible";
        return false;
    }


    if (zipcode.length != 6) {
        document.getElementById('i9').title = "Zipcode must be 6 digits";
        document.getElementById('i9').style.visibility = "visible";
        return false;
    }
    if (/^[1-9][0-9]{5}$/.test(zipcode)) {
        document.getElementById('i9').style.visibility = "hidden";
        return true;
    } else {
        document.getElementById('i9').title = "First letter cannot be 0";
        return false;
    }

}
function checkNomineeName1() {
    hideContent();
    var nomineename1 = document.forms["profileupdate"]["nomineenameinput1"].value;
    if (nomineename1 == "") {
        document.getElementById('i10').title = "Please Enter Nominee Name";
        document.getElementById('i10').style.visibility = "visible";
        return false;
    }
    if (/^[A-z ]+$/.test(nomineename1)) {
        document.getElementById('i10').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i10').title = "Nominee Name must be alphabetic";
    document.getElementById('i10').style.visibility = "visible";
    return false;
}
function checkNomineeName2() {
    hideContent();
    var nomineename2 = document.forms["profileupdate"]["nomineenameinput2"].value;
    if (nomineename2 == "") {
        document.getElementById('i12').title = "Please Enter Nominee Name";
        document.getElementById('i12').style.visibility = "visible";
        return false;
    }
    if (/^[A-z ]+$/.test(nomineename2)) {
        document.getElementById('i12').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i12').title = "Nominee Name must be alphabetic";
    document.getElementById('i12').style.visibility = "visible";
    return false;
}
function checkNomineeName3() {
    hideContent();
    var nomineename3 = document.forms["profileupdate"]["nomineenameinput3"].value;
    if (nomineename3 == "") {
        document.getElementById('i13').title = "Please Enter Nominee Name";
        document.getElementById('i13').style.visibility = "visible";
        return false;
    }
    if (/^[A-z ]+$/.test(nomineename3)) {
        document.getElementById('i13').style.visibility = "hidden";
        return true;
    }

    document.getElementById('i13').title = "Nominee Name must be alphabetic";
    document.getElementById('i13').style.visibility = "visible";
    return false;
}


function checkForm() {
    var status = false;
    if (checkFirstName()) {
        if (checkLastName()) {
            if (checkDOB()) {
                if (checkEmailAddress()) {
                    if (checkContactNumber()) {
                        if (checkAddress()) {
                            if (checkCity()) {
                                if (checkState()) {
                                    if (checkZipcode()) {
                                        if (checkNomineeName1()) {
                                            if (checkNomineeName2()) {
                                                if (checkNomineeName3()) {
                                                    status = true;
                                                }
                                            }


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    return status;
}