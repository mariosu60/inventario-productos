/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author mario
 */
public class FondoPanel extends JPanel{
    
    private Image imagen;
    
    public void paint(Graphics g){
        imagen=new ImageIcon(getClass().getResource("/imagenes/imagenesFondo.png")).getImage();
        g.drawImage(imagen, 0, 0,getWidth(),getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
