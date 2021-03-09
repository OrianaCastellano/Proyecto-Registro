package com.mycompany.servletsm.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class loginController extends dbController{
    
    public boolean ingresar(String usuario, String Contraseña){
        try {
            Conectar();
            Contraseña = new passwordController().getHast(Contraseña.getBytes());
            PreparedStatement ps = (PreparedStatement) Conexion.prepareStatement("SELECT COUNT(*) FROM usuario WHERE usuario = ? AND contraseña = ?");
                ps.setString(1, usuario);
                ps.setString(2, Contraseña);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next())
                    if(rs.getInt(1)>0)
                        return true;} 
        
        catch (Exception e) { }
        
        finally{Desconectar();}
    return false;}
    
}
