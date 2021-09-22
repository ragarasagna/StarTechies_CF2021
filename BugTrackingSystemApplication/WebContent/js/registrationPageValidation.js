function printError(Id, Msg) {
    document.getElementById(Id).innerHTML = Msg;
}

function validateForm() {

    var passcheck = document.getElementById("passcheck").value;
    var email = document.getElementById("email").value;
    var pass = document.getElementById("psw").value;

    var emailErr = passErr = passcheckErr = true;
    if (email == "") {
        emailErr = true;
        printError("emailErr", "Please enter your email address");
        var elem = document.getElementById("email");
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {

        var regex = /^\S+@\S+\.\S+$/;
        if (regex.test(email) === false) {
            emailErr = true;
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


    if (pass == "") {
        printError("passErr", "Please enter your password");
        passErr = true;
        var elem = document.getElementById("psw");
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {
        var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
        if (regex.test(pass) === false) {
            printError("passErr", "Password must contain 8 to 15 characters and atleast one uppercase letter, atleast one lowercase letter, atleast one special symbol");
            passErr = true;
            var elem = document.getElementById("psw");
            elem.classList.add("input-2");
            elem.classList.remove("input-1");
        } else {
            printError("passErr", "");
            passErr = false;
            var elem = document.getElementById("psw");
            elem.classList.add("input-1");
            elem.classList.remove("input-2");
        }
    }

    if (passcheck == "") {
        printError("passcheckErr", "Please enter your password");
        var elem = document.getElementById("passcheck");
        passcheckErr = true;
        elem.classList.add("input-2");
        elem.classList.remove("input-1");
    } else {
        if (pass == passcheck) {
            printError("passcheckErr", "");
            passcheckErr = false;
            var elem = document.getElementById("passcheck");
            elem.classList.add("input-1");
            elem.classList.remove("input-2");
        } else {

            printError("passcheckErr", "Password is not matching");
            var elem = document.getElementById("passcheck");
            passcheckErr = true;
            elem.classList.add("input-2");
            elem.classList.remove("input-1");
        }
    }


    /*if (role == "Select Role") {
        printError("roleErr", "Please select your role");
        var elem = document.getElementById("role");
        elem.classList.add("input-4");
        elem.classList.remove("input-3");
    } else {
        printError("roleErr", "");
        roleErr = false;
        var elem = document.getElementById("role");
        elem.classList.add("input-3");
        elem.classList.remove("input-4");
    } */
    

    if ((emailErr || passErr || passcheckErr) == true) {
        return false;
    }
    else {
        return true;
    }
};