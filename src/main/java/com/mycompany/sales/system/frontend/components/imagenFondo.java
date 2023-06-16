package com.mycompany.sales.system.frontend.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

/**
 * @author Mavster
 */
public class imagenFondo extends JDesktopPane{
    //Puedes Cambiar el JPanel por cualquier comoponente. (Que acepte fondo).
    private Image fondo;
    
    @Override
    public void paintComponent(Graphics g){
        int height,width;
        //Sera Automatico y se acoplara a el JDesktopPane (En este caso)
        height=this.getSize().height;// Alto
        width=this.getSize().width;//   Largo 
        super.paintComponent(g);
        if(fondo!=null){
            g.drawImage(fondo, 0, 0, width,height,this);
        }
    }
    
    public void setBackgroung(String fondoImg){
        Image temp;
        this.setOpaque(false);
        URL direccion=ClassLoader.getSystemResource(fondoImg);
        temp=Toolkit.getDefaultToolkit().createImage(direccion);
        this.fondo=temp;
        this.repaint();
    }
    
}
