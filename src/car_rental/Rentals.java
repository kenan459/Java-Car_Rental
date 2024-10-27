/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car_rental;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kenan
 */
public class Rentals {

    public boolean insertData(String vehicle_id, String vehicle_name, String cust_name, String days, String amount, String date, String paymentMethod) {
        String query = "INSERT INTO rentals (vehicle_ID, vehicle_name, customer_name, rental_days, rental_amountPaid, rental_date, payment_method) VALUES (?,?,?,?,?,?,?)"; // Update with your table and columns
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, vehicle_id);
            pstmt.setString(2, vehicle_name);
            pstmt.setString(3, cust_name);
            pstmt.setString(4, days);
            pstmt.setString(5, amount);
            pstmt.setString(6, date);
            pstmt.setString(7, paymentMethod);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if there is an error
        }
    }

    public void displayRentals(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM rentals ORDER BY rental_status DESC, rental_date DESC";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("rental_id");
                String vehicle_id = rs.getString("vehicle_id");
                String vehicle_name = rs.getString("vehicle_name");
                String amount = rs.getString("rental_amountPaid");
                String customer_name = rs.getString("customer_name");
                String duration = rs.getString("rental_days");
                String date = rs.getString("rental_date");
                String return_date = rs.getString("rental_returnedDate");
                String paymentMethod = rs.getString("payment_method");
                String status = rs.getString("rental_status");
                if (status.equals("1")) {
                    status = "Active";
                } else {
                    status = "Returned";
                }

                model.addRow(new Object[]{id, vehicle_id, vehicle_name, customer_name, duration, amount, paymentMethod, date, return_date, status});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateBooking(int rental_id, String date) {
        String query = "UPDATE rentals SET rental_status = ?, rental_returnedDate = ? WHERE rental_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            // Set the parameters in the query
            pstmt.setInt(1, 0);
            pstmt.setString(2, date);
            pstmt.setInt(3, rental_id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
