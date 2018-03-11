package Layout.Buttons.Right;

import javafx.scene.layout.HBox;

public class Right_math extends HBox {

    public Right_math(){
        setSpacing(8);
        getChildren().addAll(new Col1(), new Col2(), new Col3());
    }
}
