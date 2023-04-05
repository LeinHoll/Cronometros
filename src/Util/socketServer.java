package Util;

import Frames.framePantalla;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.sql.ResultSet;
import java.util.ArrayList;

public class socketServer extends Thread {
    
    public socketServer(framePantalla frame){
        this.frame = frame;
        getIPPort();
    }
    
    private void getIPPort(){
        linker      = frame.getLinker();
        File dir    = new File("puerto.txt");
        try{
            if(dir.createNewFile()){
                PrintWriter pw = new PrintWriter(new FileWriter(dir));
                pw.write("1771");
                pw.close();
            } else {
                FileReader      fr = new FileReader(dir);
                BufferedReader  br = new BufferedReader(fr);
                puerto = Integer.parseInt(br.readLine());
                br.close();
                fr.close();
            }
        } catch(Exception exc){
            ouch.whoops("serverSocket()", exc);
            System.exit(0);
        }
    }
    
    @Override
    public void run(){
        while(true){
            try{
                ServerSocket servidor   = new ServerSocket(puerto);
                socketClient cliente    = new socketClient(servidor.accept(), frame);
                
                cliente.setName(cliente.getClientIP());
                cliente.start();
                
                validaCliente(cliente);
                               
                servidor.close();
            } catch(Exception exc){
                ouch.whoops("run()", exc);
            }
        }
    }
    
    private void validaCliente(socketClient cliente) {
        try {
            String SQL = ""
                    + "SELECT IP "
                    + "FROM Maquinas_Cronometros "
                    + "WHERE IP = '" + cliente.getClientIP() + "'";
            ResultSet RS = linker.consulta(SQL);

            if(!RS.next()){
                cliente.habla("salir");
            } else {
                ArrayList<Crono> Reloj = frame.getReloj();
                for(Crono reloj : Reloj){
                    if(reloj.getMaquina().getIP().equals(cliente.getClientIP())){
                        reloj.setCliente(cliente);
                        break;
                    }
                }
            }
            RS.close();
        } catch(NullPointerException exc){
        } catch(Exception exc){
            ouch.whoops("validaCliente(socketClient cliente)", exc);
        }
    }
    
    int             puerto  = 1771;
    Conector        linker  ;
    upsy            ouch    = new upsy("serverSocket");
    framePantalla   frame   ;
}