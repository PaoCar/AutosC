<%-- 
    Document   : listaVentas
    Created on : 31/08/2018, 01:02:56 AM
    Author     : Cesar Benavidez
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Ventas</title>
    </head>
    <body>
       
        
         <c:forEach var="a" items="${ventas}">
           |${a.id}| |${a.username}| |${a.email}| 
           <a onclick="return confirm('Esta seguro?')" href="AccountServlet?action=delete&id=${a.id}">Delete</a>        
           <hr/>
        </c:forEach>        
       
        
        
    </body>
</html>
