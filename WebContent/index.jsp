<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" />
<title>Acceso de Usuario</title>
</head>
<body>
<div class="container">
<div class="register">
<h1>Acceso de usuario</h1>
<form action="SERVLOGIN" method="post">
<label for="name"><b>Usuario</b></label>
<input type="text" name="user" />
<label for="name"><b>Contraseña</b></label>
<input type="password"name="pass" />
<p><% if(request.getAttribute("mensaje")!= null){ %>
     <%= request.getAttribute("mensaje")%>
<% }%></p>

<input type="submit" class="registerbtn" name="btnLogin" value="Iniciar Sesion" />

</form>
<a href="register.jsp">Registrar</a>
</div>
</div>

<%
	HttpSession sesion = request.getSession();
	boolean status = false; 
	if(request.getAttribute("status") != null){
		status = (Boolean)request.getAttribute("status");
		if(status == true){
			
			sesion.setAttribute("user", request.getAttribute("user"));
			sesion.setAttribute("status", request.getAttribute("status"));
			//Redireccionamos hacia el panel de usuario
			response.sendRedirect("User/panel.jsp");
		}
	}
	if(request.getParameter("cerrar") != null){
		session.invalidate();
	}
%>
</body>
</html>