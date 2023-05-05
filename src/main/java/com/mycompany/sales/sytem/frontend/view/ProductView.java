/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Product;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.restclient.ProductCategoryService;
import com.mycompany.sales.sytem.frontend.restclient.ProductService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
public class ProductView extends javax.swing.JInternalFrame {

    private TableRowSorter trsFiltro;

    public ProductView() {
        initComponents();
        listProducts();
        loadPtoductCategory();
    }

    public List<Product> listAll() throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<List<Product>> call = service.getAll();
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public void save(Product product) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.save(product);
        call.execute();
    }

    public void update(Product product) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.update(product);
        call.execute();
    }

    public void delete(int id) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }

    public List<ProductCategory> listAllProductCategory() throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<List<ProductCategory>> call = categoryService.getAll();
        Response<List<ProductCategory>> response = call.execute();
        return response.body();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JTextField();
        spnPrice = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Productos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel6.setText("Precio");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel1.setText("Categoria:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 70, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        jLabel7.setText("Nombre:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        jScrollPane1.setViewportView(txaDescription);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 280, 70));

        jLabel2.setText("Descripción:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jPanel2.add(cboCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 280, -1));

        lblId.setEditable(false);
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel2.add(spnPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, -1));

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProduct);

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel4.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnAdd)
                        .addGap(16, 16, 16)
                        .addComponent(btnModify)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModify)
                        .addComponent(btnDelete)
                        .addComponent(jButton1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        tbEventMouseClick(evt);
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteProduct();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateProduct();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveProduct();
    }//GEN-LAST:event_btnAddActionPerformed

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
        trsFiltro = new TableRowSorter(tbProduct.getModel());
        tbProduct.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listProducts() {

        List<Product> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Nombre", "Categoría", "Descripción", "Precio"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[5];
            for (Product response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getName();
                registros[2] = String.valueOf(response.getProductCategory().getId() + ", " + response.getProductCategory().getName());
                registros[3] = response.getDescription();
                registros[4] = String.valueOf(response.getPrice());

                table.addRow(registros);
            }
            tbProduct.setModel(table);

        }

    }

    private void saveProduct() {
        try {

            Product product = new Product();

            String selectedItem = (String) cboCategory.getSelectedItem();
            int number = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));

            product.setId(0);
            product.setName(txtNombre.getText());
            product.setProductCategory(new ProductCategory(number, ""));
            product.setDescription(txaDescription.getText());
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(spnPrice.getValue().toString())));
            save(product);
            JOptionPane.showMessageDialog(null, "Registrado");
            listProducts();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateProduct() {
        try {

            Product product = new Product();

            String selectedItem = (String) cboCategory.getSelectedItem();
            int number = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));

            product.setId(Integer.parseInt(lblId.getText()));
            product.setName(txtNombre.getText());
            product.setProductCategory(new ProductCategory(number, ""));
            product.setDescription(txaDescription.getText());
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(spnPrice.getValue().toString())));

            update(product);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listProducts();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteProduct() {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
            listProducts();
        } catch (Exception ex) {
            Logger.getLogger(ProductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        return false;

    }

    private void clear() {
        lblId.setText("");
        txtNombre.setText("");
        cboCategory.setSelectedIndex(-1);
        txaDescription.setText("");
        spnPrice.setValue(0);
    }

    private void loadPtoductCategory() {
        try {
            List<ProductCategory> list = listAllProductCategory();

            for (ProductCategory category : list) {
                cboCategory.addItem(String.valueOf(category.getId()) + ", " + category.getName());
            }
        } catch (Exception e) {

        }
    }

    private void tbEventMouseClick(MouseEvent evt) {

        int seleccion = tbProduct.rowAtPoint(evt.getPoint());
        lblId.setText(String.valueOf(tbProduct.getValueAt(seleccion, 0)));
        txtNombre.setText(String.valueOf(tbProduct.getValueAt(seleccion, 1)));
        cboCategory.setSelectedItem(String.valueOf(tbProduct.getValueAt(seleccion, 2)));
        txaDescription.setText(String.valueOf(tbProduct.getValueAt(seleccion, 3)));
        spnPrice.setValue(BigDecimal.valueOf(Double.parseDouble(tbProduct.getValueAt(seleccion, 4).toString())));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JSpinner spnPrice;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
