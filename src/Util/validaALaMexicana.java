package Util;

public class validaALaMexicana {

    public String mexicanaDecimal(String numDecimal){
       
        String losEnteros   = mexicanaEntera(numDecimal.substring(0, numDecimal.length() - 3));
        String losDecimales = numDecimal.substring(numDecimal.length() - 2);

        return losEnteros + "." + losDecimales;
    }
    
    public String mexicanaEntera(String numEntero){
        if(numEntero.contains(",") || numEntero.contains(".")){
            numEntero = numEntero.replace(",", "");
            numEntero = numEntero.replace(".", "");
        }
        return numEntero;
    }
}
