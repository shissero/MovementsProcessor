module com.example.movementsprocessor {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires com.dlsc.formsfx;
        requires org.apache.logging.log4j;

        exports com.example.movementsprocessor;
        opens com.example.movementsprocessor to javafx.fxml;
        exports com.example.movementsprocessor.views;
        opens com.example.movementsprocessor.views to javafx.fxml ;
        exports com.example.movementsprocessor.presenters;
        opens com.example.movementsprocessor.presenters to javafx.fxml;
        exports com.example.movementsprocessor.utils;
        opens com.example.movementsprocessor.utils to javafx.fxml;
        exports com.example.movementsprocessor.controllers;
        opens com.example.movementsprocessor.controllers to javafx.fxml;
        exports com.example.movementsprocessor.models.movement.getdatastratagies;
        opens com.example.movementsprocessor.models.movement.getdatastratagies to javafx.fxml;
        exports com.example.movementsprocessor.models.movement;
        opens com.example.movementsprocessor.models.movement to javafx.fxml;
}