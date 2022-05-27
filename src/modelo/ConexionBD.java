/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.Imagen;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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

//    public boolean insertDenuncia(Denuncia objf) {
//        boolean t = false;
//
//        String sql = "insert into Denuncia(descripcionD,foto1Evidencia)" + " values('" + objf.getDescripcionD() + "','" + objf.getFoto1evidencia() + "');";
//        ConexionBD objcbd = new ConexionBD();
//        t = objcbd.ejecutarSQL(sql);
//
//        return t;
//    }
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

    public String validarAutorizacionUsuario(String userBuscar, String passwordBuscar) {
        ArrayList arrayElementos = new ArrayList();
        String idCiudadano = "";
        String perfil = "";

        String sqlQuery = "SELECT * FROM ciudadanos WHERE nombre1C= '" + userBuscar + "' AND passC= '" + passwordBuscar + "' ";

        try {
            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                idCiudadano = rs.getString("idCiudadano");
                //perfil = rs.getObject("nombre1C").toString();
                //arrayElementos.add(perfil);
            } //fin while

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idCiudadano;
    }

    public boolean insertarDenuncia(Denuncia unaDenuncia, String sql) {
        FileInputStream fis; //borrar si no hay imagen, audio o vídeo
        PreparedStatement ps;
        boolean t = false;
        try {
            if (crearConexion()) {
                conexion.setAutoCommit(false);
                ps = conexion.prepareStatement(sql);
                ps.setString(1, unaDenuncia.getDescripcionD());
                ps.setString(2, unaDenuncia.getEstadoD());
                File file = new File(unaDenuncia.getFoto1Evidencia());
                fis = new FileInputStream(file);
                ps.setBinaryStream(3, fis, (int) file.length());
                ps.setString(4, unaDenuncia.getIdCiudadnoFK());
                ps.setInt(5, unaDenuncia.getIdzonasFK());
                ps.executeUpdate();
                conexion.commit();

                return t = true;
            }
        } catch (IOException | SQLException ex) {
            t = false;
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public boolean Zona(Zona zona) {
        Random ramdomnum = new Random();
        int value = ramdomnum.nextInt(999999 + 100000) + 100000;
        String codz = String.valueOf(ramdomnum);

        PreparedStatement ps;

        String sqlInsert = "INSERT INTO zonas (nombreZ,descripcionZ) "
                + "VALUES(?,?,?,?)";

        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sqlInsert);
            ps.setString(1, codz);
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

    public ArrayList buscarIdentificacionCliente(String buscarpor) {
        ArrayList arrayElementos = new ArrayList();
        String sqlQuery = "SELECT * FROM denuncias WHERE codigoD= '" + buscarpor + "' ";
       // String sqlQuery1 = "SELECT * FROM zonas WHERE nombreZ= '" + buscarpor + "' ";

        try {
            ResultSet rs = st.executeQuery(sqlQuery);
            //ResultSet rs1 = st.executeQuery(sqlQuery1);
            while (rs.next()
                    //&&rs1.next()
                    ) {
                Imagen imagen = new Imagen(); //borrar si no hay imagen, audio o vídeo
                String codigo = rs.getObject("codigoD").toString();
                String descripcion = rs.getObject("descripcionD").toString();
                String estado = rs.getObject("estadoD").toString();
                String fechaRegistro = rs.getObject("fechaRegistroD").toString();
                //String zona = rs1.getObject("nombreZ").toString();

                arrayElementos.add(codigo); //0
                arrayElementos.add(descripcion); //1
                arrayElementos.add(estado); //2
                arrayElementos.add(fechaRegistro); //3
                //arrayElementos.add(zona); //4

                //borrar líneas siguientes si no hay imagen, audio o vídeo
                if (rs.getBlob("foto1Evidencia") != null) {
                    Blob blob = rs.getBlob("foto1Evidencia"); //borrar si no hay imagen, audio o vídeo
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    imagen.setImagen(img);
                    arrayElementos.add(imagen.getImagen()); //7
                } else {
                    arrayElementos.add(""); //7
                }

            } //fin while

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayElementos;
    }

    public LinkedList<Zona> consultarZonas(String sql) {
        LinkedList<Zona> lz = new LinkedList<>();
        ResultSet rs;
        int idZona;
        String nombreZ;
        String descripcionZ;
        if (crearConexion()) {
            try {
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    idZona = rs.getInt("idZona");
                    nombreZ = rs.getString("nombreZ");
                    descripcionZ = rs.getString("descripcionZ");

                    Zona objz = new Zona(idZona, nombreZ, descripcionZ);
                    lz.add(objz);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lz;

    }
    
    public boolean insertarSancion(SancionDenuncia unaSancion, String sql) {

        PreparedStatement ps;
        boolean t = false;
        try {
            if (crearConexion()) {
                conexion.setAutoCommit(false);
                ps = conexion.prepareStatement(sql);
                ps.setString(3, unaSancion.getEstado());
                ps.setInt(1, unaSancion.getCondena());
                ps.setDouble(2,unaSancion.getCantidadSM());
                ps.executeUpdate();
                conexion.commit();

                return t = true;
            }
        } catch (SQLException ex) {
            t = false;
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public boolean insertarTipoSancion(TipoSancion objTSancion, String sql) {
        PreparedStatement ps;
        boolean t = false;
        try {
            if (crearConexion()) {
                conexion.setAutoCommit(false);
                ps = conexion.prepareStatement(sql);
                ps.setString(2,objTSancion.getArticuloTS());
                ps.setString(3,objTSancion.getPenaAumentadaTS());
                ps.setString(4,String.valueOf(objTSancion.getIdSFK()));
                ps.executeUpdate();
                conexion.commit();

                return t = true;
            }
        } catch (SQLException ex) {
            t = false;
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }
}
