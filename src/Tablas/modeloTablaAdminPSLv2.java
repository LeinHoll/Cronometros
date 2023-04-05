package Tablas;

import setters_getters.setGetProdProv;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminPSLv2 extends DefaultTableModel{
    
    public modeloTablaAdminPSLv2(){
        addColumn("Proveedor"   );
        addColumn("Precio"      );
    }
    
    public void setDatos(ArrayList<setGetProdProv> proveedores){
        limpiaTabla();
        Object fila[] = new Object[getColumnCount()];
        for(int i = 0 ; i < proveedores.size() ; i++){
            setGetProdProv prov = proveedores.get(i);
            
            fila[intColumna("Proveedor" )] = prov.getProveedor();
            fila[intColumna("Precio"    )] = prov.getPrecio();
            
            addRow(fila);
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public double getPrecio(int fila){
        return Double.parseDouble(getValueAt(fila,intColumna("Precio")).toString());
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nom)){
                return i;
            }
        }
        return -1;
    }
    
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col == intColumna("Precio"))
            return freeze;
        return false;
    }
    
    @Override
    public Class<?> getColumnClass(int index){
        if(index == intColumna("Precio"))
            return Double.class;
        return super.getColumnClass(index);
    }
    
    boolean freeze = true;
}