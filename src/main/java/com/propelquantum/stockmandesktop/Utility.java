package com.propelquantum.stockmandesktop;

import javafx.scene.control.Alert;
import javafx.stage.Window;

import java.sql.*;

public class Utility {
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/stockman?useSSL=false";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "2024";

    public static final String SELECT_LOGIN_QUERY_FROM_STAFF = "SELECT * FROM stockman.user WHERE username = ? and password = ?";
    public static final String SEARCH_ALL_CUSTOMER_QUERY = "SELECT * FROM stockman.customer";
    public static final String SEARCH_ALL_SUPPLIER_QUERY = "SELECT * FROM stockman.supplier";
    public static final String SEARCH_ALL_PRODUCT_QUERY = "SELECT * FROM stockman.products";
    public static final String SEARCH_ALL_EXPENDITURE_QUERY = "SELECT * FROM stockman.expenditure";

    public static User loggedInUser = new User();

    public static boolean validateLoginCredentials(final String username, final String password) {

        try(Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_QUERY_FROM_STAFF)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // debug
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                loggedInUser.setUserID(resultSet.getInt("userID"));
                loggedInUser.setFullName(resultSet.getString("fullName"));
                loggedInUser.setUsername(resultSet.getString("username"));
                loggedInUser.setPassword(resultSet.getString("password"));

                // debug
                System.out.println(loggedInUser.getFullName() + " with ID " + loggedInUser.getUserID() + " has logged in");

                return true;
            }

        } catch(SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public static void informationDisplay(final String message, final String header, final String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setContentText(message);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, final String title, final String message) {
        Alert alert = new Alert(alertType);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
