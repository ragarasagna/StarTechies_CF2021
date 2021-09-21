/**
 * 
 */
function printError(Id, Msg) {
    document.getElementById(Id).innerHTML = Msg;
}

function validateForm() {

    var passcheck = document.Form.passcheck.value;
    var email = document.Form.email.value;
    var psw = document.Form.psw.value;
    var role = document.Form.role.value;
    var emailErr = passErr = roleErr = true;
    if (email == "") {
        printError("emailErr", "Please enter your email address");
        var elem = document.getElementById("email");
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {

        var regex = /^\S+@\S+\.\S+$/;
        if (regex.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
            var elem = document.getElementById("email");
            elem.classList.add("input-2");
            elem.classList.remove("input-1");
        } else {
            printError("emailErr", "");
            emailErr = false;
            var elem = document.getElementById("email");
            elem.classList.add("input-1");
            elem.classList.remove("input-2");

        }
    }


    if (psw == "") {
        printError("passErr", "Please enter your password");
        var elem = document.getElementById("psw");
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {
        var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
        if (regex.test(psw) === false) {
            printError("passErr", "Password must contain 8 to 15 characters and atleast one uppercase letter, atleast one lowercase letter, atleast one special symbol");
            var elem = document.getElementById("psw");
            elem.classList.add("input-2");
            elem.classList.remove("input-1");
        } else {
            printError("passErr", "");
            mobileErr = false;
            var elem = document.getElementById("psw");
            elem.classList.add("input-1");
            elem.classList.remove("input-2");
        }
    }

    if (passcheck == "") {
        printError("passcheckErr", "Please enter your password");
        var elem = document.getElementById("passcheck");
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {
        var p1 = document.getElementById("psw").value;
        var p2 = document.getElementById("passcheck").value;
        if (p1 == p2) {
            printError("passcheckErr", "");
            var elem = document.getElementById("passcheck");
            elem.classList.add("input-1");
            elem.classList.remove("input-2");
        } else {

            printError("passcheckErr", "Password is not matching");
            var elem = document.getElementById("passcheck");
            elem.classList.add("input-2");
            elem.classList.remove("input-1");
        }
    }


    if (role == "Select Role") {
        printError("roleErr", "Please select your role");
        var elem = document.getElementById("role");
        elem.classList.add("input-4");
        elem.classList.remove("input-3");
    } else {
        printError("roleErr", "");
        countryErr = false;
        var elem = document.getElementById("role");
        elem.classList.add("input-3");
        elem.classList.remove("input-4");
    }
    if ((emailErr || passErr || roleErr || passcheckErr) == true) {
        return false;
    }
};