/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.WarehouseStock;
import com.mycompany.sales.sytem.frontend.restclient.WarehouseStockService;
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
public class WarehouseStockView extends javax.swing.JInternalFrame {

    /**
     * Creates new form WarehouseStockView
     */
    public WarehouseStockView() {
        initComponents();
        listWarehouseStock();
    }

    public List<WarehouseStock> listAll() throws Exception {
        WarehouseStockService service = RetrofitClient.createService(WarehouseStockService.class);
        Call<List<WarehouseStock>> call = service.findAll("");
        Response<List<WarehouseStock>> response = call.execute();
        return response.body();
    }

    /*public void save(WarehouseStock warehouseStock) throws Exception {
        WarehouseStockService service = RetrofitClient.createService(WarehouseStockService.class);
        Call<HttpStatus> call = service.save(warehouseStock);
        call.execute();
    }

    public void update(WarehouseStock warehouseStock) throws Exception {
        WarehouseStockService service = RetrofitClient.createService(WarehouseStockService.class);
        Call<HttpStatus> call = service.update(warehouseStock);
        call.execute();
    }

    public void delete(int id) throws Exception {
        WarehouseStockService service = RetrofitClient.createService(WarehouseStockService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }*/
    
    public void listWarehouseStock() {
        List<WarehouseStock> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(StoreStockView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Producto", "Cantidad"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[3];
            for (WarehouseStock response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getProduct().getName();
                registros[2] = String.valueOf(response.getQuantity());

                table.addRow(registros);
            }
            tbWarehouseStock.setModel(table);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tbWarehouseStock = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
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
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDescription1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        cboCategory1 = new javax.swing.JComboBox<>();
        lblId1 = new javax.swing.JTextField();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProduct1 = new javax.swing.JTable();
        btnDelete1 = new javax.swing.JButton();
        btnModify1 = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtSearch1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblUsuario2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaDescription2 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        cboCategory2 = new javax.swing.JComboBox<>();
        lblId2 = new javax.swing.JTextField();
        jSpinner3 = new javax.swing.JSpinner();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbProduct2 = new javax.swing.JTable();
        btnDelete2 = new javax.swing.JButton();
        btnModify2 = new javax.swing.JButton();
        btnAdd2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtSearch2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombre3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaDescription3 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        cboCategory3 = new javax.swing.JComboBox<>();
        lblId3 = new javax.swing.JTextField();
        jSpinner4 = new javax.swing.JSpinner();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbProduct3 = new javax.swing.JTable();
        btnDelete3 = new javax.swing.JButton();
        btnModify3 = new javax.swing.JButton();
        btnAdd3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtSearch3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtSearch4 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setTitle("Stock en Almacen");

        tbWarehouseStock.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tbWarehouseStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbWarehouseStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbWarehouseStockMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbWarehouseStock);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 280, -1));

        lblId.setEditable(false);
        jPanel2.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, -1));

        jInternalFrame1.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 888, 156));

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

        jInternalFrame1.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 215, 890, 294));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        btnModify.setText("Modificar");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jButton1.setText("Limpiar");
        jInternalFrame1.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 290, -1));

        jLabel4.setText("Buscar:");
        jInternalFrame1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, 20));

        jInternalFrame2.setClosable(true);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Id:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel8.setText("Precio");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel9.setText("Categoria:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 70, -1));
        jPanel3.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        jLabel12.setText("Nombre:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel3.add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        txaDescription1.setColumns(20);
        txaDescription1.setRows(5);
        jScrollPane3.setViewportView(txaDescription1);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 280, 70));

        jLabel13.setText("Descripción:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        cboCategory1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cboCategory1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 280, -1));

        lblId1.setEditable(false);
        jPanel3.add(lblId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel3.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, -1));

        jInternalFrame2.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 888, 156));

        tbProduct1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduct1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProduct1);

        jInternalFrame2.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 215, 890, 294));

        btnDelete1.setText("Eliminar");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        btnModify1.setText("Modificar");
        btnModify1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModify1ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(btnModify1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnAdd1.setText("Agregar");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jButton2.setText("Limpiar");
        jInternalFrame2.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 290, -1));

        jLabel14.setText("Buscar:");
        jInternalFrame2.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, 20));

        jInternalFrame3.setClosable(true);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Id:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel16.setText("Precio");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel17.setText("Categoria:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 70, -1));
        jPanel4.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        jLabel18.setText("Nombre:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel4.add(lblUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        txaDescription2.setColumns(20);
        txaDescription2.setRows(5);
        jScrollPane6.setViewportView(txaDescription2);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 280, 70));

        jLabel19.setText("Descripción:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        cboCategory2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cboCategory2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 280, -1));

        lblId2.setEditable(false);
        jPanel4.add(lblId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel4.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, -1));

        jInternalFrame3.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 888, 156));

        tbProduct2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduct2MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbProduct2);

        jInternalFrame3.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 215, 890, 294));

        btnDelete2.setText("Eliminar");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(btnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        btnModify2.setText("Modificar");
        btnModify2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModify2ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(btnModify2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnAdd2.setText("Agregar");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(btnAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jButton3.setText("Limpiar");
        jInternalFrame3.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        txtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch2ActionPerformed(evt);
            }
        });
        jInternalFrame3.getContentPane().add(txtSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 290, -1));

        jLabel20.setText("Buscar:");
        jInternalFrame3.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, 20));

        jInternalFrame4.setClosable(true);
        jInternalFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Id:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel22.setText("Precio");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel23.setText("Categoria:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 70, -1));
        jPanel6.add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        jLabel24.setText("Nombre:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        txaDescription3.setColumns(20);
        txaDescription3.setRows(5);
        jScrollPane8.setViewportView(txaDescription3);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 280, 70));

        jLabel25.setText("Descripción:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        cboCategory3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cboCategory3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 280, -1));

        lblId3.setEditable(false);
        jPanel6.add(lblId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel6.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 150, -1));

        jInternalFrame4.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 888, 156));

        tbProduct3.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProduct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduct3MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbProduct3);

        jInternalFrame4.getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 215, 890, 294));

        btnDelete3.setText("Eliminar");
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });
        jInternalFrame4.getContentPane().add(btnDelete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        btnModify3.setText("Modificar");
        btnModify3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModify3ActionPerformed(evt);
            }
        });
        jInternalFrame4.getContentPane().add(btnModify3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        btnAdd3.setText("Agregar");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });
        jInternalFrame4.getContentPane().add(btnAdd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jButton4.setText("Limpiar");
        jInternalFrame4.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        txtSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch3ActionPerformed(evt);
            }
        });
        jInternalFrame4.getContentPane().add(txtSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 290, -1));

        jLabel26.setText("Buscar:");
        jInternalFrame4.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, 20));

        txtSearch4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch4ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel27.setText("Buscar:");

        btnRefresh.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnRefresh.setText("Refrescar Stock");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(txtSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbWarehouseStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbWarehouseStockMouseClicked

    }//GEN-LAST:event_tbWarehouseStockMouseClicked

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked

    }//GEN-LAST:event_tbProductMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tbProduct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduct1MouseClicked
       
    }//GEN-LAST:event_tbProduct1MouseClicked

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnModify1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModify1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModify1ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void tbProduct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduct2MouseClicked
       
    }//GEN-LAST:event_tbProduct2MouseClicked

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnModify2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModify2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModify2ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void tbProduct3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduct3MouseClicked

    }//GEN-LAST:event_tbProduct3MouseClicked

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnModify3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModify3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModify3ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void txtSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch3ActionPerformed

    private void txtSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch4ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        listWarehouseStock();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnModify1;
    private javax.swing.JButton btnModify2;
    private javax.swing.JButton btnModify3;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboCategory1;
    private javax.swing.JComboBox<String> cboCategory2;
    private javax.swing.JComboBox<String> cboCategory3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTextField lblId;
    private javax.swing.JTextField lblId1;
    private javax.swing.JTextField lblId2;
    private javax.swing.JTextField lblId3;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JLabel lblUsuario1;
    public javax.swing.JLabel lblUsuario2;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTable tbProduct1;
    private javax.swing.JTable tbProduct2;
    private javax.swing.JTable tbProduct3;
    private javax.swing.JTable tbWarehouseStock;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextArea txaDescription1;
    private javax.swing.JTextArea txaDescription2;
    private javax.swing.JTextArea txaDescription3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch4;
    // End of variables declaration//GEN-END:variables
}
