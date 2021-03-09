package config;

public class Database {
	private String url;
	private String password;
	private String user;
	private String driver;
	
	public Database() {
		//ruta de conexion a la base de datos mediante el controlador de java JDBC
		this.url = "jdbc:postgresql://localhost:5432/registrousuarios";
		//usuario de la base de datos
		this.user="postgres";
		//contraseña de la base de datos
		this.password="1234";
		//parametro de conexion al driver para postgres de java
		this.driver="org.postgresql.Driver";
	}

// las funciones siguientes corresponden a los getters que permitan devolver el valor de las variables declasradas dentro de la clase
	public String getUrl() {
		return url;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public String getDriver() {
		return driver;
	}

	
}
