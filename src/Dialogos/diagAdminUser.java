package Dialogos;

import setters_getters.setGetPermisos;
import Tablas.modeloTablaAdminUser;
import Util.Conector;
import Util.upsy;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.TableColumn;

public class diagAdminUser extends javax.swing.JDialog {

    public diagAdminUser(java.awt.Frame parent, boolean modal, Conector linker, setGetPermisos responsable) {
        super(parent, modal);
        this.responsable = responsable;
        this.linker   = linker;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        recuperaDatos();
        
        TUser.setModel(modelo);
        
        TableColumn col;
        
        col = TUser.getColumnModel().getColumn(modelo.intColumna("ID"));
        col.setPreferredWidth(30);
        
        col = TUser.getColumnModel().getColumn(modelo.intColumna("Usuario"));
        col.setPreferredWidth(300);
        
        TUser.getTableHeader().setReorderingAllowed(false);
        TUser.getTableHeader().setResizingAllowed(false);
        
        TUser.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "tab");
        TUser.getActionMap().put("tab", new accionTablaTab());
        
        BAgregar    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        BEliminar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        BEditar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "abajo");
        
        BAgregar    .getActionMap() .put("abajo", new accionBotonAbajo());
        BEliminar   .getActionMap().put("abajo", new accionBotonAbajo());
        BEditar     .getActionMap().put("abajo", new accionBotonAbajo());
        
        BAgregar    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        BEliminar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        BEditar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "arriba");
        
        BAgregar    .getActionMap().put("arriba", new accionBotonArriba());
        BEliminar   .getActionMap().put("arriba", new accionBotonArriba());
        BEditar     .getActionMap().put("arriba", new accionBotonArriba());
        
        BAgregar    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BEliminar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BEditar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BAgregar    .getActionMap().put("enter", new accionBotonEnter(BAgregar  ));
        BEliminar   .getActionMap().put("enter", new accionBotonEnter(BEliminar ));
        BEditar     .getActionMap().put("enter", new accionBotonEnter(BEditar   ));
    }

    private void recuperaDatos(){
        try{
            String SQL = "";
            if(responsable.getBool_usu_con()){
                SQL = "SELECT ID, usuario FROM Usuarios";
                if(responsable.getID() != 1){
                        SQL += " WHERE NOT ID = 1";
                }
            } else {
                SQL = "SELECT ID, usuario FROM Usuarios WHERE ID = " + responsable.getID();
            }
            modelo.setDatos(linker.consulta(SQL));
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
    }
    
    private void invocaDiagAdminUserLv2(int ID){
        diagAdminUserLv2 admUsr2 = new diagAdminUserLv2(this, true, ID, linker, responsable);
        
        admUsr2.setLocationRelativeTo(null);
        admUsr2.setVisible(true);
        
        recuperaDatos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        BAgregar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        BEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de usuarios");

        jPanel3.setLayout(new java.awt.GridLayout(3, 0, 0, 25));

        BAgregar.setText("Agregar");
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(BAgregar);

        BEliminar.setText("Eliminar");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(BEliminar);

        BEditar.setText("Editar");
        BEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarActionPerformed(evt);
            }
        });
        jPanel3.add(BEditar);

        TUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Usuario"
            }
        ));
        jScrollPane1.setViewportView(TUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        if(responsable.getBool_usu_alt())
            invocaDiagAdminUserLv2(diagAdminUserLv2.NUEVO);
        else
            JOptionPane.showMessageDialog(
                    null, 
                    "El usuario no tiene derechos para dar de alta", 
                    "carencia de derechos", 
                    JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_BAgregarActionPerformed

    private void BEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarActionPerformed
        if(TUser.getSelectedRow() != -1){
            invocaDiagAdminUserLv2(modelo.getID(TUser.getSelectedRow()));
        }
    }//GEN-LAST:event_BEditarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
        if(responsable.getBool_usu_baj()){
            if(TUser.getSelectedRow() != -1){
                if(responsable.getID() != modelo.getID(TUser.getSelectedRow())){
                    try{
                        String SQL = "DELETE FROM Usuarios WHERE ID = " + modelo.getID(TUser.getSelectedRow());
                        linker.ejecuta(SQL);
                    }catch(Exception exc){
                        ouch.whoops("BEliminarActionPerformed(ActionEvent evt)", exc);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null, 
                            "El usuario no se puede eliminar a si mismo", 
                            "Estas loco?", 
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    null, 
                    "El usuario no tiene derecho a dar de baja", 
                    "carencia de derechos", 
                    JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_BEliminarActionPerformed

    private class accionBotonAbajo extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAgregar.isFocusOwner()){
                BEliminar.requestFocus();
            } else if(BEliminar.isFocusOwner()){
                BEditar.requestFocus();
            } else if(BEditar.isFocusOwner()){
                BAgregar.requestFocus();
            }
        }
    }
    
    private class accionBotonArriba extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAgregar.isFocusOwner()){
                BEditar.requestFocus();
            } else if(BEditar.isFocusOwner()){
                BEliminar.requestFocus();
            } else if(BEliminar.isFocusOwner()){
                BAgregar.requestFocus();
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
    
    private class accionTablaTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TUser.transferFocus();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BEditar;
    private javax.swing.JButton BEliminar;
    private javax.swing.JTable TUser;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    Conector                linker      ;
    modeloTablaAdminUser    modelo      = new modeloTablaAdminUser();
    setGetPermisos          responsable ;
    upsy                    ouch        = new upsy("diagAdminUser");
}