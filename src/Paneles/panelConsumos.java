package Paneles;

import Dialogos.diagConsumosLv2;
import Tablas.cellEditorDecimal;
import Tablas.cellEditorDefault;
import Tablas.cellEditorInteger;
import Tablas.modeloTablaConsumos;
import Util.Conector;
import Util.soloNumeros;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.SwingUtilities;

public class panelConsumos extends javax.swing.JPanel {

    public panelConsumos(JDialog padre, modeloTablaConsumos modelo, AbstractAction picoEscape, Conector linker) {
        this.padre  = padre;
        this.modelo = modelo;
        this.linker = linker;
        initComponents();
        
        TConsumos.getTableHeader().setReorderingAllowed(false);
        TConsumos.getTableHeader().setResizingAllowed(false);
        TConsumos.setRowSelectionInterval(0, 0);
        TConsumos.changeSelection(modelo.getRowCount() - 1, 0, false, false);
        
        DefaultTableCellRenderer Derecha = new DefaultTableCellRenderer();
        Derecha.setHorizontalAlignment(SwingUtilities.RIGHT);
        
        for(int i = 0 ; i < TConsumos.getColumnCount() ; i++){
            TableColumn col = TConsumos.getColumnModel().getColumn(i);
            if(i == 1){
                col.setPreferredWidth(300);
                col.setCellEditor(editorDefault);
            } else if(i == 0 || i == 3){
                col.setCellRenderer(Derecha);
                col.setCellEditor(editorInteger);
            } else {
                col.setCellRenderer(Derecha);
                col.setCellEditor(editorDecimal);
            }
        }
        
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEsc");
        TConsumos.getActionMap().put("picoEsc", picoEscape);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popConsumos = new javax.swing.JPopupMenu();
        consumosItemBuscar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsumos = new javax.swing.JTable();

        consumosItemBuscar.setText("Buscar");
        consumosItemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumosItemBuscarActionPerformed(evt);
            }
        });
        popConsumos.add(consumosItemBuscar);

        setLayout(new java.awt.GridLayout(1, 0));

        TConsumos.setModel(modelo);
        TConsumos.setColumnSelectionAllowed(true);
        TConsumos.setGridColor(new java.awt.Color(102, 102, 102));
        TConsumos.setSelectionBackground(new java.awt.Color(204, 255, 255));
        TConsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TConsumosMouseClicked(evt);
            }
        });
        TConsumos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TConsumosPropertyChange(evt);
            }
        });
        TConsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TConsumosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TConsumos);
        TConsumos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter"   );
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "picoTab"     );
        TConsumos.getActionMap().put("picoEnter", new picoEnter()  );
        TConsumos.getActionMap().put("picoTab"  , new picoTab()    );

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void TConsumosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TConsumosKeyTyped
        if(TConsumos.getSelectedRow() == modelo.getRowCount() - 1 && 
                !(evt.getKeyChar() == KeyEvent.VK_ESCAPE || evt.getKeyChar() == KeyEvent.VK_TAB))
            modelo.agregaFilaVacia();
        
        int tecla = Valida.soloNum(evt);
        
        edtFil = TConsumos.getSelectedRow();
        edtCol = TConsumos.getSelectedColumn();
        
        if(evt.getKeyChar() != KeyEvent.VK_ESCAPE){
            if(TConsumos.getSelectedColumn() != 1){
                if(tecla != -1 && tecla != 10){
                    if(TConsumos.editCellAt(TConsumos.getSelectedRow(), TConsumos.getSelectedColumn())){
                        editorDecimal.entrandoPorTecla();
                        editorInteger.entrandoPorTecla(tecla);
                        Component editor = TConsumos.getEditorComponent();
                        editor.requestFocusInWindow();
                    }
                } else {
                    evt.consume();
                }
            }
            else if(tecla != 10 && evt.getKeyChar() != KeyEvent.VK_TAB) {
                if(TConsumos.editCellAt(TConsumos.getSelectedRow(), TConsumos.getSelectedColumn())){
                    editorDefault.entrandoPorTecla(tecla);
                    Component editor = TConsumos.getEditorComponent();
                    editor.requestFocusInWindow();
                }
            }
        }
    }//GEN-LAST:event_TConsumosKeyTyped

    private void TConsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TConsumosMouseClicked
        Point p = evt.getPoint();
        
        edtFil = TConsumos.rowAtPoint(p);
        edtCol = TConsumos.columnAtPoint(p);
                
        if(SwingUtilities.isRightMouseButton(evt)){
            TConsumos.changeSelection(TConsumos.rowAtPoint(p), TConsumos.columnAtPoint(p), false, false);
            
            popConsumos.show(evt.getComponent(), evt.getX(), evt.getY());
        }
                        
        editorDecimal.entrandoPorClick();
        editorInteger.entrandoPorClick();
        editorDefault.entrandoPorClick();
    }//GEN-LAST:event_TConsumosMouseClicked

    private void TConsumosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TConsumosPropertyChange
        if(evt.getOldValue() != null){
            String edit = evt.getOldValue().toString();
            if(edit.contains("cellEditor"))
                editado = true;
            if(edit.contains("cellEditorDecimal")){
                modelo.calculaTotales();
            } else if(edit.contains("cellEditorInteger")){
                switch(edtCol){
                    case COL_COD: 
                        buscaArticulo();
                        break;
                    case COL_CANT:
                        modelo.calculaTotales();
                        break;
                }
            }
        }
    }//GEN-LAST:event_TConsumosPropertyChange

    private void consumosItemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumosItemBuscarActionPerformed
        invocaDiagConsumosLv2();
    }//GEN-LAST:event_consumosItemBuscarActionPerformed
    
    private void buscaArticulo(){
        try{
            String SQL = "SELECT concepto, precio "
                    + "FROM Productos_Servicios "
                    + "WHERE ID = " + modelo.getCodigo(edtFil);
            ResultSet RS = linker.consulta(SQL);
            if(RS.next()){
                modelo.setConcepto  (RS.getString("concepto"), edtFil);
                modelo.setPrecio    (RS.getDouble("precio"  ), edtFil);
                TConsumos.changeSelection(edtFil, modelo.intColumna("Cantidad"), false, false);
            } else {
                modelo.setCodigo(edtFil);
                TConsumos.changeSelection(edtFil, modelo.intColumna("Concepto"), false, false);
            }
            RS.close();
        }catch(Exception exc){}
    }
    
    private void invocaDiagConsumosLv2(){
        diagConsumosLv2 conlv2 = new diagConsumosLv2(padre, true, linker);
        conlv2.setLocationRelativeTo(null);
        conlv2.setVisible(true);
        
        if(conlv2.getSalvo()){
            TConsumos.setValueAt(conlv2.getID(), edtFil, modelo.intColumna("Codigo"));
            buscaArticulo();
        }
    }
    
    public boolean getEditado(){
        return editado;
    }
    
    public void detenEdicion(){
        TConsumos.getCellEditor().stopCellEditing();
        modelo.calculaTotales();
    }
    
    public boolean estaEditando(){
        return TConsumos.isEditing();
    }
    
    private class picoEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TConsumos.getSelectedColumn();
            int nFil = TConsumos.getSelectedRow();
            int fila = modelo.getRowCount()-1;
            int colu = modelo.getColumnCount()-2;

            if(nCol >= colu && nFil == fila){
                TConsumos.transferFocus();
                TConsumos.clearSelection();
            } else if(nCol >= colu){
                nCol = 0;
                if(nFil == fila){
                    nFil = 0;
                } else {
                    nFil += 1;
                }
            } else {
                nCol += 1;
            }

            TConsumos.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class picoTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TConsumos.transferFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TConsumos;
    private javax.swing.JMenuItem consumosItemBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popConsumos;
    // End of variables declaration//GEN-END:variables
    int                 edtFil          = 0;
    int                 edtCol          = 0;
    final static int    COL_COD          = 0;
    final static int    COL_CANT        = 3;
    boolean             editado         = false;
    cellEditorDecimal   editorDecimal   = new cellEditorDecimal(new picoEnter());
    cellEditorDefault   editorDefault   = new cellEditorDefault(new picoEnter());
    cellEditorInteger   editorInteger   = new cellEditorInteger(new picoEnter());
    Conector            linker          ;
    JDialog             padre           ;
    modeloTablaConsumos modelo          ;
    soloNumeros         Valida          = new soloNumeros();
}