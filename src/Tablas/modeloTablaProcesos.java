package Tablas;

import javax.swing.table.DefaultTableModel;

public class modeloTablaProcesos extends DefaultTableModel {
    
    public modeloTablaProcesos(){
        addColumn("Seleccion"       );
        addColumn("Nombre de imagen");
        addColumn("PID"             );
        addColumn("RAM (KB)"        );
    }
    
    public boolean getSeleccion(int fila){
        return Boolean.parseBoolean(getValueAt(fila, intColumna("Seleccion")).toString());
    }
    
    public int getPID(int fila){
        return Integer.parseInt(getValueAt(fila, intColumna("PID")).toString());
    }
    
    public void addFila(String txt){
        if(!txt.contains("Nombre de imagen")){
            try {
                String campos[] = txt.split("\",\"");
                Object fila[] = new Object[getColumnCount()];
                for(int i = 0 ; i < fila.length ; i++){
                    switch(i){
                        case 0: fila[0] = false; break;
                        case 1: fila[1] = campos[0].replace("\"", ""); break;
                        case 2: fila[2] = Integer.parseInt(campos[1]); break;
                        case 3: fila[3] = Integer.parseInt(campos[4].replace(" KB\"", "").replace(",", "")); break;
                    }
                }
                    
                addRow(fila);
            } catch(Exception exc){}
        }
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(getColumnName(i).equals(nom))
                return i;
        }
        return -1;
    }
    
    @Override
    public Class<?> getColumnClass(int col){
        if(col == intColumna("PID") || col == intColumna("RAM (KB)"))
            return Integer.class;
        if(col == intColumna("Seleccion"))
            return Boolean.class;
        return super.getColumnClass(col);
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col == intColumna("Seleccion"))
            return true;
        return false;
    }
}