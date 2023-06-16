/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ro
 */
public class ExportToExel {
    
    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {   
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                } 
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                            
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(true);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
    
    public void exportarExcel2(JTable t) throws IOException {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xlsx");
    chooser.setFileFilter(filter);
    chooser.setDialogTitle("Guardar archivo");
    chooser.setAcceptAllFileFilterUsed(false);
    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        String ruta = chooser.getSelectedFile().toString().concat(".xlsx");
        try {
            File archivoXLSX = new File(ruta);
            if (archivoXLSX.exists()) {
                archivoXLSX.delete();
            }
            archivoXLSX.createNewFile();
            Workbook libro = new XSSFWorkbook();

            Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
            hoja.setDisplayGridlines(true);

            // Set column widths based on table column widths
            for (int columnIndex = 0; columnIndex < t.getColumnCount(); columnIndex++) {
                int tableColumnWidth = t.getColumnModel().getColumn(columnIndex).getWidth();
                hoja.setColumnWidth(columnIndex, tableColumnWidth);
            }

            // Create a cell style for the green font
            CellStyle greenCellStyle = libro.createCellStyle();
            Font font = libro.createFont();
            font.setColor(IndexedColors.GREEN.getIndex());
            greenCellStyle.setFont(font);

            for (int f = 0; f < t.getRowCount(); f++) {
                Row fila = hoja.createRow(f);
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = fila.createCell(c);
                    if (f == 0) {
                        celda.setCellValue(t.getColumnName(c));
                    }
                    Object value = t.getValueAt(f, c);
                    if (value instanceof Double) {
                        celda.setCellValue((Double) value);
                    } else if (value instanceof Float) {
                        celda.setCellValue((Float) value);
                    } else if (value instanceof Integer) {
                        celda.setCellValue((Integer) value);
                    } else if (value instanceof BigDecimal) {
                        BigDecimal priceValue = (BigDecimal) value;
                        celda.setCellValue(priceValue.doubleValue());
                        if (priceValue.compareTo(BigDecimal.ZERO) != 0) {
                            celda.setCellStyle(greenCellStyle);
                        }
                    } else {
                        celda.setCellValue(value != null ? value.toString() : "");
                    }
                }
            }

            FileOutputStream archivo = new FileOutputStream(archivoXLSX);
            libro.write(archivo);
            archivo.close();
            Desktop.getDesktop().open(archivoXLSX);
        } catch (IOException | NumberFormatException e) {
            throw e;
        }
    }
}
}
