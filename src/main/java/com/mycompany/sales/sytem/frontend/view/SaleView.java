/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.google.gson.Gson;
import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
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
        Call<List<Sale>> call = service.findAll("");
        Response<List<Sale>> response = call.execute();
        return response.body();
    }

    public void save(List<SaleDetail> saleDetail) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.save("",saleDetail);
        call.execute();
    }

    public void update(Sale sale) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.update("", sale);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SaleService service = RetrofitClient.createService(SaleService.class);
        Call<HttpStatus> call = service.delete("", id);
        call.execute();
    }

    public void saveSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.save("", saleDetail);
        call.execute();
    }

    public void updateSaleDetail(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.update("", saleDetail);
        call.execute();
    }

    //others service
    public List<Customer> listCustomers() throws Exception {
        CustomerService service = RetrofitClient.createService(CustomerService.class);
        Call<List<Customer>> call = service.findAll("");
        Response<List<Customer>> response = call.execute();
        return response.body();
    }

    public List<Store> listStores() throws Exception {
        StoreService service = RetrofitClient.createService(StoreService.class);
        Call<List<Store>> call = service.findAll("");
        Response<List<Store>> response = call.execute();
        return response.body();
    }

    public List<Product> listProducts() throws Exception {
        ProductService service = RetrofitClient.createService(ProductService.class);
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYWNvIiwiZXhwIjoxNjg1NTkxMTQ1LCJpYXQiOjE2ODU1OTExNDV9.t1TGvTPMNPVAOTAfgucJrAjvwAx0bDlzJLvo51OMbqw";
        Call<List<Product>> call = service.findAll("Bearer " + token);
        Response<List<Product>> response = call.execute();
        return response.body();
    }

    public StoreStock findByProductIdAndStoreId(int productId, int storeId) throws Exception {
        StoreStockService service = RetrofitClient.createService(StoreStockService.class);
        Call<StoreStock> call = service.findByProductIdAndStoreId("", productId, storeId);
        Response<StoreStock> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en Stock");
            throw new Exception("No hay producto registrado en Stock");
        }

        return response.body();

    }

    public List<SaleDetail> getSaleDetails(int saleId) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleDetail>> call = service.getSaleDetails("", saleId);
        Response<List<SaleDetail>> response = call.execute();


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
        btnDeleteProduct = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSaleDetail = new javax.swing.JTable();
        spnQuantity = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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
        getContentPane().add(btnAddSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de los productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel13.setText("Producto:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        cboProducts.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(cboProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 260, -1));

        btnDeleteProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnDeleteProduct.setText("Quitar producto de la venta");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        tbSaleDetail.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        tbSaleDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tbSaleDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleDetailMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSaleDetail);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 1020, 140));

        spnQuantity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jPanel6.add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 120, -1));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel15.setText("Cantidad:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        btnAddProduct.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        btnAddProduct.setText("Agregar producto a la compra");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 101, 1075, 295));
        jPanel6.getAccessibleContext().setAccessibleName("Detalles del producto");

        tbSale.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
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

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 478, 1166, 220));

        jButton1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jButton1.setText("Nueva Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        try {
            addOrDeleteProducts(0);
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaleActionPerformed
        try {
            saveSale();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddSaleActionPerformed

    private void tbSaleDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleDetailMouseClicked

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
        clearProducts();
        clearForm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listSales() {

        List<Sale> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabeceras[] = {"Id", "Usuario", "Cliente", "Tienda", "Fecha", "Precio", "Descuento", "Precio Total"};
            DefaultTableModel table = new DefaultTableModel(null, cabeceras);
            String[] registros = new String[8];
            for (Sale response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getUserSystem().getName();
                registros[2] = response.getCustomer().getName();
                registros[3] = response.getStore().getName();
                registros[4] = response.getDate();
                registros[5] = String.valueOf(response.getPrice());
                registros[6] = String.valueOf(response.getDiscount());
                registros[7] = String.valueOf(response.getTotalPrice());

                table.addRow(registros);
            }
            tbSale.setModel(table);

        }

    }
    //params for build sale details
    ArrayList<SaleDetail> saleDetailsListInCache = new ArrayList<>();
    String cabecera[] = {"Id", "Venta", "Producto", "Cantidad", "Precio unitario", "Descuento", "Precio total"};
    DefaultTableModel model = new DefaultTableModel(null, cabecera);

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


    private void listSalesDetails() throws Exception {

        List<SaleDetail> lista = new ArrayList<>();

        Sale sale = new Sale();
        sale.setId(Integer.parseInt(lblId.getText().toString()));

        List<SaleDetail> saleDetailListFromDB = getSaleDetails(sale.getId());

        try {
            lista = saleDetailListFromDB;
        } catch (Exception ex) {
            Logger.getLogger(SaleView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabeceras[] = {"Id", "Id Venta", "Id Producto", "Cantidad", "Precio Unitario", "Descuento", "Precio Total"};
            DefaultTableModel table = new DefaultTableModel(null, cabeceras);
            String[] registros = new String[7];
            for (SaleDetail response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = String.valueOf(response.getSale().getId());
                registros[2] = String.valueOf(response.getProduct().getId());
                registros[3] = String.valueOf(response.getQuantity());
                registros[4] = String.valueOf(response.getUnitPrice());
                registros[5] = String.valueOf(response.getDiscount());
                registros[6] = String.valueOf(response.getTotalPrice());

                table.addRow(registros);
            }
            tbSale.setModel(table);

        }

    }

    private void tb_SaleDetailMouseClick(MouseEvent evt) {

        int seleccion = tbSaleDetail.rowAtPoint(evt.getPoint());
        lblId.setText(String.valueOf(tbSaleDetail.getValueAt(seleccion, 0)));
        //cboProduct.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(seleccion, 1)));
        cboStore.setSelectedItem(String.valueOf(tbSaleDetail.getValueAt(seleccion, 2)));
        spnQuantity.setValue(BigDecimal.valueOf(Double.parseDouble(tbSaleDetail.getValueAt(seleccion, 3).toString())));

    }

    private void addOrDeleteProducts(int action) throws Exception {
        int quantity = (int) spnQuantity.getValue();
        
        if(quantity <= 0){
            JOptionPane.showMessageDialog(null, "Seleccione una cantidad valida");
            throw new Exception("Cantidad ingresada es incorrecta");
        }
        
        //BigDecimal discount = BigDecimal.valueOf(Integer.parseInt(spnDiscountPdt.getValue().toString()));

        String selectedItem = (String) cboProducts.getSelectedItem();
        int productId = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));
        String productName = selectedItem.substring(selectedItem.indexOf(",") + 2);

        //Valida el stock
        String selectedItemS = (String) cboStore.getSelectedItem();
        int storeIdforDB = Integer.parseInt(selectedItemS.substring(0, selectedItemS.indexOf(",")));

        StoreStock storeStock = findByProductIdAndStoreId(productId, storeIdforDB);

        if (storeStock.getQuantity() < quantity) {

            JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
            throw new Exception("El Stock del producto solicitado es menor al pedido");

        }

        //fin de validacion de stovk
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

        if (action == 1) {
            saleDetail.setId(saleDetailsListInCache.size() + 1);

            Object[] row = new Object[7];
            row[0] = saleDetail.getId();
            row[1] = saleDetail.getSale().getId();
            row[2] = saleDetail.getProduct().getId() + "," + saleDetail.getProduct().getName();
            row[3] = saleDetail.getQuantity();
            row[4] = saleDetail.getUnitPrice();
            row[5] = saleDetail.getDiscount();
            row[6] = saleDetail.getTotalPrice();
            model.addRow(row);

            saleDetail.setId(0);

            saleDetailsListInCache.add(saleDetail);

            tbSaleDetail.setModel(model);
            model.fireTableDataChanged();
        } else if (action == 0) {
            int selectedRowIndex = tbSaleDetail.getSelectedRow();
            if (selectedRowIndex >= 0 && selectedRowIndex < saleDetailsListInCache.size()) {
                saleDetailsListInCache.remove(selectedRowIndex);
                model.removeRow(selectedRowIndex);
                model.fireTableDataChanged();
            }
        }
    }

    //params for build sale details
    ArrayList<SaleDetail> saleDetailsListInCacheForUpdate = new ArrayList<>();
    DefaultTableModel modelForUpdate = new DefaultTableModel(null, cabecera);

    private void updateSale() throws Exception {

        Sale sale = new Sale();
        sale.setId(Integer.parseInt(lblId.getText().toString()));

        List<SaleDetail> saleDetailListFromDB = getSaleDetails(sale.getId());





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
                //Sale sale = new Sale();

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

    private void addOrDeleteProductsUpdate(int action) throws Exception {
        int quantity = (int) spnQuantity.getValue();
        //BigDecimal discount = BigDecimal.valueOf(Integer.parseInt(spnDiscountPdt.getValue().toString()));

        String selectedItem = (String) cboProducts.getSelectedItem();
        int productId = Integer.parseInt(selectedItem.substring(0, selectedItem.indexOf(",")));

        //Valida el stock
        String selectedItemS = (String) cboStore.getSelectedItem();
        int storeIdforDB = Integer.parseInt(selectedItemS.substring(0, selectedItemS.indexOf(",")));

        StoreStock storeStock = findByProductIdAndStoreId(productId, storeIdforDB);

        if (storeStock.getQuantity() < quantity) {

            JOptionPane.showMessageDialog(null, "El Stock del producto solicitado es menor al pedido");
            throw new Exception("El Stock del producto solicitado es menor al pedido");

        }

        //fin de validacion de stovk
        Sale sale = new Sale();
        Product product = new Product();
        product.setId(productId);

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

        if (action == 1) {
            saleDetail.setId(saleDetailsListInCache.size() + 1);

            Object[] row = new Object[7];
            row[0] = saleDetail.getId();
            row[1] = saleDetail.getSale().getId();
            row[2] = saleDetail.getProduct().getId();
            row[3] = saleDetail.getQuantity();
            row[4] = saleDetail.getUnitPrice();
            row[5] = saleDetail.getDiscount();
            row[6] = saleDetail.getTotalPrice();
            model.addRow(row);

            saleDetail.setId(0);

            saleDetailsListInCache.add(saleDetail);

            tbSaleDetail.setModel(model);
            model.fireTableDataChanged();
        } else if (action == 0) {
            int selectedRowIndex = tbSaleDetail.getSelectedRow();
            if (selectedRowIndex >= 0 && selectedRowIndex < saleDetailsListInCache.size()) {
                saleDetailsListInCache.remove(selectedRowIndex);
                model.removeRow(selectedRowIndex);
                model.fireTableDataChanged();
            }
        }
    }



    private void clearForm() {
        lblId.setText("");
        cboCustomer.setSelectedIndex(0);
        cboStore.setSelectedIndex(0);
        cboProducts.setSelectedIndex(0);
        spnQuantity.setValue(0);
        clearProducts();

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
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboProducts;
    private javax.swing.JComboBox<String> cboStore;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario3;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tbSale;
    private javax.swing.JTable tbSaleDetail;
    // End of variables declaration//GEN-END:variables

}
