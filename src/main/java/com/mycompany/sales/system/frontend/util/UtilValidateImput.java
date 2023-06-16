/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.system.frontend.util;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ro
 */
public class UtilValidateImput {

    public static void configureSpinner(JSpinner snpPrice) {
        SpinnerNumberModel priceSpinnerModel = new SpinnerNumberModel(0d, 0d, null, 0.01d);
        snpPrice.setModel(priceSpinnerModel);

        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(snpPrice, "#,##0.00");
        JFormattedTextField textField = editor.getTextField();
        textField.setColumns(12);

        // Add focus listener to validate the input when losing focus
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    validateSpinnerInput(snpPrice);
                } catch (Exception ex) {
                    Logger.getLogger(UtilValidateImput.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        snpPrice.setEditor(editor);
    }

    private static void validateSpinnerInput(JSpinner snpPrice) throws Exception {
        JFormattedTextField textField = ((JSpinner.DefaultEditor) snpPrice.getEditor()).getTextField();
        String inputValue = textField.getText();

        try {
            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
            decimalFormat.setParseBigDecimal(true);
            BigDecimal value = (BigDecimal) decimalFormat.parse(inputValue);
            snpPrice.setValue(value);
        } catch (ParseException e) {
            textField.requestFocus();
            textField.selectAll();
            
        }
    }

    public static void validateString(String input, String nameComponet) {
        if (input == null || input.isEmpty()) {
            showErrorMessage(String.format("La entrada para el campo %s no puede ser nula o vacía.", nameComponet));
            return;
        }

        if (!input.matches("[a-zA-Z0-9\\s-]+")) {
            showErrorMessage("Entrada inválida para el campo " + nameComponet + ". Solo se permiten letras, números, espacios y guiones.");
            return;
        }
    }

    public static void validateSelectedJCombobox(JComboBox jComboBox, String nameComponet) {

        if (jComboBox.getSelectedIndex() < 0) {
            showErrorMessage("Seleccione la " + nameComponet);
            return;
        }
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
