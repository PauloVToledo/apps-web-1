<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="Styles.css">
  <title>Menú Principal de Usuarios</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f5f5f5;
    }

    h1 {
      text-align: center;
      color: #333;
      padding: 20px;
      background-color: #4caf50; /* Verde claro */
      margin: 0;
    }

    form {
      text-align: center;
      margin-top: 20px;
    }

    .boton {
      padding: 25px 40px; /* Ajustar el padding para hacer el botón más grande */
      font-size: 30px; /* Ajustar el tamaño de la fuente para hacer el botón más grande */
      background-color: #008CBA; /* Azul */
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    .boton:hover {
      background-color: #005a80; /* Azul oscuro al pasar el mouse */
    }
  </style>
</head>
<body>
<h1>Menú Principal de Usuarios</h1>
<form action="registroUsuario" method="get">
  <button type="submit" class="boton registrar">Registrar Usuario</button>

</form>
</body>
</html>
