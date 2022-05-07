<%-- 
    Document   : login
    Created on : 2/03/2021, 08:42:45 PM
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
body {font-family: Arial, Helvetica, sans-serif; background-color:#9FD4FF; }
form {border: 2px solid #f1f1f1; width:75%; max-width: 600px; justify-content: center;
  align-items: center;  height: 50%}


input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;

}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}



        </style>
    </head>
   <body>
   <center> 
       <h1>Inicio de sesión</h1>
    <form action="validarlogin" method="post">
        <div class="imgcontainer">
    <img src="usu.png" alt="Avatar" class="avatar">
  </div>

        <input type="text" name="usuario" placeholder="Nombre de usuario"/><br/>

            <input type="password" name="password" placeholder="Contraseña"/><br/>
<br/>            
            <button type="submit">Login</button>
<br/>            
        </form>
   </center>
   </body>
</html>
