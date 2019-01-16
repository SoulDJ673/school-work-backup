$(document).ready(function () {
    /* Centering Headers! */
    $('H1').addClass('text-center');
    $('H2').addClass('text-center');

    /* Replace 'Team Up!' Class! */
    $('.MyBannerHeading').addClass('page-header');
    $('.MyBannerHeading').removeClass('MyBannerHeading');

    /* Change 'The Squad' to 'Yellow Team' */
    $('#yellowHeading').text('Yellow Team');

    /* Making Text Backrounds Match Teams */
    $('#redTeamList').css({ 'background-color': 'Red' });
    $('#blueTeamList').css({ 'background-color': 'Blue' });
    $('#yellowTeamList').css({ 'background-color': 'Yellow' });
    $('#orangeTeamList').css({ 'background-color': 'Orange' });

    /* Add Peeps to the Yellow Team  &&&&&& ERROR &&&&& ERROR &&&&& ERROR &&&&& */
    $('#yellowTeamList').append('li').html('<li>Joseph Banks</li>');
    $('#yellowTeamList').append('li').html('<li>Simon Jones</li>');

    /* Hide "Hide Me!!!" */
    $('#oops').hide();

    /* Remove Footer */
    $('#footerPlaceholder').remove();

    /* Add Custom Footer */
    $('.footer').append('p').text('Devin Lloyd - souldj673@firemail.cc');
    $('.footer').css({ 'font-family': 'Courier', 'font-size': '24px', 'height':'32px'});
});