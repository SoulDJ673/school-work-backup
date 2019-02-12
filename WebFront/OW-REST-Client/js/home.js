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
            $('#currentWindSpeed').before($('<li class="addedInfo">').text($('#currentWindSpeed').text() + windSpeed + " " + windSpeedUnit));
            $('#currentWindDir').before($('<li class="addedInfo">').text($('#currentWindDir').text() + windDir + " degrees (meteorlogical)"));

            /* Reveal */
            console.log("Ajax call to retrieve current weather info successful.")
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
                    var temp_min = weather.main.temp_min;
                    var temp_max = weather.main.temp_max;
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

                    var displayDate = humanizeDate(date);

                    /* Apply */
                    /* Header Row */
                    $('#5DayForecastHeadRow').append($('<th>').text(displayDate.monthName + " " + displayDate.dateNum));

                    /* Data Row */
                    $('#5DayForecastRow').append($('<td>').html('<img class="addedInfo" alt="' + condition + '" src="https://openweathermap.org/img/w/' + icon + '.png"></img><p class="addedInfo">' + description + '</p><h4 class="addedInfo">Low: ' + temp_min + " " + tempUnit + '</h4><h4 class="addedInfo">High: ' + temp_max + " " + tempUnit + '</h4>'));

                    /* Reveal */
                    console.log("Ajax call to retrieve 5 day weather info successful.")
                    $('#returnedInfo').fadeIn();
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
    $('li').remove('.addedInfo');
}

function humanizeDate(date) {
    var splitDateTime = date.split(" ");
    var aloneDate = splitDateTime[0];

    /* Get Month Alone */
    var dateArray = aloneDate.split("-");
    var monthNum = dateArray[1];
    var monthName;

    /* Name Month */
    if (monthNum.search("01") != -1) {
        monthName = "January";
    } else if (monthNum.search("02") != -1) {
        monthName = "February";
    } else if (monthNum.search("03") != -1) {
        monthName = "March";
    } else if (monthNum.search("04") != -1) {
        monthName = "April";
    } else if (monthNum.search("05") != -1) {
        monthName = "May";
    } else if (monthNum.search("06") != -1) {
        monthName = "June";
    } else if (monthNum.search("07") != -1) {
        monthName = "July";
    } else if (monthNum.search("08") != -1) {
        monthName = "August";
    } else if (monthNum.search("09") != -1) {
        monthName = "September";
    } else if (monthNum.search("10") != -1) {
        monthName = "October";
    } else if (monthNum.search("11") != -1) {
        monthName = "November";
    } else if (monthNum.search("12") != -1) {
        monthName = "December";
    } else {
        showGenericError();
        return;
    }

    /* Package up month name and date for return */
    var dateNum = dateArray[2];
    var dayForDisplay = { monthName, dateNum }; //This is an OBJECT, not an array
    return dayForDisplay;
}