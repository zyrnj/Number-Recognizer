package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.tensorflow.*;

import java.io.IOException;

public class GUIApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GUIController c=new GUIController();
        GridPane root=c.addElement();
        Scene scene = new Scene(root, 450, 450);
        stage.setTitle("Number recognition");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
