package Values;

import javafx.scene.control.Button;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conditions {
    public static boolean backspaceClicked = false;
    public static boolean plusMinusClicked = false;
    public static boolean signClicked = false;
    public static boolean numberClicked = false;
    public static boolean equalsClicked= false;
    public static boolean decimalClicked = false;
    public static boolean blockBackspace = false;

    public static void LastClicked(Button btn){
        String tmp = btn.getText();
        if(tmp.equals("⇐") && equalsClicked){
            blockBackspace = true;
        }else if(!tmp.equals("⇐")){
            blockBackspace  = false;
        }
        equalsClicked = false;
        decimalClicked = false;
        numberClicked = false;
        signClicked = false;
        backspaceClicked = false;
        plusMinusClicked = false;

        System.out.println(tmp);
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher(tmp);
        if(mat.matches()) numberClicked = true;
        else if(tmp.equals("=")) equalsClicked = true;
        else if (tmp.equals(",")) decimalClicked = true;
        else if (tmp.equals("±")) plusMinusClicked = true;
        else if (tmp.equals("⇐")) {
            backspaceClicked = true;
            System.out.println("wykryto backspace");}
        else {
            pat = Pattern.compile("[-/*+]");
            mat = pat.matcher(tmp);
            if(mat.matches()) signClicked = true;
        }

        printConditions();

    }

    public static void printConditions() {
        System.out.println("equalsClicked =" + equalsClicked
        + " decimal = " + decimalClicked + " clickedNumber = " + numberClicked + " signClicked =" + signClicked
        + " backspaceClicked = " + backspaceClicked + " plusminusClicked = " + plusMinusClicked);
    }
}
