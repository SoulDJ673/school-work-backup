$(document).ready(function () {
    populateLibrary();

    $('#exitButton').click(function (event) {
        hideEditForm();
    });

    $('#editDvdSubmitButton').click(function (event) {
        submitEditData();
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
                row += '<td><a onclick="showEditForm(' + id + ')">Edit</a> <a onclick="deleteDVD(' + id + ')">Delete</a></td>';
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
    $('#dvdDisplay').slideUp();
    $('#dvdEditForm').slideDown();
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
    $('#dvdDisplay').slideDown();
    $('#dvdEditForm').slideUp();
}