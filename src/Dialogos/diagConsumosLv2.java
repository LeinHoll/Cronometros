package Dialogos;

import Util.Conector;
import Util.upsy;
import Tablas.modeloTablaConsumosLv2;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class diagConsumosLv2 extends javax.swing.JDialog {

    public diagConsumosLv2(java.awt.Dialog parent, boolean modal, Conector linker) {
        super(parent, modal);
        this.linker = linker;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        recuperaDatos();
        
        TProd.setModel(modelo);
        TProd.setRowSorter(sorter = new TableRowSorter(modelo));
        
        TProd.getTableHeader().setReorderingAllowed(false);
        TProd.getTableHeader().setResizingAllowed(false);
        
        TableColumn col = TProd.getColumnModel().getColumn(modelo.intColumna("Codigo"));
        col.setPreferredWidth(50);
        col = TProd.getColumnModel().getColumn(modelo.intColumna("Concepto"));
        col.setPreferredWidth(300);
        
        TProd.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "tab");
        TProd.getActionMap().put("tab", new accionTablaTab());
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0), "lateral");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0), "lateral");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0), "lateral");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0), "lateral");
        
        BAceptar.getActionMap().put("lateral", new accionBotonLateral());
        BCancela.getActionMap().put("lateral", new accionBotonLateral());
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BAceptar.getActionMap().put("enter", new accionBotonEnter(BAceptar));
        BCancela.getActionMap().put("enter", new accionBotonEnter(BCancela));
    }
    
    private void recuperaDatos(){
        try{
            String SQL = "SELECT ID, concepto "
                    + "FROM Productos_Servicios";
            modelo.setDatos(linker.consulta(SQL));
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
    }
    
    public boolean getSalvo(){
        return salvar;
    }
    
    public int getID(){
        int idx = TProd.convertRowIndexToModel(TProd.getSelectedRow());
        return modelo.getCodigo(idx);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TProd = new javax.swing.JTable();
        TBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda rapida");

        TProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Concepto"
            }
        ));
        TProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TProd);

        TBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TBuscarKeyReleased(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 25, 0));

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

        jLabel1.setText("Busqueda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBuscarKeyReleased
        sorter.setRowFilter(
                RowFilter.regexFilter(
                    "(?i)^" + TBuscar.getText()
                )
        );
    }//GEN-LAST:event_TBuscarKeyReleased

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        if(TProd.getSelectedRow() != -1){
            salvar = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Elige al menos un producto o servicio");
        }
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        salvar = false;
        dispose();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void TProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProdMouseClicked
        Point p = evt.getPoint();
        
        if(SwingUtilities.isRightMouseButton(evt))
            TProd.changeSelection(TProd.rowAtPoint(p), TProd.columnAtPoint(p), false, false);
        
        if(SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2)
            BAceptar.doClick();
    }//GEN-LAST:event_TProdMouseClicked

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
    
    private class accionTablaTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TProd.transferFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancela;
    private javax.swing.JTextField TBuscar;
    private javax.swing.JTable TProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    boolean                 salvar  = false;
    Conector                linker  ;
    modeloTablaConsumosLv2  modelo  = new modeloTablaConsumosLv2();
    TableRowSorter          sorter  ;
    upsy                    ouch    = new upsy("diagConsumosLv2");
}