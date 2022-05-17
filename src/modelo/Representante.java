/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Representante {
    private String idR;
    private String nombre1R;
    private String nombre2R;
    private String apellido1R;
    private String apeliido2R;
    private String telefonoR;
    private String correoR;
    private String passR;
    private String fechaRegistroR;

    public Representante() {
    }

    public Representante(String idR, String nombre1R, String nombre2R, String apellido1R, String apeliido2R, String telefonoR, String correoR, String passR, String fechaRegistroR) {
        this.idR = idR;
        this.nombre1R = nombre1R;
        this.nombre2R = nombre2R;
        this.apellido1R = apellido1R;
        this.apeliido2R = apeliido2R;
        this.telefonoR = telefonoR;
        this.correoR = correoR;
        this.passR = passR;
        this.fechaRegistroR = fechaRegistroR;
    }

    public String getIdR() {
        return idR;
    }

    public void setIdR(String idR) {
        this.idR = idR;
    }

    public String getNombre1R() {
        return nombre1R;
    }

    public void setNombre1R(String nombre1R) {
        this.nombre1R = nombre1R;
    }

    public String getNombre2R() {
        return nombre2R;
    }

    public void setNombre2R(String nombre2R) {
        this.nombre2R = nombre2R;
    }

    public String getApellido1R() {
        return apellido1R;
    }

    public void setApellido1R(String apellido1R) {
        this.apellido1R = apellido1R;
    }

    public String getApeliido2R() {
        return apeliido2R;
    }

    public void setApeliido2R(String apeliido2R) {
        this.apeliido2R = apeliido2R;
    }

    public String getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(String telefonoR) {
        this.telefonoR = telefonoR;
    }

    public String getCorreoR() {
        return correoR;
    }

    public void setCorreoR(String correoR) {
        this.correoR = correoR;
    }

    public String getPassR() {
        return passR;
    }

    public void setPassR(String passR) {
        this.passR = passR;
    }

    public String getFechaRegistroR() {
        return fechaRegistroR;
    }

    public void setFechaRegistroR(String fechaRegistroR) {
        this.fechaRegistroR = fechaRegistroR;
    }

    @Override
    public String toString() {
        return "Representante{" + "idR=" + idR + ", nombre1R=" + nombre1R + ", nombre2R=" + nombre2R + ", apellido1R=" + apellido1R + ", apeliido2R=" + apeliido2R + ", telefonoR=" + telefonoR + ", correoR=" + correoR + ", passR=" + passR + ", fechaRegistroR=" + fechaRegistroR + '}';
    }

    
    
    
    
}
