package Tablas;

import setters_getters.setGetProdProv;
import Util.upsy;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaPuenteProdProv extends DefaultTableModel{
    
    public modeloTablaPuenteProdProv(int caso){
        addColumn("ID");
        this.caso = caso;
        switch(caso){
            case PROVEEDOR: addColumn("Producto" ); break;
            case PRODUCTO : addColumn("Proveedor"); break;
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public void setDatos(ResultSet registros){
        limpiaTabla();
        try{
            Object fila[] = new Object[getColumnCount()];
            while(registros.next()){
                switch(caso){
                    case PROVEEDOR:
                        fila[intColumna("ID")] = registros.getInt("ID");
                        fila[intColumna("Producto")] = registros.getString("concepto");
                        break;
                    case PRODUCTO:
                        fila[intColumna("ID")] = registros.getInt("ID");
                        fila[intColumna("Proveedor")] = registros.getString("proveedor");
                        break;
                }
                addRow(fila);
            }
            registros.close();
        }catch(Exception exc){
            ouch.whoops("setDatos(ResultSet registros)", exc);
        }
    }
    
    public void setDatos(ArrayList<setGetProdProv> registros){
        limpiaTabla();
        Object fila[] = new Object[getColumnCount()];
        for(int i = 0 ; i < registros.size() ; i++){
            switch(caso){
                case PROVEEDOR: 
                    fila[intColumna("ID"        )] = registros.get(i).getIdProdServ();
                    fila[intColumna("Producto"  )] = registros.get(i).getProducto();
                    break;
                case PRODUCTO:
                    fila[intColumna("ID"        )] = registros.get(i).getIdProveedor();
                    fila[intColumna("Proveedor" )] = registros.get(i).getProveedor();
                    break;
            }
            addRow(fila);
        }
    }
    
    public Object[] getFila(int fila){
        Object Fila[] = new Object[getColumnCount()];
        
        for(int i = 0 ; i < Fila.length ; i++){
            Fila[intColumna("ID")] = getID(fila);
            switch(caso){
                case PROVEEDOR:
                    Fila[intColumna("Producto"  )] = getProducto(fila);
                    break;
                case PRODUCTO:
                    Fila[intColumna("Proveedor" )] = getProveedor(fila);
                    break;
            }
        }
        
        return Fila;
    }
    
    public void addFila(Object fila[]){
        addRow(fila);
    }
    
    public int getID(int fila){
        return (Integer)getValueAt(fila,intColumna("ID"));
    }
    
    public String getProducto(int fila){
        return (String)getValueAt(fila,intColumna("Producto"));
    }
    
    public String getProveedor(int fila){
        return (String)getValueAt(fila,intColumna("Proveedor"));
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
    public Class<?> getColumnClass(int index){
        if(index == intColumna("ID"))
            return Integer.class;
        return super.getColumnClass(index);
    }
    
    int                     caso        ;
    public static final int PROVEEDOR   = 0;
    public static final int PRODUCTO    = 1;
    upsy                    ouch        = new upsy("modeloTablaPuenteProdProv");
}