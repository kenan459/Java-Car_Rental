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
public class Vehicles {

    public void getVehicles() {
        try {
            // Get the database connection
            Connection connection = DatabaseConnection.getConnection();

            // Create a statement
            Statement stmt = connection.createStatement();

            // Execute a query to retrieve data
            String query = "SELECT * FROM vehicles";
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String model = rs.getString("vehicle_model");

                // Print to console (You can show it in a JTable later)
                System.out.println("ID: " + id + ", Name: " + make + ", Email: " + model);
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayVehicles(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vehicles ORDER BY vehicle_status DESC";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String vec_model = rs.getString("vehicle_model");
                String year = rs.getString("vehicle_year");
                String rate = rs.getString("vehicle_rate");
                String status = rs.getString("vehicle_status");
                if (status.equals("1")) {
                    status = "Available";
                } else {
                    status = "Unavailable";
                }

                model.addRow(new Object[]{id, status, make, vec_model, year, rate});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayVehicles_ThisWeek(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vehicles WHERE available_From >= (CURDATE())";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String vec_model = rs.getString("vehicle_model");
                String year = rs.getString("vehicle_year");
                String rate = rs.getString("vehicle_rate");
                String status = rs.getString("vehicle_status");
                if (status.equals("1")) {
                    status = "Available";
                } else {
                    status = "Unavailable";
                }

                model.addRow(new Object[]{id, status, make, vec_model, year, rate});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayVehicles_NextWeek(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vehicles WHERE available_From >= CURDATE() + INTERVAL 7 DAY;";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String vec_model = rs.getString("vehicle_model");
                String year = rs.getString("vehicle_year");
                String rate = rs.getString("vehicle_rate");
                String status = rs.getString("vehicle_status");
                if (status.equals("1")) {
                    status = "Available";
                } else {
                    status = "Unavailable";
                }

                model.addRow(new Object[]{id, status, make, vec_model, year, rate});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayVehicles_NextMonth(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vehicles WHERE available_From >= CURDATE() + INTERVAL 30 DAY;";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String vec_model = rs.getString("vehicle_model");
                String year = rs.getString("vehicle_year");
                String rate = rs.getString("vehicle_rate");
                String status = rs.getString("vehicle_status");
                if (status.equals("1")) {
                    status = "Available";
                } else {
                    status = "Unavailable";
                }

                model.addRow(new Object[]{id, status, make, vec_model, year, rate});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public void vehicleList(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM vehicles ORDER BY vehicle_status DESC";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("vehicle_id");
                String make = rs.getString("vehicle_make");
                String vec_model = rs.getString("vehicle_model");
                String year = rs.getString("vehicle_year");
                String rate = rs.getString("vehicle_rate");
                String status = rs.getString("vehicle_status");
                if (status.equals("1")) {
                    status = "Available";
                } else {
                    status = "Unavailable";
                }

                model.addRow(new Object[]{id, make, vec_model, rate, year, status});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean newVehicle(String make, String model, String year, String rate) {
        String query = "INSERT INTO vehicles (vehicle_make, vehicle_model, vehicle_year, vehicle_rate) VALUES (?,?,?,?)"; // Update with your table and columns
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, make);
            pstmt.setString(2, model);
            pstmt.setString(3, year);
            pstmt.setString(4, rate);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if there is an error
        }
    }

    public boolean updateVehicle(int id, String rate, String availability) {
        String query = "UPDATE vehicles SET vehicle_rate = ?, vehicle_status = ? WHERE vehicle_id = ?";
        String status;
        if (availability.equals("Available")) {
            status = "1";
        } else {
            status = "0";
        }

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set the parameters in the query
            pstmt.setString(1, rate);
            pstmt.setString(2, status);
            pstmt.setInt(3, id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean bookVehicle(int id) {
        String query = "UPDATE vehicles SET vehicle_status = ? WHERE vehicle_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set the parameters in the query
            pstmt.setString(1, "0");
            pstmt.setInt(2, id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean returnVehicle(int id) {
        String query = "UPDATE vehicles SET vehicle_status = ? WHERE vehicle_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Set the parameters in the query
            pstmt.setString(1, "1");
            pstmt.setInt(2, id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
