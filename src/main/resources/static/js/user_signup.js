function validateForm() {
    var returnval = true;

    clearErrors();

    var fname = document.forms['signupform']["firstName"].value.trim();
    if (fname.length < 5) {
        seterror("fname", "*Invalid First Name.");
        returnval = false;
    }

    var lname = document.forms['signupform']["lastName"].value.trim();
    if (lname.length < 5) {
        seterror("lname", "*Invalid Last Name.");
        returnval = false;
    }

    var email = document.forms['signupform']["email"].value.trim();
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!email.match(mailformat) || email.length > 25) {
        seterror("email", "*Invalid E-mail.");
        returnval = false;
    }

    var pass = document.forms['signupform']["password"].value.trim();
    if (pass.length < 6) {
        seterror("password", "*Invalid Password");
        returnval = false;
    }

    var repass = document.forms['signupform']["repassword"].value.trim();
    if (repass != pass || repass === '') {
        seterror("repassword", "*Password not match.");
        returnval = false;
    }

    var add = document.forms['signupform']["address"].value.trim();
    if (add === '') {
        seterror("address", "*Enter Address");
        returnval = false;
    }

    var secans = document.forms['signupform']["secAnswer"].value.trim();
    if (secans === '') {
        seterror("answer", "*Security answer can't be empty");
        returnval = false;
    }

    var city = document.forms['signupform']["city"].value.trim();
    if (city === '') {
        seterror("city", "*Enter a valid City Name");
        returnval = false;
    }

    var mob = document.forms['signupform']["mobileNumber"].value.trim();
    var mobformat = /^\d{10}$/;
    if (!mob.match(mobformat)) {
        seterror("mobile", "*Mobile number must be 10 digits.");
        returnval = false;
    }

    return returnval;
}

function clearErrors() {
    errors1 = document.getElementsByClassName('formerror');
    for (let item of errors1) {
        item.innerHTML = "";
    }

    errors2 = document.getElementsByTagName('input');
    for (let item of errors2) {
        item.classList.remove("error");
    }
}



function seterror(id, error) {
    element = document.getElementById(id);
    element.getElementsByClassName('formerror')[0].innerHTML = error;
    element.getElementsByTagName('input')[0].classList.add("error");
}