$(document).ready(function () {

});

function addCoinage(value) {

};

function purchaseItem(id) {

};

function loadItems() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (data) {
            $.each(data, function (index, item) {
                var id = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;

                //Add to table
                var box = "<div onclick='$(" + '"#itemCodeInput"' + ").val(" + id + ")' class='flex-container flex-container-centered item-box'>"
            });
        },
        error: function () {

        }
    });
};