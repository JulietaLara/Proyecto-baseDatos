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
public class Infraccion {
    private String referencia;
    private String tipoInfraccion; 

    public Infraccion() {
    }

    public Infraccion(String referencia, String tipoInfraccion) {
        this.referencia = referencia;
        this.tipoInfraccion = tipoInfraccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipoInfraccion() {
        return tipoInfraccion;
    }

    public void setTipoInfraccion(String tipoInfraccion) {
        this.tipoInfraccion = tipoInfraccion;
    }

    @Override
    public String toString() {
        return "Infraccion{" + "referencia=" + referencia + ", tipoInfraccion=" + tipoInfraccion + '}';
    }
    
    
}
