package com.example.demo;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HelloController {
    int number1;
    int number2;
    String logic;
    boolean flag;
    boolean eq;
    TextField view;

     void addPane(AnchorPane root) {
        view=new TextField("0");
        view.setMinSize(200,50);
        view.setLayoutX(30);
        view.setLayoutY(10);
        view.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(view);

        GridPane gridPane=new GridPane();
        gridPane.setLayoutY(75);
         gridPane.setLayoutX(30);
        gridPane.setHgap(24);
        gridPane.setVgap(10);
        root.getChildren().add(gridPane);

        NumberEvent numberEvent=new NumberEvent();
        ArrayList<Button>list=new ArrayList<>();
        for(int i=0;i<=9;i++){
            Button button=new Button(""+i);
            list.add(button);
            button.setOnMouseClicked(numberEvent);
            gridPane.add(button,i%3,i/3);
        }

        LogicEvent logicEvent=new LogicEvent();
        Button button_add=new Button("+");
        button_add.setOnMouseClicked(logicEvent);
        gridPane.add(button_add,3,0);
        Button button_sub=new Button("-");
        button_sub.setOnMouseClicked(logicEvent);
        gridPane.add(button_sub,3,1);
        Button button_mul=new Button("*");
        button_mul.setOnMouseClicked(logicEvent);
        gridPane.add(button_mul,3,2);
        Button button_div=new Button("/");
        button_div.setOnMouseClicked(logicEvent);
        gridPane.add(button_div,3,3);

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
                        number1=number2+number1;
                        break;
                    case "-":
                        number1=number1-number2;
                        break;
                    case "*":
                        number1=number1*number2;
                        break;
                    case "/":
                        number1=number1/number2;
                        break;
                    default:
                        break;
                }
                view.setText(number1+"");
                eq=true;
            }
        });
        gridPane.add(button_eq,2,3);
    }


    class NumberEvent implements EventHandler<Event>{
        @Override
        public void handle(Event event) {
            if(eq)clean();
            String text=view.getText();
            Button button=(Button)event.getSource();
            String num=button.getText();
            if(flag){
                text="0";
                flag=false;
            }
            text+=num;
            int res=Integer.valueOf(text);
            if(logic==null){
                number1=res;
                view.setText(number1+"");
            }
            else{
                number2=res;
                view.setText(number2+"");
            }
        }
    }

    class LogicEvent implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            Button button=(Button)event.getSource();
            logic=button.getText();
            flag=true;
            eq=false;
        }
    }
    void clean(){
        number1=0;
        number2=0;
        logic=null;
        flag=false;
        eq=false;
        view.setText("0");
    }
}