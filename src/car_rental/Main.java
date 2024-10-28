/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car_rental;

import car_rental.Vehicles;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 */
public class Main extends javax.swing.JFrame {

    private User_Session session;
    private Rentals newBooking;
    private String vehicle_IDSelected;
    private String vehicle_nameSelected;

    /**
     * Creates new form Main
     */
    public Main(User_Session session) {
        this.session = session;
        initComponents();
        setLocationRelativeTo(null);

        if (session.isAdmin()) {
            JOptionPane.showMessageDialog(this, "Login Sucessful.");
        } else {
            JOptionPane.showMessageDialog(this, "Login Sucessful");
            admin_panel.setVisible(false);
        }

        Vehicles vehicleData = new Vehicles();
        vehicleData.displayVehicles(jTable1); // Assuming jTable1 is the JTable's variable name

        cb_Payment.addItem("Cash");
        cb_Payment.addItem("Gcash");
        cb_Payment.addItem("Bank Transfer");

        tb_Rate.setEditable(false);
        tb_Total.setEditable(false);
        btn_Confirm.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tb_Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tb_Duration = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tb_Rate = new javax.swing.JTextField();
        btn_Confirm = new javax.swing.JButton();
        tb_Total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_Payment = new javax.swing.JComboBox<>();
        btn_Calculate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Bookings = new javax.swing.JButton();
        admin_panel = new javax.swing.JPanel();
        btn_users = new javax.swing.JButton();
        btn_vehicles = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JToggleButton();
        cb_filterDays = new javax.swing.JComboBox<>();
        btn_reports = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setLocation(new java.awt.Point(400, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Booking Fillup Form:");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle_ID", "Status", "Make", "Model", "Year", "Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tb_Name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Customer Full Name:");

        tb_Duration.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Days Duration:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Per Day Rate:");

        tb_Rate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_Confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Confirm.setText("Confirm Booking");
        btn_Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfirmActionPerformed(evt);
            }
        });

        tb_Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Total Due:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Method of Payment");

        btn_Calculate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Calculate.setText("Calculate");
        btn_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(tb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tb_Rate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tb_Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tb_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_Duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_Rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_Calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Available Cars");

        btn_Bookings.setBackground(new java.awt.Color(102, 255, 102));
        btn_Bookings.setText("Bookings");
        btn_Bookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BookingsActionPerformed(evt);
            }
        });

        admin_panel.setBackground(new java.awt.Color(204, 255, 204));

        btn_users.setBackground(new java.awt.Color(102, 255, 102));
        btn_users.setText("Users");
        btn_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usersActionPerformed(evt);
            }
        });

        btn_vehicles.setBackground(new java.awt.Color(102, 255, 102));
        btn_vehicles.setText("Vehicles");
        btn_vehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vehiclesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Admin Panel");

        javax.swing.GroupLayout admin_panelLayout = new javax.swing.GroupLayout(admin_panel);
        admin_panel.setLayout(admin_panelLayout);
        admin_panelLayout.setHorizontalGroup(
            admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panelLayout.createSequentialGroup()
                .addGroup(admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(admin_panelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_users, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(admin_panelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel8)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        admin_panelLayout.setVerticalGroup(
            admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, admin_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_users)
                    .addComponent(btn_vehicles))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        cb_filterDays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "This Week", "Next Week", "Next Month" }));
        cb_filterDays.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_filterDaysItemStateChanged(evt);
            }
        });

        btn_reports.setBackground(new java.awt.Color(102, 255, 102));
        btn_reports.setText("Generate Reports");
        btn_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_filterDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btn_Bookings, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_reports, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(admin_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Bookings, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reports, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addComponent(admin_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_filterDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();

        // Get the ID from the first column (column index 0)
        Object id = jTable1.getValueAt(selectedRow, 0);// Assuming ID is in the first column
        Object rate = jTable1.getValueAt(selectedRow, 5);
        Object status = jTable1.getValueAt(selectedRow, 1);
        Object vehicle_name = jTable1.getValueAt(selectedRow, 2).toString() + " " + jTable1.getValueAt(selectedRow, 3);

        vehicle_IDSelected = id.toString();
        vehicle_nameSelected = vehicle_name.toString();

        System.out.println("Selected ID: " + vehicle_IDSelected);
        System.out.println("Car: " + vehicle_name);
        System.out.println("Availability: " + status);

        if (status.equals("Available")) {
            tb_Rate.setText(rate.toString());
        } else {
            tb_Rate.setText("");
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmActionPerformed
        // TODO add your handling code here:
        Rentals newBooking = new Rentals();
        Vehicles updateVehicle = new Vehicles();
        String vehicle_id = vehicle_IDSelected;
        String vehicle_name = vehicle_nameSelected;
        String cust_name = tb_Name.getText();
        String days = tb_Duration.getText();
        String amount = tb_Total.getText();
        String paymentMethod = (String) cb_Payment.getSelectedItem();

        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");
        LocalDateTime today = LocalDateTime.now();
        String date = today.format(formatter);

        // Call the insertData method from DatabaseHandler
        if (newBooking.insertData(vehicle_id, vehicle_name, cust_name, days, amount, date, paymentMethod)) {
            updateVehicle.bookVehicle(Integer.parseInt(vehicle_id));
            JOptionPane.showMessageDialog(Main.this, "New booking confirmed");
            BookingConfirmation_Page thankyouPage = new BookingConfirmation_Page(cust_name, vehicle_name, days, amount, date, paymentMethod);
            thankyouPage.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(Main.this, "Error inserting data.");
        }

        updateVehicle.displayVehicles(jTable1);
        tb_Name.setText("");
        tb_Duration.setText("");
        tb_Rate.setText("");
        tb_Total.setText("");

    }//GEN-LAST:event_btn_ConfirmActionPerformed

    private void btn_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalculateActionPerformed
        // TODO add your handling code here:
        double rate;
        int duration;
        double total = 0;

        if (!tb_Rate.getText().isEmpty() && !tb_Duration.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Both fields have values.");
            rate = Double.parseDouble(tb_Rate.getText());
            duration = Integer.parseInt(tb_Duration.getText());
            total = rate * duration;
            tb_Total.setText(String.valueOf(total));

        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Vehicle and put in the duration of rent.");
        }

        btn_Confirm.setEnabled(true);
    }//GEN-LAST:event_btn_CalculateActionPerformed

    private void btn_BookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BookingsActionPerformed
        // TODO add your handling code here:
        // Create an instance of NewFrame and make it visible
        Booking_Page newFrame = new Booking_Page();
        newFrame.setVisible(true);
    }//GEN-LAST:event_btn_BookingsActionPerformed

    private void btn_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usersActionPerformed
        // TODO add your handling code here:
        new User_Panel().setVisible(true); // Show the JFrame form
    }//GEN-LAST:event_btn_usersActionPerformed

    private void btn_vehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vehiclesActionPerformed
        // TODO add your handling code here:
        new Vehicle_Panel().setVisible(true); // Show the JFrame form
    }//GEN-LAST:event_btn_vehiclesActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        Vehicles vehicleData = new Vehicles();
        vehicleData.displayVehicles(jTable1); // Assuming jTable1 is the JTable's variable name
        JOptionPane.showMessageDialog(Main.this, "List Refreshed.");
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void cb_filterDaysItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_filterDaysItemStateChanged
        // TODO add your handling code here:
        Vehicles vehicleData = new Vehicles();
        String days = (String) cb_filterDays.getSelectedItem();

        if (days.equals("This Week")) {
            vehicleData.displayVehicles(jTable1); // 
        } else if (days.equals("Next Week")) {
            vehicleData.displayVehicles_NextWeek(jTable1); // 
        } else if (days.equals("Next Month")) {
            vehicleData.displayVehicles_NextMonth(jTable1); // 
        }


    }//GEN-LAST:event_cb_filterDaysItemStateChanged

    private void btn_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportsActionPerformed
        // TODO add your handling code here:
        Reports_Panel newFrame = new Reports_Panel();
        newFrame.setVisible(true);
    }//GEN-LAST:event_btn_reportsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin_panel;
    private javax.swing.JButton btn_Bookings;
    private javax.swing.JButton btn_Calculate;
    private javax.swing.JButton btn_Confirm;
    private javax.swing.JToggleButton btn_refresh;
    private javax.swing.JButton btn_reports;
    private javax.swing.JButton btn_users;
    private javax.swing.JButton btn_vehicles;
    private javax.swing.JComboBox<String> cb_Payment;
    private javax.swing.JComboBox<String> cb_filterDays;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tb_Duration;
    private javax.swing.JTextField tb_Name;
    private javax.swing.JTextField tb_Rate;
    private javax.swing.JTextField tb_Total;
    // End of variables declaration//GEN-END:variables
}
