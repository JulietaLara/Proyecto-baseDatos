/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexionBD {
    public Connection conexion;
    public Statement st;

    public ConexionBD() {
    }

    public Connection getConexion() {
        return conexion;
    }

    public boolean crearConexion() {
        boolean t = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mineria",
                    "root", "root");
            st = conexion.createStatement();
            t = true;
        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        }

        return t;
    }

    public boolean ejecutarSQL(String sql) {
        boolean t = false;
        try {
            if (crearConexion()) {
                Statement sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql);
                t = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return t;
    }

   

    public boolean insertDenuncia( Denuncia objf) {
       boolean t=false;
        
        String sql="insert into Denuncia(descripcionD,foto1Evidencia)"+" values('"+objf.getDescripcionD()+"','"+objf.getFoto1evidencia()+"');";
        ConexionBD objcbd=new ConexionBD();
        t=objcbd.ejecutarSQL(sql);
        
        return t;
    }
    
     public boolean login(Ciudadano usr){
         PreparedStatement ps=null;
         ResultSet rs=null;
         Connection con= getConexion();
        
         String sql ="SELECT idCiudadano nombre1C nombre2C apellido1C apellido2C telefonoC correoC passC FROM Ciudadano WHERE nombre1C=?";
         
         try {
             ps=con.prepareStatement(sql);
             ps.setString(1, usr.getNombre1C());
             rs=ps.executeQuery();
             
             if(rs.next()){
                    if(usr.getPassC().equals(rs.getString(8))){
                        usr.setIdCiudadano(rs.getString(1));
                        usr.setNombre1C(rs.getString(2));
                        return true;
                    }else{
                        return false;
                    }
             }return false;
         } catch (SQLException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE,null,ex);
             return false;
         }
    }
    
     
}
