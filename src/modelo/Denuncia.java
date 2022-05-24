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
    private String fechaRegistroD; 
    private String foto1Evidencia; 

    public Denuncia() {
    }

    public Denuncia(String codigoD, String descripcionD, String estadoD, String fechaRegistroD, String foto1evidencia) {
        this.codigoD = codigoD;
        this.descripcionD = descripcionD;
        this.estadoD = estadoD;
        this.fechaRegistroD = fechaRegistroD;
        this.foto1Evidencia = foto1evidencia;
    }

    public Denuncia(String descripcionD, String foto1Evidencia) {
        this.descripcionD = descripcionD;
        this.foto1Evidencia = foto1Evidencia;
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

    public String getFechaRegistroD() {
        return fechaRegistroD;
    }

    public void setFechaRegistroD(String fechaRegistroD) {
        this.fechaRegistroD = fechaRegistroD;
    }

    public String getFoto1evidencia() {
        return foto1Evidencia;
    }

    public void setFoto1evidencia(String foto1evidencia) {
        this.foto1Evidencia = foto1evidencia;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "codigoD=" + codigoD + ", descripcionD=" + descripcionD + ", estadoD=" + estadoD + ", fechaRegistroD=" + fechaRegistroD + ", foto1evidencia=" + foto1Evidencia + '}';
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
