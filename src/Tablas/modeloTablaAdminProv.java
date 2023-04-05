package Tablas;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminProv extends DefaultTableModel{
    
    public modeloTablaAdminProv(){
        addColumn("ID"          );
        addColumn("Proveedor"   );
        addColumn("Tel"         );
        addColumn("Correo"      );
    }
    
    public void setDatos(ResultSet proveedores){
        limpiaTabla();
        Object fila[] = new Object[getColumnCount()];
        try{
            while(proveedores.next()){
                fila[intColumna("ID"        )] = proveedores.getInt("ID");
                fila[intColumna("Proveedor" )] = proveedores.getString("proveedor");
                fila[intColumna("Tel"       )] = proveedores.getString("tel");
                fila[intColumna("Correo"    )] = proveedores.getString("correo");
                
                addRow(fila);
            }
            proveedores.close();
        }catch(Exception exc){}
    }
    
    public int getID(int fila){
        return (Integer) getValueAt(fila,intColumna("ID"));
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--)
            removeRow(i);
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nom))
                return i;
        }
        return -1;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    @Override
    public Class<?> getColumnClass(int index){
        if(index == intColumna("ID")){
            return Integer.class;
        }
        return super.getColumnClass(index);
    }
}