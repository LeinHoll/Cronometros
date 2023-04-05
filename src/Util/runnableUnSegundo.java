package Util;

public class runnableUnSegundo implements Runnable{
    
    runnableUnSegundo(Crono reloj){
        this.reloj = reloj;
        ouch = new upsy("runnableUnSegundo() " + reloj.getMaquina().getNombre());
    }
    
    @Override
    public void run(){
        try{
            String SQL = "UPDATE Renta_Activa "
                    + "SET "
                    + "fecha = '"               + reloj.getFormatoFechaInicial  () + "', "
                    + "hora_inicio = '"         + reloj.getFormatoHoraInicial   () + "', " 
                    + "prepago = "              + reloj.getPrepago              () + ", "
                    + "tiempo_limite = "        + reloj.getTiempoLimite         () + ", "
                    + "id_tarifa = "            + reloj.getTarifario().getID    () + ", "
                    + "tiempo_transcurrido = "  + reloj.getTiempoTranscurrido   () + " "
                    + "WHERE id_maquina = "     + reloj.getMaquina().getID      ();
            
            reloj.getFrame().getLinker().ejecuta(SQL);
        } catch(Exception exc){
            ouch.whoops("run()", exc);
        }
    }
    
    Crono reloj;
    upsy ouch;
}