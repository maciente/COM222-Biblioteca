<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Publicação</title>
    </head>
    <body>
        <h3>Dados da Publicação</h3>
        <form method = "get" action = "/Biblioteca/CadastrarPublicacao">
            <p>ISBN: <input type = "text" name = "isbn" size = "15"></p>
            <p>Titulo: <input type = "text" name = "titulo" size = "40"></p>
            <p>Autor: <input type = "text" name = "autor" size = "40"></p>
            <p>Editora: <input type = "text" name = "editora" size = "30"></p>
            <p>Ano de Publicação: <input type = "text" name = "ano" size = "4"></p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>
