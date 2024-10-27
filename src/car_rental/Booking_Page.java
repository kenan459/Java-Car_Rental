/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package car_rental;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author kenan
 */
public class Booking_Page extends javax.swing.JFrame {

    private String booking_IDSelected;
    private String vehicle_IDSelected;

    /**
     * Creates new form Bookings
     */
    public Booking_Page() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this frame
        btn_return.setEnabled(false);
        Rentals rentalData = new Rentals();
        rentalData.displayRentals(table_Rentals);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Rentals = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        txt_vehicleName = new javax.swing.JLabel();
        txt_customerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        table_Rentals.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_Rentals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental_ID", "Vehicle_ID", "Vehicle Name", "Customer Name", "Rental Days", "Amount Paid", "Payment Method", "Rental Date", "Rental Returned Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Rentals.setRowHeight(40);
        table_Rentals.setShowGrid(false);
        table_Rentals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_RentalsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Rentals);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Booking Records");

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_return.setText("Return Car");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_id.setText("Rental ID");

        txt_vehicleName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_vehicleName.setText("Vehicle Name");

        txt_customerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_customerName.setText("Customer Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_customerName)
                    .addComponent(txt_vehicleName)
                    .addComponent(txt_id)
                    .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_vehicleName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_customerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_RentalsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_RentalsMouseClicked
        int selectedRow = table_Rentals.getSelectedRow();

        // Get the ID from the first column (column index 0)
        Object id = table_Rentals.getValueAt(selectedRow, 0);// Assuming ID is in the first column
        Object vehicle_id = table_Rentals.getValueAt(selectedRow, 1);// Assuming ID is in the first column
        Object vehicle_name = table_Rentals.getValueAt(selectedRow, 2).toString();
        Object customer_name = table_Rentals.getValueAt(selectedRow, 3).toString();
        Object status = table_Rentals.getValueAt(selectedRow, 9).toString();

        booking_IDSelected = id.toString();
        vehicle_IDSelected = vehicle_id.toString();
        txt_id.setText("Rental ID: " + id.toString());
        txt_vehicleName.setText("Vehicle Name: " + vehicle_name);
        txt_customerName.setText("Customer Name: " + customer_name);
        if (status.equals("Active")) {
            btn_return.setEnabled(true);
        } else {
            btn_return.setEnabled(false);
        }

        System.out.println("Selected ID: " + booking_IDSelected);
        System.out.println("Selected Vehicle: " + vehicle_name);

//        tb_Rate.setText(rate.toString());
    }//GEN-LAST:event_table_RentalsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        // TODO add your handling code here:
        Rentals updateData = new Rentals();
        Vehicles updateVehicle = new Vehicles();

        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");
        LocalDateTime today = LocalDateTime.now();
        String date = today.format(formatter);

        int rentalID = Integer.parseInt(booking_IDSelected);
        boolean success = updateData.updateBooking(rentalID, date);
        if (success) {
            updateVehicle.returnVehicle(Integer.parseInt(vehicle_IDSelected));
            JOptionPane.showMessageDialog(Booking_Page.this, "Booking updated: Car Returned.");
            updateData.displayRentals(table_Rentals);
        } else {
            System.out.println("Error updating Booking.");
        }

        btn_return.setEnabled(false);
    }//GEN-LAST:event_btn_returnActionPerformed

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
            java.util.logging.Logger.getLogger(Booking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Rentals;
    private javax.swing.JLabel txt_customerName;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_vehicleName;
    // End of variables declaration//GEN-END:variables
}
