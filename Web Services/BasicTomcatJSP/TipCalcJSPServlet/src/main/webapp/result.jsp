<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Tip Calc Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You asked to calculate a <c:out value="${percentage}"/>% tip on a $<c:out value="${amount}"/> bill.
            You will have to tip $<c:out value="${tip}"/>, which brings your total bill to $<c:out value="${totalBill}"/>.
        </p>    
        <p>
            <a href="index.jsp">Calculate Again</a>
        </p>
    </body>
</html>