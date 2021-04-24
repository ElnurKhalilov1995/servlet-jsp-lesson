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
            <h1>Clients</h1>
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="client" items="${clients}">
                        <tr>
                            <td><c:out value="${client.getName()}"/></td>
                            <td><c:out value="${client.getSurname()}"/></td>
                            <td><c:out value="${client.getAge()}"/></td>

                            <td>
                                <a href="http://localhost:8080/servlet-ptoject/ClientDetails?id=${client.getId()}">
                                    <button class="button button-success">detail</button>
                                </a> 
                        </tr>
                    </c:forEach> 
                </tbody>      
            </table>

        </div>
    </body>
</html>
