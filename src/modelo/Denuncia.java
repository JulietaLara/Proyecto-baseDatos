/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Bases.BaseDatos;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Denuncia {
    private String codigo; 
    private String zona; 
    private String descripcion; 
    private String estado; 
    private Date fechaRegistro; 
    private String rutaImagenEvidencia; 

    public Denuncia() {
    }

    public Denuncia(String codigo, String zona, String descripcion, String estado, Date fechaRegistro, String rutaImagenEvidencia) {
        this.codigo = codigo;
        this.zona = zona;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.rutaImagenEvidencia = rutaImagenEvidencia;
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

    public String getRutaImagenEvidencia() {
        return rutaImagenEvidencia;
    }

    public void setRutaImagenEvidencia(String rutaImagenEvidencia) {
        this.rutaImagenEvidencia = rutaImagenEvidencia;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "codigo=" + codigo + ", zona=" + zona + ", descripcion=" + descripcion + ", estado=" + estado + ", fechaRegistro=" + fechaRegistro + ", rutaImagenEvidencia=" + rutaImagenEvidencia + '}';
    }
    
    public boolean insertarDenuncia(ArrayList<Denuncia> arrDen){
        String sql="";
        BaseDatos objBases=new BaseDatos();
        boolean conexion=false;
        boolean insertar=false;
        
        sql="INSERT INTO ESTUDIANTES (idestudiantes,codigoestudiante,nombreestudiante,apellidoestudiante,telefonoestudiante,direccionestudiante,correoestudiante,imagenestudiante) VALUES(?,?,?,?,?,?,?,?)";
        
        for (Denuncia arrDen1 : arrDen) {
            conexion=objBases.crearConexion();
            if (conexion) {
                insertar = objBases.sqlInsertWithImageDenuncia(arrDen1.getRutaImagenEvidencia(), sql, 
                        arrDen1.getCodigo(), arrDen1.getDescripcion(), arrDen1.getEstado(), 
                        arrDen1.getRutaImagenEvidencia(), arrDen1.getZona(), (java.sql.Date) arrDen1.getFechaRegistro()); 
            }
        }
        return insertar;
    }

   
}
