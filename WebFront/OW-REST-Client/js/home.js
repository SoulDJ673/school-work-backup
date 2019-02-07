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
});

function getWeatherData() {
    var zipCode = $('#enterZipCode').val();
    var units = $('#unitDropdown').val();

    $.ajax({
        type: 'GET',
        url: 'https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function (data) {
            /* Turn JSON into Displayable Data */
            var city = data.name;
            var condition = data.weather.main;
            var description = data.weather.description;

            console.log(data);
        },
        error: function () {
            $('#headerDiv').hide();
            $('#errorCage').show();
            $('#errorCage').prepend($('<p>').text('Error calling web service.  Try again later.'));
        }
    });
};