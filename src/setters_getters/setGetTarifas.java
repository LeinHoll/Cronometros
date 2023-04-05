package setters_getters;

import java.sql.ResultSet;
import java.util.ArrayList;

public class setGetTarifas {
    
    public setGetTarifas(){
        lapso   = 30;
        precio  = 8;
        tarifa  = "default";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public int getLapso() {
        return lapso;
    }

    public void setLapso(int lapso) {
        this.lapso = lapso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setBanderas(ResultSet RSBanderas){
        banderas.clear();
        try{
            while(RSBanderas.next()){
                setGetBanderaTarifa bandera = new setGetBanderaTarifa();
                
                bandera.setID       (RSBanderas.getInt("ID"));
                bandera.setLapso    (RSBanderas.getInt("lapso"));
                bandera.setPrecio   (RSBanderas.getDouble("precio"));
                
                banderas.add(bandera);
            }
            
            RSBanderas.close();
        }catch(Exception exc){}
    }
    
    public ArrayList<setGetBanderaTarifa> getBanderas(){
        return banderas;
    }
    
    public double calculaTarifa(long tiempoTranscurrido){        
        for(int i = 0 ; i < banderas.size() ; i++)
            if(banderas.get(i).getLapso() * 60 >= tiempoTranscurrido){             
                return banderas.get(i).getPrecio();
            } else {
                ultimoLapso     = banderas.get(i).getLapso();
                ultimoPrecio    = banderas.get(i).getPrecio();
            }
        
        double calculo = ultimoPrecio + ( Math.ceil( ((double)tiempoTranscurrido / 60.0 - (double)ultimoLapso ) / (double)lapso ) ) * precio;
        
        if(calculo == 0)
            return precio;
        else
            return calculo;
    }
    
    int                             ID              ;
    int                             lapso           ;
    int                             ultimoLapso     = 0;
    double                          ultimoPrecio    = 0;
    double                          precio          ;
    String                          tarifa          ;
    ArrayList<setGetBanderaTarifa>  banderas        = new ArrayList();
}