<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calculator</title>
        <!-- Bootstrap core CSS -->   
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" 
              rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/souldj673-flooringCalc.css" 
              rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator</h1>
            <br/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" 
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/hello/sayhi">
                            Hello Controller
                        </a>
                    </li>
                </ul>    
            </div>
            <h2>Enter Flooring Purchase Information:</h2>
            <form method="POST" action="flooringCalculator">
                <h4>Area of Floor</h4>
                <input class="servletForm" type="number" name="widthOfArea" placeholder="Width"/><br/>
                <input class="servletForm" type="number" name="lengthOfArea" placeholder="Length"/><br/>
                <br>
                <h4>Cost of Material / ft^2 </h4>
                <input class="servletForm" type="number" name="pricePerSqFoot" placeholder="$ Per Sqr Ft"/><br/>
                <br/>
                <input class="servletForm btn-form" type="submit" value="Brain Blast"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js">
        </script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js">
        </script>

    </body>
</html>