/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sales.system.frontend;

import com.mycompany.sales.system.frontend.config.RetrofitClient;
import com.mycompany.sales.system.frontend.config.TokenCache;
import com.mycompany.sales.system.frontend.config.UserCache;
import com.mycompany.sales.system.frontend.model.UserSystem;
import com.mycompany.sales.system.frontend.restclient.UserService;
import com.mycompany.sales.system.frontend.view.CustomerView;
import com.mycompany.sales.system.frontend.view.ProductCategoryView;
import com.mycompany.sales.system.frontend.view.ProductEntryWarehouseView;
import com.mycompany.sales.system.frontend.view.ProductOutStoreView;
import com.mycompany.sales.system.frontend.view.ProductView;
import com.mycompany.sales.system.frontend.view.SaleDetailView;
import com.mycompany.sales.system.frontend.view.SaleView;
import com.mycompany.sales.system.frontend.view.StoreStockView;
import com.mycompany.sales.system.frontend.view.StoreView;
import com.mycompany.sales.system.frontend.view.SupplierView;
import com.mycompany.sales.system.frontend.view.UserView;
import com.mycompany.sales.system.frontend.view.WarehouseStockView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * @author ro
 */
public class SalesSystemAdmin extends javax.swing.JFrame {

    

    String imagePath = "/images/imageBack.jpg";
    BackgroundDesktopPane desktopPane = new BackgroundDesktopPane(imagePath);

    /**
     * Creates new form NewJFrame
     */
    public SalesSystemAdmin() {

        initComponents();
        setTitle("Inversiones y Representaciones JOE Glass");
        this.setExtendedState(SalesSystemAdmin.MAXIMIZED_BOTH);
        
        
        String iconPath = "/images/option.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
        int desiredWidth = 32;
        int desiredHeight = 32;
        Image resizedImage = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        

        // Set the layout of the frame to BorderLayout
        getContentPane().setLayout(new BorderLayout());
        mniHome.setIcon(resizedIcon);
        // Add the desktopPane to the center of the frame
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        manageMenuItemsEnabled(false);

    }

    private void manageMenuItemsEnabled(boolean value) {
        mniUserAdmin.setEnabled(value);
        mniLogout.setEnabled(value);
        mnuProduct.setEnabled(value);
        mniProducts.setEnabled(value);
        mnuCategory.setEnabled(value);
        mnuEntry.setEnabled(value);
        mniAddProductToInven.setEnabled(value);
        mniWerehouseStock.setEnabled(value);
        mnuOuput.setEnabled(value);
        mniOuputProductToInven.setEnabled(value);
        mniStoreStock.setEnabled(value);
        mnuSale.setEnabled(value);
        mnuMakeSale.setEnabled(value);
        mnuStockSale.setEnabled(value);
        mnuSaleDetail.setEnabled(value);
        mnuStore.setEnabled(value);
        mniStore.setEnabled(value);
        mnuSupplier.setEnabled(value);
        mniSupplier.setEnabled(value);
        mnuCustomers.setEnabled(value);
        mniCustomers.setEnabled(value);
    }

    private void manageMenuItemsEnabledStaff(boolean value) {
        mniUserAdmin.setEnabled(value);
        mniLogout.setEnabled(value);
        mnuSale.setEnabled(value);
        mnuMakeSale.setEnabled(value);
        mnuStockSale.setEnabled(value);
        mnuSaleDetail.setEnabled(value);
    }

    private void manageMenuItemsEnabledAdmin(boolean value) {
        mniUserAdmin.setEnabled(value);
        mniLogout.setEnabled(value);
        mnuProduct.setEnabled(value);
        mniProducts.setEnabled(value);
        mnuCategory.setEnabled(value);
        mnuEntry.setEnabled(value);
        mniAddProductToInven.setEnabled(value);
        mniWerehouseStock.setEnabled(value);
        mnuOuput.setEnabled(value);
        mniOuputProductToInven.setEnabled(value);
        mniStoreStock.setEnabled(value);
        mnuSale.setEnabled(value);
        mnuMakeSale.setEnabled(value);
        mnuStockSale.setEnabled(value);
        mnuSaleDetail.setEnabled(value);
        mnuStore.setEnabled(value);
        mniStore.setEnabled(value);
        mnuSupplier.setEnabled(value);
        mniSupplier.setEnabled(value);
        mnuCustomers.setEnabled(value);
        mniCustomers.setEnabled(value);
    }

    public UserSystem login(UserSystem userSystem) throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<UserSystem> call = service.login(userSystem);
        try {
            Response<UserSystem> response = call.execute();
            int codeHttp = response.code();

            if (codeHttp == HttpStatus.NOT_FOUND.value()) {
                JOptionPane.showMessageDialog(null, "Usuario o password incorrecto");
                throw new Exception("Usuario o password incorrecto");
            }

            return response.body();
        } catch (IOException e) {
            // Handle IO exception if it occurs during the API call
            throw new Exception("Error occurred during API call: " + e.getMessage());
        }
    }

    public void logout() throws Exception {
        UserService service = RetrofitClient.createService(UserService.class);
        Call<HttpStatus> call = service.logout(TokenCache.getToken());
        call.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        mniHome = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniUserAdmin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuProduct = new javax.swing.JMenuItem();
        mniProducts = new javax.swing.JMenuItem();
        mnuCategory = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuEntry = new javax.swing.JMenuItem();
        mniAddProductToInven = new javax.swing.JMenuItem();
        mniWerehouseStock = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuOuput = new javax.swing.JMenuItem();
        mniOuputProductToInven = new javax.swing.JMenuItem();
        mniStoreStock = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuSale = new javax.swing.JMenuItem();
        mnuMakeSale = new javax.swing.JMenuItem();
        mnuStockSale = new javax.swing.JMenuItem();
        mnuSaleDetail = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuStore = new javax.swing.JMenuItem();
        mniStore = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuSupplier = new javax.swing.JMenuItem();
        mniSupplier = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuCustomers = new javax.swing.JMenuItem();
        mniCustomers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuBar.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        menuBar.setPreferredSize(new java.awt.Dimension(839, 50));

        mniHome.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        mniHome.setPreferredSize(new java.awt.Dimension(60, 50));

        mniLogin.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        mniLogin.setText("Iniciar sesion");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        mniHome.add(mniLogin);

        mniUserAdmin.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniUserAdmin.setText("Administrar usuario");
        mniUserAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUserAdminActionPerformed(evt);
            }
        });
        mniHome.add(mniUserAdmin);

        mniLogout.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniLogout.setText("Cerrar sesion");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mniHome.add(mniLogout);
        mniHome.add(jSeparator1);

        mnuProduct.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuProduct.setText("Productos");
        mniHome.add(mnuProduct);

        mniProducts.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniProducts.setText("ver productos");
        mniProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProductsActionPerformed(evt);
            }
        });
        mniHome.add(mniProducts);

        mnuCategory.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mnuCategory.setText("categorias");
        mnuCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoryActionPerformed(evt);
            }
        });
        mniHome.add(mnuCategory);
        mniHome.add(jSeparator2);

        mnuEntry.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuEntry.setText("Entrada de productos");
        mniHome.add(mnuEntry);

        mniAddProductToInven.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniAddProductToInven.setText("añadir productos al almacén");
        mniAddProductToInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddProductToInvenActionPerformed(evt);
            }
        });
        mniHome.add(mniAddProductToInven);

        mniWerehouseStock.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniWerehouseStock.setText("stock en almacen");
        mniWerehouseStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniWerehouseStockActionPerformed(evt);
            }
        });
        mniHome.add(mniWerehouseStock);
        mniHome.add(jSeparator3);

        mnuOuput.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuOuput.setText("Salida de productos");
        mniHome.add(mnuOuput);

        mniOuputProductToInven.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniOuputProductToInven.setText("registrar salida de almacén");
        mniOuputProductToInven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOuputProductToInvenActionPerformed(evt);
            }
        });
        mniHome.add(mniOuputProductToInven);

        mniStoreStock.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniStoreStock.setText("stock en tienda");
        mniStoreStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniStoreStockActionPerformed(evt);
            }
        });
        mniHome.add(mniStoreStock);
        mniHome.add(jSeparator4);

        mnuSale.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuSale.setText("Ventas");
        mniHome.add(mnuSale);

        mnuMakeSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mnuMakeSale.setText("realizar venta");
        mnuMakeSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMakeSaleActionPerformed(evt);
            }
        });
        mniHome.add(mnuMakeSale);

        mnuStockSale.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mnuStockSale.setText("Stock");
        mnuStockSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuStockSaleActionPerformed(evt);
            }
        });
        mniHome.add(mnuStockSale);

        mnuSaleDetail.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        mnuSaleDetail.setText("Ver detalle de las ventas");
        mnuSaleDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaleDetailActionPerformed(evt);
            }
        });
        mniHome.add(mnuSaleDetail);
        mniHome.add(jSeparator5);

        mnuStore.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuStore.setText("Tiendas");
        mniHome.add(mnuStore);

        mniStore.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniStore.setText("ver tiendas");
        mniStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniStoreActionPerformed(evt);
            }
        });
        mniHome.add(mniStore);
        mniHome.add(jSeparator6);

        mnuSupplier.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuSupplier.setText("Proveedores");
        mniHome.add(mnuSupplier);

        mniSupplier.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniSupplier.setText("ver proveedores");
        mniSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSupplierActionPerformed(evt);
            }
        });
        mniHome.add(mniSupplier);
        mniHome.add(jSeparator7);

        mnuCustomers.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        mnuCustomers.setText("Clientes");
        mniHome.add(mnuCustomers);

        mniCustomers.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        mniCustomers.setText("ver clientes");
        mniCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCustomersActionPerformed(evt);
            }
        });
        mniHome.add(mniCustomers);

        menuBar.add(mniHome);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        try {
            logout();
            manageMenuItemsEnabled(false);
            mniLogin.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(SalesSystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_mniLogoutActionPerformed

    private void mniOuputProductToInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniOuputProductToInvenActionPerformed
        ProductOutStoreView enr = new ProductOutStoreView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniOuputProductToInvenActionPerformed

    private void mniProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProductsActionPerformed
        ProductView enr = new ProductView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniProductsActionPerformed

    private void mnuCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoryActionPerformed
        ProductCategoryView enr = new ProductCategoryView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mnuCategoryActionPerformed

    private void mniAddProductToInvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddProductToInvenActionPerformed
        ProductEntryWarehouseView enr = new ProductEntryWarehouseView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniAddProductToInvenActionPerformed

    private void mniStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniStoreActionPerformed
        StoreView enr = new StoreView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniStoreActionPerformed

    private void mniSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSupplierActionPerformed
        SupplierView enr = new SupplierView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniSupplierActionPerformed

    private void mniWerehouseStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniWerehouseStockActionPerformed
        WarehouseStockView enr = new WarehouseStockView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniWerehouseStockActionPerformed

    private void mniStoreStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniStoreStockActionPerformed
        StoreStockView enr = new StoreStockView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniStoreStockActionPerformed

    private void mnuMakeSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMakeSaleActionPerformed
        SaleView enr = new SaleView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mnuMakeSaleActionPerformed

    private void mniCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCustomersActionPerformed
        CustomerView enr = new CustomerView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniCustomersActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void mnuStockSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuStockSaleActionPerformed
        StoreStockView enr = new StoreStockView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mnuStockSaleActionPerformed

    private void mniUserAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUserAdminActionPerformed
        UserView enr = new UserView();

        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mniUserAdminActionPerformed

    private void mnuSaleDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaleDetailActionPerformed
        SaleDetailView enr = new SaleDetailView();
        showInternalFrame(enr, desktopPane);
    }//GEN-LAST:event_mnuSaleDetailActionPerformed

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] fields = {"Username:", usernameField, "Password:", passwordField};

        int option = JOptionPane.showOptionDialog(null, fields, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                isValidLogin(username, password);
            } catch (Exception ex) {
                Logger.getLogger(SalesSystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_mniLoginActionPerformed

    private void isValidLogin(String username, String password) throws Exception {

        UserSystem userSystem = new UserSystem();
        userSystem.setUserName(username);
        userSystem.setUserPassword(String.valueOf(password));

        try {
            UserSystem systemDB = login(userSystem);

            if (systemDB != null) {
                //save token in cache         
                String token = systemDB.getToken();
                TokenCache tokenCache = new TokenCache();
                tokenCache.saveToken(token);

                UserCache userCache = new UserCache();
                userCache.saveUser(systemDB);

                if (systemDB.getTypeUser().equals("staff")) {

                    mniLogin.setEnabled(false);
                    manageMenuItemsEnabledStaff(true);
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);

                } else if (systemDB.getTypeUser().equals("admin")) {

                    mniLogin.setEnabled(false);
                    manageMenuItemsEnabledAdmin(true);
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error.", "Login", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cerrar() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "En realidad desea cerrar la aplicacion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            try {
                logout();
                manageMenuItemsEnabled(false);
                mniLogin.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(SalesSystemAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        } else {
        }
    }

    public void showInternalFrame(JInternalFrame internalFrame, JDesktopPane desktopPane) {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        boolean isOpen = false;
        JInternalFrame existingFrame = null;

        // Verificar si el JInternalFrame ya está abierto
        for (JInternalFrame frame : frames) {
            if (frame.getClass().equals(internalFrame.getClass())) {
                isOpen = true;
                existingFrame = frame;
                break;
            }
        }

        if (isOpen) {
            // El JInternalFrame ya está abierto, lo quitamos antes de mostrarlo nuevamente
            desktopPane.remove(existingFrame);
            existingFrame.dispose();
        }

        // Agregar el JInternalFrame al desktopPane
        desktopPane.add(internalFrame);

        // Mostrar el JInternalFrame centrado en el desktopPane
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = internalFrame.getSize();
        internalFrame.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);

        // Mostrar el JInternalFrame
        internalFrame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mniAddProductToInven;
    private javax.swing.JMenuItem mniCustomers;
    private javax.swing.JMenu mniHome;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniOuputProductToInven;
    private javax.swing.JMenuItem mniProducts;
    private javax.swing.JMenuItem mniStore;
    private javax.swing.JMenuItem mniStoreStock;
    private javax.swing.JMenuItem mniSupplier;
    private javax.swing.JMenuItem mniUserAdmin;
    private javax.swing.JMenuItem mniWerehouseStock;
    private javax.swing.JMenuItem mnuCategory;
    private javax.swing.JMenuItem mnuCustomers;
    private javax.swing.JMenuItem mnuEntry;
    private javax.swing.JMenuItem mnuMakeSale;
    private javax.swing.JMenuItem mnuOuput;
    private javax.swing.JMenuItem mnuProduct;
    private javax.swing.JMenuItem mnuSale;
    private javax.swing.JMenuItem mnuSaleDetail;
    private javax.swing.JMenuItem mnuStockSale;
    private javax.swing.JMenuItem mnuStore;
    private javax.swing.JMenuItem mnuSupplier;
    // End of variables declaration//GEN-END:variables
}
