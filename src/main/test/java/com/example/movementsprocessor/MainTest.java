package com.example.movementsprocessor;

import com.example.movementsprocessor.models.movement.getdatastratagies.NubankCSVStrategy;
import com.example.movementsprocessor.presenters.TableDataPresenter;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void start() {

        ObservableList<? extends TableDataPresenter.TableDataAdapter> all_movements = (new NubankCSVStrategy()).getMovements("src/main/resources/com/example/vamojossa/test_ignore");

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movements_list.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Main.class.getResource("movements_list_style.css").toExternalForm());

        TableDataPresenter presenter = new TableDataPresenter(all_movements, fxmlLoader.getController());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    @Test
    void main() {

        launch();
    }
}