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
    private String articulo; 
    private String razones; 
    private char penaAumentada; 

    public TipoSancion() {
    }

    public TipoSancion(String articulo, String razones, char penaAumentada) {
        this.articulo = articulo;
        this.razones = razones;
        this.penaAumentada = penaAumentada;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getRazones() {
        return razones;
    }

    public void setRazones(String razones) {
        this.razones = razones;
    }

    public char getPenaAumentada() {
        return penaAumentada;
    }

    public void setPenaAumentada(char penaAumentada) {
        this.penaAumentada = penaAumentada;
    }

    @Override
    public String toString() {
        return "TipoSancion{" + "articulo=" + articulo + ", razones=" + razones + ", penaAumentada=" + penaAumentada + '}';
    }
    
    
    
}
