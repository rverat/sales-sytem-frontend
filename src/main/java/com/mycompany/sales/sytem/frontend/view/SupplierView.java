/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Supplier;
import com.mycompany.sales.sytem.frontend.restclient.SupplierService;
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
public class SupplierView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Supplier
     */
    public SupplierView() {
        initComponents();
    }

    public List<Supplier> listAll() throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<List<Supplier>> call = service.getAll();
        Response<List<Supplier>> response = call.execute();
        return response.body();
    }

    public void save(Supplier supplier) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.save(supplier);
        call.execute();
    }

    public void update(Supplier supplier) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.update(supplier);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        lblId1 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtRUC1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Proveedor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSupplier);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 440, 300));

        btnLimpiar.setText("Limpiar");
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Id:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel12.setText("PhoneNumber:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel13.setText("Nombre:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId1.setEditable(false);
        jPanel6.add(lblId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel6.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));
        jPanel6.add(txtRUC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 240, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 410, 156));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplierMouseClicked
        int fila = tbSupplier.getSelectedRow();
        String Cod = tbSupplier.getValueAt(fila, 0).toString();

        {
            int seleccion = tbSupplier.rowAtPoint(evt.getPoint());

        }
    }//GEN-LAST:event_tbSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModify;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lblId1;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtRUC1;
    // End of variables declaration//GEN-END:variables
}
