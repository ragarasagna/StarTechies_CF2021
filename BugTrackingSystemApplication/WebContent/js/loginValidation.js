function printError(Id, Msg) {
    document.getElementById(Id).innerHTML = Msg;
}

function validateEmail()
{
	//var e=document.getElementById("email").value;
	 var email = document.getElementById("email").value;
	 var emailErr = true;
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
	    if ((emailErr) == true) {
	        return false;
	    }
	    else {
	        return true;
	    }
//	if(!e.match(/^\S+@\S+\.\S+$/))
//	{
//        document.getElementById("s1").innerHTML=" Please enter valid email"+"\n";
//        var e=document.getElementById("email").value;
//    	
//		
//	}
//	else
//	{
//		var e=document.getElementById("email").value;
//	}
}

function validatePassword()
{
	p=document.getElementById("psw").value;
	if(p == "" || p == null)
	{
        document.getElementById("s2").innerHTML="Please Enter password";
		return false;
	}
	else
	{
		return true;
	}		
	
}
function validate()
{
	if(validateEmail() && validatePassword())
	{
		return true;
	}
	else
	{
		return false;
	}
}