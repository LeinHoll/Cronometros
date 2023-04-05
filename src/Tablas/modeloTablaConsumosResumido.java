package Tablas;

import setters_getters.setGetConsumos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaConsumosResumido extends DefaultTableModel{
    
    public modeloTablaConsumosResumido(){
        addColumn("Concepto");
        addColumn("Coste"   );
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void setDatos(ArrayList<setGetConsumos> consumos){
        limpiaDatos();
        
        Object Fila[] = new Object[getColumnCount()];
        
        for(int i = 0 ; i < consumos.size() ; i++){
            Fila[0] = consumos.get(i).getConcepto();
            Fila[1] = consumos.get(i).getTotal();
            
            addRow(Fila);
        }
    }
    
    public void limpiaDatos(){
        for(int j = getRowCount() -1 ; j >= 0 ; j--)
            removeRow(j);
    }
}