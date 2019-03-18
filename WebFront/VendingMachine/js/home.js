$(document).ready(function () {
    loadItems();
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
                var box = "<div onclick='$(" + '"#itemCodeInput"' + ").val(" + id + ")' class='item-box'>";
                box += "<p style='top:10;left:10'>" + id + "</p>";
                box += "<h4 class='text-center' style='margin:20px'>" + name + "</h4>"
                box += "<h4 class='text-center' style='margin:20px'>$" + price + "</h4>";
                box += "<h4 class='text-center' style='margin:20px'>Quantity Left: " + quantity + "</h4>";
                box += "</div>";

                $('#foodStuffs').append(box);
            });
        },
        error: function () {

        }
    });
};