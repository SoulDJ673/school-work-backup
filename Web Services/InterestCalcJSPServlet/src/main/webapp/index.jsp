<%-- 
    Document   : index
    Created on : Apr 16, 2019, 9:45:19 AM
    Author     : souldj673
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boring $ Calculator</title> <!-- Lol -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/tomorrow-night-bright.css" rel="stylesheet">
        <link href="css/souldj673-interestcalc.css" rel="stylesheet">
    </head>
    <body>
        <h1>Interest Calculator</h1>
        <h2 class="comment">Calculate Interest rates and stuff. Idc.</h2>
        <hr>
        <div style="margin-left: 7%">
            <form method="post" action="InterestServlet">
                <label for="rate">Annual Interest Rate:</label>
                <input class="back-grey" type="text" placeholder="Annual interest rate (in %)" name="rate">
                <br style="margin-bottom: 20px;">
                <label for="initialMoney">Initial Principle:</label>
                <input class="back-grey" type="text" placeholder="Initial $$$" name="initPrinciple">
                <br style="margin-bottom: 20px;">
                <label for="yearsHeld">Time:</label>
                <input class="back-grey" type="number" placeholder="Years to hold" name="yearsHeld">
                <br style="margin-bottom: 20px;">
                <input class="back-grey" type="submit" value="Go!">
            </form>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/home.js"></script>
        <div id="bruh"></div>
</html>
