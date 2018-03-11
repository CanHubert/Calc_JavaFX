package Layout.MenuBar;

import Layout.MyCalc;

import javafx.scene.control.*;

import static javafx.application.Platform.exit;

public class MyMenuBar extends MenuBar {

    public MyMenuBar(){
        Menu fileMenu = new Menu("Plik");
       /// MenuItem open = new MenuItem("Otwórz");
        MenuItem close = new MenuItem("Zamknij");
        close.setOnAction(ea->{
            exit();
        });
        fileMenu.getItems().addAll(close);

       Menu colorMenu = new Menu("Motywy");
       RadioMenuItem defaultTheme = new RadioMenuItem("Podstawowy");
       RadioMenuItem TelAvivTheme = new RadioMenuItem("Cool and Calm");
       //RadioMenuItem
        defaultTheme.setSelected(true);

        ToggleGroup tg = new ToggleGroup();
        defaultTheme.setToggleGroup(tg);
        TelAvivTheme.setToggleGroup(tg);
        colorMenu.getItems().addAll(defaultTheme,TelAvivTheme);

        defaultTheme.setOnAction(ea->{
            MyCalc.scene.getStylesheets().removeAll("Layout/style.css","Layout/style3.css");
            MyCalc.scene.getStylesheets().add("Layout/style.css");
        });

        TelAvivTheme.setOnAction(ea->{
            MyCalc.scene.getStylesheets().removeAll("Layout/style.css","Layout/style3.css");
            MyCalc.scene.getStylesheets().add("Layout/style3.css");
        });



        getMenus().addAll(fileMenu,colorMenu);

    }
}
