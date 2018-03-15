package Layout.Buttons.Right;


import ButtonsMap.Buttons;
import Layout.Field.FieldLayout;
import Values.Conditions;
import Values.Value;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Col2 extends VBox {
     private char[] chars = {'⇐','C','±', '%'};
     private Button btn;


    public Col2(){
        setSpacing(8);
        for(int i =0 ; i < chars.length; i++){
            btn = new Button(String.valueOf(chars[i]));
            btn.setPrefSize(50,50);
            btn.setFocusTraversable(false);
            {//dodawanie stylu do cyferek
                Pattern pat = Pattern.compile("[⇐C]");
                Matcher mat = pat.matcher(btn.getText());
                if(mat.matches())
                    btn.getStyleClass().addAll("reset");
                else
                    btn.getStyleClass().add("othersButtons");
            }
            btn.getStyleClass().add("othersButtons");
            btn.setOnAction(ea->{
                Button butn = (Button)ea.getSource();
                String sign = butn.getText();

                switch (sign){
                    case "C":{
                        resetAll();
                        FieldLayout.setText("0");
                    }break;
                    case "±": {
                        String tmp = FieldLayout.getText();
                        if(tmp.equals("0")) break;
                        if(tmp.charAt(0)== '-'){ FieldLayout.setText(tmp.substring(1, tmp.length())); }
                        else{ FieldLayout.setText("-"+tmp); }
                        Value.setLastValue();
                    }break;
                    case "⇐" :{
                        try{
                            if(!Conditions.blockBackspace){
                                String tmp = FieldLayout.getText();
                                FieldLayout.setText(tmp.substring(0,tmp.length()-1));
                               // tmp= FieldLayout.getText();
                                //Value.value = Double.valueOf(tmp.replace(',', '.'));
                            }
                        }catch (Exception e){
                            System.out.println("Nie ma co usuwać");
                        }
                    }break;
                    case "%" :{
                        try{
                            String tmp = FieldLayout.getText().replace(',', '.');
                            double d = Double.valueOf(tmp);
                            Value.setValueAndShow((d/100)*Value.value);
                           // FieldLayout.setText(String.valueOf();

                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }break;
                }
                Conditions.LastClicked(butn);

            });
            getChildren().add(btn);
            Buttons.put(btn);
        }

    }

    public static void resetAll(){
        FieldLayout.reset();
        Col1.reset();
        Value.resetValues();
    }
}
