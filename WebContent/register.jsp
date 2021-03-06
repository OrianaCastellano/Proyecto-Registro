<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" />
<meta charset="ISO-8859-1">
<title>Registro de usuario</title>
</head>
<body>

<div class="container">
<div class="register">
<h1>Registro de usuario</h1>
<form class="registro-usuario" action="SERVREGISTER" method="post">
<label for="name"><b>Nombre</b></label><span id="error-name" class="error-msg"></span>
<input class="validate" type="text" id="name" name="name"  aria-required="true" placeholder="Ej. Juan Lopez" title="Enter input here"/>
<label for="cedula"><b>Cedula</b></label><span id="error-cedula" class="error-msg"></span>
<input class="validate" type="text" id="cedula" name="cedula"  onkeypress='return esNumero(event)' placeholder="Ej. 12345667" />
<label for="telefono"><b>Telefono</b></label><span id="error-telefono" class="error-msg"></span>
<input class="validate" type="text" id="telefono" name="telefono" onkeypress='return esNumero(event)' placeholder="Ej. 04241688529"/>
<label for="username"><b>Usuario</b></label><span id="error-username" class="error-msg"></span>
<input class="validate" type="text" id="username" name="username"  aria-required="true" placeholder="Ej. juanlopez28" />
<label for="password"><b>Contraseņa</b></label><span id="error-password" class="error-msg"></span>
<input class="validate" name="password" type="password"  id="password" aria-required="true"/>
<label for="password2"><b>Confirmar Contraseņa</b></label><span id="error-password2" class="error-msg"></span>
<input class="validate" type="password" id="password2" name="password2" placeholder=""/>
<input type="submit" class="registerbtn" name="btnRegister" value="Registrar" />
<span id="error-message" class="error-msg"></span>
</form>
<a href="index.jsp">Ya tengo una cuenta</a>
</div>
</div>

</body>
<script>

document.querySelector('.registro-usuario').addEventListener('submit', function(e) {
	//detenemos la propagacion del evento submit
	e.preventDefault();

    var formData = new FormData(this);//creamos un objeto tipo FormData para insertar los datos del formulario ()
    var data = serialize_form(formData)//serializamos el form para enviarlo como si un submit normal se tratase
    var validados = true;//validador final en caso de que todos los campos esten completos
    //recorremos el objeto form en busqueda de campos vacios
    for(let name of formData) {
		if(!validateField(name[0], name[1])){
			validados = false;//setear falso si el campo esta vacio
			
		}
    }
   	//validamos si las claves coinciden
    if(!validar_password('password', 'password2')){
    	validados = false;
    	//mensaje de error
    	document.getElementById('error-password2').innerHTML='Las contraseņas no coinciden'

    }
    
    //si no hay campos vacios o errores con las claves, hacemos una peticion ajax al servidor
    if(validados){
    	
    	ajax_request(this.action, data)
    }
    
    

});

function esNumero(evt){
	//bloquear uso de letras en campos de solo numero verificando su charCode numerico
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validar_password(idpassword, idpassword2){
	
	 var pass = document.getElementById(idpassword).value;
	 var pass2 = document.getElementById(idpassword2).value;
	 //si las claves son iguales, pasar
	 if(pass == pass2){
		 return true;
	 }
	 return false;
}
function ajax_request(action, data){
	//inicializamos el objeto ajax XMLHttpRequest()
	var request = new XMLHttpRequest();
	//manejador de la respuesta luego del request.send(data)
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	//convertimos el json en un objeto
            var json = JSON.parse(this.responseText);
            //devuelve errores durante el registro
            if(json.hasOwnProperty('error')){
            	document.getElementById("error-message").innerHTML='ERROR: '+json.error
            } else {
            	alert(json.message);
            	//redireccionamos al login para iniciar sesion
            	 window.location.href = "/registroUsuarios/index.jsp";
            }
           
       }
    };
    request.open("POST", action);//metodo y ruta para enviar el form
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
   	//enviamos la data
    request.send(data);//enviar data
}

function serialize_form(formData){
	return Array.from(formData,
  		  e => e.map(encodeURIComponent).join('=')
	).join('&')
}

function validateField(nombre, valor) {
	//verificamos si el campo esta vacio, en caso verdadero, insertar mensaje de error
	  if (valor == "") {
		  document.getElementById('error-'+nombre).innerHTML="Este campo es requerido"
	    return false;
	  } else {
		  document.getElementById('error-'+nombre).innerHTML=""
			return true;
	  }
	}
	</script>
</html>