package Tablas;

import setters_getters.setGetProdServ;
import Util.validaALaMexicana;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class modeloTablaAdminPS extends DefaultTableModel{
    
    public modeloTablaAdminPS(){}
    
    public modeloTablaAdminPS(int caso){
        this.caso = caso;
        switch(caso){
            case CUALQUIERA:
                addColumn("ID"      );
                addColumn("Tipo"    );
                addColumn("Concepto");
                addColumn("Precio"  );
                break;
            case SERVICIOS:
                addColumn("ID"      );
                addColumn("Concepto");
                addColumn("Precio"  );
                break;
            case PRODUCTOS:
                addColumn("ID"      );
                addColumn("Concepto");
                addColumn("Precio"  );
                addColumn("Stock"   );
                addColumn("Min"     );
                addColumn("Max"     );
                break;
            case NUEVOS:
                addColumn("Tipo"    );
                addColumn("Concepto");
                addColumn("Precio"  );
                addColumn("Stock"   );
                addColumn("Min"     );
                addColumn("Max"     ); 
                filaVacia();
                break;
        }
    }
    
    public final void filaVacia(){
        Object fila[] = {"Servicio","",0.0,0,0,0};
        addRow(fila);
    }
    
    public void setDatos(ArrayList<setGetProdServ> archivos){
        indices.clear();
        limpiaTabla();
        
        for(int j = 0 ; j < archivos.size() ; j++){
            setGetProdServ archivo = archivos.get(j);
            switch(caso){
                case CUALQUIERA:
                    addRow(ordenaFila(archivo)); 
                    indices.add(j);
                    break;
                case SERVICIOS:
                    if(archivo.getTipo().equals("Servicio")){
                        addRow(ordenaFila(archivo));
                        indices.add(j);
                    }
                    break;
                case PRODUCTOS:
                    if(archivo.getTipo().equals("Producto")){
                        addRow(ordenaFila(archivo));
                        indices.add(j);
                    }
                    break;
            }
        }
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    private Object[] ordenaFila(setGetProdServ archivo){
        Object fila[] = new Object[getColumnCount()];
        for(int j2 = 0 ; j2 < getColumnCount() ; j2++){
            String nom = getColumnName(j2);
            if(nom.equals("ID"              )){
                fila[intColumna("ID"        )] = archivo.getID();
            } else if(nom.equals("Tipo"     )){
                fila[intColumna("Tipo"      )] = archivo.getTipo();
            } else if(nom.equals("Concepto" )){
                fila[intColumna("Concepto"  )] = archivo.getConcepto();
            } else if(nom.equals("Precio"   )){
                fila[intColumna("Precio"    )] = archivo.getPrecio();
            } else if(nom.equals("Stock"    )){
                fila[intColumna("Stock"     )] = archivo.getStock();
            } else if(nom.equals("Min"      )){
                fila[intColumna("Min"       )] = archivo.getMinStock();
            } else if(nom.equals("Max"      )){
                fila[intColumna("Max"       )] = archivo.getMaxStock();
            }
        }
        return fila;
    }
    
    public int getIndice(int fila){
        return indices.get(fila);
    }
    
    public String getTipo(int fila){
        return getValueAt(fila,intColumna("Tipo")).toString();
    }
    
    public String getConcepto(int fila){
        return getValueAt(fila,intColumna("Concepto")).toString();
    }
    
    public double getPrecio(int fila){
        return mexicanada(getValueAt(fila, intColumna("Precio")).toString());
    }
        
    public int getStock(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Stock")).toString());
    }
    
    public int getMinStock(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Min")).toString());
    }
    
    public int getMaxStock(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Max")).toString());
    }
    
    public int intColumna(String nombre){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nombre)){
                return i;
            }
        }
        return -1;
    }
    
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }
    
    private double mexicanada(String valor){
        try{
            return Double.parseDouble(valor);
        }catch(Exception exc){
            valor = mexicana.mexicanaDecimal(valor);
            return Double.parseDouble(valor);
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col == intColumna("ID") || (
                caso == NUEVOS && getValueAt(row,intColumna("Tipo")).equals("Servicio") && (
                        col == intColumna("Stock")
                    ||  col == intColumna("Min")
                    ||  col == intColumna("Max")
                    )
                )
            ){
            return false;
        }
        return freeze;
    }

    @Override
    public Class<?> getColumnClass(int index) {
        if(index == intColumna("ID"))
            return Integer.class;
        else if(index == intColumna("Precio"))
            return Double.class;
        return super.getColumnClass(index);
    }
    
    public static final int CUALQUIERA  = 0;
    public static final int SERVICIOS   = 1;
    public static final int PRODUCTOS   = 2;
    public static final int NUEVOS      = 3;
    int                     caso        = 0;
    boolean                 freeze      = true;
    ArrayList<Integer>      indices     = new ArrayList();
    validaALaMexicana       mexicana    = new validaALaMexicana();
}
