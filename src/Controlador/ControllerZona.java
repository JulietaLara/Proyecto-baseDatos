/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.LinkedList;
import modelo.ConexionBD;
import modelo.Zona;

/**
 *
 * @author dacastro
 */
public class ControllerZona {

    public LinkedList<Zona> consutlarZonas() {
        String sql="select * from zonas";
        ConexionBD objc=new ConexionBD();
        LinkedList<Zona> lz=objc.consultarZonas(sql);
        
        return lz;
    }
    
}
