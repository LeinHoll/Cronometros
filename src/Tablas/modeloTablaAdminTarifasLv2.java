package Tablas;

import setters_getters.setGetBanderaTarifa;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminTarifasLv2 extends DefaultTableModel{
    
    public modeloTablaAdminTarifasLv2(){
        addColumn("Lapso" );
        addColumn("Precio");
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return freeze;
    }
    
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }
    
    public void agregaFila(){
        Object fila[] = {0,0};
        addRow(fila);
    }
    
    public void eliminaFila(int fila[]){
        for(int i = fila.length - 1 ; i >= 0 ; i--){
            removeRow(fila[i]);
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() -1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public int getLapso(int fila){
        return Integer.parseInt(getValueAt(fila, 0).toString());
    }
    
    public double getPrecio(int fila){
        return Double.parseDouble(getValueAt(fila, 1).toString());
    }
    
    public void setLapsosYPrecios(ArrayList<Integer> lapsos, ArrayList<Double> precios){
        limpiaTabla();
        
        for(int i = lapsos.size() - 1 ; i >= 0 ; i--){
            if(lapsos.get(i) == 0){
                lapsos.remove(i);
            }
        }
        
        for(int j = precios.size() - 1 ; j >= 0 ; j--){
            if(precios.get(j) == 0){
                precios.remove(j);
            }
        }
        
        int techo = 0;
        if(lapsos.size() <= precios.size()){
            techo = lapsos.size();
        } else {
            techo = precios.size();
        }
                
        for(int k = 0 ; k < techo ; k++){
            Object fila[] = {lapsos.get(k),precios.get(k)};
            addRow(fila);
        }
    }
    
    public void setBanderas(ArrayList<setGetBanderaTarifa> banderas){
        limpiaTabla();
        for(int i = 0 ; i < banderas.size() ; i++){
            Object fila[] = {banderas.get(i).getLapso(), banderas.get(i).getPrecio()};
            addRow(fila);
        }
    }
    
    boolean freeze = true;
}