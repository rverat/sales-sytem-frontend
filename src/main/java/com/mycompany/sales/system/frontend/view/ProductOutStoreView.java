/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend.view;

import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.model.Product;
import com.mycompany.sales.system.frontend.model.ProductOutStore;
import com.mycompany.sales.system.frontend.model.Store;
import com.mycompany.sales.system.frontend.restclient.ProductOutStoreService;
import com.mycompany.sales.system.frontend.restclient.ProductService;
import com.mycompany.sales.system.frontend.restclient.StoreService;
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
public class ProductOutStoreView extends javax.swing.JInternalFrame {

    /**
     * Creates new form InventoryOutput
     */
    public ProductOutStoreView() {
        initComponents();
        loadPtoductAndStore();
        listProductOutStore();
    }

    public List<ProductOutStore> listAll() throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<List<ProductOutStore>> call = service.findAll(TokenCache.getToken());
        Response<List<ProductOutStore>> response = call.execute();
        return response.body();
    }

    public void save(ProductOutStore productOutStore) throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), productOutStore);
        call.execute();
    }

    public void update(ProductOutStore productOutStore) throws Exception {
        ProductOutStoreService service = RetrofitClient.createService(ProductOutStoreService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), productOutStore);
        call.execute();
    }

    public List<Product> listProduct() throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<List<Product>> call = service.findAll(TokenCache.getToken());
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public List<Store> listStore() throws Exception {
        StoreService service = RetrofitClient.createService(StoreService.class);
        Call<List<Store>> call = service.findAll(TokenCache.getToken());
        Response<List<Store>> response = call.execute();
        return response.body();
    }

    private void loadPtoductAndStore() {
        try {
            List<Product> listP = listProduct();
            List<Store> listS = listStore();

            for (Product product : listP) {
                cboProduct.addItem(String.valueOf(product.getId()) + ", " + product.getName());
            }
            for (Store store : listS) {
                cboStore.addItem(String.valueOf(store.getId()) + ", " + store.getName());
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
        cboStore = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductOutStore = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida de Productos a Tienda");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Id:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Tienda:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Producto:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboProduct.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(cboProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 300, -1));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 300, -1));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setText("Cantidad:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 100, -1));

        spnQuantity.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 240, -1));

        cboStore.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel2.add(cboStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 250, -1));

        tbProductOutStore.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tbProductOutStore.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductOutStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductOutStoreMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductOutStore);

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
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(16, 16, 16)
                        .addComponent(btnModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(btnDelete))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModify)
                        .addComponent(jButton1)
                        .addComponent(btnDelete)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductOutStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductOutStoreMouseClicked
        tbProductOutStoreMouseClick(evt);
    }//GEN-LAST:event_tbProductOutStoreMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteProductOutStore();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
       updateProductOutStore();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveProductOutStore();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listProductOutStore() {
        List<ProductOutStore> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(ProductOutStoreView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Id Producto", "Id Tienda", "Cantidad", "Fecha"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[5];
            for (ProductOutStore response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = String.valueOf(response.getProduct().getId() + ", " + response.getProduct().getName());
                registros[2] = String.valueOf(response.getStore().getId() + ", " + response.getStore().getName());
                registros[3] = String.valueOf(response.getQuantity());
                registros[4] = String.valueOf(response.getDate());

                table.addRow(registros);
            }
            tbProductOutStore.setModel(table);
        }
    }

    private void saveProductOutStore() {
        
        //Validations
        UtilValidateImput.validateSelectedJCombobox(cboProduct, "producto");
        UtilValidateImput.validateSelectedJCombobox(cboStore, "tienda");
        UtilSS.isValidInteger(spnQuantity.getValue().toString(), "cantidad");
        try {
            ProductOutStore productOutStore = new ProductOutStore();

            String selectedItem = (String) cboProduct.getSelectedItem();
            String productId = selectedItem.substring(0, selectedItem.indexOf(","));

            String selectedItemS = (String) cboStore.getSelectedItem();
            String storeId = selectedItemS.substring(0, selectedItemS.indexOf(","));
            
            Product product= new Product();
            product.setId(Integer.parseInt(productId));
            
            Store store = new Store();
            store.setId(Integer.parseInt(storeId));

            productOutStore.setId(0);
            productOutStore.setProduct(product);
            productOutStore.setStore(store);
            productOutStore.setQuantity(Integer.parseInt(spnQuantity.getValue().toString()));
            productOutStore.setDate(LocalDate.now().toString());

            save(productOutStore);
            JOptionPane.showMessageDialog(null, "Registrado");
            listProductOutStore();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateProductOutStore() {
        
        //Validations
        UtilValidateImput.validateSelectedJCombobox(cboProduct, "producto");
        UtilValidateImput.validateSelectedJCombobox(cboStore, "tienda");
        UtilSS.isValidInteger(spnQuantity.getValue().toString(), "cantidad");
        
        try {

            ProductOutStore productOutStore = new ProductOutStore();

            productOutStore.setId(Integer.parseInt(lblId.getText()));

            String selectedItem = (String) cboProduct.getSelectedItem();
            String productId = selectedItem.substring(0, selectedItem.indexOf(","));

            String selectedItemS = (String) cboStore.getSelectedItem();
            String storeId = selectedItemS.substring(0, selectedItemS.indexOf(","));
            
            Product product= new Product();
            product.setId(Integer.parseInt(productId));
            
            Store store = new Store();
            store.setId(Integer.parseInt(storeId));

            productOutStore.setId(Integer.parseInt(lblId.getText()));
            productOutStore.setProduct(product);
            productOutStore.setStore(store);
            productOutStore.setQuantity(Integer.parseInt(spnQuantity.getValue().toString()));
            productOutStore.setDate(LocalDate.now().toString());

            update(productOutStore);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listProductOutStore();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteProductOutStore() {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            //delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductOutStoreView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        listProductOutStore();
        clear();
        return false;
    }

    private void clear() {
        lblId.setText("");
        cboProduct.setSelectedIndex(-1);
        cboStore.setSelectedIndex(-1);
        spnQuantity.setValue(0);
    }

    private void tbProductOutStoreMouseClick(MouseEvent evt) {
       
        int seleccion = tbProductOutStore.rowAtPoint(evt.getPoint());
        lblId.setText(String.valueOf(tbProductOutStore.getValueAt(seleccion, 0)));
        cboProduct.setSelectedItem(String.valueOf(tbProductOutStore.getValueAt(seleccion, 1)));
        cboStore.setSelectedItem(String.valueOf(tbProductOutStore.getValueAt(seleccion, 2)));
        spnQuantity.setValue(BigDecimal.valueOf(Double.parseDouble(tbProductOutStore.getValueAt(seleccion, 3).toString())));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JComboBox<String> cboStore;
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
    private javax.swing.JTable tbProductOutStore;
    // End of variables declaration//GEN-END:variables
}
