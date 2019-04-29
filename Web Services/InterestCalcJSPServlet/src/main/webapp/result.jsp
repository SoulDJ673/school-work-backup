<%-- 
    Document   : result
    Created on : Apr 16, 2019, 9:45:35 AM
    Author     : souldj673
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <table class="text-red back-grey">
                <tr>
                    <th>Year</th>
                        <c:forEach var="currentYear" items="${principles.keySet().toArray()}">
                        <td>
                            <c:out value="${currentYear}"/>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Yearly Starting Principles</td>
                    <c:forEach var="currentYearPrinciple" items="${principles.values()}">
                        <td>$<c:out value="${currentYearPrinciple}"/></td>
                    </c:forEach>
                </tr>               
                <tr>
                    <td>Yearly Ending Principles</td>
                    <c:forEach var="currentYearPrinciple" items="${products.values()}">
                        <td>$<c:out value="${currentYearPrinciple}"/></td>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
