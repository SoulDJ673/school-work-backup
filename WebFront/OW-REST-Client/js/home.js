$(document).ready(function () {
    /* Toggle Input Fields */
    $('#hideInputFields').on("click", function (event) {
        $('#hideInputFields').hide();
        $('#getInfo').hide();
        $('#showInputFields').show();
    });

    $('#showInputFields').on("click", function (event) {
        $('#showInputFields').hide();
        $('#hideInputFields').show();
        $('#getInfo').show();
    });

    $('#infoSubmitButton').on("click", function (event) {
        getWeatherData();
    });

    $('.clearErrors').on("click", function (event) {
        clearErrorsFtn();
    });
});

function getWeatherData() {
    var zipCode = $('#enterZipCode').val();
    var units = $('#unitDropdown').val();

    /* Current Conditions FeelsOkayMan */
    $.ajax({
        type: 'GET',
        url: 'https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function (data) {
            /* Turn JSON into Displayable Data */
            var city = data.name;

            /* These will be set in the each function below */
            var condition = null;
            var description = null;
            var icon = null;
            var id = null;

            /* Weather key has object values in an array, pick the first one */
            $.each(data.weather, function (index, weather) {
                if (index === 0) {
                    condition = weather.main;
                    description = weather.description;
                    icon = weather.icon;
                    id = weather.id;
                }
            });

            /* Use the icon id to get the icon */
            $.ajax({
                type: 'GET',
                url: 'https://openweathermap.org/img/w/' + icon + '.png',
                success: function (data) {

                },
                error: function () {
                    showGenericError();
                }
            });

        },
        error: function () {
            showGenericError();
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