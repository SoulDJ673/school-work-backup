$(document).ready(function () {
    /* Toggle Input Fields */
    $('#hideInputFields').on("click", function (event) {
        hideInputFields();
    });

    $('#showInputFields').on("click", function (event) {
        showInputFields();
    });

    $('#infoSubmitButton').on("click", function (event) {
        getWeatherData();
    });

    $('.clearErrors').on("click", function (event) {
        clearErrorsFtn();
    });
});

function getWeatherData() {

    clearNewAdditions();

    var zipCode = $('#enterZipCode').val();
    var units = $('#unitDropdown').val();

    var tempUnit;
    var windSpeedUnit;

    /* Set units */
    if (units === "metric") {
        tempUnit = "C";
        windSpeedUnit = "m/s";

    } else {
        tempUnit = "F";
        windSpeedUnit = "mph";
    }

    /* Current Conditions FeelsOkayMan */
    $.ajax({
        type: 'GET',
        url: 'https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + '&units=' + units + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function (data) {
            /* Only hide input form if successful */
            hideInputFields();

            /* Turn JSON into Displayable Data */
            var city = data.name;
            var temp = data.main.temp;
            var humidity = data.main.humidity;
            var windSpeed = data.wind.speed;
            var windDir = data.wind.deg;

            /* These will be set in the each function below */
            var condition = null;
            var description = null;
            var icon = null;

            /* Weather key has object values in an array, pick the first one */
            $.each(data.weather, function (index, weather) {
                if (index === 0) {
                    condition = weather.main;
                    description = weather.description;
                    icon = weather.icon;
                    id = weather.id;
                }
            });

            /* Apply */
            /* Current Conditions Left */
            $('#conditionsHead').html('<h2 class="addedInfo">Current Conditions in ' + city + '</h2>');
            $('#iconDescription').prepend($('<img>').html('<img class="addedInfo" alt="' + condition + '" src="https://openweathermap.org/img/w/' + icon + '.png"></img>'));
            $('#iconDescription').append($('<p>').html('<p class="addedInfo">' + description + '</p>'));

            /* Current Conditions Right */
            $('#currentTemp').before($('<h4>').html('<h4 class="addedInfo">' + $('#currentTemp').text() + temp + " " + tempUnit + '</h4>'));
            $('#currentHumid').before($('<h4>').html('<h4 class="addedInfo">' + $('#currentHumid').text() + humidity + "%" + '</h4>'));
            $('#currentWindSpeed').before($('<li>').html('<li class="addedInfo">' + $('#currentWindSpeed').text() + windSpeed + " " + windSpeedUnit + '</li>'))
            $('#currentWindDir').before($('<li>').html('<li class="addedInfo">' + $('#currentWindDir').text() + windDir + " degrees (meteorlogical)"));

            /* Reveal */
            $('#returnedInfo').fadeIn();

        },
        error: function () {
            showGenericError();
            console.log("Ajax call to retrieve current weather information failed.")
        }
    });

    /* Five Day Forecast PagChomp */
    $.ajax({
        type: 'GET',
        url: 'https://api.openweathermap.org/data/2.5/forecast?zip=' + zipCode + '&units=' + units + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function (data) {
            /* Only hide input form if successful */
            hideInputFields();

            /* Pull every forecast from 12:00 */
            $.each(data.list, function (index, weather) {
                var dateTime = weather.dt_txt;
                if (dateTime.search("12:00:00") != -1) {

                    /* Turn JSON into Displayable Data */
                    var temp = weather.main.temp;
                    var humidity = weather.main.humidity;
                    var windSpeed = weather.wind.speed;
                    var windDir = weather.wind.deg;
                    var date = weather.dt_txt;

                    /* These will be set in the each function below */
                    var condition = null;
                    var description = null;
                    var icon = null;

                    /* Weather key has object values in an array, pick the first one */
                    $.each(weather.weather, function (index, weather) {
                        if (index === 0) {
                            condition = weather.main;
                            description = weather.description;
                            icon = weather.icon;
                            id = weather.id;
                        }
                    });
                }
            });
        },
        error: function () {
            showGenericError();
            console.log('5 Day Forecast Ajax call failed');
        }
    });
};

function showGenericError() {
    $('#headerDiv').hide();
    $('#errorPrison').show();
    $('#errorCage').prepend($('<h3>').text('Error calling web service.  Try again later.'));
};

function clearErrorsFtn() {
    $('#errorCage').empty();
    $('#errorPrison').hide();
    $('#headerDiv').show();
};

function showInputFields() {
    $('#showInputFields').hide();
    $('#hideInputFields').show();
    $('#getInfo').slideDown();
}

function hideInputFields() {
    $('#hideInputFields').hide();
    $('#getInfo').slideUp();
    $('#showInputFields').show();
}

function clearNewAdditions() {
    $('h1').remove('.addedInfo');
    $('h2').remove('.addedInfo');
    $('h3').remove('.addedInfo');
    $('h4').remove('.addedInfo');
    $('img').remove('.addedInfo');
    $('p').remove('.addedInfo');
    $('td').remove('.addedInfo');
    $('tr').remove('.addedInfo');
    $('th').remove('.addedInfo');
}