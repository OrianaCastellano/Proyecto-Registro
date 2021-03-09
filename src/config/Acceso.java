package config;
import java.sql.*;


public class Acceso {
	
	Database db= new Database(); 
	String sql="";
	PreparedStatement pst;
	ResultSet rs;
	
	public boolean Validar(String username, String password ) throws ClassNotFoundException {
		boolean status = false;
		Class.forName(db.getDriver());
		try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(),db.getPassword())) {
			//asignamos el controlador de la base de datos
			
			sql = "SELECT id from users WHERE username='"+username+"' AND password='"+password+"'";
			pst=con.prepareStatement(sql);
			//seteamos la respuesta en RS
			System.out.println("SQL= "+sql); // output 1
			rs = pst.executeQuery();
			
			status = rs.next();
			System.out.println("result= "+status); // output 1
			con.close();
			rs.close();
			
		} catch(SQLException e) {
			return status;
		}
		return status;
		
	}
	public boolean ValidarRegistro(String col, String val) throws ClassNotFoundException {
		boolean status = false;
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(),db.getPassword())) {
			//asignamos el controlador de la base de datos
			sql = "SELECT id from users WHERE "+col+"='"+val+"'";
			pst=con.prepareStatement(sql);
			//seteamos la respuesta en RS
			System.out.println("SQL2= "+sql); // output 1
			rs = pst.executeQuery();
			status = rs.next();

			con.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("error= "+e);
			return status;
		}
		return status;
	}
	
	public boolean Registrar(String username, String password, String name, String cedula, String telefono) throws ClassNotFoundException {
		boolean status = false;
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(),db.getPassword())) {
			//asignamos el controlador de la base de datos
			
			
			sql = "INSERT INTO public.users(name, cedula, username, password, telefono) VALUES ('"+name+"', '"+cedula+"', '"+username+"', '"+password+"','"+telefono+"') RETURNING *";
			pst=con.prepareStatement(sql);
			//seteamos la respuesta en RS
			System.out.println("SQL2= "+sql); // output 1
			//rs = pst.executeQuery();
			status = pst.execute();
			// <-- something like this.

			con.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("error= "+e);
			return status;
		}
		return status;
	}
}

