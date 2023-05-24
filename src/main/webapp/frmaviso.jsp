<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${aviso.id ==0}">
                Nuevo Registro
            </c:if>
            <c:if test="${aviso.id !=0}">
                Editar Registro
            </c:if> 
                aviso
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" mane="id" value="${aviso.id}" >
            <table>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${aviso.titulo}"/></td>
                </tr>
                
                <tr>
                    <td>Contenido:</td>
                    <td>
                        <textarea name="contenido" rows="4" cols="20"> ${aviso.contenido}</textarea>    
                    </td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" > </td>
                </tr>
                
            </table> 
        </form>
    </body>
</html>
