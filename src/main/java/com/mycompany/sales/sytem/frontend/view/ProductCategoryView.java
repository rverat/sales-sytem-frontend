/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.restclient.ProductCategoryService;
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
public class ProductCategoryView extends javax.swing.JInternalFrame {

    public ProductCategoryView() {
        initComponents();
        listProductCategory();
    }

    public List<ProductCategory> listAll() throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<List<ProductCategory>> call = categoryService.getAll();
        Response<List<ProductCategory>> response = call.execute();
        return response.body();
    }

    public void save(ProductCategory productCategory) throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<HttpStatus> call = categoryService.save(productCategory);
        call.execute();
    }

    public void update(ProductCategory productCategory) throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<HttpStatus> call = categoryService.save(productCategory);
        call.execute();
    }

    public void delete(int id) throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<HttpStatus> call = categoryService.delete(id);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetail = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCategory = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        pnlDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlDetail.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));
        pnlDetail.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        pnlDetail.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));

        jLabel1.setText("Id:");
        pnlDetail.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Nombre:");
        pnlDetail.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        getContentPane().add(pnlDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 367, 114));

        tbCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCategory);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 178, 367, 163));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoryMouseClicked
        tbEventMouseClick(evt);
    }//GEN-LAST:event_tbCategoryMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteProductCategory();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateProductCategory();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveProductCategory();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listProductCategory() {

        List<ProductCategory> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductCategoryView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Nombre"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[2];
            for (ProductCategory response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getName();

                table.addRow(registros);
            }
            tbCategory.setModel(table);

        }

    }

    private void saveProductCategory() throws HeadlessException {
        try {

            ProductCategory productCategory = new ProductCategory();

            productCategory.setId(0);
            productCategory.setName(txtNombre.getText());

            save(productCategory);
            JOptionPane.showMessageDialog(null, "Registrado");
            listProductCategory();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateProductCategory() throws HeadlessException {
        try {

            ProductCategory productCategory = new ProductCategory();

            productCategory.setId(Integer.parseInt(lblId.getText()));
            productCategory.setName(txtNombre.getText());

            update(productCategory);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listProductCategory();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteProductCategory() throws NumberFormatException, HeadlessException {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductCategoryView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        listProductCategory();
        clear();
        return false;
    }

    private void clear() {
        lblId.setText("");
        txtNombre.setText("");
    }

    private void tbEventMouseClick(MouseEvent evt) {
        int fila = tbCategory.getSelectedRow();
        String Cod = tbCategory.getValueAt(fila, 0).toString();

        {
            int seleccion = tbCategory.rowAtPoint(evt.getPoint());
            lblId.setText(String.valueOf(tbCategory.getValueAt(seleccion, 0)));
            txtNombre.setText(String.valueOf(tbCategory.getValueAt(seleccion, 1)));

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JTable tbCategory;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
