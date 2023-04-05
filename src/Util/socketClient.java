package Util;

import Frames.framePantalla;
import Frames.frameProcesos;
import Tablas.modeloTablaProcesos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class socketClient extends Thread {
    public socketClient(Socket cliente, framePantalla frame){
        this.cliente = cliente;
        this.frame = frame;
    }
    
    @Override
    public void run(){
        try{
            lector      = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            escritor    = new PrintWriter(cliente.getOutputStream(), true);
            
            escucha();
                        
            lector  .close();
            escritor.close();
            cliente .close();
        } catch(Exception exc){
            casosCliente(RELOJ_OFF);
        }
    }
    
    public String getClientIP(){
        return cliente.getInetAddress().getHostAddress();
    }
    
    public void setReloj(Crono reloj){
        this.reloj = reloj;
    }
    
    private void escucha(){
        try { 
            while((txt = lector.readLine()) != null){
                if(txt.equals("salir")){
                    casosCliente(RELOJ_OFF);
                    break;
                } else if(txt.startsWith("estado tskmgr")){
                    casosCliente(ESTADO_TSKMGR);
                } else if(txt.startsWith("setTiempo")){
                    casosCliente(SET_TIEMPO);
                } else if(txt.equals("kiubos")){
                    casosCliente(GET_TIEMPO);
                } else if(txt.equals("captura")){
                    recibeCaptura captura = new recibeCaptura(
                                                reloj.getMaquina().getIP(), 
                                                reloj.getMaquina().getNombre());
                    captura.start();
                } else if(txt.equals("tabla")){
                    mProcesos = new modeloTablaProcesos();
                } else if(txt.startsWith("fila")){
                    mProcesos.addFila(txt.replace("fila ", ""));
                } else if(txt.equals("fin tabla")){
                    muestraProcesos();
                } else if(txt.equals("procesos killed")){
                    try {
                        habla("getProcesos");
                    } catch(Exception exc){}
                } else if(txt.equals("new challenger")){
                    casosCliente(INSERT_A_COIN);
                }
            }
        } catch(Exception exc){
            casosCliente(RELOJ_OFF);
        }
    }
    
    private void muestraProcesos(){
        if(fProcesos != null && fProcesos.isVisible())
            fProcesos.setModelo(mProcesos);
        else {
            fProcesos = new frameProcesos(this);
            fProcesos.setModelo(mProcesos);
            fProcesos.setLocationRelativeTo(null);
            fProcesos.setVisible(true);
        }
    }
    
    private void casosCliente(int caso){
        try{
            switch(caso){
                case RELOJ_OFF: 
                    reloj.setStatus(Crono.STATUS_OFF);
                    break;
                case ESTADO_TSKMGR: 
                    reloj.setTskMgr(
                            Boolean.parseBoolean(
                                txt.replace("estado tskmgr ", "")
                            ));
                    break;
                case SET_TIEMPO: 
                    reloj.setTiempoRescatado(
                            Long.parseLong(
                                txt.replace("setTiempo ", "")
                            )); 
                    break;
                case GET_TIEMPO:
                    habla("getTiempo");
                    break;
                case INSERT_A_COIN:
                    if(reloj.getEstado() == Crono.ESTADO_STANDBY){
                        
                        reloj.setTiempoLimite   (15);
                        reloj.setPrepago        (5);
                        reloj.setTarifario      (frame.getTarifas().get(0));
                        reloj.setFechaInicial   (new Date());

                        String SQL = "INSERT INTO Renta_Activa "
                                + "(id_maquina, fecha, hora_inicio, prepago, "
                                + "tiempo_limite, id_tarifa, tiempo_transcurrido) "
                                + "VALUES "
                                + "("
                                + ""  + reloj.getMaquina().getID()     + ", "
                                + "'" + reloj.getFormatoFechaInicial() + "', "
                                + "'" + reloj.getFormatoHoraInicial()  + "', "
                                + ""  + reloj.getPrepago()             + ", "
                                + ""  + reloj.getTiempoLimite()        + ", "
                                + ""  + 1                              + ", "
                                + "0)";

                        frame.getLinker().ejecuta(SQL);
                        
                        reloj.start();
                        
                    } else {
                        reloj.setTiempoLimite(reloj.getTiempoLimite() + 15);
                        reloj.setPrepago(reloj.getPrepago() + 5);
                        reloj.setEstado(Crono.ESTADO_RENTANDO);
                        reloj.syncEstado();
                        reloj.syncRenta();
                        reloj.syncLimite();
                        reloj.syncPrepago();
                        reloj.unSegundo();
                    }
                    break;
             }
        }
        catch(Exception exc){
            ups.whoops("casosCliente", exc);
        }
    }
        
    
    public void habla(String txt) throws Exception{
        escritor.println(txt);
    }
    
    static final int    RELOJ_OFF       = 0;
    static final int    ESTADO_TSKMGR   = 1;
    static final int    SET_TIEMPO      = 2;
    static final int    GET_TIEMPO      = 3;
    static final int    INSERT_A_COIN   = 4;
    String              txt             ;
    BufferedReader      lector          ;
    Crono               reloj           ;
    frameProcesos       fProcesos       ;
    modeloTablaProcesos mProcesos       ;
    PrintWriter         escritor        ;
    Socket              cliente         ;
    framePantalla       frame           ;
    upsy                ups             = new upsy(this.getClass().toString());
}