package Util;

import setters_getters.setGetConsumos;
import setters_getters.setGetTarifas;
import setters_getters.setGetMaquinas;
import Tablas.modeloTablaMaquinas;
import Tablas.modeloTablaConsumos;
import Frames.framePantalla;
import Paneles.panelDetalles;
import Paneles.panelConsumosResumido;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Crono extends Thread{
    
    public Crono(framePantalla frame, setGetMaquinas maquina, int fila){
        this.maquina        = maquina;
        this.frame          = frame;
        this.fila           = fila;
        linker              = frame.getLinker();
        modelo              = frame.getModelo();
        panel_detalles      = frame.getPanelDetalles();
        panel_resumen       = frame.getPanelResumen();
        estado              = ESTADO_STANDBY;
        consumos            = new ArrayList(0);
        if(maquina.getTipo().equals("Maquina")){
            status          = STATUS_OFF;
        } else {
            status          = STATUS_NONE;
        }
    }
 
    @Override
    public void run(){
        fechaFinal = new Date();
        if(fechaBase == null)
            fechaBase = new Date();
        setEstado(ESTADO_RENTANDO);
        syncEstado();
        syncRenta();
        syncLimite();
        syncPrepago();
        frame.menuCambio();
        while(!freno){
            try{
                Thread.sleep(1000);
                if(estado == ESTADO_RENTANDO){
                    modelo.setValueAt(cronometro(), fila, 1);
                    calculos();
                    detalles();
                    pintaEstado();
                    unSegundo();
                }
            }catch (Exception exc){}
        }
    }
    
    public void freno(){
        freno = true;
    }
    
    public void limpiaDatos(){
        panel_detalles.setDefaults();
        panel_resumen .getModelo().limpiaDatos();
        defaultFila();
        setEstado(ESTADO_STANDBY);
    }
    
    public boolean getBoolEstado(){
        if(getEstado() != ESTADO_STANDBY)
            return true;
        return false;
    }
        
    public boolean getBoolFoto(){
        if(getBoolEstado() && getBoolStatus())
            return true;
        return false;
    }
    
    public boolean getBoolStatus(){
        if(getStatus() == STATUS_ON)
            return true;
        return false;
    }
    
    public boolean getBoolSystem(){
        if(getBoolStatus() && !getBoolEstado())
            return true;
        return false;
    }
    
    public socketClient getCliente(){
        return cliente;
    }
    
    public double getConsumo(){
        return consumo;
    }
    
    public ArrayList<setGetConsumos> getConsumos(){
        return consumos;
    }
    
    public Object[] getDatosFinales(){
        Object Datos[] = {
            0,
            "Tiempo de " + getMaquina().getNombre() + "(" + cronometro(tiempoTranscurrido) + ")",
            formato.format(tarifa),
            1,
            formato.format(tarifa)
        };
        return Datos;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public Date getFechaBase(){
        return fechaBase;
    }
    
    public Date getFechaInicial(){
        return fechaInicial;
    }
    
    public String getFormatoFechaInicial(){
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaInicial);
    }
    
    public String getFormatoHoraInicial(){
        return new SimpleDateFormat("HH:mm:ss").format(fechaInicial);
    }
    
    public String getFormatoHoraFinal(){
        return new SimpleDateFormat("HH:mm:ss").format(fechaFinal);
    }
    
    public int getFila(){
        return fila;
    }
    
    public framePantalla getFrame(){
        return frame;
    }
    
    public setGetMaquinas getMaquina(){
        return maquina;
    }
    
    public double getPrepago(){
        return prepago;
    }
    
    public double getTarifa(){
        return tarifa;
    }
    
    public setGetTarifas getTarifario(){
        return tarifario;
    }
    
    public int getTiempoLimite(){
        return TiempoLimite;
    }
    
    public long getTiempoTranscurrido(){
        return tiempoTranscurrido;
    }
    
    public double getTotal(){
        return total;
    }
    
    public boolean getTskmgr(){
        return tskmgr;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setCliente(socketClient cliente){
        this.cliente = cliente;
        cliente.setReloj(this);
        try{
            Thread.sleep(1000);
        } catch(Exception exc){}
        syncInicio();
        setStatus(STATUS_ON);
        syncEstado();
        syncRenta();
    }
    
    public void setConsumos(ArrayList<setGetConsumos> consumos){
        this.consumos = consumos;
        consumo = calculaConsumos();
        syncTarifa();
    }
    
    public void setConsumos(modeloTablaConsumos modelo, int iniFila){
        if(iniFila == DIAG_FIN_MAQUINA){
            setTarifa(modelo.getPrecio(0));
            modelo.removeRow(0);
        }
        new runnableConsumos(this,modelo).run();
    }
    
    public void setEstado(int estado){
        this.estado = estado;
        pintaEstado();
    }
    
    public void setFechaBase(Date fechaBase){
        this.fechaBase = fechaBase;
    }
    
    public void setFechaInicial(Date fechaInicial){
        this.fechaInicial = fechaInicial;
    }
    
    public void setFila(int fila){
        this.fila = fila;
    }
    
    public void setHoraInicial(Time hora){
        fechaInicial.setTime(hora.getTime());
    }
    
    public void setMaquina(setGetMaquinas maquina){
        this.maquina = maquina;
    }
    
    public void setPrepago(double prepago){
        this.prepago = prepago;
    }
    
    public void setStatus(int status){
        this.status = status;
        pintaEstado();
    }
    
    public void setTarifa(double tarifa){
        this.tarifa = tarifa;
    }
    
    public void setTarifario(setGetTarifas tarifario){
        this.tarifario = tarifario;
    }
    
    public void setTiempoLimite(int TiempoLimite){
        this.TiempoLimite = TiempoLimite;
    }
    
    public void setTiempoRescatado(long  tiempoRescatado){
        this.tiempoRescatado = tiempoRescatado;
    }
    
    public void setTskMgr(boolean tskmgr){
        this.tskmgr = tskmgr;
    }
    
    private void calculos(){
        total = tarifa + consumo - prepago;
        modelo.setValueAt(formato.format(tarifa) , fila, 2);
        modelo.setValueAt(formato.format(consumo), fila, 3);
        modelo.setValueAt(formato.format(prepago), fila, 4);
        modelo.setValueAt(formato.format(total)  , fila, 5);
    }
    
    private double calculaConsumos(){
        double totalcons = 0;
        
        for(int i = 0 ; i < consumos.size() ; i++){
            double precioFila   = consumos.get(i).getPrecio();
            double cantidadFila = consumos.get(i).getCantidad();
            
            totalcons += precioFila * cantidadFila;
        }
        return totalcons;
    }
    
    private String cronometro(){
        long tiempoTotal = 0;
        
        fechaFinal = new Date();
        
        tiempoTranscurrido = ( ( fechaFinal.getTime() - fechaBase.getTime() ) / 1000 ) + tiempoRescatado;
        
        if(TiempoLimite == 0)
            tiempoTotal = tiempoTranscurrido;
        else {
            tiempoTotal = TiempoLimite * 60 - tiempoTranscurrido;
            if(tiempoTotal <= 0){
                tiempoTotal = 0;
                setEstado(ESTADO_PAUSADO);
                syncEstado();
                syncRenta();
            } else if((tiempoTotal / 60 == 3 || tiempoTotal / 60 == 1) && tiempoTotal % 60 == 0){
                syncAdvertencia(tiempoTotal / 60);
            }
        }
        
        tarifa = tarifario.calculaTarifa(tiempoTranscurrido);
        
        if(tiempoTranscurrido == 1 || tiempoTranscurrido % 60 == 0)
            syncTarifa();
        
        syncTiempo(cronometro(tiempoTotal));
        
        return getTiempoLimite() + "/" + getEstado() + "/" + cronometro(tiempoTotal) + "/" + tarifario.getTarifa();
    }
    
    public String cronometro(long tiempo){
        String cronometro = "";
        long hrs = tiempo / 3600;
        long min = ( tiempo - hrs * 3600 ) / 60;
        long seg = tiempo % 60;
        
        cronometro  = (hrs < 10) ?  "0" + hrs : ""  + hrs;
        cronometro += (min < 10) ? ":0" + min : ":" + min;
        cronometro += (seg < 10) ? ":0" + seg : ":" + seg;
        
        return cronometro;
    }
    
    private void defaultFila(){
        String FilaReseteada[] = {"0/0/00:00:00/- - -", "0.00", "0.00", "0.00", "0.00"}; 
        for(int j = 0 ; j < FilaReseteada.length ; j++)
            modelo.setValueAt(FilaReseteada[j], fila, j + 1);
    }
    
    public void detalles(){
        if(frame.getActual() == fila){
            panel_detalles.setTitulo                (maquina.getNombre());
            panel_detalles.setLHoraInicio           (fechaInicial       );
            panel_detalles.setLTiempoTranscurrido   (cronometro(tiempoTranscurrido));
            panel_detalles.setLTiempoLimite         (TiempoLimite       );
            panel_detalles.setLTarifa               (tarifa             );
            panel_detalles.setLConsumo              (consumo            );
            panel_detalles.setLPrepago              (prepago            );
            panel_detalles.setLTotal                (total              );
            panel_resumen .getModelo().setDatos     (consumos           );
        }
    }
    
    public void unSegundo(){
        new runnableUnSegundo(this).run();
    }
    
    private void pintaEstado(){
        try{
            modelo.setValor(status + "/" + estado + "/" + maquina.getNombre(), fila, 0);
        }catch(Exception exc){}
    }
    
    public void syncAdvertencia(long minuto){
        try {
            cliente.habla("quedan " + minuto);
        } catch(Exception exc) {}
    }
    
    public void syncCaptura(){
        try {
            cliente.habla("captura");
        } catch(Exception exc){}
    }
        
    public void syncEstado(){
        try{
            switch(estado){
                case ESTADO_STANDBY : 
                        cliente.habla("bloquea " + ESTADO_STANDBY);   
                        cliente.habla("mute");    
                        break;
                case ESTADO_RENTANDO: 
                        cliente.habla("desbloquea");
                        cliente.habla("unmute");
                        break;
                case ESTADO_PAUSADO : 
                        cliente.habla("bloquea " + ESTADO_PAUSADO);
                        cliente.habla("mute");
                        break;
            }
        } catch(Exception exc){}
    }
    
    public void syncInicio(){
        try {
            cliente.habla("kiubos");
            cliente.habla("taskOff");
        } catch(Exception exc){}
    }
    
    public void syncLimite(){
        try {
            cliente.habla("setLimite " + cronometro(TiempoLimite * 60));
        } catch(Exception exc) {}
    }
    
    public void syncPrepago(){
        try {
            cliente.habla("setPrepago " + prepago);
        } catch(Exception exc) {}
    }
    
    public void syncProcesos(){
        try {
            cliente.habla("getProcesos");
        } catch(Exception exc) {}
    }
    
    public void syncRenta(){
        try{
            if(estado == ESTADO_RENTANDO){
                if(TiempoLimite == 0)   cliente.habla("renta libre" ); 
                else                    cliente.habla("renta limite");
                
                syncTarifa();
                syncPrepago();
            }
        } catch(Exception exc){}
    }
    
    public void syncSystema(int caso){
        try{
            switch(caso){
                case COMP_SHUTDOWN  : cliente.habla("apagar"    ); break;
                case COMP_RESTART   : cliente.habla("resetear"  ); break;
                case COMP_CERRAR    : cliente.habla("salir"     ); break;
            }
        } catch(Exception exc){}
    }
    
    public void syncTarifa(){
        try {
            double envio = tarifario.calculaTarifa(tiempoTranscurrido) + calculaConsumos();
            cliente.habla("setTarifa " + envio);
        } catch(Exception exc) {}
    }
    
    public void syncTiempo(String tiempo){
        try {
            cliente.habla("setTiempo " + tiempo);
        } catch(Exception exc) {}
    }
    
    public void syncTskmgr(){
        try{
            if(tskmgr)  cliente.habla("taskOff" );
            else        cliente.habla("taskOn"  );
        } catch(Exception exc){}
    }
    
    int                         fila                ;
    int                         estado              ;
    int                         status              ;
    int                         TiempoLimite        = 0;
    double                      consumo             = 0;
    double                      tarifa              = 0;
    double                      prepago             = 0;
    double                      total               = 0;
    long                        tiempoRescatado     = 0;
    long                        tiempoTranscurrido  = 0;
    boolean                     freno               = false;
    boolean                     token               = false;
    boolean                     tskmgr              = false;
    ArrayList<setGetConsumos>   consumos            ;
    Conector                    linker              ;
    Date                        fechaBase           ;
    Date                        fechaInicial        ;
    Date                        fechaFinal          ;
    DecimalFormat               formato             = new DecimalFormat("#,##0.00");
    framePantalla               frame               ;
    modeloTablaMaquinas         modelo              ;
    panelDetalles               panel_detalles      ;
    panelConsumosResumido       panel_resumen       ;
    setGetMaquinas              maquina             ;
    setGetTarifas               tarifario           ;
    socketClient                cliente             ;
    validaALaMexicana           mexicana            = new validaALaMexicana();
    public static final int     COMP_SHUTDOWN       = 0;
    public static final int     COMP_RESTART        = 1;
    public static final int     COMP_CERRAR         = 2;
    public static final int     DIAG_FIN_MAQUINA    = 5;
    public static final int     DIAG_CONSUMOS       = 6;
    public static final int     ESTADO_STANDBY      = 0;
    public static final int     ESTADO_RENTANDO     = 1;
    public static final int     ESTADO_PAUSADO      = 2;
    public static final int     STATUS_NONE         = 0;
    public static final int     STATUS_OFF          = 1;
    public static final int     STATUS_ON           = 2;
    public static final boolean TSK_ON              = true;
    public static final boolean TSK_OFF             = false;
}