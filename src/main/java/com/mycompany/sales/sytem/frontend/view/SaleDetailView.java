/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.SaleDetail;
import com.mycompany.sales.sytem.frontend.restclient.SaleDetailService;
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
public class SaleDetailView extends javax.swing.JInternalFrame {

    /**
     * Creates new form SaleDetailView
     */
    public SaleDetailView() {
        initComponents();
    }

    public List<SaleDetail> listAll() throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleDetail>> call = service.getAll();
        Response<List<SaleDetail>> response = call.execute();
        return response.body();
    }

    public void save(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.save(saleDetail);
        call.execute();
    }

    public void update(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.update(saleDetail);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblUsuario3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        cboC = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();

        setTitle("Detalle de la Venta");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Id:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel10.setText("RUC:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel1.setText("Numero de telefono:");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 140, -1));

        jLabel11.setText("Nombre:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel5.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        jLabel2.setText("Descripción:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        lblId.setEditable(false);
        jPanel5.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 240, -1));
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));
        jPanel5.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 240, -1));

        jPanel5.add(cboC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 270, -1));
        jPanel5.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 178, 30));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");

        tbSupplier.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSupplier);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnAdd)
                .addGap(16, 16, 16)
                .addComponent(btnModify)
                .addGap(19, 19, 19)
                .addComponent(btnDelete)
                .addGap(16, 16, 16)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

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
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario3;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRUC;
    // End of variables declaration//GEN-END:variables
}
