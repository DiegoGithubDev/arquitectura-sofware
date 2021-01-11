<%-- 
    Document   : modificar
    Created on : 05-ene-2021, 22:54:29
    Author     : LeoCL
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

</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <form action="CategoriaControlador?accion=modificar" method="POST">
          <h2> Modficar Categoria</h2>
          <label for="fname">codigo</label><br>
          <input type="text" id="codigo" name="codigo" value="<c:out value="${codigo}"/>"<br>
          <label for="fname">nombre:</label><br>
          <input type="text" id="nombre" name="nombre" value="<c:out value="${nombre}"/>"><br>
          <input type="submit" value="modificar">
        </form> 
    </body>
</html>
