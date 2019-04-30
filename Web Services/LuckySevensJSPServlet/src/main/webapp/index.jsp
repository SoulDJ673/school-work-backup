<%-- 
    Document   : index
    Created on : Apr 29, 2019, 10:10:36 AM
    Author     : souldj673
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
        <link href="css/bootstrap-reboot.css" rel="stylesheet">
        <link href="css/tomorrow-night-bright.css" rel="stylesheet">
        <link href="css/souldj673-LuckySevens.css" rel="stylesheet">
    </head>
    <body>
        <h1 class="text-purple title">Lucky Sevens</h1>
        <p class="note subtitle">Lucky Sevens is a game you can never win.
        <p class="note subtitle">A true lesson on the horrors of gambling.  Good luck idiot.</p>
        <hr align="left">
        <div id="torso">
            <ul style="list-style-type: circle;">
                <li>Each round, I roll a virtual pair of dice</li>
                <li>If the sum of the 2 dice is equal to 7, you win $4; otherwise, you lose $1</li>
            </ul>
            <br>
            <br>
            <form method="post" action="LuckySevensServlet">
                <label for="dollarInput">Money to bet: $</label>
                <input class="text-grey back-purple" type="number" name="dollarInput" placeholder="Amount in Dollars" required/>
                <input class="back-purple" type="submit" value="Play!"/>
            </form>
        </div>
    </body>
</html>
