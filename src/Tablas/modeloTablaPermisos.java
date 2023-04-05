package Tablas;

import setters_getters.setGetPermisos;
import javax.swing.table.DefaultTableModel;

public class modeloTablaPermisos extends DefaultTableModel {
    
    public modeloTablaPermisos(){
        String columnas[] = {
            "Area","Consulta","Edicion","Alta","Baja"
        };
        
        for(int j = 0 ; j < columnas.length ; j++)
            addColumn(columnas[j]);
        
        Object filas[][] = {
            {"Usuarios"     ,true, true, true, true},
            {"Maquinas"     ,true, true, true, true},
            {"Tarifas"      ,true, true, true, true},
            {"Almacen"      ,true, true, true, true},
            {"Proveedores"  ,true, true, true, true},
            {"Clientes"     ,true, true, true, true}
        };
        
        for(int i = 0 ; i < filas.length ; i++)           
            addRow(filas[i]);
    }
    
    public void setDatos(setGetPermisos permisos){
        limpiaTabla();
        Object filas[][] = {
            {"Usuarios"     , permisos.getBool_usu_con(), permisos.getBool_usu_mod(), permisos.getBool_usu_alt(), permisos.getBool_usu_baj()},
            {"Maquinas"     , permisos.getBool_maq_con(), permisos.getBool_maq_mod(), permisos.getBool_maq_alt(), permisos.getBool_maq_baj()},
            {"Tarifas"      , permisos.getBool_tar_con(), permisos.getBool_tar_mod(), permisos.getBool_tar_alt(), permisos.getBool_tar_baj()},
            {"Almacen"      , permisos.getBool_alm_con(), permisos.getBool_alm_mod(), permisos.getBool_alm_alt(), permisos.getBool_alm_baj()},
            {"Proveedores"  , permisos.getBool_pro_con(), permisos.getBool_pro_mod(), permisos.getBool_pro_alt(), permisos.getBool_pro_baj()},
            {"Clientes"     , permisos.getBool_cli_con(), permisos.getBool_cli_mod(), permisos.getBool_cli_alt(), permisos.getBool_cli_baj()}
        };
        
        for(int i = 0 ; i < filas.length ; i++)
            addRow(filas[i]);
    }
    
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }
    
    public void validaFila(int fila, int columna){
        if(columna == intColumna("Consulta") || columna == intColumna("Edicion")){
            setValueAt(false,fila,intColumna("Edicion"));
            setValueAt(false,fila,intColumna("Alta"));
            setValueAt(false,fila,intColumna("Baja"));
        }
    }
    
    public setGetPermisos getPermisos(){
        setGetPermisos permisos = new setGetPermisos();
        
        permisos.setUsu_con(boolToInt("Usuarios","Consulta" ));
        permisos.setUsu_mod(boolToInt("Usuarios","Edicion"  ));
        permisos.setUsu_alt(boolToInt("Usuarios","Alta"     ));
        permisos.setUsu_baj(boolToInt("Usuarios","Baja"     ));
        
        permisos.setMaq_con(boolToInt("Maquinas","Consulta" ));
        permisos.setMaq_mod(boolToInt("Maquinas","Edicion"  ));
        permisos.setMaq_alt(boolToInt("Maquinas","Alta"     ));
        permisos.setMaq_baj(boolToInt("Maquinas","Baja"     ));
        
        permisos.setTar_con(boolToInt("Tarifas","Consulta"  ));
        permisos.setTar_mod(boolToInt("Tarifas","Edicion"   ));
        permisos.setTar_alt(boolToInt("Tarifas","Alta"      ));
        permisos.setTar_baj(boolToInt("Tarifas","Baja"      ));
        
        permisos.setAlm_con(boolToInt("Almacen","Consulta"  ));
        permisos.setAlm_mod(boolToInt("Almacen","Edicion"   ));
        permisos.setAlm_alt(boolToInt("Almacen","Alta"      ));
        permisos.setAlm_baj(boolToInt("Almacen","Baja"      ));
        
        permisos.setPro_con(boolToInt("Proveedores","Consulta"  ));
        permisos.setPro_mod(boolToInt("Proveedores","Edicion"   ));
        permisos.setPro_alt(boolToInt("Proveedores","Alta"      ));
        permisos.setPro_baj(boolToInt("Proveedores","Baja"      ));
        
        permisos.setCli_con(boolToInt("Clientes","Consulta" ));
        permisos.setCli_mod(boolToInt("Clientes","Edicion"  ));
        permisos.setCli_alt(boolToInt("Clientes","Alta"     ));
        permisos.setCli_baj(boolToInt("Clientes","Baja"     ));
        
        return permisos;
    }
    
    private int boolToInt(String fil, String col){
        if(Boolean.parseBoolean(getValueAt(intFila(fil),intColumna(col)).toString()))
            return 1;
        else
            return 0;
    }
    
    public void limpiaTabla(){
        for(int i = getRowCount() -1 ; i >= 0 ; i--){
            removeRow(i);
        }
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(nom.equals(getColumnName(i)))
                return i;
        }
        return -1;
    }
    
    public int intFila(String nom){
        for(int i = 0 ; i < getRowCount() ; i++){
            if(getValueAt(i,intColumna("Area")).toString().equals(nom)){
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col == intColumna("Area"))
            return false;
        return freeze;
    }
    
    @Override
    public Class<?> getColumnClass(int idx){
        if(idx == intColumna("Area"))
            return super.getColumnClass(idx);
        else
            return Boolean.class;
    }
    
    boolean freeze;
}