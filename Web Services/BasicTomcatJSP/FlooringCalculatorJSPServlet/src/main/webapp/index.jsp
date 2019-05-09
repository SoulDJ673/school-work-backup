<%-- 
    Document   : index
    Created on : Apr 15, 2019, 9:27:20 AM
    Author     : souldj673
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/souldj673-flooringmastery.css">
    </head>
    <body class="bg">
        <div id="headerDiv" class="centered-flex-container">
            <h1>Flooring Calculator</h1>
        </div>

        <form method="post" action="FlooringCalculator">
            <div class="centered-flex-container">
                <input class="servletForm" type="number" name="widthOfArea" placeholder="Width"/><br/>
                <input class="servletForm" type="number" name="lengthOfArea" placeholder="Length"/><br/>
                <input class="servletForm" type="number" name="pricePerSqFoot" placeholder="$ Per Sqr Ft"/>
            </div>
            <div class="centered-flex-container">
                <input class="servletForm btn-form" type="submit" value="Brain Blast!"/></div>
        </form>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>