package Dialogos;

import Tablas.modeloTablaPermisos;
import setters_getters.setGetPermisos;

public class diagAdminPermisos extends javax.swing.JDialog {

    public diagAdminPermisos(java.awt.Dialog parent, boolean modal, setGetPermisos permisos, setGetPermisos responsable) {
        super(parent, modal);
        this.responsable    = responsable;
        this.permisos       = permisos;
        initComponents();
        misComponentes();
    }

    private void misComponentes(){
        modelo.setDatos(permisos);
        
        if(permisos.getID() == responsable.getID()){
            modelo.setFreeze(false);
        } else {
            modelo.setFreeze(responsable.getBool_usu_mod());
        }
        
        TPermisos.setModel(modelo);
        
        BOk.setEnabled(responsable.getBool_usu_mod());
    }
    
    public boolean getSalvo(){
        return salvar;
    }
    
    public setGetPermisos getPermisos(){
        return modelo.getPermisos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TPermisos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BOk = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de permisos");

        TPermisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Usuarios", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)},
                {"Maquinas", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)},
                {"Tarifas", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)},
                {"Almacen", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)},
                {"Proveedores", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)},
                {"Clientes", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true)}
            },
            new String [] {
                "Area", "Cons", "Edit", "Alta", "Baja"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TPermisos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TPermisosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(TPermisos);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BOk.setText("Ok");
        BOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOkActionPerformed(evt);
            }
        });
        jPanel1.add(BOk);

        BSalir.setText("Salir");
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        salvar = false;
        
        dispose();
    }//GEN-LAST:event_BSalirActionPerformed

    private void BOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOkActionPerformed
        salvar = true;
        
        dispose();
    }//GEN-LAST:event_BOkActionPerformed

    private void TPermisosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TPermisosPropertyChange
        if(evt.getOldValue() != null && evt.getOldValue().toString().contains("BooleanEditor")){
            int fil = TPermisos.getEditingRow();
            int col = TPermisos.getEditingColumn();
            boolean bool = Boolean.parseBoolean(TPermisos.getValueAt(fil, col).toString());
            if(!bool){
                modelo.validaFila(fil, col);
            }
        }
    }//GEN-LAST:event_TPermisosPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOk;
    private javax.swing.JButton BSalir;
    private javax.swing.JTable TPermisos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    boolean             salvar      = false;
    modeloTablaPermisos modelo      = new modeloTablaPermisos();
    setGetPermisos      responsable ;
    setGetPermisos      permisos    ;
}