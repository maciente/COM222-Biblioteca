<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Exemplar</title>
    </head>
    <body>
        <h3>Dados do Exemplar</h3>
        <form method = "post" action = "/Biblioteca/CadastrarExemplar">
            <p>ISBN: <input type = "text" name = "isbn" size = "15"></p>
            <p>Numero do exemplar: <input type = "text" name = "numero" size = "40"></p>
            <p>Preço do Livro: <input type = "text" name = "preco" size = "40"></p>
            <p>Situação: </p>
            <p>
                <input type="radio" name="situacao" value="disponivel" checked> Disponível<br>
                <input type="radio" name="situacao" value="emprestado"> Emprestado<br>
            </p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>
