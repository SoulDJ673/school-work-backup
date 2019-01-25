$(document).ready(function () {

    loadContacts();

    $('#add-button').click(function (event) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/contact',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val(),
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',

            },
            'dataType': 'json',
            success: function () {
                /* Make sure error message div is empty */
                $('#errorMessages').empty();

                $('#add-first-name').val();
                $('#add-last-name').val();
                $('#add-company').val();
                $('#add-phone').val();
                $('#add-email').val();

                loadContacts();
            },
            error: function () {
                $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' })
                    .text('Error calling web service.  Try again later.'));
            }
        });
    });
});

function loadContacts() {
    clearContactTable();
    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/contacts',
        success: function (contactArray) {
            $.each(contactArray, function (index, contact) {
                var name = contact.firstName + ' ' + contact.lastName;
                var company = contact.company;

                var row = '<tr>';
                row += '<td>' + name + '</td>';
                row += '<td>' + company + '</td>';
                row += '<td><a>Edit</a></td>';
                row += '<td><a>Delete</a></td>';
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

function clearContactTable() {
    $('#contentRows').empty();
}

function showEditForm() {
    
}
