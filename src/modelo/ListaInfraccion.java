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
public class ListaInfraccion {
    private int cantidad; 
    private String autoridad; 

    public ListaInfraccion() {
    }

    public ListaInfraccion(int cantidad, String autoridad) {
        this.cantidad = cantidad;
        this.autoridad = autoridad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }

    @Override
    public String toString() {
        return "ListaInfraccion{" + "cantidad=" + cantidad + ", autoridad=" + autoridad + '}';
    }
    
    
}
