/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sales.sytem.frontend.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ro
 */
public class UtilSS {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static void isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            showErrorMessage("Correo invalido ");
            return;

        }
    }

    public static void isValidInteger(String number, String name) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            showErrorMessage(String.format("El %d debe ser un numero entero", name));
            return;
        }
    }

    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
