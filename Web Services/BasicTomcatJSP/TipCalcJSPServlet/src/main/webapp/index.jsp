<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <h1>Tip Calculator</h1>
        <p>
            Please enter the amount of the bill and the percentage you'd like to tip:
        </p>
        <br/>
        <form method="post" action="TipCalcServlet">
            <label for="billAmount">Bill Amount: </label>
            <input type="number" name="billAmount" placeholder="in $ (without dollar symbol)" required/>
            <label for="tipPercentage">Tip Percentage: </label>
            <input type="number" name="tipPercentage" placeholder="in % (without percent symbol)" required/><br/>

            <input type="submit" value="Find Tip!!!"/>
        </form>
    </body>
</html>