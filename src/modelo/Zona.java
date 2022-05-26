/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Zona {
    private int idZona;
    private String nombreZ;
    private String descripcionZ;

    public Zona() {
    }

    public Zona(int idZona, String nombreZ, String descripcionZ) {
        this.idZona = idZona;
        this.nombreZ = nombreZ;
        this.descripcionZ = descripcionZ;
    }

    public Zona(String nombreZ, String descripcionZ) {
        this.nombreZ = nombreZ;
        this.descripcionZ = descripcionZ;
    }
    
    

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNombreZ() {
        return nombreZ;
    }

    public void setNombreZ(String nombreZ) {
        this.nombreZ = nombreZ;
    }

    public String getDescripcionZ() {
        return descripcionZ;
    }

    public void setDescripcionZ(String descripcionZ) {
        this.descripcionZ = descripcionZ;
    }

    @Override
    public String toString() {
        return "Zona{" + "idZona=" + idZona + ", nombreZ=" + nombreZ + ", descripcionZ=" + descripcionZ + '}';
    }
    
    public boolean insertarzonas(ArrayList<Zona> arrayZona){
        ConexionBD objBases=new ConexionBD();
        boolean conexion;
        boolean insertar=false;
        
        for (Zona unaZona : arrayZona) {
            conexion=objBases.crearConexion();
            if (conexion) {
                insertar = objBases.Zona(unaZona);
            }
        }
        
        return insertar;
    }
}
