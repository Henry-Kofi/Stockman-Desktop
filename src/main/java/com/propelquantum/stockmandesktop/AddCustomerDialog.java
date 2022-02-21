package com.propelquantum.stockmandesktop;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddCustomerDialog {
    

    public static String show() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        TextField customerFullName = new TextField();
        TextField locationOrCompany = new TextField();
        TextField telephone = new TextField();

        Button button = new Button("Add");
        button.setOnAction(e -> );
    }
}
