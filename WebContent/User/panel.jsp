<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%

HttpSession sesion = request.getSession();

if(sesion.getAttribute("status") == null){
	response.sendRedirect("../index.jsp");
	System.out.println("se recibe status null"); // output 1
} else {
	System.out.println("statuss= "+sesion.getAttribute("status")); // output 1
	// String status = sesion.getAttribute("status").toString();
	//if(status.equals("1")){
	//	response.sendRedirect("../index.jsp");
	//}
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/style.css" />
<title>Bienvenido</title>
</head>
<body>
<ul class="horizontal">
  <li class="rightli" style="float:right"><a href="../index.jsp?cerrar=true" >Cerrar Sesion</a></li>
</ul>
<div class="container">
<h1>Bienvenido....</h1>
<h2>Sesion iniciada</h2>
</div>


</body>
</html>