function validateForm()
{
    var x = document.forms["registerform"]["fname"].value;
    if (x === null || x === "")
    {
        alert("First name must be filled out");
        return false;
    }
    var x = document.forms["registerform"]["lname"].value;
    if (x === null || x === "")
    {
        alert("Last name must be filled out");
        return false;
    }
    var x = document.forms["registerform"]["email"].value;
    if (x === null || x === "")
    {
        alert("Not a valid e-mail address");
        return false;
    }
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos === -1 || dotpos === -1) {
        alert("Not a valid e-mail address");
        return false;
    }
    if (1 > atpos || atpos + 2 > dotpos || dotpos + 2 >= x.length)
    {
        alert("Not a valid e-mail address");
        return false;
    }
    var x = document.forms["registerform"]["pnum"].value;
    if (isNaN(x)) {
        alert("Pnum must be numbers only (without space and dash)");
        return false;
    }
    var x = document.forms["registerform"]["password"].value;
    var x2 = document.forms["registerform"]["rpassword"].value;
    if (x === null || x === "") {
        alert("Enter a password");
    }
    if (!x.equals(x2)) {
        alert("passwords must match");
    }
    return true;
}