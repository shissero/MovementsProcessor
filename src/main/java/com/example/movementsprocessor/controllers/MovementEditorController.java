package com.example.movementsprocessor.controllers;

import com.example.movementsprocessor.VistaNavigator;
import com.example.movementsprocessor.models.movement.Movement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class MovementEditorController {

        TableView<String> view = new TableView<>();
        Movement movement;

        @FXML
        public void fileManager(ActionEvent event) {

                VistaNavigator.loadVista(VistaNavigator.FILE_NAVIGATOR);
        }
}
