package com.propelquantum.stockmandesktop;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PurchaseDialog {
    private static int quantity;

    public static void show() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);

        TextField quantityToPurchase = new TextField();
        quantityToPurchase.setPromptText("How many quantities?");
        quantityToPurchase.setMinHeight(30);

        ComboBox<String> customerName = new ComboBox<>();
        customerName.setMinHeight(30);
        customerName.setPromptText("Pick Customer's name");

        ComboBox<String> customerTelephone = new ComboBox<>();
        customerTelephone.setMinHeight(30);
        customerTelephone.setPromptText("Pick Customer's telephone");

        Button button = new Button("Make Purchase");
        button.setMinSize(150, 30);
        button.setOnAction(e -> {
            try {
                quantity = Integer.parseInt(quantityToPurchase.getText());
            } catch (NumberFormatException ne) {
                System.out.println("Error parsing quantity string to int: " + ne);

                Utility.showAlert(Alert.AlertType.ERROR, null, "Purchase Failure!", "Quantity is in the wrong format");
                return;
            }

            if (quantityToPurchase.getText().isEmpty()) {
                Utility.showAlert(Alert.AlertType.ERROR, null, "Purchase Failure!", "Please enter the purchased quantity");
                return;
            }

            
        });

    }
}
