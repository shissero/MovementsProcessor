package com.example.vamojossa;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Main controller class for the entire layout.
 */
public class MainController {

    private static final MainController INSTANCE = new MainController();

    private MainController(){}

    /** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;

    public static MainController getInstance(){
        return INSTANCE;
    }

    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }

}