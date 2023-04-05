package setters_getters;

public class setGetBanderaTarifa {
    
    public setGetBanderaTarifa(){}
    
    public setGetBanderaTarifa(int ID, int lapso, double precio){
        this.ID     = ID;
        this.lapso  = lapso;
        this.precio = precio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public int getLapso(){
        return lapso;
    }
    
    public void setPrecio(String coste){
        this.precio = Double.parseDouble(coste);
    }
    
    public void setPrecio(double coste){
        this.precio = coste;
    }
    
    public void setLapso(String max){
        this.lapso = Integer.parseInt(max);
    }
    
    public void setLapso(int lapso){
        this.lapso = lapso;
    }
    
    int ID;
    int lapso;
    double precio;
}
