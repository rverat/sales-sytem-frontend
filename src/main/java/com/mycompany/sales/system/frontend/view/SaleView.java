/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend.view;

import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.config.UserCache;
import com.mycompany.sales.system.frontend.model.Customer;
import com.mycompany.sales.system.frontend.model.Product;
import com.mycompany.sales.system.frontend.model.Sale;
import com.mycompany.sales.system.frontend.model.SaleDetail;
import com.mycompany.sales.system.frontend.model.Store;
import com.mycompany.sales.system.frontend.model.StoreStock;
import com.mycompany.sales.system.frontend.model.UserSystem;
import com.mycompany.sales.system.frontend.restclient.CustomerService;
import com.mycompany.sales.system.frontend.restclient.ProductService;
import com.mycompany.sales.system.frontend.restclient.SaleDetailService;
import com.mycompany.sales.system.frontend.restclient.SaleService;
import com.mycompany.sales.system.frontend.restclient.StoreService;
import com.mycompany.sales.system.frontend.restclient.StoreStockService;
import com.mycompany.sales.system.frontend.util.UtilValidateImput;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.math.BigDecimal;
import java.math.BigInteger;
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
public class SaleView extends javax.swing.JInternalFrame {

    List<Product> listProductsInCache = new ArrayList<>();
    private TableRowSorter trsFiltro;

    public SaleView() {
        initComponents();
        loadCustomersProductsStores();
        listSales();
        UtilValidateImput.configureSpinner(spnDiscount);

        btnAddSale.setEnabled(true);
        btnNewSale.setEnabled(true);
        btnCancelSale.setEnabled(true);
        btnCancelEditSale.setEnabled(false);
        btnUpdateSale.setEnabled(false);
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

    public void update(List<SaleDetail> saleDetail) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), saleDetail);
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
        SaleService service = RetrofitClient.createService(SaleService.class);
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
        btnAddProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnCancelSaleDetail = new javax.swing.JButton();
        chbCancelSaleDetail = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblIdSaleDetail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        btnCancelSale = new javax.swing.JButton();
        btnEditSale = new javax.swing.JButton();
        btnNewSale = new javax.swing.JButton();
        btnUpdateSale = new javax.swing.JButton();
        btnCancelEditSale = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        spnDiscount = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();

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
        jPanel5.add(cboStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 230, -1));

        cboCustomer.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel5.add(cboCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 260, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 17, 1250, 72));

        btnAddSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAddSale.setText("Ejecutar Venta");
        btnAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

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
        jPanel6.add(btnUpdateSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 220, -1));

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

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1230, 140));

        spnQuantity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 110, -1));

        btnAddProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAddProduct.setText("Agregar producto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, -1));

        btnDeleteProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnDeleteProduct.setText("Quitar producto");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 180, -1));

        btnCancelSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnCancelSaleDetail.setText("Cancelar actualizacion");
        btnCancelSaleDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSaleDetailActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 220, -1));

        chbCancelSaleDetail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        chbCancelSaleDetail.setText("Cancelar producto vendido");
        jPanel6.add(chbCancelSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 30));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel7.setText("Id:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblIdSaleDetail.setEditable(false);
        lblIdSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(lblIdSaleDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, -1));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel16.setText("Cantidad:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 101, 1260, 290));
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

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 498, 1240, 250));

        btnCancelSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnCancelSale.setText("Cancelar venta");
        btnCancelSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, -1));

        btnEditSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnEditSale.setText("Editar Venta");
        btnEditSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        btnNewSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnNewSale.setText("Nueva Venta");
        btnNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        btnUpdateSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnUpdateSale.setText("Actualizar");
        btnUpdateSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 450, -1, -1));

        btnCancelEditSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnCancelEditSale.setText("Cancelar Edicion");
        btnCancelEditSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditSaleActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelEditSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel15.setText("Buscar venta:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        spnDiscount.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        spnDiscount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDiscountStateChanged(evt);
            }
        });
        getContentPane().add(spnDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 120, -1));

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel17.setText("Descuento:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        txtSearch.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 170, -1));

        lblPrice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 400, 180, 30));

        btnCalculate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnCalculate.setText("Calcular Precio");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, -1, -1));

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

            int isCancel = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 7)));

            if (isCancel == 2) {
                //update sale detail not saved

                chbCancelSaleDetail.setEnabled(false);
                lblIdSaleDetail.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 0)));
                lblId.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 1)));
                cboProducts.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 2)));
                spnQuantity.setValue(Integer.parseInt(tbSaleDetail.getValueAt(rowIndex, 3).toString()));

            } else if (isCancel == 1 || isCancel == 0) {

                //update sale detail saved in db
                chbCancelSaleDetail.setEnabled(true);
                lblIdSaleDetail.setText(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 0)));
                cboProducts.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 2)));

                boolean canceledProduct = false;

                int canceledP = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 7)));

                if (canceledP == 1) {
                    canceledProduct = true;
                }
                chbCancelSaleDetail.setSelected(canceledProduct);
                spnQuantity.setValue(Integer.parseInt(tbSaleDetail.getValueAt(rowIndex, 3).toString()));

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

    private void btnCancelSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSaleActionPerformed
        cancelSale();
    }//GEN-LAST:event_btnCancelSaleActionPerformed

    private void btnEditSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaleActionPerformed

        btnEditSale.setEnabled(false);
        btnAddSale.setEnabled(false);
        btnNewSale.setEnabled(false);
        btnCancelSale.setEnabled(false);
        btnCancelEditSale.setEnabled(true);
        btnUpdateSale.setEnabled(true);
        try {
            listSalesDetails();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditSaleActionPerformed

    private void btnNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewSaleActionPerformed

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

    private void btnUpdateSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSaleActionPerformed

        btnEditSale.setEnabled(true);
        btnAddSale.setEnabled(true);
        btnNewSale.setEnabled(true);
        btnCancelSale.setEnabled(true);
        btnCancelEditSale.setEnabled(false);
        btnUpdateSale.setEnabled(false);
        try {
            updateSale();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateSaleActionPerformed

    private void btnCancelEditSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditSaleActionPerformed

        btnEditSale.setEnabled(true);
        btnAddSale.setEnabled(true);
        btnNewSale.setEnabled(true);
        btnCancelSale.setEnabled(true);
        btnCancelEditSale.setEnabled(false);
        btnUpdateSale.setEnabled(false);
        clearProducts();
        clearForm();
    }//GEN-LAST:event_btnCancelEditSaleActionPerformed

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
        trsFiltro = new TableRowSorter(tbSale.getModel());
        tbSale.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void spnDiscountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDiscountStateChanged

    }//GEN-LAST:event_spnDiscountStateChanged

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        calculateFinalPrice();
    }//GEN-LAST:event_btnCalculateActionPerformed

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
                registros[1] = response.getUserSystem().getId() + ", " + response.getUserSystem().getName();
                registros[2] = response.getCustomer().getId() + ", " + response.getCustomer().getName();
                registros[3] = response.getStore().getId() + ", " + response.getStore().getName();
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
        
        if(saleDetailListFromDB.get(0).getSale().getCancelSale() == 0){
             saleDetailsListInCache.clear();
        model.fireTableDataChanged();

        if (saleDetailListFromDB != null) {

            String[] registros = new String[8];
            for (SaleDetail response : saleDetailListFromDB) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = String.valueOf(response.getSale().getId());
                registros[2] = String.valueOf(response.getProduct().getId() + ", " + response.getProduct().getName());
                registros[3] = String.valueOf(response.getQuantity());
                registros[4] = String.valueOf(response.getUnitPrice());
                registros[5] = String.valueOf(response.getDiscount());
                registros[6] = String.valueOf(response.getTotalPrice());
                registros[7] = String.valueOf(response.getCancelSaleDetail());
                saleDetailsListInCache.add(response);
                model.addRow(registros);
            }
            tbSaleDetail.setModel(model);

        }

        lblId.setText(String.valueOf(tbSale.getValueAt(rowIndex, 0)));
        cboCustomer.setSelectedItem(String.valueOf(tbSale.getValueAt(rowIndex, 2)));
        cboProducts.setSelectedItem(String.valueOf(tbSale.getValueAt(rowIndex, 3)));
        spnDiscount.setValue(BigDecimal.valueOf(Double.parseDouble(tbSale.getValueAt(rowIndex, 6).toString())));
        }else{
            
            JOptionPane.showMessageDialog(null, "Esta venta ya no se puede actualizar, ya esta cancelada");
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
            
            String discount =  spnDiscount.getValue().toString();
            
            BigDecimal bigdecimalDicount = new BigDecimal(BigInteger.ZERO);
            
            if(!discount.equals("0.00")){
                bigdecimalDicount = (BigDecimal) spnDiscount.getValue();
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
                sale.setUserSystem(new UserSystem(Integer.parseInt(UserCache.getId()), "", "", "", "", "", ""));
                sale.setCustomer(customer);
                sale.setStore(store);
                sale.setDiscount(bigdecimalDicount);

                saleDetail.setCancelSaleDetail(0);

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

        if (action == 1) {
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida");
                throw new Exception("Cantidad ingresada es incorrecta");
            }
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
            saleDetail.setDiscount(BigDecimal.ZERO);

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

            //saleDetail.setId(0);
            saleDetailsListInCache.add(saleDetail);
            Object[] row = new Object[8];
            row[0] = saleDetail.getId();
            row[1] = saleDetail.getSale().getId();
            row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
            row[3] = saleDetail.getQuantity();
            row[4] = saleDetail.getUnitPrice();
            row[5] = saleDetail.getDiscount();
            row[6] = saleDetail.getTotalPrice();
            row[7] = saleDetail.getCancelSaleDetail();
            model.addRow(row);
            tbSaleDetail.setModel(model);
            model.fireTableDataChanged();

        } else if (action == 0) {

            int rowIndex = tbSaleDetail.getSelectedRow();
            // Verificar si hay una fila seleccionada
            if (rowIndex != -1) {

                int isCancel = Integer.parseInt(String.valueOf(tbSaleDetail.getValueAt(rowIndex, 7)));

                if (isCancel == 1 || isCancel == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar este producto");
                    throw new Exception("No se puede eliminar este producto");
                }

                if (isCancel == 2) {
                    saleDetailsListInCache.remove(rowIndex);
                    model.removeRow(rowIndex);
                    model.fireTableDataChanged();
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
        product.setName(p.getName());

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
                            // Update sale detail properties
                            saleDetail.setSale(sale);
                            saleDetail.setProduct(product);
                            saleDetail.setQuantity(0);
                            saleDetail.setUnitPrice(BigDecimal.ZERO);
                            saleDetail.setTotalPrice(BigDecimal.ZERO);
                            saleDetail.setCancelSaleDetail(1);

                            // Create the updated row
                            Object[] row = new Object[8];
                            row[0] = saleDetail.getId();
                            row[1] = saleDetail.getSale().getId();
                            row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
                            row[3] = saleDetail.getQuantity();
                            row[4] = saleDetail.getUnitPrice();
                            row[5] = saleDetail.getDiscount();
                            row[6] = saleDetail.getTotalPrice();
                            row[7] = saleDetail.getCancelSaleDetail();

                            // Update the table row
                            int rowIndex = saleDetailsListInCache.indexOf(saleDetail);
                            for (int i = 0; i < row.length; i++) {
                                model.setValueAt(row[i], rowIndex, i);
                            }
                        }
                    }
                    model.fireTableDataChanged();
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
                        saleDetail.setSale(sale);
                        saleDetail.setProduct(product);
                        saleDetail.setQuantity(quantity);
                        saleDetail.setUnitPrice(unitPrice);
                        saleDetail.setTotalPrice(finalPrice);
                        saleDetail.setCancelSaleDetail(0);
                        // howupdate table row

                        // Create the updated row
                        Object[] row = new Object[8];
                        row[0] = saleDetail.getId();
                        row[1] = saleDetail.getSale().getId();
                        row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
                        row[3] = saleDetail.getQuantity();
                        row[4] = saleDetail.getUnitPrice();
                        row[5] = saleDetail.getDiscount();
                        row[6] = saleDetail.getTotalPrice();
                        row[7] = saleDetail.getCancelSaleDetail();

                        // Update the table row
                        int rowIndex = saleDetailsListInCache.indexOf(saleDetail);
                        for (int i = 0; i < row.length; i++) {
                            model.setValueAt(row[i], rowIndex, i);
                        }
                    }
                }
                model.fireTableDataChanged();
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

                    // Create the updated row
                    Object[] row = new Object[8];
                    row[0] = saleDetail.getId();
                    row[1] = saleDetail.getSale().getId();
                    row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
                    row[3] = saleDetail.getQuantity();
                    row[4] = saleDetail.getUnitPrice();
                    row[5] = saleDetail.getDiscount();
                    row[6] = saleDetail.getTotalPrice();
                    row[7] = saleDetail.getCancelSaleDetail();

                    // Update the table row
                    int rowIndex = saleDetailsListInCache.indexOf(saleDetail);
                    for (int i = 0; i < row.length; i++) {
                        model.setValueAt(row[i], rowIndex, i);
                    }
                }
            }
            model.fireTableDataChanged();
        }
    }

    private void updateSale() throws Exception {

        ArrayList<SaleDetail> saleDetailList = new ArrayList<>();
        

          double discountValue = (double) spnDiscount.getValue();


         String discount =  spnDiscount.getValue().toString();
            
            BigDecimal bigdecimalDicount = new BigDecimal(BigInteger.ZERO);
            
            if(!discount.equals("0.00")){
                bigdecimalDicount = (BigDecimal) spnDiscount.getValue();
            }
                
        //BigDecimal bigdecimalDicount = (BigDecimal) spnDiscount.getValue();

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

            sale.setId(Integer.parseInt(lblId.getText()));
            sale.setUserSystem(new UserSystem(Integer.parseInt(UserCache.getId()), "", "", "", "", "", ""));
            sale.setCustomer(customer);
            sale.setStore(store);
            sale.setDiscount(bigdecimalDicount);
            sale.setDate(saleDetail.getSale().getDate());

            saleDetail.setSale(sale);
            saleDetail.setProduct(product);
            saleDetail.setQuantity(saleDetail.getQuantity());

            saleDetailList.add(saleDetail);
        }

        update(saleDetailList);
        listSales();
        JOptionPane.showMessageDialog(null, "Actualizado");
        
        clearProducts();
        clearForm();

    }

    private void calculateFinalPrice() {

        if (!saleDetailsListInCache.isEmpty()) {

            BigDecimal finalPrice = BigDecimal.ZERO;

            for (SaleDetail saleDetail : saleDetailsListInCache) {

                if (saleDetail.getCancelSaleDetail() == 0 || saleDetail.getCancelSaleDetail() == 2) {
                    finalPrice = finalPrice.add(saleDetail.getTotalPrice());

                }

            }

            BigDecimal bigdecimalDicount = (BigDecimal) spnDiscount.getValue();

            finalPrice = finalPrice.subtract(bigdecimalDicount);

            lblPrice.setText(String.valueOf(finalPrice));

        }

    }

    private void clearForm() {
        lblId.setText("");
        lblIdSaleDetail.setText("");
        cboCustomer.setSelectedIndex(0);
        cboStore.setSelectedIndex(0);
        cboProducts.setSelectedIndex(0);
        spnQuantity.setValue(0);
        spnDiscount.setValue(0.00);
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

        try {
            cancelSale(idSale);
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Venta cancelada");
        listSales();
        clearProducts();
        clearForm();

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
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCancelEditSale;
    private javax.swing.JButton btnCancelSale;
    private javax.swing.JButton btnCancelSaleDetail;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditSale;
    private javax.swing.JButton btnNewSale;
    private javax.swing.JButton btnUpdateSale;
    private javax.swing.JButton btnUpdateSaleDetail;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboProducts;
    private javax.swing.JComboBox<String> cboStore;
    private javax.swing.JCheckBox chbCancelSaleDetail;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lblId;
    private javax.swing.JTextField lblIdSaleDetail;
    private javax.swing.JLabel lblPrice;
    public javax.swing.JLabel lblUsuario3;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JSpinner spnDiscount;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tbSale;
    private javax.swing.JTable tbSaleDetail;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
