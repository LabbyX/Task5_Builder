package com.example.task5_builder;

import javafx.scene.layout.Pane;

public class Indicator {
    private Pane root;

    public Indicator() {
        this.root = new Pane();
    }

    public void add(Pane pane) {
        root.getChildren().add(pane);
    }

    public Pane getView() {
        return root;
    }
}
