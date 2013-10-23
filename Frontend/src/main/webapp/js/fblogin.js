function fblogin() {
    FB.login(function(response) {
        if (response.authResponse) {

            FB.api('/me', function(response) {
                document.getElementById('fname').value = response.first_name;
                document.getElementById('lname').value = response.last_name;
                var element = document.getElementById('facebookloginlink');

                element.style.visibility = false;

                document.getElementById("fbform").submit();
            });
        } else {
            alert('User cancelled login or did not fully authorize.');
        }

    });
}


// Additional JS functions here
window.fbAsyncInit = function() {
    FB.init({
        appId: '440894206020617', // App ID
        channelUrl: '//localhost:8080/Frontend/channel.html', // Channel File
        status: true, // check login status
        cookie: true, // enable cookies to allow the server to access the session
        xfbml: true  // parse XFBML
    });

    // Here we subscribe to the auth.authResponseChange JavaScript event. This event is fired
    // for any authentication related change, such as login, logout or session refresh. This means that
    // whenever someone who was previously logged out tries to log in again, the correct case below 
    // will be handled. 

};


// Load the SDK asynchronously
(function(d) {
    var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement('script');
    js.id = id;
    js.async = true;
    js.src = "//connect.facebook.net/en_US/all.js";
    ref.parentNode.insertBefore(js, ref);
}(document));
