<%-- 
    Document   : newjsp
    Created on : Apr 18, 2021, 11:48:47 AM
    Author     : ehkhalilov
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Client Detail</h1>
            <c:out value="${client.getId()}"/><br>
            <c:out value="${client.getName()}"/><br>
            <c:out value="${client.getSurname()}"/></br>
            <c:out value="${client.getAge()}"/></br>   
        </div>
    </body>
</html>
