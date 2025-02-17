package com.example.movementsprocessor.presenters;

import com.example.movementsprocessor.models.movement.MovementBuilder;
import com.example.movementsprocessor.views.MovementFormView;

public class MovementFormPresenter {

    private MovementFormView view;

    private MovementBuilder movementBuilder;

    public MovementFormPresenter(MovementFormView view, MovementBuilder movementBuilder) {

        this.view = view;
        this.movementBuilder = movementBuilder;
    }
}
