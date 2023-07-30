$(document).ready(function(){ 
    getWeather();
    $('#location').change(getWeather);
});

function getWeather() {
    //$.getJSON("http://api.weatherstack.com/current?access_key=e87252bf5b15deae15a0592b14fc4555&query=fetch:ip", function(json) {
    $.getJSON("https://pocasiodts.azurewebsites.net/weather/" + $('#location').val(), function (json) {
        console.log(json);
        console.log($('#location').val());
        $("#temperature").html(json.temp_celsius + " <span>&#176;</span>C");
        $("#timestamp").html("Time: " + json.timestamp);
        $("#wind").html(json.windSpeed_mps + " m/s " + json.windDirection);
        $("#humidity").html(json.rel_humidity + "%");
        $("#description").html(json.weatherDescription);
    });
}