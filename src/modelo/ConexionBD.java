/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String nameDB = "mineria";
        String userDB = "root";
        String pwdDB = "root";
        boolean t = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sourceURL = "jdbc:mysql:///" + nameDB;//user  //pass
            conexion = DriverManager.getConnection(sourceURL, userDB, pwdDB);
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

    public boolean insertDenuncia(Denuncia objf) {
        boolean t = false;

        String sql = "insert into Denuncia(descripcionD,foto1Evidencia)" + " values('" + objf.getDescripcionD() + "','" + objf.getFoto1evidencia() + "');";
        ConexionBD objcbd = new ConexionBD();
        t = objcbd.ejecutarSQL(sql);

        return t;
    }

    public boolean registrar(Ciudadano usr) {

        PreparedStatement ps;

        String sqlInsert = "INSERT INTO ciudadanos (idCiudadano,nombre1C,nombre2C,apellido1C,apellido2C,telefonoC,correoC,passC) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sqlInsert);
            ps.setString(1, usr.getIdCiudadano());
            ps.setString(2, usr.getNombre1C());
            ps.setString(3, usr.getNombre2C());
            ps.setString(4, usr.getApellido1C());
            ps.setString(5, usr.getApellido2C());
            ps.setString(6, usr.getTelefonoC());
            ps.setString(7, usr.getCorreoC());
            ps.setString(8, usr.getPassC());

            
            ps.executeUpdate();
            ps.close();

            conexion.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean login(Ciudadano usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT idCiudadano nombre1C nombre2C apellido1C apellido2C telefonoC correoC passC FROM Ciudadano WHERE nombre1C=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre1C());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPassC().equals(rs.getString(8))) {
                    usr.setIdCiudadano(rs.getString(1));
                    usr.setNombre1C(rs.getString(2));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean validarAutorizacionUsuario(String userBuscar, String passwordBuscar) {
        ArrayList arrayElementos = new ArrayList();
        boolean autorizado=false;
        String perfil="";
        
        String sqlQuery = "SELECT * FROM ciudadanos WHERE nombre1C= '" + userBuscar + "' AND passC= '" + passwordBuscar+"' ";
        
        try {
            ResultSet rs = st.executeQuery(sqlQuery);
            
            while (rs.next()) {
                perfil = rs.getObject("nombre1C").toString();
                arrayElementos.add(perfil);
            } //fin while
            
            if(!arrayElementos.isEmpty())
            {
                autorizado = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autorizado;
    }

    boolean insertarDenuncia(Denuncia unaDenuncia) {
        FileInputStream fis; //borrar si no hay imagen, audio o vídeo
        PreparedStatement ps;
        
        String sqlInsert = "INSERT INTO denuncias (Descripcion,foto) "
                        + "VALUES(?,?,?,?,?,?,?,?)";
        
        try {            
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sqlInsert);
            ps.setString(2, unaDenuncia.getDescripcionD());
           
            
            if(!unaDenuncia.getFoto1evidencia().equals("")){
                File file = new File(unaDenuncia.getFoto1evidencia()); //borrar si no hay imagen, audio o vídeo
                fis = new FileInputStream(file); //borrar si no hay imagen, audio o vídeo
                ps.setBinaryStream(5, fis, (int) file.length()); //borrar si no hay imagen, audio o vídeo
                ps.executeUpdate();
                ps.close();
                fis.close(); //borrar si no hay imagen, audio o vídeo
            } else{
                ps.setString(4, null);
                ps.executeUpdate();
                ps.close();
            }
            
            conexion.commit();
            return true;
        } catch (IOException  | SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
      public boolean Zona(Zona zona) {

        PreparedStatement ps;

        String sqlInsert = "INSERT INTO zonas (nombreZ,descripcionZ) "
                + "VALUES(?,?,?,?)";

        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sqlInsert);
            ps.setString(2, zona.getNombreZ());
            ps.setString(3, zona.getDescripcionZ());
           

            
            ps.executeUpdate();
            ps.close();

            conexion.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
