/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.ProductOutStore;
import com.mycompany.sales.sytem.frontend.restclient.ProductOutStoreService;
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
public class ProductOutStoreView extends javax.swing.JInternalFrame {

    /**
     * Creates new form InventoryOutput
     */
    public ProductOutStoreView() {
        initComponents();
    }

    public List<ProductOutStore> listAll() throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<List<ProductOutStore>> call = service.getAll();
        Response<List<ProductOutStore>> response = call.execute();
        return response.body();
    }

    public void save(ProductOutStore productOutStore) throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<HttpStatus> call = service.save(productOutStore);
        call.execute();
    }

    public void update(ProductOutStore productOutStore) throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<HttpStatus> call = service.update(productOutStore);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        cboStore = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        spnAmoun = new javax.swing.JSpinner();
        cboStore1 = new javax.swing.JComboBox<>();
        chbIsCancel = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbInventoryO = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida a Tienda");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblDate.setEditable(false);
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 190, -1));

        jLabel6.setText("Tienda:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jLabel1.setText("Fecha de registro:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 120, -1));

        jLabel7.setText("Producto:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboStore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, -1));

        lblId.setEditable(false);
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 190, -1));

        jLabel8.setText("Cantidad:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));
        jPanel2.add(spnAmoun, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 130, -1));

        cboStore1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboStore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 250, -1));

        chbIsCancel.setText("Cancelar envio a Tienda");
        chbIsCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbIsCancelActionPerformed(evt);
            }
        });
        jPanel2.add(chbIsCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 770, 177));

        tbInventoryO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbInventoryO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInventoryOMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbInventoryO);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 229, 780, 270));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jButton1.setText("Limpiar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbInventoryOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInventoryOMouseClicked
        int fila = tbInventoryO.getSelectedRow();
        String Cod = tbInventoryO.getValueAt(fila, 0).toString();

        {
            int seleccion = tbInventoryO.rowAtPoint(evt.getPoint());
            lblDate.setText(String.valueOf(tbInventoryO.getValueAt(seleccion, 0)));

        }
    }//GEN-LAST:event_tbInventoryOMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void chbIsCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbIsCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbIsCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboStore;
    private javax.swing.JComboBox<String> cboStore1;
    private javax.swing.JCheckBox chbIsCancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblDate;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JSpinner spnAmoun;
    private javax.swing.JTable tbInventoryO;
    // End of variables declaration//GEN-END:variables
}
