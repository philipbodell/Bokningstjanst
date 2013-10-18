

// Seconds to count down
var secondsLeft = 7;


// Function update intervall 1 sec
var refreshIntervalId = setInterval(function() {


    secondsLeft--;

    if (secondsLeft === 0) {
        clearInterval(refreshIntervalId);
        document.getElementById('countdownClock').innerHTML = "stop";
    }
    //Update countdownId inner html with seconds 
    document.getElementById('countdownClock').innerHTML = secondsLeft + "s";

}, 1000);

