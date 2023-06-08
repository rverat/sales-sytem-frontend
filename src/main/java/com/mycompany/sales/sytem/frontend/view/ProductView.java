/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.TokenCache;
import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Product;
import com.mycompany.sales.sytem.frontend.model.ProductCategory;
import com.mycompany.sales.sytem.frontend.restclient.ProductCategoryService;
import com.mycompany.sales.sytem.frontend.restclient.ProductService;
import com.mycompany.sales.sytem.frontend.util.UtilValidateImput;
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
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
@Component
public class ProductView extends javax.swing.JInternalFrame {

    private TableRowSorter trsFiltro;   
    

    public ProductView() {
        initComponents();
        listProducts();
        loadPtoductCategory();
        UtilValidateImput.configureSpinner(spnPrice);
    }


    public List<Product> listAll() throws Exception {      
        
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<List<Product>> call = service.findAll(TokenCache.getToken());
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public void save(Product product) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), product);
        call.execute();
    }

    public void update(Product product) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), product);
        call.execute();
    }

    public void delete(int id) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
    }

    public List<ProductCategory> listAllProductCategory() throws Exception {
        ProductCategoryService categoryService = RetrofitClient.createService(ProductCategoryService.class);
        Call<List<ProductCategory>> call = categoryService.findAll(TokenCache.getToken());
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Precio:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Categoria:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, -1));

        txtNombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 310, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Nombre:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        txaDescription.setColumns(20);
        txaDescription.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txaDescription.setRows(5);
        jScrollPane1.setViewportView(txaDescription);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 370, 60));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Descripción:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 120, -1));

        cboCategory.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(cboCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 360, -1));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 310, -1));

        spnPrice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(spnPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 310, -1));

        tbProduct.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
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

        btnDelete.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnAdd)
                .addGap(16, 16, 16)
                .addComponent(btnModify)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModify)
                        .addComponent(btnDelete)
                        .addComponent(jButton1)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
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

        //Validations
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");
        UtilValidateImput.validateSelectedJCombobox(cboCategory, "categoria");

        try {

            Product product = new Product();

            String selectedItem = (String) cboCategory.getSelectedItem();
            int number = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));

            product.setId(0);

            setProductDetail(product, number);

            save(product);
            JOptionPane.showMessageDialog(null, "Producto registrado");
            listProducts();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al registrar");
        }
    }

    private void updateProduct() {

        //Validations
        UtilValidateImput.validateString(txtNombre.getText(), "nombre");
        UtilValidateImput.validateSelectedJCombobox(cboCategory, "categoria");

        try {

            Product product = new Product();

            String selectedItem = (String) cboCategory.getSelectedItem();
            int number = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));

            product.setId(Integer.parseInt(lblId.getText()));

            setProductDetail(product, number);

            update(product);
            JOptionPane.showMessageDialog(null, "Ptoducto actualizado");
            listProducts();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar");
        }
    }

    private void setProductDetail(Product product, int number) {
        product.setName(txtNombre.getText());
        product.setProductCategory(new ProductCategory(number, ""));
        product.setDescription(txaDescription.getText());
        BigDecimal price = BigDecimal.valueOf((Double) spnPrice.getValue());
        product.setPrice(price);
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
