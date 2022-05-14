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
    private Date fecharegistroS;
    private int condena;
    private double CantidadSM;
    private String Estado;

    public SancionDenuncia() {
    }

    public SancionDenuncia(int idS, Date fecharegistroS, int condena, double CantidadSM, String Estado) {
        this.idS = idS;
        this.fecharegistroS = fecharegistroS;
        this.condena = condena;
        this.CantidadSM = CantidadSM;
        this.Estado = Estado;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public Date getFecharegistroS() {
        return fecharegistroS;
    }

    public void setFecharegistroS(Date fecharegistroS) {
        this.fecharegistroS = fecharegistroS;
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

    @Override
    public String toString() {
        return "SancionDenuncia{" + "idS=" + idS + ", fecharegistroS=" + fecharegistroS + ", condena=" + condena + ", CantidadSM=" + CantidadSM + ", Estado=" + Estado + '}';
    }

}
