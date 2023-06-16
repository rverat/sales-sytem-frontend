/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JTable;

/**
 *
 * @author ro
 */
public class ExportToPDF {
    
    public void guardarTablaEnPDF(JTable table) {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showSaveDialog(null);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String nombreArchivo = selectedFile.getAbsolutePath();
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo + ".pdf"));
            document.open();
    
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            
            // Agregar encabezados de columna al PDF
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
            }
    
            // Agregar filas al PDF
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
                }
            }
    
            document.add(pdfTable);
            document.close();
    
            System.out.println("Archivo PDF creado exitosamente.");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

    
}
