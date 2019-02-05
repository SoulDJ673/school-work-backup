$(document).ready(function () {

});

getWeatherData(function () {
    $.ajax({
        type: 'GET',
        url: 'api.openweathermap.org/data/2.5/weather?zip=' + zipCode + '&appid=e52123ca9924186bd5b93d59366b7e55',
        success: function () {
            /* Turn JSON into Displayable content */
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
});