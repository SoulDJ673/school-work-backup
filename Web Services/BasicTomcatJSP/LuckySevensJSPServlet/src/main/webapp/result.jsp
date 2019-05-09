<%-- 
    Document   : result
    Created on : Apr 30, 2019, 10:49:15 AM
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
        <p class="note subtitle">Good job idiot, you're broke</p>
        <hr align="left">
        <h3>You bet $<c:out value="${betMoney}"/>.</h3>
        <h3>You went broke after <c:out value="${rolls}"/> rolls.</h3>
        <h3>You should've quit after <c:out value="${maxRolls}"/> rolls when you had $<c:out value="${maxMoney}"/>.</h3>
        <br>
        <h1>PepeLaugh</h1>
        <br>
        <br>
        <a href="/LuckySevensJSPServlet" class="back-purple btn btn-default">Return Home</a>
    </body>
</html>
