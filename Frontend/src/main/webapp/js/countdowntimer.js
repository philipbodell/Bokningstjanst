

// Seconds to count down
var secondsLeft = 60;


// Function update intervall 1 sec
var refreshIntervalId = setInterval(function() {


    secondsLeft--;

    if (secondsLeft === 0) {
        clearInterval(refreshIntervalId);
        document.getElementById('countdownClock').innerHTML = "";
    }
    //Update countdownId inner html with seconds 
    document.getElementById('button').innerHTML = "Accept Expire in "+ secondsLeft + " s";

}, 1000);

