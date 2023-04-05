package Paneles;

import Tablas.modeloTablaConsumosResumido;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.SwingUtilities;

public class panelConsumosResumido extends javax.swing.JPanel {

    public panelConsumosResumido() {
        initComponents();
        
        TConsumos.getTableHeader().setReorderingAllowed(false);
        TConsumos.getTableHeader().setResizingAllowed(false);
        
        DefaultTableCellRenderer Derecha = new DefaultTableCellRenderer();
        Derecha.setHorizontalAlignment(SwingUtilities.RIGHT);
        
        TableColumn col = TConsumos.getColumnModel().getColumn(1);
        col.setPreferredWidth(15);
        col.setCellRenderer(Derecha);
    }
    
    public modeloTablaConsumosResumido getModelo(){
        return modelo;
    }
    
    public void setTitulo(String nombre){
        setBorder(BorderFactory.createTitledBorder("Detalles de " + nombre));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TConsumos = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Consumos"));
        setLayout(new java.awt.GridLayout(1, 0));

        TConsumos.setModel(modelo = new modeloTablaConsumosResumido());
        jScrollPane2.setViewportView(TConsumos);

        add(jScrollPane2);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TConsumos;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    modeloTablaConsumosResumido modelo;
}