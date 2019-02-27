$(document).ready(function () {
    populateLibrary();

    $('#editDvdSubmitButton').click(function (event) {
        if (checkForErrors()) {
            clearErrorCage();
        }
        submitEditData();
    });

    $('#createDvdSubmitButton').click(function (event) {

        clearErrorCage();

        // Validate
        var messages = [];

        var yearInput = $('#createDvdYear').val();

        var validYear;

        validYear = isInt(yearInput);
        if (!validYear || yearInput.length == 0) {
            var messageYear = "The year must be an integer.";
            messages.push(messageYear);
        }

        var titleInput = $('#createDvdTitle').val();
        var invalidTitle = isEmpty(titleInput);
        if (invalidTitle) {
            var messageTitle = "The title must exist";
            messages.push(messageTitle);
        }

        if (messages.length > 0) {
            createErrorMessage(messages);
            console.log("Went to create error messages");
            return;
        }

        if (!checkForErrors()) {
            console.log("Went to submit data");
            submitCreateData();
        }
    });

    $('#searchButton').click(function (event) {
        if (checkForErrors()) {
            clearErrorCage();
        }
        searchLibrary();
    });

    $('#clearSearchResults').click(function (event) {
        $('#clearSearchResults').hide();
        $('#searchString').css({ 'border-color': '#00000000' });
        $('#categoryDropdown').css({ 'border-color': '#00000000' });
        populateLibrary();
    });

});

function isInt(value) {
    var x;
    return isNaN(value) ? !1 : (x = parseFloat(value), (0 | x) === x);
}

function isEmpty(string) {
    /* This function will check to see if a given string is empty */
    console.log(string.length);
    if (string.length === 0) {
        return true;
    } else {
        return false;
    }
}

function populateLibrary() {
    clearDVDLibraryTable();
    var contentRows = $('#dvdSection');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvds',
        success: function (dvdArray) {
            $.each(dvdArray, function (index, dvd) {
                var id = dvd.dvdId;
                var title = dvd.title;
                var year = dvd.releaseYear;
                var director = dvd.director;
                var rating = dvd.rating;
                var notes = dvd.notes;

                var row = '<tr>';
                // Aniki Egg
                if (director === "Van") {
                    if (rating === "XXX") {
                        if (year === 2018) {
                            if (notes === "Aniki") {
                                row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + " " + '<a href="https://www.youtube.com/watch?v=02C1R7fHH-A"><img src="https://cdn.frankerfacez.com/emoticon/238016/1" alt="gachiF"></img></a>' + '</a>' + '</td>';
                            }
                        }
                    }
                } else {
                    row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + '</a>' + '</td>';
                }
                row += '<td>' + year + '</td>';
                row += '<td>' + director + '</td>';
                row += '<td>' + rating + '</td>';
                row += '<td><a onclick="showEditForm(' + id + ')" style="margin-right:10px">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
                row += '</tr>';

                contentRows.append(row);
            });
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
}

function clearDVDLibraryTable() {
    $('#dvdSection').empty();
} s

function showDeleteConfirmDiv() {
    $('#deleteConfirmDiv').show();

    /* Make Action Bar Unusable until user input */
    $('#actionBarDiv').hide();
    return;
}

function hideDeleteConfirmDiv() {
    $('#deleteConfirmDiv').fadeOut();

    /* Re-enable Action Bar */
    $('#actionBarDiv').fadeIn();
    return;
}

function deleteDVD(dvdId) {
    var id = dvdId;
    showDeleteConfirmDiv();
    $('#confirmCancel').click(function (event) {
        hideDeleteConfirmDiv();
        id = null;
        return;
    });

    $('#confirmDeleteButton').click(function (event) {
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/dvd/' + id,
            success: function () {
                populateLibrary();
            },
        });
        hideDeleteConfirmDiv();
        id = null;
        return;
    });

    /* id = null fixes multidelete issue on reuse */
    return;
}

function showEditForm(dvdId) {
    var id = dvdId;
    $('#actionBarDiv').hide();
    $('#editNavBarDiv').show();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + id,
        success: function (data, status) {
            $('#editDvdTitle').val(data.title);
            $('#editDvdYear').val(data.releaseYear);
            $('#editDvdDirector').val(data.director);
            $('#editDvdRating').val(data.rating);
            $('#editDvdNotes').val(data.notes);
            $('#editDvdIDHolder').val(id);

            /* Fix Header to show title */
            $('#editTitleHeader').text(data.title);
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
    $('#dvdDisplay').hide();
    $('#dvdEditForm').fadeIn('slow');
}

function submitEditData() {
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/dvd/' + $('#editDvdIDHolder').val(),
        data: JSON.stringify({
            dvdId: $('#editDvdIDHolder').val(),
            title: $('#editDvdTitle').val(),
            releaseYear: $('#editDvdYear').val(),
            director: $('#editDvdDirector').val(),
            notes: $('#editDvdNotes').val(),
            rating: $('#editDvdRating').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        'dataType': 'json',
        success: function () {
            anikiEgg(1);
            populateLibrary();
            hideEditForm();
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
}

function hideEditForm() {
    $('#actionBarDiv').show();
    $('#editNavBarDiv').hide();
    $('#dvdDisplay').fadeIn('slow');
    $('#dvdEditForm').hide();
}

function showCreateForm() {
    $('#actionBarDiv').hide();
    $('#createNavBarDiv').show();

    // Always reset input fields
    $('select.createDvd').val('G');
    $('input.createDvd').val(null);
    $('textarea.createDvd').val(null);

    $('#dvdDisplay').hide();
    $('#dvdCreateForm').fadeIn('slow');
}

function submitCreateData() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/dvd',
        data: JSON.stringify({
            title: $('#createDvdTitle').val(),
            releaseYear: $('#createDvdYear').val(),
            director: $('#createDvdDirector').val(),
            notes: $('#createDvdNotes').val(),
            rating: $('#createDvdRating').val()
        }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        'dataType': 'json',
        success: function () {
            anikiEgg(0);
            populateLibrary();
            hideCreateForm();
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
}

function hideCreateForm() {
    $('#actionBarDiv').show();
    $('#createNavBarDiv').hide();
    $('#dvdCreateForm').hide();
    $('#dvdDisplay').fadeIn('slow');
}

function searchLibrary() {
    var contentRows = $('#dvdSection');
    var sS = $('#searchString').val();

    // Input Validation
    if (sS.trim() === "") {
        $('#searchString').css({ 'border-color': '#ff0000' });

        //Check Dropdown after query before function return
        if ($('#categoryDropdown').val() === "") {
            $('#categoryDropdown').css({ 'border-color': '#FF0000' });
            var message = ["Both Search Category and Search Term are required."];
            createErrorMessage(message);
            return;
        } else {
            $('#categoryDropdown').css({ 'border-color': '#00000000' });
            var message = ["Search Term Required."];
            createErrorMessage(message);
        }
        return;
    } else {
        $('#searchString').css({ 'border-color': '#00000000' });

        //Check dropdown after query success before continuing
        if ($('#categoryDropdown').val() === "") {
            $('#categoryDropdown').css({ 'border-color': '#FF0000' });
            var message = ["Search Category Required."];
            createErrorMessage(message);
            return;
        } else {
            $('#categoryDropdown').css({ 'border-color': '#00000000' });
        }
    }

    // Start Search
    clearDVDLibraryTable();

    if ($('#categoryDropdown').val() === "title") {
        $('#clearSearchResults').show();
        var searchString = $('#searchString').val();
        var searchStringFixed = searchString.replace(/ /gi, "%20");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/title/' + searchStringFixed,
            success: function (dvdArray) {
                $.each(dvdArray, function (index, dvd) {
                    var id = dvd.dvdId;
                    var title = dvd.title;
                    var year = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var notes = dvd.notes;

                    var row = '<tr>';
                    // Aniki Egg
                    if (director === "Van") {
                        if (rating === "XXX") {
                            if (year === 2018) {
                                if (notes === "Aniki") {
                                    row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + " " + '<a href="https://www.youtube.com/watch?v=02C1R7fHH-A"><img src="https://cdn.frankerfacez.com/emoticon/238016/1" alt="gachiF"></img></a>' + '</a>' + '</td>';
                                }
                            }
                        }
                    } else {
                        row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + '</a>' + '</td>';
                    }
                    row += '<td>' + year + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><a onclick="showEditForm(' + id + ')" style="margin-right:10px">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                });
            },
            error: function () {
                var message = ['Error calling web service.  Try again later.'];
                createErrorMessage(message);
            }
        });
    } else if ($('#categoryDropdown').val() === "year") {
        $('#clearSearchResults').show();
        var searchString = $('#searchString').val();
        var searchStringFixed = searchString.replace(/ /gi, "%20");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/year/' + searchStringFixed,
            success: function (dvdArray) {
                $.each(dvdArray, function (index, dvd) {
                    var id = dvd.dvdId;
                    var title = dvd.title;
                    var year = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var notes = dvd.notes;

                    var row = '<tr>';
                    // Aniki Egg
                    if (director === "Van") {
                        if (rating === "XXX") {
                            if (year === 2018) {
                                if (notes === "Aniki") {
                                    row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + " " + '<a href="https://www.youtube.com/watch?v=02C1R7fHH-A"><img src="https://cdn.frankerfacez.com/emoticon/238016/1" alt="gachiF"></img></a>' + '</a>' + '</td>';
                                }
                            }
                        }
                    } else {
                        row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + '</a>' + '</td>';
                    }
                    row += '<td>' + year + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><a onclick="showEditForm(' + id + ')" style="margin-right:10px">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                });
            },
            error: function () {
                var message = ['Error calling web service.  Try again later.'];
                createErrorMessage(message);
            }
        });
    } else if ($('#categoryDropdown').val() === "rating") {
        $('#clearSearchResults').show();
        var searchString = $('#searchString').val();
        var searchStringFixed = searchString.replace(/ /gi, "%20");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/rating/' + searchStringFixed,
            success: function (dvdArray) {
                $.each(dvdArray, function (index, dvd) {
                    var id = dvd.dvdId;
                    var title = dvd.title;
                    var year = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var notes = dvd.notes;

                    var row = '<tr>';
                    // Aniki Egg
                    if (director === "Van") {
                        if (rating === "XXX") {
                            if (year === 2018) {
                                if (notes === "Aniki") {
                                    row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + " " + '<a href="https://www.youtube.com/watch?v=02C1R7fHH-A"><img src="https://cdn.frankerfacez.com/emoticon/238016/1" alt="gachiF"></img></a>' + '</a>' + '</td>';
                                }
                            }
                        }
                    } else {
                        row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + '</a>' + '</td>';
                    }
                    row += '<td>' + year + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><a onclick="showEditForm(' + id + ')" style="margin-right:10px">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                });
            },
            error: function () {
                var message = ['Error calling web service.  Try again later.'];
                createErrorMessage(message);
            }
        });
    } else if ($('#categoryDropdown').val() === "director") {
        $('#clearSearchResults').show();
        var searchString = $('#searchString').val();
        var searchStringFixed = searchString.replace(/ /gi, "%20");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/director/' + searchStringFixed,
            success: function (dvdArray) {
                $.each(dvdArray, function (index, dvd) {
                    var id = dvd.dvdId;
                    var title = dvd.title;
                    var year = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var notes = dvd.notes;

                    var row = '<tr>';
                    // Aniki Egg
                    if (director === "Van") {
                        if (rating === "XXX") {
                            if (year === 2018) {
                                if (notes === "Aniki") {
                                    row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + " " + '<a href="https://www.youtube.com/watch?v=02C1R7fHH-A"><img src="https://cdn.frankerfacez.com/emoticon/238016/1" alt="gachiF"></img></a>' + '</a>' + '</td>';
                                }
                            }
                        }
                    } else {
                        row += '<td>' + '<a onclick="showProperties(' + id + ')">' + title + '</a>' + '</td>';
                    }
                    row += '<td>' + year + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><a onclick="showEditForm(' + id + ')" style="margin-right:10px">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                });
            },
            error: function () {
                var message = ['Error calling web service.  Try again later.'];
                createErrorMessage(message);
            }
        });
    }
}

function anikiEgg(menu) {
    // Edit
    if (menu === 1) {
        if ($('#editDvdDirector').val() === "Van") {
            if ($('#editDvdRating').val() === "XXX") {
                if ($('#editDvdYear').val() === "2018") {
                    if ($('#editDvdNotes').val() === "Aniki") {
                        alert("PepeHands we love and miss you Billy <3 gachiF");
                    }
                }
            }
        }
    }
    // Create
    if (menu === 0) {
        if ($('#createDvdDirector').val() === "Van") {
            if ($('#createDvdRating').val() === "XXX") {
                if ($('#createDvdYear').val() === "2018") {
                    if ($('#createDvdNotes').val() === "Aniki") {
                        alert("PepeHands we love and miss you Billy <3 gachiF");
                    }
                }
            }
        }
    }
}

function hideProperties() {
    $('#actionBarDiv').show();
    $('#propertiesNavBarDiv').hide();
    $('#dvdDisplay').fadeIn('slow');
    $('#dvdProperties').hide();
}

function showProperties(dvdId) {
    var id = dvdId;
    $('#actionBarDiv').hide();
    $('#propertiesNavBarDiv').show();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + id,
        success: function (data, status) {
            $('#dvdPropReleaseValue').text(data.releaseYear);
            $('#dvdPropDirectorValue').text(data.director);
            $('#dvdPropRatingValue').text(data.rating);
            $('#dvdPropNotesValue').text(data.notes);

            /* Fix Header to show title */
            $('#propertiesTitleHeader').text(data.title);
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                .text('Error calling web service.  Try again later.'));
        }
    });
    $('#dvdDisplay').hide();
    $('#dvdProperties').fadeIn('slow');
}

function createErrorMessage(messages) {
    clearErrorCage();

    //Messages is an array
    $.each(messages, function (index, message) {
        $('#errorCage').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text(message));
    });

    $('#errorCage').show();
}

function checkForErrors() {
    var errors = $('#errorCage').html();
    console.log(errors);
    if (errors.length > 0) {
        console.log("checkForErrors returned true!");
        return true;
    } else {
        console.log("checkForErrors returned false!");
        return false;
    }
}

function clearErrorCage() {
    $('#errorCage').empty();
    $('#errorCage').hide();
}