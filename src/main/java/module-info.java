module com.propelquantum.stockmandesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.propelquantum.stockmandesktop to javafx.fxml;
    exports com.propelquantum.stockmandesktop;
}