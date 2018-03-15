package Layout.Buttons.Left;

import ButtonsMap.Buttons;
import Layout.Buttons.Right.Col1;
import Layout.Buttons.Right.Col2;
import Layout.Field.FieldLayout;
import Values.Conditions;
import Values.Value;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Left_numbers extends FlowPane {
    private char[] chars = {'7','8','9','4','5','6','1','2','3',',','0','='};
    public static Button btn;

    public Left_numbers(){
        setAlignment(Pos.CENTER);
        setPrefWidth(170);
        setHgap(8);
        setVgap(8);
        for(int i = 0; i < chars.length; i++){
            btn = new Button(String.valueOf(chars[i]));
            //btn.setPrefSize(50,50);
            btn.setFocusTraversable(false);
            {//dodawanie stylu do cyferek
                Pattern pat = Pattern.compile("[0-9]");
                Matcher mat = pat.matcher(btn.getText());
                if(mat.matches())
                    btn.getStyleClass().addAll("numbers");
                else
                    btn.getStyleClass().add("othersButtons");
            }
            btn.setOnAction(ea->{
                Button button = (Button) ea.getSource();
                if(!(button.getText().equals(",")) && !(button.getText().equals("="))){// wybrana została cyfra
                    if(Conditions.equalsClicked) Col2.resetAll();
                    Value.addValue(button.getText());
                    //equalsClicked= false;

                }
                if(button.getText().equals("=")){
                    if(!Conditions.equalsClicked)Value.setLastValue();
                    Value.printValues();
                    Col1.doCalculations();
                    Conditions.equalsClicked = true;
                    Conditions.signClicked = false;
                    unCheckNumbers();
                }
                if(button.getText().equals(",")){
                    if(Conditions.equalsClicked) Col2.resetAll();
                    if(Conditions.signClicked){
                        System.out.println("przecinek when sign clicked");
                        FieldLayout.setText("0,");
                    }
                    else if(!FieldLayout.getText().contains(",")){
                        if(FieldLayout.getText().equals(""))
                            FieldLayout.setText("0");
                        FieldLayout.setText(FieldLayout.getText()+',');
                    }

                }
                Conditions.LastClicked(button);
            });
            if(btn!= null)

            Buttons.put(btn);
            getChildren().add(btn);
        }
    }
    public static void unCheckNumbers(){
        Conditions.numberClicked = false;
        Conditions.decimalClicked = false;
    }
}
