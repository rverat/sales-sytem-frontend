/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.ProductEntryWarehouse;
import com.mycompany.sales.sytem.frontend.restclient.ProductEntryWarehouseService;
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
public class ProductEntryWarehouseView extends javax.swing.JInternalFrame {

    /**
     * Creates new form InventoryEntry
     */
    public ProductEntryWarehouseView() {
        initComponents();
    }

    public List<ProductEntryWarehouse> listAll() throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<List<ProductEntryWarehouse>> call = service.getAll();
        Response<List<ProductEntryWarehouse>> response = call.execute();
        return response.body();
    }

    public void save(ProductEntryWarehouse productEntryWarehouse) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.save(productEntryWarehouse);
        call.execute();
    }

    public void update(ProductEntryWarehouse productEntryWarehouse) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.update(productEntryWarehouse);
        call.execute();
    }

    public void delete(int id) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.delete(id);
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
        cboProduct = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spnAmount = new javax.swing.JSpinner();
        cboSupplier = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        spnPrice = new javax.swing.JSpinner();
        chbIsCancel = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbInventoryE = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Entrada de productos al almacen");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblDate.setEditable(false);
        jPanel2.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 190, -1));

        jLabel6.setText("proveedor");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        jLabel1.setText("Fecha de registro:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 120, -1));

        jLabel7.setText("Producto:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 320, -1));

        lblId.setEditable(false);
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 190, -1));

        jLabel4.setText("Precio Total:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        jLabel8.setText("Cantidad:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, -1));
        jPanel2.add(spnAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        cboSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 270, -1));

        jLabel5.setText("Precio Unitario:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, -1));
        jPanel2.add(spnPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, -1));

        chbIsCancel.setText("Cancelar entrada al almacen");
        jPanel2.add(chbIsCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 914, 193));

        tbInventoryE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tbInventoryE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInventoryEMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbInventoryE);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 246, 914, 263));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jButton1.setText("Limpiar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbInventoryEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInventoryEMouseClicked
        int fila = tbInventoryE.getSelectedRow();
        String Cod = tbInventoryE.getValueAt(fila, 0).toString();

        {
            int seleccion = tbInventoryE.rowAtPoint(evt.getPoint());

        }
    }//GEN-LAST:event_tbInventoryEMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JCheckBox chbIsCancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblDate;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JTable tbInventoryE;
    // End of variables declaration//GEN-END:variables
}
