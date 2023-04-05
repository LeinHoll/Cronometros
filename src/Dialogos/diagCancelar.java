package Dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class diagCancelar extends javax.swing.JDialog {

    public diagCancelar(java.awt.Frame parent, boolean modal, String maquina) {
        super(parent, modal);
        initComponents();
        misComponentes();
        setTitle("Cancelando " + maquina);
    }
    
    private void misComponentes(){
        TConcepto.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "skip");
        TConcepto.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "skip");
        
        TConcepto.getActionMap().put("skip", new textoSkip());
        
        BTerminar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BReanudar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BTerminar.getActionMap().put("enter", new botonEnter());
        BReanudar.getActionMap().put("enter", new botonEnter());
        
        BTerminar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flecha");
        BReanudar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flecha");
        
        BTerminar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flecha");
        BReanudar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flecha");
        
        BTerminar.getActionMap().put("flecha", new botonFlecha());
        BReanudar.getActionMap().put("flecha", new botonFlecha());
        
        
    }

    private void validaTexto(){
        if(TConcepto.getText().equals(""))
            BTerminar.setEnabled(false);
        else
            BTerminar.setEnabled(true);
    }
    
    public boolean getTerminar(){
        return terminar;
    }
    
    public String getConcepto(){
        if(TConcepto.getText().length() > 100)
            return TConcepto.getText().substring(0, 100);
        return TConcepto.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BEleccion = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConcepto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        BTerminar = new javax.swing.JButton();
        BReanudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Razon");

        BEleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "El cliente se retracto", "El cliente olvido algo en la maquina", "Me equivoque", "Otro (especifique)" }));
        BEleccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BEleccionItemStateChanged(evt);
            }
        });

        TConcepto.setColumns(20);
        TConcepto.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TConcepto.setLineWrap(true);
        TConcepto.setRows(5);
        TConcepto.setText("El cliente se retracto");
        TConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TConceptoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TConcepto);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BTerminar.setText("Terminar");
        BTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTerminarActionPerformed(evt);
            }
        });
        jPanel1.add(BTerminar);

        BReanudar.setText("Reanudar");
        BReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReanudarActionPerformed(evt);
            }
        });
        jPanel1.add(BReanudar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEleccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BEleccionItemStateChanged
        if(BEleccion.getSelectedItem().equals("Otro (especifique)")){
            TConcepto.setText("");
        } else {
            TConcepto.setText(BEleccion.getSelectedItem().toString());
        }
        validaTexto();
    }//GEN-LAST:event_BEleccionItemStateChanged

    private void TConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TConceptoKeyReleased
        validaTexto();
    }//GEN-LAST:event_TConceptoKeyReleased

    private void BReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReanudarActionPerformed
        terminar = false;
        dispose();
    }//GEN-LAST:event_BReanudarActionPerformed

    private void BTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTerminarActionPerformed
        terminar = true;
        dispose();
    }//GEN-LAST:event_BTerminarActionPerformed

    private class textoSkip extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            TConcepto.transferFocus();
        }
    }
    
    private class botonEnter extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BTerminar.isFocusOwner())
                BTerminar.doClick();
            else if(BReanudar.isFocusOwner())
                BReanudar.doClick();
        }
    }
    
    private class botonFlecha extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BTerminar.isFocusOwner())
                BReanudar.requestFocus();
            else if(BReanudar.isFocusOwner())
                BTerminar.requestFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox BEleccion;
    private javax.swing.JButton BReanudar;
    private javax.swing.JButton BTerminar;
    private javax.swing.JTextArea TConcepto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    boolean terminar = false;
}