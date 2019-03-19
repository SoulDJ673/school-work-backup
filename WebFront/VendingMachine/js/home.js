var depositedMoney = 0.00;

$(document).ready(function () {
    loadItems();
});

function addCoinage(value) {
    depositedMoney += value;
    $('#depositedMoneyDisplay').val("$" + depositedMoney.toFixed(2));
};

function purchaseItem(id) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/money/' + depositedMoney + '/item/' + id,
        success: function (data, response) {
            var change = 0;
            change += .10(response.responseJSON.dimes);
            alert(response.responseJSON.dimes);
            alert(response.responseJSON.nickels);
            alert(response.responseJSON.pennies);
            alert(response.responseJSON.quarters);
            loadItems();
        },
        error: function (headers) {
            alert(headers.responseJSON.message);
        }
    });
};

function loadItems() {
    $('#foodStuffs').empty();

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
            $('#messagesOutput').val("Failed to contact web service.")
        }
    });
};