/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class RepresentanteANM {
    private String usuario;
    private String contraseña; 
    private String sancion; 
    private String reporte; 

    public RepresentanteANM() {
    }

    public RepresentanteANM(String usuario, String contraseña, String sancion, String reporte) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.sancion = sancion;
        this.reporte = reporte;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    @Override
    public String toString() {
        return "RepresentanteANM{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", sancion=" + sancion + ", reporte=" + reporte + '}';
    }
    
    
}
