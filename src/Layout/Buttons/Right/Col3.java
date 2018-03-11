package Layout.Buttons.Right;

import ButtonsMap.Buttons;
import Layout.Field.FieldLayout;
import Values.Value;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Col3 extends VBox {
    String[] chars = {"CE","√", "%","x²"};
   static public Button btn;


    Col3(){
        setSpacing(8);
        for(int i =0 ; i < chars.length; i++){
            btn = new Button(String.valueOf(chars[i]));
            btn.setPrefSize(50,50);
            btn.setFocusTraversable(false);
            {
                if(btn.getText().equals("CE"))
                { btn.getStyleClass().addAll("reset","resetCE");
                btn.setFont(new Font(4));}
                else
                    btn.getStyleClass().add("othersButtons");
            }
           // btn.getStyleClass().add("othersButtons");
            btn.setOnAction(ea ->{
                Button butn = (Button)ea.getSource();
                String btnSign = butn.getText();
                switch (btnSign){
                    case "√":{
                        String tmp = FieldLayout.getText().replace(',', '.');
                        double d = Double.valueOf(tmp);
                        Value.setValueAndShow(Math.sqrt(d));
                    }break;
                    case "x²": {
                        String tmp = FieldLayout.getText().replace(',', '.');
                        double d = Double.valueOf(tmp);
                        Value.setValueAndShow(Math.pow(d,2));
                    }break;
                    case "CE" :{
                        try{
                            //String tmp = FieldLayout.getText();
                            FieldLayout.setText("");
                            //tmp= FieldLayout.getText();
                            //Value.value = Double.valueOf(tmp.replace(',', '.'));
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

            });

            getChildren().add(btn);
        }

        Buttons.put(btn);

    }
}
