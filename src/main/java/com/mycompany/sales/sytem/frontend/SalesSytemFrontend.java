/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sales.sytem.frontend;

//import com.mycompany.system.Application;
//import com.mycompany.system.Application;
import com.mycompany.sales.sytem.frontend.view.MDI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.boot.SpringApplication;

/**
 *
 * @author ro
 */
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
        
        //SpringApplication.run(Application.class, args);

        /*try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("control", new java.awt.Color(128, 128, 128)); // color de fondo para los componentes
                    UIManager.put("info", new java.awt.Color(128, 128, 128)); // color de fondo para los tooltips
                    UIManager.put("nimbusBase", new java.awt.Color(18, 30, 49)); // color de fondo para la ventana
                    UIManager.put("nimbusFocus", new java.awt.Color(128, 128, 128)); // color del borde para los componentes enfocados
                    UIManager.put("nimbusLightBackground", new java.awt.Color(18, 30, 49)); // color de fondo para los componentes que tienen un fondo claro
                    UIManager.put("nimbusSelectionBackground", new java.awt.Color(128, 128, 128)); // color de fondo para los componentes seleccionados
                    UIManager.put("text", new java.awt.Color(230, 230, 230)); // color de texto para los componentes
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Error al establecer la apariencia Nimbus");
        }*/

        java.awt.EventQueue.invokeLater(() -> {
            new MDI().setVisible(true);
        });

    }
}
