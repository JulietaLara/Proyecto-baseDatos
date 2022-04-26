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
public class Denuncia {
    private String codigo; 
    private String zona; 
    private String descripcion; 
    private String recomendaciones; 
    private String estado; 
    private Date fechaRegistro; 

    public Denuncia() {
    }

    public Denuncia(String codigo, String zona, String descripcion, String recomendaciones, String estado, Date fechaRegistro) {
        this.codigo = codigo;
        this.zona = zona;
        this.descripcion = descripcion;
        this.recomendaciones = recomendaciones;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
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

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "codigo=" + codigo + ", zona=" + zona + ", descripcion=" + descripcion + ", recomendaciones=" + recomendaciones + ", estado=" + estado + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
}
