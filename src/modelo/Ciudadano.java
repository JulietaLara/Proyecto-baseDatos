/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Ciudadano extends ConexionBD{
    private String idCiudadano;
    private String nombre1C; 
    private String nombre2C; 
    private String apellido1C;
    private String apellido2C; 
    private String telefonoC; 
    private String correoC; 
    private String passC;
    private String fechaRegistroC;

    public Ciudadano() {
    }

    public Ciudadano(String idCiudadano, String nombre1C, String nombre2C, String apellido1C, String apellido2C, String telefonoC, String correoC, String passC, String fechaRegistroC) {
        this.idCiudadano = idCiudadano;
        this.nombre1C = nombre1C;
        this.nombre2C = nombre2C;
        this.apellido1C = apellido1C;
        this.apellido2C = apellido2C;
        this.telefonoC = telefonoC;
        this.correoC = correoC;
        this.passC = passC;
        this.fechaRegistroC = fechaRegistroC;
    }

    public Ciudadano(String idCiudadano, String nombre1C, String nombre2C, String apellido1C, String apellido2C, String telefonoC, String correoC, String passC) {
        this.idCiudadano = idCiudadano;
        this.nombre1C = nombre1C;
        this.nombre2C = nombre2C;
        this.apellido1C = apellido1C;
        this.apellido2C = apellido2C;
        this.telefonoC = telefonoC;
        this.correoC = correoC;
        this.passC = passC;
    }

    
   

   
    
    

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombre1C() {
        return nombre1C;
    }

    public void setNombre1C(String nombre1C) {
        this.nombre1C = nombre1C;
    }

    public String getNombre2C() {
        return nombre2C;
    }

    public void setNombre2C(String nombre2C) {
        this.nombre2C = nombre2C;
    }

    public String getApellido1C() {
        return apellido1C;
    }

    public void setApellido1C(String apellido1C) {
        this.apellido1C = apellido1C;
    }

    public String getApellido2C() {
        return apellido2C;
    }

    public void setApellido2C(String apellido2C) {
        this.apellido2C = apellido2C;
    }

    public String getTelefonoC() {
        return telefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        this.telefonoC = telefonoC;
    }

    public String getCorreoC() {
        return correoC;
    }

    public void setCorreoC(String correoC) {
        this.correoC = correoC;
    }

    public String getPassC() {
        return passC;
    }

    public void setPassC(String passC) {
        this.passC = passC;
    }

    public String getFechaRegistroC() {
        return fechaRegistroC;
    }

    public void setFechaRegistroC(String fechaRegistroC) {
        this.fechaRegistroC = fechaRegistroC;
    }

    @Override
    public String toString() {
        return "Ciudadano{" + "idCiudadano=" + idCiudadano + ", nombre1C=" + nombre1C + ", nombre2C=" + nombre2C + ", apellido1C=" + apellido1C + ", apellido2C=" + apellido2C + ", telefonoC=" + telefonoC + ", correoC=" + correoC + ", passC=" + passC + ", fechaRegistroC=" + fechaRegistroC + '}';
    }

    
    //Método para insertar clientes desde un ArrayList
    public boolean insertarCiudadanos(ArrayList<Ciudadano> arrayCiudadanos){
        ConexionBD objBases=new ConexionBD();
        boolean conexion;
        boolean insertar=false;
        
        for (Ciudadano unCiudadano : arrayCiudadanos) {
            conexion=objBases.crearConexion();
            if (conexion) {
                insertar = objBases.registrar(unCiudadano);
            }
        }
        
        return insertar;
    }
    
    
    
//    public boolean insertCiudadano(Ciudadano objcc) {
//       boolean t=false;
//        
//        String sql="insert into Ciudadanos(idCiudadano,nombre1C,nombre2C,apellido1C,apellido2C,telefonoC,correoC,passC)"+
//                " values('"+objcc.getIdCiudadano()+"','"+objcc.getNombre1C()+"','"+objcc.getNombre2C()+"','"+objcc.getApellido1C()+"'"
//                + ",'"+objcc.getApellido2C()+"','"+objcc.getTelefonoC()+"','"+objcc.getCorreoC()+"','"+objcc.getPassC()+"');";
//        ConexionBD objcbd=new ConexionBD();
//        t=objcbd.ejecutarSQL(sql);
//        
//        return t;
//    }
    
   

   
    

    


    
    
    
}
