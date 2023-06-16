/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend.view;

import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.model.SaleDetail;
import com.mycompany.sales.system.frontend.model.reports.SaleReport;
import com.mycompany.sales.system.frontend.restclient.SaleDetailService;
import com.mycompany.sales.system.frontend.util.ExportToExel;
import com.mycompany.sales.system.frontend.util.ExportToPDF;
import com.mycompany.sales.system.frontend.util.PaintRowsTable;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
public class SaleDetailView extends javax.swing.JInternalFrame {

    /**
     * Creates new form SaleDetailView
     */
    public SaleDetailView() {
        initComponents();
       

        try {
            listSalesDetails();
        } catch (Exception ex) {
            Logger.getLogger(SaleDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
        PaintRowsTable prt = new PaintRowsTable();
        tbSaleDetails.setDefaultRenderer(Object.class, prt);
        tablaAjustes();
    }

    private void tablaAjustes() {
        tbSaleDetails.setAutoResizeMode(tbSaleDetails.AUTO_RESIZE_OFF);
        tbSaleDetails.doLayout();

        TableColumnModel columnModel = tbSaleDetails.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(90);
        columnModel.getColumn(1).setPreferredWidth(90);
        columnModel.getColumn(2).setPreferredWidth(90);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(300);
        columnModel.getColumn(5).setPreferredWidth(90);
        columnModel.getColumn(6).setPreferredWidth(90);
        columnModel.getColumn(7).setPreferredWidth(90);
        columnModel.getColumn(8).setPreferredWidth(90);
        columnModel.getColumn(9).setPreferredWidth(90);
        columnModel.getColumn(10).setPreferredWidth(90);
        columnModel.getColumn(11).setPreferredWidth(90);
        columnModel.getColumn(12).setPreferredWidth(90);
        columnModel.getColumn(13).setPreferredWidth(90);
        columnModel.getColumn(14).setPreferredWidth(120);
        columnModel.getColumn(15).setPreferredWidth(90);

    }

    public List<SaleDetail> listAll() throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleDetail>> call = service.findAll(TokenCache.getToken());
        Response<List<SaleDetail>> response = call.execute();
        return response.body();
    }

    public void save(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.save(TokenCache.getToken(), saleDetail);
        call.execute();
    }

    public void update(SaleDetail saleDetail) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.update(TokenCache.getToken(), saleDetail);
        call.execute();
    }

    public void delete(int id) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<HttpStatus> call = service.delete(TokenCache.getToken(), id);
        call.execute();
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

    public List<SaleReport> getSaleReportAll() throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleReport>> call = service.getSaleReportAll(TokenCache.getToken());
        Response<List<SaleReport>> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en esta venta");
            throw new Exception("No hay producto registrado en esta venta");
        }
        return response.body();
    }

    public List<SaleReport> getSaleReportByDate(String startDate, String endDate) throws Exception {
        SaleDetailService service = RetrofitClient.createService(SaleDetailService.class);
        Call<List<SaleReport>> call = service.getSaleReportByDate(TokenCache.getToken(), startDate, endDate);
        Response<List<SaleReport>> response = call.execute();

        int codeHttp = response.code();

        if (HttpStatus.valueOf(codeHttp) == HttpStatus.NOT_FOUND) {

            JOptionPane.showMessageDialog(null, "No hay producto registrado en esta venta");
            throw new Exception("No hay producto registrado en esta venta");
        }
        return response.body();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lblUsuario3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ftxtStart = new javax.swing.JFormattedTextField();
        ftxtEnd = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        btnReportByDate = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSaleDetails = new javax.swing.JTable();
        btnToPDF = new javax.swing.JButton();
        btnToExel = new javax.swing.JButton();

        setClosable(true);
        setTitle("Detalle de la Venta");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 18))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(lblUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, 20));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel10.setText("Buscar:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtNombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel5.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 240, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Fecha inicio:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        ftxtStart.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftxtStart.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel5.add(ftxtStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 190, -1));

        ftxtEnd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftxtEnd.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel5.add(ftxtEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 190, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Fecha fin:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, -1, -1));

        btnReportByDate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnReportByDate.setText("Buscar por fecha");
        btnReportByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportByDateActionPerformed(evt);
            }
        });
        jPanel5.add(btnReportByDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 40, -1, -1));

        tbSaleDetails.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        tbSaleDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16"
            }
        ));
        tbSaleDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleDetailsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSaleDetails);

        btnToPDF.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnToPDF.setText("Generar Pdf");
        btnToPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToPDFActionPerformed(evt);
            }
        });

        btnToExel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnToExel.setText("Generar Exel");
        btnToExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToExelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnToExel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnToPDF))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToPDF)
                    .addComponent(btnToExel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSaleDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleDetailsMouseClicked
        int fila = tbSaleDetails.getSelectedRow();
        String Cod = tbSaleDetails.getValueAt(fila, 0).toString();

        {
            int seleccion = tbSaleDetails.rowAtPoint(evt.getPoint());

        }
    }//GEN-LAST:event_tbSaleDetailsMouseClicked

    private void btnToExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToExelActionPerformed
        ExportToExel export = new ExportToExel();
        try {
            export.exportarExcel(tbSaleDetails);
        } catch (IOException ex) {
            Logger.getLogger(SaleDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnToExelActionPerformed

    private void btnToPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToPDFActionPerformed
        ExportToPDF pdf = new ExportToPDF();
        pdf.guardarTablaEnPDF(tbSaleDetails);

    }//GEN-LAST:event_btnToPDFActionPerformed

    private void btnReportByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportByDateActionPerformed

        try {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(ftxtStart.getText(), fmt);
            LocalDate endDate = LocalDate.parse(ftxtEnd.getText(), fmt);

            String start = startDate.toString();
            String end = endDate.toString();

            ArrayList<SaleReport> saleDetailsListInCache = new ArrayList<>();
            String cabecera[] = {"Numero", "Id Venta", "Id Detalle", "Id Producto", "Nombre Producto", "Cantidad", "Precio unitario",
                "Precio total", " Producto Cancelado", "Descuento", "Precio de Venta", "Fecha", "Cancelado"};
            DefaultTableModel model = new DefaultTableModel(null, cabecera);

            List<SaleReport> saleDetailList = getSaleReportByDate(start, end);

            saleDetailsListInCache.clear();
            model.fireTableDataChanged();

            buildModel(saleDetailList, saleDetailsListInCache, model);

        } catch (Exception ex) {
            Logger.getLogger(SaleDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportByDateActionPerformed

    private void formatDate() {

        try {
            // Crear un MaskFormatter con el formato de fecha deseado
            MaskFormatter formatter = new MaskFormatter("####/##/##");
            formatter.setPlaceholderCharacter('_');

            // Crear un JFormattedTextField con el MaskFormatter
            JFormattedTextField formattedTextField = new JFormattedTextField(formatter);

            // Establecer un SimpleDateFormat para el JFormattedTextField
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            formattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.DateFormatter(dateFormat)));

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

    private void listSalesDetails() throws Exception {

        ArrayList<SaleReport> saleDetailsListInCache = new ArrayList<>();
        String cabecera[] = {"Numero", "Id Venta", "Id Detalle", "Id Producto", "Nombre Producto", "Cantidad", "Precio unitario",
            "Precio total", " Producto Cancelado", "Descuento", "Precio de Venta", "Fecha", "Id Usuario", "Id Customer", "Id Tienda", "Cancelado"};
        DefaultTableModel model = new DefaultTableModel(null, cabecera);

        List<SaleReport> saleDetailList = getSaleReportAll();
        saleDetailsListInCache.clear();
        model.fireTableDataChanged();

        buildModel(saleDetailList, saleDetailsListInCache, model);

    }

    private void buildModel(List<SaleReport> saleDetailList, ArrayList<SaleReport> saleDetailsListInCache, DefaultTableModel model) {
        if (saleDetailList != null) {

            String[] registros = new String[16];
            for (SaleReport response : saleDetailList) {
                registros[0] = String.valueOf(response.getRowNumber());
                registros[1] = String.valueOf(response.getIdSale());
                registros[2] = String.valueOf(response.getIdSaleDetail());
                registros[3] = String.valueOf(response.getIdProduct());
                registros[4] = String.valueOf(response.getProductName());
                registros[5] = String.valueOf(response.getQuantity());
                registros[6] = String.valueOf(response.getUnitPrice());
                registros[7] = String.valueOf(response.getTotalPriceDetail());
                registros[8] = String.valueOf(response.getCancelSaleDetail());
                registros[9] = String.valueOf(response.getDiscount());
                registros[10] = String.valueOf(response.getFinalPrice());
                registros[11] = String.valueOf(response.getSaleDate());
                registros[12] = String.valueOf(response.getIdUser());
                registros[13] = String.valueOf(response.getIdCustomer());
                registros[14] = String.valueOf(response.getIdStore());
                registros[15] = String.valueOf(response.getCancelSale());
                saleDetailsListInCache.add(response);
                model.addRow(registros);
            }
            tbSaleDetails.setModel(model);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportByDate;
    private javax.swing.JButton btnToExel;
    private javax.swing.JButton btnToPDF;
    private javax.swing.JFormattedTextField ftxtEnd;
    private javax.swing.JFormattedTextField ftxtStart;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JLabel lblUsuario3;
    private javax.swing.JTable tbSaleDetails;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
