package Layout.Field;

import ContextMenu.MyContextMenu;
import Layout.MyCalc;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class FieldLayout extends FlowPane {
    public static TextField textField;
    MyContextMenu context = new MyContextMenu();

    public FieldLayout(int size){
        textField = new ValueTextField(size);
        getChildren().add(textField);
        setAlignment(Pos.CENTER);
        setOnContextMenuRequested(event -> context.show(this, event.getScreenX(), event.getScreenY()));
        setOnMouseClicked((event) -> context.hide());
    }
    public static void setText(String text){
        textField.setText(text.replace('.', ','));
    }
    public static String getText(){return textField.getText();}
    public static void reset(){textField.setText("");}
}
class ValueTextField extends TextField{
     ValueTextField(int size){
        setText("0");
        setDisable(true);
        setMaxWidth(360);
        setPrefWidth(size);
        setMinWidth(100);
        setPrefHeight(40);
        setPrefColumnCount(12);
        setFont(new Font(30));
        setAlignment(Pos.CENTER_RIGHT);
        setContextMenu(new MyContextMenu());


    }
}

