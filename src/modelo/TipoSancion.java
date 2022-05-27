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
    private String  penaAumentadaTS; 
    private int idSFK;

    public TipoSancion() {
    }

    public TipoSancion(int idTS, String ArticuloTS, String  penaAumentada, int idSFK) {
        this.idTS = idTS;
        this.ArticuloTS = ArticuloTS;
        this.penaAumentadaTS = penaAumentada;
        this.idSFK=  idSFK; 
    }

    public TipoSancion(String ArticuloTS, String penaAumentada, int idSFK) {
        this.ArticuloTS = ArticuloTS;
        this.penaAumentadaTS = penaAumentada;
        this.idSFK=  idSFK; 
    }
    public TipoSancion(String ArticuloTS, String penaAumentada) {
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

    public String getPenaAumentadaTS() {
        return penaAumentadaTS;
    }


    public void setPenaAumentada(String penaAumentada) {
        this.penaAumentadaTS = penaAumentada;
    }

    public int getIdSFK() {
        return idSFK;
    }

    public void setIdSFK(int idSFK) {
        this.idSFK = idSFK;
    }
    
    @Override
    public String toString() {
        return "TipoSancion{" + "idTS=" + idTS + ", ArticuloTS=" + ArticuloTS + ", penaAumentada=" + penaAumentadaTS + '}';
    }
    
    

   
    
    

   
    
    
    
}
