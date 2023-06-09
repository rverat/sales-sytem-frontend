/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend.view;

import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.config.UserCache;
import com.mycompany.sales.system.frontend.model.Product;
import com.mycompany.sales.system.frontend.model.ProductEntryWarehouse;
import com.mycompany.sales.system.frontend.model.Supplier;
import com.mycompany.sales.system.frontend.model.UserSystem;
import com.mycompany.sales.system.frontend.restclient.ProductEntryWarehouseService;
import com.mycompany.sales.system.frontend.restclient.ProductService;
import com.mycompany.sales.system.frontend.restclient.SupplierService;
import com.mycompany.sales.system.frontend.util.UtilSS;
import com.mycompany.sales.system.frontend.util.UtilValidateImput;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
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
        listProductEntryWarehouse();
        loadPtoductAndSupplier();
    }

    public List<ProductEntryWarehouse> listAll() throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<List<ProductEntryWarehouse>> call = service.findAll(TokenCache.getToken());
        Response<List<ProductEntryWarehouse>> response = call.execute();
        return response.body();
    }

    public void save(ProductEntryWarehouse productEntryWarehouse) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), productEntryWarehouse);
        call.execute();
    }

    public void update(ProductEntryWarehouse productEntryWarehouse) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), productEntryWarehouse);
        call.execute();
    }

    public void delete(int id) throws Exception {
        ProductEntryWarehouseService service = RetrofitClient.createService(ProductEntryWarehouseService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
    }

    public List<Product> listProduct() throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<List<Product>> call = service.findAll(TokenCache.getToken());
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public List<Supplier> listSuppler() throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<List<Supplier>> call = service.findAll(TokenCache.getToken());
        Response<List<Supplier>> response = call.execute();
        return response.body();
    }

    private void loadPtoductAndSupplier() {
        try {
            List<Product> listP = listProduct();
            List<Supplier> listS = listSuppler();

            for (Product product : listP) {
                cboProduct.addItem(String.valueOf(product.getId()) + ", " + product.getName());
            }
            for (Supplier supplier : listS) {
                cboSupplier.addItem(String.valueOf(supplier.getId()) + ", " + supplier.getName());
            }
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        cboProduct = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        cboSupplier = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductEntryWarehouse = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Entrada de productos al almacen");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Proveedor:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Producto:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboProduct.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(cboProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 300, -1));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 300, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setText("Cantidad:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, -1));

        spnQuantity.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 300, -1));

        cboSupplier.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(cboSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 300, -1));

        tbProductEntryWarehouse.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tbProductEntryWarehouse.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductEntryWarehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductEntryWarehouseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductEntryWarehouse);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnAdd)
                        .addGap(16, 16, 16)
                        .addComponent(btnModify)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModify)
                        .addComponent(btnDelete)
                        .addComponent(jButton1)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductEntryWarehouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductEntryWarehouseMouseClicked
        tbEventMouseClick(evt);
    }//GEN-LAST:event_tbProductEntryWarehouseMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteProductEntryWarehouse();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateProductEntryWarehouse();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveProductEntryWarehouse();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listProductEntryWarehouse() {
        List<ProductEntryWarehouse> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductEntryWarehouseView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Id Usuario", "Id Producto", "Id Proveedor", "Cantidad", "Fecha"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[10];
            for (ProductEntryWarehouse response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = String.valueOf(response.getUserSystem().getId() + ", " + response.getUserSystem().getName());
                registros[2] = String.valueOf(response.getProduct().getId() + ", " + response.getProduct().getName());
                registros[3] = String.valueOf(response.getSupplier().getId() + ", " + response.getSupplier().getName());
                registros[4] = String.valueOf(response.getQuantity());
                registros[5] = String.valueOf(response.getDate());

                table.addRow(registros);
            }
            tbProductEntryWarehouse.setModel(table);

        }

    }

    private void saveProductEntryWarehouse() {

        //Validations
        UtilValidateImput.validateSelectedJCombobox(cboProduct, "producto");
        UtilValidateImput.validateSelectedJCombobox(cboSupplier, "proveedor");
        UtilSS.isValidInteger(spnQuantity.getValue().toString(), "cantidad");

        try {

            ProductEntryWarehouse productEntryWarehouse = new ProductEntryWarehouse();

            String selectedItem = (String) cboProduct.getSelectedItem();
            String productId = selectedItem.substring(0, selectedItem.indexOf(","));

            String selectedItemS = (String) cboSupplier.getSelectedItem();
            String supplierId = selectedItemS.substring(0, selectedItemS.indexOf(","));

            Product product = new Product();
            product.setId(Integer.parseInt(productId));

            Supplier supplier = new Supplier();
            supplier.setId(Integer.parseInt(supplierId));

            productEntryWarehouse.setId(0);
            productEntryWarehouse.setUserSystem(new UserSystem(Integer.parseInt(UserCache.getId()), "", "", "", "", "",""));
            productEntryWarehouse.setProduct(product);
            productEntryWarehouse.setSupplier(supplier);
            productEntryWarehouse.setQuantity(Integer.parseInt(spnQuantity.getValue().toString()));
            productEntryWarehouse.setDate(LocalDate.now().toString());

            save(productEntryWarehouse);
            JOptionPane.showMessageDialog(null, "Registrado");
            listProductEntryWarehouse();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateProductEntryWarehouse() {
        //Validations
        UtilValidateImput.validateSelectedJCombobox(cboProduct, "producto");
        UtilValidateImput.validateSelectedJCombobox(cboSupplier, "proveedor");
        UtilSS.isValidInteger(spnQuantity.getValue().toString(), "cantidad");
        
        try {
            ProductEntryWarehouse productEntryWarehouse = new ProductEntryWarehouse();

            String selectedItem = (String) cboProduct.getSelectedItem();
            String productId = selectedItem.substring(0, selectedItem.indexOf(","));

            String selectedItemS = (String) cboSupplier.getSelectedItem();
            String supplierId = selectedItemS.substring(0, selectedItemS.indexOf(","));

            Product product = new Product();
            product.setId(Integer.parseInt(productId));

            Supplier supplier = new Supplier();
            supplier.setId(Integer.parseInt(supplierId));

            productEntryWarehouse.setId(Integer.parseInt(lblId.getText()));
            productEntryWarehouse.setUserSystem(new UserSystem(Integer.parseInt(UserCache.getId()), "", "", "", "","", ""));
            productEntryWarehouse.setProduct(product);
            productEntryWarehouse.setSupplier(supplier);
            productEntryWarehouse.setQuantity(Integer.parseInt(spnQuantity.getValue().toString()));
            productEntryWarehouse.setDate(LocalDate.now().toString());

            update(productEntryWarehouse);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listProductEntryWarehouse();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteProductEntryWarehouse() {

        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductEntryWarehouseView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        listProductEntryWarehouse();
        clear();
        return false;
    }

    private void clear() {
        lblId.setText("");
        cboProduct.setSelectedIndex(-1);
        cboSupplier.setSelectedIndex(-1);
        spnQuantity.setValue(0);
    }

    private void tbEventMouseClick(MouseEvent evt) {
        int seleccion = tbProductEntryWarehouse.rowAtPoint(evt.getPoint());
        lblId.setText(String.valueOf(tbProductEntryWarehouse.getValueAt(seleccion, 0)));
        cboProduct.setSelectedItem(tbProductEntryWarehouse.getValueAt(seleccion, 2));
        cboSupplier.setSelectedItem(tbProductEntryWarehouse.getValueAt(seleccion, 3));
        spnQuantity.setValue(BigDecimal.valueOf(Double.parseDouble(tbProductEntryWarehouse.getValueAt(seleccion, 4).toString())));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JComboBox<String> cboSupplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tbProductEntryWarehouse;
    // End of variables declaration//GEN-END:variables
}
