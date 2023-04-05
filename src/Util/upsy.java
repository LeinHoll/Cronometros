package Util;

import Dialogos.diagUpsy;

public class upsy {
    
    public upsy(String clase){
        this.clase = clase;
    }
    
    public void whoops(String metodo, Exception exc){
        diagUpsy ups = new diagUpsy(clase + " - " + metodo, exc);
        ups.setLocationRelativeTo(null);
        ups.setVisible(true);
    }

    String clase;
}