/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sales.sytem.frontend;

import com.mycompany.sales.sytem.frontend.view.MDI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author uestadisticai
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        txtNombre.requestFocus();
    }

    public char[] getPassword() {
        return this.txtContrasena.getPassword();
    }

    private void IniciarSesion() {

            
        List<User> userList = new ArrayList<>();
        
        String user = txtNombre.getText();
        String password = String.valueOf(txtContrasena.getPassword());

        // Agregar algunos usuarios a la lista
        userList.add(new User("John", "password123", "admin"));
        userList.add(new User("Mary", "qwerty", "user"));
        
        if(user.equals(userList.get(1).getName()) && password.equals(userList.get(1).getPassword())){
            
            MDI formprincipal = new MDI();
                formprincipal.setVisible(true);
                this.setVisible(false);
            
            
        }
    }
        
       /* if(user.equals(userList.get(1).getName()) && password.equals(userList.get(1).getPassword())){
            
            MDI formprincipal = new MDI();
                formprincipal.setVisible(true);
                this.setVisible(false);
                  formprincipal.mniEquipSalidGupU.setEnabled(false);
            
        }


                

            
                formprincipal.lblIdUsuario.setText(nombre + " " + apellido);
                formprincipal.lblTipoUsuario.setText(tipo);
                formprincipal.lblCodigo.setText(codigo);



        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error en iniciar sesion");

        }
    }

    /*private void IniciarSesionCopy(){
		  ClsUsuarioCL login = new ClsUsuarioCL();
                 ClsUsuarioCE dato = new ClsUsuarioCE();
		  try{  
			    dato.setUsu_Usuario(txtNombre.getText());
                           dato.setUsu_Contrasena(String.valueOf(txtContrasena.getText()));
			   
			   ClsUsuarioCE  Dato1 = login.IniciarSesion(dato);
			  
		     if(Dato1 !=null){
		 
                        MDIAdmin formprincipal = new MDIAdmin();
                        formprincipal.setVisible(true);
                        this.setVisible(false);
                        String codigo =Dato1.getUsu_Id();
		    	String nombre =Dato1.getUsu_Nombre();
                        String apellido =Dato1.getUsu_Apellido();
                        String tipo =Dato1.getUsu_Tipo();
                        
                         //String tipo = lblTipoUsuario.getText();

                         switch (tipo) {
                             case "ADMINISTRADOR":
                                 break;
                             case "TÉCNICO":
                                 formprincipal.nmiUsuario.setEnabled(false);
                                 formprincipal.mniEquipoU.setEnabled(false);
                                 formprincipal.mniMaterialU.setEnabled(false);
                                 formprincipal.mniEquipoGrupoRU.setEnabled(false);
                                 formprincipal.mniEquipSalidGupU.setEnabled(false);
                                 formprincipal.mniEquipSalidIndU.setEnabled(false);
                                 formprincipal.mniAcceNombU.setEnabled(false);
                                 formprincipal.mniEquiNombU.setEnabled(false);
                                 formprincipal.mniEquipSalidGupAU.setEnabled(false);
                                 formprincipal.mniMateNombU.setEnabled(false);
                                 formprincipal.mniMaterialSalidaU.setEnabled(false);
                                 formprincipal.mniMaterialU.setEnabled(false);
                                 formprincipal.mniOficNombU.setEnabled(false);
                                 formprincipal.mniRepuestoU.setEnabled(false);
                                 break;
                             case "SECRETARIA":
                                 formprincipal.nmiUsuario.setEnabled(false);
                                 formprincipal.mniEquipoU.setEnabled(false);
                                 formprincipal.mniMaterialU.setEnabled(false);
                                 formprincipal.mniEquipoGrupoRU.setEnabled(false);
                                 formprincipal.mniEquipSalidGupU.setEnabled(false);
                                 formprincipal.mniEquipSalidIndU.setEnabled(false);
                                 formprincipal.mniAcceNombU.setEnabled(false);
                                 formprincipal.mniEquiNombU.setEnabled(false);
                                 formprincipal.mniEquipSalidGupAU.setEnabled(false);
                                 formprincipal.mniMateNombU.setEnabled(false);
                                 formprincipal.mniMaterialSalidaU.setEnabled(false);
                                 formprincipal.mniMaterialU.setEnabled(false);
                                 formprincipal.mniOficNombU.setEnabled(false);
                                 formprincipal.mniRepuestoU.setEnabled(false);
                                 formprincipal.nmiUsuario.setEnabled(false);
                                 formprincipal.mniEquipoW.setEnabled(false);
                                 formprincipal.mniMaterialW.setEnabled(false);
                                 formprincipal.mniEquipSalidGupW.setEnabled(false);
                                 formprincipal.mniEquipSalidIndW.setEnabled(false);
                                 formprincipal.mniAcceNombW.setEnabled(false);
                                 formprincipal.mniEquiNombW.setEnabled(false);
                                 formprincipal.mniEquipSalidGupAW.setEnabled(false);
                                 formprincipal.mniMateNombW.setEnabled(false);
                                 formprincipal.mniMaterialSalidaW.setEnabled(false);
                                 formprincipal.mniMaterialW.setEnabled(false);
                                 formprincipal.mniOficNombW.setEnabled(false);
                                 formprincipal.mniRepuestoW.setEnabled(false);
                                 break;
                             default:
                                 break;
                         }
                        
		    	formprincipal.lblIdUsuario.setText(nombre+" "+apellido);
		        formprincipal.lblTipoUsuario.setText(tipo);
                        formprincipal.lblCodigo.setText(codigo);
		 
		     } else{
                    //Limpiar();
                     }
		    	
		        }catch(Exception e){
                            
		        JOptionPane.showMessageDialog(null, e);
		        JOptionPane.showMessageDialog(null, "Error en iniciar sesion");
                        
		    }
	} */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Iniciar Sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setText("Acceder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyTyped(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txtContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        IniciarSesion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyTyped

    }//GEN-LAST:event_txtContrasenaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtContrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txtNombre.getText() == "") {
                txtNombre.requestFocus();
            } else if (txtContrasena.getText() == "") {
                txtContrasena.requestFocus();
            } else {
                IniciarSesion();
            }

        }
    }//GEN-LAST:event_txtContrasenaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
