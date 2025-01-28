package com.example.vamojossa.presenters;

import com.example.vamojossa.models.movement.MovementBuilder;
import com.example.vamojossa.views.MovementFormView;

public class MovementFormPresenter {

    private MovementFormView view;

    private MovementBuilder movementBuilder;

    public MovementFormPresenter(MovementFormView view, MovementBuilder movementBuilder) {

        this.view = view;
        this.movementBuilder = movementBuilder;
    }
}
