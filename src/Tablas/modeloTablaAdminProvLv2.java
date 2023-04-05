package Tablas;

import setters_getters.setGetProdProv;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminProvLv2 extends DefaultTableModel{
    
    public modeloTablaAdminProvLv2(){
        addColumn("Producto");
        addColumn("Precio"  );
    }
    
    public void setDatos(ArrayList<setGetProdProv> productos){
        limpiaTabla();
        Object fila[] = new Object[getColumnCount()];
        for(int i = 0 ; i < productos.size() ; i++){
            setGetProdProv producto = productos.get(i);
            
            fila[intColumna("Producto"  )] = producto.getProducto();
            fila[intColumna("Precio"    )] = producto.getPrecio();
            
            addRow(fila);
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nom)){
                return i;
            }
        }
        return -1;
    }
    
    public double getPrecio(int fila){
        return Double.parseDouble(getValueAt(fila,intColumna("Precio")).toString());
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