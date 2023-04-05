package Arranque;

import Frames.framePantalla;
import Util.Conector;
import Util.runnableLogIn;
import javax.swing.UIManager;

public class Inicio {

    public Inicio(){
        Conector linker = new Conector();
        
        try {
            UIManager.LookAndFeelInfo infor[] = UIManager.getInstalledLookAndFeels();
            for(int i = 0 ; i < infor.length ; i++){
                if("Windows".equals(infor[i].getName())){
                    UIManager.setLookAndFeel(infor[i].getClassName());
                    break;
                }
            }
        } catch(Exception exc){}     
        
        runnableLogIn login = new runnableLogIn(this, linker);
        login.run();
        
        while(espera){
            synchronized (this){
                try{
                    wait();
                } catch(Exception exc){}
            }
        }
                        
        framePantalla pantalla = new framePantalla(linker);
        pantalla.setUsuario(ID);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }
    
    public static void main(String [] args){
        Inicio ini = new Inicio();
    }
    
    public void setEspera(boolean espera){
        this.espera = espera;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    int     ID      ;
    boolean espera  = true;
}