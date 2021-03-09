package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import config.Acceso;
/**
 * Servlet implementation class register
 */
@WebServlet("/SERVREGISTER")
public class SERVREGISTER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException, ClassNotFoundException {	

		String respuesta = "{ \"message\" : \"Error al registrar la data\" }"; 
		String name = request.getParameter("name");
		String cedula = request.getParameter("cedula");
		String username = request.getParameter("username");
		String password = request.getParameter("password2");
		String telefono = request.getParameter("telefono");
		//inicializar objeto de config.acceso
		Acceso acc = new Acceso();
		boolean result = false;
		boolean check_username = acc.ValidarRegistro("username", username); //verificar si existe el usuario
		boolean check_cedula = acc.ValidarRegistro("cedula", cedula); // verificar si existe la cedula
		if(check_username && check_cedula) {
			respuesta = "{ \"error\" : \"El usuario y la cedula ya estan registrados\" }";
		}else if(check_username) {
			 respuesta = "{ \"error\" : \"El usuario ya esta registrado\" }";
		   
		} else if (check_cedula){
			 respuesta = "{ \"error\" : \"La cedula ya esta registrado\" }";
		}else {
			result = acc.Registrar(username, password, name, cedula, telefono);
			if(result == true) {
				   respuesta = "{ \"message\" : \"Registro exitoso\" }";
			   }
		}
		//seteamos el tipo de respuesta   
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//creamos el objeto json para responder al usuario
		JSONObject jsonObject = new JSONObject(respuesta);
		out.print(jsonObject .toString());
    }

	/*Generado con Eclipse*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Generado con Eclipse*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
