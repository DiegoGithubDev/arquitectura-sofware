<%-- 
    Document   : modificar
    Created on : 08-ene-2021, 4:12:47
    Author     : LeoCL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style type="text/css">
    form{
        border: 1px solid #ddd;
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
#padre {
overflow:hidden;
}
#hijo {
  padding: 5px;
  margin: 5px;
  float: left;
  width: 400px;
  
}
#tablaCategoria{
     border: 1px solid #ddd;
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
tr:hover, tr.selected {
    background-color: #FFCF8B
}
td {padding: 5px;}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="padre">
           <div id="hijo">
                <form action="ProductoControlador?accion=modificar" method="POST">
                 <h2> Producto </h2>
                 <label for="fname">codigo</label><br>
                 <input type="text" id="codigo" name="codigo" value="<c:out value="${codigo}"/>"<br>
                 <label for="fname">nombre</label><br>
                 <input type="text" id="nombre" name="nombre" value="<c:out value="${nombre}" />"<br>
                  <label for="fname">precio</label><br>
                 <input type="text" id="precio" name="precio" value="<c:out value="${precio}" />"<br>
                 <label for="fname">categoria</label><br>
                 <input type="text" id="codigo_categoria" name="codigo_categoria" value="<c:out value="${codigo_categoria}" />"<br>
                 <input type="submit" value="modificar">
                </form> 
            </div>
           <div id="hijo"> 
                <h3>lista Categorias</h3>
                <table id="tablaCategoria"  >
                    <tr>
                       <th>CODIGO</th>
                       <th>NOMBRE</th> 
                    </tr>
                     <c:forEach var="categoria" items="${listaCategoria}">
                     <tr>
                       <td onclick="getCellValue(this)"><c:out value = "${categoria.get(0)}" /></td>
                       <td onclick="getCellValue(this)"><c:out value = "${categoria.get(1)}" /></td>
                     </tr>
                     </c:forEach>
                </table>
            </div>
          <script>
            function getCellValue(x) {
              var Text =  x.textContent;
              //console.log(Text);
              console.log(x.parentElement.children[0].textContent);
              document.getElementById("codigo_categoria").value = x.parentElement.children[0].textContent;
              
              
            }
          </script>
    </body>
</html>
