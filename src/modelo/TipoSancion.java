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
    private String ArticuloTS;
    private char penaAumentadaTS; 

    public TipoSancion() {
    }

    public TipoSancion(int idTS, String ArticuloTS, char penaAumentada) {
        this.idTS = idTS;
        this.ArticuloTS = ArticuloTS;
        this.penaAumentadaTS = penaAumentada;
    }

    public TipoSancion(String ArticuloTS, char penaAumentada) {
        this.ArticuloTS = ArticuloTS;
        this.penaAumentadaTS = penaAumentada;
    }

    public int getIdTS() {
        return idTS;
    }

    public void setIdTS(int idTS) {
        this.idTS = idTS;
    }

    public String getArticuloTS() {
        return ArticuloTS;
    }

    public void setArticuloTS(String ArticuloTS) {
        this.ArticuloTS = ArticuloTS;
    }

    public char getPenaAumentada() {
        return penaAumentadaTS;
    }

    public void setPenaAumentada(char penaAumentada) {
        this.penaAumentadaTS = penaAumentada;
    }

    @Override
    public String toString() {
        return "TipoSancion{" + "idTS=" + idTS + ", ArticuloTS=" + ArticuloTS + ", penaAumentada=" + penaAumentadaTS + '}';
    }
    
    

   
    
    

   
    
    
    
}
