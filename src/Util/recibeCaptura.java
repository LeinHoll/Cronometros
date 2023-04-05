package Util;

import Frames.frameCaptura;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class recibeCaptura extends Thread {
    
    public recibeCaptura(String IP, String maquina){
        this.IP         = IP        ;
        this.maquina    = maquina   ;
    }
    
    @Override
    public void run(){
        try{
            Socket                  socket  = new Socket(IP, 1987);
            InputStream             is      = socket.getInputStream();
            BufferedOutputStream    bos     = new BufferedOutputStream(
                                                new FileOutputStream(maquina + ".png"));
            byte[]                  buffer  = new byte[1024];
            int                     largo   ;
            
            while((largo = is.read(buffer)) > -1)
                bos .write(buffer, 0 , largo);
            
            is      .close();
            bos     .close();
            socket  .close();
            
            frameCaptura frame = new frameCaptura(maquina);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }catch(Exception exc){}
    }
    
    String  IP      ;
    String  maquina ;
}