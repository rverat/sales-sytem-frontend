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
import javax.swing.table.DefaultTableModel;
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
        listStoreStock();
    }

    public List<StoreStock> listAll() throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<List<StoreStock>> call = service.getAll();
        Response<List<StoreStock>> response = call.execute();
        return response.body();
    }

    /*public void save(StoreStock storeStock) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<HttpStatus> call = service.save(storeStock);
        call.execute();
    }

    public void update(StoreStock storeStock) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<HttpStatus> call = service.update(storeStock);
        call.execute();
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tbStoreStock = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Stock en la tienda");

        tbStoreStock.setModel(new javax.swing.table.DefaultTableModel(
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
        tbStoreStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStoreStockMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbStoreStock);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbStoreStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStoreStockMouseClicked
       
    }//GEN-LAST:event_tbStoreStockMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
    public void listStoreStock() {
        List<StoreStock> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(StoreStockView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Producto", "Tienda", "Cantidad"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[4];
            for (StoreStock response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getProduct().getName();
                registros[2] = response.getStore().getName();
                registros[3] = String.valueOf(response.getQuantity());

                table.addRow(registros);
            }
            tbStoreStock.setModel(table);

        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbStoreStock;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
