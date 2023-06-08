/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.google.gson.Gson;
import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.config.TokenCache;
import com.mycompany.sales.sytem.frontend.model.Customer;
import com.mycompany.sales.sytem.frontend.model.Product;
import com.mycompany.sales.sytem.frontend.model.Sale;
import com.mycompany.sales.sytem.frontend.model.SaleDetail;
import com.mycompany.sales.sytem.frontend.model.Store;
import com.mycompany.sales.sytem.frontend.model.StoreStock;
import com.mycompany.sales.sytem.frontend.model.UserSystem;
import com.mycompany.sales.sytem.frontend.restclient.CustomerService;
import com.mycompany.sales.sytem.frontend.restclient.ProductService;
import com.mycompany.sales.sytem.frontend.restclient.SaleDetailService;
import com.mycompany.sales.sytem.frontend.restclient.SaleService;
import com.mycompany.sales.sytem.frontend.restclient.StoreService;
import com.mycompany.sales.sytem.frontend.restclient.StoreStockService;

import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    List<Product> listProductsInCache = new ArrayList<>();

    public SaleView() {
        initComponents();
        loadCustomersProductsStores();
        listSales();
    }

    public List<Sale> listAll() throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<List<Sale>> call = service.findAll(TokenCache.getToken());
        Response<List<Sale>> response = call.execute();
        return response.body();
    }

    public void save(List<SaleDetail> saleDetail) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), saleDetail);
        call.execute();
    }

    public void update(Sale sale) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), sale);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
    }

    public void saveSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), saleDetail);
        call.execute();
    }

    public void updateSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), saleDetail);
        call.execute();
    }
    
    public void cancelSale(int saleId) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.cancelSale(TokenCache.getToken(), saleId);
        call.execute();
    }

    //others service
    public List<Customer> listCustomers() throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<List<Customer>> call = service.findAll(TokenCache.getToken());
        Response<List<Customer>> response = call.execute();
        return response.body();
    }

    public List<Store> listStores() throws Exception {
        StoreService service = RetrofitClient.createService(StoreService.class);
        Call<List<Store>> call = service.findAll(TokenCache.getToken());
        Response<List<Store>> response = call.execute();
        return response.body();
    }

    public List<Product> listProducts() throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<List<Product>> call = service.findAll(TokenCache.getToken());
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public Product findByIdProduct(int id) throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        Call<Product> call = service.findById(TokenCache.getToken(), id);
        Response<Product> response = call.execute();
        return response.body();
    }

    public StoreStock findByProductIdAndStoreId(int productId, int storeId) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<StoreStock> call = service.findByProductIdAndStoreId(TokenCache.getToken(), productId, storeId);
        Response<StoreStock> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en Stock");
            throw new Exception("No hay producto registrado en Stock");
        }

        return response.body();

    }

    public List<SaleDetail> getSaleDetailsFromDB(int saleId) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleDetail>> call = service.getSaleDetails(TokenCache.getToken(), saleId);
        Response<List<SaleDetail>> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en esta venta");
            throw new Exception("No hay producto registrado en esta venta");
        }
        return response.body();
    }

    public SaleDetail getSaleDetailFromDB(int saleDetailId) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<SaleDetail> call = service.getSaleDetail(TokenCache.getToken(), saleDetailId);
        Response<SaleDetail> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en esta venta");
            throw new Exception("No hay producto registrado en esta venta");
        }
        return response.body();
    }
    // fin others service

    private void loadCustomersProductsStores() {
        try {
            List<Customer> customers = listCustomers();
            List<Store> stores = listStores();
            List<Product> products = listProducts();

            for (Product product : products) {
                cboProducts.addItem(String.valueOf(product.getId()) + ", " + product.getName());
                listProductsInCache.add(product);

            }
            for (Customer customer : customers) {
                cboCustomer.addItem(String.valueOf(customer.getId()) + ", " + customer.getName());
            }
            for (Store store : stores) {
                cboStore.addItem(String.valueOf(store.getId()) + ", " + store.getName());
            }

        } catch (Exception e) {

        }
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
        cboStore = new javax.swing.JComboBox<>();
        cboCustomer = new javax.swing.JComboBox<>();
        btnAddSale = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        cboProducts = new javax.swing.JComboBox<>();
        btnUpdateSaleDetail = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSaleDetail = new javax.swing.JTable();
        spnQuantity = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnCancelSaleDetail = new javax.swing.JButton();
        chbCancelSaleDetail = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblIdSaleDetail = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnEditSale = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnExecuteSaleDetail = new javax.swing.JButton();

        setClosable(true);
        setTitle("Ventas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel6.setText("Id:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel10.setText("Tienda:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel11.setText("Cliente:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));
        jPanel5.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        lblId.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 190, -1));

        cboStore.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(cboStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 230, -1));

        cboCustomer.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(cboCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 260, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 17, 1070, 72));

        btnAddSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAddSale.setText("Ejecutar Venta");
        btnAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de los productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel13.setText("Producto:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboProducts.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(cboProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 260, -1));

        btnUpdateSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnUpdateSaleDetail.setText("Actualizar producto");
        btnUpdateSaleDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSaleDetailActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdateSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 20, 200, -1));

        tbSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        tbSaleDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSaleDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleDetailMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSaleDetail);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1160, 140));

        spnQuantity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 120, -1));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel15.setText("Cantidad:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        btnAddProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAddProduct.setText("Agregar producto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        btnDeleteProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnDeleteProduct.setText("Quitar producto");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 180, -1));

        btnCancelSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnCancelSaleDetail.setText("Cancelar actualizacion");
        btnCancelSaleDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSaleDetailActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 70, 200, -1));

        chbCancelSaleDetail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        chbCancelSaleDetail.setText("Cancelar producto vendido");
        jPanel6.add(chbCancelSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 30));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel7.setText("Id:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblIdSaleDetail.setEditable(false);
        lblIdSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(lblIdSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 101, 1200, 290));
        jPanel6.getAccessibleContext().setAccessibleName("Detalles del producto");

        tbSale.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbSale);
        if (tbSale.getColumnModel().getColumnCount() > 0) {
            tbSale.getColumnModel().getColumn(6).setHeaderValue("Title 7");
            tbSale.getColumnModel().getColumn(7).setHeaderValue("Title 8");
        }

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 458, 1166, 240));

        jButton1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jButton1.setText("Cancelar venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, -1, -1));

        btnEditSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnEditSale.setText("Editar Venta");
        btnEditSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, -1, -1));

        jButton3.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jButton3.setText("Nueva Venta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        btnExecuteSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnExecuteSaleDetail.setText("Actualizar");
        btnExecuteSaleDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteSaleDetailActionPerformed(evt);
            }
        });
        getContentPane().add(btnExecuteSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateSaleDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSaleDetailActionPerformed
        try {
            updateSaleDetail();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateSaleDetailActionPerformed

    private void btnAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaleActionPerformed
        try {
            saveSale();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddSaleActionPerformed

    private void tbSaleDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleDetailMouseClicked

        int rowIndex = tbSaleDetail.rowAtPoint(evt.getPoint());
        // Verificar si hay una fila seleccionada
        if (rowIndex != -1) {

            int isCancel = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 0)));

            if (isCancel != 1 || isCancel != 0) {
                //update sale detail not saved

                chbCancelSaleDetail.setEnabled(true);
                lblIdSaleDetail.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 0)));
                lblId.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 1)));
                cboProducts.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 2)));
                spnQuantity.setValue(BigDecimal.valueOf(Double.parseDouble(tbSaleDetail.getValueAt(rowIndex, 7).toString())));

            } else if (isCancel == 1 || isCancel == 0) {

                //update sale detail saved in db
                chbCancelSaleDetail.setEnabled(false);
                lblIdSaleDetail.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 0)));
                cboProducts.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 2)));

                boolean canceledProduct = false;

                int canceledP = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 3)));

                if (canceledP == 1) {
                    canceledProduct = true;
                }
                chbCancelSaleDetail.setSelected(canceledProduct);
                spnQuantity.setValue(BigDecimal.valueOf(Double.parseDouble(tbSaleDetail.getValueAt(rowIndex, 7).toString())));

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el producto a actualizar");
            try {
                throw new Exception("Seleccione el producto a actualizar");
            } catch (Exception ex) {
                Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_tbSaleDetailMouseClicked

    private void tbSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSaleMouseClicked

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        try {
            addOrDeleteProducts(1);
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cancelSale();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaleActionPerformed
        try {
            listSalesDetails();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditSaleActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed

        try {
            addOrDeleteProducts(0);
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnCancelSaleDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSaleDetailActionPerformed
        clearFormDetail();
    }//GEN-LAST:event_btnCancelSaleDetailActionPerformed

    private void btnExecuteSaleDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteSaleDetailActionPerformed
        try {
            updateSale();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExecuteSaleDetailActionPerformed

    ArrayList<SaleDetail> saleDetailsListInCache = new ArrayList<>();
    String cabecera[] = {"Id", "Venta", "Producto", "Cantidad", "Precio unitario", "Descuento", "Precio total", "Cancelado"};
    DefaultTableModel model = new DefaultTableModel(null, cabecera);

    private void listSales() {

        List<Sale> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabeceras[] = {"Id", "Usuario", "Cliente", "Tienda", "Fecha", "Precio", "Descuento", "Precio Total", "Cancelado"};
            DefaultTableModel table = new DefaultTableModel(null, cabeceras);
            String[] registros = new String[9];
            for (Sale response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getUserSystem().getName();
                registros[2] = response.getCustomer().getName();
                registros[3] = response.getStore().getName();
                registros[4] = response.getDate();
                registros[5] = String.valueOf(response.getPrice());
                registros[6] = String.valueOf(response.getDiscount());
                registros[7] = String.valueOf(response.getTotalPrice());
                registros[8] = String.valueOf(response.getCancelSale());

                table.addRow(registros);
            }
            tbSale.setModel(table);

        }

    }

    private void listSalesDetails() throws Exception {

        int idSale = 0;

        // Obtener el índice de la fila seleccionada
        int rowIndex = tbSale.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (rowIndex != -1) {
            // Obtener el valor del primer campo de la fila seleccionada
            int value = Integer.parseInt(String.valueOf(tbSale.getValueAt(rowIndex, 0)));

            // Verificar si el valor no es nulo
            if (value != 0) {
                idSale = value;
            }
        }

        Sale sale = new Sale();
        sale.setId(idSale);

        List<SaleDetail> saleDetailListFromDB = getSaleDetailsFromDB(idSale);
        saleDetailsListInCache.clear();

        if (saleDetailListFromDB != null) {
            String cabeceras[] = {"Id", "Id Venta", "Id Producto", "Cantidad", "Precio Unitario", "Descuento", "Precio Total", "Cancelado"};
            DefaultTableModel table = new DefaultTableModel(null, cabeceras);
            String[] registros = new String[8];
            for (SaleDetail response : saleDetailListFromDB) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = String.valueOf(response.getSale().getId());
                registros[2] = String.valueOf(response.getProduct().getId());
                registros[3] = String.valueOf(response.getQuantity());
                registros[4] = String.valueOf(response.getUnitPrice());
                registros[5] = String.valueOf(response.getDiscount());
                registros[6] = String.valueOf(response.getTotalPrice());
                registros[7] = String.valueOf(response.getCancelSaleDetail());
                saleDetailsListInCache.add(response);
                table.addRow(registros);
            }
            tbSaleDetail.setModel(table);

        }

    }
    //params for build sale details

    private void saveSale() throws Exception {

        try {

            //validate in data base stock store saleDetailsListInCache
            String selectedItemS = (String) cboStore.getSelectedItem();
            int storeIdforDB = Integer.parseInt(selectedItemS.substring(0, selectedItemS.indexOf(",")));

            for (SaleDetail saleDetail : saleDetailsListInCache) {

                StoreStock storeStock = findByProductIdAndStoreId(saleDetail.getProduct().getId(), storeIdforDB);

                if (storeStock.getQuantity() <= saleDetail.getQuantity()) {

                    JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
                    throw new Exception("El Stock del producto solicitado es menor al pedido");

                }

            }

            //fin de validacion
            ArrayList<SaleDetail> saleDetailList = new ArrayList<>();

            for (SaleDetail saleDetail : saleDetailsListInCache) {

                //SaleDetail saleDetail = new SaleDetail();
                Product product = new Product();
                Customer customer = new Customer();
                Store store = new Store();
                Sale sale = new Sale();

                String selectedItemC = (String) cboCustomer.getSelectedItem();
                int customerId = Integer.parseInt(selectedItemC.substring(0, selectedItemC.indexOf(",")));

                String selectedItemSX = (String) cboStore.getSelectedItem();
                int storeId = Integer.parseInt(selectedItemSX.substring(0, selectedItemSX.indexOf(",")));

                product.setId(saleDetail.getProduct().getId());
                customer.setId(customerId);
                store.setId(storeId);

                sale.setId(0);
                sale.setUserSystem(new UserSystem(2, "", "", "", "", "", ""));
                sale.setCustomer(customer);
                sale.setStore(store);

                saleDetail.setId(0);
                saleDetail.setSale(sale);
                saleDetail.setProduct(product);
                saleDetail.setQuantity(saleDetail.getQuantity());

                saleDetailList.add(saleDetail);
            }

            save(saleDetailList);

            JOptionPane.showMessageDialog(null, "Registrado");
            listSales();
            clearProducts();
            clearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void addOrDeleteProducts(int action) throws Exception {

        String selectedItem = (String) cboProducts.getSelectedItem();

        int productId = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));
        String productName = selectedItem.substring(selectedItem.indexOf(",") + 2);

        String selectedItemS = (String) cboStore.getSelectedItem();
        int storeIdforDB = Integer.parseInt(selectedItemS.substring(0, selectedItemS.indexOf(",")));

        int quantity = (int) spnQuantity.getValue();
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida");
            throw new Exception("Cantidad ingresada es incorrecta");
        }

        int zise = saleDetailsListInCache.size();

        //Add product
        if (action == 1) {

            if (zise > 1) {
                for (SaleDetail saleDetail : saleDetailsListInCache) {
                    if (saleDetail.getProduct().getId() == productId) {
                        JOptionPane.showMessageDialog(null, "El producto ya esta agregado, actualize");
                        throw new Exception("El producto ya esta agregado, actualize");
                    }
                }
            }

            //validacion de stock
            StoreStock storeStock = findByProductIdAndStoreId(productId, storeIdforDB);

            if (storeStock.getQuantity() < quantity) {
                JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
                throw new Exception("El Stock del producto solicitado es menor al pedido");
            }
            //fin de validacion de stock

            Sale sale = new Sale();
            Product product = new Product();
            product.setId(productId);
            product.setName(" " + productName);

            SaleDetail saleDetail = new SaleDetail();

            saleDetail.setSale(sale);
            saleDetail.setProduct(product);
            saleDetail.setQuantity(quantity);
            saleDetail.setDiscount(new BigDecimal(BigInteger.ZERO));

            for (Product productInCache : listProductsInCache) {

                if (productInCache.getId() == saleDetail.getProduct().getId()) {
                    saleDetail.setUnitPrice(productInCache.getPrice());
                }
            }

            BigDecimal quantityB = new BigDecimal(saleDetail.getQuantity());
            BigDecimal unitPrice = saleDetail.getUnitPrice();
            BigDecimal finalPrice = quantityB.multiply(unitPrice);

            saleDetail.setTotalPrice(finalPrice);
            //value 2 for product not saled
            saleDetail.setCancelSaleDetail(2);

            saleDetail.setId(saleDetailsListInCache.size() + 1);

            Object[] row = new Object[7];
            row[0] = saleDetail.getId();
            row[1] = saleDetail.getSale().getId();
            row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
            row[3] = saleDetail.getQuantity();
            row[4] = saleDetail.getUnitPrice();
            row[5] = saleDetail.getDiscount();
            row[6] = saleDetail.getTotalPrice();
            row[7] = saleDetail.getCancelSaleDetail();
            model.addRow(row);

            saleDetail.setId(0);

            saleDetailsListInCache.add(saleDetail);

            tbSaleDetail.setModel(model);
            model.fireTableDataChanged();

        } else if (action == 0) {
            int selectedRowIndex = tbSaleDetail.getSelectedRow();
            if (selectedRowIndex >= 0 && selectedRowIndex < saleDetailsListInCache.size()) {

                int value = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(selectedRowIndex, 7)));

                if (value != 0 || value != 1) {
                    saleDetailsListInCache.remove(selectedRowIndex);
                    model.removeRow(selectedRowIndex);
                    model.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar este producto");
                    throw new Exception("No se puede eliminar este producto");
                }
            }
        }
    }

    private void updateSaleDetail() throws Exception {

        Sale sale = new Sale();
        sale.setId(Integer.parseInt(lblId.getText().toString()));

        String selectedItemS = (String) cboStore.getSelectedItem();
        int storeId = Integer.parseInt(selectedItemS.substring(0, selectedItemS.indexOf(",")));
        Store store = new Store();
        store.setId(storeId);

        int idSaleDetail = Integer.parseInt(lblIdSaleDetail.getText().toString());
        String selectedItem = (String) cboProducts.getSelectedItem();
        int productId = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));
        String productName = selectedItem.substring(selectedItem.indexOf(",") + 2);

        int quantity = (int) spnQuantity.getValue();
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida");
            throw new Exception("Cantidad ingresada es incorrecta");
        }

        //get product price
        Product p = findByIdProduct(productId);

        Product product = new Product();
        product.setId(productId);
        product.setPrice(p.getPrice());

        BigDecimal quantityB = new BigDecimal(quantity);
        BigDecimal unitPrice = product.getPrice();
        BigDecimal finalPrice = quantityB.multiply(unitPrice);

        if (chbCancelSaleDetail.isEnabled()) {

            boolean selected = chbCancelSaleDetail.isSelected();
            SaleDetail saleDetailFromDB = getSaleDetailFromDB(idSaleDetail);

            if (selected) {

                if (saleDetailFromDB.getCancelSaleDetail() == 1) {
                    //not apply changes
                } else {

                    for (SaleDetail saleDetail : saleDetailsListInCache) {

                        if (saleDetail.getId() == idSaleDetail) {
                            //uodate sale detail
                            saleDetail.setSale(sale);
                            saleDetail.setProduct(product);
                            saleDetail.setQuantity(0);
                            saleDetail.setTotalPrice(BigDecimal.ZERO);
                            saleDetail.setCancelSaleDetail(1);

                        }
                        //update table

                    }
                }
            } else {

                StoreStock storeStock = findByProductIdAndStoreId(productId, storeId);

                //get sale detail saved
                if ((storeStock.getQuantity() + saleDetailFromDB.getQuantity()) < quantity) {
                    JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
                    throw new Exception("El Stock del producto solicitado es menor al pedido");
                }
                //fin de validacion de stock
                for (SaleDetail saleDetail : saleDetailsListInCache) {

                    if (saleDetail.getId() == idSaleDetail) {
                        //uodate sale detail
                        saleDetail.setSale(sale);
                        saleDetail.setProduct(product);
                        saleDetail.setQuantity(quantity);
                        saleDetail.setTotalPrice(finalPrice);
                        saleDetail.setCancelSaleDetail(0);
                        //update table row

                    }

                }

            }

        } else {

            StoreStock storeStock = findByProductIdAndStoreId(productId, storeId);

            //get sale detail saved
            if (storeStock.getQuantity() < quantity) {
                JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
                throw new Exception("El Stock del producto solicitado es menor al pedido");
            }
            for (SaleDetail saleDetail : saleDetailsListInCache) {

                if (saleDetail.getId() == idSaleDetail) {
                    //uodate sale detail
                    saleDetail.setSale(sale);
                    saleDetail.setProduct(product);
                    saleDetail.setQuantity(quantity);
                    saleDetail.setTotalPrice(finalPrice);
                    saleDetail.setCancelSaleDetail(2); //2 for product not saled
                    //update table row

                }

            }
        }
    }

    private void updateSale() throws Exception {

        ArrayList<SaleDetail> saleDetailList = new ArrayList<>();

        for (SaleDetail saleDetail : saleDetailsListInCache) {

            if (saleDetail.getCancelSaleDetail() == 2) {
                saleDetail.setId(0);
            }

            //SaleDetail saleDetail = new SaleDetail();
            Product product = new Product();
            Customer customer = new Customer();
            Store store = new Store();
            Sale sale = new Sale();

            String selectedItemC = (String) cboCustomer.getSelectedItem();
            int customerId = Integer.parseInt(selectedItemC.substring(0, selectedItemC.indexOf(",")));

            String selectedItemSX = (String) cboStore.getSelectedItem();
            int storeId = Integer.parseInt(selectedItemSX.substring(0, selectedItemSX.indexOf(",")));

            product.setId(saleDetail.getProduct().getId());
            customer.setId(customerId);
            store.setId(storeId);

            sale.setId(0);
            sale.setUserSystem(new UserSystem(2, "", "", "", "", "", ""));
            sale.setCustomer(customer);
            sale.setStore(store);

            saleDetail.setSale(sale);
            saleDetail.setProduct(product);
            saleDetail.setQuantity(saleDetail.getQuantity());

            saleDetailList.add(saleDetail);
        }

        save(saleDetailList);

        JOptionPane.showMessageDialog(null, "Registrado");
        listSales();
        clearProducts();
        clearForm();

    }

    private void clearForm() {
        lblId.setText("");
        lblIdSaleDetail.setText("");
        cboCustomer.setSelectedIndex(0);
        cboStore.setSelectedIndex(0);
        cboProducts.setSelectedIndex(0);
        spnQuantity.setValue(0);
        clearProducts();

    }
    
    private void cancelSale() {
       int idSale = 0;

        // Obtener el índice de la fila seleccionada
        int rowIndex = tbSale.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (rowIndex != -1) {
            // Obtener el valor del primer campo de la fila seleccionada
            int value = Integer.parseInt(String.valueOf(tbSale.getValueAt(rowIndex, 0)));

            // Verificar si el valor no es nulo
            if (value != 0) {
                idSale = value;
            }
        }

        Sale sale = new Sale();
        sale.setId(idSale);
        sale.setCancelSale(1);
        
        
        
        
    }
    
    private void clearFormDetail() {
        lblIdSaleDetail.setText("");
        cboProducts.setSelectedIndex(0);
        spnQuantity.setValue(0);

    }

    private void clearProducts() {
        saleDetailsListInCache.clear();
        model = (DefaultTableModel) tbSaleDetail.getModel();
        model.setRowCount(0);
    }

    private void confirmationSale() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "Realizar Venta", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnAddSale;
    private javax.swing.JButton btnCancelSaleDetail;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditSale;
    private javax.swing.JButton btnExecuteSaleDetail;
    private javax.swing.JButton btnUpdateSaleDetail;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboProducts;
    private javax.swing.JComboBox<String> cboStore;
    private javax.swing.JCheckBox chbCancelSaleDetail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lblId;
    private javax.swing.JTextField lblIdSaleDetail;
    public javax.swing.JLabel lblUsuario3;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tbSale;
    private javax.swing.JTable tbSaleDetail;
    // End of variables declaration//GEN-END:variables


}
