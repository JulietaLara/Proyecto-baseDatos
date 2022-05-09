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
    private Date fechaRegistro; 
    private int condena; 
    private int  multa; 
    private String estado; 

    public SancionDenuncia() {
    }

    public SancionDenuncia(Date fechaRegistro, int condena, int multa, String estado) {
        this.fechaRegistro = fechaRegistro;
        this.condena = condena;
        this.multa = multa;
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCondena() {
        return condena;
    }

    public void setCondena(int condena) {
        this.condena = condena;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "SancionDenuncia{" + "fechaRegistro=" + fechaRegistro + ", condena=" + condena + ", multa=" + multa + ", estado=" + estado + '}';
    }
    
    
    
}
