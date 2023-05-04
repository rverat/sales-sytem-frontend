/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.view;

import com.mycompany.sales.sytem.frontend.config.RetrofitClient;
import com.mycompany.sales.sytem.frontend.model.Supplier;
import com.mycompany.sales.sytem.frontend.restclient.SupplierService;
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
public class SupplierView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Supplier
     */
    public SupplierView() {
        initComponents();
        listSupplier();
    }

    public List<Supplier> listAll() throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<List<Supplier>> call = service.getAll();
        Response<List<Supplier>> response = call.execute();
        return response.body();
    }

    public void save(Supplier supplier) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.save(supplier);
        call.execute();
    }

    public void update(Supplier supplier) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.update(supplier);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SupplierService service = RetrofitClient.createService(SupplierService.class);
        Call<HttpStatus> call = service.delete(id);
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSupplier = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuario4 = new javax.swing.JLabel();
        lblId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Proveedor");

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

        tbSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSupplier);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Id:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel12.setText("PhoneNumber:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel13.setText("Nombre:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel6.add(lblUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        lblId.setEditable(false);
        jPanel6.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));
        jPanel6.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));
        jPanel6.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(btnAdd)
                .addGap(16, 16, 16)
                .addComponent(btnModify)
                .addGap(19, 19, 19)
                .addComponent(btnDelete)
                .addGap(16, 16, 16)
                .addComponent(btnLimpiar))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete)
                    .addComponent(btnLimpiar))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        saveSupplier();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        updateSupplier();
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSupplier();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSupplierMouseClicked
        tbSupplierMouseClick(evt);
    }//GEN-LAST:event_tbSupplierMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void listSupplier() {
        List<Supplier> lista = new ArrayList<>();

        try {
            lista = listAll();
        } catch (Exception ex) {
            Logger.getLogger(SupplierView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista != null) {
            String cabecera[] = {"Id", "Nombre", "Teléfono"};
            DefaultTableModel table = new DefaultTableModel(null, cabecera);
            String[] registros = new String[3];
            for (Supplier response : lista) {
                registros[0] = String.valueOf(response.getId());
                registros[1] = response.getName();
                registros[2] = response.getPhoneNumber();

                table.addRow(registros);
            }
            tbSupplier.setModel(table);

        }
    }

    private void saveSupplier() throws HeadlessException {
        try {

            Supplier supplier = new Supplier();

            supplier.setId(0);
            supplier.setName(txtNombre.getText());
            supplier.setPhoneNumber(txtTelefono.getText());

            save(supplier);
            JOptionPane.showMessageDialog(null, "Registrado");
            listSupplier();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private void updateSupplier() throws HeadlessException {
        try {

            Supplier supplier = new Supplier();

            supplier.setId(Integer.parseInt(lblId.getText()));
            supplier.setName(txtNombre.getText());
            supplier.setPhoneNumber(txtTelefono.getText());

            update(supplier);
            JOptionPane.showMessageDialog(null, "Actualizado");
            listSupplier();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
    }

    private boolean deleteSupplier() throws NumberFormatException, HeadlessException {
        if (lblId.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar el registro a Eliminar", "Atentamente el Sistema", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        int id = Integer.parseInt(lblId.getText().trim());
        try {
            delete(id);
        } catch (Exception ex) {
            Logger.getLogger(SupplierView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Eliminado");
        listSupplier();
        clear();
        return false;
    }

    private void clear() {
        lblId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
    }

    private void tbSupplierMouseClick(MouseEvent evt) {
        int fila = tbSupplier.getSelectedRow();
        String Cod = tbSupplier.getValueAt(fila, 0).toString();

        {
            int seleccion = tbSupplier.rowAtPoint(evt.getPoint());
            lblId.setText(String.valueOf(tbSupplier.getValueAt(seleccion, 0)));
            txtNombre.setText(String.valueOf(tbSupplier.getValueAt(seleccion, 1)));
            txtTelefono.setText(String.valueOf(tbSupplier.getValueAt(seleccion, 2)));

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModify;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField lblId;
    public javax.swing.JLabel lblUsuario4;
    private javax.swing.JTable tbSupplier;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
