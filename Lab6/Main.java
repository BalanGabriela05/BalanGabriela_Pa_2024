package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jocul cu grilă");


        // Crearea panoului de configurare
        Label gridSizeLabel = new Label("Dimensiunea grilei:");
        TextField gridSizeInput = new TextField();
        Button newGameButton = new Button("Joc nou");
        HBox configPanel = new HBox(gridSizeLabel, gridSizeInput, newGameButton);

        // Crearea panoului de desen
        Canvas gameBoard = new Canvas(600, 600);
        GraphicsContext gc = gameBoard.getGraphicsContext2D();
        //Desenez grila pe canvas
        // Presupunem că dimensiunea grilei este 10x10
        int gridSize = 10;
        double cellWidth = gameBoard.getWidth() / gridSize;
        double cellHeight = gameBoard.getHeight() / gridSize;

        //liniile verticale
        for (int i = 0; i <= gridSize; i++) {
            gc.strokeLine(i * cellWidth, 0, i * cellWidth, gameBoard.getHeight());
        }

        //liniile orizontale
        for (int i = 0; i <= gridSize; i++) {
            gc.strokeLine(0, i * cellHeight, gameBoard.getWidth(), i * cellHeight);
        }


        // Crearea panoului de control
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        HBox controlPanel = new HBox(loadButton, saveButton, exitButton);

        // Adăugarea componentelor la cadrul principal
        BorderPane root = new BorderPane();
        root.setTop(configPanel);
        root.setCenter(gameBoard);
        root.setBottom(controlPanel);

        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
