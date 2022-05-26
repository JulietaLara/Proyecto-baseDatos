/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.ConexionBD;
import modelo.Denuncia;

/**
 *
 * @author Usuario
 */
public class ControllerDenuncia {

    public boolean insertDenuncia(Denuncia objDenuncia) {
        String sql="insert into denuncias(descripcionD, estadoD, foto1Evidencia, idCiudadnoFK, idzonasFK) values(?, ?, ?, ?, ?)";
        boolean t=false;
        
        ConexionBD objd=new ConexionBD();
        t=objd.insertarDenuncia(objDenuncia, sql);
        
        return t;
    }
    
}
