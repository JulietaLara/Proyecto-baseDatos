/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.ConexionBD;
import modelo.SancionDenuncia;

/**
 *
 * @author Felipe
 */
public class ControllerSancion {
    
    public boolean insertSancion(SancionDenuncia objSancion) {
        String sql="insert into sanciones(condena, cantidadSM, estado, codigoDFK) values(?, ?, ?, ?)";
        boolean t=false;
        
        ConexionBD objd=new ConexionBD();
        t=objd.insertarSancion(objSancion, sql);
        
        return t;
    }
}
