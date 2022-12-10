package com.example.finalproject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUIController {
    private Label result=new Label("press to recognize");
    private Canvas canvas;
    private GridPane root;
    GridPane addElement(){
        canvas=new Canvas();
        root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.add(canvas,0,0,1,1);
        root.setAlignment(Pos.CENTER);

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        canvas.setHeight(225);
        canvas.setWidth(225);
        //make scene more user friendly
        root.setGridLinesVisible(true);
        root.setStyle(
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        canvas.setOnMousePressed(e -> {
            ctx.setStroke(Color.BLUE);
            ctx.beginPath();
            ctx.moveTo(e.getX(), e.getY());
            ctx.stroke();
        });
        canvas.setOnMouseDragged(e -> {
            ctx.setStroke(Color.BLACK);
            ctx.lineTo(e.getX(), e.getY());
            ctx.stroke();
        });
        canvas.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                clear(ctx);
            }
        });
        //press this button to save the canvas
        VBox v1=new VBox();
        VBox v2=new VBox();
        Button b=new Button("save");
        v1.getChildren().add(b);
        b.setEffect(new DropShadow());
        v1.setAlignment(Pos.CENTER);
        //press this button to predict the number
        Button c=new Button("recognize");
        c.setEffect(new DropShadow());
        v2.getChildren().add(c);
        v2.setAlignment(Pos.CENTER);

        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                     canvasSave();
            }
        });
        c.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                LoadImage l=new LoadImage();
                try {
                    l.getRgbArray();
                    //Predict p=Predict.getInstance();
                    //int res= p.getPredictRes(l);
                    //result.setText(res);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        root.add(v1,0,1);
        root.add(v2,1,1);
        root.add(result,1,0);
        return root;
    }

    private void clear(GraphicsContext ctx) {
        ctx.setFill(Color.WHITE);
        ctx.fillRect(0, 0, 300, 300);
    }

    private void canvasSave() {
        //use snapshot to save the canvas as a png image
        WritableImage image = canvas.snapshot(new SnapshotParameters(), null);
        File file = new File("src/main/original.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}