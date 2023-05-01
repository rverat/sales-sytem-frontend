/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Sale;
import com.mycompany.sales.sytem.frontend.model.SaleDetail;
import com.mycompany.sales.sytem.frontend.restclient.SaleDetailService;
import com.mycompany.sales.sytem.frontend.restclient.SaleService;
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
public class SaleView extends javax.swing.JInternalFrame {

    /**
     * Creates new form SaleView
     */
    public SaleView() {
        initComponents();
    }

    public List<Sale> listAll() throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<List<Sale>> call = service.getAll();
        Response<List<Sale>> response = call.execute();
        return response.body();
    }

    public void save(Sale sale) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.save(sale);
        call.execute();
    }

    public void update(Sale sale) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.update(sale);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }

    public void saveSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.save(saleDetail);
        call.execute();
    }

    public void updateSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.update(saleDetail);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        cboC = new javax.swing.JComboBox<>();
        cboC1 = new javax.swing.JComboBox<>();
        btnModify = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        cboC2 = new javax.swing.JComboBox<>();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSupplier1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Id:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel10.setText("Tienda:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        jLabel11.setText("Cliente:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));
        jPanel5.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        jPanel5.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 190, -1));

        cboC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cboC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 200, -1));

        cboC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cboC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 260, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 980, 90));

        btnModify.setText("Ejecutar Venta");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Cantidad:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jLabel13.setText("Producto:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboC2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cboC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 260, -1));
        jPanel6.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 120, -1));

        jLabel14.setText("Precio Unitario:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));
        jPanel6.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 110, -1));

        btnAdd.setText("Agregar producto");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel6.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSupplier);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 910, 140));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 960, 270));
        jPanel6.getAccessibleContext().setAccessibleName("Detalles del producto");

        tbSupplier1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbSupplier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplier1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbSupplier1);
        if (tbSupplier1.getColumnModel().getColumnCount() > 0) {
            tbSupplier1.getColumnModel().getColumn(6).setHeaderValue("Title 7");
            tbSupplier1.getColumnModel().getColumn(7).setHeaderValue("Title 8");
        }

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 960, 210));

        jButton1.setText("Ver detalle de la venta");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void tbSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplierMouseClicked
        int fila = tbSupplier.getSelectedRow();
        String Cod = tbSupplier.getValueAt(fila, 0).toString();

        {
            int seleccion = tbSupplier.rowAtPoint(evt.getPoint());

        }
    }//GEN-LAST:event_tbSupplierMouseClicked

    private void tbSupplier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplier1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSupplier1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboC;
    private javax.swing.JComboBox<String> cboC1;
    private javax.swing.JComboBox<String> cboC2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario3;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTable tbSupplier1;
    // End of variables declaration//GEN-END:variables
}
