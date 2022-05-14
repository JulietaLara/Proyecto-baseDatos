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
public class TipoSancion {
    private int idTS;
    private String nombreTS;
    private String ArticuloTS;

    public TipoSancion() {
    }

    public TipoSancion(int idTS, String nombreTS, String ArticuloTS) {
        this.idTS = idTS;
        this.nombreTS = nombreTS;
        this.ArticuloTS = ArticuloTS;
    }

    public int getIdTS() {
        return idTS;
    }

    public void setIdTS(int idTS) {
        this.idTS = idTS;
    }

    public String getNombreTS() {
        return nombreTS;
    }

    public void setNombreTS(String nombreTS) {
        this.nombreTS = nombreTS;
    }

    public String getArticuloTS() {
        return ArticuloTS;
    }

    public void setArticuloTS(String ArticuloTS) {
        this.ArticuloTS = ArticuloTS;
    }

    @Override
    public String toString() {
        return "TipoSancion{" + "idTS=" + idTS + ", nombreTS=" + nombreTS + ", ArticuloTS=" + ArticuloTS + '}';
    }
    
    

   
    
    
    
}
