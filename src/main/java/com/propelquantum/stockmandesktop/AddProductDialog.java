package com.propelquantum.stockmandesktop;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddProductDialog {
    private static String name;
    private static String description;
    private static double price;

    public static void show() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);

        TextField productName = new TextField();
        productName.setPromptText("Enter the name of the name");
        productName.setMinHeight(30);

        TextField productDescription = new TextField();
        productDescription.setPromptText("Describe the product");
        productDescription.setMinHeight(30);

        TextField productPrice = new TextField();
        productPrice.setPromptText("How much is the product");
        productPrice.setMinHeight(30);

        Button button = new Button("Add");
        button.setMinSize(150, 30);
        button.setOnAction(e -> {
            name = productName.getText();
            description = productDescription.getText();

            try {
                price = Double.parseDouble(productPrice.getText());
            } catch (NumberFormatException ne) {
                System.out.println("Error parsing price string to double: " + ne);

                Utility.showAlert(Alert.AlertType.ERROR, null, "Product Addition Error!", "The price is in the wrong format");
            }


            if (productName.getText().isEmpty()) {
                Utility.showAlert(Alert.AlertType.ERROR, null, "Product Addition Error!", "Please enter a product's name");
                return;
            }

            if (productDescription.getText().isEmpty()) {
                Utility.showAlert(Alert.AlertType.ERROR, null, "Product Addition Error!", "Please describe the product");
                return;
            }

            if (productPrice.getText().isEmpty()) {
                Utility.showAlert(Alert.AlertType.ERROR, null, "Product Addition Error!", "Please price the product");
                return;
            }

            System.out.println("The value of name is: " + name);
            System.out.println("The value of description is: " + description);
            System.out.println("The value of price is: " + price);
        });

    }
}
