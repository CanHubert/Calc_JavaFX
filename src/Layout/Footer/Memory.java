package Layout.Footer;

import Layout.Field.FieldLayout;
import Values.Value;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

public class Memory extends HBox{
    public static double memory = 0;

    public Memory(){
        String[] names = {"MC", "MR", "M-", "M+", "MS"};
        for (String name : names) {
            Button btn = new Button(name);
            btn.setPrefSize(80, 50);
            btn.getStyleClass().add("footers");
           // btn.getStyleClass().removeAll("button");
            switch (name){
                case"MC": {btn.setTooltip(new Tooltip("Wyczyść pamięć"));}break;
                case"MR": {btn.setTooltip(new Tooltip("Pobierz pamięć"));}break;
                case"M-": {btn.setTooltip(new Tooltip("Odejmij od  pamięci"));}break;
                case"M+": {btn.setTooltip(new Tooltip("Dodaj do pamięci"));}break;
                case"MS": {btn.setTooltip(new Tooltip("Zapisz w pamięci"));}break;
            }
            btn.setOnAction(ea->{
                Button btnTemp = (Button)ea.getSource();
                switch (btnTemp.getText()){
                    case"MC": {memory=0;}break;
                    case"MR": {Value.setValueAndShow(memory);Value.setLastValue(); }break;
                    case"M-": {memory-= Double.valueOf(FieldLayout.getText().replace(',', '.'));}break;
                    case"M+": {memory+= Double.valueOf(FieldLayout.getText().replace(',', '.'));}break;
                    case"MS": {memory = Double.valueOf(FieldLayout.getText().replace(',', '.'));}break;
                }
            });

            getChildren().add(btn);
        }
    }
}
