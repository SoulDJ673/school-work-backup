<%-- 
    Document   : result
    Created on : May 9, 2019, 9:39:53 AM
    Author     : souldj673
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calculator</title>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
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
            <h2>Flooring Calculations Results:</h2>
            <div>
                <br>
                <p><strong>Your total comes out to be: $${result}</strong></p>
                <p>Labor Costs: $${laborCost}</p>
                <p>Labor Time (Minutes): ${workTime} minutes</p>
                <p>Material Costs: $${materialCost}</p>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js">
        </script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js">
        </script>
    </body>
</html>