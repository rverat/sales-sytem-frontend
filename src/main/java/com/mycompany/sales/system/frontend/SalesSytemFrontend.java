/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sales.system.frontend;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ro
 */
@SpringBootApplication(scanBasePackages = "com.mycompany.sales.system")
public class SalesSytemFrontend {

    public static void main(String[] args) {

        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SalesSytemFrontend.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SalesSystemAdmin().setVisible(true);
        });

    }
}
