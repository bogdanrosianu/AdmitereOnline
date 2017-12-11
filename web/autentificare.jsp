<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="ServletAutentificare" method="POST">
            <div style="width: 40%; margin: 0 auto;">
                <h1>INTRA IN CONT !</h1>
            NUME DE UTILIZATOR <br>
            <input type="text" class="form-control" id="ex3" name="nume_de_utilizator">
            <br> <br>
            PAROLA <br>
            <input type="password" class="form-control" id="ex3" name="parola">
            <br> <br>
            <input type="submit" value="LOGARE">
            </div>
           
            
        </form>
    </body>
</html>
