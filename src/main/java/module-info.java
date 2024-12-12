module com.example.vamojossa {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires com.dlsc.formsfx;

        opens com.example.vamojossa to javafx.fxml;
        exports com.example.vamojossa;
        exports com.example.vamojossa.models;
        exports com.example.vamojossa.views;
        opens com.example.vamojossa.models to javafx.fxml;
        opens com.example.vamojossa.views to javafx.fxml ;
        exports com.example.vamojossa.presenters;
        opens com.example.vamojossa.presenters to javafx.fxml;
        exports com.example.vamojossa.utils;
        opens com.example.vamojossa.utils to javafx.fxml;
        exports com.example.vamojossa.controllers;
        opens com.example.vamojossa.controllers to javafx.fxml;
}