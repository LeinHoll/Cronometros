package Tablas;

import Util.upsy;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminUser extends DefaultTableModel{
    
    public modeloTablaAdminUser(){
        addColumn("ID");
        addColumn("Usuario");
    }
    
    public void setDatos(ResultSet RS){
        try{
            limpiaTabla();
            Object fila[] = new Object[getColumnCount()];
            while(RS.next()){
                fila[intColumna("ID"        )] = RS.getInt      ("ID"       );
                fila[intColumna("Usuario"   )] = RS.getString   ("usuario"  );
                
                addRow(fila);
            }
            RS.close();
        } catch(Exception exc){
            ouch.whoops("setDatos(ResultSet RS)", exc);
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public int getID(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("ID")).toString());
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nom))
                return i;
        }
        return -1;
    }
    
    @Override
    public Class<?> getColumnClass(int idx){
        if(idx == intColumna("ID"))
            return Integer.class;
        return super.getColumnClass(idx);
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    upsy ouch = new upsy("modeloTablaAdminUser");
}