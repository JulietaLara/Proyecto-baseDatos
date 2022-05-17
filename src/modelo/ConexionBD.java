/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    
}
