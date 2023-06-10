package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.view.*;
import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.config.TokenCache;
import com.mycompany.sales.sytem.frontend.config.UserCache;
import com.mycompany.sales.sytem.frontend.model.Supplier;
import com.mycompany.sales.sytem.frontend.model.UserSystem;
import com.mycompany.sales.sytem.frontend.restclient.SupplierService;
import com.mycompany.sales.sytem.frontend.restclient.UserService;
import com.mycompany.sales.sytem.frontend.util.UtilSS;
import com.mycompany.sales.sytem.frontend.util.UtilSS;
import com.mycompany.sales.sytem.frontend.util.UtilValidateImput;
import com.mycompany.sales.sytem.frontend.util.UtilValidateImput;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
public class UserView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Supplier
     */
    public UserView() {
        initComponents();
        listUser();
        userControl();
    }

    public List<UserSystem> findAll() throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<List<UserSystem>> call = service.findAll(TokenCache.getToken());
        Response<List<UserSystem>> response = call.execute();
        return response.body();
    }

    public void logout(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.logout(TokenCache.getToken());
        call.execute();
    }

    public void save(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), userSystem);
        call.execute();
    }

    public void update(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), userSystem);
        call.execute();
    }

    public void delete(int id) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
    }

    public char[] getPassword() {
        return this.txtPassword.getPassword();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Usuarios");

        btnAdd.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tbUser.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbUser);

        btnLimpiar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Id:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel12.setText("Email:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel13.setText("Nombre:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel6.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 300, -1));

        txtNombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel6.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 300, -1));

        txtEmail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel6.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 300, -1));

        txtUserName.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel6.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 300, -1));

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel14.setText("UserName:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel15.setText("Tipo:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel16.setText("Password:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        cboType.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "staff" }));
        jPanel6.add(cboType, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 300, -1));

        txtPassword.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel6.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(16, 16, 16)
                                .addComponent(btnModify)
                                .addGap(19, 19, 19)
                                .addComponent(btnDelete)
                                .addGap(16, 16, 16)
                                .addComponent(btnLimpiar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveUser();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateUser();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSupplier();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        tbSupplierMouseClick(evt);
    }//GEN-LAST:event_tbUserMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void userControl() {
        
        if(UserCache.getTypeUser().equals("staff")){
            
            txtUserName.setEditable(false);
            cboType.setEnabled(false);
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            btnLimpiar.setEnabled(false);
            
        }

    }

    private void listUser() {
        List<UserSystem> lista = new ArrayList<>();

        try {
            lista = findAll();
        } catch (Exception ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Nombre", "Email", "User Name", "password", "Tipo"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[6];
            for (UserSystem response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getName();
                registros[2] = response.getEmail();
                registros[3] = response.getUserName();
                registros[4] = response.getUserPassword();
                registros[5] = response.getTypeUser();

                table.addRow(registros);
            }
            tbUser.setModel(table);

        }
    }

    private void saveUser() throws HeadlessException {

        //Validations
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");
        UtilValidateImput.validateString(txtUserName.getText(), "user name");
        UtilSS.isValidEmail(txtEmail.getText());

        try {

            UserSystem userSystem = new UserSystem();
            String type = (String) cboType.getSelectedItem();

            userSystem.setId(0);
            userSystem.setName(txtNombre.getText());
            userSystem.setEmail(txtEmail.getText());
            userSystem.setUserName(txtUserName.getText());
            userSystem.setUserPassword(String.valueOf(txtPassword.getPassword()));
            userSystem.setTypeUser(type);

            update(userSystem);
            JOptionPane.showMessageDialog(null, "Registrado");
            listUser();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateUser() throws HeadlessException {

        //Validations
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");
        UtilValidateImput.validateString(txtUserName.getText(), "user name");
        UtilSS.isValidEmail(txtEmail.getText());

        try {

            UserSystem userSystem = new UserSystem();
            String type = (String) cboType.getSelectedItem();

            userSystem.setId(Integer.parseInt(lblId.getText()));
            userSystem.setName(txtNombre.getText());
            userSystem.setEmail(txtEmail.getText());
            userSystem.setUserName(txtUserName.getText());
            userSystem.setUserPassword(String.valueOf(txtPassword.getPassword()));
            userSystem.setTypeUser(type);

            update(userSystem);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listUser();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteSupplier() throws NumberFormatException, HeadlessException {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
        } catch (Exception ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        listUser();
        clear();
        return false;
    }

    private void clear() {
        lblId.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        cboType.setSelectedIndex(0);
    }

    private void tbSupplierMouseClick(MouseEvent evt) {

        int seleccion = tbUser.rowAtPoint(evt.getPoint());

        lblId.setText(String.valueOf(tbUser.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tbUser.getValueAt(seleccion, 1)));
        txtEmail.setText(String.valueOf(tbUser.getValueAt(seleccion, 2)));
        txtUserName.setText(String.valueOf(tbUser.getValueAt(seleccion, 3)));
        cboType.setSelectedItem(String.valueOf(tbUser.getValueAt(seleccion, 5)));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
