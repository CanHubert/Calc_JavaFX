package Keys;


import ButtonsMap.Buttons;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeysEvent implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();
        System.out.println("wartosc key = " + key);
        if(key.isDigitKey()){
            char tmp= ' ';
            char[] chars = key.getName().toCharArray();
            Pattern pat = Pattern.compile("[0-9]");
            Matcher mat ;
            for(char ch: chars){
                mat = pat.matcher(String.valueOf(ch));
                if(mat.matches()){
                    tmp=ch;
                    break;
                }
            }
            Buttons.get(String.valueOf(tmp)).fire();
        }
        else{
           switch(key){
               case DOWN:{Buttons.get("±").fire();}break;
               case ADD:{Buttons.get("+").fire();}break;
               case SUBTRACT:{Buttons.get("-").fire();}break;
               case MULTIPLY:{Buttons.get("*").fire();}break;
               case DIVIDE:{Buttons.get("/").fire();}break;
               case ENTER:{Buttons.get("=").fire();}break;
               case ESCAPE:{Buttons.get("C").fire();}break;
               case DECIMAL:{Buttons.get(",").fire();}break;
               case BACK_SPACE:{Buttons.get("⇐").fire();} break;
               default:{
                   System.out.println("Nie ma przypisanej akcji do tego przycisku");
               }
            }
        }
    }
}

