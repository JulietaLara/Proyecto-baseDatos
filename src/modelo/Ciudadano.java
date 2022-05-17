/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Ciudadano {
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

   
    

    


    
    
    
}
