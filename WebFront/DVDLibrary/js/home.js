$(document).ready(function () {
    populateLibrary();

    $('#editDvdSubmitButton').click(function (event) {
        submitEditData();
    });

    $('#createDvdSubmitButton').click(function (event) {
        submitCreateData();
    });
});

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
                row += '<td>' + title + '</td>';
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
}

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
            anikiEgg();
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
            anikiEgg();
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

function anikiEgg() {
    if ($('#editDvdDirector').val() === "Van") {
        if ($('#editDvdRating').val() === "XXX") {
            if ($('#editDvdYear').val() === "2018") {
                if ($('#editDvdNotes').val() === "Aniki") {
                    alert("PepeHands we love and miss you Billy <3 GachiF");
                }
            }
        }
    }
    if ($('#createDvdDirector').val() === "Van") {
        if ($('#createDvdRating').val() === "XXX") {
            if ($('#createDvdYear').val() === "2018") {
                if ($('#createDvdNotes').val() === "Aniki") {
                    alert("PepeHands we love and miss you Billy <3 GachiF");
                }
            }
        }
    }
}