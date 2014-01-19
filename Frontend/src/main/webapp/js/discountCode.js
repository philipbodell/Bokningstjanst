function discountCode()
{
    
    //var txt = document.getElementById("bajs");
    var txt=document.forms["discountCode"]["bajs"].value;
    
    txt.onchange = function() {
        alert("Not a valid e-mail address");
    };

}