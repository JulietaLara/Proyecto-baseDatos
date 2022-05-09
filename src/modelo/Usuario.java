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
public class Usuario {
    private String nombreUsuario; 
    private String contraseña; 
    private Date fecha; 

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña, Date fecha) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", fecha=" + fecha + '}';
    }

    
    
    
    
}
