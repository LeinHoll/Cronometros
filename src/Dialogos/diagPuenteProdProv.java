package Dialogos;

import setters_getters.setGetProdProv;
import Tablas.modeloTablaPuenteProdProv;
import Util.Conector;
import Util.upsy;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class diagPuenteProdProv extends javax.swing.JDialog {

    public diagPuenteProdProv(java.awt.Dialog parent, boolean modal, Conector linker, ArrayList<setGetProdProv> registros, int caso, String concepto) {
        super(parent, modal);
        this.caso       = caso;
        this.concepto   = concepto;
        this.registros  = registros;
        this.linker     = linker;
        initComponents();
        misComponentes();
    }

    private void misComponentes(){
        recuperaDatos();
        
        TPP1.getTableHeader().setReorderingAllowed(false);
        TPP2.getTableHeader().setReorderingAllowed(false);
        TPP1.getTableHeader().setResizingAllowed(false);
        TPP2.getTableHeader().setResizingAllowed(false);
        
        TPP1.setModel(modeloTPP1);
        TPP2.setModel(modeloTPP2);
        
        TPP1.setRowSorter(sorterTPP1 = new TableRowSorter(modeloTPP1));
        TPP2.setRowSorter(sorterTPP2 = new TableRowSorter(modeloTPP2));
        
        filtros();
        
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        
        for(int i = 0 ; i < TPP1.getColumnCount() ; i++){
            TableColumn col1 = TPP1.getColumnModel().getColumn(i);
            TableColumn col2 = TPP2.getColumnModel().getColumn(i);
            String      nom  = TPP1.getColumnName(i);
            
            if(nom.equals("ID")){
                col1.setPreferredWidth(30);
                col2.setPreferredWidth(30);
                col1.setCellRenderer(derecha);
                col2.setCellRenderer(derecha);
            } else if(nom.equals("Producto") || nom.equals("Proveedor")){
                col1.setPreferredWidth(200);
                col2.setPreferredWidth(200);
            }
        }
        
        BAdd.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP    , 0), "vertical");
        BRem.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP    , 0), "vertical");
        BAdd.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN  , 0), "vertical");
        BRem.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN  , 0), "vertical");
        
        BAdd.getActionMap().put("vertical", new accionBotonVertical());
        BRem.getActionMap().put("vertical", new accionBotonVertical());
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0), "lateral");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0), "lateral");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0), "lateral");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0), "lateral");
        
        BAceptar.getActionMap().put("lateral", new accionBotonLateral());
        BCancela.getActionMap().put("lateral", new accionBotonLateral());
        
        BAdd    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BRem    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BAdd    .getActionMap().put("enter", new accionBotonEnter(BAdd      ));
        BRem    .getActionMap().put("enter", new accionBotonEnter(BRem      ));
        BAceptar.getActionMap().put("enter", new accionBotonEnter(BAceptar  ));
        BCancela.getActionMap().put("enter", new accionBotonEnter(BCancela  ));
        
        TPP1.getInputMap(JTable.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "f2");
        TPP1.getActionMap().put("f2", new accionTPP1F2());
        
    }
    
    private void recuperaDatos(){
        String SQL = "";
        switch(caso){
            case PROVEEDOR: 
                SQL = "SELECT ID, concepto "
                        + "FROM Productos_Servicios "
                        + "WHERE tipo = 'Producto'";
                modeloTPP1 = new modeloTablaPuenteProdProv(PROVEEDOR);
                modeloTPP2 = new modeloTablaPuenteProdProv(PROVEEDOR);
                setTitle("Registro de productos para " + concepto);
                break;
            case PRODUCTO: 
                SQL = "SELECT ID, proveedor "
                        + "FROM Proveedores";
                modeloTPP1 = new modeloTablaPuenteProdProv(PRODUCTO);
                modeloTPP2 = new modeloTablaPuenteProdProv(PRODUCTO);
                setTitle("Registro de proveedores para " + concepto);
                break;
        }
        try{
            ResultSet RS = linker.consulta(SQL);
            modeloTPP1.setDatos(RS);
            modeloTPP2.setDatos(registros);
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
    }
    
    public boolean getSalvo(){
        return salva;
    }
        
    public ArrayList<setGetProdProv> getDatos(){
        ArrayList<setGetProdProv> datos = new ArrayList();
        
        for(int i = 0 ; i < modeloTPP2.getRowCount() ; i++){
            setGetProdProv dato = new setGetProdProv();
            
            switch(caso){
                case PROVEEDOR:
                    dato.setIdProdServ  (modeloTPP2.getID       (i));
                    dato.setProducto    (modeloTPP2.getProducto (i));
                    break;
                case PRODUCTO:
                    dato.setIdProveedor (modeloTPP2.getID       (i));
                    dato.setProveedor   (modeloTPP2.getProveedor(i));
                    break;
            }
            
            datos.add(dato);
        }
        
        return datos;
    }
        
    private void filtros(){
        try{
            ArrayList<RowFilter<Object,Object>> filtros = new ArrayList();
            for(int i = 0 ; i < modeloTPP2.getRowCount() ; i++){
                RowFilter nID = RowFilter.notFilter(
                    RowFilter.numberFilter(
                        RowFilter.ComparisonType.EQUAL, 
                        modeloTPP2.getID(i), 
                        0
                    ));
                filtros.add(nID);
            }
            if(texto == null)
                texto = "";
            filtros.add(RowFilter.regexFilter(texto));
            sorterTPP1.setRowFilter(RowFilter.andFilter(filtros));
        }catch(Exception exc){}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popPuente = new javax.swing.JPopupMenu();
        puenteItemFiltro = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPP1 = new javax.swing.JTable(){
            public boolean getScrollableTracksViewportHeight(){
                return TPP1.getPreferredSize().height < TPP1.getParent().getHeight();
            }
        };
        jPanel1 = new javax.swing.JPanel();
        BAdd = new javax.swing.JButton();
        BRem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPP2 = new javax.swing.JTable();

        puenteItemFiltro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        puenteItemFiltro.setText("Buscar por");
        puenteItemFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puenteItemFiltroActionPerformed(evt);
            }
        });
        popPuente.add(puenteItemFiltro);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TPP1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Producto"
            }
        ));
        TPP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPP1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPP1);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 0, 35));

        BAdd.setText(">");
        BAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAddActionPerformed(evt);
            }
        });
        jPanel1.add(BAdd);

        BRem.setText("<");
        BRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRemActionPerformed(evt);
            }
        });
        jPanel1.add(BRem);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 35, 0));

        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(BAceptar);

        BCancela.setText("Cancelar");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel2.add(BCancela);

        TPP2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Producto"
            }
        ));
        jScrollPane2.setViewportView(TPP2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        salva = true;
        dispose();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        salva = false;
        dispose();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void BAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAddActionPerformed
        int idx[] = TPP1.getSelectedRows();
        for(int i = 0 ; i < idx.length ; i++){
            idx[i] = TPP1.convertRowIndexToModel(idx[i]);
            modeloTPP2.addFila(modeloTPP1.getFila(idx[i]));
        }
        
        for(int j = idx.length - 1 ; j >= 0 ; j--){
            modeloTPP1.removeRow(idx[j]);
        }
        filtros();
    }//GEN-LAST:event_BAddActionPerformed

    private void BRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRemActionPerformed
        int idx[] = TPP2.getSelectedRows();
        for(int i = 0 ; i < idx.length ; i++){
            idx[i] = TPP2.convertRowIndexToModel(idx[i]);
            modeloTPP1.addFila(modeloTPP2.getFila(idx[i]));
        }
        
        for(int j = idx.length - 1 ; j >= 0 ; j--){
            modeloTPP2.removeRow(j);
        }
        filtros();
    }//GEN-LAST:event_BRemActionPerformed

    private void puenteItemFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puenteItemFiltroActionPerformed
        texto = JOptionPane.showInputDialog("Buscar por:");
        filtros();
    }//GEN-LAST:event_puenteItemFiltroActionPerformed

    private void TPP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPP1MouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            Point p = evt.getPoint();
            TPP1.changeSelection(TPP1.rowAtPoint(p), TPP1.columnAtPoint(p), false, false);
            
            popPuente.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_TPP1MouseClicked

    private class accionBotonLateral extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAceptar.isFocusOwner()){
                BCancela.requestFocus();
            } else if(BCancela.isFocusOwner()){
                BAceptar.requestFocus();
            }
        }
    }
    
    private class accionBotonVertical extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAdd.isFocusOwner()){
                BRem.requestFocus();
            } else if(BRem.isFocusOwner()){
                BAdd.requestFocus();
            }
        }
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
    
    private class accionTPP1F2 extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            texto = JOptionPane.showInputDialog("Buscar por:");
            filtros();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BAdd;
    private javax.swing.JButton BCancela;
    private javax.swing.JButton BRem;
    private javax.swing.JTable TPP1;
    private javax.swing.JTable TPP2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popPuente;
    private javax.swing.JMenuItem puenteItemFiltro;
    // End of variables declaration//GEN-END:variables
    int                         caso        ;
    public static final int     PROVEEDOR   = 0;
    public static final int     PRODUCTO    = 1;
    boolean                     salva       = false;
    String                      concepto    ;
    String                      texto       = "";
    ArrayList<setGetProdProv>   registros   ;
    Conector                    linker      ;
    modeloTablaPuenteProdProv   modeloTPP1  ;
    modeloTablaPuenteProdProv   modeloTPP2  ;
    TableRowSorter              sorterTPP1  ;
    TableRowSorter              sorterTPP2  ;
    upsy                        ouch        = new upsy("diagPuenteProdProv");
}