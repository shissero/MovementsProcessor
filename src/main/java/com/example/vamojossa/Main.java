package com.example.vamojossa;

import com.example.vamojossa.models.movement.getdatastratagies.NubankCSVStrategy;
import com.example.vamojossa.presenters.TableDataPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



        @Override
        public void start(Stage stage) throws IOException {
                stage.setTitle("Movements processor");

                stage.setScene(
                        createScene(
                                loadMainPane()
                        )
                );

                stage.show();
        }

        /**
         * Loads the main fxml layout.
         * Sets up the vista switching VistaNavigator.
         * Loads the first vista into the fxml layout.
         *
         * @return the loaded pane.
         * @throws IOException if the pane could not be loaded.
         */
        private Pane loadMainPane() throws IOException {
                FXMLLoader loader = new FXMLLoader();

                Pane mainPane = (Pane) loader.load(
                        getClass().getResourceAsStream(
                                "/main.fxml"
                        )
                );

                MainController mainController = loader.getController();

                VistaNavigator.setMainController(mainController);
                //VistaNavigator.loadVista(VistaNavigator.VISTA_1);

                return mainPane;
        }

        /**
         * Creates the main application scene.
         *
         * @param mainPane the main application layout.
         *
         * @return the created scene.
         */
        private Scene createScene(Pane mainPane) {
                Scene scene = new Scene(
                        mainPane
                );

                // ME: this will remove all current styles sheets and add vista.css
                scene.getStylesheets().setAll(
                        getClass().getResource("vista.css").toExternalForm()
                );

                return scene;
        }

        public static void main(String[] args) {

                launch();
        }
}