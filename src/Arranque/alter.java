package Arranque;

import Util.Conector;

public class alter {
    public static void main(String [] args){
        Conector linker = new Conector();
        
        try{
            String SQL = "ALTER TABLE Usuarios "
                    + "ADD COLUMN usuario VARCHAR(50)";
                    
            linker.ejecuta(SQL);
            linker.cierra();
        }catch(Exception exc){
            /*System.out.println(exc.getCause());
            System.out.println(exc.getStackTrace());
            System.out.println(exc);*/
        }
    }
}