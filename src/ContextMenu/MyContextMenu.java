package ContextMenu;

import Layout.Field.FieldLayout;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class MyContextMenu extends ContextMenu {
    public MyContextMenu() {
        super();
        MenuItem copy = new MenuItem("Kopiuj");
        copy.setOnAction(event -> copy());
        getItems().add(copy);
    }
    private void copy(){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(FieldLayout.textField.getText());
        clipboard.setContent(content);
    }
}
