$(document).ready(function () {
    /* Hide All Except Main on Load */
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();

    /* Hide All Weather by Default */
    $('#akronWeather').hide();
    $('#minneapolisWeather').hide();
    $('#louisvilleWeather').hide();

    /* Nav Buttons */
    $('#mainButton').on("click", function () {
        $('#mainInfoDiv').show();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });
    $('#akronButton').on("click", function () {
        $('#mainInfoDiv').hide();
        $('#akronInfoDiv').show();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });
    $('#minneapolisButton').on("click", function () {
        $('#mainInfoDiv').hide();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').show();
        $('#louisvilleInfoDiv').hide();
    });
    $('#louisvilleButton').on("click", function () {
        $('#mainInfoDiv').hide();
        $('#akronInfoDiv').hide();
        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').show();
    });

    /* Weather Buttons */
    $('#akronWeatherButton').on("click", function (event) {
        event.preventDefault();  //Browser shut the hell your mouth
        $('#akronWeather').toggle("slow");
    });
    $('#minneapolisWeatherButton').on("click", function () {
        $('#minneapolisWeather').toggle("slow");
    });
    $('#louisvilleWeatherButton').on("click", function () {
        $('#louisvilleWeather').toggle("slow");
    });

    /* Table Rows */
    $('tr').hover(function () {
        /* The Header Row Shouldn't Change */
        $('th').css({ "background-color": "AliceBlue" });

        /* In Callback */
        $(this).css({ "background-color": "WhiteSmoke" });
    }, function () {
        /* Out Callback */
        $(this).css({ "background-color": "" });
    });
});