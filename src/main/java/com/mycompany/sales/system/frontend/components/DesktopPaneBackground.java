/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author ro
 */
public class DesktopPaneBackground implements Border {
    private Image image;

    public DesktopPaneBackground(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(image, 0, 0, width, height, null);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public Insets getBorderInsets(Component cmpnt) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
