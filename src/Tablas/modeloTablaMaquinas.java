package Tablas;

import setters_getters.setGetMaquinas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaMaquinas extends DefaultTableModel {
    
    public modeloTablaMaquinas(){
        addColumn("Estado"  );
        addColumn("Tiempo"  );
        addColumn("Tarifa"  );
        addColumn("Consumos");
        addColumn("Prepago" );
        addColumn("Total"   );
    }
    
    @Override
    public boolean isCellEditable(int col, int row){
        return false;
    }
    
    public void agregaFila(setGetMaquinas maquina){
        Object Fila[] = {"0/0/default","0/0/00:00:00/- - -","0.00","0.00","0.00","0.00"};

        if(maquina.getTipo().equals("Cronometro"))
            Fila[0] = "0/0/" + maquina.getNombre();
        else
            Fila[0] = "1/0/" + maquina.getNombre();
        
        addRow(Fila);
    }
    
    public synchronized Object getValor(int fila, int columna){
        return getValueAt(fila,columna);
    }
    
    public synchronized void setValor(Object valor, int fila, int columna){
        setValueAt(valor,fila,columna);
    }
    
    public void reseteaTabla(ArrayList<setGetMaquinas> maquinas){
        for(int i = getRowCount() - 1 ; i >=0 ; i--)
            removeRow(i);
        
        for(int j = 0; j < maquinas.size() ; j++){
            agregaFila(maquinas.get(j));
        }
    }
}
