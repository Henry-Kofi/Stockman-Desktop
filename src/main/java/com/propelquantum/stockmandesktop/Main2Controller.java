package com.propelquantum.stockmandesktop;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Main2Controller implements Initializable {


    public BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
            borderPane.setCenter(fxml);
        } catch (IOException e) {
            Utility.showAlert(Alert.AlertType.ERROR, null, "Fatal Error!", "Contact application developer");
        }
    }
    
    
    public void onDashboardButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onInventoryButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inventory.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onProductsButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("products.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onCustomersButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onSuppliersButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("supplier.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onExpenditureButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("expenditure.fxml")));
        borderPane.setCenter(fxml);
    }

    public void onSettingsButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
    }

    
}
