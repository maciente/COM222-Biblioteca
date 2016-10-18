<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Publicação</title>
    </head>
    <body>
        <h3>Dados da Publicação</h3>
        <form method = "post" action = "/Biblioteca/ConsultarPublicacao">
            <p>Pesquisar por: </p>
            <p>
                <input type="radio" name="fonte" value="isbn" checked> ISBN: 
                <input type = "text" name = "isbn" size = "15"><br>
                <input type="radio" name="fonte" value="titulo"> Título: 
                <input type = "text" name = "titulo" size = "40"><br>
            </p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>
