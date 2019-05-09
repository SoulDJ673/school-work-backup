<%-- 
    Document   : result
    Created on : May 9, 2019, 10:27:36 AM
    Author     : souldj673
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lucky Sevens</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Lucky Sevens</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Game End!</h2>
            <p>Good job idiot, you're broke</p>

            <h3>You bet $<c:out value="${betMoney}"/>.</h3>
            <h3>You went broke after <c:out value="${rolls}"/> rolls.</h3>
            <h3>You should've quit after <c:out value="${maxRolls}"/> rolls when you had $<c:out value="${maxMoney}"/>.</h3>
            <br>
            <h1>PepeLaugh</h1>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

