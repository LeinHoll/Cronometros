package Dialogos;

import setters_getters.setGetProdServ;
import setters_getters.setGetProdProv;
import Tablas.cellEditorDecimal;
import Tablas.modeloTablaAdminPSLv2;
import Util.Conector;
import Util.soloNumeros;
import Util.upsy;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableColumn;

public class diagAdminProdServLv2 extends javax.swing.JDialog {

    public diagAdminProdServLv2(java.awt.Dialog parent, boolean modal, setGetProdServ producto, Conector linker, boolean mod) {
        super(parent, modal);
        this.mod        = mod;
        this.producto   = producto;
        this.linker     = linker;
        initComponents();
        misComponentes();
    }

    private void misComponentes(){
        setTitle("Proveedores de " + producto.getConcepto());
        recuperaProveedores();
        
        TProd.setModel(modeloProd);
        TProd.setRowSorter(sorter = new TableRowSorter(modeloProd));
        
        TProd.getTableHeader().setReorderingAllowed(false);
        TProd.getTableHeader().setResizingAllowed(false);
        
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        
        for(int i = 0 ; i < TProd.getColumnCount() ; i++){
            TableColumn col = TProd.getColumnModel().getColumn(i);
            String nom = TProd.getColumnName(i);
            if(nom.equals("Proveedor")){
                col.setPreferredWidth(150);
            } else if(nom.equals("Precio")){
                col.setPreferredWidth(50);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorDecimal);
            }
        }
        
        TProd.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter"   );
        TProd.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "tab"     );
        
        TProd.getActionMap().put("enter", new accionTablaEnter  ());
        TProd.getActionMap().put("tab"  , new accionTablaTab    ());
        
        BElegir .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        
        BElegir .getActionMap().put("abajo", new accionBotonAbajo(BOT_ELEGIR));
        BAceptar.getActionMap().put("abajo", new accionBotonAbajo(BOT_ACEPTAR));
        BCancela.getActionMap().put("abajo", new accionBotonAbajo(BOT_CANCELA));
        
        BElegir .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        
        BElegir .getActionMap().put("arriba", new accionBotonArriba(BOT_ELEGIR));
        BAceptar.getActionMap().put("arriba", new accionBotonArriba(BOT_ACEPTAR));
        BCancela.getActionMap().put("arriba", new accionBotonArriba(BOT_CANCELA));
        
        BElegir .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BElegir .getActionMap().put("enter", new accionBotonEnter(BElegir));
        BAceptar.getActionMap().put("enter", new accionBotonEnter(BAceptar));
        BCancela.getActionMap().put("enter", new accionBotonEnter(BCancela));
        
        modeloProd  .setFreeze  (mod);
        BElegir     .setEnabled (mod);
    }
    
    private void recuperaProveedores(){
        if(producto.getProveedores().isEmpty()){
            proveedores.clear();
            try{
                String SQL = "SELECT Proveedores.proveedor, Proveedores.ID, Prc_Prod_Prov.prc_co "
                        + "FROM Proveedores, Prc_Prod_Prov "
                        + "WHERE Prc_Prod_Prov.id_Prod = " + producto.getID() + " "
                        + "ORDER BY Prc_Prod_Prov.prc_co ASC";
                ResultSet RS = linker.consulta(SQL);
                while(RS.next()){
                    setGetProdProv prod = new setGetProdProv();

                    prod.setIdProdServ  (producto.getID()       );
                    prod.setProducto    (producto.getConcepto() );
                    prod.setIdProveedor (RS.getInt      ("ID"       ));
                    prod.setPrecio      (RS.getDouble   ("prc_co"   ));
                    prod.setProveedor   (RS.getString   ("proveedor"));

                    proveedores.add(prod);
                }
                modeloProd.setDatos(proveedores);
                RS.close();
            }catch(Exception exc){
                ouch.whoops("recuperaDatos()", exc);
            }
        } else {
            modeloProd.setDatos(proveedores = producto.getProveedores());
        }
    }
    
    public boolean getSalvo(){
        return salvar;
    }
    
    private void invocaDiagPuenteProdProv(){
        cancelaEdicion();
        
        diagPuenteProdProv puente = new diagPuenteProdProv(this, true, linker, proveedores, diagPuenteProdProv.PRODUCTO, producto.getConcepto());
        puente.setLocationRelativeTo(null);
        puente.setVisible(true);
        
        if(puente.getSalvo()){
            ArrayList<setGetProdProv> temps = puente.getDatos();
            
            for(int i = 0 ; i < temps.size() ; i++){
                setGetProdProv temp = temps.get(i);
                for(int j = 0 ; j < proveedores.size() ; j++){
                    setGetProdProv prov = proveedores.get(j);
                    if(temp.getIdProveedor() == prov.getIdProveedor()){
                        temps.set(i, prov);
                        break;
                    }
                }
            }
            
            proveedores = temps;
            modeloProd.setDatos(proveedores);
        }
    }
    
    private void cancelaEdicion(){
        if(TProd.isEditing()){
            TProd.getCellEditor().stopCellEditing();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TProd = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BElegir = new javax.swing.JButton();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Proveedor", "Precio"
            }
        ));
        TProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProdMouseClicked(evt);
            }
        });
        TProd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TProdPropertyChange(evt);
            }
        });
        TProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TProdKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TProd);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 0, 25));

        BElegir.setText("<HTML><CENTER>Elegir<P>Proveedor</HTML>");
        BElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BElegirActionPerformed(evt);
            }
        });
        jPanel1.add(BElegir);

        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BAceptar);

        BCancela.setText("Cancelar");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel1.add(BCancela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TProdKeyTyped
        int tecla   = evt.getKeyChar();
        int fila    = TProd.getSelectedRow();
        int columna = TProd.getSelectedColumn();
        
        if(tecla != KeyEvent.VK_TAB 
                && tecla != KeyEvent.VK_ENTER
                && TProd.editCellAt(fila, columna)
                && TProd.getColumnName(columna).equals("Precio")){
            valida.soloDecimalTyped(evt, editorDecimal.getField());
            if(!evt.isConsumed()){
                filaEditada = fila;
                editorDecimal.entrandoPorTecla();
                Component editor = TProd.getEditorComponent();
                editor.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_TProdKeyTyped

    private void TProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProdMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            Point p = evt.getPoint();
            TProd.changeSelection(TProd.rowAtPoint(p), TProd.columnAtPoint(p), false, false);
        }
        
        filaEditada = TProd.getSelectedRow();
        editorDecimal.entrandoPorClick();
    }//GEN-LAST:event_TProdMouseClicked

    private void TProdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TProdPropertyChange
        if(evt.getOldValue() != null 
                && evt.getOldValue().toString().contains("cellEditorDecimal")){
            int idx = TProd.convertRowIndexToModel(filaEditada);
            proveedores.get(idx).setPrecio(modeloProd.getPrecio(idx));
        }
    }//GEN-LAST:event_TProdPropertyChange

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        cancelaEdicion();
        salvar = true;
        dispose();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        cancelaEdicion();
        salvar = false;
        dispose();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void BElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BElegirActionPerformed
        invocaDiagPuenteProdProv();
    }//GEN-LAST:event_BElegirActionPerformed

    private class accionBotonAbajo extends AbstractAction{
        public accionBotonAbajo(int caso){
            this.caso = caso;
        }
        
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_ELEGIR : BAceptar  .requestFocus(); break;
                case BOT_ACEPTAR: BCancela  .requestFocus(); break;
                case BOT_CANCELA: BElegir   .requestFocus(); break;
            }
        }
        int caso;
    }
    
    private class accionBotonArriba extends AbstractAction{
        public accionBotonArriba(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_ACEPTAR: BElegir   .requestFocus(); break;
                case BOT_CANCELA: BAceptar  .requestFocus(); break;
                case BOT_ELEGIR : BCancela  .requestFocus(); break;
            }
        }
        int caso;
    }
    
    private class accionBotonEnter extends AbstractAction{
        public accionBotonEnter(JButton boton){
            this.boton = boton;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            boton.doClick();
        }
        JButton boton;
    }
    
    private class accionTablaEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TProd.getSelectedColumn();
            int nFil = TProd.getSelectedRow();
            int fila = TProd.getRowCount()-1;
            int colu = TProd.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TProd.transferFocus();
            } else if(nCol >= colu){
                nCol = 1;
                if(nFil == fila){
                    nFil = 0;
                } else {
                    nFil += 1;
                }
            } else {
                nCol += 1;
            }

            TProd.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class accionTablaTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TProd.transferFocus();
        }
    }
    
    public ArrayList<setGetProdProv> getProveedores(){
        return proveedores;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancela;
    private javax.swing.JButton BElegir;
    private javax.swing.JTable TProd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    int                         filaEditada     = 0;
    static final int            BOT_ELEGIR      = 0;
    static final int            BOT_ACEPTAR     = 1;
    static final int            BOT_CANCELA     = 2;
    boolean                     salvar          = false;
    boolean                     mod             ;
    ArrayList<setGetProdProv>   proveedores     = new ArrayList();
    cellEditorDecimal           editorDecimal   = new cellEditorDecimal(new accionTablaEnter());
    Conector                    linker          ;
    modeloTablaAdminPSLv2       modeloProd      = new modeloTablaAdminPSLv2();
    setGetProdServ              producto        ;
    soloNumeros                 valida          = new soloNumeros();
    TableRowSorter              sorter          ;
    upsy                        ouch            = new upsy("diagAdminProdServLv2");
}