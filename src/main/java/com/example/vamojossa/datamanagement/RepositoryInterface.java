package com.example.vamojossa.datamanagement;

import com.example.vamojossa.models.movement.Movement;
import com.example.vamojossa.models.movement.MovementBuilder;
import com.example.vamojossa.models.movement.getdatastratagies.NubankCSVStrategy;
import javafx.collections.ObservableList;

// TODO: This class will either turn into an interface or be used to create an interface. I did as a class so I can understand what the code needs before trying to generalize it
public class RepositoryInterface {

    private ObservableList<MovementBuilder> movements;

    public static ObservableList<MovementBuilder> getDataForEdition(){

        return (new NubankCSVStrategy()).getMovements("src/main/resources/com/example/vamojossa/test_ignore");
    }
}