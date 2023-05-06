/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.StoreStock;
import com.mycompany.sales.sytem.frontend.restclient.StoreStockService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
public class StoreStockView extends javax.swing.JInternalFrame {

private TableRowSorter trsFiltro;

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
        jLabel4 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Stock en la tienda");

        tbStoreStock.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel4.setText("Buscar:");

        btnRefresh.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        btnRefresh.setText("Refrescar Stock");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbStoreStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStoreStockMouseClicked
       
    }//GEN-LAST:event_tbStoreStockMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
     listStoreStock();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtSearch.getText());
                txtSearch.setText(cadena);
                repaint();
                trsFiltro.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
        });
        trsFiltro = new TableRowSorter(tbStoreStock.getModel());
        tbStoreStock.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtSearchKeyTyped

    
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
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbStoreStock;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
