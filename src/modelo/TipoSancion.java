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
    private char penaAumentada; 

    public TipoSancion() {
    }

    public TipoSancion(int idTS, String ArticuloTS, char penaAumentada) {
        this.idTS = idTS;
        this.ArticuloTS = ArticuloTS;
        this.penaAumentada = penaAumentada;
    }

    public TipoSancion(String ArticuloTS, char penaAumentada) {
        this.ArticuloTS = ArticuloTS;
        this.penaAumentada = penaAumentada;
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
        return penaAumentada;
    }

    public void setPenaAumentada(char penaAumentada) {
        this.penaAumentada = penaAumentada;
    }

    @Override
    public String toString() {
        return "TipoSancion{" + "idTS=" + idTS + ", ArticuloTS=" + ArticuloTS + ", penaAumentada=" + penaAumentada + '}';
    }
    
    

   
    
    

   
    
    
    
}
