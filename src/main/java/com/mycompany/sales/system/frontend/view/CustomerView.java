/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend.view;

import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.model.Customer;
import com.mycompany.sales.system.frontend.restclient.CustomerService;
import com.mycompany.sales.system.frontend.util.UtilSS;
import com.mycompany.sales.system.frontend.util.UtilValidateImput;
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
public class CustomerView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomerView
     */
    public CustomerView() {
        initComponents();
        listCustomers();
    }

    public List<Customer> listAll() throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<List<Customer>> call = service.findAll(TokenCache.getToken());
        Response<List<Customer>> response = call.execute();
        return response.body();
    }

    public void save(Customer customer) throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(),customer);
        call.execute();
    }

    public void update(Customer customer) throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), customer);
        call.execute();
    }

    public void delete(int id) throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();

        setClosable(true);
        setTitle("Clientes");
        setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel6.setText("Id:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel10.setText("Email:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel11.setText("Nombre:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblUsuario3.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 340, -1));

        txtNombre.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 340, -1));

        txtEmail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 340, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 156));

        btnAdd.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        btnModify.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        btnDelete.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        btnClear.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        tbCustomer.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomerMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbCustomer);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 500, 294));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveCustomer();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateCustomer(); // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteCustomer();// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerMouseClicked
        tbEventMouseClick(evt);
    }//GEN-LAST:event_tbCustomerMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void listCustomers() {

        List<Customer> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(CustomerView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Nombre", "Email"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[3];
            for (Customer response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getName();
                registros[2] = response.getEmail();

                table.addRow(registros);
            }
            tbCustomer.setModel(table);

        }

    }

    private void saveCustomer() {

        UtilSS.isValidEmail(txtEmail.getText());
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");

        try {

            Customer customer = new Customer();

            customer.setId(0);
            customer.setName(txtNombre.getText());
            customer.setEmail(txtEmail.getText());
            save(customer);
            JOptionPane.showMessageDialog(null, "Registrado");
            listCustomers();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al registrar");
        }
    }

    private void updateCustomer() {

        UtilSS.isValidEmail(txtEmail.getText());
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");

        try {

            Customer customer = new Customer();

            customer.setId(Integer.parseInt(lblId.getText()));
            customer.setName(txtNombre.getText());
            customer.setEmail(txtEmail.getText());

            update(customer);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listCustomers();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteCustomer() {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
            listCustomers();
        } catch (Exception ex) {
            Logger.getLogger(CustomerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        return false;

    }

    private void clear() {
        lblId.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
    }

    private void tbEventMouseClick(MouseEvent evt) {

        int seleccion = tbCustomer.rowAtPoint(evt.getPoint());
        lblId.setText(String.valueOf(tbCustomer.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tbCustomer.getValueAt(seleccion, 1)));
        txtEmail.setText(String.valueOf(tbCustomer.getValueAt(seleccion, 2)));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario3;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
