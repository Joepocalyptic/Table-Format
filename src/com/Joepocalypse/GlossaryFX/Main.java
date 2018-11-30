package com.Joepocalypse.GlossaryFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    private String finalText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        final VBox
                layout1 = new VBox(20),
                layout2 = new VBox(15),
                layout3 = new VBox(50);
        layout1.setAlignment(Pos.CENTER);
        layout2.setAlignment(Pos.CENTER);
        layout3.setAlignment(Pos.TOP_CENTER);

        final Scene
                intro = new Scene(layout1, 500, 200),
                scene2 = new Scene(layout2, 400, 300),
                finalScene = new Scene(layout3, 400, 600);

        final CheckBox compact = new CheckBox("Compact");
        final ChoiceBox<Table> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(Table.values()));
        final Label welcome = new Label(
                "Welcome to the Table Formatter v2.7!\n" +
                        "Please select a .txt file to continue."
        );
        welcome.setAlignment(Pos.CENTER);
        welcome.setTextAlignment(TextAlignment.CENTER);


        final Label info = new Label(
                "Please choose your Term/Def separator.\n" +
                        "Then you can choose your formatting!"
        );
        info.setTextAlignment(TextAlignment.CENTER);

        final TextField field = new TextField();
        field.setPromptText("Term/Def Separator");
        field.setMaxSize(200, 50);
        field.setAlignment(Pos.CENTER);

        final TextArea finalArea = new TextArea();
        finalArea.setPrefSize(390, 300);

        final Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        final Button chooseButton = new Button("Choose");
        chooseButton.setMaxSize(150, 160);
        chooseButton.setOnMouseClicked(event -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt")
            );
            final File selected = fileChooser.showOpenDialog(null);
            if (selected == null) { return; }
            finalText = readFile(selected);
            window.setScene(scene2);
        });

        final Button restart = new Button("Restart");
        restart.setOnAction(e -> window.setScene(intro));

        final Button generateButton = new Button("Generate");
        generateButton.setOnMouseClicked(event -> {
            final boolean isCompact = compact.isSelected();
            final Table table = choiceBox.getValue();
            if (table == null) {
                return;
            }
            final String separator = field.getText();
            if ("".equals(separator)) {
                return;
            }
            finalArea.setText(table.generate(separator, finalText, !isCompact));
            finalArea.getParent().requestFocus();
            window.setScene(finalScene);
        });

        layout1.getChildren().addAll(welcome, chooseButton);
        layout2.getChildren().addAll(info, field, choiceBox, compact, generateButton);
        layout3.getChildren().addAll(finalArea, closeButton, restart);

        field.getParent().requestFocus();
        finalArea.getParent().requestFocus();

        window.setResizable(false);
        window.setScene(intro);
        window.setTitle("Table Formatter | 2.7 FX");
        window.show();

    }

    private String readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append("\n");
                stringBuffer.append(text);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
// Content of Joepocalypse. Questions or comments? Contact me on Discord @ Joepocalypse#6925.
// Helped greatly by Hwiggy.
