package com.example.task5_builder;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class IndicatorBuilder {
    private Indicator indicator;
    private float start, stop;
    private float currentTime = 0; // Прошедшее время

    public IndicatorBuilder() {
        this.indicator = new Indicator();
    }

    public void setView(int length, char color, char label) {
        VBox vbox = new VBox(10); // Контейнер для метки
        vbox.setAlignment(Pos.CENTER);

        Text textLabel = new Text("Label: " + label);
        textLabel.setStyle("-fx-font-size: 14px; -fx-fill: black;");
        vbox.getChildren().add(textLabel);

        indicator.add(vbox);
    }

    public void lineBounds(float start, float stop) {
        this.start = start;
        this.stop = stop;
    }

    public void linePaint(float measure) {
        VBox vbox = new VBox(10); // Основной контейнер
        vbox.setAlignment(Pos.CENTER);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(300);

        Text progressText = new Text(String.format("Time elapsed: %.0fs / %.0fs", currentTime, stop));
        progressText.setStyle("-fx-font-size: 14px;");

        // Кнопка для запуска таймера
        Button startButton = new Button("Старт");
        startButton.setOnAction(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> {
                        if (currentTime < stop) {
                            currentTime++;
                            double progress = currentTime / stop;
                            progressBar.setProgress(progress);
                            progressText.setText(String.format("Таймер: %.0fs / %.0fs", currentTime, stop));
                        }
                    })
            );
            timeline.setCycleCount((int) stop);
            timeline.play();
        });

        vbox.getChildren().addAll(progressBar, progressText, startButton);
        indicator.add(vbox);
    }

    public Indicator build() {
        return indicator;
    }
}
