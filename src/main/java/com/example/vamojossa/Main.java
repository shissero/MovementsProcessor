package com.example.vamojossa;

import com.example.vamojossa.models.movement.getdatastratagies.NubankCSVStrategy;
import com.example.vamojossa.presenters.TableDataPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



        @Override
        public void start(Stage stage) throws IOException {

                ObservableList<? extends TableDataPresenter.TableDataAdapter> all_movements = (new NubankCSVStrategy()).getMovements("src/main/resources/com/example/vamojossa/test_ignore");

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movements_table.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets().add(Main.class.getResource("movement_table_style.css").toExternalForm());

                TableDataPresenter presenter = new TableDataPresenter(all_movements, fxmlLoader.getController());

                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
        }

        public static void main(String[] args) {

                launch();
        }
}