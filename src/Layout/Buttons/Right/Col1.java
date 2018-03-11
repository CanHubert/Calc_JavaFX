package Layout.Buttons.Right;

import ButtonsMap.Buttons;
import Layout.Buttons.Left.Left_numbers;
import Values.Conditions;
import Values.Value;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class Col1 extends VBox {
    private char[] chars = {'+','-','*','/'};
    public static String sign="";
    public static Button btn;

    public Col1(){
        setSpacing(8);
        for(int i =0 ; i < chars.length; i++){
            btn = new Button(String.valueOf(chars[i]));
            btn.setPrefSize(50,50);
            btn.setFocusTraversable(false);
            btn.getStyleClass().add("othersButtons");
            btn.setOnAction(ea->{
                Button butn = (Button)ea.getSource();
                String btnSign = butn.getText();
                MathMethod1();
                switch (btnSign){
                    case "+":{ sign = "add"; }break;
                    case "-":{ sign = "substract"; }break;
                    case "*":{ sign = "multiply"; }break;
                    case "/":{ sign = "divide"; }break;
                }
                MathMethod2();
                Conditions.LastClicked(butn);

            });
            getChildren().add(btn);
            Buttons.put(btn);
        }
    }

    public static void doCalculations(){
        try{
            switch (sign){
                case "add" : { Value.value += Value.lastValue; }break;
                case "substract" : { Value.value -= Value.lastValue; }break;
                case "multiply" : { Value.value *= Value.lastValue; }break;
                case "divide" : {
                    if(Value.lastValue == 0) {Value.value =0; break;}
                    Value.value /= Value.lastValue; }break;
            }
            //System.out.println("value = " + Value.value);
            Value.setValueAndShow(Value.value);
            Value.printValues();
        }catch (Exception e){

        }

    }
    public static void reset(){
        sign = "";
        Left_numbers.unCheck();
    }

    public static void MathMethod1(){
        if(!Conditions.equalsClicked) Value.setLastValue();

        if(Conditions.numberClicked && !Conditions.equalsClicked) {
            doCalculations();

        }// wykonuje obliczenia
    }


    public static void MathMethod2(){
        Left_numbers.unCheck();
        Value.printValues();
    }
}
