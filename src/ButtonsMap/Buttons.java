package ButtonsMap;

import javafx.scene.control.Button;

import java.util.Map;
import java.util.TreeMap;

public class Buttons  {
    static private Map<String, Button> map = new TreeMap<>();


    public static void put(Button btn){
        map.put(btn.getText(), btn);
    }

    public static Button get(String name){
        return map.get(name);
    }


}
