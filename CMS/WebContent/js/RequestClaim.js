$(document).ready(function () {

    $("#insurancetype2").change(function () {

        var val = $(this).val();
        if (val == 'Vechile') {
            $("#subinsurancetype2").html("<option value=''>--Reason--</option><option value='Repair'>Repair</option><option value='Stolen'>Stolen</option>");
        } else if (val == "Life") {
            $("#subinsurancetype2").html("<option value=''>--Reason--</option><option value='Treatment'>Treatment</option><option value='Death'>Death</option>");
        } else if (val == "Home") {
            $("#subinsurancetype2").html("<option value=''>--Reason--</option><option value='Renovate' >Renovate</option><option value='Destroyed' >Destroyed</option>");
        }
    });


});
function getAmountDetails(value) {
    document.getElementById('subinsurancetypehidden').value = value;
    document.getElementById('insurancetype2hidden').value = document.getElementById('insurancetype2').value;
    document.getElementById('finalclaimformsubmit').submit();
    return true;
}
