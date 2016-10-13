<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Biblioteca</title>
    </head>
    <body>
        <h3>Login</h3>
        <form method = "get" action = "/Biblioteca/LoginAuthentication">
            <p>Código: <input type = "text" name = "codigo" size = "11"></p>
            <p>Senha: <input type = "password" name = "senha" size = "12"></p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
    </body>
</html>

