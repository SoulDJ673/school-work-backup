<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tip Calculator</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/souldj673-TipCalculator.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Tip Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Home Page</h2>
            <p>
                Please enter the amount of the bill and the percentage you'd like to tip:
            </p>
            <br/>
            <form method="POST" action="calculateTip">
                <label for="billAmount">Bill Amount: </label>
                <input type="text" name="billAmount" placeholder="in $" required/><br>
                <br>
                <label for="tipPercentage">Tip Percentage: </label>
                <input type="text" name="tipPercentage" placeholder="in %" required/><br/>
                <br>
                <input type="submit" value="Find Tip!!!"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

