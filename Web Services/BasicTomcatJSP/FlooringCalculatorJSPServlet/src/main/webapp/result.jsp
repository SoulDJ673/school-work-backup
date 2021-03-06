<%-- 
    Document   : result
    Created on : Apr 15, 2019, 9:28:10 AM
    Author     : souldj673
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="centered-flex-container text-background">
            <div>
                <h3>Your total comes out to be: $${result}</h3>
                <br>
                <br>
                <p class="text-center">Labor Costs: $${laborCost}</p>
                <p class="text-center">Labor Time (Minutes): ${workTime} minutes</p>
                <p class="text-center">Material Costs: $${materialCost}</p>

            </div>
        </div>
        <div class="centered-flex-container">
            <a href="index.jsp" class="button-link">Return</a>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>