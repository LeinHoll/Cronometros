package Tablas;

import setters_getters.setGetConsumos;
import Util.validaALaMexicana;
import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class modeloTablaConsumos extends DefaultTableModel{
        
    public modeloTablaConsumos(JLabel LTotal){
        this.LTotal = LTotal;
        
        addColumn("Codigo"  );
        addColumn("Concepto");
        addColumn("Precio"  );
        addColumn("Cantidad");
        addColumn("Total"   );
        
        addRow(filaVacia);
    }
    
    public modeloTablaConsumos(ArrayList<setGetConsumos> consumos, JLabel LTotal){
        this.LTotal = LTotal;
        
        addColumn("Codigo"  );
        addColumn("Concepto");
        addColumn("Precio"  );
        addColumn("Cantidad");
        addColumn("Total"   );
        
        this.consumos = consumos;
        enComun();
    }
    
    public modeloTablaConsumos(ArrayList<setGetConsumos> consumos, Object datosFinales[], JLabel LTotal){
        this.LTotal  = LTotal;
        
        addColumn("Codigo"  );
        addColumn("Concepto");
        addColumn("Precio"  );
        addColumn("Cantidad");
        addColumn("Total"   );
        
        terminandoMaquina = true;
        addRow(datosFinales);
        
        this.consumos = consumos;
        enComun();
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(row == 0 && terminandoMaquina && col != intColumna("Precio"))
            return false;
        if(col == intColumna("Total"))
            return false;
        else if((col == intColumna("Cantidad") || col == intColumna("Precio")) && getConcepto(row).equals(""))
            return false;
        else if(col == intColumna("Concepto") && getCodigo(row) != 0)
            return false;
        return true;
    }
    
    @Override
    public Class<?> getColumnClass(int idx){
        if(idx == intColumna("ID") || idx == intColumna("Cantidad"))
            return Integer.class;
        else if(idx == intColumna("Precio"))
            return Double.class;
        return super.getColumnClass(idx);
    }
    
    public int intColumna(String nom){
        for(int i = 0 ; i < getColumnCount() ; i++){
            if(nom.equals(getColumnName(i))){
                return i;
            }
        }
        return -1;
    }
    
    public Integer getCantidad(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Cantidad")).toString());
    }
    
    public int getCodigo(int fila){
        return Integer.parseInt(getValueAt(fila,intColumna("Codigo")).toString());
    }
    
    public void setCodigo(int fila){
        setValueAt(0, fila, intColumna("Codigo"));
    }
    
    public String getConcepto(int fila){
        return getValueAt(fila,intColumna("Concepto")).toString();
    }
    
    public void setConcepto(String valor, int fila){
        setValueAt(valor, fila, intColumna("Concepto"));
    }
    
    public double getPrecio(int fila){        
        return mexicanada(getValueAt(fila, intColumna("Precio")).toString());
    }
    
    public void setPrecio(double valor, int fila){
        setValueAt(valor, fila, intColumna("Precio"));
    }
    
    public double getTotal(int fila){
        return mexicanada(getValueAt(fila, intColumna("Total")).toString());
    }
    
    public double getTotalTabla(){
        return totalTabla;
    }
    
    public void agregaFilaVacia(){
        addRow(filaVacia);
    }
    
    public void calculaTotales(){
        totalTabla = 0;
        for(int i = 0 ; i < getRowCount() ; i++){
            double precio    = getPrecio(i);
            double cantidad  = getCantidad(i).doubleValue();
            double totalFila = precio * cantidad;
            setValueAt(formato.format(totalFila),i,intColumna("Total"));
            
            totalTabla += totalFila;
        }
        
        LTotal.setText("$ " + formato.format(totalTabla));
    }
    
    private void enComun(){
        Object Fila[] = new Object[getColumnCount()];
        for(int i = 0 ; i < consumos.size() ; i++){
            setGetConsumos getting = consumos.get(i);
            Fila[0] = getting.getCodigo();
            Fila[1] = getting.getConcepto();
            Fila[2] = formato.format(getting.getPrecio());
            Fila[3] = getting.getCantidad();
            Fila[4] = formato.format(getting.getTotal());
            
            addRow(Fila);
        }
        
        addRow(filaVacia);
        calculaTotales();
    }
   
    public boolean validaFila(int fila){
        for(int i = 1 ; i < filaVacia.length - 1 ; i++)
            if(getValueAt(fila,i).equals(filaVacia[i]))
                return false;
        return true;
    }
    
    private double mexicanada(String valor){
        try{
            return Double.parseDouble(valor);
        } catch(Exception exc){
            valor = mexicana.mexicanaDecimal(valor);
            return Double.parseDouble(valor);
        }
    }
    
    public void validaTabla(){
        for(int i = getRowCount() - 1 ; i >= 0 ; i--){
            if(!validaFila(i)){
                removeRow(i);
            }
        }
    }
    
    double totalTabla = 0;
    boolean terminandoMaquina = false;
    Object filaVacia[] = {"0","","0.00","0","0.00"};
    ArrayList<setGetConsumos> consumos;
    DecimalFormat formato = new DecimalFormat("#,##0.00");
    JLabel LTotal;
    validaALaMexicana mexicana = new validaALaMexicana();
}