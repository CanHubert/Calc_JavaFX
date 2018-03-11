package Layout;

import Keys.KeysEvent;
import Layout.Buttons.HBox_Content;
import Layout.Field.FieldLayout;
import Layout.Footer.Memory;
import Layout.MenuBar.MyMenuBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCalc extends Application{
     public static KeysEvent kEvent = new KeysEvent();
     public static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Kalkulator");
        VBox rootNode = new VBox(20);
        scene = new Scene(rootNode, 385,410) ;
        scene.getStylesheets().add("Layout/style.css");


        rootNode.getStyleClass().add("body");
        scene.setOnKeyPressed(kEvent);


        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        rootNode.getChildren().addAll(
                new MyMenuBar()
                ,new FieldLayout(340)
                ,new HBox_Content()
                ,new Memory()
        );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
