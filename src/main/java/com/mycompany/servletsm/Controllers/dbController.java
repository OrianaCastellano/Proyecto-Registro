package com.mycompany.servletsm.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbController {
    private final String userName = "root";
    private final String Pasword = "";
    private final String conectionString = "jdbc:mysql://localhost:3306/orillana";
    public  Connection Conexion = null;
    
    public void Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection(conectionString, userName, Pasword);}
        
        catch (Exception e) {
            e.printStackTrace();}
    }
    
    public void Desconectar(){
        try {Conexion.close();}
        catch (Exception e) {}
    }
    
}
