/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Felipe
 */
public class Img extends javax.swing.JPanel {

    String ruta;

    public Img(int x, int y, String ruta) {
        this.setSize(x, y);
        this.ruta = ruta;
    }

    public void Paint(Graphics g) {
        
        Dimension height=getSize();
        ImageIcon img=new ImageIcon(getClass().getResource(ruta));
        
        g.drawImage(img.getImage(),0,0, WIDTH, WIDTH, this)
    }
}
