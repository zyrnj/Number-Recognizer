package com.example.exercise9;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HelloController {
    int number1;
    int number2;
    int number3;
    String logic;
    TextField view;
    Label label1;
    Label label2;

    void addPane(AnchorPane root) {
        view=new TextField("0");
        TextField view2=new TextField("");
        TextField view3=new TextField("");
        label1=new Label(logic);
        label2=new Label("=");
        label1.setStyle("-fx-background-color:lightblue;");
        label2.setStyle("-fx-background-color:lightblue;");
        //view.setLayoutX(30);
        //view.setLayoutY(10);
        view.setAlignment(Pos.CENTER_RIGHT);

        GridPane gridPane=new GridPane();
        gridPane.setLayoutX(40);
        gridPane.setHgap(24);
        gridPane.setVgap(10);
        root.getChildren().add(gridPane);

        view.setPrefSize(80, 20);
        view2.setPrefSize(80, 20);
        view3.setPrefSize(80, 20);
        gridPane.addRow(0,view2);
        gridPane.addRow(0,label1);
        gridPane.addRow(0,view3);
        gridPane.addRow(0,label2);
        gridPane.addRow(0,view);
        //view2,3 only restricted to int
        view2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                for(char ch:t1.toCharArray())
                    if(!Character.isDigit(ch))
                        view2.setText(s);
            }
        });
        view3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                for(char ch:t1.toCharArray())
                    if(!Character.isDigit(ch))
                        view3.setText(s);
            }
        });
        view2.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent keyEvent) {
                number1=Integer.valueOf(view2.getText());
            }
        });
        view3.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent keyEvent) {
                number2=Integer.valueOf(view3.getText());
            }
        });


        LogicEvent logicEvent=new LogicEvent();
        Button button_add=new Button("+");
        button_add.setOnMouseClicked(logicEvent);
        gridPane.add(button_add,0,1);
        Button button_sub=new Button("-");
        button_sub.setOnMouseClicked(logicEvent);
        gridPane.add(button_sub,1,1);
        Button button_mul=new Button("*");
        button_mul.setOnMouseClicked(logicEvent);
        gridPane.add(button_mul,2,1);
        Button button_div=new Button("/");
        button_div.setOnMouseClicked(logicEvent);
        gridPane.add(button_div,3,1);

        Button button_c=new Button("C");
        button_c.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clean();
            }
        });
        gridPane.add(button_c,1,3);

        Button button_eq=new Button("=");
        button_eq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(logic==null)return;
                switch(logic){
                    case "+":
                        number3=number2+number1;
                        break;
                    case "-":
                        number3=number1-number2;
                        break;
                    case "*":
                        number3=number1*number2;
                        break;
                    case "/":
                        number3=number1/number2;
                        break;
                    default:
                        break;
                }
                view.setText(number3+"");
            }
        });
        gridPane.add(button_eq,2,3);
    }



    class LogicEvent implements EventHandler<Event>{
        @Override
        public void handle(Event event) {
            Button button=(Button)event.getSource();
            logic=button.getText();
            label1.setText(logic);
        }
    }

    void clean(){
        number1=0;
        number2=0;
        logic=null;
        view.setText("0");
    }
}