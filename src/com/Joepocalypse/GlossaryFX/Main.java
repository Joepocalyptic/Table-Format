package com.Joepocalypse.GlossaryFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application implements EventHandler<ActionEvent> {
    Stage window;
    Scene intro, scene2, finalScene;
    final ToggleGroup group = new ToggleGroup();
    Button b1 = new Button("Choose");
    Button b2 = new Button("Compact");
    Button b3 = new Button("Nicely Formatted");
    Button b4 = new Button("Close");
    Button b5 = new Button("Restart");
    Label label = new Label("Welcome to the Table Formatter v2.7!\nPlease select a .txt file to continue.");
    Label label2 = new Label("Please choose your Term/Def separator.\nThen you can choose your formatting!");
    TextField field = new TextField();
    CheckBox tableBox = new CheckBox("Use <table>?");
    ChoiceBox<String> choiceBox = new ChoiceBox<>();
    TextArea finalArea = new TextArea();
    String finalText;
    String separator;
    String type;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int x, y, x2, y2, x3, y3;
        x = 500;
        y = 200;
        x2 = 400;
        y2 = 300;
        x3 = 400;
        y3 = 600;
        window = primaryStage;
        field.setPromptText("Term/Def Separator");
        field.setMaxSize(200, 50);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label2.setTextAlignment(TextAlignment.CENTER);
        field.setAlignment(Pos.CENTER);
        finalArea.setPrefSize(x3 - 10, 300);
        choiceBox.getItems().addAll("BBCode", "HTML");
        tableBox.setSelected(true);
        b1.setOnAction(this);
        b1.setMaxSize(150, 160);
        b2.setOnAction(this);
        b3.setOnAction(this);
        b4.setOnAction(e -> window.close());
        b5.setOnAction(e -> window.setScene(intro));
        VBox layout1 = new VBox(20);
        VBox layout2 = new VBox(15);
        VBox layout3 = new VBox(50);
        intro = new Scene(layout1, x, y);
        scene2 = new Scene(layout2, x2, y2);
        finalScene = new Scene(layout3, x3, y3);
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label, b1);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label2, field, choiceBox, tableBox, b2, b3);
        layout3.getChildren().addAll(finalArea, b4, b5);
        layout3.setAlignment(Pos.TOP_CENTER);
        field.getParent().requestFocus();
        finalArea.getParent().requestFocus();
        window.setResizable(false);
        window.setScene(intro);
        window.setTitle("Table Formatter | 2.7 FX");
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == b1) {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().addAll(
                    new ExtensionFilter("Text Files", "*.txt")
            );
            File selectedFile = fc.showOpenDialog(null);
            if (selectedFile != null) {
                finalText = readFile(selectedFile);
                window.setScene(scene2);
                System.out.println(finalText);
            } else {
                System.out.println("File is not valid!");

            }

        }
        if (event.getSource() == b2) {
            separator = field.getText();
            if(field.getText().equals("")) {
                return;
            }
            String finalValue = "";
            try {
                getChoice(choiceBox);
                switch (type) {
                    case "BBCode":
                        finalValue = TableTypes.compactBBTable(separator, finalText, tableBox.isSelected());

                        break;
                    case "HTML":
                        finalValue = TableTypes.compactHTMLTable(separator, finalText, tableBox.isSelected());
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
                if (type.equals("")) {
                    return;
                }
                finalArea.setText(finalValue);
                finalArea.getParent().requestFocus();
                window.setScene(finalScene);
            } catch(NullPointerException e) {
                return;
            }
        }
        if (event.getSource() == b3) {
            separator = field.getText();
            if(field.getText().equals("")) {
                return;
            }
            String finalValue = "";
            try {
                getChoice(choiceBox);
                switch (type) {
                    case "BBCode":
                        finalValue = TableTypes.aestheticBBTable(separator, finalText, tableBox.isSelected());
                        break;
                    case "HTML":
                        finalValue = TableTypes.aestheticHTMLTable(separator, finalText, tableBox.isSelected());
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
                if (type.equals("")) {
                    return;
                }
                finalArea.setText(finalValue);
                finalArea.getParent().requestFocus();
                window.setScene(finalScene);
            } catch(NullPointerException e) {
                return;
            }
        }
    }

    private String readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append("\n");
                stringBuffer.append(text);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }
    private void getChoice(ChoiceBox<String> choiceBox) {

        type = choiceBox.getValue();

    }
}
// Content of Joepocalypse. Questions or comments? Contact me on Discord @ Joepocalypse#6925.
// Helped greatly by Hwiggy.
