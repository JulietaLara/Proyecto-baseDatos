/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.ConexionBD;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Denuncia {

    private String codigoD;
    private String descripcionD;
    private String estadoD;
    private String foto1Evidencia;
    private String idCiudadnoFK;
    private int idzonasFK;

    public Denuncia() {
    }

    public Denuncia(String codigoD, String descripcionD, String estadoD, String foto1Evidencia, String idCiudadnoFK, int idzonasFK) {
        this.codigoD = codigoD;
        this.descripcionD = descripcionD;
        this.estadoD = estadoD;
        this.foto1Evidencia = foto1Evidencia;
        this.idCiudadnoFK = idCiudadnoFK;
        this.idzonasFK = idzonasFK;
    }

    public Denuncia(String descripcionD, String estadoD, String foto1Evidencia, String idCiudadnoFK, int idzonasFK) {
        this.descripcionD = descripcionD;
        this.estadoD = estadoD;
        this.foto1Evidencia = foto1Evidencia;
        this.idCiudadnoFK = idCiudadnoFK;
        this.idzonasFK = idzonasFK;
    }

    public String getCodigoD() {
        return codigoD;
    }

    public void setCodigoD(String codigoD) {
        this.codigoD = codigoD;
    }

    public String getDescripcionD() {
        return descripcionD;
    }

    public void setDescripcionD(String descripcionD) {
        this.descripcionD = descripcionD;
    }

    public String getEstadoD() {
        return estadoD;
    }

    public void setEstadoD(String estadoD) {
        this.estadoD = estadoD;
    }

    public String getFoto1Evidencia() {
        return foto1Evidencia;
    }

    public void setFoto1Evidencia(String foto1Evidencia) {
        this.foto1Evidencia = foto1Evidencia;
    }

    public String getIdCiudadnoFK() {
        return idCiudadnoFK;
    }

    public void setIdCiudadnoFK(String idCiudadnoFK) {
        this.idCiudadnoFK = idCiudadnoFK;
    }

    public int getIdzonasFK() {
        return idzonasFK;
    }

    public void setIdzonasFK(int idzonasFK) {
        this.idzonasFK = idzonasFK;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "codigoD=" + codigoD + ", descripcionD=" + descripcionD + ", estadoD=" + estadoD + ", foto1Evidencia=" + foto1Evidencia + ", idCiudadnoFK=" + idCiudadnoFK + ", idzonasFK=" + idzonasFK + '}';
    }

  

//    public boolean insertarDenuncia(ArrayList<Denuncia> arrDen){
//        String sql="";
//        BaseDatos objBases=new BaseDatos();
//        boolean conexion=false;
//        boolean insertar=false;
//        
//        sql="INSERT INTO ESTUDIANTES (idestudiantes,codigoestudiante,nombreestudiante,apellidoestudiante,telefonoestudiante,direccionestudiante,correoestudiante,imagenestudiante) VALUES(?,?,?,?,?,?,?,?)";
//        
//        for (Denuncia arrDen1 : arrDen) {
//            conexion=objBases.crearConexion();
//            if (conexion) {
//                insertar = objBases.sqlInsertWithImageDenuncia(arrDen1.getFoto1evidencia(), sql, 
//                        arrDen1.getCodigoD(), arrDen1.getDescripcionD(), arrDen1.getEstadoD(), 
//                        arrDen1.getFoto1evidencia(), arrDen1.getZona(), (java.sql.Date) arrDen1.getFechaRegistroD()); 
//            }
//        }
//        return insertar;
//    }
    
}


