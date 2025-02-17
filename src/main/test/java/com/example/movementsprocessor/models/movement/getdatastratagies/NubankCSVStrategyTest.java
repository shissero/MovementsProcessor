package com.example.movementsprocessor.models.movement.getdatastratagies;

import com.example.movementsprocessor.models.movement.MovementBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NubankCSVStrategyTest {

    public static ObservableList<MovementBuilder> movements;
    public static MovementBuilder movementBuilder1 = new MovementBuilder();
    public static MovementBuilder movementBuilder2 = new MovementBuilder();
    public static String test_csv_file_path = "src/main/resources/com/example/vamojossa/test_ignore/nubank_csv_test.csv";
    public static String test_csv_dir_path = "src/main/resources/com/example/vamojossa/test_ignore";

    @BeforeAll
    protected static void setUp() {

        movements = FXCollections.observableArrayList();

        movementBuilder1.addDateInfo("22/45/1733");
        movementBuilder1.addAmountInfo(2.91f);
        movementBuilder1.addDescription("Compra no débito");

        movementBuilder2.addDateInfo("58/37/2724");
        movementBuilder2.addAmountInfo(-354.96f);
        movementBuilder2.addDescription("Compra no crédito");

        movements.add(movementBuilder1);
        movements.add(movementBuilder2);
    }

    @Test
    void getFromDirectory(){

        ObservableList<MovementBuilder> result = (new NubankCSVStrategy()).getFromDirectory(test_csv_dir_path);

        assertTrue(result.containsAll(movements));
    }

    @Test
    void getFromFile() {

        ObservableList<MovementBuilder> result = (new NubankCSVStrategy()).getFromFile(test_csv_file_path);

        assertTrue(result.containsAll(movements));
    }

    @Test
    void validateNubankCSVLine() {
    }
}