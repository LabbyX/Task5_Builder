package com.example.task5_builder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IndicatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        IndicatorBuilder builder = new IndicatorBuilder();
        IndicatorDirector director = new IndicatorDirector(builder);

        VBox root = new VBox(20); // Контейнер для всех индикаторов
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0;");

        // Создаём таймер
        Indicator timer = director.createIndicator();
        root.getChildren().add(timer.getView());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Timer Indicator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
