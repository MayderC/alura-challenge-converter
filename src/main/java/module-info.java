module com.example.currency {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.currency to javafx.fxml;
    exports com.example.currency;
    exports com.example.currency.controllers;
    opens com.example.currency.controllers to javafx.fxml;
}