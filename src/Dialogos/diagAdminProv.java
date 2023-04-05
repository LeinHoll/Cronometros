package Dialogos;

import setters_getters.setGetPermisos;
import setters_getters.setGetProveedor;
import setters_getters.setGetProdProv;
import Tablas.modeloTablaAdminProv;
import Util.Conector;
import Util.upsy;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class diagAdminProv extends javax.swing.JDialog {
    
    public diagAdminProv(java.awt.Frame parent, boolean modal, Conector linker, setGetPermisos responsable) {
        super(parent, modal);
        initComponents()    ;
        this.responsable    = responsable;
        this.linker         = linker;
        misComponentes()    ;
    }

    private void misComponentes(){
        TProv.getTableHeader().setReorderingAllowed(false);
        TProv.getTableHeader().setResizingAllowed(false);
        
        TProv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TProv.getActionMap().put("enter", new accionTablaEnter());
        
        recuperaDatos();
        
        TProv.setModel(modeloProv);
        TProv.setRowSorter(sorter = new TableRowSorter(modeloProv));
        
        DefaultTableCellRenderer centro     = new DefaultTableCellRenderer();
        DefaultTableCellRenderer derecha    = new DefaultTableCellRenderer();
        
        centro  .setHorizontalAlignment(SwingUtilities.CENTER);
        derecha .setHorizontalAlignment(SwingUtilities.RIGHT);
        
        for(int i = 0 ; i < TProv.getColumnCount() ; i++){
            TableColumn col = TProv.getColumnModel().getColumn(i);
            String      nom = TProv.getColumnName(i);
            if(nom.equals("ID")){
                col.setPreferredWidth(10);
                col.setCellRenderer(derecha);
            } else if(nom.equals("Proveedor")){
                col.setPreferredWidth(180);
            } else if(nom.equals("Tel")){
                col.setPreferredWidth(50);
                col.setCellRenderer(centro);
            } else if(nom.equals("Correo")){
                col.setPreferredWidth(100);
            }
        }
        
        provItemNuevo   .setEnabled(responsable.getBool_pro_alt());
        provItemEliminar.setEnabled(responsable.getBool_pro_baj());
    }
    
    private void recuperaDatos(){
        try{
            String SQL = "SELECT ID, proveedor, tel, correo FROM Proveedores";
            ResultSet proveedores = linker.consulta(SQL);
            modeloProv.setDatos(proveedores);
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
    }
    
    private void invocaDiagAdminProvLv2(int ID){
        boolean mod;
        
        if(ID == NUEVO)
            mod = true;
        else
            mod = responsable.getBool_pro_mod();
        
        diagAdminProvLv2 admProv = new diagAdminProvLv2(this, true, linker, ID, mod);
        admProv.setLocationRelativeTo(null);
        admProv.setVisible(true);
        
        if(admProv.getSalvo()){
            setGetProveedor prov = admProv.getProveedor();
            ArrayList<setGetProdProv> productos = admProv.getProductos();
            
            String SQL = "";
            if(prov.getID() == NUEVO){
                try{
                    SQL = "INSERT INTO Proveedores "
                            + "(proveedor, persona, direccion, tel, cel, correo, web, rfc, curp) "
                            + "VALUES ("
                            + "'" + prov.getProveedor   () + "', "
                            + "'" + prov.getPersona     () + "', "
                            + "'" + prov.getDireccion   () + "', "
                            + "'" + prov.getTelefono    () + "', "
                            + "'" + prov.getCelular     () + "', "
                            + "'" + prov.getCorreo      () + "', "
                            + "'" + prov.getWeb         () + "', "
                            + "'" + prov.getRfc         () + "', "
                            + "'" + prov.getCurp        () + "')";
                    ResultSet RS = linker.inserta(SQL);
                    if(RS.next()){
                        for(int i = 0 ; i < productos.size() ; i++){
                            SQL = "INSERT INTO Prc_Prod_Prov "
                                    + "(id_prov, id_prod, prc_co) "
                                    + "VALUES ("
                                    + "" + RS       .getInt(1)              + ", "
                                    + "" + productos.get(i).getIdProdServ() + ", "
                                    + "" + productos.get(i).getPrecio()     + ")";
                            linker.ejecuta(SQL);
                        }
                    }
                    RS.close();
                }catch(Exception exc){
                    ouch.whoops("invocaDiagAdminProvLv2(setGetProveedor prov)\nINSERT INTO", exc);
                }
            } else {
                try{
                    SQL = "UPDATE Proveedores "
                            + "SET "
                            + "proveedor = '"   + prov.getProveedor () + "', "
                            + "persona = '"     + prov.getPersona   () + "', "
                            + "rfc = '"         + prov.getRfc       () + "', "
                            + "curp = '"        + prov.getCurp      () + "', "
                            + "direccion = '"   + prov.getDireccion () + "', "
                            + "tel = '"         + prov.getTelefono  () + "', "
                            + "cel = '"         + prov.getCelular   () + "', "
                            + "correo = '"      + prov.getCorreo    () + "', "
                            + "web = '"         + prov.getWeb       () + "' "
                            + "WHERE ID = "     + prov.getID        ();
                    linker.ejecuta(SQL);
                    SQL = "DELETE FROM Prc_Prod_Prov "
                            + "WHERE id_prov = " + prov.getID();
                    linker.ejecuta(SQL);
                    for(int i = 0 ; i < productos.size() ; i++){
                        SQL = "INSERT INTO Prc_Prod_Prov "
                                + "(id_prov, id_prod, prc_co) "
                                + "VALUES ("
                                + "" + prov     .getID()                + ", "
                                + "" + productos.get(i).getIdProdServ() + ", "
                                + "" + productos.get(i).getPrecio()     + ")";
                        linker.ejecuta(SQL);
                    }
                } catch(Exception exc){
                    ouch.whoops("invocaDiagAdminProvLv2(setGetProveedor prov)\nUPDATE", exc);
                }
            }
            recuperaDatos();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popProv = new javax.swing.JPopupMenu();
        provItemDetalles = new javax.swing.JMenuItem();
        provItemNuevo = new javax.swing.JMenuItem();
        provItemEliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TProv = new javax.swing.JTable(){
            public boolean getScrollableTracksViewportHeight(){
                return TProv.getPreferredSize().height < TProv.getParent().getHeight();
            }
        };
        jPanel1 = new javax.swing.JPanel();
        TBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        provItemDetalles.setText("Detalles");
        provItemDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provItemDetallesActionPerformed(evt);
            }
        });
        popProv.add(provItemDetalles);

        provItemNuevo.setText("Nuevo");
        provItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provItemNuevoActionPerformed(evt);
            }
        });
        popProv.add(provItemNuevo);

        provItemEliminar.setText("Eliminar");
        provItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provItemEliminarActionPerformed(evt);
            }
        });
        popProv.add(provItemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catalogo de Proveedores");

        TProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Empresa", "Telefono", "Correo"
            }
        ));
        TProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TProv);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        TBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TBuscarKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.ipadx = 200;
        jPanel1.add(TBuscar, gridBagConstraints);

        jLabel1.setText("Filtro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel1.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void provItemDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provItemDetallesActionPerformed
        int idx = TProv.getSelectedRow();
        idx = TProv.convertRowIndexToModel(idx);
        invocaDiagAdminProvLv2(modeloProv.getID(idx));
    }//GEN-LAST:event_provItemDetallesActionPerformed

    private void provItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provItemNuevoActionPerformed
        invocaDiagAdminProvLv2(NUEVO);
    }//GEN-LAST:event_provItemNuevoActionPerformed

    private void provItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provItemEliminarActionPerformed
        try{
            String SQL = "DELETE FROM Proveedores "
                    + "WHERE ID = " + modeloProv.getID(
                            TProv.convertRowIndexToModel(
                            TProv.getSelectedRow()));
            
            linker.ejecuta(SQL);
            
            recuperaDatos();
        }catch(Exception exc){
            ouch.whoops("provItemEliminarActionPerformed(ActionEvent evt)", exc);
        }
    }//GEN-LAST:event_provItemEliminarActionPerformed

    private void TProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProvMouseClicked
        if(SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2){
            int idx = TProv.getSelectedRow();
            if(idx != -1){
                idx = TProv.convertRowIndexToModel(idx);
                if(responsable.getBool_pro_mod())
                    invocaDiagAdminProvLv2(modeloProv.getID(idx));
            } else {
                if(responsable.getBool_pro_alt())
                    invocaDiagAdminProvLv2(NUEVO);
            }
        }
        
        if(SwingUtilities.isRightMouseButton(evt)){
            Point p = evt.getPoint();
            TProv.changeSelection(TProv.rowAtPoint(p), TProv.columnAtPoint(p), false, false);
            if(TProv.getSelectedRow() == -1){
                provItemDetalles.setEnabled(false);
                provItemEliminar.setEnabled(false);
            } else {
                provItemDetalles.setEnabled(true);
                provItemEliminar.setEnabled(true);
            }
            popProv.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_TProvMouseClicked

    private void TBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBuscarKeyReleased
        sorter.setRowFilter(
                RowFilter.regexFilter(
                    "(?i)^" + TBuscar.getText()
                )
        );
    }//GEN-LAST:event_TBuscarKeyReleased

    private class accionTablaEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TProv.getSelectedColumn();
            int nFil = TProv.getSelectedRow();
            int fila = TProv.getRowCount()-1;
            int colu = TProv.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TProv.transferFocus();
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

            TProv.changeSelection(nFil, nCol, false, false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TBuscar;
    private javax.swing.JTable TProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popProv;
    private javax.swing.JMenuItem provItemDetalles;
    private javax.swing.JMenuItem provItemEliminar;
    private javax.swing.JMenuItem provItemNuevo;
    // End of variables declaration//GEN-END:variables
    final static int            NUEVO       = 0;
    Conector                    linker      ;
    modeloTablaAdminProv        modeloProv  = new modeloTablaAdminProv();
    setGetPermisos              responsable ;
    TableRowSorter              sorter      ;
    upsy                        ouch        = new upsy("diagAdminProv");
}