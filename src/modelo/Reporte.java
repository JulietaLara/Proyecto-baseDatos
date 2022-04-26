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
public class Reporte {
    private String codigo; 
    private String zona;
    private String descripcion; 
    private Date fechaReporte; 
    private String estado; 

    public Reporte() {
    }

    public Reporte(String codigo, String zona, String descripcion, Date fechaReporte, String estado) {
        this.codigo = codigo;
        this.zona = zona;
        this.descripcion = descripcion;
        this.fechaReporte = fechaReporte;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reporte{" + "codigo=" + codigo + ", zona=" + zona + ", descripcion=" + descripcion + ", fechaReporte=" + fechaReporte + ", estado=" + estado + '}';
    }
    
    
}
