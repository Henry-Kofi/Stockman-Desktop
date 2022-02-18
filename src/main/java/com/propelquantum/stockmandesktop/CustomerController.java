package com.propelquantum.stockmandesktop;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    public TextField searchTextField;
    public TableView<Customer> tableView;
    public TableColumn<Customer, Integer> idTableColumn;
    public TableColumn<Customer, String> fullNameTableColumn;
    public TableColumn<Customer, String> companyOrLocationTableColumn;
    public TableColumn<Customer, Number> totalAmountPurchasedTableColumn;
    public TableColumn<Customer, String> lastPurchasedDateTableColumn;
    public TableColumn<Customer, String> telephoneTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onAddCustomerButtonClicked(ActionEvent actionEvent) {
    }

    public void onSearchButtonClicked(ActionEvent actionEvent) {
    }


}
