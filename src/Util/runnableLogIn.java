package Util;

import Arranque.Inicio;
import Frames.frameLogIn;

public class runnableLogIn implements Runnable{
    
    public runnableLogIn(Inicio ini, Conector linker){
        this.ini    = ini;
        this.linker = linker;
    }
    
    @Override
    public void run(){
        login = new frameLogIn(ini, linker);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    Conector    linker  ;
    frameLogIn  login   ;
    Inicio      ini     ;
}