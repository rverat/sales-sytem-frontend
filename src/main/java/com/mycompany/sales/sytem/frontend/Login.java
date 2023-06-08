/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sales.sytem.frontend;

import com.mycompany.sales.sytem.frontend.config.TokenCache;
import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Store;
import com.mycompany.sales.sytem.frontend.model.UserSystem;
import com.mycompany.sales.sytem.frontend.restclient.StoreService;
import com.mycompany.sales.sytem.frontend.restclient.UserService;
import com.mycompany.sales.sytem.frontend.view.MDI;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author uestadisticai
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        txtNombre.requestFocus();
    }

    public List<UserSystem> listAll() throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<List<UserSystem>> call = service.findAll("");
        Response<List<UserSystem>> response = call.execute();
        return response.body();
    }

    public UserSystem login(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<UserSystem> call = service.login(userSystem);
        try {
        Response<UserSystem> response = call.execute();
        int codeHttp = response.code();

        if (codeHttp == HttpStatus.NOT_FOUND.value()) {
            JOptionPane.showMessageDialog(null, "Usuario o password incorrecto");
            throw new Exception("Usuario o password incorrecto");
        }

        return response.body();
    } catch (IOException e) {
        // Handle IO exception if it occurs during the API call
        throw new Exception("Error occurred during API call: " + e.getMessage());
    }
    }

    public void logout(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.logout("");
        call.execute();
    }

    public void save(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.save("", userSystem);
        call.execute();
    }

    public void update(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.update("", userSystem);
        call.execute();
    }

    public void delete(int id) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.delete("", id);
        call.execute();
    }

    public char[] getPassword() {
        return this.txtContrasena.getPassword();
    }

    private void login() throws Exception {
        
        UserSystem userSystem = new UserSystem();
        userSystem.setUserName(txtNombre.getText());
        userSystem.setUserPassword(String.valueOf(txtContrasena.getPassword()));

        try {
            UserSystem systemDB  = login(userSystem);
            
            //save token in cache         
            String token = systemDB.getToken();
            TokenCache tokenCache = new TokenCache();
            tokenCache.saveToken(token);
            
            System.err.println("print token: " + tokenCache.getToken());
            
            
            

            if (systemDB.getTypeUser().equals("staff")) {

                MDI mdi = new MDI();
                mdi.setVisible(true);
                this.setVisible(false);
                mdi.mnuClient.setEnabled(false);
                mdi.mnuEntAlm.setEnabled(false);
                mdi.mnuPr.setEnabled(false);
                mdi.mnuPr.setEnabled(false);
                mdi.mnuSalTien.setEnabled(false);
                mdi.mnuTien.setEnabled(false);
                mdi.mnuProvee.setEnabled(false);

            } else if (systemDB.getTypeUser().equals("admin")) {

                MDI mdi = new MDI();
                mdi.setVisible(true);
                this.setVisible(false);

            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al iniciar sesion");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Iniciar Sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtContrasena.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtNombre))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            login();
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyTyped

    }//GEN-LAST:event_txtContrasenaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtContrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if ("".equals(txtNombre.getText())) {
                txtNombre.requestFocus();
            } else if ("".equals(txtContrasena.getText())) {
                txtContrasena.requestFocus();
            } else {
                try {
                    login();
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
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
