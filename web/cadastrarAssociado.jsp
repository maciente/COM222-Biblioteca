<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Associado</title>
    </head>
    <body>
        <h3>Dados do Associado</h3>
        <form method = "post" action = "/Biblioteca/CadastrarAssociado">
            <p>Código: <input type = "text" name = "codigo" size = "11"></p>
            <p>Nome: <input type = "text" name = "nome" size = "30"></p>
            <p>Senha: <input type = "password" name = "senha" size = "12"></p>
            <p>Email: <input type = "text" name = "email" size = "40"></p>
            <p>Endereço: <input type = "text" name = "endereco" size = "50"></p>
            <p>Tipo: </p>
            <p>
                <input type="radio" name="tipo" value="Grad" checked> Aluno de graduação<br>
                <input type="radio" name="tipo" value="Posgrad"> Aluno de pós-graduação<br>
                <input type="radio" name="tipo" value="Prof"> professor 
            </p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>
