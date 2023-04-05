package Tablas;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class modeloTablaConsumosLv2 extends DefaultTableModel{
    
    public modeloTablaConsumosLv2(){
        addColumn("Codigo");
        addColumn("Concepto");
    }
    
    public void setDatos(ResultSet RS){
        try{
            while(RS.next()){
                Object fila[] = new Object[getColumnCount()];
                
                fila[intColumna("Codigo"    )] = RS.getInt  ("ID"       );
                fila[intColumna("Concepto"  )] = RS.getString   ("concepto" );
                
                addRow(fila);
            }
            RS.close();
        }catch(Exception exc){}
    }
    
    public int getCodigo(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Codigo")).toString());
    }
            
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(nom.equals(getColumnName(i)))
                return i;
        }
        return -1;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    @Override
    public Class<?> getColumnClass(int idx){
        if(idx == intColumna("Codigo"))
            return Integer.class;
        return super.getColumnClass(idx);
    }
    
}