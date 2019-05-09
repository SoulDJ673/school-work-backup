<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lucky Sevens</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/souldj673-LuckySevens.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Lucky Sevens</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Home Page</h2>
            <p>Lucky Sevens is a game you can never win.</p>
            <p>A true lesson on the horrors of gambling.  Good luck idiot.</p>
            <br>
            <h4>Rules:</h4>
            <ul style="list-style-type: circle;">
                <li>Each round, I roll a virtual pair of dice</li>
                <li>If the sum of the 2 dice is equal to 7, you win $4; otherwise, you lose $1</li>
            </ul>
            <br>
            <form method="POST" action="luckySevens">
                <label for="dollarInput">Money to bet: $</label>
                <input type="number" name="dollarInput" placeholder="Amount in Dollars" required/>
                <input type="submit" value="Play!"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

