package Tablas;

import Util.Crono;
import setters_getters.setGetMaquinas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminMaquinas extends DefaultTableModel{
    
    public modeloTablaAdminMaquinas(ArrayList<Crono> Relojes){
        this.Relojes = Relojes;
        
        addColumn("Tipo");
        addColumn("Nombre");
        addColumn("IP");
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(getValueAt(row,0).equals("Cronometro") && col == 2)
            return false;
        if(row >= 0 
                && row < Relojes.size() 
                && Relojes.get(row).getEstado() != Crono.ESTADO_STANDBY){
            return false;
        }
        return freeze;
    }
    
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }
    
    public void agregaFilaVacia(){
        Object Fila[] = {"Cronometro","","0"};
        addRow(Fila);
    }
    
    public void agregaMaquina(setGetMaquinas maquina){
        Object Fila[] = {maquina.getTipo(), maquina.getNombre(), maquina.getIP()};
        addRow(Fila);
    }
    
    public void quitaFilas(int fila[]){
        for(int i = fila.length - 1 ; i >=0 ; i--){
            removeRow(fila[i]);
        }
    }
        
    boolean             freeze = false;
    ArrayList<Crono>    Relojes;
}