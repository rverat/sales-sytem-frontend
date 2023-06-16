/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.math.BigDecimal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ro
 */
public class PaintRowsTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);

        String valStr = table.getValueAt(row, 10).toString();

        BigDecimal numeroDecimal = new BigDecimal(valStr);
        
        Color darkGreen = new Color(0, 100, 0);

        if (numeroDecimal.compareTo(BigDecimal.ZERO) != 0) {
          setForeground(darkGreen);
          Font font = getFont();
          setFont(font.deriveFont(font.getStyle() | Font.BOLD));
          
        } else {
            // Reset the foreground color to the default
            setForeground(table.getForeground());
        }

        return this;

    }
}
