/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author ro
 */

public class BackgroundDesktopPane extends JDesktopPane {
    private Image backgroundImage;

    public BackgroundDesktopPane(String imagePath) {
        
        // Load the image using resource loading
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            backgroundImage = new ImageIcon(imageUrl).getImage();
        } else {
            throw new IllegalArgumentException("Image not found: " + imagePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

