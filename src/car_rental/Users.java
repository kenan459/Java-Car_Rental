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
public class Users {

    //Login Query
    public User_Session validateUser(String username, String password) {
        String query = "SELECT user_role FROM users WHERE username = ? AND password = ? AND user_status = 1";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("user_role");
                return new User_Session(username, role); // Return a UserSession if login is successful
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // Return null if login fails
    }

    public void displayUsers(JTable table) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM users ORDER BY user_status DESC, user_role ASC";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            // Add data to the table model
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String role = rs.getString("user_role");
                String status = rs.getString("user_status");

                if (status.equals("1")) {
                    status = "Active";
                } else {
                    status = "Inactive";
                }

                model.addRow(new Object[]{id, username, role, status});
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean newUser(String username, String password, String role) {
        String query = "INSERT INTO users (username, password, user_role) VALUES (?,?,?)"; // Update with your table and columns
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if there is an error
        }
    }

    public boolean updateUser(int id, String username, String password, String role) {
        String query = "UPDATE users SET username = ?, password = ?, user_role = ? WHERE user_id = ?";

        if (password.equals("")) {
            query = "UPDATE users SET username = ?, user_role = ? WHERE user_id = ?";
            try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
                // Set the parameters in the query
                pstmt.setString(1, username);
                pstmt.setString(2, role);
                pstmt.setInt(3, id);

                // Execute the update
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0; // Return true if at least one row was updated
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
                // Set the parameters in the query
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, role);
                pstmt.setInt(4, id);

                // Execute the update
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0; // Return true if at least one row was updated
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    public boolean activateUser(int user_id) {
        String query = "UPDATE users SET user_status = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            // Set the parameters in the query
            pstmt.setInt(1, 1);
            pstmt.setInt(2, user_id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean disableUser(int user_id) {
        String query = "UPDATE users SET user_status = ? WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            // Set the parameters in the query
            pstmt.setInt(1, 0);
            pstmt.setInt(2, user_id);

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was updated
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
