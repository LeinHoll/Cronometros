package Util;

import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class soloNumeros {
  
    public void soloDecimalTyped(KeyEvent evt, JFormattedTextField JFTF){
        int tecla = (int)evt.getKeyChar();
        boolean decimal = false;
        
        if(JFTF.getText().equals("0") && tecla != 46)
            JFTF.setText("");
        
        if(tecla == 10)
            JFTF.transferFocus();
        
        if(tecla == 46){
            if(JFTF.getText().contains(".")){
                if(Double.parseDouble(JFTF.getText()) == 0)
                    JFTF.setText("0" + evt.getKeyChar());
                else
                    JFTF.setText(JFTF.getText().replace(".", evt.getKeyChar() + ""));
                decimal = true;
            } else {
                decimal = false;
            }
        }
        
        if(soloNum(evt) <= -1){
            if(tecla == 46 && !decimal){}
            else {
                evt.consume();
            }
        }
        
    }
    
    public String soloDecimalReleased(JFormattedTextField JFTF){
        if(JFTF.getText().equals(""))
            JFTF.setText("0");
        
        return JFTF.getText().replace(",", "");
    }
    
    public int soloNum(KeyEvent evt){
        int tecla = (int)evt.getKeyChar();
        if((tecla < 48 || tecla > 57)
                && (tecla != KeyEvent.VK_BACK_SPACE)
                && (tecla != KeyEvent.VK_ENTER))
            return -1;
        return tecla;
    }
}
