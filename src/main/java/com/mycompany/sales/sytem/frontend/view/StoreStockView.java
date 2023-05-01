/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.StoreStock;
import com.mycompany.sales.sytem.frontend.restclient.StoreStockService;
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
public class StoreStockView extends javax.swing.JInternalFrame {

    /**
     * Creates new form StoreStockView
     */
    public StoreStockView() {
        initComponents();
    }

    public List<StoreStock> listAll() throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<List<StoreStock>> call = service.getAll();
        Response<List<StoreStock>> response = call.execute();
        return response.body();
    }

    public void save(StoreStock storeStock) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<HttpStatus> call = service.save(storeStock);
        call.execute();
    }

    public void update(StoreStock storeStock) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<HttpStatus> call = service.update(storeStock);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSupplier);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 710, 190));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 290, -1));

        jLabel4.setText("Buscar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplierMouseClicked
        int fila = tbSupplier.getSelectedRow();
        String Cod = tbSupplier.getValueAt(fila, 0).toString();

        {
            int seleccion = tbSupplier.rowAtPoint(evt.getPoint());

        }
    }//GEN-LAST:event_tbSupplierMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
