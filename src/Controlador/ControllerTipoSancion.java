/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.ConexionBD;
import modelo.TipoSancion;

/**
 *
 * @author Felipe
 */
public class ControllerTipoSancion {
    public boolean insertTSancion(TipoSancion objTSancion) {
        String sql="insert into tipos_sanciones(penaAumentadaTS, articuloTS, idSFK) values(?, ?, ?)";
        boolean t=false;
        
        ConexionBD objd=new ConexionBD();
        t=objd.insertarTipoSancion(objTSancion, sql);
        
        return t;
    }
}
