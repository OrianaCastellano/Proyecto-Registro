package com.mycompany.servletsm.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class registerController extends dbController{
    public void registrar(String Nombre, String Direccion, String CP, String Telefono, int Edad, String Fecha, String Correo, String Usuario, String Password){
        try {
            Conectar();
            PreparedStatement ps = (PreparedStatement) Conexion.prepareStatement("INSERT INTO persona VALUES(null,?,?,?,?,?,?,?)");
                ps.setString(1, Nombre);
                ps.setString(2, Direccion);
                ps.setString(3, CP);
                ps.setString(4, Telefono);
                ps.setInt(5, Edad);
                ps.setString(6, Fecha);
                ps.setString(7, Correo);
                
                ps.executeUpdate(); 
        
                System.out.println(Usuario + Password);
                registrarUsuario(Usuario, Password);} 
        
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.toString());;}
        
        finally{Desconectar();}
    }
    
    
    private void registrarUsuario(String Usuario, String Contraseña){
    
        try {
            Conectar();
            PreparedStatement ps = (PreparedStatement) Conexion.prepareStatement("INSERT INTO usuario VALUES(null, ?, ?, ?)");
            ps.setInt(1, getMaxID());
            ps.setString(2, Usuario);
            ps.setString(3, new passwordController().getHast(Contraseña.getBytes()));
            ps.executeUpdate();} 
        
        catch (Exception e) { 
            e.printStackTrace();}
        
        finally{Desconectar();}
    }
    
    private int getMaxID(){
        int maxID = -1;
        
        try {
            Conectar();
            PreparedStatement ps = (PreparedStatement) Conexion.prepareStatement("SELECT MAX(ID) FROM persona");
            ResultSet rs = ps.executeQuery();
        
            if(rs.next())
                maxID = rs.getInt(1);}
        
        catch (Exception e) { 
            e.printStackTrace();}
        
        finally{Desconectar();}
        
        System.out.println(maxID);
    return maxID;}
}
