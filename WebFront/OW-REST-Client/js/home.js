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

    /* Current Conditions FeelsOkayMan */
    $.ajax({
        type: 'GET',
        url: 'https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function (data) {
            /* Only hide input form if successful */
            hideInputFields();

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

            /* Apply */
            $('#conditionsHead').html('<h2 class="addedInfo">Current Conditions in ' + city + '</h2>');
            $('#iconDescription').prepend($('<img>').html('<img class="addedInfo" alt="' + description + '" src="https://openweathermap.org/img/w/' + icon + '.png"></img>'));

            /* Reveal */
            $('#returnedInfo').fadeIn();

        },
        error: function () {
            showGenericError();
            console.log("Ajax call to retrieve current weather information failed.")
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