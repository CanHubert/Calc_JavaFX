package Values;

import Layout.Buttons.Right.Col1;
import Layout.Field.FieldLayout;
import com.sun.istack.internal.NotNull;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Value {
    public static double value =0;
    public static double lastValue =0;

    //wyisuje liczby w polu tekstowym
    public static void addValue(String s){
        if(Conditions.signClicked) {FieldLayout.setText(""); Conditions.signClicked = false;}
        Pattern pat = Pattern.compile("[1-9,]");
        Matcher mat = pat.matcher(s);
        boolean match = mat.matches();
        String prev = FieldLayout.getText();
        if(prev.equals("0") && match) {FieldLayout.setText(s); return;}
        else if(prev.length()>0) if(prev.charAt(0) == '0' && s.equals("0") && !Conditions.decimalClicked) return;
        if(prev.length() > 15) return;
        FieldLayout.setText(prev + s);

    }
// ustawia wartosci value i lastvalue, gdzie value oznacza 1 wprowadzona liczbe oraz stan aktualnej liczby, a lastvalue oznacza ostatnia wprowadzona liczbe
    public static void setLastValue(){
        try{
            String prev = FieldLayout.getText();

            if(Col1.sign.equals("") || Conditions.equalsClicked){
                value = Double.valueOf(prev.replace(',', '.'));
                System.out.println("+- cilcked");
            }
            else{
                lastValue = Double.valueOf(prev.replace(',', '.'));
               // Left_numbers.clickedNumber = true;
            }
            printValues();
        }catch (Exception e){
            System.out.println("Błąd w setLastValue()");
        }
    }


    public static void setValueAndShow(double v){
        if(v%1 == 0 ) {FieldLayout.setText(String.valueOf((long)v));
            System.out.println("long");}
        else  {
            Formatter fmt = new Formatter();
            String tmp = String.valueOf(v);
            tmp = (tmp.length() > 10) ? fmt.format("%.4f", v).toString() : tmp;
            FieldLayout.setText(cutZeros(tmp));}
    }

    public static void resetValues(){
        lastValue =0;
        value =0;
    }
    @NotNull
    private static String cutZeros(String s){
        while(s.charAt(s.length()-1)== '0'){
            s = s.substring(0, s.length()-1);
        }
        return s;
    }

    public static void printValues (){
        System.out.println("Value = " + value + " lastvalue = " +lastValue );
    }






}
