<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    List<Aviso> avisos = (List<Aviso>)request.getAttribute("avisos");
%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Avisos clasificados</h1>
        
        <p><a href="Inicio?action=add">Nuevo</a></p>
        
        <table border="1">
            
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Contenido</th>
                <th></th>
                <th></th>
            </tr>
            
            <c:forEach var="item" items="${avisos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.contenido}</td>
                <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR...???'))">Eliminar</a></td>
            </tr> 
            </c:forEach>
 
        </table>  
    </body>
</html>
