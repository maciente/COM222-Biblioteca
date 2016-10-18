<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Empréstimo</title>
    </head>
    <body>
        <h3>Dados do Empréstimo</h3>
        <form method = "post" action = "/Biblioteca/RealizarEmprestimo">
            <p>ISBN: <input type = "text" name = "isbn" size = "15"></p>
            <p>Numero do Exemplar: <input type = "text" name = "numero" size = "10"></p>
            <p>Código do Associado: <input type = "text" name = "codigo" size = "15"></p>
            <p>Data do Empréstimo: <input type = "text" pattern="\d{1,2}/\d{1,2}/\d{4}" name = "data" size = "10"></p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>
