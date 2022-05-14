/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bases;

import Controlador.Imagen;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelo.Denuncia;

/**
 *
 * @author Usuario
 */
public class BaseDatos {
    Connection conexion;
    Statement st;

    public BaseDatos() {
        //conexion
    }

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion() {
        String nameDB = "denuncia";
        String userDB = "root";
        String pwdDB = "root";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/uao", "root", "root");
            String sourceURL = "jdbc:mysql:///" + nameDB;
            conexion = DriverManager.getConnection(sourceURL, userDB, pwdDB);
            //Objeto para manejo de sentencias SQL
            st = conexion.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return estado regresa el estado de la ejecución, true(éxito) o
     * false(error)
     *     
*/
    public boolean ejecutarSQL(String sql) {
        
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar la instrucción SELECT
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     *     
*/
    public String ejecutarSQLSelect(String sql) {
        ResultSet rs;
        int id;
        String nom = "";
        String tel = "";
        String dir = "";
        String concatenar = "";

        try {
            Statement sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
                nom = rs.getNString("nombreusuario");
                tel = rs.getNString("cedulausuario");
                dir = rs.getNString("celusuario");

                concatenar = id + " " + nom + " " + tel + " " + dir;
            }

        } catch (SQLException ex) {
           ex.printStackTrace ();
            return null;
        }

        return concatenar;
    }

    public boolean UpdateDenuncia(Denuncia denunciamod, Imagen imagen) throws SQLException, IOException {
        boolean modificar = false;
        FileInputStream fis = null;
        String update = "update estudiantes set idestudiantes = ?,"
                + "codigoestudiante=?,"
                + "nombreestudiante=?,"
                + "apellidoestudiante=?,"
                + "telefonoestudiante=?,"
                + "direccionestudiante=?,"
                + "correoestudiante=?,"
                + "imagenestudiante=? where codigoestudiante = ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(update);
        preparedStmt.setString(1, denunciamod.getCodigoD());
        preparedStmt.setString(2, denunciamod.getDescripcionD());
        preparedStmt.setString(3, denunciamod.getEstadoD());
        preparedStmt.setString(4, denunciamod.getFoto1evidencia());
        preparedStmt.setDate(6, (Date) denunciamod.getFechaRegistroD());
        

        
        if (!"".equals(denunciamod.getFoto1evidencia())) {
            File file = new File(denunciamod.getFoto1evidencia());
            try {
                fis = new FileInputStream(file);
                preparedStmt.setBinaryStream(8, fis, (int) file.length());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStmt.setString(9, denunciamod.getCodigoD());

            preparedStmt.executeUpdate();
            preparedStmt.close();
            modificar = true;
        } else {
            if (imagen != null) { //tengan cuidado con estas rutas... deben cambiarlas
                ImageIO.write((RenderedImage) imagen.getImagen(), "jpg", new File("C://Users//Alejo//Documents//David//david.jpg"));
                File imageFile = new File("C://Users//Alejo//Documents//David//david.jpg");
                fis = new FileInputStream(imageFile);
                preparedStmt.setBinaryStream(8, fis, (int) imageFile.length());

                preparedStmt.setString(9, denunciamod.getCodigoD());

                preparedStmt.executeUpdate();
                preparedStmt.close();
                modificar = true;
            }
        }

        return modificar;
    }

    public void storeProcedious() {
        CallableStatement statemen;
        try {
            statemen = conexion.prepareCall("{call INSERT_USUARIO(%,%,%)}");
            statemen.setString(1, "Gloria");
            statemen.setString(2, "3344");
            statemen.setString(3, "CAlle Medellin 7345");
            if (statemen.execute()) {
                System.out.println("si se realizó ");
            }

        } catch (Exception ex) {

        }
    }

    public void storeProcediousImage(String ruta) {
        CallableStatement statemen;
        FileInputStream fis = null;

        try {
            statemen = conexion.prepareCall("{call INSERT_USUARIO_PICTURE(?,?,?,?)}");
            File file = new File(ruta);
            System.out.println("ruta " + ruta);
            fis = new FileInputStream(file);
            statemen.setString(1, "Maria");
            statemen.setString(2, "555");
            statemen.setString(3, "Itagui");
            statemen.setBinaryStream(4, fis, (long) file.length());
            if (!statemen.execute()) {
                System.out.println("si se realizó ");
            }

        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean sqlInsertWithImage(String ruta, String insert) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, "1135");
            ps.setString(2, "David");
            ps.setString(3, "Benavides");
            ps.setString(4, "30156");
            ps.setBinaryStream(5, fis, (int) file.length());
            //ps.setString(2, nombre);
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean sqlInsertWithImageDenuncia(String ruta, String insert, String codigo, String zona, String descripcion, String estado, String rutaImagenEvidencia, Date fechaRegistro) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            
            conexion.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, codigo);
            ps.setString(2, zona);
            ps.setString(3, descripcion);
            ps.setString(4, estado);
            ps.setString(5, rutaImagenEvidencia);
            ps.setString(6, String.valueOf(fechaRegistro));  
            ps.setBinaryStream(7, fis, (int) file.length());
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
//que es esto??
    public ArrayList buscarCodigo(String buscarpor) throws IOException {
        ArrayList arrElementos = new ArrayList();
        String cadena = "";
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM estudiantes WHERE codigoestudiante=" + buscarpor + "");
            while (rs.next()) {
                Imagen imagen = new Imagen();
                String idestudiantes = rs.getObject("idestudiantes").toString();
                String codigoestudiante = rs.getObject("codigoestudiante").toString();
                String nombreestudiante = rs.getObject("nombreestudiante").toString();
                String apellidoestudiante = rs.getObject("apellidoestudiante").toString();
                String telefonoestudiante = rs.getObject("telefonoestudiante").toString();
                String direccionestudiante = rs.getObject("direccionestudiante").toString();
                String correoestudiante = rs.getObject("correoestudiante").toString();
                Blob blob = rs.getBlob("imagenestudiante");

                arrElementos.add(idestudiantes);
                arrElementos.add(codigoestudiante);
                arrElementos.add(nombreestudiante);
                arrElementos.add(apellidoestudiante);
                arrElementos.add(telefonoestudiante);
                arrElementos.add(direccionestudiante);
                arrElementos.add(correoestudiante);

                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
//
                imagen.setImagen(img);

                arrElementos.add(imagen.getImagen());
//                imagen.setNombre(nombre);
//                lista.add(imagen);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrElementos;
    }
    
}
