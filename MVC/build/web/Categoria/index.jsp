<%-- 
    Document   : index
    Created on : 04-ene-2021, 22:39:15
    Author     : Diego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style type="text/css">
    form{
        border: 1px solid #ddd;
        width: 50%;
        padding: 8px;
    }
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responsables</title>
            </head>
     <body>
         <h2> Categoria</h2>
         <form action="CategoriaControlador?accion=crear" method="POST">
          <label for="fname">codigo</label><br>
          <input type="text" id="codigo" name="codigo" value=><br>
          <label for="fname">nombre:</label><br>
          <input type="text" id="nombre" name="nombre" value=><br>
          <input type="submit" value="crear">
        </form> 
         
         
            <h1>Lista Categorias</h1>
            <a href="CategoriaControlador?accion=crear"> nuevo </a>
        <table id="customers">
          <tr>
            <th>CODIGO</th>
            <th>NOMBRE</th>
            <th>ACCIONES</th>
            <th>ACCIONES</th>
          </tr>  
          <c:forEach var="categoria" items="${listaCategoria}">
              <tr>
                <td><c:out value = "${categoria.get(0)}" /></td>
                <td><c:out value = "${categoria.get(1)}" /></td>
                <td><a href="CategoriaControlador?accion=modificar&codigo=<c:out value = "${categoria.get(0)}" />&nombre=<c:out value = "${categoria.get(1)}" />"> modificar </a></td>
                <td><a href="CategoriaControlador?accion=eliminar&codigo=<c:out value = "${categoria.get(0)}" />"> eliminar</a></td>
              </tr>
          </c:forEach>
        </table>
    </body>
</html>