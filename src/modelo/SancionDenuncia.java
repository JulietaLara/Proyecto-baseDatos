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
public class SancionDenuncia {

    private int idS;
    private String fechaRegistroS;
    private int condena;
    private double CantidadSM;
    private String Estado;
    private int codigoDFK; 

    public SancionDenuncia() {
    }

    public SancionDenuncia(int idS, String fecharegistroS, int condena, double CantidadSM, String Estado, int codigoDFK) {
        this.idS = idS;
        this.fechaRegistroS = fecharegistroS;
        this.condena = condena;
        this.CantidadSM = CantidadSM;
        this.Estado = Estado;
        this.codigoDFK=  codigoDFK; 
    }

    public SancionDenuncia(int condena, double CantidadSM, String Estado, int codigoDFK) {
        this.condena = condena;
        this.CantidadSM = CantidadSM;
        this.Estado = Estado;
        this.codigoDFK=  codigoDFK; 
    }

   
    

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getFecharegistroS() {
        return fechaRegistroS;
    }

    public void setFecharegistroS(String fecharegistroS) {
        this.fechaRegistroS = fecharegistroS;
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }

    public double getCantidadSM() {
        return CantidadSM;
    }

    public void setCantidadSM(double CantidadSM) {
        this.CantidadSM = CantidadSM;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFechaRegistroS() {
        return fechaRegistroS;
    }

    public void setFechaRegistroS(String fechaRegistroS) {
        this.fechaRegistroS = fechaRegistroS;
    }

    public int getCodigoDFK() {
        return codigoDFK;
    }

    public void setCodigoDFK(int codigoDFK) {
        this.codigoDFK = codigoDFK;
    }
    

    @Override
    public String toString() {
        return "SancionDenuncia{" + "idS=" + idS + ", fecharegistroS=" + fechaRegistroS + ", condena=" + condena + ", CantidadSM=" + CantidadSM + ", Estado=" + Estado + '}';
    }

}
