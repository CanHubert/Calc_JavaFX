package Layout.Buttons;

import Layout.Buttons.Left.Left_numbers;
import Layout.Buttons.Right.Right_math;
import javafx.geometry.Insets;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HBox_Content extends HBox {
    Pane right,  left;
    public HBox_Content(){
        setSpacing(15);

        left = new Left_numbers();
        right = new Right_math();
        setMargin(left,new Insets(0,0,0,20));
        getChildren().addAll(left,right);
    }
}
