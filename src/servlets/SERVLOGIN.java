package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importamos la libreria con la configuracion de la base de datos
import config.Acceso; 
/**
 * Servlet implementation class SERVLOGIN
 */
@WebServlet("/SERVLOGIN")
public class SERVLOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException, ClassNotFoundException {
    	//asignamos el tipo de respuesta 
    	response.setContentType("text/html;charset=UTF-8");
    		String username ;
    		String password ;
    		//inicializamos un objeto con la clase Acceso 
    		Acceso acc = new Acceso();// inicializamos el objeto de config.acceso
    		boolean status= false;
    		RequestDispatcher rd = null;
    		
    		if(request.getParameter("btnLogin") != null) {
    			username = request.getParameter("user"); //optenemos el valor de user desde el POST
    			password = request.getParameter("pass"); //optenemos el valor de pass desde el POST
    			//validamos si las credenciales existen
    			status = acc.Validar(username, password); //llamamos a la funcion validad dentro de la clase Acceso
    			if(status == true) {
    				request.setAttribute("status", true);
    			} else {
    				
        			//mensaje de error al no pasar las credenciales
        			request.setAttribute("mensaje", "Usuario o clave incorrectos");
        			//redireccionamos al login al con mensaje
        			
    			}
    			request.setAttribute("user", username);
    			rd = request.getRequestDispatcher("index.jsp"); //redireccionar
    		}
    		    		
    		rd.forward(request, response);
    	//}    	
		
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
